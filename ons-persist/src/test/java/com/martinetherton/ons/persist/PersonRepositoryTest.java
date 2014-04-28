package com.martinetherton.ons.persist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.martinetherton.ons.model.Person;

public class PersonRepositoryTest {

    private PersonRepository repository;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    @Before
    public void setUpPersonRepository() {
        entityManagerFactory = createEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repository = new PersonRepositoryImpl();
        repository.setEntityManager(entityManager);        
    }
    
    @Test
    public void findPersonById() {
        long id = 0;
        Person person = repository.findBy(id);
        assertNotNull(person);
        assertThat(person.getFirstName(), is("Martin"));
    }

    @Test
    @Ignore
    public void findOldestPerson() {
        Person person = repository.findEarliestPerson();
        assertThat(person.getFirstName(), is("Samuel Original"));
    }
    
//    @Test
//    
//    public void insertPerson() {
//        Person newPerson = new Person();
//        newPerson.setFirstName("NewFirstName");
//        entityManager.
//        repository.add(newPerson);
//        long id = 2;
//        Person person = repository.findBy(id);
//        Assert.assertNotNull(person);
//        Assert.assertThat(person.getFirstName(), Matchers.is("NewFirstName"));
//    }
    
    @Test
    public void populatePersonCache() {
        repository.populateCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(2));
    }
    
    @Test
    public void clearCache() {
        repository.populateCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(2));
        repository.clearCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(0));
    }    
    
    private EntityManagerFactory createEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(createTestDataSource());
        
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.HSQL);
        jpaVendorAdapter.setShowSql(true);
        
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("hibernate.format_sql", "true");
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }    

    @After
    public void shutdownAccountRepository(){
        if(entityManager != null){
            entityManager.close();
        }
        
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
        
    
    /**
     * We are not using Spring in this unit test, so we have to setup our
     * embedded database manually.
     * 
     * @return The factory.
     */
    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
        .setName("ons")
        .addScript("classpath:/META-INF/db/schema.sql")
        .addScript("classpath:/META-INF/db/test-data.sql")
        .build();        
    }        
    
}
