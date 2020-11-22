package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class fw
{
  static String a;
  private static final String[] b = { "arm64-v8a", "x86_64" };
  private static final String[] c = { "arm", "x86" };
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 80)
    {
      localStringBuilder.append("=");
      i += 1;
    }
    a = localStringBuilder.toString();
  }
  
  public static fv a()
    throws fj
  {
    return new fv.a("collection", "1.0", "AMap_collection_1.0").a(new String[] { "com.amap.api.collection" }).a();
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.CHINA).format(new Date(paramLong));
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    Object localObject4;
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT < 28) {
        try
        {
          localObject2 = paramContext.getApplicationInfo();
          localObject4 = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
          ((Field)localObject4).setAccessible(true);
          localObject2 = (String)((Field)localObject4).get(localObject2);
        }
        catch (Throwable localThrowable)
        {
          gg.a(localThrowable, "ut", "gct");
          localObject3 = localObject1;
        }
      }
    }
    localObject1 = localObject3;
    if (Build.VERSION.SDK_INT >= 28)
    {
      Object localObject5 = localObject3;
      try
      {
        localObject1 = (String[])Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
        localObject4 = localObject3;
        if (localObject1 != null)
        {
          localObject4 = localObject3;
          localObject5 = localObject3;
          if (localObject1.length >= 1) {
            localObject4 = localObject1[0];
          }
        }
        localObject5 = localObject4;
        localObject1 = localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject5 = localObject4;
          localObject1 = localObject4;
          if (Arrays.asList(b).contains(localObject4))
          {
            localObject5 = localObject4;
            paramContext = paramContext.getApplicationInfo().nativeLibraryDir;
            localObject5 = localObject4;
            localObject1 = localObject4;
            if (!TextUtils.isEmpty(paramContext))
            {
              localObject5 = localObject4;
              paramContext = paramContext.substring(paramContext.lastIndexOf(File.separator) + 1);
              localObject5 = localObject4;
              localObject1 = localObject4;
              if (Arrays.asList(c).contains(paramContext))
              {
                localObject5 = localObject4;
                paramContext = (String[])Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);
                localObject1 = localObject4;
                if (paramContext != null)
                {
                  localObject5 = localObject4;
                  localObject1 = localObject4;
                  if (paramContext.length >= 1) {
                    localObject1 = paramContext[0];
                  }
                }
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        gg.a(paramContext, "ut", "gct_p");
        localObject1 = localObject5;
      }
    }
    paramContext = (Context)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramContext = Build.CPU_ABI;
    }
    return paramContext;
  }
  
  /* Error */
  public static String a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 194	java/io/StringWriter
    //   3: dup
    //   4: invokespecial 195	java/io/StringWriter:<init>	()V
    //   7: astore_2
    //   8: new 197	java/io/PrintWriter
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 200	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: aload 4
    //   22: astore_3
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 203	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: invokevirtual 207	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +27 -> 67
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: astore_3
    //   48: aload_0
    //   49: aload 4
    //   51: invokevirtual 203	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   54: aload_2
    //   55: astore_1
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 207	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   63: astore_0
    //   64: goto -25 -> 39
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 208	java/lang/Object:toString	()Ljava/lang/String;
    //   76: astore_0
    //   77: aload_2
    //   78: invokevirtual 213	java/io/Writer:close	()V
    //   81: goto +8 -> 89
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   89: aload 4
    //   91: invokevirtual 214	java/io/PrintWriter:close	()V
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   101: aload_0
    //   102: areturn
    //   103: astore_1
    //   104: aload 4
    //   106: astore_0
    //   107: aload_1
    //   108: astore 4
    //   110: goto +32 -> 142
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: goto +67 -> 185
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_0
    //   125: goto +17 -> 142
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore_3
    //   133: goto +52 -> 185
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_0
    //   142: aload_2
    //   143: astore_1
    //   144: aload_0
    //   145: astore_3
    //   146: aload 4
    //   148: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   151: aload_2
    //   152: ifnull +15 -> 167
    //   155: aload_2
    //   156: invokevirtual 213	java/io/Writer:close	()V
    //   159: goto +8 -> 167
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   167: aload_0
    //   168: ifnull +14 -> 182
    //   171: aload_0
    //   172: invokevirtual 214	java/io/PrintWriter:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aload_1
    //   186: ifnull +15 -> 201
    //   189: aload_1
    //   190: invokevirtual 213	java/io/Writer:close	()V
    //   193: goto +8 -> 201
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   201: aload_3
    //   202: ifnull +15 -> 217
    //   205: aload_3
    //   206: invokevirtual 214	java/io/PrintWriter:close	()V
    //   209: goto +8 -> 217
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   217: aload_0
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramThrowable	Throwable
    //   19	50	1	localStringWriter1	java.io.StringWriter
    //   84	2	1	localThrowable1	Throwable
    //   96	2	1	localThrowable2	Throwable
    //   103	5	1	localThrowable3	Throwable
    //   117	27	1	localStringWriter2	java.io.StringWriter
    //   162	28	1	localThrowable4	Throwable
    //   196	2	1	localThrowable5	Throwable
    //   212	2	1	localThrowable6	Throwable
    //   7	149	2	localStringWriter3	java.io.StringWriter
    //   22	184	3	localObject1	Object
    //   16	93	4	localObject2	Object
    //   121	1	4	localThrowable7	Throwable
    //   136	11	4	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	81	84	java/lang/Throwable
    //   89	94	96	java/lang/Throwable
    //   23	29	103	java/lang/Throwable
    //   34	39	103	java/lang/Throwable
    //   48	54	103	java/lang/Throwable
    //   59	64	103	java/lang/Throwable
    //   72	77	103	java/lang/Throwable
    //   8	18	113	finally
    //   8	18	121	java/lang/Throwable
    //   0	8	128	finally
    //   0	8	136	java/lang/Throwable
    //   155	159	162	java/lang/Throwable
    //   171	175	177	java/lang/Throwable
    //   23	29	184	finally
    //   34	39	184	finally
    //   48	54	184	finally
    //   59	64	184	finally
    //   72	77	184	finally
    //   146	151	184	finally
    //   189	193	196	java/lang/Throwable
    //   205	209	212	java/lang/Throwable
  }
  
  static String a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {}
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return new String(paramArrayOfByte);
    return "";
  }
  
  public static Method a(Class paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(c(paramString), paramVarArgs);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Object localObject3 = "";
    String str4 = fk.e(paramContext);
    String str6 = fs.b(str4);
    String str2 = "";
    String str1 = "";
    localObject2 = "";
    String str5 = fk.a(paramContext);
    String str3 = "";
    paramContext = (Context)localObject2;
    localObject1 = localObject2;
    try
    {
      if (paramJSONObject.has("info"))
      {
        localObject1 = localObject2;
        localObject3 = paramJSONObject.getString("info");
        localObject1 = localObject2;
        paramContext = new StringBuilder();
        localObject1 = localObject2;
        paramContext.append("请在高德开放平台官网中搜索\"");
        localObject1 = localObject2;
        paramContext.append((String)localObject3);
        localObject1 = localObject2;
        paramContext.append("\"相关内容进行解决");
        localObject1 = localObject2;
        paramContext = paramContext.toString();
      }
      localObject1 = paramContext;
      if ("INVALID_USER_SCODE".equals(localObject3))
      {
        localObject2 = str2;
        localObject1 = paramContext;
        if (paramJSONObject.has("sec_code"))
        {
          localObject1 = paramContext;
          localObject2 = paramJSONObject.getString("sec_code");
        }
        localObject3 = str1;
        localObject1 = paramContext;
        if (paramJSONObject.has("sec_code_debug"))
        {
          localObject1 = paramContext;
          localObject3 = paramJSONObject.getString("sec_code_debug");
        }
        localObject1 = paramContext;
        if (str6.equals(localObject2)) {
          break label520;
        }
        localObject2 = paramContext;
        localObject1 = paramContext;
        if (str6.equals(localObject3)) {
          break label520;
        }
      }
      else
      {
        localObject2 = paramContext;
        localObject1 = paramContext;
        if ("INVALID_USER_KEY".equals(localObject3))
        {
          localObject3 = str3;
          localObject1 = paramContext;
          if (paramJSONObject.has("key"))
          {
            localObject1 = paramContext;
            localObject3 = paramJSONObject.getString("key");
          }
          localObject2 = paramContext;
          localObject1 = paramContext;
          if (((String)localObject3).length() > 0)
          {
            localObject2 = paramContext;
            localObject1 = paramContext;
            if (!str5.equals(localObject3)) {
              paramContext = "请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决";
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        localObject2 = localObject1;
        continue;
        paramContext = "请在高德开放平台官网中搜索\"请求内容过长导致业务调用失败\"相关内容进行解决";
      }
    }
    paramContext = (Context)localObject2;
    h(a);
    h("                                   鉴权错误信息                                  ");
    h(a);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SHA1Package:");
    ((StringBuilder)localObject1).append(str4);
    g(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key:");
    ((StringBuilder)localObject1).append(str5);
    g(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("csid:");
    ((StringBuilder)localObject1).append(paramString1);
    g(((StringBuilder)localObject1).toString());
    paramString1 = new StringBuilder();
    paramString1.append("gsid:");
    paramString1.append(paramString2);
    g(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("json:");
    paramString1.append(paramJSONObject.toString());
    g(paramString1.toString());
    h("                                                                               ");
    h(paramContext);
    h(a);
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, byte paramByte, byte[] paramArrayOfByte)
  {
    try
    {
      paramByteArrayOutputStream.write(new byte[] { paramByte });
      int i = paramByte & 0xFF;
      if ((i < 255) && (i > 0))
      {
        paramByteArrayOutputStream.write(paramArrayOfByte);
        return;
      }
      if (i == 255)
      {
        paramByteArrayOutputStream.write(paramArrayOfByte, 0, 255);
        return;
      }
    }
    catch (IOException paramByteArrayOutputStream)
    {
      gg.a(paramByteArrayOutputStream, "ut", "wFie");
    }
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramByteArrayOutputStream.write(new byte[] { 0 });
        return;
      }
      catch (IOException paramByteArrayOutputStream)
      {
        paramByteArrayOutputStream.printStackTrace();
        return;
      }
    }
    int j = paramString.length();
    int i = j;
    if (j > 255) {
      i = 255;
    }
    a(paramByteArrayOutputStream, (byte)i, a(paramString));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramContext.checkCallingOrSelfPermission(paramString) != 0) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.getApplicationInfo().targetSdkVersion >= 23)) {}
    try
    {
      int i = ((Integer)paramContext.getClass().getMethod("checkSelfPermission", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString })).intValue();
      return i == 0;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return gm.a(paramContext, paramBoolean);
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    return (paramJSONObject != null) && (paramJSONObject.has(paramString));
  }
  
  public static byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return paramString.getBytes();
  }
  
  public static fv b()
    throws fj
  {
    return new fv.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[] { "com.amap.co", "com.amap.opensdk.co", "com.amap.location" }).a();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = fq.c(a(paramString));
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((char)(paramString.length() % 26 + 65));
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String b(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer;
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      localStringBuffer = new StringBuffer();
      int i = 1;
      try
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (i != 0)
          {
            i = 0;
            localStringBuffer.append((String)localEntry.getKey());
            localStringBuffer.append("=");
            localStringBuffer.append((String)localEntry.getValue());
          }
          else
          {
            localStringBuffer.append("&");
            localStringBuffer.append((String)localEntry.getKey());
            localStringBuffer.append("=");
            localStringBuffer.append((String)localEntry.getValue());
          }
        }
        return localStringBuffer.toString();
      }
      catch (Throwable paramMap)
      {
        gg.a(paramMap, "ut", "abP");
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo("com.android.vending", 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = h(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      gg.a(paramArrayOfByte, "ut", "gZp");
    }
    return new byte[0];
  }
  
  public static String c(String paramString)
  {
    if (paramString.length() < 2) {
      return "";
    }
    return fq.a(paramString.substring(1));
  }
  
  public static String c(Map<String, String> paramMap)
  {
    return d(a(paramMap));
  }
  
  public static byte[] c()
  {
    try
    {
      String[] arrayOfString = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
      byte[] arrayOfByte = new byte[arrayOfString.length];
      int j = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]);
        i += 1;
      }
      arrayOfString = new StringBuffer(new String(fq.b(new String(arrayOfByte)))).reverse().toString().split(",");
      arrayOfByte = new byte[arrayOfString.length];
      i = j;
      while (i < arrayOfString.length)
      {
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      gg.a(localThrowable, "ut", "gIV");
    }
    return new byte[16];
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +267 -> 268
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 345	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 482	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_1
    //   19: new 484	java/util/zip/ZipOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 487	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 4
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: new 489	java/util/zip/ZipEntry
    //   39: dup
    //   40: ldc_w 491
    //   43: invokespecial 492	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 496	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   49: aload_1
    //   50: astore_2
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: aload_0
    //   57: invokevirtual 497	java/util/zip/ZipOutputStream:write	([B)V
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: invokevirtual 500	java/util/zip/ZipOutputStream:closeEntry	()V
    //   70: aload_1
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: invokevirtual 503	java/util/zip/ZipOutputStream:finish	()V
    //   80: aload_1
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: aload_1
    //   86: invokevirtual 506	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: astore_0
    //   90: aload 4
    //   92: invokevirtual 507	java/util/zip/ZipOutputStream:close	()V
    //   95: goto +13 -> 108
    //   98: astore_2
    //   99: aload_2
    //   100: ldc -118
    //   102: ldc_w 509
    //   105: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 510	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_0
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: ldc -118
    //   118: ldc_w 512
    //   121: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: areturn
    //   126: astore_2
    //   127: aload 4
    //   129: astore_0
    //   130: aload_2
    //   131: astore 4
    //   133: goto +30 -> 163
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_3
    //   139: goto +85 -> 224
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_0
    //   146: goto +17 -> 163
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: astore_3
    //   154: goto +70 -> 224
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_0
    //   163: aload_1
    //   164: astore_2
    //   165: aload_0
    //   166: astore_3
    //   167: aload 4
    //   169: ldc -118
    //   171: ldc_w 514
    //   174: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: ifnull +20 -> 198
    //   181: aload_0
    //   182: invokevirtual 507	java/util/zip/ZipOutputStream:close	()V
    //   185: goto +13 -> 198
    //   188: astore_0
    //   189: aload_0
    //   190: ldc -118
    //   192: ldc_w 509
    //   195: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_1
    //   199: ifnull +20 -> 219
    //   202: aload_1
    //   203: invokevirtual 510	java/io/ByteArrayOutputStream:close	()V
    //   206: goto +13 -> 219
    //   209: astore_0
    //   210: aload_0
    //   211: ldc -118
    //   213: ldc_w 512
    //   216: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: ifnull +20 -> 245
    //   228: aload_3
    //   229: invokevirtual 507	java/util/zip/ZipOutputStream:close	()V
    //   232: goto +13 -> 245
    //   235: astore_2
    //   236: aload_2
    //   237: ldc -118
    //   239: ldc_w 509
    //   242: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_1
    //   246: ifnull +20 -> 266
    //   249: aload_1
    //   250: invokevirtual 510	java/io/ByteArrayOutputStream:close	()V
    //   253: goto +13 -> 266
    //   256: astore_1
    //   257: aload_1
    //   258: ldc -118
    //   260: ldc_w 512
    //   263: invokestatic 145	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: athrow
    //   268: aconst_null
    //   269: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramArrayOfByte	byte[]
    //   18	91	1	localByteArrayOutputStream1	ByteArrayOutputStream
    //   114	2	1	localThrowable1	Throwable
    //   151	99	1	localObject1	Object
    //   256	2	1	localThrowable2	Throwable
    //   30	52	2	localByteArrayOutputStream2	ByteArrayOutputStream
    //   98	2	2	localThrowable3	Throwable
    //   126	5	2	localThrowable4	Throwable
    //   164	59	2	localObject2	Object
    //   235	2	2	localThrowable5	Throwable
    //   33	196	3	localObject3	Object
    //   27	105	4	localObject4	Object
    //   142	1	4	localThrowable6	Throwable
    //   157	11	4	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   90	95	98	java/lang/Throwable
    //   108	112	114	java/lang/Throwable
    //   34	49	126	java/lang/Throwable
    //   54	60	126	java/lang/Throwable
    //   65	70	126	java/lang/Throwable
    //   75	80	126	java/lang/Throwable
    //   85	90	126	java/lang/Throwable
    //   19	29	136	finally
    //   19	29	142	java/lang/Throwable
    //   11	19	149	finally
    //   11	19	157	java/lang/Throwable
    //   181	185	188	java/lang/Throwable
    //   202	206	209	java/lang/Throwable
    //   34	49	221	finally
    //   54	60	221	finally
    //   65	70	221	finally
    //   75	80	221	finally
    //   85	90	221	finally
    //   167	177	221	finally
    //   228	232	235	java/lang/Throwable
    //   249	253	256	java/lang/Throwable
  }
  
  public static String d(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      Object localObject = paramString.split("&");
      Arrays.sort((Object[])localObject);
      StringBuffer localStringBuffer = new StringBuffer();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append(localObject[i]);
        localStringBuffer.append("&");
        i += 1;
      }
      localObject = localStringBuffer.toString();
      if (((String)localObject).length() > 1)
      {
        localObject = (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      gg.a(localThrowable, "ut", "sPa");
    }
    return paramString;
  }
  
  /* Error */
  static java.security.PublicKey d()
    throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, IOException
  {
    // Byte code:
    //   0: new 535	java/io/ByteArrayInputStream
    //   3: dup
    //   4: ldc_w 537
    //   7: invokestatic 479	com/amap/api/mapcore/util/fq:b	(Ljava/lang/String;)[B
    //   10: invokespecial 538	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: ldc_w 540
    //   19: invokestatic 546	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   22: astore_3
    //   23: aload_1
    //   24: astore_0
    //   25: ldc_w 548
    //   28: invokestatic 553	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 557	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +46 -> 87
    //   44: aload_2
    //   45: ifnonnull +6 -> 51
    //   48: goto +39 -> 87
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: new 559	java/security/spec/X509EncodedKeySpec
    //   57: dup
    //   58: aload_3
    //   59: invokevirtual 564	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   62: invokeinterface 569 1 0
    //   67: invokespecial 570	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   70: invokevirtual 574	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 577	java/io/InputStream:close	()V
    //   78: aload_2
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   85: aload_2
    //   86: areturn
    //   87: aload_1
    //   88: invokevirtual 577	java/io/InputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_2
    //   101: goto +12 -> 113
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: goto +34 -> 141
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: astore_0
    //   115: aload_2
    //   116: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   119: aload_1
    //   120: ifnull +14 -> 134
    //   123: aload_1
    //   124: invokevirtual 577	java/io/InputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_2
    //   137: aload_0
    //   138: astore_1
    //   139: aload_2
    //   140: astore_0
    //   141: aload_1
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: invokevirtual 577	java/io/InputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   157: aload_0
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	38	0	localObject1	Object
    //   80	2	0	localThrowable1	Throwable
    //   93	2	0	localThrowable2	Throwable
    //   104	1	0	localObject2	Object
    //   114	1	0	localObject3	Object
    //   129	9	0	localThrowable3	Throwable
    //   140	18	0	localObject4	Object
    //   13	133	1	localObject5	Object
    //   152	2	1	localThrowable4	Throwable
    //   31	55	2	localObject6	Object
    //   100	1	2	localThrowable5	Throwable
    //   110	6	2	localThrowable6	Throwable
    //   136	4	2	localObject7	Object
    //   22	37	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/lang/Throwable
    //   87	91	93	java/lang/Throwable
    //   16	23	100	java/lang/Throwable
    //   25	32	100	java/lang/Throwable
    //   34	40	100	java/lang/Throwable
    //   53	74	100	java/lang/Throwable
    //   0	14	104	finally
    //   0	14	110	java/lang/Throwable
    //   123	127	129	java/lang/Throwable
    //   16	23	136	finally
    //   25	32	136	finally
    //   34	40	136	finally
    //   53	74	136	finally
    //   115	119	136	finally
    //   145	149	152	java/lang/Throwable
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = h(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new byte[0];
  }
  
  static String e(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = g(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      gg.a(paramArrayOfByte, "ut", "h2s");
    }
    return null;
  }
  
  public static byte[] e(String paramString)
  {
    Object localObject = paramString;
    if (paramString.length() % 2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new byte[((String)localObject).length() / 2];
    int i = 0;
    while (i < paramString.length)
    {
      int j = i * 2;
      paramString[i] = ((byte)Integer.parseInt(((String)localObject).substring(j, j + 2), 16));
      i += 1;
    }
    return paramString;
  }
  
  static String f(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = g(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = fq.a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append(Build.VERSION.SDK_INT);
      boolean bool = paramString.contains(localStringBuilder.toString());
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static String g(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject = str;
      if (str.length() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('0');
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static void g(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (j < 78)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      while (i < 78 - paramString.length())
      {
        ((StringBuilder)localObject).append(" ");
        i += 1;
      }
      ((StringBuilder)localObject).append("|");
      h(((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramString.substring(0, 78);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    h(localStringBuilder.toString());
    g(paramString.substring(78));
  }
  
  private static void h(String paramString)
  {
    Log.i("authErrLog", paramString);
  }
  
  /* Error */
  private static byte[] h(byte[] paramArrayOfByte)
    throws IOException, Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 345	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 482	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_1
    //   19: new 616	java/util/zip/GZIPOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 617	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 618	java/util/zip/GZIPOutputStream:write	([B)V
    //   33: aload_2
    //   34: invokevirtual 619	java/util/zip/GZIPOutputStream:finish	()V
    //   37: aload_1
    //   38: invokevirtual 506	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 620	java/util/zip/GZIPOutputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 510	java/io/ByteArrayOutputStream:close	()V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: aload_0
    //   57: athrow
    //   58: astore_3
    //   59: aload_2
    //   60: astore_0
    //   61: aload_3
    //   62: astore_2
    //   63: goto +41 -> 104
    //   66: astore_3
    //   67: aload_2
    //   68: astore_0
    //   69: aload_3
    //   70: astore_2
    //   71: goto +13 -> 84
    //   74: astore_2
    //   75: aload 4
    //   77: astore_0
    //   78: goto +26 -> 104
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_0
    //   84: goto +17 -> 101
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload 4
    //   92: astore_0
    //   93: goto +11 -> 104
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: athrow
    //   103: astore_2
    //   104: aload_0
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: invokevirtual 620	java/util/zip/GZIPOutputStream:close	()V
    //   112: goto +6 -> 118
    //   115: astore_0
    //   116: aload_0
    //   117: athrow
    //   118: aload_1
    //   119: ifnull +13 -> 132
    //   122: aload_1
    //   123: invokevirtual 510	java/io/ByteArrayOutputStream:close	()V
    //   126: goto +6 -> 132
    //   129: astore_0
    //   130: aload_0
    //   131: athrow
    //   132: aload_2
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramArrayOfByte	byte[]
    //   18	105	1	localObject1	Object
    //   27	44	2	localObject2	Object
    //   74	1	2	localObject3	Object
    //   81	1	2	localThrowable1	Throwable
    //   87	1	2	localObject4	Object
    //   96	6	2	localThrowable2	Throwable
    //   103	30	2	localObject5	Object
    //   4	1	3	localObject6	Object
    //   58	4	3	localObject7	Object
    //   66	34	3	localThrowable3	Throwable
    //   1	90	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/lang/Throwable
    //   42	46	55	java/lang/Throwable
    //   28	42	58	finally
    //   28	42	66	java/lang/Throwable
    //   19	28	74	finally
    //   19	28	81	java/lang/Throwable
    //   11	19	87	finally
    //   11	19	96	java/lang/Throwable
    //   101	103	103	finally
    //   108	112	115	java/lang/Throwable
    //   122	126	129	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */