package logic;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Customer;
import model.Order;
import model.Share;
import dao.CustomerDao;
import dao.ExchangeDao;
import dao.OrderDao;
import dao.ShareDao;
import dao.SymbolDao;
import daoInterface.CustomerDaoInterface;
import daoInterface.ExchangeDaoInterface;
import daoInterface.OrderDaoInterface;
import daoInterface.ShareDaoInterface;
import daoInterface.SymbolDaoInterface;
import exception.*;

public class Core{

	private static Core instance;
	
	CustomerDaoInterface customers ;
	OrderDaoInterface orders;
	ShareDaoInterface shares;
	SymbolDaoInterface symbols;
	ExchangeDaoInterface exchanges;
	
	Map<String, Integer> consistency = new HashMap<String, Integer>();
	int totalSystemCredit = 0;
	
	int ref = 1000 ;
	public int getRef(){
		return ref++;
	}
	public Core(){
		
		customers = CustomerDao.getInstance();
		orders = OrderDao.getInstance();
		shares = ShareDao.getInstance();
		symbols = SymbolDao.getInstance();
		exchanges = ExchangeDao.getInstance();
		
		try {
			customers.addCustomer(new Customer("1", "admin", "adminian", 0));
		} catch (RepeatedIdException e) {
			e.printStackTrace();
		}
	}

	public static Core getInstance(){
		if(instance == null)
			instance = new Core();
		return instance;
	}
	
	public void customer_add(String id, String name, String family) throws RepeatedIdException, MismatchedParametersException{
		if(id==null || name==null || family==null || id.equals(""))
			throw new MismatchedParametersException();
		customers.addCustomer(new Customer(id, name, family, 0));
		//customers.print();
	}
	
	public void customer_deposit(String id, int amount) throws UnknownUserIdException, MismatchedParametersException{
		if(id==null /*|| amount==null*/ || id.equals(""))
			throw new MismatchedParametersException();
		//customers.depositById(id, amount);
		Customer user = customers.getCustomerById(id);
		user.setCredit( user.getCredit() + amount);
		totalSystemCredit += amount;
	}
	public void customer_withdraw(String id, int amount) throws UnknownUserIdException, NotEnoughCreditException, MismatchedParametersException{
		if(id==null /*|| amount==null*/ || id.equals(""))
			throw new MismatchedParametersException();
		Customer user = customers.getCustomerById(id);
		int currentCredit = user.getCredit();
		if(currentCredit < amount)
			throw new NotEnoughCreditException();
		user.setCredit( user.getCredit() - amount);
	}
	public String order_sell(String id, String instrument, String price, int quantity, String type) throws MismatchedParametersException, OrderIsQueuedException , UnknownUserIdException, InvalidOrderTypeException, NotEnoughShareException, InvalidSymbolIdException, OrderIsDeclinedException{

		if(id==null || instrument==null || price==null || type==null || id.equals("") || instrument.equals("") || price.equals("") || type.equals(""))
			throw new MismatchedParametersException();
		
		Customer user = customers.getCustomerById(id);
		Order sellOrder = new Order(instrument, price, type, id, quantity, "Sell", getRef());
		orders.addOrder(sellOrder);
		
		if(!user.isAdmin()){
			symbols.getSymbolByName(instrument);
		}
		else{
			symbols.addSymbol(instrument);
			
				//symbol's share consistency
				String symbol = instrument;
				int val = quantity;
				if(consistency.get(symbol) != null){
					int currentQty = consistency.get(symbol);
					consistency.put(symbol, val+currentQty);
				}
				else{
					consistency.put(symbol, val);
				}
				//System.out.println("%%%%%%%%%%\t" + consistency.get("RENA1"));
		}

		String response = "";
		try{
			Class clazz = Class.forName("types.Sell" + type);
			Sell sellRequest = (Sell)clazz.newInstance();
			response = sellRequest.sell(user, sellOrder);
		}catch(ClassNotFoundException ex){
			throw new InvalidOrderTypeException();
		}catch(InstantiationException | IllegalAccessException ex){
			ex.printStackTrace();
		}
		return response;
	}

	public String order_buy(String id, String instrument, String price, int quantity, String type) throws MismatchedParametersException, UnknownUserIdException, InvalidOrderTypeException, InvalidSymbolIdException, OrderIsDeclinedException, OrderIsQueuedException, NotEnoughCreditException{
		if(id==null || instrument==null || price==null || type==null || id.equals("") || instrument.equals("") || price.equals("") || type.equals(""))
			throw new MismatchedParametersException();
		Customer user = customers.getCustomerById(id);
		Order buyOrder = new Order(instrument, price, type, id, quantity, "Buy", getRef());
		orders.addOrder(buyOrder);
		
		String response = "";
		try{
			Class clazz = Class.forName("types.Buy" + type);
			Buy buyRequest = (Buy)clazz.newInstance();
			response = buyRequest.buy(user, buyOrder);
		}catch(ClassNotFoundException ex){
			throw new InvalidOrderTypeException();
		}catch(InstantiationException | IllegalAccessException ex){
			ex.printStackTrace();
		}
		return response;
	}

	public String makeResponse(Customer seller, Customer buyer, int quantity, int price, String namad){
		return seller.getId() + " sold " + quantity + " shares of " + namad + " @" + price + " to " + buyer.getId() + "\n" ;
	}
	public void prt(int i){
		System.out.println(i);
	}
	public void log(){
		System.out.println("*------------------ Welcome to Log ------------------*");
		customers.log();
		System.out.println("............Orders.....");
		orders.log();
		System.out.println("............Shares.....");
		shares.log();
		System.out.println("............Exchanges..");
		exchanges.log();
		System.out.println("------------------------------------------------------");
	}
	public void check(){
		int totalCrdt = 0;
		int totalShare = 0;
		for(Customer c : customers.getAllCustomers()){
			totalCrdt += c.getCredit();
		}
		for(Order o : orders.getAllOrders(0)){
			if(o.getOperation().equals("Buy")){
				totalCrdt += o.getRemainingQuantity() * Integer.valueOf(o.getPrice()) ;
			}
			else{
				totalShare += o.getRemainingQuantity() ;
			}
		}
		for(Share s : shares.getAllShares()){
			totalShare += s.getQuantity();
		}
		
		int totalSystemShare = 0;
		for(Map.Entry<String, Integer> e : consistency.entrySet()){
			totalSystemShare += e.getValue();
			System.out.println("==" + e.getKey() + "==" + e.getValue());
		}
		
		System.out.println("Credit: " + totalSystemCredit + "\t" +  totalCrdt );
		System.out.println("Share: " + totalSystemShare + "\t" +  totalShare );
		System.out.println(":::: " + model.Order.cnt);
		
		for(Order o : orders.getAllOrders(0)){
			if(!o.getType().equals("GTC"))
				System.err.println("status error");
		}
	}
}