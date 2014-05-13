package com.martinetherton.ons.service;

import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Tree;
import com.martinetherton.ons.model.TreeConfirmation;

public class TreeServiceImpl implements TreeService {

    @Override
    @Transactional
    public TreeConfirmation handleTreeFor(Tree tree) {
        System.out.println("Received:" + tree);
        TreeConfirmation confirmation = new TreeConfirmation();
        confirmation.setMessage(tree.getDescription());
        return confirmation;
    }

}
