package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Order;
import daoInterface.OrderDaoInterface;

public class OrderDao implements OrderDaoInterface{
	
	ArrayList<Order> orders;
	private static OrderDao instance;

	public OrderDao() {
		this.orders = new ArrayList<Order>() ;
	}
	
	public static OrderDaoInterface getInstance(){
		if(instance == null)
			instance = new OrderDao();
		return instance;
	}

	@Override
	public ArrayList<Order> getAllOrders(int status) {
		ArrayList<Order> statusOrders = new ArrayList<Order>();
		for(Order o : orders){
			if(o.getStatus() == status)
				statusOrders.add(o);
		}
		return statusOrders;
	}

	@Override
	public ArrayList<Order> getSymbolOrdersByName(String symbol, int status){
		
		ArrayList<Order> symbolOrders = new ArrayList<Order>();
		
		for(Order x : orders){
			if(x.getSymbol().equals(symbol) && x.getStatus()==status)
				symbolOrders.add(x);
		}
		
		return symbolOrders;
	}

	@Override
	public ArrayList<Order> getCustomerOrdersById(String id, int status){
		
		ArrayList<Order> customerOrders = new ArrayList<Order>();
		
		for(Order x : orders){
			if(x.getUserId().equals(id) && x.getStatus()==status)
				customerOrders.add(x);
		}

		return customerOrders;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public ArrayList<Order> getSymbolOrdersByOperation(String symbol, String operation, Comparator<Order> comparator, int status) {
		
		ArrayList<Order> soOrders = new ArrayList<Order>();
		
		for(Order x : orders){
			if(x.getSymbol().equals(symbol) && x.getOperation().equals(operation) && x.getStatus()==status)
				soOrders.add(x);
		}
		
		if(comparator != null){
			Collections.sort(soOrders, comparator);
			//System.err.println("sorted");
		}
		
		/*for(Order x : soOrders){
			System.err.print(x.getPrice() + "," + x.getRemainingQuantity() + " -> ");
		}
		System.err.println();*/
		return soOrders;
	}
	
	public void log(){
		for(int i=0 ; i<orders.size() ; i++){
			Order o = orders.get(i);
			System.out.println(i + "\t" + o.getSymbol() + '\t' + o.getInitQuantity() + '\t' + o.getRemainingQuantity() + '\t' + o.getUserId() + '\t' + o.getType() + '\t' + o.getOperation() + '\t' + o.getPrice() + "\t" + o.getStatus());
			if(o.getStatus()==0 && !o.getType().equals("GTC"))
				System.err.println(i);
		}
	}

	@Override
	public void updateOrdersStatus() {
		for(Order x : orders){
			if(x.getRemainingQuantity()<=0 && x.getStatus()==0)
				x.setStatus(1);
		}
	}

}
