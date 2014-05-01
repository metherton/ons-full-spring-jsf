package com.martinetherton.ons.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.persist.PersonRepositoryImpl;
import com.martinetherton.ons.persist.SurnameRepositoryImpl;

public class SurnameServiceImplTest {

    @Test
    public void surnameServiceImplCreation() {
        SurnameRepositoryImpl mockRepository = Mockito.mock(SurnameRepositoryImpl.class);
        SurnameService surnameService = new SurnameServiceImpl(mockRepository);
        Assert.assertNotNull(surnameService);        
    }
    
    
    
}
