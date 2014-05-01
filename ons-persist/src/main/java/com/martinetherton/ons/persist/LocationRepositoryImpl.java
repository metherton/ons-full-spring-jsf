package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Location;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Location findBy(long id) {
        return entityManager.find(Location.class, id);
    }

}
