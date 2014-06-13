package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Death;

@Repository
public class DeathRepositoryImpl implements DeathRepository {

    private EntityManager entityManager;
    
    @Override
    public Death findBy(long id) {
        return entityManager.find(Death.class, id);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public long getTotalNumberOfDeaths() {
        Query query = entityManager.createQuery("SELECT COUNT(d) FROM Death d");
        return (long) query.getSingleResult();
    }

}
