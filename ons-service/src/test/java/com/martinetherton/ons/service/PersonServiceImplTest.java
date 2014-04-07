package com.martinetherton.ons.service;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.persist.PersonRepository;
import com.martinetherton.ons.persist.PersonRepositoryImpl;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.PersonServiceImpl;

public class PersonServiceImplTest {

    @Test
    public void personServiceImplCreation() {
        PersonRepositoryImpl mockRepository = Mockito.mock(PersonRepositoryImpl.class);
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        PersonService personService = new PersonServiceImpl(mockRepository);
        Assert.assertNotNull(personService);
    }
    
}
