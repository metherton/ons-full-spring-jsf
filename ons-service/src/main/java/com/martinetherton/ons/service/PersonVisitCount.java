package com.martinetherton.ons.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;

public interface PersonVisitCount {

     
    public int getCount();

    public void incrementCount();

    
}
