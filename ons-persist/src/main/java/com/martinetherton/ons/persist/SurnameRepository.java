package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Surname;

public interface SurnameRepository {

    Surname findBy(long i);

}
