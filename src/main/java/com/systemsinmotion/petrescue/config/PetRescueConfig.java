import java.util.Properties;

import javax.sql.DataSource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "com.systemsinmotion.petrescue.data" })
@EnableTransactionManagement
@PropertySource("classpath:/shelter.properties")
public class PetRescueConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public static VelocityEngine velocityEngine() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
		velocityEngine.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		return velocityEngine;
	}

	@Bean
	public DataSource dataSource() {
		String driverClassName = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:hsql://localhost:9001?defaultSchema=gaar";
		String username = "sa";
		String password = "";

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.systemsinmotion.petrescue.entity");

		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");

		sessionFactory.setHibernateProperties(props);
		
		return sessionFactory();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> stash
