package com.example.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.security.entity.TbContent;
import com.example.security.service.ITbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yerong
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/tbContent")
public class TbContentController {

    @Autowired
    ITbContentService tbContentService;

    @GetMapping("/getEntity/{id}")
    public ResponseEntity getEntity(@PathVariable Integer id) {
        TbContent content = tbContentService.getById(id);
        List<TbContent> contentList = tbContentService.list();
        System.out.println("id: " + id + ", content: " + content);
        System.out.println("contentList: " + contentList);
        return ResponseEntity.ok(content);
    }

    @GetMapping("/getPage/{pageNo}/{pageSize}")
    public ResponseEntity page(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        //测试分页
        IPage<TbContent> contentIPage = tbContentService.page(
                new Page<TbContent>(pageNo, pageSize), new QueryWrapper<>());
        System.out.println(contentIPage.toString());
        return ResponseEntity.ok(contentIPage);
    }
}
