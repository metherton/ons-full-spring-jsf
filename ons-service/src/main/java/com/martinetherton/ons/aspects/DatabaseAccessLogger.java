package com.martinetherton.ons.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import com.martinetherton.ons.model.Person;

@Aspect
public class DatabaseAccessLogger {

 //   private Logger logger = Logger.getLogger(getClass());
    
    private Map<Long, Person> cache = new HashMap<Long, Person>();


    @Before("@target(org.springframework.stereotype.Service)")
    public void serviceLogger() {
        System.out.println("service method called");
    }
    
    @Before("execution(@org.springframework.transaction.annotation.Transactional * *..*(..))")
    public void serviceLoggerWithAnnotation() {
        System.out.println("service method with annotation called");
    }
 
    @Before("execution(* *..*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
    public void serviceLoggerAroundWithAnnotation() {
        System.out.println("service method with transactional annotation called");
    }    
    
    
    @Before("execution(public void com.martinetherton.ons.persist.PersonRepositoryImpl.add(*))")
    public void trackInsertion(JoinPoint point) {
        String name = point.getSignature().getName();
        Object newValue = point.getArgs()[0];
        System.out.println("in track insertion");
   //     logger.info(name + " about to insert entity" + newValue + " on " + point.getTarget());
    }
    
    @AfterReturning(value="execution(public * *..service.*.get*(..))", returning="person")
    public void trackGetter(JoinPoint jp, Person person) {
        String name = jp.getSignature().getName();
    }
        
    @After("execution(public void *..add*(*))")
    public void trackUpdater(JoinPoint jp) {
        String name = jp.getSignature().getName();
        Object newValue = jp.getArgs()[0];
        System.out.println("in trackupdater" + newValue);
    }
    
    @Around("execution(public * *..service.*.getPerson(..))")
    public Object cache(ProceedingJoinPoint point) throws Throwable {
        Object key = point.getArgs()[0];
        System.out.println("innnn cache with key" + key);
        Object value = cache.get(key);
        System.out.println("value from cache is " + value);
        if (value == null) {
            value = point.proceed();
            System.out.println("value after proceed is " + value);
            cache.put((Long)key, (Person)value);
            System.out.println("cache is " + cache);
        }
        return value;
    }
    
}
