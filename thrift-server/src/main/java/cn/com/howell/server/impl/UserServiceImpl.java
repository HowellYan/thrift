package cn.com.howell.server.impl;

import cn.com.howell.api.UserService;
import cn.com.howell.api.req.UserReq;
import cn.com.howell.api.resp.UserResp;
import cn.com.howell.api.resp.base.BaseResp;
import org.apache.thrift.TException;

/**
 * Created by HowellYang on 12/7/17 PM2:31.
 * E-Mail:th15817161961@gmail.com
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public UserResp userLogin(UserReq userReq) throws TException {
        UserResp userResp = new UserResp();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode("000000").setMsg("成功").setIp("123456");
        if(userReq.getUserId().equals("123456")){
            userResp.setBaseResp(baseResp);
            userResp.setUserId("123456");
            userResp.setUserName("123456");
        }
        return userResp;
    }

    @Override
    public UserResp userLogout(UserReq userReq) throws TException {
        return null;
    }

}
