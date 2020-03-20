package com.demo.alpha.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

;

@SpringBootApplication
@ComponentScan("com.demo.alpha")
public class AlphaApplication {


    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        Resource initSchema = new ClassPathResource("schema-h2.sql");
        //Resource initData = new ClassPathResource("scripts/data-h2.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
        //DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);

        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }
}
