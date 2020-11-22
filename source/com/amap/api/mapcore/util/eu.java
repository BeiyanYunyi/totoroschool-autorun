package com.amap.api.mapcore.util;

import android.content.Context;

public abstract class eu<T, V>
  extends cw
{
  protected T d;
  protected int e = 1;
  protected Context f;
  protected String g;
  
  public eu(Context paramContext, T paramT)
  {
    a(paramContext, paramT);
  }
  
  private V a(byte[] paramArrayOfByte)
    throws et
  {
    return (V)b(paramArrayOfByte);
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.f = paramContext;
    this.d = paramT;
    this.e = 1;
    setSoTimeout(30000);
    setConnectionTimeout(30000);
  }
  
  private V e()
    throws et
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if (i < this.e) {}
      try
      {
        setProxy(ft.a(this.f));
        localObject3 = a(makeHttpRequest());
        try
        {
          int j = this.e;
          i = j;
          localObject1 = localObject3;
        }
        catch (et localet1)
        {
          localObject4 = localet1;
          break label79;
        }
        catch (fj localfj1)
        {
          Object localObject4 = localObject3;
          localObject3 = localfj1;
          break label115;
        }
        throw new et("未知错误");
      }
      catch (et localet2)
      {
        Object localObject3 = localfj1;
        i += 1;
        if (i < this.e)
        {
          localObject2 = localObject3;
          continue;
        }
        throw new et(localet2.a());
      }
      catch (fj localfj2)
      {
        Object localObject2;
        Object localObject5 = localObject2;
        i += 1;
        if (i < this.e) {}
        try
        {
          Thread.sleep(1000L);
          localObject2 = localObject5;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        if ((!"http连接失败 - ConnectionException".equals(localfj2.getMessage())) && (!"socket 连接异常 - SocketException".equals(localfj2.getMessage())) && (!"服务器连接失败 - UnknownServiceException".equals(localfj2.getMessage()))) {
          throw new et(localfj2.a());
        }
        throw new et("http或socket连接失败 - ConnectionException");
        d();
        if ((!"http连接失败 - ConnectionException".equals(localfj2.getMessage())) && (!"socket 连接异常 - SocketException".equals(localfj2.getMessage())) && (!"未知的错误".equals(localfj2.a())) && (!"服务器连接失败 - UnknownServiceException".equals(localfj2.getMessage()))) {
          throw new et(localfj2.a());
        }
        throw new et("http或socket连接失败 - ConnectionException");
        return (V)localObject2;
      }
      catch (Throwable localThrowable)
      {
        label79:
        label115:
        for (;;) {}
      }
    }
  }
  
  public V a()
    throws et
  {
    if (this.d != null) {
      return (V)e();
    }
    return null;
  }
  
  protected V b(byte[] paramArrayOfByte)
    throws et
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte != null)
    {
      if ("".equals(paramArrayOfByte)) {
        return null;
      }
      ew.a(paramArrayOfByte, this.g);
      return (V)c(paramArrayOfByte);
    }
    return null;
  }
  
  protected abstract V c(String paramString)
    throws et;
  
  protected V d()
  {
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */