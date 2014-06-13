package com.martinetherton.ons.service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.persist.DeathRepository;
import com.martinetherton.ons.persist.DeathRepositoryImpl;

public class DeathServiceImplTest {

    private DeathRepository deathRepository;
    private DeathService deathService;

    @Before
    public void setUp() {
        deathRepository = mock(DeathRepositoryImpl.class);
        deathService = new DeathServiceImpl(deathRepository);        
    }
    
    @Test
    public void deathServiceImplContructor() {
        assertThat(deathService, Matchers.is(Matchers.notNullValue()));
    }    
    
    @Test
    public void totalNumberOfDeathsRetrieved() {
        deathService.getTotalNumberOfDeaths();
        verify(deathRepository).getTotalNumberOfDeaths();
    }
    
}
