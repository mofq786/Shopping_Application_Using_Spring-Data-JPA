package org.jsp.service;

import java.util.List;
import java.util.Scanner;

import org.jsp.DAO.CustomerDAO;
import org.jsp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	Scanner scanner;
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public boolean customerDetails() {
		
		List<Customer> customerList = customerDAO.getAllCustomerDetails();
		
		Customer customer = new Customer();
		System.out.println("Enter Your First Name: ");
		customer.setFirstname(scanner.next());
		System.out.println("Enter Your Last Name: ");
		customer.setLastname(scanner.next());
		System.out.println("Enter Your Email Id: ");
		String emailId = scanner.next();
		
		boolean status = false;
		for (Customer customers : customerList) {
			if(customers.getEmailid().equalsIgnoreCase(emailId))
			{
				status = true;
				break;
			}
		}
		
		if(status)
		{
			System.err.println("Email Already Exists");
			return false;
		}
		else
		{
			customer.setEmailid(emailId);
			System.out.println("Enter Password: ");
			String password = scanner.next();
			
			boolean passStatus = false;
			for (Customer customer2 : customerList) {
				if(customer2.getPassword().equalsIgnoreCase(password))
				{
					passStatus = true;
					break;
				}
			}
			
			if(passStatus)
			{
				System.err.println("Password already exists");
				return false;
			}
			else {
				customer.setPassword(password);
				System.out.println("Enter Mobile Number: ");
				Long mobile = scanner.nextLong();
				boolean mobileStatus = false;
				
				for (Customer customer2 : customerList) {
					
					if(customer2.getMobilenumbe()==mobile)
					{
						mobileStatus = true;
					}
					
				}
				
				if(mobileStatus)
				{
					System.err.println("Mobile Number is Already in Use");
					return false;
				}
				else {
					customer.setMobilenumbe(mobile);
					System.out.println("Enter Your Gender");
					customer.setGender(scanner.next());
					System.out.println("Enter Your Address");
					customer.setAddress(scanner.next());
					
					Customer customerObject = customerDAO.insertCustomerObject(customer);
					
					if(customerObject.getCustomerid()!=0)
					{
						System.out.println("Registration Successful... With the Id: "+customerObject.getCustomerid());
						return true;
					}
					else {
						System.out.println("Server 404");
						return false;
					}
				}
				
			}
		}
		
		
		
		
		
	}

}
