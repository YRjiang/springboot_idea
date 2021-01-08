package com.example.springboot.elasticsearch.controller;


import com.example.springboot.elasticsearch.entity.DocBean;
import com.example.springboot.elasticsearch.repository.DocRepository;
import com.example.springboot.elasticsearch.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(("/elasticsearch"))
public class ElasticsearchController {

    /**
     * Elasticsearch是一个基于Lucene的搜索服务器。
     * 它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。
     *
     *
     */

    //@Autowired
    //private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    DocRepository repository;

    @Autowired
    private IElasticService elasticService;

    @PostMapping("/create")
    public Object create(Map<String, Object> paramsMap) {

        // 创建索引, 根据 Item 类的 @Document 注解信息来创建
        //elasticsearchTemplate.createIndex(DocBean.class);
        // 配置映射, 根据 Item 类中的 id、 Field 等字段来自完成映射
        //elasticsearchTemplate.putMapping(DocBean.class);

        System.out.println("elasticsearch create success -----------------");

        return null;
    }

    @PostMapping("/test")
    public Object get(Map<String, Object> paramsMap) {

        return  null;
    }

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<DocBean> list =new ArrayList<>();
        list.add(new DocBean(1L,"XX0193","XX8064","xxxxxx",1));
        list.add(new DocBean(2L,"XX0210","XX7475","xxxxxxxxxx",1));
        list.add(new DocBean(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all() {
        return elasticService.findAll();
    }

}
