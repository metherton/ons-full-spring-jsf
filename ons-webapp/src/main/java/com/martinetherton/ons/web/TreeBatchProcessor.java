package com.martinetherton.ons.web;

import java.util.List;

import com.martinetherton.ons.model.Tree;

public interface TreeBatchProcessor {

    void processBatch(List<Tree> batch);
    
}
