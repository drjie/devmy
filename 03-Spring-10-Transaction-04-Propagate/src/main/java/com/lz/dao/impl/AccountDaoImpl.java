package com.lz.dao.impl;

import com.lz.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void addAccount(String name) {
        getJdbcTemplate().update("insert into account(name) value (?)",name);

    }
}
