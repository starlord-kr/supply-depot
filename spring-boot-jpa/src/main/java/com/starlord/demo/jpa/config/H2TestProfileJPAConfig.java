package com.starlord.demo.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.starlord.demo.jpa"
})
@EnableTransactionManagement
public class H2TestProfileJPAConfig {

    @Bean
    @Profile({"h2"})
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/testdb;DB_CLOSE_ON_EXIT=TRUE;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("testuser");
        dataSource.setPassword("testuser");

        return dataSource;
    }
}
