package dao;

import java.util.ArrayList;
import model.Share;
import daoInterface.ShareDaoInterface;

public class ShareDao implements ShareDaoInterface{
	
	ArrayList<Share> shares;
	private static ShareDao instance;
	
	public ShareDao() {
		this.shares = new ArrayList<Share>();
	}
	
	public static ShareDaoInterface getInstance(){
		if(instance == null)
			instance = new ShareDao();
		return instance;
	}

	@Override
	public ArrayList<Share> getAllShares() {
		return shares;
	}

	@Override
	public ArrayList<Share> getSymbolSharesByName(String symbol){
		
		ArrayList<Share> symbolShares = new ArrayList<Share>();
		
		for(Share x : shares){
			if(x.getSymbol().equals(symbol))
				symbolShares.add(x);
		}
		
		return symbolShares;
	}

	@Override
	public ArrayList<Share> getCustomerSharesById(String id){
		
		ArrayList<Share> customerShares = new ArrayList<Share>();
		
		for(Share x : shares){
			if(x.getUserId().equals(id))
				customerShares.add(x);
		}

		return customerShares;
	}

	@Override
	public void updateShare(Share share) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShare(Share share) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addShare(Share share) {
		
		//share consistency
		//int currentQty ;
		//currentQty = consistency.get(share.getSymbol());
		/*if(share.getUserId().equals("1")){
			String symbol = share.getSymbol();
			int val = share.getQuantity();
			if(consistency.get(share.getSymbol()) != null){
				int currentQty = consistency.get(share.getSymbol());
				consistency.put(symbol, val+currentQty);
			}
			else{
				consistency.put(symbol, val);
			}
			System.out.println("%%%%%%%%%%\t" + consistency.size());
		}*/
		
		for(Share x : shares){
			if(x.getUserId().equals(share.getUserId()) && x.getSymbol().equals(share.getSymbol())){
				int quantity = x.getQuantity() ;
				x.setQuantity( quantity + share.getQuantity() );
				return ;
			}
		}
		
		//if not found  in shares
		shares.add(share);
	}
	
	public void log(){
		for(int i=0 ; i<shares.size() ; i++){
			Share s = shares.get(i);
			System.out.println(i + "\t" + s.getUserId() + '\t' + s.getSymbol() + '\t' + s.getQuantity());
		}
	}

	@Override
	public Share getCustomerShareBySymbol(String id, String symbol) {
		
		for(Share x : shares){
			if(x.getUserId().equals(id) && x.getSymbol().equals(symbol))
				return x;
		}
		return null;
	}

}
