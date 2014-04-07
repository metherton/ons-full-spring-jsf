package com.martinetherton.ons.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class EmbeddedServletResponseWrapper extends HttpServletResponseWrapper {

    private StringWriter sw = new StringWriter(1024);
    
    public EmbeddedServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(sw);
    }
    
    public String toString() {
        return sw.toString();
    }
    
}
