package com.lz.service.impl;

import com.lz.dao.LocationDao;
import com.lz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDao;
    @Override
    public void addLocation(String name) {
        locationDao.addLocation(name);
    }
}
