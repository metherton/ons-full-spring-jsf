package com.martinetherton.ons.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.martinetherton.ons.model.TreeConfirmation;

public class TreeConfirmationLoggerImpl implements TreeConfirmationLogger {

    private List<TreeConfirmation> confirmations = new ArrayList<TreeConfirmation>();
    
    public void log(TreeConfirmation confirmation) {
        this.confirmations.add(confirmation);     
        System.out.println("received:" + confirmation);
        System.out.println("confirmations is now:" + this.confirmations);
    }
    
    public List<TreeConfirmation> getConfirmations() {
        System.out.println("called to getConfirmations");
        return Collections.unmodifiableList(confirmations);
    }    
    
}
