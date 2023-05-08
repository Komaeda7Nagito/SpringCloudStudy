package com.xzzzf.service.impl;

import com.xzzzf.entity.Book;
import com.xzzzf.mapper.BookMapper;
import com.xzzzf.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.getBookById(bid);
    }
}
