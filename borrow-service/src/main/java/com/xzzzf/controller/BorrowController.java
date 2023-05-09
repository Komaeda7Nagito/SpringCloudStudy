package com.xzzzf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xzzzf.entity.BorrowDetails;
import com.xzzzf.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    public BorrowDetails getUserBorrows(@PathVariable("uid") Integer uid) {
        return borrowService.getUserBorrowDetails(uid);
    }

    /** hystrix 服务降级 备选方案
     * 如果多次不行会直接升级到服务熔断
     * 过一段时间会再次尝试调用
     * 如果成功了，就会恢复正常 否则继续熔断
    */
    public BorrowDetails onError(Integer uid){
        return new BorrowDetails(null, Collections.emptyList());
    }
}
