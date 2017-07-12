namespace java cn.com.howell.api.resp
include "base/BaseResp.thrift"
struct UserResp {
1: required BaseResp.BaseResp baseResp;
2: required string userId;
3: required string userName;
}