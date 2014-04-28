package com.martinetherton.ons.web;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.PersonServiceImpl;

public class PersonControllerTest {

    @Test
    public void personDetailsHandler() {
        Model model = Mockito.mock(Model.class);
        PersonService personService = Mockito.mock(PersonServiceImpl.class);
        Person person = new Person();
        
        PersonController personController = new PersonController(personService);
        
        Mockito.when(personService.getPerson(1)).thenReturn(person);
        
        String viewName = personController.personDetails(1, model);
        Assert.assertEquals("personDetails", viewName);
        Mockito.verify(model).addAttribute("personDetails", person);
    }

}
