package com.xzzzf.service.client;

import com.xzzzf.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient{
    @Override
    public Book findBookById(Integer bid) {
        return new Book();
    }
}
