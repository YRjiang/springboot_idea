package com.example.connect_mysql.controller;

import com.example.connect_mysql.model.City;
import com.example.connect_mysql.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {//
        return cityService.findCityByName(cityName);
    }

    @GetMapping(value = "/getCity/{id}")
    public City getCity(@PathVariable Integer id){
        System.out.print("查询城市, id: " + id);
        return cityService.findCityById(id);
    }

    /**
     * CacheManager 管理多个Cache 组件中，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
     * CacheManager 属性：
     *              cacheNames/value： 指定缓存组件的名字；
     *              key： 缓存数据使用的 key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *                    编写 spEl
     *              keyGenerator: key 的生成器； 与 key，二选一
     *              cacheManager: 指定缓存管理器
     *              condition: 指定符合条件的情况下才缓存
     *              sync： 是否使用异步模式
     *
     * @param id
     * @return
     */

    //将方法的结果进行缓存   key = "#id"; #id 相当于 #root.args[0]
    //@Cacheable(value = {"emp"})
    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable Integer id) {//@RequestParam(value = "cityName", required = true) String userName
        System.out.print("查询城市, id: " + id);
        return cityService.getCityById(id);
    }

    //@CachePut(value = "emp", key = "#result.id")
    @RequestMapping(value = "/updateCity", method = RequestMethod.GET)
    public City updateCity(City city){
        System.out.print("更新城市: " + city.toString());
        cityService.updateCityById(city);
        return city;
    }

    @GetMapping(value = "/abc")
    public String index(){
        return "首页";
    }

}
