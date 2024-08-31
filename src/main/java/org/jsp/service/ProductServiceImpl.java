package org.jsp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsp.DAO.ProductDAO;
import org.jsp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	Scanner scanner;
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public void addProducts() {
		
		System.out.println("Enter Product Brand");
		String brand = scanner.next();
		System.out.println("Enter No. Of Products");
		int noOfProducts = scanner.nextInt();
		
		List<Product> productList = new ArrayList<Product>();
		
		for(int i=1; i <= noOfProducts; i++)
		{
			System.out.println();
			Product product = new Product();
			System.out.println("Enter Product Name: ");
			product.setProductname(scanner.next());
			System.out.println("Enter Product Price: ");
			product.setPrice(scanner.nextDouble());
			System.out.println("Enter Product Quantity: ");
			product.setQuantity(scanner.nextInt());
			System.out.println("Enter Product Manufacture Date in YYYY-MM-DD: ");
			product.setMfdate(LocalDate.parse(scanner.next()));
			System.out.println("Enter Product Expiry Date in YYYY-MM-DD: ");
			product.setExdate(LocalDate.parse(scanner.next()));
			product.setBrand(brand);
			productList.add(product);
		}
		
		productDAO.saveAllProducts(productList);
		
		boolean status = true;
		while(status)
		{
			System.out.println("\nDo you want to Add More Products\n 1. YES\n 2. NO\n");
			String choice = scanner.next().toLowerCase();
			switch(choice)
			{
				case "yes":{
					addProducts();
				}
				case "no":{
					return;
				}
				default: System.err.println("Enter valid option");
			}
		}
		
		
	}

	@Override
	public void deleteProducts() {
		// TODO Auto-generated method stub
		
	}

}
