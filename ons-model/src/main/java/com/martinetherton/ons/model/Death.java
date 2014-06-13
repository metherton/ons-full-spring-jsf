package com.martinetherton.ons.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_DEATH")
public class Death {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long entityId;    
    
    @ManyToOne
    @JoinColumn(name="PERSON_ID")    
    private Person person;
    
    @ManyToOne
    @JoinColumn(name="LOCATION_ID")        
    private Location location;
    
    @Column(name="DATE_OF_DEATH")    
    private Date dateOfDeath;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Person getPerson() {
        return person;
    }

    public Location getLocation() {
        return location;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

}
