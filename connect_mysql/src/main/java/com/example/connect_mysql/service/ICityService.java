package com.example.connect_mysql.service;

import com.example.connect_mysql.model.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ICityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    City findCityById(Integer id);

    public City getCityById(Integer id);

    void updateCityById(City city);

    public void deleteCityById(Integer id);

    public void insertCity(City city);

    public City findAllCity();
}
