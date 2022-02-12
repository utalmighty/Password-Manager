package com.PasswordManager.Spring.Config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc // Annotation Driven
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.PasswordManager.Spring")
public class SpringConfig {
	
	@Bean 
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean(name = "myDataSource")
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSrc = new ComboPooledDataSource();
		
		try {
			dataSrc.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSrc.setJdbcUrl("jdbc:mysql://localhost:3306/password_manager?useSSL=false&amp;serverTimezone=UTC");
		dataSrc.setUser("defeat_the_hunger");
		dataSrc.setPassword("defeat_the_hunger");
		dataSrc.setInitialPoolSize(5);
		dataSrc.setMinPoolSize(5);
		dataSrc.setMaxPoolSize(20);
		dataSrc.setMaxIdleTime(30000);
		
		return dataSrc;
	}
	
	@Bean(name= "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.PasswordManager.Spring.Entity");
		Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", true);
		sessionFactory.setHibernateProperties(properties);
		
		return sessionFactory;
	}
	
	@Bean(name = "myTransactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager transManager = new HibernateTransactionManager();
		transManager.setSessionFactory(s);
		return transManager;
	}
}
