package types;

import java.util.ArrayList;
import java.util.Comparator;

import dao.CustomerDao;
import dao.ExchangeDao;
import dao.OrderDao;
import dao.ShareDao;
import daoInterface.CustomerDaoInterface;
import daoInterface.ExchangeDaoInterface;
import daoInterface.OrderDaoInterface;
import daoInterface.ShareDaoInterface;
import exception.NotEnoughShareException;
import exception.OrderIsDeclinedException;
import exception.OrderIsQueuedException;
import exception.UnknownUserIdException;
import logic.Sell;
import model.Customer;
import model.Exchange;
import model.Order;
import model.Share;

public class SellIOC extends Sell{

	@Override
	public String sell(Customer seller, Order sellOrder) throws OrderIsDeclinedException, OrderIsQueuedException, UnknownUserIdException, NotEnoughShareException {
		
		String response = "";

		OrderDaoInterface orders = OrderDao.getInstance();
		ShareDaoInterface shares = ShareDao.getInstance();
		ExchangeDaoInterface exchanges = ExchangeDao.getInstance();
		CustomerDaoInterface customers = CustomerDao.getInstance();
		
		String symbol = sellOrder.getSymbol();
		
		//orders.addOrder(sellOrder);
		
		if(!hasEnoughShare(seller, sellOrder)){
			sellOrder.declineOrder();
			throw new NotEnoughShareException();
		}
		
		ArrayList<Order> buyOrders = orders.getSymbolOrdersByOperation(symbol, "Buy", new Comparator<Order>() {
	        	@Override
	        	public int compare(Order o1, Order o2)
	        	{
	        		//return  (o2.getPrice()).compareTo(o1.getPrice());
	        		return  Integer.valueOf(o2.getPrice()).compareTo(Integer.valueOf(o1.getPrice()));
	        	}
	    	}
			, 0);
		
		int sellPrice = Integer.valueOf(sellOrder.getPrice());
		
		//check availability
		int presentQty = 0;
		for(Order buyOrder : buyOrders){
			int buyPrice = Integer.valueOf(buyOrder.getPrice());
			
			if(sellPrice < buyPrice){
				presentQty += buyOrder.getRemainingQuantity();
			}
		}
		if(presentQty < sellOrder.getInitQuantity()){
			//no enough share in buy queue
			sellOrder.declineOrder();
			returnShare(seller, sellOrder);
			throw new OrderIsDeclinedException();
		}
		
		//int sellPrice = Integer.valueOf(sellOrder.getPrice());
		for(Order buyOrder : buyOrders){
			
			if(sellOrder.getRemainingQuantity() <= 0){
				//sellOrder.setStatus(1);
				break;
			}
			
			int buyPrice = Integer.valueOf(buyOrder.getPrice());
			if(sellPrice < buyPrice){
				
				int sellQty = sellOrder.getRemainingQuantity();
				int buyQty  = buyOrder.getRemainingQuantity();
				int diff = sellQty - buyQty ;
				int exQty = 0 ; //exchange quantity
				int exPrc = buyPrice; //exchange price
				
				if(diff > 0){
					exQty = buyQty;
				}
				else{
					exQty = sellQty;
				}
				
				sellOrder.setRemainingQuantity(sellQty - exQty);
				buyOrder.setRemainingQuantity( buyQty  - exQty);
				
				Customer buyer = customers.getCustomerById(buyOrder.getUserId());
				Share newShare = new Share(buyer.getId(), symbol, exQty);
				shares.addShare(newShare);
				
				seller.deposit(exQty * exPrc);
				
				Exchange newEx = new Exchange(symbol, sellOrder.getPrice(), buyOrder.getPrice(), "IOC", sellOrder.getUserId(), buyOrder.getUserId(), exQty, 0);
				exchanges.addExchange(newEx);
				
				response += makeResponse(seller, buyer, exQty, exPrc, symbol);
	
			}
			else{
				break;
			}
		}
		
		orders.updateOrdersStatus();
		/*if(sellOrder.getStatus() == 0){
			System.err.println("------" + sellOrder.getSymbol() + "\t" + sellOrder.getRemainingQuantity() + "\t" + sellOrder.getInitQuantity());
			int a = shares.getCustomerShareBySymbol(sellOrder.getUserId(), sellOrder.getSymbol()).getQuantity();
			System.err.println("++++++");
			for(Order x : buyOrders){
				System.err.println(x.getPrice() + "\t" + x.getSymbol() + "\t" + x.getOperation() + "\t" + x.getInitQuantity() + "\t" + x.getRemainingQuantity());
			}
			for(int i=0 ; i<buyOrders.size() ; i++){
				System.err.println(buyOrders.get(i).getPrice());
			}
		}*/
		return response;
	}
	
	public boolean hasEnoughShare(Customer seller, Order sellOrder){
		Share x = ShareDao.getInstance().getCustomerShareBySymbol(seller.getId(), sellOrder.getSymbol());
		int requiredShare = sellOrder.getInitQuantity();
		
		if(x==null || x.getQuantity()<requiredShare)
			return false;
		
		//int qty = x.getQuantity();
		//x.setQuantity(qty - requiredShare);
		x.decreaseQuantity(requiredShare);
		return true;
	}
	
	public void returnShare(Customer seller, Order sellOrder){
		Share x = ShareDao.getInstance().getCustomerShareBySymbol(seller.getId(), sellOrder.getSymbol());
		int returnQty = sellOrder.getInitQuantity();
		//int currentQty =  x.getQuantity();
		//x.setQuantity(currentQty + returnQty);
		x.increaseQuantity(returnQty);
		
	}

}
