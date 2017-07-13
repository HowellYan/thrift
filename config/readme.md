```
docker run -v "/Users/Howell/Work/other/docker/thrift:/data" thrift thrift -o /data --gen java /data/add.thrift

/Users/Howell/Tool/install/consul agent -dev -data-dir=/data/consul

http://127.0.0.1:8500/ui/#/dc1/services

/usr/local/Cellar/thrift/0.10.0/bin

```