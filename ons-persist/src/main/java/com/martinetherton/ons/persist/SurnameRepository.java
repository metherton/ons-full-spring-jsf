package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.martinetherton.ons.model.Surname;

public interface SurnameRepository {

    Surname findBy(long i);
    public List<Surname> findAll();
    public Surname findByName(String name);
    public int getSurnameCount();
    void generateSurnameFile(PrintWriter out);
    Surname findByNameFromResultSet(String string);
    int insert(Surname surname);
    int update(Surname surname);
    String findLastSurname();
    int findNumberOfSurnamesGreaterThanLetter(String letter);
    Map findSurnameAsMap(long id);
    List<Surname> findAllSurnameInfo();
    public void init();
}
