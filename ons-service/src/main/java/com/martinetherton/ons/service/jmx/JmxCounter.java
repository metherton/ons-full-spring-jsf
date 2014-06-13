package com.martinetherton.ons.service.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName="statistics:name=counter", description="A simple JMX counter")
public class JmxCounter implements JmxCounterMBean {

    @Override
    @ManagedAttribute(description="the counter value")
    public int getCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @ManagedOperation(description="increments the counter value")
    public void increment() {
        // TODO Auto-generated method stub

    }

}
