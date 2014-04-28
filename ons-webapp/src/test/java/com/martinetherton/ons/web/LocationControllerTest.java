package com.martinetherton.ons.web;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.service.LocationService;
import com.martinetherton.ons.service.LocationServiceImpl;


public class LocationControllerTest {

    @Test
    public void locationDetailsAddedToModel() {
        Location location = new Location("Sheffield");
        Model model = Mockito.mock(Model.class);
        LocationService locationService = Mockito.mock(LocationServiceImpl.class);
        LocationController locationController = new LocationController(locationService);;
        Mockito.when(locationService.getLocation(1)).thenReturn(location);
        String viewName = locationController.locactionDetails(1, model );
        Assert.assertThat("locationDetails", Matchers.is(viewName));
        Mockito.verify(model).addAttribute("locationDetails", location);
    }
    
}
