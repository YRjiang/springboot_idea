package com.example.springboot.elasticsearch.repository;

/*import com.example.springboot.elasticsearch.entity.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocRepository extends ElasticsearchRepository<DocBean, String> {

    //默认的注释
    //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<DocBean> findByContent(String content, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
    Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}")
    Page<DocBean> findBySecordCode(String secordCode, Pageable pageable);

}*/
