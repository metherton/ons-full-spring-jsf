package com.martinetherton.ons.model;



import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void personCreation() {
        Person person = new Person();
        Assert.assertNotNull(person);
    }
    
}
