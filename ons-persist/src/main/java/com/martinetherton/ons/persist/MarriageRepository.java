package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Marriage;

public interface MarriageRepository {

    void setEntityManager(EntityManager entityManager);

    Marriage findBy(long id);

}
