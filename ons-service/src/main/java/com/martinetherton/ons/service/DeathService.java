package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Death;

public interface DeathService {

    Death getDeath(long id);

    long getTotalNumberOfDeaths();

}
