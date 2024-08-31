package org.jsp.DAO;

import java.util.List;

import org.jsp.entity.Customer;

public interface CustomerDAO {
	Customer insertCustomerObject(Customer customer);
	List<Customer> getAllCustomerDetails();
	Customer getCustomerDetailsBasedOnEmailIdAndPassword(String emailId,String password);
}
