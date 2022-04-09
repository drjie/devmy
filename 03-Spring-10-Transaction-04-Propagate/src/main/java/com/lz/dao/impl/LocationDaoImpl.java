package com.lz.dao.impl;

import com.lz.dao.LocationDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LocationDaoImpl extends JdbcDaoSupport implements LocationDao {
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addLocation(String name) {
        getJdbcTemplate().update("insert into location(name) values (?)",name);
        int num=1/0;
    }
}
