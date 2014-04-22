package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.martinetherton.ons.model.Surname;

public class SurnameRepositoryImpl implements SurnameRepository {

    public class SurnameExtractor implements ResultSetExtractor<Surname> {

        @Override
        public Surname extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            Surname surname = null;
            while (rs.next()) {
                if (surname == null) {
                    surname = new Surname();
                    surname.setEntityId(rs.getLong("ID"));
                    surname.setSurname(rs.getString("SURNAME"));
                }
            }
            return surname;
        }

    }

    private JdbcTemplate jdbcTemplate;

    public SurnameRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Surname> rowMapper = new SurnameMapper();    
    
    @Override
    public Surname findBy(long id) {
        String sql = "select * from T_SURNAME where ID = ?";
        return jdbcTemplate.queryForObject(sql, new SurnameMapper(),id);
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

    @Override
    public List<Surname> findAll() {
        String sql = "select * from T_SURNAME";
        return jdbcTemplate.query(sql, new SurnameMapper());
    }

    @Override
    public Surname findByName(String name) {
        String sql = "select * from T_SURNAME where SURNAME = ?";
        return jdbcTemplate.queryForObject(sql, new SurnameMapper(), name);
    }

    public int getSurnameCount() {
        String sql = "select count(*) from T_SURNAME";
        return jdbcTemplate.queryForInt(sql);
    }

    @Override
    public void generateSurnameFile(PrintWriter out) {
        jdbcTemplate.query("select * from T_SURNAME", new SurnameReportWriter(out));
    }

    @Override
    public Surname findByNameFromResultSet(String string) {
        return jdbcTemplate.query("select * from T_SURNAME where SURNAME = ?", new SurnameExtractor(), string);
    }

    @Override
    public int insert(Surname surname) {
        String sql = "insert into T_SURNAME (SURNAME) values (?)";
        return jdbcTemplate.update(sql, surname.getSurname());
    }

    @Override
    public void update(Surname surname) {
        // TODO Auto-generated method stub
        
    }

}
