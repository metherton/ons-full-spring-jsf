package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Marriage;

@Repository
public class MarriageRepositoryImpl implements MarriageRepository {

    private EntityManager entityManager;

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Marriage findBy(long id) {
        return entityManager.find(Marriage.class, id);
    }
    
}
