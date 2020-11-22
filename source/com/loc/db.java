package com.loc;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class db
{
  private static db b;
  bj a = null;
  private Context c = null;
  private int d = dg.f;
  private boolean e = false;
  private int f = 0;
  
  private db(Context paramContext)
  {
    try
    {
      r.a().a(paramContext);
      this.c = paramContext;
      this.a = bj.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static db a(Context paramContext)
  {
    if (b == null) {
      b = new db(paramContext);
    }
    return b;
  }
  
  public final int a()
  {
    return this.d;
  }
  
  public final bo a(dc paramdc)
    throws Throwable
  {
    boolean bool;
    if ((!this.e) && (!dn.k(this.c))) {
      bool = false;
    } else {
      bool = true;
    }
    return bj.a(paramdc, bool);
  }
  
  public final dc a(Context paramContext, byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new HashMap(16);
        dc localdc = new dc(paramContext, dg.b());
        String str;
        Object localObject2;
        continue;
      }
      catch (Throwable paramContext)
      {
        try
        {
          ((Map)localObject1).put("Content-Type", "application/octet-stream");
          ((Map)localObject1).put("Accept-Encoding", "gzip");
          ((Map)localObject1).put("gzipped", "1");
          ((Map)localObject1).put("Connection", "Keep-Alive");
          ((Map)localObject1).put("User-Agent", "AMAP_Location_SDK_Android 4.8.0");
          ((Map)localObject1).put("KEY", l.f(paramContext));
          ((Map)localObject1).put("enginever", "5.1");
          str = n.a();
          localObject2 = new StringBuilder("key=");
          ((StringBuilder)localObject2).append(l.f(paramContext));
          localObject2 = n.a(paramContext, str, ((StringBuilder)localObject2).toString());
          ((Map)localObject1).put("ts", str);
          ((Map)localObject1).put("scode", localObject2);
          ((Map)localObject1).put("encr", "1");
          localdc.f = ((Map)localObject1);
          localObject1 = "loc";
          if (!paramBoolean) {
            localObject1 = "locf";
          }
          localdc.m = true;
          localdc.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[] { "4.8.0", localObject1, Integer.valueOf(3) });
          localdc.j = paramBoolean;
          localdc.g = paramString;
          localdc.h = dn.a(paramArrayOfByte);
          localdc.a(t.a(paramContext));
          localObject1 = new HashMap(16);
          ((Map)localObject1).put("output", "bin");
          ((Map)localObject1).put("policy", "3103");
          switch (this.f)
          {
          case 0: 
            ((Map)localObject1).put("custom", paramArrayOfByte);
            continue;
            ((Map)localObject1).remove("custom");
            localdc.l = ((Map)localObject1);
            localdc.a(this.d);
            localdc.b(this.d);
            if (!this.e)
            {
              paramArrayOfByte = localdc;
              if (!dn.k(paramContext)) {}
            }
            else
            {
              paramArrayOfByte = localdc;
              if (paramString.startsWith("http:"))
              {
                localdc.g = localdc.c().replace("https:", "https:");
                return localdc;
                paramArrayOfByte = null;
              }
            }
            return paramArrayOfByte;
          }
        }
        catch (Throwable paramContext)
        {
          return localdc;
        }
        paramContext = paramContext;
        continue;
      }
      paramArrayOfByte = "language:en";
      continue;
      paramArrayOfByte = "language:cn";
    }
  }
  
  public final String a(Context paramContext, double paramDouble1, double paramDouble2)
  {
    try
    {
      HashMap localHashMap1 = new HashMap(16);
      dc localdc = new dc(paramContext, dg.b());
      localHashMap1.clear();
      localHashMap1.put("Content-Type", "application/x-www-form-urlencoded");
      localHashMap1.put("Connection", "Keep-Alive");
      localHashMap1.put("User-Agent", "AMAP_Location_SDK_Android 4.8.0");
      HashMap localHashMap2 = new HashMap(16);
      localHashMap2.put("custom", "26260A1F00020002");
      localHashMap2.put("key", l.f(paramContext));
      switch (this.f)
      {
      case 0: 
        localHashMap2.put("language", localObject);
        break label161;
        localHashMap2.remove("language");
        label161:
        localObject = n.a();
        String str = n.a(paramContext, (String)localObject, w.b(localHashMap2));
        localHashMap2.put("ts", localObject);
        localHashMap2.put("scode", str);
        localObject = new StringBuilder("output=json&radius=1000&extensions=all&location=");
        ((StringBuilder)localObject).append(paramDouble2);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramDouble1);
        localdc.b(((StringBuilder)localObject).toString().getBytes("UTF-8"));
        localdc.m = false;
        localdc.j = true;
        localdc.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[] { "4.8.0", "loc", Integer.valueOf(3) });
        localdc.l = localHashMap2;
        localdc.f = localHashMap1;
        localdc.a(t.a(paramContext));
        localdc.a(dg.f);
        localdc.b(dg.f);
        try
        {
          if (dn.k(paramContext))
          {
            localdc.g = "http://restapi.amap.com/v3/geocode/regeo".replace("http:", "https:");
            paramContext = bj.a(localdc);
          }
          else
          {
            localdc.g = "http://restapi.amap.com/v3/geocode/regeo";
            paramContext = bj.b(localdc);
          }
          paramContext = new String(paramContext, "utf-8");
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          dg.a(paramContext, "LocNetManager", "post");
          return null;
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        continue;
        continue;
        Object localObject = "en";
        continue;
        localObject = "zh-CN";
      }
    }
  }
  
  /* Error */
  public final void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: putfield 36	com/loc/db:e	Z
    //   5: invokestatic 42	com/loc/r:a	()Lcom/loc/r;
    //   8: iload_3
    //   9: invokevirtual 300	com/loc/r:a	(Z)V
    //   12: aload_0
    //   13: lload_1
    //   14: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   17: invokevirtual 308	java/lang/Long:intValue	()I
    //   20: putfield 34	com/loc/db:d	I
    //   23: aload_0
    //   24: iload 4
    //   26: putfield 37	com/loc/db:f	I
    //   29: return
    //   30: astore 5
    //   32: aload 5
    //   34: ldc_w 287
    //   37: ldc_w 310
    //   40: invokestatic 292	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   43: return
    //   44: astore 5
    //   46: goto -34 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	db
    //   0	49	1	paramLong	long
    //   0	49	3	paramBoolean	boolean
    //   0	49	4	paramInt	int
    //   30	3	5	localThrowable1	Throwable
    //   44	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	5	30	java/lang/Throwable
    //   12	29	30	java/lang/Throwable
    //   5	12	44	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */