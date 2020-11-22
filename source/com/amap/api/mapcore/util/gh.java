package com.amap.api.mapcore.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class gh
{
  public static final String a = "/a/";
  static final String b = "b";
  static final String c = "c";
  static final String d = "d";
  public static final String e = "g";
  public static final String f = "h";
  public static final String g = "e";
  public static final String h = "f";
  public static final String i = "j";
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("AMSKLG_CFG", 0).getString(paramString, "");
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      ExecutorService localExecutorService = gk.d();
      if (localExecutorService != null)
      {
        if (localExecutorService.isShutdown()) {
          return;
        }
        localExecutorService.submit(new Runnable()
        {
          public void run()
          {
            try
            {
              ij.a(this.a);
              gl.b(this.a);
              gl.d(this.a);
              gl.c(this.a);
              io.a(this.a);
              im.a(this.a);
              return;
            }
            catch (Throwable localThrowable)
            {
              gk.c(localThrowable, "Lg", "proL");
              return;
            }
            catch (RejectedExecutionException localRejectedExecutionException) {}
          }
        });
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "Lg", "proL");
    }
  }
  
  @TargetApi(9)
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("AMSKLG_CFG", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.startsWith("at ")) && (paramString.contains("uncaughtException"));
  }
  
  static boolean a(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString != null) {
      if (paramString == null) {
        return false;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        paramString = paramString.split("\n");
        int k = paramString.length;
        j = 0;
        if (j < k)
        {
          if (!a(paramString[j])) {
            break label83;
          }
          return false;
        }
        k = paramString.length;
        j = 0;
        if (j < k)
        {
          boolean bool = b(paramArrayOfString, paramString[j].trim());
          if (bool) {
            return true;
          }
          j += 1;
          continue;
        }
        return false;
      }
      catch (Throwable paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
      return false;
      label83:
      j += 1;
    }
  }
  
  /* Error */
  static java.util.List<fv> b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: invokestatic 137	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   9: astore 4
    //   11: aload_3
    //   12: astore_1
    //   13: aload 4
    //   15: monitorenter
    //   16: aload_2
    //   17: astore_1
    //   18: new 139	com/amap/api/mapcore/util/gt
    //   21: dup
    //   22: aload_0
    //   23: iconst_0
    //   24: invokespecial 142	com/amap/api/mapcore/util/gt:<init>	(Landroid/content/Context;Z)V
    //   27: invokevirtual 145	com/amap/api/mapcore/util/gt:a	()Ljava/util/List;
    //   30: astore_0
    //   31: aload 4
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: astore_2
    //   37: goto +6 -> 43
    //   40: astore_2
    //   41: aload_1
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload 4
    //   47: monitorexit
    //   48: aload_0
    //   49: astore_1
    //   50: aload_2
    //   51: athrow
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   57: aload_1
    //   58: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    //   5	53	1	localObject1	Object
    //   3	14	2	localObject2	Object
    //   36	1	2	localObject3	Object
    //   40	11	2	localObject4	Object
    //   1	11	3	localObject5	Object
    //   9	37	4	localLooper	android.os.Looper
    // Exception table:
    //   from	to	target	type
    //   31	34	36	finally
    //   18	31	40	finally
    //   45	48	40	finally
    //   6	11	52	java/lang/Throwable
    //   13	16	52	java/lang/Throwable
    //   50	52	52	java/lang/Throwable
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("AMSKLG_CFG", 0).edit();
    paramContext.remove(paramString);
    paramContext.apply();
  }
  
  static boolean b(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString != null)
    {
      if (paramString == null) {
        return false;
      }
      try
      {
        int k = paramArrayOfString.length;
        int j = 0;
        while (j < k)
        {
          String str = paramArrayOfString[j];
          paramString = paramString.trim();
          if (paramString.startsWith("at "))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(".");
            if ((paramString.contains(localStringBuilder.toString())) && (paramString.endsWith(")")))
            {
              boolean bool = paramString.contains("uncaughtException");
              if (!bool) {
                return true;
              }
            }
          }
          j += 1;
        }
        return false;
      }
      catch (Throwable paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    return false;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(a);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */