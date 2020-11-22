package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class ev<T, V>
  extends eu<T, V>
{
  public ev(Context paramContext, T paramT)
  {
    super(paramContext, paramT);
  }
  
  protected V d()
  {
    return null;
  }
  
  protected abstract String e();
  
  public byte[] getEntityBytes()
  {
    try
    {
      byte[] arrayOfByte = e().getBytes("utf-8");
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public Map<String, String> getParams()
  {
    return null;
  }
  
  public Map<String, String> getRequestHead()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("Content-Type", " application/json");
    localHashMap.put("Accept-Encoding", "gzip");
    localHashMap.put("User-Agent", "AMAP SDK Android Trace 7.1.0");
    localHashMap.put("x-INFO", fn.b(this.f));
    localHashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { "7.1.0", "trace" }));
    localHashMap.put("logversion", "2.1");
    return localHashMap;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */