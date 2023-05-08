package com.xzzzf.service.impl;

import com.xzzzf.entity.Book;
import com.xzzzf.entity.Borrow;
import com.xzzzf.entity.BorrowDetails;
import com.xzzzf.entity.User;
import com.xzzzf.mapper.BorrowMapper;
import com.xzzzf.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowMapper borrowMapper;

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public BorrowDetails getUserBorrowDetails(Integer uid) {
        List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);
        User user = restTemplate.getForObject("http://localhost:8301/user/" + uid, User.class);

        List<Book> bookList = borrows
                .stream()
                .map(borrow -> restTemplate.getForObject("http://localhost:8101/book/" + borrow.getBid(), Book.class))
                .collect(Collectors.toList());
        return new BorrowDetails(user, bookList);
    }
}
