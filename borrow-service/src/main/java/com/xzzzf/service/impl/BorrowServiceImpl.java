package com.xzzzf.service.impl;

import com.xzzzf.entity.Book;
import com.xzzzf.entity.Borrow;
import com.xzzzf.entity.BorrowDetails;
import com.xzzzf.entity.User;
import com.xzzzf.mapper.BorrowMapper;
import com.xzzzf.service.BorrowService;
import com.xzzzf.service.client.BookClient;
import com.xzzzf.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowMapper borrowMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    @Resource
    private BookClient bookClient;


    // 通过restTemplate调用user-service和book-service
    // @Override
    // public BorrowDetails getUserBorrowDetails(Integer uid) {
    //     List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);
    //     User user = restTemplate.getForObject("http://user-service/user/" + uid, User.class);
    //
    //     List<Book> bookList = borrows
    //             .stream()
    //             .map(borrow -> restTemplate.getForObject("http://book-service/book/" + borrow.getBid(), Book.class))
    //             .collect(Collectors.toList());
    //     return new BorrowDetails(user, bookList);
    // }

    // 通过 Feign 调用 user-service 和 book-service
    @Override
    public BorrowDetails getUserBorrowDetails(Integer uid) {
        List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);
        User user = userClient.findUserById(uid);

        List<Book> bookList = borrows
                .stream()
                .map(borrow -> bookClient.findBookById(borrow.getBid()))
                .collect(Collectors.toList());
        return new BorrowDetails(user, bookList);
    }
}
