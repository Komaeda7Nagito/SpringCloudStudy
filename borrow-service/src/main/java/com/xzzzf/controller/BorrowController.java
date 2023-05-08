package com.xzzzf.controller;

import com.xzzzf.entity.BorrowDetails;
import com.xzzzf.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    public BorrowDetails getUserBorrows(@PathVariable("uid") Integer uid) {
        return borrowService.getUserBorrowDetails(uid);
    }
}
