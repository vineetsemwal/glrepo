package org.globaltrainings.springjpademo;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource("app.properties")
@EnableTransactionManagement
@ComponentScan("org.globaltrainings.springjpademo")
@Configuration
public class JavaConfig {


    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.driverClass}")
    private String driverClass;

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("org.globaltrainings.springjpademo");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(orm());
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(databaseUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager(){
        PlatformTransactionManager transactionManager=new JpaTransactionManager();
        return transactionManager;
    }

    public Properties orm() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        // create, create-drop, validate, update
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        return properties;
    }



}
