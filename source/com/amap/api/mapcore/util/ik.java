package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class ik
  extends eu<String, a>
{
  private int[] h = { 10000, 0, 10018, 10019, 10020, 10021, 10022, 10023 };
  
  public ik(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.g = "/feedback";
    this.isPostFlag = false;
  }
  
  protected a a(String paramString)
    throws et
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = -1;
      paramString = "";
      String str = "";
      if (((JSONObject)localObject).has("errcode"))
      {
        i = ((JSONObject)localObject).optInt("errcode");
        paramString = ((JSONObject)localObject).optString("errmsg");
        str = ((JSONObject)localObject).optString("errdetail");
      }
      localObject = new a();
      ((a)localObject).a = i;
      ((a)localObject).b = paramString;
      ((a)localObject).c = str;
      int j = 0;
      ((a)localObject).d = false;
      paramString = this.h;
      int k = paramString.length;
      while (j < k)
      {
        if (paramString[j] == i)
        {
          ((a)localObject).d = true;
          return (a)localObject;
        }
        j += 1;
      }
      return (a)localObject;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public Map<String, String> getParams()
  {
    Hashtable localHashtable = new Hashtable(16);
    localHashtable.put("key", fk.f(this.f));
    localHashtable.put("pname", "3dmap");
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
    public int a = -1;
    public String b;
    public String c;
    public boolean d = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */