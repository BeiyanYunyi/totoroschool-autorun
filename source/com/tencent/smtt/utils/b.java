package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  
  private static PackageInfo a(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = Class.forName("android.content.pm.PackageParser");
        Object localObject1 = ((Class)localObject2).getDeclaredClasses();
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label349;
        }
        localMethod1 = localObject1[i];
        if (localMethod1.getName().compareTo("android.content.pm.PackageParser$Package") == 0)
        {
          Object localObject3 = ((Class)localObject2).getConstructor(new Class[] { String.class });
          Method localMethod2 = ((Class)localObject2).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
          localObject1 = ((Class)localObject2).getDeclaredMethod("collectCertificates", new Class[] { localMethod1, Integer.TYPE });
          localMethod1 = ((Class)localObject2).getDeclaredMethod("generatePackageInfo", new Class[] { localMethod1, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE });
          ((Constructor)localObject3).setAccessible(true);
          localMethod2.setAccessible(true);
          ((Method)localObject1).setAccessible(true);
          localMethod1.setAccessible(true);
          localObject2 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
          localObject3 = new DisplayMetrics();
          ((DisplayMetrics)localObject3).setToDefaults();
          paramString = localMethod2.invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
          if (paramString == null) {
            return null;
          }
          if ((paramInt & 0x40) != 0) {
            ((Method)localObject1).invoke(localObject2, new Object[] { paramString, Integer.valueOf(0) });
          }
          paramString = (PackageInfo)localMethod1.invoke(null, new Object[] { paramString, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      i += 1;
      continue;
      label349:
      Method localMethod1 = null;
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: getstatic 112	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   3: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +7 -> 13
    //   9: getstatic 112	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   12: areturn
    //   13: new 120	java/io/InputStreamReader
    //   16: dup
    //   17: invokestatic 126	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: ldc -128
    //   22: invokevirtual 132	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   25: invokevirtual 138	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   28: invokespecial 141	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: new 143	java/io/BufferedReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_2
    //   43: aload_1
    //   44: astore_3
    //   45: aload_0
    //   46: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: ldc -105
    //   51: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +21 -> 75
    //   57: ldc -100
    //   59: astore 4
    //   61: aload_0
    //   62: astore_2
    //   63: aload_1
    //   64: astore_3
    //   65: aload 4
    //   67: invokestatic 159	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 4
    //   72: goto +17 -> 89
    //   75: aload_0
    //   76: astore_2
    //   77: aload_1
    //   78: astore_3
    //   79: ldc -95
    //   81: invokestatic 166	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 4
    //   86: goto -25 -> 61
    //   89: aload_0
    //   90: invokevirtual 169	java/io/BufferedReader:close	()V
    //   93: aload_1
    //   94: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   97: aload 4
    //   99: areturn
    //   100: astore 4
    //   102: goto +30 -> 132
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: goto +69 -> 177
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_0
    //   115: goto +17 -> 132
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_2
    //   123: goto +54 -> 177
    //   126: astore 4
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_0
    //   132: aload_0
    //   133: astore_2
    //   134: aload_1
    //   135: astore_3
    //   136: ldc -95
    //   138: invokestatic 166	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 159	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 5
    //   146: aload_0
    //   147: astore_2
    //   148: aload_1
    //   149: astore_3
    //   150: aload 4
    //   152: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 169	java/io/BufferedReader:close	()V
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   171: aload 5
    //   173: areturn
    //   174: astore_0
    //   175: aload_3
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 169	java/io/BufferedReader:close	()V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: goto -103 -> 93
    //   199: astore_0
    //   200: aload 4
    //   202: areturn
    //   203: astore_0
    //   204: goto -41 -> 163
    //   207: astore_0
    //   208: goto -37 -> 171
    //   211: astore_2
    //   212: goto -27 -> 185
    //   215: astore_1
    //   216: goto -23 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	50	0	localBufferedReader	java.io.BufferedReader
    //   105	1	0	localObject1	Object
    //   114	1	0	localObject2	Object
    //   118	1	0	localObject3	Object
    //   131	29	0	localObject4	Object
    //   174	20	0	localObject5	Object
    //   195	1	0	localIOException1	java.io.IOException
    //   199	1	0	localIOException2	java.io.IOException
    //   203	1	0	localIOException3	java.io.IOException
    //   207	1	0	localIOException4	java.io.IOException
    //   31	159	1	localObject6	Object
    //   215	1	1	localIOException5	java.io.IOException
    //   42	140	2	localObject7	Object
    //   211	1	2	localIOException6	java.io.IOException
    //   44	132	3	localObject8	Object
    //   59	39	4	str1	String
    //   100	1	4	localThrowable1	Throwable
    //   111	1	4	localThrowable2	Throwable
    //   126	75	4	localThrowable3	Throwable
    //   144	28	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   45	57	100	java/lang/Throwable
    //   65	72	100	java/lang/Throwable
    //   79	86	100	java/lang/Throwable
    //   32	41	105	finally
    //   32	41	111	java/lang/Throwable
    //   13	32	118	finally
    //   13	32	126	java/lang/Throwable
    //   45	57	174	finally
    //   65	72	174	finally
    //   79	86	174	finally
    //   136	146	174	finally
    //   150	155	174	finally
    //   89	93	195	java/io/IOException
    //   93	97	199	java/io/IOException
    //   159	163	203	java/io/IOException
    //   167	171	207	java/io/IOException
    //   181	185	211	java/io/IOException
    //   189	193	215	java/io/IOException
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String a(Context paramContext, File paramFile)
  {
    try
    {
      if (!paramContext.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
        break label47;
      }
      TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
      localObject1 = a(paramFile);
      if (localObject1 == null) {
        break label47;
      }
      TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
      return (String)localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      label47:
      Object localObject2;
      for (;;) {}
    }
    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
    localObject2 = a(paramContext, paramFile, false);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AppUtil.getSignatureFromApk]  android api signature=");
    ((StringBuilder)localObject1).append((String)localObject2);
    TbsLog.i("AppUtil", ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramFile);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[AppUtil.getSignatureFromApk]  java get signature=");
      ((StringBuilder)localObject2).append((String)localObject1);
      TbsLog.i("AppUtil", ((StringBuilder)localObject2).toString());
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = a(paramContext, paramFile, true);
      paramContext = new StringBuilder();
      paramContext.append("[AppUtil.getSignatureFromApk]  android reflection signature=");
      paramContext.append((String)localObject2);
      TbsLog.i("AppUtil", paramContext.toString());
    }
    return (String)localObject2;
  }
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramContext = a(paramFile.getAbsolutePath(), 65);
    } else {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
    }
    paramFile = null;
    if (paramContext != null)
    {
      if ((paramContext.signatures != null) && (paramContext.signatures.length > 0)) {
        paramContext = paramContext.signatures[0];
      } else {
        TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
      }
    }
    else {
      paramContext = null;
    }
    if (paramContext != null) {
      paramFile = paramContext.toCharsString();
    }
    return paramFile;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = String.valueOf(paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.get(paramString));
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    try
    {
      paramString = String.valueOf(Integer.toHexString(Integer.parseInt(paramContext)));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
    return paramContext;
  }
  
  private static String a(File paramFile)
  {
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[' '];
        String str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (localEnumeration.hasMoreElements())
        {
          paramFile = (JarEntry)localEnumeration.nextElement();
          String str2 = paramFile.getName();
          if (str2 == null) {
            continue;
          }
          paramFile = a(localJarFile, paramFile, arrayOfByte);
          if (paramFile != null)
          {
            paramFile = a(paramFile[0].getEncoded());
            if (paramFile == null)
            {
              if (str2.startsWith("META-INF/")) {
                continue;
              }
              return null;
            }
            boolean bool = paramFile.equals(str1);
            if (bool) {
              continue;
            }
            return null;
          }
        }
        else
        {
          return str1;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = null;
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    while (i < k)
    {
      int n = paramArrayOfByte[i];
      int j = n >> 4 & 0xF;
      int m = i * 2;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[m] = ((char)j);
      j = n & 0xF;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[(m + 1)] = ((char)j);
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public static String b()
  {
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return (String)localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return "02:00:00:00:00:00";
  }
  
  public static String c(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    if (TextUtils.isEmpty(d)) {
      if (Build.VERSION.SDK_INT < 23) {
        try
        {
          paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
          if (paramContext == null) {
            paramContext = null;
          } else {
            paramContext = paramContext.getConnectionInfo();
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    for (paramContext = paramContext.getMacAddress();; paramContext = "")
    {
      d = paramContext;
      break label74;
      d = b();
      label74:
      return d;
      if (paramContext != null) {
        break;
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */