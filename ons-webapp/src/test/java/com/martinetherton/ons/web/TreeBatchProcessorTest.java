package com.martinetherton.ons.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Tree;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
//@ContextConfiguration({"classpath:/META-INF/springconfig/app-config.xml","classpath:/META-INF/springconfig/app-persist-config.xml", "classpath:/META-INF/springconfig/jms-client-config.xml"})
@ContextConfiguration("classpath:/META-INF/springconfig/app-config.xml")
public class TreeBatchProcessorTest {

    @Autowired
    private TreeBatchProcessor treeBatchProcessor;

    @Autowired
    private TreeConfirmationLoggerImpl confirmationLogger;    
    
    @Test
    @Ignore
    public void testBatch() throws Exception {
        Tree tree1 = new Tree();
        tree1.setDescription("London Etherton tree");
        Tree tree2 = new Tree();
        tree2.setDescription("Sussex Etherton tree");
        Tree tree3 = new Tree();
        tree3.setDescription("Sussex 1 Etherton tree");
        Tree tree4 = new Tree();
        tree4.setDescription("Sussex 2 Etherton tree");
        Tree tree5 = new Tree();
        tree5.setDescription("Sussex 3 Etherton tree");
        List<Tree> batch = new ArrayList<Tree>();
        batch.add(tree1);    
        batch.add(tree2); 
        batch.add(tree3);  
        batch.add(tree4);        
        batch.add(tree5);        
        
        treeBatchProcessor.processBatch(batch);
        waitForBatch(batch.size(), 1000);
//System.out.println("batchsize is " + batch.size());
//System.out.println("confirm logger size is " + confirmationLogger.getConfirmations().size());
//System.out.println(confirmationLogger.getConfirmations());
        System.out.println("confirmationLogger" + confirmationLogger.getConfirmations());
        System.out.println("batch" + batch);
        Assert.assertEquals(batch.size(), confirmationLogger.getConfirmations().size());       
        
    }
    
    private void waitForBatch(int batchSize, int timeout) throws InterruptedException {
        int sleepTime = 100;
        while (confirmationLogger.getConfirmations().size() < batchSize && timeout > 0) {
            Thread.sleep(sleepTime);
            timeout -= sleepTime;
        }
    }    
    
}
