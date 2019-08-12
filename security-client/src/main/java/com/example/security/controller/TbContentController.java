package com.example.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.security.entity.TbContent;
import com.example.security.service.ITbContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@Api(value="用户controller",tags={"用户操作接口"})
public class TbContentController {

    @Autowired
    ITbContentService tbContentService;

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping("/getEntity/{id}")
    public ResponseEntity getEntity(@PathVariable Integer id) {
        TbContent content = tbContentService.getById(id);
        // List<TbContent> contentList = tbContentService.list();
        System.out.println("id: " + id + ", content: " + content);
        // System.out.println("contentList: " + contentList);
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

    @PostMapping("/insertContent")
    public void insertContent(TbContent tbContent) {

        StringBuilder sb = new StringBuilder();
        sb.append(tbContent.getContent());
        sb.append(tbContent.getCategoryId());

        sb.append(tbContent.getPic2());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");


        StringBuilder stringBuilder = new StringBuilder();



    }

}
