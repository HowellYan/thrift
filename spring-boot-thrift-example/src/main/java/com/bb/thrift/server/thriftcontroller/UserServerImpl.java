package com.bb.thrift.server.thriftcontroller;


import cn.com.howell.api.UserService;
import cn.com.howell.api.req.UserReq;
import cn.com.howell.api.resp.UserResp;
import cn.com.howell.api.resp.base.BaseResp;
import org.apache.thrift.TException;
import org.spring.boot.thrift.server.annotation.ThriftServer;

/**
 * Created by Howell on 17/1/11.
 */
@ThriftServer(value = "/userService")
public class UserServerImpl implements UserService.Iface {

    @Override
    public UserResp userLogin(UserReq userReq) throws TException {
        UserResp userResp = new UserResp();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode("000000").setMsg("成功").setIp("123456345345");
        if(userReq.getUserId().equals("123456")){
            userResp.setBaseResp(baseResp);
            userResp.setUserId("123456777");
            userResp.setUserName("1234567777");
        }
        return userResp;
    }

    @Override
    public UserResp userLogout(UserReq userReq) throws TException {
        return null;
    }
}