package cn.com.howell.client;

import cn.com.howell.api.AdditionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
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
            TProtocol protocol = new TBinaryProtocol(transport);
            AdditionService.Client client = new AdditionService.Client(protocol);
            transport.open();

            System.out.println(client.add(2012, 5100));
            System.out.println(client.getString("Howell"));

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
