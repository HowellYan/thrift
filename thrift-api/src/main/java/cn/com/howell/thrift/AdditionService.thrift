namespace java cn.com.howell.api
include "req/Addreq.thrift"
include "resp/Addresp.thrift"
typedef i32 int

service AdditionService {
        int add(1:int n1, 2:int n2), //defines a method  
        string getString(1:string s1),
        Addresp.Addresp tre(1:Addreq.Addreq s1)
}