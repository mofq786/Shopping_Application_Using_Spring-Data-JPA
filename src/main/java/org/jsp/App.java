package org.jsp;

import java.util.Scanner;

import org.jsp.config.ShoppingConfig;
import org.jsp.service.AdminService;
import org.jsp.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        ApplicationContext context  = new AnnotationConfigApplicationContext(ShoppingConfig.class);
        CustomerService custService = context.getBean(CustomerService.class);
        AdminService adminService = context.getBean(AdminService.class);
        Scanner scan = context.getBean(Scanner.class);
        
        boolean status = true;
        
        sleep("*****Welcome to Qureshi's Shopping Application*****");
        
        while(status)
        {
        	System.out.println("\nEnter the Option to Perform the Below Operations."
        			+ "\n 1. Admin Login"
        			+ "\n 2. Customer Registration"
        			+ "\n 3. Customer Login"
        			+ "\n 4. Exit");
        	int choice = scan.nextInt();
        	
        	switch(choice)
        	{
        		case 1:{
        	
        			sleep("Admin Login Page");
        			sleep("Enter Your Details Below");
        			adminService.adminLogin();
        			
        		}
				break;
        		case 2:{
        			sleep("Customer Details");
        			System.out.println("\n To Register Enter Your Details Below");
        			custService.customerDetails();
        		}
				break;
        		case 3:{
        			
        			sleep("Customer Login");
        			custService.customerLogin();
        			
        		}
				break;
        		case 4:{
        			sleep("Exit");
        			status = false;
        		}
				break;
        		default: System.err.println("Enter Valid Choice Number");
        		break;
        	}
        	
        }
    }
    
    
    
    
    public static void sleep(String str)
    {
    	for(int i = 0; i < str.length(); i++)
    	{
    		System.out.print(str.charAt(i));
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	System.out.println();
    }
    
}
