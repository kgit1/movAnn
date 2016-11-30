package com.cMovieA.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//tell spring that it is java configuration
@Configuration
@EnableTransactionManagement
//tell spring where to scan for components
//can be missing if all our needed components here and
//all of them manually defined 
@ComponentScan("com.cmoviea.configutation")
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {
	
	@Autowired
	private Environment environment;
	
	// Setup Hibernate session factory
		// <bean id="sessionFactory"
		// class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
		// <property name="dataSource" ref="myDataSource" />
		// <property name="packagesToScan" value="com.cMovieA.entity" />
		// <property name="hibernateProperties">
		// <props>
		// <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
		// <prop key="hibernate.show_sql">true</prop>
		// </props>
		// </property>
		// </bean>
		//So LocalSessionFactoryBean's getObject() method returns 
		//a SessionFactory object.
	
	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource());
		sessionFactory.scanPackages("com.cMovieA.entity");
		sessionFactory.addProperties(hibernateProperties());
		return sessionFactory.buildSessionFactory();
	}
	private Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}
	
	
	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory(){
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(new String [] { "com.cMovieA.entity" });
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//	}
//	private Properties hibernateProperties(){
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect",
//				environment.getRequiredProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql",
//				environment.getRequiredProperty("hibernate.show_sql"));
//		properties.put("hibernate.format_sql",
//				environment.getRequiredProperty("hibernate.format_sql"));
//		return properties;
//	}
	
	// Define Database DataSource
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(
				environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource
				.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource
				.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}


	// <!-- Step 3: Setup Hibernate transaction manager -->
	// <bean id="myTransactionManager"
	// class="org.springframework.orm.hibernate5.HibernateTransactionManager">
	// <property name="sessionFactory" ref="sessionFactory"/>
	// </bean>
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

}
