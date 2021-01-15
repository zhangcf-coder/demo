package com.example.demo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class DoubleDataSource {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @RequestMapping("/test3")
    public List<Map<String, Object>> test3(){
        String sql = "SELECT * FROM department";
        List<Map<String, Object>> maps = jdbcTemplate2.queryForList(sql);
        return maps;
    }

    @RequestMapping("/test4")
    public List<Map<String, Object>> test4(){
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> maps = jdbcTemplate1.queryForList(sql);
        return maps;
    }
}
