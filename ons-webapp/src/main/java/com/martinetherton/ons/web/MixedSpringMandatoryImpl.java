package com.martinetherton.ons.web;

public class MixedSpringMandatoryImpl implements MixedSpringMandatory {

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        if (!(obj instanceof MixedSpringMandatoryImpl)) {
            return false;
        }
        MixedSpringMandatoryImpl other = (MixedSpringMandatoryImpl) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    private String name;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    
    
}
