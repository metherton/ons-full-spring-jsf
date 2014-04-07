package com.martinetherton.ons.persist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Person;


@Repository
public class PersonRepositoryImpl implements PersonRepository {

    
    private EntityManager entityManager;
    private Map<Long, Person> cache;
    
    @Override
    public Person findBy(long entityId) {
        if (cache != null && cache.containsKey(entityId)) {
            return cache.get(entityId);
        }
        return (Person) entityManager.find(Person.class, entityId);
    }

    /**
     * Set the entity manager. Assumes automatic dependency injection via the
     * JPA @PersistenceContext annotation. However this method may still be
     * called manually in a unit-test.
     * 
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void populateCache() {
        cache = new HashMap<Long, Person>();
        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();
        for (Person p : persons) {
            cache.put(p.getEntityId(), p);
        }
    }

    @PreDestroy
    public Map<Long, Person> getPersonCache() {
        return cache;
    }

    @Override
    public void clearCache() {
        cache.clear();
    }

    @Override
    public void add(Person newPerson) {
        entityManager.persist(newPerson);
    }

}
