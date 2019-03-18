package com.example.connect_mysql.service.impl;

import com.example.connect_mysql.model.City;
import com.example.connect_mysql.mapper.CityMapper;
import com.example.connect_mysql.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }

}
