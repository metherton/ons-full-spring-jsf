package com.martinetherton.ons.web;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class PrintPageOutputStream extends ServletOutputStream {

    BufferedOutputStream outputStream;

    public PrintPageOutputStream(ServletOutputStream outputStream) {
        this.outputStream = new BufferedOutputStream(outputStream);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }


}
