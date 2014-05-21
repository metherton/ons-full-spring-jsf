package com.martinetherton.ons.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.martinetherton.ons.model.Person;

public class PersonServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    PersonService personService;
    
    @Test
    public void getPerson() {
        Assert.assertThat(personService.getPerson(0).getFirstName(), Matchers.is("Martin"));
    }
    
    @Test
    public void insertPerson() {
        Person pToInsert = new Person();
        System.out.println("entityId is " + pToInsert.getEntityId());
        pToInsert.setFirstName("PToInsert");
        personService.addPerson(pToInsert);
        Person personInserted = personService.getPerson(pToInsert.getEntityId());
        Assert.assertThat(personInserted.getFirstName(), Matchers.is("PToInsert"));
    }
    
    @Test
    public void pointcutMethod() {
        personService.pointcut1();
        personService.pointcut2();
        personService.pointcutWithParam("Martin");
    }
    
    
}