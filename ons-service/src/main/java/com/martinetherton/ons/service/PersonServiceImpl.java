package com.martinetherton.ons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.persist.PersonRepository;
import com.martinetherton.ons.persist.PersonRepositoryImpl;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Override
    @Transactional
    public Person getPerson(long id) {
        return personRepository.findBy(id);
    }

    @Override
    @Transactional
    public void addPerson(Person pToInsert) {
        personRepository.add(pToInsert);
    }

}
