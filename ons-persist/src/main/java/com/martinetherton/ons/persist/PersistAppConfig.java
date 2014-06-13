package com.martinetherton.ons.persist;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistAppConfig {

    @Autowired
    DataSource dataSource;
    
    public PersistAppConfig() {
        
    }
    
    public PersistAppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Bean
    public SurnameRepository surnameRepository() {
        SurnameRepository surnameRepository = new SurnameRepositoryImpl(dataSource);
        return surnameRepository;
    }
    
    
}
