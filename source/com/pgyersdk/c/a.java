package com.pgyersdk.c;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.pgyersdk.f.f;
import java.io.File;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class a
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static String f = "";
  public static String g = "";
  public static String h = "";
  public static String i = "";
  public static String j = "";
  public static String k = "3.0.10";
  public static String l = "";
  public static String m = "PGYER_APPID";
  public static String n = "getting failed";
  public static String o = "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAkFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+WABnwAAAAL3RSTlMAMtw091D6Sy7fTTbjpioQBe2vJ8G5tY16ZlLy6MeCDc+bkoZ7c1NAOyGeg1w6Gpvp7nkAAAFwSURBVEjH7dbHcoMwFIXhA0ggMLiAe4+70877v10wDtHCmHCXmfCv2HwjXUaDQFvbX+kjdR/abppZL2ZFPeRtsl9sZ8Cp85DpAwgWTOrxmFNUF5ArjmpxyC4qi+gbvHBcjw2qmlN5QK5H/efYpYOKNOP7jl6ZSHA5L+6teJXhgIOEw2K/ZqB6IqypupgU2lMMIMGn4l3dNDI/txKsSa942HG4YAQJDkoLJKSGBEf0S2tCzgH0e5uGeE5VWs+/79ksts2wpt8pLRl8Pywb4cjO6/3M69BtggPadRVPkGBN5VmrIcHWonM7GxJsuDR23ggiPGJi19UQ4atPvpXzziHDO66X3NuzIcF9FSNTXKNLBhDiGY9AFjNR1JDisPjMr8ncSvGZe3weQ/qpAzEe8X1CqkkGiLHDPHd227kcz8j0DECA7Y3Rmxk8zTCU3lW2LkPpLWmbclxzPx+cug4cdOr+DOqLPTzvkrp1pRe0tf2LvgDo0C+Y+R4NZwAAAABJRU5ErkJggg==";
  private static int p = -1;
  
  private static int a(Context paramContext, PackageManager paramPackageManager)
  {
    try
    {
      paramContext = paramPackageManager.getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        int i1 = paramContext.getInt("buildNumber", 0);
        return i1;
      }
    }
    catch (Exception paramContext)
    {
      f.b("PgyerSDK", "Exception thrown when accessing the application info:");
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      int i2 = paramArrayOfByte[i1] & 0xFF;
      int i3 = i1 * 2;
      arrayOfChar2[i3] = arrayOfChar1[(i2 >>> 4)];
      arrayOfChar2[(i3 + 1)] = arrayOfChar1[(i2 & 0xF)];
      i1 += 1;
    }
    return new String(arrayOfChar2).replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 103	com/pgyersdk/f/l:c	()Z
    //   3: ifne +10 -> 13
    //   6: getstatic 105	com/pgyersdk/c/a:n	Ljava/lang/String;
    //   9: putstatic 107	com/pgyersdk/c/a:i	Ljava/lang/String;
    //   12: return
    //   13: aload_0
    //   14: ldc 109
    //   16: invokevirtual 113	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast 115	android/telephony/TelephonyManager
    //   22: astore_2
    //   23: new 117	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 8
    //   34: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 126	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   43: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_1
    //   52: new 117	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: ldc 8
    //   63: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual 132	android/telephony/TelephonyManager:getSimSerialNumber	()Ljava/lang/String;
    //   72: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_2
    //   81: new 117	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: ldc 8
    //   92: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_0
    //   97: invokevirtual 136	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: astore_0
    //   101: aload_3
    //   102: aload_0
    //   103: ldc -118
    //   105: invokestatic 144	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_3
    //   117: aload_2
    //   118: astore_0
    //   119: aload_3
    //   120: astore_2
    //   121: goto +39 -> 160
    //   124: astore_3
    //   125: aload_2
    //   126: astore_0
    //   127: aload_3
    //   128: astore_2
    //   129: goto +18 -> 147
    //   132: astore_0
    //   133: goto +7 -> 140
    //   136: astore_0
    //   137: ldc 8
    //   139: astore_1
    //   140: ldc 8
    //   142: astore_3
    //   143: aload_0
    //   144: astore_2
    //   145: aload_3
    //   146: astore_0
    //   147: aload_2
    //   148: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   151: getstatic 105	com/pgyersdk/c/a:n	Ljava/lang/String;
    //   154: putstatic 107	com/pgyersdk/c/a:i	Ljava/lang/String;
    //   157: ldc 8
    //   159: astore_2
    //   160: aload_1
    //   161: ldc 8
    //   163: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +32 -> 198
    //   169: new 150	java/util/UUID
    //   172: dup
    //   173: lconst_0
    //   174: aload_1
    //   175: invokevirtual 154	java/lang/String:hashCode	()I
    //   178: i2l
    //   179: bipush 32
    //   181: lshl
    //   182: aload_0
    //   183: invokevirtual 154	java/lang/String:hashCode	()I
    //   186: i2l
    //   187: lor
    //   188: invokespecial 157	java/util/UUID:<init>	(JJ)V
    //   191: invokevirtual 158	java/util/UUID:toString	()Ljava/lang/String;
    //   194: putstatic 107	com/pgyersdk/c/a:i	Ljava/lang/String;
    //   197: return
    //   198: new 150	java/util/UUID
    //   201: dup
    //   202: aload_2
    //   203: invokevirtual 154	java/lang/String:hashCode	()I
    //   206: i2l
    //   207: aload_1
    //   208: invokevirtual 154	java/lang/String:hashCode	()I
    //   211: i2l
    //   212: bipush 32
    //   214: lshl
    //   215: aload_0
    //   216: invokevirtual 154	java/lang/String:hashCode	()I
    //   219: i2l
    //   220: lor
    //   221: invokespecial 157	java/util/UUID:<init>	(JJ)V
    //   224: invokevirtual 158	java/util/UUID:toString	()Ljava/lang/String;
    //   227: putstatic 107	com/pgyersdk/c/a:i	Ljava/lang/String;
    //   230: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   30	178	1	localObject1	Object
    //   22	181	2	localObject2	Object
    //   59	61	3	localObject3	Object
    //   124	4	3	localException	Exception
    //   142	4	3	str	String
    // Exception table:
    //   from	to	target	type
    //   81	89	124	java/lang/Exception
    //   89	101	124	java/lang/Exception
    //   101	117	124	java/lang/Exception
    //   52	60	132	java/lang/Exception
    //   60	81	132	java/lang/Exception
    //   13	31	136	java/lang/Exception
    //   31	52	136	java/lang/Exception
  }
  
  public static boolean a()
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "/system/bin/";
    arrayOfString[1] = "/system/xbin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    int i1 = 0;
    try
    {
      while (i1 < arrayOfString.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[i1]);
        localStringBuilder.append("su");
        if (new File(localStringBuilder.toString()).exists())
        {
          p = 1;
          return true;
        }
        i1 += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    p = 0;
    i1 = p;
    if (i1 == 1) {
      return true;
    }
    if (i1 == 0) {}
    return false;
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      paramContext = new StringBuilder();
      paramContext.append(localDisplayMetrics.widthPixels);
      paramContext.append("x");
      paramContext.append(localDisplayMetrics.heightPixels);
      j = paramContext.toString();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    j = "resolution getting faild";
  }
  
  public static void c(Context paramContext)
  {
    e = Build.VERSION.RELEASE;
    f = Build.MODEL;
    g = Build.MANUFACTURER;
    g(paramContext);
    h(paramContext);
    e(paramContext);
    f(paramContext);
  }
  
  private static String d(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("HA");
    paramContext.append(Build.BOARD.length() % 10);
    paramContext.append(Build.BRAND.length() % 10);
    paramContext.append(Build.CPU_ABI.length() % 10);
    paramContext.append(Build.PRODUCT.length() % 10);
    String str = paramContext.toString();
    Object localObject = "";
    paramContext = (Context)localObject;
    if (Build.VERSION.SDK_INT >= 9) {}
    try
    {
      paramContext = Build.class.getField("SERIAL").get(null).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  private static void e(Context paramContext)
  {
    Object localObject = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((c != null) && (localObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(":");
      localStringBuilder.append(d(paramContext));
      localObject = localStringBuilder.toString();
    }
    try
    {
      paramContext = MessageDigest.getInstance("SHA-1");
      localObject = ((String)localObject).getBytes("UTF-8");
      paramContext.update((byte[])localObject, 0, localObject.length);
      h = a(paramContext.digest());
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static void f(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        a(paramContext);
        b(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        f.b("PgyerSDK", "Exception thrown then accessing the device info:");
        paramContext.printStackTrace();
      }
    }
  }
  
  private static void g(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getFilesDir();
        if (paramContext != null)
        {
          a = paramContext.getAbsolutePath();
          return;
        }
      }
      catch (Exception paramContext)
      {
        f.b("PgyerSDK", "Exception thrown when accessing the files dir:");
        paramContext.printStackTrace();
      }
    }
  }
  
  private static void h(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
        c = localPackageInfo.packageName;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localPackageInfo.versionCode);
        b = localStringBuilder.toString();
        d = localPackageInfo.versionName;
        int i1 = a(paramContext, localPackageManager);
        if ((i1 != 0) && (i1 > localPackageInfo.versionCode))
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          paramContext.append(i1);
          b = paramContext.toString();
          return;
        }
      }
      catch (Exception paramContext)
      {
        f.b("PgyerSDK", "Exception thrown when accessing the package info:");
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */