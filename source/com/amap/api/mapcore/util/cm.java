package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

public class cm
  extends eu<String, a>
{
  private String h;
  private boolean i = false;
  
  public cm(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.g = "/map/styles";
  }
  
  public cm(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramString);
    this.i = paramBoolean;
    if (paramBoolean)
    {
      this.g = "/sdk/map/styles";
      this.isPostFlag = false;
      return;
    }
    this.g = "/map/styles";
  }
  
  protected a a(String paramString)
    throws et
  {
    return null;
  }
  
  protected a a(byte[] paramArrayOfByte)
    throws et
  {
    a locala = new a();
    locala.a = paramArrayOfByte;
    if ((this.i) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length == 0)
      {
        locala.a = null;
        return locala;
      }
      if (locala.a.length > 1024) {
        return locala;
      }
      try
      {
        if (new String(paramArrayOfByte, "utf-8").contains("errcode"))
        {
          locala.a = null;
          return locala;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        gk.c(paramArrayOfByte, "CustomStyleRequest", "loadData");
      }
    }
    return locala;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public Map<String, String> getParams()
  {
    Hashtable localHashtable = new Hashtable(16);
    localHashtable.put("key", fk.f(this.f));
    if (!this.i) {
      localHashtable.put("output", "bin");
    } else {
      localHashtable.put("sdkType", "sdk_700");
    }
    localHashtable.put("styleid", this.h);
    String str1 = fn.a();
    String str2 = fn.a(this.f, str1, fw.c(localHashtable));
    localHashtable.put("ts", str1);
    localHashtable.put("scode", str2);
    return localHashtable;
  }
  
  public Map<String, String> getRequestHead()
  {
    Object localObject = dx.e();
    if (localObject != null) {
      localObject = ((fv)localObject).b();
    } else {
      localObject = null;
    }
    Hashtable localHashtable = new Hashtable(16);
    localHashtable.put("User-Agent", lk.c);
    localHashtable.put("Accept-Encoding", "gzip");
    localHashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { localObject, "3dmap" }));
    localHashtable.put("x-INFO", fn.a(this.f));
    localHashtable.put("key", fk.f(this.f));
    localHashtable.put("logversion", "2.1");
    return localHashtable;
  }
  
  public String getURL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://restapi.amap.com/v4");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public byte[] a;
    public int b = -1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */