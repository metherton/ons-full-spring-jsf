package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Location;

public interface LocationRepository {

    void setEntityManager(EntityManager entityManager);

    Location findBy(long id);

}
