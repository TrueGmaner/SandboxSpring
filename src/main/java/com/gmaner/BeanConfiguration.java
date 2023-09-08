package com.gmaner;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
public class BeanConfiguration {
    @Bean(name = "businessLogic")
    @Scope(scopeName = "singleton")
    public BusinessLogic getBusinessLogic() {
        return new BusinessLogic(1L, "German Kostya");
    }

    @Bean(name = "businessLogic2")
    @Scope(scopeName = "singleton")
    @Primary
    public BusinessLogic getBusinessLogic2() {
        return new BusinessLogic(2L, "Dragosh Sergey");
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/TestDB");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("Forgetmenot1!");
        hikariDataSource.setSchema("sandbox");
        hikariDataSource.setDriverClassName("org.postgresql.Driver");

        sessionFactory.setDataSource(hikariDataSource);
        Properties properties = new Properties();
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresPlusDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.generate_statistics", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("com.gmaner");
        return sessionFactory;
    }
}
