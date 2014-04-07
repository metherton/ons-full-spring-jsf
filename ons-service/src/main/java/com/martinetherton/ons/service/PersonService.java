package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Person;

public interface PersonService {

    Person getPerson(long id);

    void addPerson(Person pToInsert);

}
