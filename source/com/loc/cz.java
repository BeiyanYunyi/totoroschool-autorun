package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cz
{
  private static cz d;
  private long a = 0L;
  private boolean b = false;
  private boolean c = false;
  private String[] e;
  private ArrayList<String> f = new ArrayList();
  private String g;
  private String h;
  private int i = 0;
  private long j = 120000L;
  private Context k;
  private boolean l = false;
  private boolean m = false;
  
  private cz(Context paramContext)
  {
    this.k = paramContext;
  }
  
  public static cz a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new cz(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private void b()
  {
    if (this.l)
    {
      Object localObject = this.k;
      try
      {
        localObject = ((Context)localObject).getSharedPreferences("cbG9jaXA", 0).edit();
        ((SharedPreferences.Editor)localObject).remove("last_ip");
        dm.a((SharedPreferences.Editor)localObject);
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "SpUtil", "setPrefsLong");
      }
      this.l = false;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      try
      {
        if (!df.A())
        {
          paramBoolean = this.m;
          if (paramBoolean) {
            return;
          }
        }
      }
      finally
      {
        break label119;
      }
    }
    if (this.a != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a;
      long l3 = this.j;
      if (l1 - l2 < l3) {
        return;
      }
      l2 = this.a;
      if (l1 - l2 < 60000L) {
        return;
      }
    }
    this.a = System.currentTimeMillis();
    this.m = true;
    aj.d().submit(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = new StringBuilder("http://");
        ((StringBuilder)localObject1).append(df.D());
        ((StringBuilder)localObject1).append("?host=apilocatesrc.amap.com");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new da();
        ((da)localObject2).f = ((String)localObject1);
        try
        {
          bj.a();
          localObject1 = new JSONObject(new String(bj.b((bn)localObject2)));
          if (((JSONObject)localObject1).has("ips"))
          {
            localObject2 = ((JSONObject)localObject1).getJSONArray("ips");
            int j = ((JSONArray)localObject2).length();
            if (j == 0) {
              return;
            }
            String[] arrayOfString = new String[j];
            int i = 0;
            while (i < j)
            {
              arrayOfString[i] = ((JSONArray)localObject2).getString(i);
              i += 1;
            }
            if (!cz.a(arrayOfString, cz.a(cz.this)))
            {
              cz.a(cz.this, arrayOfString);
              cz.b(cz.this);
            }
            if (((JSONObject)localObject1).has("ttl"))
            {
              i = ((JSONObject)localObject1).getInt("ttl");
              if (i > 30) {
                cz.a(cz.this, i * 1000);
              }
            }
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("key", "dnsError");
          ((JSONObject)localObject1).put("reason", localThrowable1.getMessage());
          dk.a(cz.c(cz.this), "O018", (JSONObject)localObject1);
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
      }
    });
    return;
    label119:
    throw ((Throwable)localObject);
  }
  
  private String c()
  {
    int n = 0;
    b(false);
    if ((this.e != null) && (this.e.length > 0))
    {
      String[] arrayOfString = this.e;
      int i1 = arrayOfString.length;
      while (n < i1)
      {
        str = arrayOfString[n];
        if (!this.f.contains(str)) {
          break label65;
        }
        n += 1;
      }
      str = null;
      label65:
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      this.g = str;
      return this.g;
    }
    String str = dm.b(this.k, "cbG9jaXA", "last_ip", null);
    if ((!TextUtils.isEmpty(str)) && (!this.f.contains(str)))
    {
      this.g = str;
      this.h = this.g;
      this.l = true;
    }
    return this.g;
  }
  
  public final String a(dc paramdc)
  {
    if (paramdc != null) {}
    for (;;)
    {
      String str2;
      try
      {
        String str3 = paramdc.c();
        str2 = new URL(str3).getHost();
        if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(str3))
        {
          if ("abroad.apilocate.amap.com".equals(str2)) {
            return null;
          }
          if (!"apilocate.amap.com".equalsIgnoreCase(str2)) {
            break label111;
          }
          str1 = "httpdns.apilocate.amap.com";
          String str4 = c();
          if (!TextUtils.isEmpty(str4))
          {
            paramdc.g = str3.replace(str2, str4);
            paramdc.b().put("host", str1);
            paramdc.b(str1);
            return str4;
          }
        }
        return null;
      }
      catch (Throwable paramdc)
      {
        return null;
      }
      label111:
      String str1 = str2;
    }
  }
  
  public final void a()
  {
    if (!this.c)
    {
      this.f.add(this.g);
      b();
      b(true);
      return;
    }
    b();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if ((this.c) && (!TextUtils.isEmpty(this.g)) && (!this.g.equals(this.h)))
    {
      this.h = this.g;
      dm.a(this.k, "cbG9jaXA", "last_ip", this.h);
      this.l = true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */