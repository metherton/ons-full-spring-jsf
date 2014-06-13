package com.martinetherton.ons.web;

import java.util.Collections;
import java.util.List;

import com.martinetherton.ons.model.TreeConfirmation;

public interface TreeConfirmationLogger {

    public void log(TreeConfirmation confirmation);
    
    public List<TreeConfirmation> getConfirmations();
    
}
