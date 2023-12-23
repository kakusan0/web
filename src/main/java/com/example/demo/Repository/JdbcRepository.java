package com.example.demo.Repository;

import com.example.demo.Model.userstorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        JdbcRepository.jdbcTemplate = jdbcTemplate;
    }

    public static String test(userstorage user) {
        List<String> results = jdbcTemplate.query(
                """
                SELECT
                   *
                FROM
                    USERSTORAGE
                WHERE
                    MAIL = ?
                """,
                (rs, rowNum) -> rs.getString("MAIL"),
                user.getMail()
        );

        return results.isEmpty() ? null : results.get(0);
    }

    }
