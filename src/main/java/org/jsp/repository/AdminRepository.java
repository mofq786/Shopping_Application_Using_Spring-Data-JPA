package org.jsp.repository;

import org.jsp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin readByAdminemailidAndAdminpassword(String email,String password);
	
}
