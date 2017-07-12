package cn.com.howell.server;

import cn.com.howell.api.AdditionService;
import cn.com.howell.api.UserService;
import cn.com.howell.server.impl.AdditionServiceImpl;
import cn.com.howell.server.impl.UserServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by HowellYang on 12/7/17 AM11:02.
 * E-Mail:th15817161961@gmail.com
 */
public class Server {
    public void startServer() {
        try {

            TServerSocket serverTransport = new TServerSocket(1234);

            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            AdditionService.Processor process = new AdditionService.Processor(new AdditionServiceImpl());
            UserService.Processor userProcessor = new UserService.Processor(new UserServiceImpl());

            processor.registerProcessor("AdditionService", process);
            processor.registerProcessor("UserService", userProcessor);

            Factory portFactory = new Factory(true, true);
            Args args = new Args(serverTransport);
            args.processor(processor);
            args.protocolFactory(portFactory);

            TServer server = new TThreadPoolServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}