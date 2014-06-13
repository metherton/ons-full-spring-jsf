package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.martinetherton.ons.model.Surname;

public class SurnameRepositoryImpl implements SurnameRepository, InitializingBean {

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
    
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("in after properties set");
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
    public int update(Surname surname) {
        return jdbcTemplate.update("update T_SURNAME set SURNAME = ? where ID = ?", surname.getSurname(), surname.getEntityId());
        
    }

    @Override
    public String findLastSurname() {
        String sql = "select max(SURNAME) from T_SURNAME";
        return (String) jdbcTemplate.queryForObject(sql, String.class);
    }

    @Override
    public int findNumberOfSurnamesGreaterThanLetter(String letter) {
        String sql = "select count(*) from T_SURNAME where SURNAME > ?";
        return jdbcTemplate.queryForInt(sql, letter);
    }

    @Override
    public Map findSurnameAsMap(long id) {
        String sql = "select * from T_SURNAME where ID = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    @Override
    public List findAllSurnameInfo() {
        String sql = "select * from T_SURNAME";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public void init() {
        System.out.println("in init-method");
    }

    public List<Properties> getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(List<Properties> adminEmails) {
        this.adminEmails = adminEmails;
    }

    private List<Properties> adminEmails;
    
}
