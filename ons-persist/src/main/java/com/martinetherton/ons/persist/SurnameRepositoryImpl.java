package com.martinetherton.ons.persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.martinetherton.ons.model.Surname;

public class SurnameRepositoryImpl implements SurnameRepository {

    private JdbcTemplate jdbcTemplate;

    public SurnameRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Surname> rowMapper = new SurnameMapper();    
    
    @Override
    public Surname findBy(long i) {
        String sql = "select * from T_SURNAME where ID = ?";
        return jdbcTemplate.queryForObject(sql, new SurnameMapper(),i);
    }

    private Surname mapSurname(ResultSet rs) throws SQLException {
        // get the row column data
        String surname = rs.getString("SURNAME");
        Surname entity = new Surname();
        entity.setSurname(surname);
        return entity;
    }    
    
    private class SurnameMapper implements RowMapper<Surname> {

        @Override
        public Surname mapRow(ResultSet rs, int rowNum) throws SQLException {
            return mapSurname(rs);
        }

    }    
    

}
