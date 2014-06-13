package com.martinetherton.ons.web;

public class OtherMandatoryAnnotation implements MixedSpringMandatory {

    private String name;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

}
