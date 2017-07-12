namespace java cn.com.howell.api
include "Addreq.thrift"

typedef i32 int  //typedefs to get convenient names for your types

service AdditionService {  // defines the service to add two numbers  
        int add(1:int n1, 2:int n2), //defines a method  
        string getString(1:string s1),
        double tre(1:Addreq.Addreq s1)
}