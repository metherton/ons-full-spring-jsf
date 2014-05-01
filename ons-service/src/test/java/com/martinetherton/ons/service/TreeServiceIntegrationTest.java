package com.martinetherton.ons.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/springconfig/app-services-config.xml")
@ActiveProfiles("dev")
public class TreeServiceIntegrationTest {

    @Autowired
    private TreeService treeService;
    
    
    @Test
    public void ethertonLondonTreeContainsMoreThanOnePerson() {
        Assert.assertNotNull(treeService);
    }
    
}
