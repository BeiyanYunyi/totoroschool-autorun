package com.pgyersdk.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.pgyersdk.PgyerProvider;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class a
{
  private static String a = "/sdkstat/launch";
  
  public static void a(Context paramContext)
  {
    b(paramContext);
  }
  
  public static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("agKey", com.pgyersdk.c.a.l);
    localHashMap.put("deviceId", com.pgyersdk.c.a.i);
    localHashMap.put("osType", "2");
    localHashMap.put("from", com.pgyersdk.c.a.f);
    localHashMap.put("deviceName", com.pgyersdk.c.a.g);
    localHashMap.put("osVersion", com.pgyersdk.c.a.e);
    localHashMap.put("sdkVersion", com.pgyersdk.c.a.k);
    localHashMap.put("_api_key", "305092bc73c180b55c26012a94809131");
    localHashMap.put("versionCode", com.pgyersdk.c.a.b);
    localHashMap.put("version", com.pgyersdk.c.a.d);
    localHashMap.put("deviceModel", com.pgyersdk.c.a.f);
    localHashMap.put("resolution", com.pgyersdk.c.a.j);
    if (com.pgyersdk.c.a.a()) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    localHashMap.put("jailBroken", localObject1);
    Object localObject1 = com.pgyersdk.d.a.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localObject1[1]);
    ((StringBuilder)localObject2).append(" / ");
    ((StringBuilder)localObject2).append(localObject1[0]);
    localHashMap.put("freeSapce", ((StringBuilder)localObject2).toString());
    if (com.pgyersdk.d.a.c())
    {
      localObject1 = com.pgyersdk.d.a.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localObject1[1]);
      ((StringBuilder)localObject2).append(" / ");
      ((StringBuilder)localObject2).append(localObject1[0]);
      localHashMap.put("freeSdc", ((StringBuilder)localObject2).toString());
    }
    localObject2 = com.pgyersdk.d.a.e(PgyerProvider.a);
    localObject1 = "";
    if (localObject2.length == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localObject2[1]);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(localObject2[0]);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localHashMap.put("freeRam", localObject1);
    localHashMap.put("battery", com.pgyersdk.d.a.a(PgyerProvider.a));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PgyerProvider.a.getResources().getConfiguration().orientation);
    ((StringBuilder)localObject1).append("");
    localHashMap.put("protrait", ((StringBuilder)localObject1).toString());
    localObject1 = "";
    localObject2 = com.pgyersdk.d.a.d(PgyerProvider.a);
    if (((Map)localObject2).containsKey("network_type")) {
      localObject1 = (String)((Map)localObject2).get("network_type");
    }
    localHashMap.put("network", localObject1);
    localHashMap.put("_appName", (String)PgyerProvider.a.getPackageManager().getApplicationLabel(PgyerProvider.a.getApplicationInfo()));
    localHashMap.put("_packageName", PgyerProvider.a.getPackageName());
    localHashMap.put("_language", PgyerProvider.a.getResources().getConfiguration().locale.getDisplayLanguage());
    return localHashMap;
  }
  
  public static void b(Context paramContext)
  {
    com.pgyersdk.f.a.a(new a());
  }
  
  public static class a
    extends AsyncTask<Void, Void, HashMap<String, String>>
  {
    HttpURLConnection a = null;
    HashMap<String, String> b = new HashMap();
    
    /* Error */
    protected HashMap<String, String> a(Void... paramVarArgs)
    {
      // Byte code:
      //   0: invokestatic 30	com/pgyersdk/a/a:b	()Ljava/util/Map;
      //   3: astore_1
      //   4: new 32	java/lang/StringBuilder
      //   7: dup
      //   8: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   11: astore_2
      //   12: aload_2
      //   13: ldc 35
      //   15: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   18: pop
      //   19: aload_2
      //   20: invokestatic 42	com/pgyersdk/a/a:a	()Ljava/lang/String;
      //   23: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: pop
      //   27: new 44	com/pgyersdk/f/d
      //   30: dup
      //   31: aload_2
      //   32: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   35: invokespecial 50	com/pgyersdk/f/d:<init>	(Ljava/lang/String;)V
      //   38: astore_2
      //   39: aload_0
      //   40: aload_2
      //   41: ldc 52
      //   43: invokevirtual 55	com/pgyersdk/f/d:a	(Ljava/lang/String;)Lcom/pgyersdk/f/d;
      //   46: aload_1
      //   47: getstatic 60	com/pgyersdk/PgyerProvider:a	Landroid/content/Context;
      //   50: aconst_null
      //   51: aconst_null
      //   52: invokevirtual 63	com/pgyersdk/f/d:a	(Ljava/util/Map;Landroid/content/Context;Ljava/io/File;Ljava/util/List;)Lcom/pgyersdk/f/d;
      //   55: invokevirtual 66	com/pgyersdk/f/d:a	()Ljava/net/HttpURLConnection;
      //   58: putfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   61: aload_0
      //   62: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   65: invokevirtual 71	java/net/HttpURLConnection:connect	()V
      //   68: aload_0
      //   69: getfield 23	com/pgyersdk/a/a$a:b	Ljava/util/HashMap;
      //   72: astore_1
      //   73: aload_1
      //   74: ldc 73
      //   76: aload_0
      //   77: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   80: invokevirtual 77	java/net/HttpURLConnection:getResponseCode	()I
      //   83: invokestatic 83	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   86: invokevirtual 87	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   89: pop
      //   90: aload_0
      //   91: getfield 23	com/pgyersdk/a/a$a:b	Ljava/util/HashMap;
      //   94: astore_1
      //   95: aload_1
      //   96: ldc 89
      //   98: aload_0
      //   99: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   102: invokestatic 94	com/pgyersdk/f/j:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
      //   105: invokevirtual 87	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   108: pop
      //   109: aload_0
      //   110: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   113: astore_1
      //   114: aload_1
      //   115: ifnull +28 -> 143
      //   118: goto +21 -> 139
      //   121: astore_1
      //   122: goto +26 -> 148
      //   125: astore_1
      //   126: aload_1
      //   127: invokevirtual 97	java/lang/Exception:printStackTrace	()V
      //   130: aload_0
      //   131: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   134: astore_1
      //   135: aload_1
      //   136: ifnull +7 -> 143
      //   139: aload_1
      //   140: invokevirtual 100	java/net/HttpURLConnection:disconnect	()V
      //   143: aload_0
      //   144: getfield 23	com/pgyersdk/a/a$a:b	Ljava/util/HashMap;
      //   147: areturn
      //   148: aload_0
      //   149: getfield 18	com/pgyersdk/a/a$a:a	Ljava/net/HttpURLConnection;
      //   152: astore_2
      //   153: aload_2
      //   154: ifnull +7 -> 161
      //   157: aload_2
      //   158: invokevirtual 100	java/net/HttpURLConnection:disconnect	()V
      //   161: aload_1
      //   162: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	this	a
      //   0	163	1	paramVarArgs	Void[]
      //   11	147	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	12	121	finally
      //   12	39	121	finally
      //   39	73	121	finally
      //   73	95	121	finally
      //   95	109	121	finally
      //   126	130	121	finally
      //   0	12	125	java/lang/Exception
      //   12	39	125	java/lang/Exception
      //   39	73	125	java/lang/Exception
      //   73	95	125	java/lang/Exception
      //   95	109	125	java/lang/Exception
    }
    
    protected void a(HashMap<String, String> paramHashMap)
    {
      super.onPostExecute(paramHashMap);
      com.pgyersdk.d.a.h(PgyerProvider.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */