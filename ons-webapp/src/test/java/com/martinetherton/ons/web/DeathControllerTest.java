package com.martinetherton.ons.web;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.martinetherton.ons.model.Death;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.service.DeathService;
import com.martinetherton.ons.service.DeathServiceImpl;

public class DeathControllerTest {

    private DeathController deathController;

    @Test
    public void deathDetailsAddedToModel() {
        Model model = mock(Model.class);
        Death death = new Death();
        Person person = new Person();
        person.setFirstName("Martin");
        death.setPerson(person);
        
        DeathService deathService = mock(DeathServiceImpl.class);
        when(deathService.getDeath(0)).thenReturn(death);
        when(deathService.getTotalNumberOfDeaths()).thenReturn(5L);
        
        deathController = new DeathController(deathService);
        String viewName = deathController.showDeathDetails(0, model);

        assertThat(viewName, is("deathDetails"));
        verify(model).addAttribute("deathDetails", death);
        verify(model).addAttribute("totalNumberOfDeaths", deathService.getTotalNumberOfDeaths());
    }
    
}
