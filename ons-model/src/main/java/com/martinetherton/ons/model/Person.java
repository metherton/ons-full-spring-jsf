package com.martinetherton.ons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="T_PERSON")
public class Person {

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getHandicapped() {
        return handicapped;
    }

    @Override
    public String toString() {
        return "Person [entityId=" + entityId + ", firstName=" + firstName
                + ", handicapped=" + handicapped + "]";
    }

    public void setHandicapped(Boolean handicapped) {
        this.handicapped = handicapped;
    }

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;
    
    @Column(name="FIRST_NAME")
    @NotNull
    @Size(min=1)
    private String firstName;
    
    @Column(name="HANDICAPPED")
    private Boolean handicapped;
    
}
