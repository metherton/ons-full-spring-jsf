package com.martinetherton.ons.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinetherton.ons.persist.DeathRepository;

public class DeathServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    private DeathRepository deathRepository;

    @Test
    public void deadPersonShouldBeMartin() {
        DeathService deathService = new DeathServiceImpl(deathRepository);
        assertThat(deathService.getDeath(0).getPerson().getFirstName(), Matchers.is("Martin"));
    }
    
    @Test
    public void totalNumberOfDeathsIsReturned() {
        DeathService deathService = new DeathServiceImpl(deathRepository);
        assertThat(deathService.getTotalNumberOfDeaths(), is(1L));        
    }
    
}
