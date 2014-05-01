package com.martinetherton.ons.model;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
                + ", handicapped=" + handicapped + ", marriages=" + marriages
                + "]";
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
      
    @OneToMany
    @JoinColumn(name="PERSON_ID")
    private Set<Marriage> marriages;

    public Set<Marriage> getMarriages() {
        return marriages;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((entityId == null) ? 0 : entityId.hashCode());
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((handicapped == null) ? 0 : handicapped.hashCode());
        result = prime * result
                + ((marriages == null) ? 0 : marriages.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        if (entityId == null) {
            if (other.entityId != null) {
                return false;
            }
        } else if (!entityId.equals(other.entityId)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (handicapped == null) {
            if (other.handicapped != null) {
                return false;
            }
        } else if (!handicapped.equals(other.handicapped)) {
            return false;
        }
        if (marriages == null) {
            if (other.marriages != null) {
                return false;
            }
        } else if (!marriages.equals(other.marriages)) {
            return false;
        }
        return true;
    }
    
}
