package de.mobile.moviedb.itest.config;

import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class ITestPersistenceConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        EmbeddedDatabaseFactoryBean factory = new EmbeddedDatabaseFactoryBean();
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        factory.setPersistenceProviderClass(HibernatePersistence.class);
        factory.setDataSource(getDataSource());
        factory.setJpaProperties(getJpaPropertiesFrom(factory.getJpaPropertyMap()));
        return factory;
    }

    private Properties getJpaPropertiesFrom(Map<String, Object> defaults) {
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }
}
