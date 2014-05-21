package com.martinetherton.ons.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.martinetherton.ons.persist.LocationRepository;

public class LocationServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    LocationRepository locationRepository;
    
    @Test
    public void cityForId0ShouldBeSheffield() {
        LocationService locationService = new LocationServiceImpl(locationRepository);
        Assert.assertThat(locationService.getLocation(0).getCity(), Matchers.is("Sheffield"));
    }
    
    @Test
    public void cityForId1ShouldBeLondon() {
        LocationService locationService = new LocationServiceImpl(locationRepository);
        Assert.assertThat(locationService.getLocation(1).getCity(), Matchers.is("London"));
    }    
}
