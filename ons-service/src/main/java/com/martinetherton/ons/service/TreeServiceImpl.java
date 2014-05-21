package com.martinetherton.ons.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Tree;
import com.martinetherton.ons.model.TreeConfirmation;

public class TreeServiceImpl implements TreeService {

    private int count;

    @ManagedAttribute(description="the counter value")        
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    @Transactional
    public TreeConfirmation handleTreeFor(Tree tree) {
        System.out.println("Received:" + tree);
        TreeConfirmation confirmation = new TreeConfirmation();
        confirmation.setMessage(tree.getDescription());
        count++;
        return confirmation;
    }



}
