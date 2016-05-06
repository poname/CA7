package model;

public class Order {
	public static int cnt = 0;
	
	String symbol;
	String price;
	String type; //GTC, IOC, MPO, ...
	String userId;

	int remainingQuantity; //quantity left
	int initQuantity; //quantity at first
	String operation; // buy or sell
	int oid; // id in db
	int status;

	public Order(String symbol, String price, String type, String userId,int initQuantity, String operation, int oid) {

		this.symbol = symbol;
		this.price = price;
		this.type = type;
		this.userId = userId;
		this.initQuantity = initQuantity;
		this.remainingQuantity = initQuantity;
		this.operation = operation;
		this.oid = oid;
		this.status = 0;
		
		cnt++;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getRemainingQuantity() {
		return remainingQuantity;
	}
	
	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	
	public int getInitQuantity() {
		return initQuantity;
	}
	
	public void setInitQuantity(int initQuantity) {
		this.initQuantity = initQuantity;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void declineOrder() {
		status = -1;
	}
	
}
