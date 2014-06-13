package com.martinetherton.ons.web;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.martinetherton.ons.model.Surname;

public class SurnameControllerTest {

    @Test
    public void surnameDetailsAddedToModel() {
        Model model = Mockito.mock(Model.class);
        Surname surname = new Surname();
        surname.setSurname("Etherton");
        
        
        
        SurnameController surnameController = new SurnameController();
        String viewName = surnameController.showLocationDetails(model);
        
        assertThat(viewName, Matchers.is("surnameDetails"));
        Mockito.verify(model).addAttribute("surnameDetails", surname);
    }
    
}
