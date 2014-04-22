package com.martinetherton.ons.persist;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.martinetherton.ons.model.Surname;

public class SurnameRepositoryTest {

    private SurnameRepository repository;
    
    @Before
    public void setUp() {
        repository = new SurnameRepositoryImpl(createTestDataSource());
    }
    
    @Test
    public void findSurnameById() {
        Surname surname = repository.findBy(0);
        assertThat(surname.getSurname(), Matchers.is("Etherton"));
    }

    @Test
    public void findSurnameByName() {
        Surname surname = repository.findByName("Etherton");
        assertThat(surname.getSurname(), is("Etherton"));
    }
    
    @Test
    public void findAllSurnames() {
        List<Surname> surnames = repository.findAll();
        assertThat(surnames.size(), greaterThan(0));
    }
    
    @Test
    public void surnameCount() {
        assertThat(repository.getSurnameCount(), is(3));
    }
    
    @Test
    public void dumpSurnamesToFile() throws Exception {
        File file = new File("/Users/martin/surnames.txt");
        PrintWriter out = new PrintWriter(file);
        repository.generateSurnameFile(out);
        out.close();
    }
    
    @Test
    public void extractSurnameFromResultSet() {
        Surname surname = repository.findByNameFromResultSet("Etherton");
        assertThat(surname.getSurname(), is("Etherton"));        
    }
    
    @Test
    public void insertSurname() {
        Surname surname = new Surname();
        surname.setSurname("newSurname");
        repository.insert(surname);
        int insertId = repository.insert(surname);
        assertThat(insertId, greaterThan(0));
        insertId = repository.insert(surname);
        assertThat(insertId, greaterThan(0));
        assertThat(repository.getSurnameCount(), is(6));
    }
    
    @Test
    public void updateSurname() {
        Surname surname = new Surname();
        surname.setSurname("newSurname");
        repository.insert(surname);
        Surname changedSurname = new Surname();
        surname.setSurname("changedSurname");
        repository.update(surname);        
    }
    
    
    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
        .setName("ons")
        .addScript("classpath:/META-INF/db/schema.sql")
        .addScript("classpath:/META-INF/db/test-data.sql")
        .build();        
    }     
    
}
