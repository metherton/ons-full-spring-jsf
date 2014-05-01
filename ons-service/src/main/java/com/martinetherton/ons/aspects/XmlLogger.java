package com.martinetherton.ons.aspects;

import org.aspectj.lang.JoinPoint;

public class XmlLogger {

    public void trackChange(JoinPoint point) {
        System.out.println("in xmllogger trackchange");
    }
    
}
