package com.martinetherton.ons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.persist.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl() {}
    
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    
    @Override
    @Transactional
    public Location getLocation(long id) {
        return locationRepository.findBy(id);
    }

}
