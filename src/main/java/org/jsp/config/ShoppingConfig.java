package org.jsp.config;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@ComponentScan(basePackages = "org.jsp")
@EnableJpaRepositories("org.jsp.repository")
public class ShoppingConfig {
	
	@Bean(name="entityManagerFactory")
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("Shopping_Application");
		return bean;
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager jpaTransactionManagerBean(EntityManagerFactory emf)
	{
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);
		return manager;
	}
	
	@Bean
	public Scanner scannerBean()
	{
		return new Scanner(System.in);
	}
}
