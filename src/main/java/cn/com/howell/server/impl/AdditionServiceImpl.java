package cn.com.howell.server.impl;

import cn.com.howell.api.AdditionService;
import org.apache.thrift.TException;

/**
 * Created by HowellYang on 12/7/17 AM11:07.
 * E-Mail:th15817161961@gmail.com
 */
public class AdditionServiceImpl implements AdditionService.Iface {
    public int add(int n1, int n2) throws TException {

        return n1+n2;
    }

    public String getString(String s1) throws TException {
        return s1+" , 你好！";
    }
}
