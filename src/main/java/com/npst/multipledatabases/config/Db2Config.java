package com.npst.multipledatabases.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2entityManagerFactory",
        basePackages = { "com.npst.multipledatabases.repo.db2" },
        transactionManagerRef= "db2TransactionManager"
)
public class Db2Config {

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "db2entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.npst.multipledatabases.model.db2")
                .build();
    }

    @Primary
    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager db2transactionManager(
            @Qualifier("db2entityManagerFactory") EntityManagerFactory
                    db2entityManagerFactory) {
        return new JpaTransactionManager(db2entityManagerFactory);
    }
}
