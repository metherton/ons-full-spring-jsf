package com.martinetherton.ons.persist;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;

@Aspect
public class EntityFinderTracker {

    private Logger logger = Logger.getLogger(getClass());
    
    @Before("execution(* find*(*))")
    public void trackFind() {
        logger.info("About to find entity");
    }
    
    
}
