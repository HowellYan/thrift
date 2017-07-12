package cn.com.howell.client;

import cn.com.howell.api.AdditionService;
import cn.com.howell.api.UserService;
import cn.com.howell.api.req.UserReq;
import cn.com.howell.api.req.base.BaseReq;
import cn.com.howell.api.resp.UserResp;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by HowellYang on 12/7/17 AM11:11.
 * E-Mail:th15817161961@gmail.com
 */
public class Client {
    public void startClient() {
        TTransport transport;
        try {
            transport = new TSocket("localhost", 1234);
            transport.open();


            TBinaryProtocol protocol = new TBinaryProtocol(transport);


            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"AdditionService");
            AdditionService.Client client1= new AdditionService.Client(mp1);
            System.out.println(client1.add(2012, 5100));


            TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol,"UserService");
            UserService.Client client2 = new UserService.Client(mp2);
            UserReq userReq = new UserReq();
            userReq.setUserPasswd("123456");
            userReq.setUserId("123456");
            userReq.setUserIp("123456");
            userReq.setUserMac("123456");
            userReq.setBaseReq(new BaseReq().setIp("123456").setKeep("123456"));
            UserResp userResp = client2.userLogin(userReq);
            System.out.println(userResp.getBaseResp().getCode());

            transport.close();



        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startClient();
    }
}
