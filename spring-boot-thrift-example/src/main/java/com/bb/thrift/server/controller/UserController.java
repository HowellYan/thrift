package com.bb.thrift.server.controller;

import cn.com.howell.api.UserService;
import cn.com.howell.api.req.UserReq;
import cn.com.howell.api.req.base.BaseReq;
import org.spring.boot.thrift.client.annotation.ThriftClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob on 17/1/11.
 */
@RestController
public class UserController {

    @ThriftClient(serviceId = "UserServerImpl", path = "/userService")
    UserService.Client UserServiceClient;

    @RequestMapping(method = RequestMethod.GET, value = "/userLogin")
    public Object userService() throws Exception {
        Map<String, Object> o = new HashMap<>();
        UserReq userReq = new UserReq();
        userReq.setUserPasswd("123456");
        userReq.setUserId("123456");
        userReq.setUserIp("123456");
        userReq.setUserMac("123456");
        userReq.setBaseReq(new BaseReq().setIp("123456").setKeep("123456"));
        UserServiceClient.userLogin(userReq);

        return o;
    }


}