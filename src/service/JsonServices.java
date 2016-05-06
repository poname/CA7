package service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import exception.UnknownUserIdException;

public class JsonServices {

	private static JsonServices instance;

	CustomerDaoInterface customers ;
	OrderDaoInterface orders;
	ShareDaoInterface shares;
	SymbolDaoInterface symbols;
	ExchangeDaoInterface exchanges;
	
	Gson gson ;
	
	public JsonServices(){
		
		customers = CustomerDao.getInstance();
		orders = OrderDao.getInstance();
		shares = ShareDao.getInstance();
		symbols = SymbolDao.getInstance();
		exchanges = ExchangeDao.getInstance();
		
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public static JsonServices getInstance(){
		if(instance == null)
			instance =new JsonServices();
		return instance;
	}

	public String getSymbolList(){
		return gson.toJson(symbols.getAllSymbols());
	}
	
	public String getSymbolInfoByName(String symbol){
		return gson.toJson(orders.getSymbolOrdersByName(symbol, 0));
	}
	
	public String getCustomerEconomicInfoById(String id){
		ArrayList<Object> info = new ArrayList<Object>();
		try {
			info.add(customers.getCustomerById(id));
		} catch (UnknownUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		info.add(orders.getCustomerOrdersById(id, 0));
		info.add(orders.getCustomerOrdersById(id, 1));
		info.add(orders.getCustomerOrdersById(id, -1));
		info.add(shares.getCustomerSharesById(id));
		
		return gson.toJson(info);
	}
	
	public String getCustomerCreditById(String id){
		try {
			return gson.toJson(customers.getCustomerById(id));
		} catch (UnknownUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String getCustomerActiveOrdersById(String id){
		return gson.toJson(orders.getCustomerOrdersById(id, 0));
	}
	
	public String getCustomerApprovedOrdersById(String id){
		return gson.toJson(orders.getCustomerOrdersById(id, 1));
	}
	
	public String getCustomerDeclinedOrdersById(String id){
		return gson.toJson(orders.getCustomerOrdersById(id, -1));
	}
	
	public String getCustomerSharesById(String id){
		return gson.toJson(shares.getCustomerSharesById(id));
	}
	
	public String getMarketInfo(){
		return gson.toJson(orders.getAllOrders(0));
	} 
}
