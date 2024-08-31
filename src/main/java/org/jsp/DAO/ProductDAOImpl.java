package org.jsp.DAO;

import java.util.List;

import org.jsp.entity.Product;
import org.jsp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public List<Product> saveAllProducts(List<Product> productList) {
		
		return productRepo.saveAll(productList);
	}

}
