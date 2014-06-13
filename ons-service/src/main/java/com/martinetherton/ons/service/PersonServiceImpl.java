package com.martinetherton.ons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.persist.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonVisitCount personVisitCount;

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @Autowired
//    public void setPersonVisitCount(PersonVisitCount personVisitCount) {
//        this.personVisitCount = personVisitCount;
//    }

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonVisitCount personVisitCount) {
        this.personRepository = personRepository;
        this.personVisitCount = personVisitCount;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Person getPerson(long id) {
        personVisitCount.incrementCount();
        return personRepository.findBy(id);
    }

    @Override
    @Transactional
    public void addPerson(Person pToInsert) {
        personRepository.add(pToInsert);
    }

    @Override
    public void pointcut1() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pointcut2() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pointcutWithParam(String name) {
        System.out.println("pointcutWithParam: " + name);
    }



}
