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
	public void customerDetails() {
		
		List<Customer> customerList = customerDAO.getAllCustomerDetails();
		
		Customer customer = new Customer();
		System.out.println("Enter Your First Name: ");
		customer.setFirstname(scanner.next());
		System.out.println("Enter Your Last Name: ");
		customer.setLastname(scanner.next());
		System.out.println("Enter Your Email Id: ");
		String emailId = scanner.next();
		
		boolean status = true;
		
		outer: while(status)
		{
			status = false;
			for (Customer customers : customerList) {
				if(customers.getEmailid().equalsIgnoreCase(emailId))
				{
					System.err.println("Email Already Exists");
					System.out.println("Enter Other Email Id: ");
					emailId = scanner.next();
					status = true;
					continue outer;
				}
				
			}
			
			customer.setEmailid(emailId);
			
		}
			
		System.out.println("Enter Password: ");
		String password = scanner.next();
		boolean passStatus = true;
		
		outer: while(passStatus)
		{
			passStatus = false;
			for (Customer customer2 : customerList) {
				if(customer2.getPassword().equalsIgnoreCase(password))
				{
					System.err.println("Password already exists");
					System.out.println("Enter Other Password: ");
					password = scanner.next();
					passStatus = true;
					continue outer;
				}
			}
			
			customer.setPassword(password);
			
		}
		
		System.out.println("Enter Mobile Number: ");
		Long mobile = scanner.nextLong();
		boolean mobileStatus = true;
		
		outer: while(mobileStatus)
		{
			mobileStatus = false;
			for (Customer customer2 : customerList) {
				
				if(customer2.getMobilenumbe()==mobile)
				{
					System.err.println("Mobile Number is Already in Use");
					System.out.println("Enter Other Mobile Number: ");
					mobile = scanner.nextLong();
					mobileStatus = true;
					continue outer;
				}
				
			}
			customer.setMobilenumbe(mobile);
		}
		
		System.out.println("Enter Your Gender");
		customer.setGender(scanner.next());
		System.out.println("Enter Your Address");
		customer.setAddress(scanner.next());
					
		Customer customerObject = customerDAO.insertCustomerObject(customer);
					
		if(customerObject.getCustomerid()!=0)
		{
			System.out.println("Registration Successful... With the Id: "+customerObject.getCustomerid());
		}
		else {
			System.out.println("Server 404");
		}
	}
	

	@Override
	public void customerLogin() {
		
		
		System.out.println("To Login Enter Your Details");
		System.out.println("Enter Your EmailId: ");
		String emailId = scanner.next();
		System.out.println("Enter Your Password: ");
		String password = scanner.next();
		
		Customer customer = customerDAO.getCustomerDetailsBasedOnEmailIdAndPassword(emailId, password);
		
		if(customer!=null)
		{
			System.out.println("=== Welcome "+customer.getFirstname()+" To Our Application"
					+"\n 1. For Product Details\n 2. For Cart Details\n 3. For Order Details");
			
			switch(scanner.nextInt())
			{
				case 1: {
					System.out.println("Product Details");
				}
				break;
				case 2: {
					System.out.println("Cart Details");
				}
				break;
				case 3:{
					System.out.println("Order Details");
				}
				break;
				case 4:{
					System.out.println("Exit");
				}
				break;
				default: System.out.println("Invalid Option Number");
			}
		}
		else {
			System.out.println("Invalid Credentials");
		}
		
	}

}
