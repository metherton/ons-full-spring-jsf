package com.martinetherton.ons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinetherton.ons.model.Death;
import com.martinetherton.ons.service.DeathService;

@Controller
public class DeathController {

    private DeathService deathService;

    @Autowired
    public DeathController(DeathService deathService) {
        this.deathService = deathService;
    }

    @RequestMapping("/deaths/{id}")
    public String showDeathDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("deathDetails", deathService.getDeath(id));
        model.addAttribute("totalNumberOfDeaths", 5);
        return "deathDetails";
    }

}
