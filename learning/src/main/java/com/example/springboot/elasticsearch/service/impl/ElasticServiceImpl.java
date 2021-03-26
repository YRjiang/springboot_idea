package com.example.springboot.elasticsearch.service.impl;

/*import com.example.springboot.elasticsearch.entity.DocBean;
import com.example.springboot.elasticsearch.repository.DocRepository;
import com.example.springboot.elasticsearch.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ElasticServiceImpl implements IElasticService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private DocRepository repository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(DocBean.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(DocBean docBean) {
        repository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        repository.saveAll(list);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return repository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        return repository.findByContent(content,pageable);
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return repository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return repository.findBySecordCode(secordCode,pageable);
    }

    @Override
    public Page<DocBean> query(String key) {
        return repository.findByContent(key,pageable);
    }

}*/
