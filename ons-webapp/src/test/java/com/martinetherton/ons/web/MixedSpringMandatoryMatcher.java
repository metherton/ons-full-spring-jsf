package com.martinetherton.ons.web;

import org.mockito.ArgumentMatcher;

public class MixedSpringMandatoryMatcher extends ArgumentMatcher<MixedSpringMandatory> {

    public MixedSpringMandatoryMatcher(MixedSpringMandatory mandatory) {
        super();
        this.mandatory = mandatory;
    }

    private MixedSpringMandatory mandatory;

    @Override
    public boolean matches(Object other) {
        return ((MixedSpringMandatory) other).getName().equals(mandatory.getName());
    }

}
