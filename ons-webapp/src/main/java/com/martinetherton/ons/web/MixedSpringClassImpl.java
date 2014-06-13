package com.martinetherton.ons.web;

import org.springframework.beans.factory.annotation.Autowired;

public class MixedSpringClassImpl implements MixedSpringClass {

    private MixedSpringMandatory mandatory;
    private MixedSpringOptional optional;
    
    @Autowired
    private MixedSpringOptional mixedSpringOptional;
    
    private MixedSpringOptional mixedSpringOptionalViaMethod;
    
    public MixedSpringClassImpl(MixedSpringMandatory mandatory) {
        this.mandatory = mandatory;
    }

    public void setMandatory(MixedSpringMandatory mandatory) {
        this.mandatory = mandatory;
    }

    public void setOptional(MixedSpringOptional optional) {
        this.optional = optional;
    }

    @Override
    public MixedSpringMandatory getMandatory() {
        return mandatory;
    }

    @Override
    public MixedSpringOptional getOptional() {
        return optional;
    }
    
    public void setMixedSpringOptional(MixedSpringOptional mixedSpringOptional) {
        this.mixedSpringOptional = mixedSpringOptional;
    }

    @Autowired
    public void setMixedSpringOptionalViaMethod(MixedSpringOptional mixedSpringOptionalViaMethod) {
        this.mixedSpringOptionalViaMethod = mixedSpringOptionalViaMethod;
    }
    
    
    @Override
    public MixedSpringOptional getMixedSpringOptional() {
        return mixedSpringOptional;
    }

    @Override
    public MixedSpringOptional getMixedSpringOptionalViaMethod() {
        return mixedSpringOptionalViaMethod;
    }
    
}
