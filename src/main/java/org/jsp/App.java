package org.jsp;

import org.jsp.DAO.CustomerDAO;
import org.jsp.config.ShoppingConfig;
import org.jsp.entity.Customer;
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
        custService.customerDetails();
    }
}
