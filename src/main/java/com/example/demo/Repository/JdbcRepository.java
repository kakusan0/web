package com.example.demo.Repository;

import com.example.demo.Model.userstorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // JdbcTemplateを使用したメソッドをここに定義
    public List<userstorage> singleselect() {
        String sql = "SELECT id, name, email FROM customers";
        return jdbcTemplate.query(sql, customerRowMapper());
    }
}
