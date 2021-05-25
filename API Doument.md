# API 文档
本文是龙猫校园的 API 文档，由抓包及逆向工程得出。

## 主API
地址：`http://md.*****.com:****/CGTService.svc/`  
该 API 接收 `HTTP1.1 POST` 请求，`headers` 如下：
```
Content-Type: application/json; charset=utf-8
Content-Length: ***
Host: 39.100.151.**:****
Connection: Keep-Alive
Accept-Encoding: gzip
User-Agent: okhttp/3.12.0
```
`POST` 报文是一段密文，加密方法为 `AES-ECB`，padding为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码。  
解密后的报文是一个经 stringify 的 JSON 对象，对其使用 `JSON.parse()`(JavaScript，其它语言请自行探索) 方法后即为本文档各示例使用的格式。

### allnewlogin
此接口的作用是使用用户的微信信息进行登录。  
解密后报文示意如下：
```jsonc
{
   "Mac": "12:34:56:F0:ED:CE",
   "login_way": "5",
   "loginid": "orVpa6Y*****1*****k*********", // 经脱敏
   "password": ""
}
```
`Mac` —— 用户设备的 MAC 地址。
`login_way` —— 未知，目前该值恒定为 5。
`loginid` —— 用户微信的 openID。据微信开发者文档，对每个`应用开发者 ID` 而言， openID 与用户微信账号存在唯一对应关系。
