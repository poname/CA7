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
import exception.NotEnoughCreditException;
import exception.OrderIsDeclinedException;
import exception.OrderIsQueuedException;
import exception.UnknownUserIdException;
import logic.Buy;
import model.Customer;
import model.Exchange;
import model.Order;
import model.Share;

public class BuyMPO extends Buy{

	@Override
	public String buy(Customer buyer, Order buyOrder) throws OrderIsDeclinedException, OrderIsQueuedException, UnknownUserIdException, NotEnoughCreditException {
		
		//call this later because we don't have needed credit
		//if(!hasEnoughCredit(buyer, buyOrder))
		//	throw new NotEnoughCreditException();
		String response = "";

		OrderDaoInterface orders = OrderDao.getInstance();
		ShareDaoInterface shares = ShareDao.getInstance();
		ExchangeDaoInterface exchanges = ExchangeDao.getInstance();
		CustomerDaoInterface customers = CustomerDao.getInstance();
		
		String symbol = buyOrder.getSymbol();
		
		//orders.addOrder(buyOrder);
		
		ArrayList<Order> sellOrders = orders.getSymbolOrdersByOperation(symbol, "Sell", new Comparator<Order>() {
	        	@Override
	        	public int compare(Order o1, Order o2)
	        	{
	        		//return  o1.getPrice().compareTo(o2.getPrice());
	        		return  Integer.valueOf(o1.getPrice()).compareTo(Integer.valueOf(o2.getPrice()));
	        	}
	    	}
			, 0);
		
		//int buyPrice = Integer.valueOf(buyOrder.getPrice());
		//check availability
		int presentQty = 0;
		int estimatedPrc = 0;
		int neededQty = buyOrder.getInitQuantity() ;
		//estimate needed quantity price
		for(Order sellOrder : sellOrders){
			//int sellPrice = Integer.valueOf(sellOrder.getPrice());
			int sellOrderRemainingQty = sellOrder.getRemainingQuantity();
			int sellOrderPrice = Integer.valueOf(sellOrder.getPrice());
			int diff = neededQty - sellOrderRemainingQty ;
			//if(sellPrice < buyPrice){
			if(neededQty<=0)
				break;
			
			if(diff > 0){
				estimatedPrc += sellOrderRemainingQty * sellOrderPrice ;
				neededQty -= sellOrderRemainingQty ;
			}
			else{
				estimatedPrc += neededQty * sellOrderPrice ;
				neededQty = 0;
			}
			
			presentQty += sellOrder.getRemainingQuantity();
			//}
		}
		//no enough share
		//if(neededQty > 0){
			
		//}
		//now we have estimated credit to check user
		if(!hasEnoughCredit(buyer, estimatedPrc)){
			buyOrder.declineOrder();
			throw new NotEnoughCreditException();
		}
			
		
		//check if there are enough quantity of share in queue
		if(presentQty < buyOrder.getInitQuantity()){
			//no enough share in buy queue
			buyOrder.declineOrder();
			returnCredit(buyer, estimatedPrc);
			throw new OrderIsDeclinedException();
		}
		
		//int buyPrice = Integer.valueOf(buyOrder.getPrice());
		for(Order sellOrder : sellOrders){
			
			if(buyOrder.getRemainingQuantity() <= 0){
				//buyOrder.setStatus(1);
				break;
			}
			
			int sellPrice = Integer.valueOf(sellOrder.getPrice());
			//if(sellPrice < buyPrice){
				
				int sellQty = sellOrder.getRemainingQuantity();
				int buyQty  = buyOrder.getRemainingQuantity();
				int diff = sellQty - buyQty ;
				int exQty = 0 ; //exchange quantity
				int exPrc = sellPrice; //exchange price --> important!
				
				if(diff > 0){
					exQty = buyQty;
				}
				else{
					exQty = sellQty;
				}
				
				sellOrder.setRemainingQuantity(sellQty - exQty);
				buyOrder.setRemainingQuantity( buyQty  - exQty);
				
				Customer seller = customers.getCustomerById(sellOrder.getUserId());
				
				Share newShare = new Share(buyer.getId(), symbol, exQty);
				shares.addShare(newShare);
				
				seller.deposit(exQty * exPrc);
				
				Exchange newEx = new Exchange(symbol, sellOrder.getPrice(), buyOrder.getPrice(), "GTC", sellOrder.getUserId(), buyOrder.getUserId(), exQty, 0);
				exchanges.addExchange(newEx);
				
				response += makeResponse(seller, buyer, exQty, exPrc, symbol);
				
				//if(sellOrder.getRemainingQuantity() <= 0){
				//	sellOrder.setStatus(1);
				//}
				
			//}
			//else{
			//	break;
			//}
		}
		
		orders.updateOrdersStatus();
		return response;
	}
	
	public boolean hasEnoughCredit(Customer buyer, int neededCredit){
		int currentCredit = buyer.getCredit();
		
		if(neededCredit > currentCredit)
			return false;
		
		buyer.decreaseCredit(neededCredit);
		return true;
	}
	
	public void returnCredit(Customer buyer, int returnCrdt){
		//int returnCrdt = Integer.valueOf(buyOrder.getPrice()) * buyOrder.getInitQuantity() ;
		buyer.deposit(returnCrdt);
	}

}
