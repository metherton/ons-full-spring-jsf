package com.martinetherton.ons.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import com.martinetherton.ons.model.Tree;
import com.martinetherton.ons.model.TreeConfirmation;

public interface TreeService {

    public TreeConfirmation handleTreeFor(Tree tree);

    public int getCount();
    
}
