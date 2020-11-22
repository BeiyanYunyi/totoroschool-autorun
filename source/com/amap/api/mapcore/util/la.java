package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class la
{
  private static la b;
  hx a = null;
  private Context c = null;
  private int d = 0;
  private int e = lf.f;
  private boolean f = false;
  private int g = 0;
  
  private la(Context paramContext)
  {
    try
    {
      fr.a().a(paramContext);
      this.c = paramContext;
      this.a = hx.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static la a(Context paramContext)
  {
    if (b == null) {
      b = new la(paramContext);
    }
    return b;
  }
  
  public final ie a(lb paramlb)
    throws Throwable
  {
    long l = lj.b();
    boolean bool;
    if ((!this.f) && (!lj.e(this.c))) {
      bool = false;
    } else {
      bool = true;
    }
    paramlb = this.a.a(paramlb, bool);
    this.d = Long.valueOf(lj.b() - l).intValue();
    return paramlb;
  }
  
  public final lb a(Context paramContext, byte[] paramArrayOfByte, String paramString)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap(16);
        lb locallb = new lb(paramContext, lf.b());
        String str;
        Object localObject;
        continue;
      }
      catch (Throwable paramContext)
      {
        try
        {
          localHashMap.put("Content-Type", "application/octet-stream");
          localHashMap.put("Accept-Encoding", "gzip");
          localHashMap.put("gzipped", "1");
          localHashMap.put("Connection", "Keep-Alive");
          localHashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.7.0");
          localHashMap.put("KEY", fk.f(paramContext));
          localHashMap.put("enginever", "5.1");
          str = fn.a();
          localObject = new StringBuilder("key=");
          ((StringBuilder)localObject).append(fk.f(paramContext));
          localObject = fn.a(paramContext, str, ((StringBuilder)localObject).toString());
          localHashMap.put("ts", str);
          localHashMap.put("scode", localObject);
          localHashMap.put("encr", "1");
          locallb.b(localHashMap);
          locallb.k();
          locallb.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[] { "4.7.0", "loc", Integer.valueOf(3) }));
          locallb.a();
          locallb.b(paramString);
          locallb.b(lj.a(paramArrayOfByte));
          locallb.setProxy(ft.a(paramContext));
          localHashMap = new HashMap(16);
          localHashMap.put("output", "bin");
          localHashMap.put("policy", "3103");
          switch (this.g)
          {
          case 0: 
            localHashMap.put("custom", paramArrayOfByte);
            continue;
            localHashMap.remove("custom");
            locallb.a(localHashMap);
            locallb.setConnectionTimeout(this.e);
            locallb.setSoTimeout(this.e);
            if (!this.f)
            {
              paramArrayOfByte = locallb;
              if (!lj.e(paramContext)) {}
            }
            else
            {
              paramArrayOfByte = locallb;
              if (paramString.startsWith("http:"))
              {
                locallb.b(locallb.getURL().replace("https:", "https:"));
                return locallb;
                paramArrayOfByte = null;
              }
            }
            return paramArrayOfByte;
          }
        }
        catch (Throwable paramContext)
        {
          return locallb;
        }
        paramContext = paramContext;
        continue;
      }
      paramArrayOfByte = "language:en";
      continue;
      paramArrayOfByte = "language:cn";
    }
  }
  
  /* Error */
  public final void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: putfield 39	com/amap/api/mapcore/util/la:f	Z
    //   5: invokestatic 46	com/amap/api/mapcore/util/fr:a	()Lcom/amap/api/mapcore/util/fr;
    //   8: iload_3
    //   9: invokevirtual 255	com/amap/api/mapcore/util/fr:a	(Z)V
    //   12: aload_0
    //   13: lload_1
    //   14: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   17: invokevirtual 80	java/lang/Long:intValue	()I
    //   20: putfield 37	com/amap/api/mapcore/util/la:e	I
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 41	com/amap/api/mapcore/util/la:g	I
    //   28: return
    //   29: astore 4
    //   31: aload 4
    //   33: ldc_w 257
    //   36: ldc_w 259
    //   39: invokestatic 262	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   42: return
    //   43: astore 4
    //   45: goto -33 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	la
    //   0	48	1	paramLong	long
    //   0	48	3	paramBoolean	boolean
    //   29	3	4	localThrowable1	Throwable
    //   43	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	5	29	java/lang/Throwable
    //   12	28	29	java/lang/Throwable
    //   5	12	43	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */