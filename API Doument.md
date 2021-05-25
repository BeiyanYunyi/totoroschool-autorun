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
/CGTService.svc/allnewlogin
