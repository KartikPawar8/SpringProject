package com.city.mode.dao;

import com.city.mode.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MyDaoImpl implements MyDao {





        @Autowired
        private JdbcTemplate jdbcTemplate;

        private final RowMapper<MyModel> rowMapper = new RowMapper<MyModel>() {
            @Override
            public MyModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                MyModel myModel = new MyModel();
                myModel.setId(rs.getLong("id"));
                myModel.setName(rs.getString("name"));
                // map other fields
                return myModel;
            }
        };

        @Override
        public List<MyModel> findAll() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, rowMapper);
        }

        @Override
        public MyModel save(MyModel myModel) {
            String sql = "INSERT INTO my_table (name) VALUES (?) RETURNING id";
            Long id = jdbcTemplate.queryForObject(sql, new Object[]{myModel.getName()}, Long.class);
            myModel.setId(id);
            return myModel;
        }
    }



