package com.martinetherton.ons.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration("classpath:/META-INF/springconfig/app-config.xml")
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class SurnameControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    @BeforeTransaction
    public void verifyDatabase() {
        
    }
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    @Rollback(true)
    public void insertSurname() {
        
    }
    
    @Test
    public void showSurnameDetailsPage() throws Exception {
        this.mockMvc.perform(get("/surnames/0").accept(MediaType.parseMediaType("text/html")))
                            .andExpect(status().isOk())
                            .andExpect(model().attributeExists("surnameDetails"));
        
    }
   
    
}
