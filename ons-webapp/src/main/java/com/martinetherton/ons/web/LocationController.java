package com.martinetherton.ons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.service.LocationService;

@Controller
public class LocationController {

    private LocationService locationService;

    public LocationController() {
        
    }
    
    @RequestMapping(value="/locations/new", method=RequestMethod.GET)
    public String setUpForm(Model model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "addLocation";
    }    
    
    
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/locations/{id}")
    public String locactionDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("locationDetails", locationService.getLocation(id));
        return "locationDetails";
    }

}
