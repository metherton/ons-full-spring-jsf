package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Tree;
import com.martinetherton.ons.model.TreeConfirmation;

public interface TreeService {

    public TreeConfirmation handleTreeFor(Tree tree);
    
}
