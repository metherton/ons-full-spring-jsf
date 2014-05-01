package com.martinetherton.ons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="T_LOCATION")
public class Location {

    public Location() {};
    
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long entityId;
    @Column(name="CITY")
    private String city;
    @Column(name="POST_CODE")
    private String postCode;

    public Location(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

}
