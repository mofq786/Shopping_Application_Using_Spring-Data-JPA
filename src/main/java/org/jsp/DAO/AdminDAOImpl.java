package org.jsp.DAO;

import org.jsp.entity.Admin;
import org.jsp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin getAdminDetails(String email, String passwrd) {
		
		Admin admin = adminRepo.readByAdminemailidAndAdminpassword(email, passwrd);
		return admin;
		
	}

}
