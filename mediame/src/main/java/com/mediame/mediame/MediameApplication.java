package com.mediame.mediame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.mediame.mediame.utility.DBConnectionTest;

@SpringBootApplication
//@ComponentScan(basePackages = "com.mediame.mediame")
//@EnableJpaRepositories(basePackages = "com.mediame.mediame.repository")
//@AutoConfiguration(after = { DataSourceAutoConfiguration.class })
//@ConditionalOnClass({ LocalContainerEntityManagerFactoryBean.class, EntityManager.class, SessionImplementor.class })
@EnableConfigurationProperties(JpaProperties.class)
//@Import(HibernateJpaConfiguration.class)
public class MediameApplication {
	
	public static Logger LOGGER = LoggerFactory.getLogger(MediameApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MediameApplication.class, args);
		
		LOGGER.info("Starting MediameApplication App ...");
		
		DBConnectionTest testDB = new DBConnectionTest();
		testDB.testDB();
	}

}
