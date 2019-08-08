package com.example.springboot.service.impl;

import com.example.springboot.mapper.CityMapper;
import com.example.springboot.model.City;
import com.example.springboot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private CityMapper cityMapper;

    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }

    @Override
    public City findCityById(Integer id) {
        return cityMapper.findById(id);
    }

    @Override
    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public void updateCityById(City city) {
        cityMapper.updateCityById(city);
    }

    @Override
    public void deleteCityById(Integer id) {
        cityMapper.deleteCityById(id);
    }

    @Override
    public void insertCity(City city) {
        cityMapper.insertCity(city);
    }

    @Override
    public City findAllCity() {
        return cityMapper.findAllCity();
    }

}
