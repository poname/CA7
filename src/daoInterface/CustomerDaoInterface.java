package daoInterface;

import java.util.ArrayList;

import exception.RepeatedIdException;
import exception.UnknownUserIdException;

import model.Customer;

public interface CustomerDaoInterface {
	//public CustomerDaoInterface getInstance();
	public ArrayList<Customer> getAllCustomers();
	public Customer getCustomerById(String id) throws UnknownUserIdException;
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void addCustomer(Customer customer) throws RepeatedIdException;
	public void log();

}
