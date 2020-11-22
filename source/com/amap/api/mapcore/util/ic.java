package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class ic
{
  int a = 20000;
  int b = 20000;
  Proxy c = null;
  
  String b()
  {
    Object localObject = getEntityBytes();
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = getParams();
      if (localObject == null) {
        return getURL();
      }
      localObject = ia.a((Map)localObject);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(getURL());
      localStringBuffer.append("?");
      localStringBuffer.append((String)localObject);
      return localStringBuffer.toString();
    }
    return getURL();
  }
  
  byte[] c()
  {
    byte[] arrayOfByte2 = getEntityBytes();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length != 0) {}
    }
    else
    {
      String str = ia.a(getParams());
      arrayOfByte1 = arrayOfByte2;
      if (!TextUtils.isEmpty(str)) {
        arrayOfByte1 = fw.a(str);
      }
    }
    return arrayOfByte1;
  }
  
  public byte[] getEntityBytes()
  {
    return null;
  }
  
  protected String getIPDNSName()
  {
    return "";
  }
  
  public abstract Map<String, String> getParams();
  
  public abstract Map<String, String> getRequestHead();
  
  public abstract String getURL();
  
  protected boolean isIPRequest()
  {
    return TextUtils.isEmpty(getIPDNSName()) ^ true;
  }
  
  public boolean isIgnoreGZip()
  {
    return false;
  }
  
  public final void setConnectionTimeout(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void setProxy(Proxy paramProxy)
  {
    this.c = paramProxy;
  }
  
  public final void setSoTimeout(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */