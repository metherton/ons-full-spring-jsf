package com.martinetherton.ons.persist;

import javax.sql.DataSource;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.martinetherton.ons.model.Surname;

public class SurnameRepositoryTest {

    private SurnameRepositoryImpl repository;
    
    @Before
    public void setUp() {
        repository = new SurnameRepositoryImpl(createTestDataSource());
    }
    
    @Test
    public void findSurnameById() {
        Surname surname = repository.findBy(0);
        Assert.assertThat(surname.getSurname(), Matchers.is("Etherton"));
    }

    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
        .setName("ons")
        .addScript("classpath:/META-INF/db/schema.sql")
        .addScript("classpath:/META-INF/db/test-data.sql")
        .build();        
    }     
    
}
