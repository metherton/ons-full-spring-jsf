package com.martinetherton.ons.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinetherton.ons.model.Surname;

@Controller
public class SurnameController {

    @RequestMapping("/surnames/0")
    public String showLocationDetails(Model model) {
        Surname surname = new Surname();
        surname.setSurname("Etherton");
        model.addAttribute("surnameDetails", surname);
        return "surnameDetails";
    }



}
