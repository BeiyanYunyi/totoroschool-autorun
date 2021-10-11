# 主 API

地址：`http://md.*****.com:****/CGTService.svc/接口名`  
该 API 接收 `HTTP1.1 POST` 请求，`headers` 如下：

```HTTP
Content-Type: application/json; charset=utf-8
Content-Length: ***
Host: 39.100.151.**:****
Connection: Keep-Alive
Accept-Encoding: gzip
User-Agent: okhttp/3.12.0
```

请求与响应的报文均是一段密文，加密方法为 `AES-ECB`，padding 为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码，密钥为 `www.xtotoro.com/`。  
解密后的报文是一个经 stringify 的 JSON 对象，对其使用 `JSON.parse()`(JavaScript，其它语言请自行探索) 方法后即为本文档各示例使用的格式。

## allnewlogin

此接口的作用是使用用户的微信信息进行登录。

### allnewlogin 请求

```json
{
  "Mac": "12:34:56:F0:ED:CE",
  "login_way": "5",
  "loginid": "orVpa6Y*****1*****k*********", // 经脱敏
  "password": ""
}
```

`Mac` ——用户设备的 MAC 地址。  
`login_way` ——未知，目前该值恒定为 5。  
`loginid` ——用户微信的 openID。据微信开发者文档，对每个`应用开发者 ID` 而言， openID 与用户微信账号存在唯一对应关系。  
`password` ——用户密码。在使用微信登录的情况下，该值恒为空。

### allnewlogin 响应

```json
{
  "schoolID": "*", // 经脱敏
  "schoolName": "******", // 经脱敏
  "snCode": "*******", // 经脱敏
  "login_url": "77",
  "bindflag": "Y",
  "code": "0000"
}
```

`schoolID` ——学校的 ID，与使用龙猫校园的各学校存在对应关系。  
`schoolName` ——学校名，为人类可直接阅读的汉字。  
`snCode` ——学号。  
`login_url` ——未知。  
`bindflag` ——推测为"用户是否已绑定微信"。在龙猫校园强制使用微信登录的当下，该值恒为 `"Y"`。  
`code` ——响应状态码。对本请求，已知`0000`表示成功。

## GetStudentInfo

此接口的作用是获取学生的个人信息。

### GetStudentInfo 请求

```json
{
  "schoolName": "*", // 经脱敏
  "snCode": "********" // 经脱敏
}
```

`schoolName` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项。（吐槽一下龙猫开发者为啥不把键名统一一下）  
`snCode` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。

### GetStudentInfo 响应

```json
{
  "Studentlist": [
    {
      "snCode": "********", // 经脱敏
      "stuName": "***", // 经脱敏
      "sex": "*", // 经脱敏
      "className": "******", // 经脱敏
      "phoneNumber": "***********", // 经脱敏
      "curclass": "*********", // 经脱敏
      "birthdate": null,
      "cardid": "",
      "indate": "2020-09",
      "collegesName": "*******", // 经脱敏
      "campusid": "**", // 经脱敏
      "campusName": "***", // 经脱敏
      "photoflag": "N"
    }
  ],
  "code": "8000"
}
```

