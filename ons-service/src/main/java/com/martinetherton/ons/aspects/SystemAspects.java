package com.martinetherton.ons.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class SystemAspects {

    
    @Pointcut("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcut1())")
    public void bla() {}

    @Pointcut("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcut2())")
    public void bla1() {}    
    
}
