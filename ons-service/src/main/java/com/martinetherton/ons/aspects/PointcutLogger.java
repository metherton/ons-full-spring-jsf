package com.martinetherton.ons.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.martinetherton.ons.service.PersonServiceImpl;

@Aspect
public class PointcutLogger {

//    @Before("bla() || bla1()")
//    public void monitor() {
//        System.out.println("a service method has been called");
//    }
    
//    @Pointcut("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcut1())")
//    public void bla() {}
//
//    @Pointcut("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcut2())")
//    public void bla1() {}    

    
    @Before("com.martinetherton.ons.aspects.SystemAspects.bla()")
    public void monitor() {
        System.out.println("pointcut1 has been called");
    }
 
    @Before("com.martinetherton.ons.aspects.SystemAspects.bla1()")
    public void monitor1() {
        System.out.println("pointcut2 has been called");
    } 
    
    @Before("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcutWithParam(String))")
    public void monitorPointcutWithParam(JoinPoint jp) {
        PersonServiceImpl ps = (PersonServiceImpl) jp.getTarget();
        Object[] args = jp.getArgs();
        String name = (String) args[0];
        System.out.println("arg passed was " + name);
    }     
    

    @Before("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcutWithParam(String)) && target(serviceType) && args(input)")
    public void monitorPointcutWithContext(PersonServiceImpl serviceType, String input) {
        System.out.println("Pointcut with context arg passed was " + input);
    }     
    
    @Pointcut("execution(* com.martinetherton.ons.service.PersonServiceImpl.pointcutWithParam(String)) && target(serviceType) && args(input)")
    public void monitorPointcutWithContextUsingPointcutAnnotation(PersonServiceImpl serviceType, String input) {}     
    
    @Before("monitorPointcutWithContextUsingPointcutAnnotation(serviceType,input)") 
    public void logPointCutWithContext(PersonServiceImpl serviceType, String input) {
        System.out.println("Pointcut with context arg and pointcut annotation passed was " + input);
    }
    
    
}
