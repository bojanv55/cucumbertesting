package me.vukas;

import javax.sql.DataSource;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@TestConfiguration
public class TestProgramConfig {

	@Primary
	@Bean
	public DataSource dataSource(){
		return DataSourceBuilder.create()
				.url("jdbc:mysql://10.10.121.137:3306/crawled")
				.username("root")
				.password("123456")
				.build();
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setAddresses("10.10.121.137:5672");
		factory.setUsername("root");
		factory.setPassword("123456");
		factory.setVirtualHost("/");
		return factory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setMaxConcurrentConsumers(5);
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public AmqpAdmin rabbitAdmin(){
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan("me.vukas");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		return entityManager;
	}

}
