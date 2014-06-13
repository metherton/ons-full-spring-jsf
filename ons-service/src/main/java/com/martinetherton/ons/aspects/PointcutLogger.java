package com.martinetherton.ons.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.martinetherton.ons.service.PersonServiceImpl;

public interface PointcutLogger {

    public void monitor();
 
    public void monitor1();

    public void pointcutMon();
    
    
    public void monitorPointcutWithParam(JoinPoint jp);
    

    public void monitorPointcutWithContext(PersonServiceImpl serviceType, String input);
    
    public void monitorPointcutWithContextUsingPointcutAnnotation(PersonServiceImpl serviceType, String input);     
        
    public void logPointCutWithContext(PersonServiceImpl serviceType, String input);
    
}
