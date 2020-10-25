package match.game.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableJpaRepositories(basePackages= {"match.game.dao"})
@ComponentScan(basePackages={"match.game.service","match.game.service.impl","match.game","match.game.controller"})
@EnableWebMvc
@EnableTransactionManagement
@EntityScan(basePackages = {"match.game.entities"})
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		    //vendorAdapter.setGenerateDdl(true);

		    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		    factory.setEntityManagerFactoryInterface(EntityManagerFactory.class);
		    factory.setPersistenceUnitName("liga");
		    factory.setJpaVendorAdapter(vendorAdapter);
		    //factory.setPackagesToScan("com.acme.domain");
		   // factory.setDataSource(dataSource());
		    return factory;
	}
	@Bean
	   public PlatformTransactionManager transactionManager(){
	      JpaTransactionManager transactionManager
	        = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(
	        entityManagerFactory().getObject() );
	      return transactionManager;
	   }
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
}
