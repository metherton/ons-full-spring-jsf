package com.martinetherton.ons.persist;

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
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Marriage;

public class MarriageRepositoryTest {

    MarriageRepository repository;
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    
    @Before
    public void setUp() {
        entityManagerFactory = createEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repository = new MarriageRepositoryImpl();
        repository.setEntityManager(entityManager);         
    }
       
    
    @Test
    public void findMarriageById() {
        Marriage marriage = repository.findBy(0);
        assertThat(marriage.getEntityId(), Matchers.is(0L));
        assertThat(marriage.getPerson().getEntityId(), Matchers.is(0L));
        assertThat(marriage.getPartner().getEntityId(), Matchers.is(4L));
        
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
