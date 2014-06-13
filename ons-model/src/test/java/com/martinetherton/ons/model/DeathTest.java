package com.martinetherton.ons.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DeathTest {

    @Test
    public void testDeathCreation() {
        Death death = new Death();
        Date dateOfDeath = new Date();
        death.setDateOfDeath(dateOfDeath);
        Person person = new Person();
        person.setFirstName("John");
        death.setPerson(person);
        Location location = new Location();
        location.setPostCode("N1");
        death.setLocation(location);
        assertThat(death.getPerson().getFirstName(), is("John"));
        assertThat(death.getLocation().getPostCode(), is("N1"));
        assertThat(death.getDateOfDeath(), is(dateOfDeath));
    }
    
}
