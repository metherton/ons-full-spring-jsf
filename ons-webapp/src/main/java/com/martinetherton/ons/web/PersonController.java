package com.martinetherton.ons.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.service.PersonService;


@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @ModelAttribute("handicappedOptions")
    public Map<Boolean, String> populateHandicapped() {
        Map<Boolean, String> handicappedOptions = new HashMap<Boolean, String>();
        handicappedOptions.put(Boolean.TRUE, "yes");
        handicappedOptions.put(Boolean.FALSE, "no");
        return handicappedOptions;
    }

    @RequestMapping("/persons/{id}")
    public String personDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("personDetails", personService.getPerson(id));
        return "personDetails";
    }
    
    @RequestMapping(value="/persons/new", method=RequestMethod.GET)
    public String setUpForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addPerson";
    }
    
    @RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String processSubmit(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        personService.addPerson(person);
        return "redirect:" + person.getEntityId();
    }    
    

}
