package com.martinetherton.ons.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.martinetherton.ons.model.Surname;


public class SurnameServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    private SurnameService surnameService;
    
    @Test
    public void getSurname() {
        assertThat(surnameService.getSurname((long) 0).getSurname(), Matchers.is("Etherton"));
        assertThat(surnameService.getSurname((long) 0).getSurname(), Matchers.is("Etherton"));
    }
    
    @Test
    public void getSurnameByName() {
        assertThat(surnameService.getSurnameWithName("Etherton").getSurname(), Matchers.is("Etherton"));
        assertThat(surnameService.getSurnameWithName("Etherton").getSurname(), Matchers.is("Etherton"));
    } 
    
    @Test
    public void getAllSurnames() {
        assertThat(surnameService.getSurnames().size(), Matchers.greaterThan(0));
    }
    
    @Test
    public void insertSurname() {
        Surname newSurname = new Surname();
        newSurname.setSurname("SurnameToInsert");
        surnameService.add(newSurname);
        Surname insertedSurname = surnameService.getSurnameWithName("SurnameToInsert");
        assertThat(insertedSurname.getSurname(), is("SurnameToInsert"));
    }
    
    @Test
    @Ignore
    public void updateSurname() {
        Surname newSurname = new Surname();
        newSurname.setSurname("SurnameToChange");
        surnameService.add(newSurname);
        Surname insertedSurname = surnameService.getSurnameWithName("SurnameToChange");
        assertThat(insertedSurname.getSurname(), is("SurnameToChange"));
        insertedSurname.setSurname("changedSurname");
        surnameService.update(insertedSurname);
        Surname changedSurname = surnameService.getSurnameWithName("changedSurname");
        assertThat(changedSurname.getSurname(), is("changedSurname"));
    }
    
}
