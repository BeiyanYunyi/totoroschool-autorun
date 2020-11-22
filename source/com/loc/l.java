package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public final class l
{
  static String a;
  static boolean b = false;
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static String f = "";
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = h(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return f;
  }
  
  static void a(Context paramContext, final String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    f = paramString;
    if (paramContext != null) {
      aj.d().submit(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore 4
          //   3: aconst_null
          //   4: astore_2
          //   5: aload_2
          //   6: astore_1
          //   7: new 27	java/io/File
          //   10: dup
          //   11: aload_0
          //   12: getfield 16	com/loc/l$1:a	Landroid/content/Context;
          //   15: ldc 29
          //   17: invokestatic 35	com/loc/ah:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
          //   20: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
          //   23: astore_3
          //   24: aload_2
          //   25: astore_1
          //   26: aload_3
          //   27: invokevirtual 42	java/io/File:getParentFile	()Ljava/io/File;
          //   30: invokevirtual 46	java/io/File:exists	()Z
          //   33: ifne +13 -> 46
          //   36: aload_2
          //   37: astore_1
          //   38: aload_3
          //   39: invokevirtual 42	java/io/File:getParentFile	()Ljava/io/File;
          //   42: invokevirtual 49	java/io/File:mkdirs	()Z
          //   45: pop
          //   46: aload_2
          //   47: astore_1
          //   48: new 51	java/io/FileOutputStream
          //   51: dup
          //   52: aload_3
          //   53: invokespecial 54	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
          //   56: astore_2
          //   57: aload_2
          //   58: aload_0
          //   59: getfield 18	com/loc/l$1:b	Ljava/lang/String;
          //   62: invokestatic 59	com/loc/w:a	(Ljava/lang/String;)[B
          //   65: invokevirtual 63	java/io/FileOutputStream:write	([B)V
          //   68: aload_2
          //   69: invokevirtual 66	java/io/FileOutputStream:close	()V
          //   72: return
          //   73: astore_1
          //   74: aload_1
          //   75: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
          //   78: return
          //   79: astore_1
          //   80: goto +46 -> 126
          //   83: astore_1
          //   84: aload_1
          //   85: astore_3
          //   86: goto +15 -> 101
          //   89: astore_3
          //   90: aload_1
          //   91: astore_2
          //   92: aload_3
          //   93: astore_1
          //   94: goto +32 -> 126
          //   97: astore_3
          //   98: aload 4
          //   100: astore_2
          //   101: aload_2
          //   102: astore_1
          //   103: aload_3
          //   104: ldc 71
          //   106: ldc 73
          //   108: invokestatic 78	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
          //   111: aload_2
          //   112: ifnull +13 -> 125
          //   115: aload_2
          //   116: invokevirtual 66	java/io/FileOutputStream:close	()V
          //   119: return
          //   120: astore_1
          //   121: aload_1
          //   122: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
          //   125: return
          //   126: aload_2
          //   127: ifnull +15 -> 142
          //   130: aload_2
          //   131: invokevirtual 66	java/io/FileOutputStream:close	()V
          //   134: goto +8 -> 142
          //   137: astore_2
          //   138: aload_2
          //   139: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
          //   142: aload_1
          //   143: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	144	0	this	1
          //   6	42	1	localObject1	Object
          //   73	2	1	localThrowable1	Throwable
          //   79	1	1	localObject2	Object
          //   83	8	1	localThrowable2	Throwable
          //   93	10	1	localObject3	Object
          //   120	23	1	localThrowable3	Throwable
          //   4	127	2	localObject4	Object
          //   137	2	2	localThrowable4	Throwable
          //   23	63	3	localObject5	Object
          //   89	4	3	localObject6	Object
          //   97	7	3	localThrowable5	Throwable
          //   1	98	4	localObject7	Object
          // Exception table:
          //   from	to	target	type
          //   68	72	73	java/lang/Throwable
          //   57	68	79	finally
          //   57	68	83	java/lang/Throwable
          //   7	24	89	finally
          //   26	36	89	finally
          //   38	46	89	finally
          //   48	57	89	finally
          //   103	111	89	finally
          //   7	24	97	java/lang/Throwable
          //   26	36	97	java/lang/Throwable
          //   38	46	97	java/lang/Throwable
          //   48	57	97	java/lang/Throwable
          //   115	119	120	java/lang/Throwable
          //   130	134	137	java/lang/Throwable
        }
      });
    }
  }
  
  public static void a(String paramString)
  {
    d = paramString;
  }
  
  static boolean a()
  {
    try
    {
      if (b) {
        return true;
      }
      if (b(a))
      {
        b = true;
        return true;
      }
      if (!TextUtils.isEmpty(a))
      {
        b = false;
        a = null;
        return false;
      }
      if (b(d))
      {
        b = true;
        return true;
      }
      if (!TextUtils.isEmpty(d))
      {
        b = false;
        d = null;
        return false;
      }
      return true;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      if (!"".equals(c)) {
        return c;
      }
      PackageManager localPackageManager = paramContext.getPackageManager();
      c = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "AI", "gAN");
    }
    return c;
  }
  
  private static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString.toCharArray();
      char[] arrayOfChar = paramString.toCharArray();
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfChar[i];
        if (((65 > k) || (k > 122)) && ((48 > k) || (k > 58)) && (k != 46)) {}
        try
        {
          aj.b(w.a(), paramString, "errorPackage");
          return false;
        }
        catch (Throwable paramString) {}
        i += 1;
      }
      return true;
    }
    else
    {
      return false;
    }
    return false;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      if ((d != null) && (!"".equals(d))) {
        return d;
      }
      String str = paramContext.getPackageName();
      d = str;
      if (!b(str)) {
        d = paramContext.getPackageName();
      }
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "AI", "gpck");
    }
    return d;
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      if (!"".equals(e)) {
        return e;
      }
      e = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "AI", "gAV");
    }
    if (e == null) {
      return "";
    }
    return e;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      Object localObject = localPackageInfo.signatures;
      int i = 0;
      localObject = localObject[0].toByteArray();
      localObject = MessageDigest.getInstance("SHA1").digest((byte[])localObject);
      StringBuffer localStringBuffer = new StringBuffer();
      while (i < localObject.length)
      {
        str = Integer.toHexString(localObject[i] & 0xFF).toUpperCase(Locale.US);
        if (str.length() == 1) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(str);
        localStringBuffer.append(":");
        i += 1;
      }
      String str = localPackageInfo.packageName;
      localObject = str;
      if (b(str)) {
        localObject = localPackageInfo.packageName;
      }
      if (!TextUtils.isEmpty(d)) {
        localObject = c(paramContext);
      }
      localStringBuffer.append((String)localObject);
      paramContext = localStringBuffer.toString();
      a = paramContext;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "AI", "gsp");
    }
    return a;
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = h(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "AI", "gKy");
    }
    return f;
  }
  
  /* Error */
  private static String g(Context paramContext)
  {
    // Byte code:
    //   0: new 198	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc -56
    //   7: invokestatic 205	com/loc/ah:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 210	java/io/File:exists	()Z
    //   18: ifne +6 -> 24
    //   21: ldc 14
    //   23: areturn
    //   24: new 212	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: invokevirtual 218	java/io/FileInputStream:available	()I
    //   39: newarray <illegal type>
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 222	java/io/FileInputStream:read	([B)I
    //   49: pop
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: invokestatic 225	com/loc/w:a	([B)Ljava/lang/String;
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: invokevirtual 175	java/lang/String:length	()I
    //   63: bipush 32
    //   65: if_icmpne +8 -> 73
    //   68: aload_2
    //   69: astore_0
    //   70: goto +6 -> 76
    //   73: ldc 14
    //   75: astore_0
    //   76: aload_1
    //   77: invokevirtual 228	java/io/FileInputStream:close	()V
    //   80: aload_0
    //   81: areturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 29	java/lang/Throwable:printStackTrace	()V
    //   87: aload_0
    //   88: areturn
    //   89: astore_2
    //   90: goto +12 -> 102
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: goto +62 -> 158
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: ldc 93
    //   107: ldc -26
    //   109: invokestatic 100	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: astore_0
    //   114: aload_3
    //   115: invokevirtual 210	java/io/File:exists	()Z
    //   118: ifeq +20 -> 138
    //   121: aload_1
    //   122: astore_0
    //   123: aload_3
    //   124: invokevirtual 233	java/io/File:delete	()Z
    //   127: pop
    //   128: goto +10 -> 138
    //   131: astore_2
    //   132: aload_1
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual 29	java/lang/Throwable:printStackTrace	()V
    //   138: aload_1
    //   139: ifnull +15 -> 154
    //   142: aload_1
    //   143: invokevirtual 228	java/io/FileInputStream:close	()V
    //   146: goto +8 -> 154
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 29	java/lang/Throwable:printStackTrace	()V
    //   154: ldc 14
    //   156: areturn
    //   157: astore_1
    //   158: aload_0
    //   159: ifnull +15 -> 174
    //   162: aload_0
    //   163: invokevirtual 228	java/io/FileInputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 29	java/lang/Throwable:printStackTrace	()V
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContext	Context
    //   32	45	1	localFileInputStream	java.io.FileInputStream
    //   82	2	1	localThrowable1	Throwable
    //   93	1	1	localObject1	Object
    //   101	42	1	localObject2	Object
    //   157	18	1	localObject3	Object
    //   41	28	2	localObject4	Object
    //   89	1	2	localThrowable2	Throwable
    //   99	6	2	localThrowable3	Throwable
    //   131	4	2	localThrowable4	Throwable
    //   13	111	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	80	82	java/lang/Throwable
    //   35	42	89	java/lang/Throwable
    //   44	50	89	java/lang/Throwable
    //   52	57	89	java/lang/Throwable
    //   59	68	89	java/lang/Throwable
    //   24	33	93	finally
    //   24	33	99	java/lang/Throwable
    //   114	121	131	java/lang/Throwable
    //   123	128	131	java/lang/Throwable
    //   142	146	149	java/lang/Throwable
    //   35	42	157	finally
    //   44	50	157	finally
    //   52	57	157	finally
    //   59	68	157	finally
    //   104	112	157	finally
    //   114	121	157	finally
    //   123	128	157	finally
    //   134	138	157	finally
    //   162	166	169	java/lang/Throwable
  }
  
  private static String h(Context paramContext)
    throws PackageManager.NameNotFoundException
  {
    if ((f == null) || (f.equals("")))
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localObject == null) || (((ApplicationInfo)localObject).metaData == null)) {
        break label75;
      }
      localObject = ((ApplicationInfo)localObject).metaData.getString("com.amap.api.v2.apikey");
      f = (String)localObject;
      if (localObject == null) {
        f = g(paramContext);
      }
    }
    return f;
    label75:
    return f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */