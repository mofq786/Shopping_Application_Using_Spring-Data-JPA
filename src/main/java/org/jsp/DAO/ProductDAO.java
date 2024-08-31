package org.jsp.DAO;

import java.util.List;

import org.jsp.entity.Product;

public interface ProductDAO {
	
	List<Product> saveAllProducts(List<Product> productList);

}
