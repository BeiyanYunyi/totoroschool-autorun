package com.amap.api.mapcore.util;

public class et
  extends Exception
{
  private String a = "";
  private int b = 1000;
  
  public et() {}
  
  public et(String paramString)
  {
    super(paramString);
    this.a = paramString;
    a(paramString);
  }
  
  private void a(String paramString)
  {
    if ("用户签名未通过".equals(paramString))
    {
      this.b = 1001;
      return;
    }
    if ("用户key不正确或过期".equals(paramString))
    {
      this.b = 1002;
      return;
    }
    if ("请求服务不存在".equals(paramString))
    {
      this.b = 1003;
      return;
    }
    if ("访问已超出日访问量".equals(paramString))
    {
      this.b = 1004;
      return;
    }
    if ("用户访问过于频繁".equals(paramString))
    {
      this.b = 1005;
      return;
    }
    if ("用户IP无效".equals(paramString))
    {
      this.b = 1006;
      return;
    }
    if ("用户域名无效".equals(paramString))
    {
      this.b = 1007;
      return;
    }
    if ("用户MD5安全码未通过".equals(paramString))
    {
      this.b = 1008;
      return;
    }
    if ("请求key与绑定平台不符".equals(paramString))
    {
      this.b = 1009;
      return;
    }
    if ("IP访问超限".equals(paramString))
    {
      this.b = 1010;
      return;
    }
    if ("服务不支持https请求".equals(paramString))
    {
      this.b = 1011;
      return;
    }
    if ("权限不足，服务请求被拒绝".equals(paramString))
    {
      this.b = 1012;
      return;
    }
    if ("开发者删除了key，key被删除后无法正常使用".equals(paramString))
    {
      this.b = 1013;
      return;
    }
    if ("请求服务响应错误".equals(paramString))
    {
      this.b = 1100;
      return;
    }
    if ("引擎返回数据异常".equals(paramString))
    {
      this.b = 1101;
      return;
    }
    if ("服务端请求链接超时".equals(paramString))
    {
      this.b = 1102;
      return;
    }
    if ("读取服务结果超时".equals(paramString))
    {
      this.b = 1103;
      return;
    }
    if ("请求参数非法".equals(paramString))
    {
      this.b = 1200;
      return;
    }
    if ("缺少必填参数".equals(paramString))
    {
      this.b = 1201;
      return;
    }
    if ("请求协议非法".equals(paramString))
    {
      this.b = 1202;
      return;
    }
    if ("其他未知错误".equals(paramString))
    {
      this.b = 1203;
      return;
    }
    if ("协议解析错误 - ProtocolException".equals(paramString))
    {
      this.b = 1801;
      return;
    }
    if ("socket 连接超时 - SocketTimeoutException".equals(paramString))
    {
      this.b = 1802;
      return;
    }
    if ("url异常 - MalformedURLException".equals(paramString))
    {
      this.b = 1803;
      return;
    }
    if ("未知主机 - UnKnowHostException".equals(paramString))
    {
      this.b = 1804;
      return;
    }
    if ("未知错误".equals(paramString))
    {
      this.b = 1900;
      return;
    }
    if ("无效的参数 - IllegalArgumentException".equals(paramString))
    {
      this.b = 1901;
      return;
    }
    if ("http或socket连接失败 - ConnectionException".equals(paramString))
    {
      this.b = 1806;
      return;
    }
    if ("IO 操作异常 - IOException".equals(paramString))
    {
      this.b = 1902;
      return;
    }
    if ("空指针异常 - NullPointException".equals(paramString))
    {
      this.b = 1903;
      return;
    }
    this.b = 1800;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */