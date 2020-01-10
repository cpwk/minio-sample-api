package com.mdtech.minio_sample.common.jpa;

import com.mdtech.minio_sample.common.reposiotry.BaseRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.mdtech.minio_sample", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@EnableTransactionManagement
@ComponentScan
public class JpaConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.jpa.show-sql}")
    private boolean show_sql;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(show_sql);
        //vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.mdtech.minio_sample");
        factory.setDataSource(dataSource);

        Map<String, Object> jpaProperties = new HashMap<String, Object>();
        jpaProperties.put("spring.jpa.hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        jpaProperties.put("hibernate.jdbc.batch_size", 50);
        jpaProperties.put("hibernate.show_sql", show_sql);
        jpaProperties.put("hibernate.enable_lazy_load_no_trans", true);

        factory.setJpaPropertyMap(jpaProperties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}