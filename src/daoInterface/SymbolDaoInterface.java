package daoInterface;

import java.util.ArrayList;

import exception.InvalidSymbolIdException;


public interface SymbolDaoInterface {
	//public abstract SymbolDaoInterface getInstance();
	public ArrayList<String> getAllSymbols();
	//public void updateSymbol(String Symbol);
	public void deleteSymbol(String Symbol);
	public void addSymbol(String Symbol);
	public String getSymbolByName(String symbol) throws InvalidSymbolIdException;
	public void log();
}
