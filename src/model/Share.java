package model;

public class Share {

	String userId;
	String symbol;
	int quantity;
	
	public Share(String userId, String symbol, int quantity) {
		super();
		this.userId = userId;
		this.symbol = symbol;
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void increaseQuantity(int amount){
		quantity += amount;
	}
	
	public void decreaseQuantity(int amount){
		quantity -= amount;
	}

}
