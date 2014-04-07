package com.martinetherton.ons.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.persist.LocationRepository;
import com.martinetherton.ons.persist.LocationRepositoryImpl;

public class LocationServiceImplTest {

    @Test
    public void locationServiceImplContructor() {
        LocationRepository locationRepository = Mockito.mock(LocationRepositoryImpl.class);
        LocationService locationService = new LocationServiceImpl(locationRepository);
        Assert.assertThat(locationService, Matchers.is(Matchers.notNullValue()));
    }
}
