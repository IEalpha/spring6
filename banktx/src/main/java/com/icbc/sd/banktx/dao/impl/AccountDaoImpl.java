package com.icbc.sd.banktx.dao.impl;

import com.icbc.sd.banktx.dao.AccountDao;
import com.icbc.sd.banktx.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account selectAccount(String name) {
        String sql = "select * from account where name = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), name);
    }

    @Override
    public Integer changeBalance(String name, String balance) {
        String sql = "update account set balance = ? where name = ?";
        return jdbcTemplate.update(sql, balance, name);
    }

    @Override
    public Integer saveAccount(String name) {
        String sql = "insert into account(name, balance) values(?, ?)";
        return jdbcTemplate.update(sql, name, "0");
    }

}
