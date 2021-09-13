package com.service.openapi.trade.wtoapiservice.cofigurations;

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
@ConfigurationProperties(prefix = "datasource.wto")
@EnableJpaRepositories(
        basePackages = {"com.service.openapi.trade.wtoapiservice.repositories.wto"},
        transactionManagerRef = "transactionManagerWto",
        entityManagerFactoryRef = "entityManagerFactoryWto"
)
public class WtoDataSourceConfig extends HikariConfig {
    @Bean
    public PlatformTransactionManager transactionManagerWto() {
        return new JpaTransactionManager(this.entityManagerFactoryWto());
    }

    @Bean
    public DataSource dataSourceWto() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    @Bean
    public EntityManagerFactory entityManagerFactoryWto() {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(this.dataSourceWto());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        factoryBean.setJpaProperties(this.properties());
        factoryBean.setPackagesToScan("com.service.openapi.trade.wtoapiservice.entities.wto");
        factoryBean.setPersistenceUnitName("wto");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
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
