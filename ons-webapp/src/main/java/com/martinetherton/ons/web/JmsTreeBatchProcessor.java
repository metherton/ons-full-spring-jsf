package com.martinetherton.ons.web;

import java.util.List;

import org.springframework.jms.core.JmsTemplate;

import com.martinetherton.ons.model.Tree;

public class JmsTreeBatchProcessor implements TreeBatchProcessor {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    @Override
    public void processBatch(List<Tree> batch) {
        for (Tree tree : batch) {
            jmsTemplate.convertAndSend(tree);
        }

    }

}
