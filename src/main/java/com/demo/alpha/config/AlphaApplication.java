package com.demo.alpha.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.demo.alpha")
@EnableTransactionManagement
@EnableJpaRepositories("com.demo.alpha.repository")
@EntityScan("com.demo.alpha.domen")
public class AlphaApplication extends SpringBootServletInitializer implements WebMvcConfigurer {


    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }
}
