package dao;

import java.util.ArrayList;

import model.Customer;
import daoInterface.CustomerDaoInterface;
import exception.RepeatedIdException;
import exception.UnknownUserIdException;

public class CustomerDao implements CustomerDaoInterface{
	
	ArrayList<Customer> customers;
	private static CustomerDao instance;
	
	public CustomerDao() {
		this.customers = new ArrayList<Customer>();
	}

	public static CustomerDaoInterface getInstance(){
		if(instance == null)
			instance = new CustomerDao();
		return instance;
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public Customer getCustomerById(String id) throws UnknownUserIdException {
		for(Customer x : customers){
			if(x.getId().equals(id))
				return x;
		}
		System.out.print("++++++++++++++++" + customers.size());
		throw new UnknownUserIdException();
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomer(Customer customer) throws RepeatedIdException {
		
		for(Customer x : customers){
			if(x.getId().equals(customer.getId()))
				throw new RepeatedIdException();
		}
		
		customers.add(customer);
	}
	
	public void log(){
		for(int i=0 ; i<customers.size() ; i++){
			Customer cs = customers.get(i);
			System.out.println(i + "\t" + cs.getId() + '\t' + cs.getCredit());
		}
	}

}
