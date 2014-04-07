package com.martinetherton.ons.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.sun.istack.internal.logging.Logger;

@Aspect
public class InsertionLogger {

    private Logger logger = Logger.getLogger(getClass());
    
    @Before("(execution(public void com.martinetherton.ons.persist.PersonRepositoryImpl.add(*)))")
    public void trackInsertion(JoinPoint point) {
        String name = point.getSignature().getName();
        Object newValue = point.getArgs()[0];
        logger.info(name + " about to insert entity" + newValue + " on " + point.getTarget());
    }
}
