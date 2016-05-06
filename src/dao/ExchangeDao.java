package dao;

import java.util.ArrayList;

import model.Exchange;
import daoInterface.ExchangeDaoInterface;

public class ExchangeDao implements ExchangeDaoInterface{
	
	ArrayList<Exchange> exchanges;
	private static ExchangeDao instance;
	
	public ExchangeDao() {
		super();
		this.exchanges = new ArrayList<Exchange>() ;
	}
	
	public static ExchangeDaoInterface getInstance(){
		if(instance == null)
			instance = new ExchangeDao();
		return instance;
	}

	@Override
	public ArrayList<Exchange> getAllExchanges() {
		return exchanges;
	}

	@Override
	public ArrayList<Exchange> getSymbolExchangesByName(String symbol) {
		
		ArrayList<Exchange> symbolExchanges = new ArrayList<Exchange>();
		
		for(Exchange x : exchanges){
			if(x.getSymbol().equals(symbol))
				symbolExchanges.add(x);
		}
		
		return symbolExchanges;
	}

	@Override
	public ArrayList<Exchange> getCustomerExchangesById(String id) {
		
		ArrayList<Exchange> customerExchanges = new ArrayList<Exchange>();
		
		for(Exchange x : exchanges){
			if(x.getSellerId().equals(id) || x.getBuyerId().equals(id))
				customerExchanges.add(x);
		}

		return customerExchanges;
	}

	@Override
	public void updateExchange(Exchange exchange) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExchange(Exchange exchange) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExchange(Exchange exchange) {
		exchanges.add(exchange);
	}
	
	public void log(){
		for(int i=0 ; i<exchanges.size() ; i++){
			Exchange ex = exchanges.get(i);
			System.out.println(i + "\t" + ex.getSymbol() + '\t' + ex.getQuantity() + '\t' + ex.getBuyerId() + '\t' + ex.getBuyPrice() + '\t' + ex.getSellerId() + '\t' + ex.getSellPrice());
		}
	}

}
