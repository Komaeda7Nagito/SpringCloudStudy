package com.xzzzf.controller;

import com.xzzzf.entity.Book;
import com.xzzzf.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping("/book/{bid}")
    public Book findBookById(@PathVariable("bid") Integer bid) {
        return bookService.getBookById(bid);
    }
}
