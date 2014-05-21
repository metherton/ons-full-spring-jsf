package com.martinetherton.ons.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.persist.SurnameRepository;

@Service
public class SurnameServiceImpl implements SurnameService {

    private SurnameRepository surnameRepository;
    
    @Autowired
    public SurnameServiceImpl(SurnameRepository surnameRepository) {
        this.surnameRepository = surnameRepository;
    }

    @PostConstruct
    @CacheEvict(value="surnames")
    public void loadSurnames() {
        
    }
    
    @Override
    @Cacheable(value="surnames", key="#id")
    public Surname getSurname(Long id) {
        System.out.println("getSurname for ID: " + id);
        return surnameRepository.findBy(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Surname> getSurnames() {
        return surnameRepository.findAll();
    }

    @Override
    @Cacheable(value="surnames", key="#name")
    public Surname getSurnameWithName(String name) {
        System.out.println("getSurnameWithName for: " + name);
        return surnameRepository.findByName(name);
    }

    @Override
    @Transactional
    public void add(Surname surname) {
        surnameRepository.insert(surname);
    }

    @Override
    @Transactional
    public void update(Surname changedSurname) {
        // TODO Auto-generated method stub
        
    }

}
