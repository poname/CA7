package dao;

import java.util.ArrayList;

import daoInterface.SymbolDaoInterface;
import exception.InvalidSymbolIdException;

public class SymbolDao implements SymbolDaoInterface{
	
	ArrayList<String> symbols;
	private static SymbolDao instance;
	
	public SymbolDao() {
		this.symbols = new ArrayList<String>();
	}
	
	public static SymbolDaoInterface getInstance(){
		if(instance == null)
			instance = new SymbolDao();
		return instance;
	}

	@Override
	public ArrayList<String> getAllSymbols() {
		return symbols;
	}

	@Override
	public void deleteSymbol(String Symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSymbol(String symbol) {
		boolean found = false;
		for(String x : symbols){
			if(x.equals(symbol))
				found = true ;
		}
		if(!found)
			symbols.add(symbol);
	}

	@Override
	public String getSymbolByName(String symbol) throws InvalidSymbolIdException{
		for(String x : symbols){
			if(x.equals(symbol))
				return x ;
		}
		throw new InvalidSymbolIdException();
	}

	@Override
	public void log() {
		
	}

}
