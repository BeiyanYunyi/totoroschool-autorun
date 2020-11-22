package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class co
  extends eu<String, a>
{
  public co(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.g = "/map/styles";
  }
  
  protected a a(byte[] paramArrayOfByte)
    throws et
  {
    a locala = new a();
    locala.a = paramArrayOfByte;
    return locala;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  protected a b(String paramString)
    throws et
  {
    return null;
  }
  
  public Map<String, String> getParams()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("key", fk.f(this.f));
    localHashMap.put("output", "bin");
    String str1 = fn.a();
    String str2 = fn.a(this.f, str1, fw.c(localHashMap));
    localHashMap.put("ts", str1);
    localHashMap.put("scode", str2);
    return localHashMap;
  }
  
  public Map<String, String> getRequestHead()
  {
    Object localObject = dx.e();
    if (localObject != null) {
      localObject = ((fv)localObject).b();
    } else {
      localObject = null;
    }
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("User-Agent", lk.c);
    localHashMap.put("Accept-Encoding", "gzip");
    localHashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { localObject, "3dmap" }));
    localHashMap.put("x-INFO", fn.a(this.f));
    localHashMap.put("key", fk.f(this.f));
    localHashMap.put("logversion", "2.1");
    return localHashMap;
  }
  
  public String getURL()
  {
    return this.g;
  }
  
  public static class a
  {
    public byte[] a;
    public int b = -1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */