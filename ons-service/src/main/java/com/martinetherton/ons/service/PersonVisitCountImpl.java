package com.martinetherton.ons.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

public class PersonVisitCountImpl implements PersonVisitCount {

    private int count;

    public PersonVisitCountImpl() {}
    
    @Override
    @ManagedAttribute(description="the counter value") 
    public int getCount() {
        return count;
    }

    @Override
    public void incrementCount() {
        count++;
    }

}
