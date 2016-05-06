package model;

public class Customer {
	
	String id, name, family ;
	int credit ;
	//int cid; //used as database index
	
	public Customer(String id, String name, String family, int credit) {
		//super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.credit = credit;
	}
	
	public void deposit(int amount){
		credit += amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public boolean isAdmin(){
		return (id.equals("1")) ;
	}

	public void decreaseCredit(int amount) {
		// TODO Auto-generated method stub
		credit -= amount;
	}

}
