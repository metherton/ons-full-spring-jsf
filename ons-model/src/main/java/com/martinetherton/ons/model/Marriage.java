package com.martinetherton.ons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_MARRIAGE")
public class Marriage {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long entityId;
    
    @ManyToOne
    @JoinColumn(name="PARTNER_ID")
    private Person partner;

    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    private Person person;

    public Marriage() {
        
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public Person getPerson() {
        return person;
    }

    public Person getPartner() {
        return partner;
    }

}
