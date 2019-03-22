/*
package com.example.connect_mysql.controller;

import com.example.connect_mysql.mapper.BookStoreRepository;
import com.example.connect_mysql.model.BookStore;
import com.example.connect_mysql.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Autowired
    AsyncServiceImpl asyncService;

    @GetMapping(value = "/api/bookstore")
    public void elasticsearchIndex(){
        BookStore bookStore = new BookStore();
        bookStore.setName("西游记");
        bookStore.setAddress("address");
        bookStoreRepository.index(bookStore);
    }

    @GetMapping("/api/save")
    public String save(){
        BookStore bookStore = new BookStore("商品"+System.currentTimeMillis(), "这是一个测试商品");
        bookStoreRepository.save(bookStore);
        return "success";
    }

    @GetMapping(value = "/api/getBookStore")
    public BookStore getBookStore(){
        BookStore bookStore = new BookStore();
        bookStore.setName("西游记");
        bookStore.setAddress("address");
        return bookStore;
    }

    @GetMapping(value = "/api/async")
    public String async(){
        asyncService.sayHello();
        return "success";
    }

}
*/
