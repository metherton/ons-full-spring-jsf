package com.martinetherton.ons.web;

public class TreeHandler {

    public String processMessage(String message) {
        System.out.println("Message is : " + message);
        return "confirmation that we received: " + message;
    }
    
}
