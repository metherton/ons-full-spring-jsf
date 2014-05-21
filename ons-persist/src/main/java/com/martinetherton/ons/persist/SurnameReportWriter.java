package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class SurnameReportWriter implements RowCallbackHandler {

    private PrintWriter out;

    public SurnameReportWriter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        String currentRow = rs.getString("SURNAME");
        out.println(currentRow);
    }
}
