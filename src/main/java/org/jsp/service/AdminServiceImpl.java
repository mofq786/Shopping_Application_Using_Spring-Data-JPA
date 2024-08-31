package org.jsp.service;

import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.DAO.AdminDAO;
import org.jsp.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	Scanner scanner;
	
	@Autowired
	ProductService prodService;
	
	@Autowired
	AdminDAO adminDAO;

	@Override
	public void adminLogin() {
		
		System.out.println("Enter your Email: ");
		String email = scanner.next();
		System.out.println("Enter your Password: ");
		String password = scanner.next();
		
		Admin admin = adminDAO.getAdminDetails(email, password);
		
		if(admin!=null)
		{
			boolean status = true;
			
			while(status)
			{
				System.out.println("Enter\n 1. To Add Products\n 2. To Delete Product\n 3. To Exit\n");
				switch(scanner.nextInt())
				{
					case 1:{
						
						prodService.addProducts();
						
					}
					break;
					case 2:{
						
					}
					break;
					case 3:{
						status = false;
						System.out.println("Exited Successfully");
					}
					break;
					
					default: System.out.println("Enter Valid Option");
				
				}
			}
		}
		else
		{
			System.out.println("Invalid Credentials");
		}
	}
	
	private LocalDate stringToDateConverter(String str)
	{
		int date = Integer.parseInt(str.substring(0,2));
		int month = Integer.parseInt(str.substring(3,5));
		int year = Integer.parseInt(str.substring(6,10));
		
		return LocalDate.of(year, month, date);
	}

}
