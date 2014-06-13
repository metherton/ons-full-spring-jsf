package com.martinetherton.ons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Death;
import com.martinetherton.ons.persist.DeathRepository;

@Service
@Transactional(timeout=60)
public class DeathServiceImpl implements DeathService {

    private DeathRepository deathRepository;

    @Autowired
    public DeathServiceImpl(DeathRepository deathRepository) {
        this.deathRepository = deathRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public Death getDeath(long id) {
        return deathRepository.findBy(id);
    }

    @Override
    public long getTotalNumberOfDeaths() {
        return deathRepository.getTotalNumberOfDeaths();
    }

}
