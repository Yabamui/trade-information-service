package com.service.openapi.trade.apiservice.cofigurations;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ConfigurationProperties(prefix = "datasource.information")
@EnableJpaRepositories(
        basePackages = {"com.service.openapi.trade.apiservice.repositories.information"},
        transactionManagerRef = "transactionManagerInformation",
        entityManagerFactoryRef = "entityManagerFactoryInformation"
)
public class InformationDataSourceConfig extends HikariConfig {
    @Bean
    public PlatformTransactionManager transactionManagerInformation() {
        return new JpaTransactionManager(this.entityManagerFactoryInformation());
    }

    @Bean
    public EntityManagerFactory entityManagerFactoryInformation() {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(this.dataSourceInformation());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        factoryBean.setJpaProperties(this.properties());
        factoryBean.setPackagesToScan("com.service.openapi.trade.apiservice.entities.information");
        factoryBean.setPersistenceUnitName("information");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSourceInformation() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    private Properties properties() {
        final Properties properties = new Properties();
        properties.put("hibernate.hdm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");

        return properties;
    }

    private Map<String, String> getProperties() {
        final HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.hdm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");

        return properties;
    }
}
