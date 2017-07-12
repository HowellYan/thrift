package cn.com.howell.server.impl;

import cn.com.howell.api.AdditionService;
import cn.com.howell.api.req.Addreq;
import org.apache.thrift.TException;

/**
 * Created by HowellYang on 12/7/17 AM11:07.
 * E-Mail:th15817161961@gmail.com
 */
public class AdditionServiceImpl implements AdditionService.Iface {
    @Override
    public int add(int n1, int n2) throws TException {
        return n1+n2;
    }

    @Override
    public String getString(String s1) throws TException {
        return s1+" , 你好！";
    }

    @Override
    public double tre(Addreq addreq) throws TException {
        return addreq.getNum1()+addreq.getNum2();
    }
}
