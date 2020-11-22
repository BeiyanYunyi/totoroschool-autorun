package com.amap.api.mapcore.util;

public class fj
  extends Exception
{
  private String a = "未知的错误";
  private String b = "";
  private String c = "";
  private String d = "1900";
  private String e = "UnknownError";
  private int f = -1;
  
  public fj(String paramString)
  {
    super(paramString);
    this.a = paramString;
    a(paramString);
  }
  
  public fj(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1);
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private void a(String paramString)
  {
    if ("IO 操作异常 - IOException".equals(paramString))
    {
      this.f = 21;
      this.d = "1902";
      this.e = "IOException";
      return;
    }
    if ("socket 连接异常 - SocketException".equals(paramString))
    {
      this.f = 22;
      return;
    }
    if ("socket 连接超时 - SocketTimeoutException".equals(paramString))
    {
      this.f = 23;
      this.d = "1802";
      this.e = "SocketTimeoutException";
      return;
    }
    if ("无效的参数 - IllegalArgumentException".equals(paramString))
    {
      this.f = 24;
      this.d = "1901";
      this.e = "IllegalArgumentException";
      return;
    }
    if ("空指针异常 - NullPointException".equals(paramString))
    {
      this.f = 25;
      this.d = "1903";
      this.e = "NullPointException";
      return;
    }
    if ("url异常 - MalformedURLException".equals(paramString))
    {
      this.f = 26;
      this.d = "1803";
      this.e = "MalformedURLException";
      return;
    }
    if ("未知主机 - UnKnowHostException".equals(paramString))
    {
      this.f = 27;
      this.d = "1804";
      this.e = "UnknownHostException";
      return;
    }
    if ("服务器连接失败 - UnknownServiceException".equals(paramString))
    {
      this.f = 28;
      this.d = "1805";
      this.e = "CannotConnectToHostException";
      return;
    }
    if ("协议解析错误 - ProtocolException".equals(paramString))
    {
      this.f = 29;
      this.d = "1801";
      this.e = "ProtocolException";
      return;
    }
    if ("http连接失败 - ConnectionException".equals(paramString))
    {
      this.f = 30;
      this.d = "1806";
      this.e = "ConnectionException";
      return;
    }
    if ("未知的错误".equals(paramString))
    {
      this.f = 31;
      return;
    }
    if ("key鉴权失败".equals(paramString))
    {
      this.f = 32;
      return;
    }
    if ("requeust is null".equals(paramString))
    {
      this.f = 1;
      return;
    }
    if ("request url is empty".equals(paramString))
    {
      this.f = 2;
      return;
    }
    if ("response is null".equals(paramString))
    {
      this.f = 3;
      return;
    }
    if ("thread pool has exception".equals(paramString))
    {
      this.f = 4;
      return;
    }
    if ("sdk name is invalid".equals(paramString))
    {
      this.f = 5;
      return;
    }
    if ("sdk info is null".equals(paramString))
    {
      this.f = 6;
      return;
    }
    if ("sdk packages is null".equals(paramString))
    {
      this.f = 7;
      return;
    }
    if ("线程池为空".equals(paramString))
    {
      this.f = 8;
      return;
    }
    if ("获取对象错误".equals(paramString))
    {
      this.f = 101;
      return;
    }
    this.f = -1;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */