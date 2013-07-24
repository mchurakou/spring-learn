
package com.mikalai.mvc.test.config;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ImportResource("classpath:datasource-tx-jpa.xml")
@ComponentScan(basePackages={"com.mikalai.mvc.service"})
@Profile("test")
public class ServiceTestConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.build();
	}
	
	@Bean(name="databaseTester")
	public DataSourceDatabaseTester dataSourceDatabaseTester() {
		DataSourceDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource());
		return databaseTester;
	}
	
	@Bean(name="xlsDataFileLoader")
	public XlsDataFileLoader xlsDataFileLoader() {
		return new XlsDataFileLoader();
	}

}
