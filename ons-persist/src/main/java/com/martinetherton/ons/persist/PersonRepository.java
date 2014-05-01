package com.martinetherton.ons.persist;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Person;


public interface PersonRepository {

    Person findBy(long id);

    void setEntityManager(EntityManager entityManager);

    void populateCache();

    Map<Long, Person> getPersonCache();

    void clearCache();

    void add(Person newPerson);

    Person findEarliestPerson();

    List<Person> findAll();

}
