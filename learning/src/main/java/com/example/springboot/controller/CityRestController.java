package com.example.springboot.controller;

import com.example.springboot.model.City;
import com.example.springboot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 使用 @Controller 注解，在对应的方法上，视图解析器可以解析 return 的jsp.html页面，并且跳转到相应页面。
 *    若返回json等内容到页面，则需要加@ResponseBody注解
 *
 * 2. @RestController注解，相当于 @Controller + @ResponseBody 两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了
 *    但使用 @RestController 这个注解，就不能返回 jsp.html 页面，视图解析器无法解析 jsp.html 页面
 *
 */

//@RestController    //使用@RestController这个注解，就不能返回 jsp.html 页面，视图解析器无法解析 jsp.html 页面
@Controller
public class CityRestController {

    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseBody
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {//
        return cityService.findCityByName(cityName);
    }

    @GetMapping(value = "/getCity/{id}")
    public City getCity(@PathVariable Integer id){
        System.out.print("查询城市, id: " + id);
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@PathVariable Integer id) {//@RequestParam(value = "cityName", required = true) String userName
        System.out.print("查询城市, id: " + id);
        return cityService.getCityById(id);
    }

    @RequestMapping(value = "/updateCity", method = RequestMethod.GET)
    public City updateCity(City city){
        System.out.print("更新城市: " + city.toString());
        cityService.updateCityById(city);
        return city;
    }

    @GetMapping(value = "/abc")
    public String homePage(){
        return "首页";
    }

    @RequestMapping("/index")
    public String index() {
        return "demo";
    }

    @RequestMapping(value = "/mynearby")
    public String myNearby(Model model) {

        List<City> list = new ArrayList<>();
        City city1 = getCity(1);
        City city2 = getCity(2);
        City city3 = getCity(3);
        list.add(city1);
        list.add(city2);
        list.add(city3);

        model.addAttribute("myinfo", list);
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.print("点击了 hello ");
        return "commit";
    }

    @RequestMapping(value = "/api/ajax", method = RequestMethod.POST)
    @ResponseBody
    public City apiAjax(@RequestParam(value = "cityName", required = true) @RequestBody String id){
        System.out.print("ajax 查询城市, id: " + id);
        return cityService.findCityById(Integer.valueOf(id));
    }

    @RequestMapping(value = "/ajax/city", method = RequestMethod.POST)
    @ResponseBody
    public City ajaxCity(@RequestParam(value = "cityName", required = true) @RequestBody String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value="save.do", method=RequestMethod.POST)
    @ResponseBody
    private String doSave(@RequestParam("userName") String userName, @RequestParam("age") Integer age, HttpSession session){
        System.out.print("username: " + userName + ", age: " + age + "session: " + session);
        return "成功";
    }
}
