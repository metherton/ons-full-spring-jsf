package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import com.martinetherton.ons.model.Location;

public class LocationTest {

    @Test
    public void locationConstructor() {
        Location location = new Location("Sheffield");
        location.setPostCode("S17");
        Assert.assertThat("Sheffield", Matchers.is(location.getCity()));
        Assert.assertThat("S17", Matchers.is(location.getPostCode()));
    }
    
}
