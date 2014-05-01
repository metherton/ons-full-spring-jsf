package com.martinetherton.ons.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MarriageTest {

    @Test
    public void testMarriageCreation() {
        Marriage marriage = new Marriage();
        Person person = new Person();
        person.setFirstName("man");
        Person partner = new Person();
        partner.setFirstName("woman");
        marriage.setPerson(person);
        marriage.setPartner(partner);
        assertThat(marriage, Matchers.notNullValue());
        assertThat(marriage.getPerson().getFirstName(), is("man"));
        assertThat(marriage.getPartner().getFirstName(), is("woman"));
    }
    
}
