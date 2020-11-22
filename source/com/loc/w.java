package com.loc;

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

public final class w
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
  
  public static v a()
    throws k
  {
    return new v.a("collection", "1.0", "AMap_collection_1.0").a(new String[] { "com.amap.api.collection" }).a();
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
          ag.a(localThrowable, "ut", "gct");
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
          if (localObject1.length > 0) {
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
                  if (paramContext.length > 0) {
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
        ag.a(paramContext, "ut", "gct_p");
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
    //   40: ifnull +17 -> 57
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: astore_3
    //   48: aload_0
    //   49: aload 4
    //   51: invokevirtual 203	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   54: goto -25 -> 29
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: astore_3
    //   62: aload_2
    //   63: invokevirtual 208	java/lang/Object:toString	()Ljava/lang/String;
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 213	java/io/Writer:close	()V
    //   71: goto +8 -> 79
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   79: aload 4
    //   81: invokevirtual 214	java/io/PrintWriter:close	()V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_1
    //   94: aload 4
    //   96: astore_0
    //   97: aload_1
    //   98: astore 4
    //   100: goto +32 -> 132
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_2
    //   107: astore_1
    //   108: goto +67 -> 175
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_0
    //   115: goto +17 -> 132
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_3
    //   123: goto +52 -> 175
    //   126: astore 4
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: astore_3
    //   136: aload 4
    //   138: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_2
    //   146: invokevirtual 213	java/io/Writer:close	()V
    //   149: goto +8 -> 157
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   157: aload_0
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: invokevirtual 214	java/io/PrintWriter:close	()V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aload_1
    //   176: ifnull +15 -> 191
    //   179: aload_1
    //   180: invokevirtual 213	java/io/Writer:close	()V
    //   183: goto +8 -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   191: aload_3
    //   192: ifnull +15 -> 207
    //   195: aload_3
    //   196: invokevirtual 214	java/io/PrintWriter:close	()V
    //   199: goto +8 -> 207
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   207: aload_0
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramThrowable	Throwable
    //   19	40	1	localStringWriter1	java.io.StringWriter
    //   74	2	1	localThrowable1	Throwable
    //   86	2	1	localThrowable2	Throwable
    //   93	5	1	localThrowable3	Throwable
    //   107	27	1	localStringWriter2	java.io.StringWriter
    //   152	28	1	localThrowable4	Throwable
    //   186	2	1	localThrowable5	Throwable
    //   202	2	1	localThrowable6	Throwable
    //   7	139	2	localStringWriter3	java.io.StringWriter
    //   22	174	3	localObject1	Object
    //   16	83	4	localObject2	Object
    //   111	1	4	localThrowable7	Throwable
    //   126	11	4	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	71	74	java/lang/Throwable
    //   79	84	86	java/lang/Throwable
    //   23	29	93	java/lang/Throwable
    //   34	39	93	java/lang/Throwable
    //   48	54	93	java/lang/Throwable
    //   62	67	93	java/lang/Throwable
    //   8	18	103	finally
    //   8	18	111	java/lang/Throwable
    //   0	8	118	finally
    //   0	8	126	java/lang/Throwable
    //   145	149	152	java/lang/Throwable
    //   161	165	167	java/lang/Throwable
    //   23	29	174	finally
    //   34	39	174	finally
    //   48	54	174	finally
    //   62	67	174	finally
    //   136	141	174	finally
    //   179	183	186	java/lang/Throwable
    //   195	199	202	java/lang/Throwable
  }
  
  public static String a(Map<String, String> paramMap)
  {
    if (paramMap.size() == 0) {
      return null;
    }
    localStringBuffer = new StringBuffer();
    int i = 1;
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        if (i != 0)
        {
          i = 0;
          localStringBuffer.append((String)paramMap.getKey());
          localStringBuffer.append("=");
        }
        for (paramMap = (String)paramMap.getValue();; paramMap = (String)paramMap.getValue())
        {
          localStringBuffer.append(paramMap);
          break;
          localStringBuffer.append("&");
          localStringBuffer.append((String)paramMap.getKey());
          localStringBuffer.append("=");
        }
      }
      return localStringBuffer.toString();
    }
    catch (Throwable paramMap)
    {
      ag.a(paramMap, "ut", "abP");
    }
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
    String str4 = l.e(paramContext);
    String str6 = s.b(str4);
    String str2 = "";
    String str1 = "";
    localObject2 = "";
    String str5 = l.a(paramContext);
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
        paramContext = new StringBuilder("请在高德开放平台官网中搜索\"");
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
          break label507;
        }
        localObject2 = paramContext;
        localObject1 = paramContext;
        if (str6.equals(localObject3)) {
          break label507;
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
    Log.i("authErrLog", a);
    Log.i("authErrLog", "                                   鉴权错误信息                                  ");
    Log.i("authErrLog", a);
    localObject1 = new StringBuilder("SHA1Package:");
    ((StringBuilder)localObject1).append(str4);
    e(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder("key:");
    ((StringBuilder)localObject1).append(str5);
    e(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder("csid:");
    ((StringBuilder)localObject1).append(paramString1);
    e(((StringBuilder)localObject1).toString());
    paramString1 = new StringBuilder("gsid:");
    paramString1.append(paramString2);
    e(paramString1.toString());
    paramString1 = new StringBuilder("json:");
    paramString1.append(paramJSONObject.toString());
    e(paramString1.toString());
    Log.i("authErrLog", "                                                                               ");
    Log.i("authErrLog", paramContext);
    Log.i("authErrLog", a);
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
      if (i == 255) {
        paramByteArrayOutputStream.write(paramArrayOfByte, 0, 255);
      }
      return;
    }
    catch (IOException paramByteArrayOutputStream)
    {
      ag.a(paramByteArrayOutputStream, "ut", "wFie");
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
    return af.a(paramContext, paramBoolean);
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
  
  public static v b()
    throws k
  {
    return new v.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[] { "com.amap.co", "com.amap.opensdk.co", "com.amap.location" }).a();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = q.c(a(paramString));
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
      paramMap = localStringBuilder.toString();
    }
    else
    {
      paramMap = null;
    }
    return d(paramMap);
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
      ag.a(paramArrayOfByte, "ut", "gZp");
    }
    return new byte[0];
  }
  
  public static String c(String paramString)
  {
    if (paramString.length() < 2) {
      return "";
    }
    return q.a(paramString.substring(1));
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
      arrayOfString = new StringBuffer(new String(q.b(new String(arrayOfByte)))).reverse().toString().split(",");
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
      ag.a(localThrowable, "ut", "gIV");
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
    //   11: new 362	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 486	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_1
    //   19: new 488	java/util/zip/ZipOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 491	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 4
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: new 493	java/util/zip/ZipEntry
    //   39: dup
    //   40: ldc_w 495
    //   43: invokespecial 496	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 500	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   49: aload_1
    //   50: astore_2
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: aload_0
    //   57: invokevirtual 501	java/util/zip/ZipOutputStream:write	([B)V
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: invokevirtual 504	java/util/zip/ZipOutputStream:closeEntry	()V
    //   70: aload_1
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: invokevirtual 507	java/util/zip/ZipOutputStream:finish	()V
    //   80: aload_1
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: aload_1
    //   86: invokevirtual 510	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: astore_0
    //   90: aload 4
    //   92: invokevirtual 511	java/util/zip/ZipOutputStream:close	()V
    //   95: goto +13 -> 108
    //   98: astore_2
    //   99: aload_2
    //   100: ldc -118
    //   102: ldc_w 513
    //   105: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 514	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_0
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: ldc -118
    //   118: ldc_w 516
    //   121: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
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
    //   171: ldc_w 518
    //   174: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: ifnull +20 -> 198
    //   181: aload_0
    //   182: invokevirtual 511	java/util/zip/ZipOutputStream:close	()V
    //   185: goto +13 -> 198
    //   188: astore_0
    //   189: aload_0
    //   190: ldc -118
    //   192: ldc_w 513
    //   195: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_1
    //   199: ifnull +20 -> 219
    //   202: aload_1
    //   203: invokevirtual 514	java/io/ByteArrayOutputStream:close	()V
    //   206: goto +13 -> 219
    //   209: astore_0
    //   210: aload_0
    //   211: ldc -118
    //   213: ldc_w 516
    //   216: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: ifnull +20 -> 245
    //   228: aload_3
    //   229: invokevirtual 511	java/util/zip/ZipOutputStream:close	()V
    //   232: goto +13 -> 245
    //   235: astore_2
    //   236: aload_2
    //   237: ldc -118
    //   239: ldc_w 513
    //   242: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_1
    //   246: ifnull +20 -> 266
    //   249: aload_1
    //   250: invokevirtual 514	java/io/ByteArrayOutputStream:close	()V
    //   253: goto +13 -> 266
    //   256: astore_1
    //   257: aload_1
    //   258: ldc -118
    //   260: ldc_w 516
    //   263: invokestatic 145	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static String d(String paramString)
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
      ag.a(localThrowable, "ut", "sPa");
    }
    return paramString;
  }
  
  /* Error */
  static java.security.PublicKey d()
    throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, IOException
  {
    // Byte code:
    //   0: new 539	java/io/ByteArrayInputStream
    //   3: dup
    //   4: ldc_w 541
    //   7: invokestatic 483	com/loc/q:b	(Ljava/lang/String;)[B
    //   10: invokespecial 542	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: ldc_w 544
    //   19: invokestatic 550	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   22: astore_3
    //   23: aload_1
    //   24: astore_0
    //   25: ldc_w 552
    //   28: invokestatic 557	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 561	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +46 -> 87
    //   44: aload_2
    //   45: ifnonnull +6 -> 51
    //   48: goto +39 -> 87
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: new 563	java/security/spec/X509EncodedKeySpec
    //   57: dup
    //   58: aload_3
    //   59: invokevirtual 568	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   62: invokeinterface 573 1 0
    //   67: invokespecial 574	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   70: invokevirtual 578	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 581	java/io/InputStream:close	()V
    //   78: aload_2
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   85: aload_2
    //   86: areturn
    //   87: aload_1
    //   88: invokevirtual 581	java/io/InputStream:close	()V
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
    //   124: invokevirtual 581	java/io/InputStream:close	()V
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
    //   146: invokevirtual 581	java/io/InputStream:close	()V
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
      ag.a(paramArrayOfByte, "ut", "h2s");
    }
    return null;
  }
  
  private static void e(String paramString)
  {
    for (;;)
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
        Log.i("authErrLog", ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = paramString.substring(0, 78);
      StringBuilder localStringBuilder = new StringBuilder("|");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      Log.i("authErrLog", localStringBuilder.toString());
      paramString = paramString.substring(78);
    }
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
  
  private static String g(byte[] paramArrayOfByte)
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
        localObject = new StringBuilder("0");
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      i += 1;
    }
    return localStringBuilder.toString();
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
    //   11: new 362	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 486	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_1
    //   19: new 601	java/util/zip/GZIPOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 602	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 603	java/util/zip/GZIPOutputStream:write	([B)V
    //   33: aload_2
    //   34: invokevirtual 604	java/util/zip/GZIPOutputStream:finish	()V
    //   37: aload_1
    //   38: invokevirtual 510	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 605	java/util/zip/GZIPOutputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 514	java/io/ByteArrayOutputStream:close	()V
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
    //   109: invokevirtual 605	java/util/zip/GZIPOutputStream:close	()V
    //   112: goto +6 -> 118
    //   115: astore_0
    //   116: aload_0
    //   117: athrow
    //   118: aload_1
    //   119: ifnull +13 -> 132
    //   122: aload_1
    //   123: invokevirtual 514	java/io/ByteArrayOutputStream:close	()V
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */