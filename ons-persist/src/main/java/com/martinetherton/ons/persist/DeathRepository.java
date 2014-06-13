package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Death;

public interface DeathRepository {

    Death findBy(long id);

    void setEntityManager(EntityManager entityManager);

    long getTotalNumberOfDeaths();

}
