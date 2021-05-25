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
请求与响应的报文均是一段密文，加密方法为 `AES-ECB`，padding为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码，密钥为 `www.xto*oro.com/`。  
解密后的报文是一个经 stringify 的 JSON 对象，对其使用 `JSON.parse()`(JavaScript，其它语言请自行探索) 方法后即为本文档各示例使用的格式。

### allnewlogin
此接口的作用是使用用户的微信信息进行登录。  
#### 请求：
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
`password` —— 用户密码。在使用微信登录的情况下，该值恒为空。  

#### 响应：
```jsonc
{
   "schoolID": "*",
   "schoolName": "******",
   "snCode": "*******",
   "login_url": "77",
   "bindflag": "Y",
   "code": "0000"
 }
```
`schoolID` —— 学校的ID，与使用龙猫校园的各学校存在对应关系。  
`schoolName` —— 学校名，为人类可直接阅读的汉字。  
`snCode` —— 学号。  
`login_url` —— 未知。  
`bindflag` —— 推测为"用户是否已绑定微信"。在龙猫校园强制使用微信登录的当下，该值恒为 `"Y"`。  
`code` —— 响应状态码。对于本请求，已知`0000`表示成功。  

### GetStudentInfo
此接口的作用是获取学生的个人信息。

#### 请求：
```jsonc
{
  "schoolName": "*",
  "snCode": "********"
}
```
`schoolName` —— 同 `allnewlogin` 响应中 `schoolID` 一项。（吐槽一下龙猫开发者为啥不把键名统一一下）  
`snCode` —— 同 `allnewlogin` 响应中 `snCode` 一项。  

#### 响应
```jsonc
{
   "Studentlist": [
     {
       "snCode": "********",
       "stuName": "***",
       "sex": "*",
       "className": "******",
       "phoneNumber": "***********",
       "curclass": "*********",
       "birthdate": null,
       "cardid": "",
       "indate": "2020-09",
       "collegesName": "*******",
       "campusid": "**",
       "campusName": "***",
       "photoflag": "N"
     }
   ],
   "code": "8000"
 }
```
`snCode` —— 同 `allnewlogin` 中 `snCode` 一项。  
`stuName` —— 学生的名字，人类可读。  
`sex` —— 学生的身份证性别，绝大多数情况下是生理性别，大多数情况下是心理性别，人类可读。  
`className` —— 学生所在班级的名字，人类可读。  
`phoneNumber` —— 学生的手机号，人类可读。  
`curclass` —— 课程归属，人类可读。  
`birthdate` —— 生日。  
`cardid` —— 未知。对本文作者所属学校，该值恒为空。  
`indate` —— 学生入学年月。  
`collegesName` —— 学院名，人类可读。  
`campusid` —— 未知，值与 `allnewlogin` 响应中 `schoolID` 一项不同。  
`campusName` —— 学校名，人类可读，值与 `allnewlogin` 响应中 `schoolName` 一项可以不同。  
`photoflag` —— 未知。是"有/无照片"？是"需要/不需要照片"？还请自行摸索。  
`code` —— 响应状态码。对本请求，已知 `0800` 表示成功。
