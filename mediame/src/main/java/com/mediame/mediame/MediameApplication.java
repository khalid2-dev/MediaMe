package com.mediame.mediame;

import jakarta.persistence.EntityManager;

import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mediame.mediame.utility.DBConnectionTest;

@SpringBootApplication
//@ComponentScan(basePackages = "com.mediame.mediame")
//@EnableJpaRepositories(basePackages = "com.mediame.mediame.repository")
//@AutoConfiguration(after = { DataSourceAutoConfiguration.class })
//@ConditionalOnClass({ LocalContainerEntityManagerFactoryBean.class, EntityManager.class, SessionImplementor.class })
@EnableConfigurationProperties(JpaProperties.class)
//@Import(HibernateJpaConfiguration.class)
public class MediameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediameApplication.class, args);
		
		DBConnectionTest testDB = new DBConnectionTest();
		testDB.testDB();
	}

}
