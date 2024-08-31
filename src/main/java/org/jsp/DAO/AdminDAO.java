package org.jsp.DAO;

import org.jsp.entity.Admin;

public interface AdminDAO {
	Admin getAdminDetails(String email,String passwrd);
}