`snCode` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。  
`stuName` ——学生的名字，人类可读。  
`sex` ——学生的身份证性别，绝大多数情况下是生理性别，大多数情况下是心理性别，人类可读。  
`className` ——学生所在班级的名字，人类可读。  
`phoneNumber` ——学生的手机号，人类可读。  
`curclass` ——课程归属，人类可读。  
`birthdate` ——生日。  
`cardid` ——未知。对本文作者所属学校，该值恒为空。  
`indate` ——学生入学年月。  
`collegesName` ——学院名，人类可读。  
`campusid` ——学院编号。  
`campusName` ——学校名，人类可读，值与 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolName` 一项可以不同。  
`photoflag` ——未知。是"有/无照片"？是"需要/不需要照片"？还请自行摸索。  
`code` ——响应状态码。对本请求，已知 `8000` 表示成功。

## getQrCode

此接口的作用似乎是获取早操签到二维码。由于笔者学校不使用此功能，该接口的文档仅供参考。

### getQrCode 请求

```json
{
  "campusName": "**",
  "schoolName": "*"
}
```

`campusName` ——学院编号。同 [GetStudentInfo 响应](#getstudentinfo-响应) 中 `campusid` 一项（继续吐槽作者为啥没统一键名）。  
`schoolName` ——学校编号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项（继续吐槽作者为啥没统一键名）。

### getQrCode 响应

```json
{
  "code": "8000",
  "qrcode": "1,93*****f-f7b8-4d26-bc71-4**********5,2020/*/*,2020/*/**,*:00,**:**,TM000000**,N,Y," // 经脱敏
}
```

`code` ——响应状态码。对本请求，已知 `8000` 表示成功。  
`qrcode` ——推测是二维码中的文本。包含一串 UUID、起止日期、起止时间和学期编号（TM000000\*\*）等信息，待解明。

## queryTaskPointList(已废弃)

此接口以前用于获取可用路线列表，但截至本文档撰写时已废弃。尽管如此，在每次进入 app 查看路线时，龙猫校园 app 仍然会徒劳地使用本 API。

### queryTaskPointList 请求

```json
{
  "campusName": "**", // 经脱敏
  "currentTime": "2021-**-**", // 经脱敏
  "scCode": "********", // 经脱敏
  "schoolName": "*" // 经脱敏
}
```

`campusName` ——学院编号。同 [GetStudentInfo 响应](#getstudentinfo-响应) 中 `campusid` 一项（继续吐槽作者为啥没统一键名）。  
`currentTime` ——当前日期，格式为`YYYY-MM-DD`。  
`scCode` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项（继续吐槽作者为啥没统一键名）。  
`schoolName` ——学校编号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项（继续吐槽作者为啥没统一键名）。

### queryTaskPointList 响应

```json
{
  "taskPointList": [
    {
      "padid": "PAD000000**", // 经脱敏
      "padname": "***", // 经脱敏
      "begdate": "2020-**-** 00:00:00.000000", // 经脱敏
      "enddate": "2020-**-** 00:00:00.000000", // 经脱敏
      "starttime": "*:00", // 经脱敏
      "endtime": "**:**", // 经脱敏
      "x": ***.***, // 经脱敏
      "y": ***.***, // 经脱敏
      "p_mile": ***.0, // 经脱敏
      "taskid": "QD000000**" // 经脱敏
    }
  ],
  "taskPointName": null,
  "taskPointCode": null,
  "startTime": "*:00", // 经脱敏
  "endTime": "**:**", // 经脱敏
  "code": "8000"
}
```

因本 API 已废弃，对此响应不作解析。

## get_runCode

本 API 的作用是获取 runCode。值得注意的是，响应中 runCode 一项存在第二重加密。

### get_runCode 请求

```json
{
  "schoolID": "*", // 经脱敏
  "snCode": "*****" // 经脱敏
}
```

`snCode` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。  
`schoolID` ——学校编号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项。

### get_runCode 响应

值得注意的是，runCode 一项存在第二重加密。

```json
{
  "code": "8000",
  "runcode": "H*****k*****k*****1*****5*****R*****p*****M=" // 经脱敏
}
```

`code` ——响应状态码。对本请求，已知 `8000` 表示成功。  
`runcode` ——被加密的 runCode。加密方法为 `AES-ECB`，padding 为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码，密钥为用户`openID`的前 16 位。经解密后的 runCode 是一个长度为 16 的字符串。

## new_runRegExercises

本 API 的作用是提交用户运动记录。值得注意的是，请求存在第二重加密。

### new_runRegExercises 请求

```json
{
  "param_add": "********", // 经脱敏
  "param_old": "********", // 经脱敏
  "baseObjId": 0
}
```

#### `param_add`

一串加密字符。加密方法为 `AES-ECB`，padding 为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码，密钥为`www.xtotoro.com/`。经解密后的`param_add`如下：

```txt
*;*****;******* // 经脱敏
```

第一个分号前的数值——同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项。  
第二个分号前的数值——同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。  
第三个分号前的数值——同 [get_runCode 响应](#get_runcode-响应) 中 `runcode` 一项。

#### `param_old`

一个被加密的 JSON 对象，加密方法为 `AES-ECB`，padding 为 `ISO10126`，内容使用 `UTF-8` 编码， 密文为 `base64` 编码，密钥为 [get_runCode 响应](#get_runcode-响应)中 `runcode` 一项经解密后得到的 16 位密钥。  
经解密与 `JSON.parse()` 后的 `param_old` 如下：

```json
{
  "alreadyAppeal": false,
  "baseStation": "mcc:460 mnc:** lac:***** ci:******** strength:0", // 经脱敏
  "begdate": "2021-04-19",
  "canAppeal": false,
  "currentTime": "2021-04-19 **:**", // 经脱敏
  "enddate": "2021-04-19",
  "flag": "Y",
  "gsensorx": "0.01",
  "gsensory": "0.33",
  "gsensorz": "0.12",
  "gvsensor": "0.12",
  "gysensorx": "0.01",
  "gysensory": "0.33",
  "gysensorz": "0.12",
  "isTask": true,
  "lasensor": "0.12",
  "lpasensor": "0.12",
  "luxsensor": "0.12",
  "mac": "**:**:**:**:**:**", // 经脱敏
  "msensorx": "0.01",
  "msensory": "0.33",
  "msensorz": "0.12",
  "nsensor": "0.12",
  "osensorx": "0.01",
  "osensory": "0.33",
  "osensorz": "0.12",
  "phoneInfo": "CN001/null/*******/******/11", // 经脱敏
  "phoneNumber": "139********", // 经脱敏
  "qualified": false,
  "route": "***.****,***.****;***.****,**.****;……", // 经脱敏
  "routeid": "***", // 经脱敏
  "rvsensor": "0.12",
  "schoolName": "*", // 经脱敏
  "snCode": "*****", // 经脱敏
  "taskid": "**", // 经脱敏
  "tsensor": "0.12",
  "userbegtime": "**:**", // 经脱敏
  "userendkm": "a", // 经脱敏
  "userendstep": "n+x", // 经脱敏
  "userendtime": "**:**", // 经脱敏
  "userfit": "3.0",
  "userkm": "a", // 经脱敏
  "useroffset": "0.0352",
  "userspeed": "*.********", // 经脱敏
  "userstartkm": "0", // 经脱敏
  "userstartstep": "n", // 经脱敏
  "userstep": "x", // 经脱敏
  "usertime": "00:**:**", // 经脱敏
  "version": "1.2.0",
  "warnflag": "N",
  "warntype": "",
  "baseObjId": 0
}
```

键名字段中带 `sensor` 的属性均为传感器数据，这些项在两位测试者手机上的值均为上文列出的恒定值，故不特别进行解析。

`alreadyAppeal` ——已撤回？未知，待解明。  
`baseStation` ——基站数据，其中 `strength` 一项在两位测试者的手机上均为 0。  
`begdate` ——跑步日期，格式为 `YYYY-MM-DD`。  
`canAppeal` ——可撤回？未知，待解明。  
`currentTime` ——当前时间，格式为 `YYYY-MM-DD hh:mm`。  
`enddate` ——跑步日期，格式为 `YYYY-MM-DD`。大多数情况下同 `begdate`。  
`flag` ——**推测**为跑步状态，正常跑步为"Y"。  
`isTask` ——**推测**为“是否为任务”，即：“阳光跑”为 `true`，“自由跑”为 `false`。  
`mac` ——用户的 MAC 地址，字母为大写形式。例：`11:45:14:AB:CD:EF`。  
`phoneInfo` ——手机信息，包含 IMEI 码、手机厂商、手机型号、系统版本，格式为 `CN001/IMEI码/手机厂商/手机型号/系统版本`。  
`phoneNumber` ——手机号码。  
`qualified` ——未知。该项在两位测试者的手机上均为 false。  
`route` ——路径信息，格式为 `经,纬;经,纬;……`。  
`routeid` ——路径编号。  
`schoolName` ——学校编号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项（继续吐槽作者为啥没统一键名）。  
`snCode` ——学号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。  
`taskid` ——任务编号。在笔者所在学校，该值与各个学期存在唯一对应关系。  
`userbegtime` ——跑步开始时间，格式为 `HH-mm`。  
`userendkm` ——用户跑步结束时的里程。在两位测试者的手机上，该值均等于 `userkm`。  
`userendstep` ——用户跑步结束时的步数。  
`userendtime` ——跑步结束时间，格式为 `HH-mm`。  
`userfit` ——**推测**是对跑步的隐式评分。一位测试者（使用 `vmos+Fake Location` 伪造跑步）的值为 2.9，另一位测试者（真实跑步）的值为 3.0。  
`userkm` ——用户跑步里程数。在两位测试者的手机上，该值均等于 `userendkm`。  
`useroffset` ——**推测**是路径偏移程度。  
`userspeed` ——用户速度，计算公式为 `userkm / 跑步时间（以带小数的小时表示）`。  
`userstartkm` ——用户开始跑步时的里程。在两位测试者的手机（Android）上，该值均等于 `"0"` 。
`userstartstep` ——用户跑步开始时的步数。  
`userstep` ——用户跑步步数，计算公式为 `userendstep - userstartstep` 。  
`usertime` ——用户跑步时间，格式为`HH-mm-ss`。  
`version` ——龙猫校园版本号。  
`warnflag` ——用户此次跑步是否被警告疑似作弊。  
`warntype` ——**推测**是警告类型，具体可能的取值待探明。  
`baseObjId` ——未知，待解明。在两位测试者的手机（Android）上，该值均等于 `"0"` 。

#### `baseObjId`

未知，待解明。在两位测试者的手机（Android）上，该值均等于 `"0"` 。

### new_runRegExercises 响应

```json
{
  "code": "8000"
}
```

`code` ——响应状态码。对本请求，已知：

- `8000` 表示成功。
- `7000` 表示当天已跑步，无法重复提交。
- `6002` 表示当前不在跑步时间，无法跑步。

## querySchoolTerm

本接口的作用是获取学期信息。

### querySchoolTerm 请求

```json
{
  "reqNum": "0",
  "schoolCode": "*" // 经脱敏
}
```

`reqNum` ——未知。在两位测试者的手机上，该值均为 0。  
`schoolCode` ——同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项。（继续吐槽作者为啥没统一键名）

### querySchoolTerm 响应

```json
{
  "termlist": [
    { "termid": "TM000000**", "termname": "2020-2021*学期", "flag": "Y" }, // 经脱敏
    { "termid": "TM000000**", "termname": "2020-2021*学期", "flag": "N" } // 经脱敏
  ],
  "code": "8000"
}
```

#### `termlist`

一个数组，里面存储着该学生经历的所有需要跑步的学期。

`termid` ——学期编号。  
`termname` ——学期名，人类可读。  
`flag` ——**推测**是用来区别当前学期与其它学期的一个 flag。本学期为`"Y"`，其他学期为`"N"`。

#### `code`

`code` ——响应状态码。对本请求，已知 `8000` 表示成功。

## run_query

该接口的作用是获取学生的跑步历史。已知该接口有两种请求与响应类型，在请求中表现为两个不同的 `flag`。

### run_query 请求 1

```json
{
  "academicYear": "TM000000**", // 已脱敏
  "flag": "T",
  "schoolName": "*", // 已脱敏
  "snCode": "****" // 已脱敏
}
```

`academicYear` ——学期编号。同 [querySchoolTerm 响应 termlist](#termlist) 中的 `termid` 一项。（继续吐槽作者为啥没统一键名）  
`flag` ——请求类型。对请求 1，类型为`"T"`。  
`schoolName` ——学校编号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `schoolID` 一项。（继续吐槽作者为啥没统一键名）  
`snCode`—— 学号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。

### run_query 响应 1

```json
{
  "code": "8000",
  "morQueryList": "[{\"stno\":……",
  "monthTimeList": "[{\"monthid\":\"2021-**\"……" // 经脱敏
}
```

`morQueryList`、`monthTimeList` 两项类型均为字符串，需要二次 `JSON.parse();` 才能被转化为对象。

#### `code`

响应状态码。对本请求，已知 `8000` 表示成功。

#### `morQueryList`

```js
[
  {
    stno: '****', // 经脱敏
    qfTimes: **, // 经脱敏
    NqfTimes: 0,
    numberOfRequests: **, // 经脱敏
    MonthnumberOfRequests: **, // 经脱敏
    termname: '2020-2021*学期' // 经脱敏
  }
]
```

一个意义不明的数组，数组里套着一个对象。

`stno` ——学号。同 [allnewlogin 响应](#allnewlogin-响应) 中 `snCode` 一项。（继续吐槽作者为啥没统一键名）  
`qfTimes` ——类型为数值（即不带引号），本学期已跑次数。  
`NqfTimes` ——类型为数值（即不带引号），未知。**推测**是不及格次数。  
`numberOfRequests` ——类型为数值（即不带引号），本学期要求跑步次数。  
`MonthnumberOfRequests` ——类型为数值（即不带引号），每月要求跑步次数。  
`termname` ——学期名，人类可读。同 [querySchoolTerm 响应 termlist](#termlist) 中的 `termname` 一项。

#### `monthTimeList`

```js
[
  { monthid: '2021-**', monthSuccess: **, NmonthSuccess: ** }, // 经脱敏
  { monthid: '2021-**', monthSuccess: **, NmonthSuccess: ** }, // 经脱敏
  ……
]
```

一个数组，存放着若干对象。每个对象的内容如下：

`monthid` ——月份名，会直接显示在龙猫校园的列表中  
`monthSuccess` ——类型为数值（即不带引号），当月已跑次数。  
`NmonthSuccess` ——类型为数值（即不带引号），当月不及格次数。
