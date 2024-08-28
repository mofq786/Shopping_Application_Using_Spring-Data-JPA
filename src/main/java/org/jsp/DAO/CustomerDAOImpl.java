package org.jsp.DAO;

import java.util.List;

import org.jsp.entity.Customer;
import org.jsp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired      
	CustomerRepository custRepo;

	@Override
	public Customer insertCustomerObject(Customer customer) {
		Customer customerObject = custRepo.save(customer);
		return customerObject;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		List<Customer> customerList = custRepo.findAll();
		return customerList;
	}

	@Override
	public void updateCustomerDetails(String address) {
		custRepo.deleteById(101);;
	}

}
