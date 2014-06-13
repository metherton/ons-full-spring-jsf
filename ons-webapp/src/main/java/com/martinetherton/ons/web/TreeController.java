package com.martinetherton.ons.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.martinetherton.ons.model.Tree;

public class TreeController {

    private TreeBatchProcessor treeBatchProcessor;
    
    public TreeController(TreeBatchProcessor batchProcessor) {
        this.treeBatchProcessor = treeBatchProcessor;
    }
    
    @RequestMapping(value="/trees/new", method=RequestMethod.GET)
    public void uploadTree() {
        Tree myTree = new Tree();
        myTree.setDescription("called by web request");
        List<Tree> treeList = new ArrayList<Tree>();
        treeList.add(myTree);
        System.out.println(treeBatchProcessor);
        treeBatchProcessor.processBatch(treeList);
    }
    
}
