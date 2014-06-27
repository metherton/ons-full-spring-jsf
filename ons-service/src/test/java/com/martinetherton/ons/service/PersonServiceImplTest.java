package com.martinetherton.ons.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.persist.PersonRepositoryImpl;

public class PersonServiceImplTest {

    @Test
    public void personServiceImplCreation() {
        PersonRepositoryImpl mockRepository = Mockito.mock(PersonRepositoryImpl.class);
        PersonService personService = new PersonServiceImpl(mockRepository, null);
        Assert.assertNotNull(personService);
    }
    
//    @Test
//    public void person
    
}
