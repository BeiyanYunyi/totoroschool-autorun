package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bc
{
  public static long a()
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      return localStatFs.getFreeBlocks() * l;
    }
    return 0L;
  }
  
  public static long a(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      return paramFile.length();
    }
    long l = 0L;
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return 0L;
    }
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        l += a(localFile);
      } else {
        l += localFile.length();
      }
      i += 1;
    }
    return l;
  }
  
  public static OfflineMapProvince a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return null;
    }
    OfflineMapProvince localOfflineMapProvince = new OfflineMapProvince();
    localOfflineMapProvince.setUrl(a(paramJSONObject, "url"));
    localOfflineMapProvince.setProvinceName(a(paramJSONObject, "name"));
    localOfflineMapProvince.setJianpin(a(paramJSONObject, "jianpin"));
    localOfflineMapProvince.setPinyin(a(paramJSONObject, "pinyin"));
    localOfflineMapProvince.setProvinceCode(d(a(paramJSONObject, "adcode")));
    localOfflineMapProvince.setVersion(a(paramJSONObject, "version"));
    localOfflineMapProvince.setSize(Long.parseLong(a(paramJSONObject, "size")));
    localOfflineMapProvince.setCityList(b(paramJSONObject));
    return localOfflineMapProvince;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = dx.a(dr.a(paramContext).open(paramString));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "MapDownloadManager", "readOfflineAsset");
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return "";
    }
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.has(paramString))
    {
      str1 = str2;
      if (!"[]".equals(paramJSONObject.getString(paramString))) {
        str1 = paramJSONObject.optString(paramString).trim();
      }
    }
    return str1;
  }
  
  public static List<OfflineMapProvince> a(String paramString, Context paramContext)
    throws JSONException
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      return a(new JSONObject(paramString), paramContext);
    }
    return new ArrayList();
  }
  
  public static List<OfflineMapProvince> a(JSONObject paramJSONObject, Context paramContext)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramJSONObject.has("result"))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", new JSONObject().put("offlinemap_with_province_vfour", paramJSONObject));
        c(localJSONObject.toString(), paramContext);
        paramContext = localJSONObject.optJSONObject("result");
      }
      catch (JSONException localJSONException)
      {
        paramContext = paramJSONObject.optJSONObject("result");
        gk.c(localJSONException, "Utility", "parseJson");
        localJSONException.printStackTrace();
      }
    }
    else
    {
      paramContext = paramJSONObject.optJSONObject("result");
    }
    if (paramContext != null)
    {
      paramJSONObject = paramContext.optJSONObject("offlinemap_with_province_vfour");
      if (paramJSONObject == null) {
        return localArrayList;
      }
      paramJSONObject = paramJSONObject.optJSONObject("offlinemapinfo_with_province");
    }
    else
    {
      paramJSONObject = paramJSONObject.optJSONObject("offlinemapinfo_with_province");
    }
    if (paramJSONObject == null) {
      return localArrayList;
    }
    if (paramJSONObject.has("version")) {
      ae.d = a(paramJSONObject, "version");
    }
    paramContext = paramJSONObject.optJSONArray("provinces");
    if (paramContext == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramContext.length())
    {
      localObject = paramContext.optJSONObject(i);
      if (localObject != null) {
        localArrayList.add(a((JSONObject)localObject));
      }
      i += 1;
    }
    Object localObject = paramJSONObject.optJSONArray("others");
    paramContext = null;
    paramJSONObject = paramContext;
    if (localObject != null)
    {
      paramJSONObject = paramContext;
      if (((JSONArray)localObject).length() > 0) {
        paramJSONObject = ((JSONArray)localObject).getJSONObject(0);
      }
    }
    if (paramJSONObject == null) {
      return localArrayList;
    }
    localArrayList.add(a(paramJSONObject));
    return localArrayList;
  }
  
  public static void a(String paramString) {}
  
  public static ArrayList<OfflineMapCity> b(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("cities");
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray == null) {
      return localArrayList;
    }
    if (localJSONArray.length() == 0) {
      localArrayList.add(c(paramJSONObject));
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      paramJSONObject = localJSONArray.optJSONObject(i);
      if (paramJSONObject != null) {
        localArrayList.add(c(paramJSONObject));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if (paramString == null) {
        return;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          String[] arrayOfString = ((File)localObject).list();
          if (arrayOfString == null) {
            ((File)localObject).delete();
          } else if (arrayOfString.length == 0) {
            ((File)localObject).delete();
          }
        }
        i += 1;
      }
    }
  }
  
  public static void b(String paramString, Context paramContext)
    throws IOException, Exception
  {
    File[] arrayOfFile = new File(dx.c(paramContext)).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if ((localFile.exists()) && (localFile.getName().contains(paramString))) {
        b(localFile);
      }
      i += 1;
    }
    b(dx.c(paramContext));
  }
  
  public static boolean b(File paramFile)
    throws IOException, Exception
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          if (arrayOfFile[i].isFile())
          {
            if (!arrayOfFile[i].delete()) {
              return false;
            }
          }
          else if (!b(arrayOfFile[i])) {
            return false;
          }
          i += 1;
        }
      }
      return paramFile.delete();
    }
    return false;
  }
  
  public static OfflineMapCity c(JSONObject paramJSONObject)
    throws JSONException
  {
    OfflineMapCity localOfflineMapCity = new OfflineMapCity();
    localOfflineMapCity.setAdcode(d(a(paramJSONObject, "adcode")));
    localOfflineMapCity.setUrl(a(paramJSONObject, "url"));
    localOfflineMapCity.setCity(a(paramJSONObject, "name"));
    localOfflineMapCity.setCode(a(paramJSONObject, "citycode"));
    localOfflineMapCity.setPinyin(a(paramJSONObject, "pinyin"));
    localOfflineMapCity.setJianpin(a(paramJSONObject, "jianpin"));
    localOfflineMapCity.setVersion(a(paramJSONObject, "version"));
    localOfflineMapCity.setSize(Long.parseLong(a(paramJSONObject, "size")));
    return localOfflineMapCity;
  }
  
  /* Error */
  public static String c(File paramFile)
  {
    // Byte code:
    //   0: new 305	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 306	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: new 308	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 311	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: new 313	java/io/BufferedReader
    //   21: dup
    //   22: new 315	java/io/InputStreamReader
    //   25: dup
    //   26: aload_0
    //   27: ldc_w 317
    //   30: invokespecial 320	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   33: invokespecial 323	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_0
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: invokevirtual 326	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +18 -> 67
    //   52: aload_0
    //   53: astore_1
    //   54: aload_3
    //   55: astore_2
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 330	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: pop
    //   64: goto -27 -> 37
    //   67: aload_0
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 331	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 334	java/io/BufferedReader:close	()V
    //   82: goto +8 -> 90
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: invokevirtual 336	java/io/FileInputStream:close	()V
    //   94: aload 4
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: areturn
    //   105: astore 5
    //   107: aload_0
    //   108: astore 4
    //   110: aload_3
    //   111: astore_0
    //   112: goto +58 -> 170
    //   115: astore 5
    //   117: aload_0
    //   118: astore 4
    //   120: aload_3
    //   121: astore_0
    //   122: goto +115 -> 237
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: goto +167 -> 295
    //   131: astore 5
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_0
    //   136: astore 4
    //   138: aload_1
    //   139: astore_0
    //   140: goto +30 -> 170
    //   143: astore 5
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_0
    //   148: astore 4
    //   150: aload_1
    //   151: astore_0
    //   152: goto +85 -> 237
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: astore_0
    //   160: goto +135 -> 295
    //   163: astore 5
    //   165: aconst_null
    //   166: astore_0
    //   167: aload_0
    //   168: astore 4
    //   170: aload 4
    //   172: astore_1
    //   173: aload_0
    //   174: astore_2
    //   175: aload 5
    //   177: ldc -112
    //   179: ldc_w 338
    //   182: invokestatic 152	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload 4
    //   187: astore_1
    //   188: aload_0
    //   189: astore_2
    //   190: aload 5
    //   192: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   195: aload_0
    //   196: ifnull +15 -> 211
    //   199: aload_0
    //   200: invokevirtual 334	java/io/BufferedReader:close	()V
    //   203: goto +8 -> 211
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   211: aload 4
    //   213: ifnull +75 -> 288
    //   216: aload 4
    //   218: invokevirtual 336	java/io/FileInputStream:close	()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore 5
    //   232: aconst_null
    //   233: astore_0
    //   234: aload_0
    //   235: astore 4
    //   237: aload 4
    //   239: astore_1
    //   240: aload_0
    //   241: astore_2
    //   242: aload 5
    //   244: ldc -112
    //   246: ldc_w 340
    //   249: invokestatic 152	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: astore_1
    //   255: aload_0
    //   256: astore_2
    //   257: aload 5
    //   259: invokevirtual 341	java/io/FileNotFoundException:printStackTrace	()V
    //   262: aload_0
    //   263: ifnull +15 -> 278
    //   266: aload_0
    //   267: invokevirtual 334	java/io/BufferedReader:close	()V
    //   270: goto +8 -> 278
    //   273: astore_0
    //   274: aload_0
    //   275: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   278: aload 4
    //   280: ifnull +8 -> 288
    //   283: aload 4
    //   285: invokevirtual 336	java/io/FileInputStream:close	()V
    //   288: aconst_null
    //   289: areturn
    //   290: astore_3
    //   291: aload_1
    //   292: astore_0
    //   293: aload_3
    //   294: astore_1
    //   295: aload_2
    //   296: ifnull +15 -> 311
    //   299: aload_2
    //   300: invokevirtual 334	java/io/BufferedReader:close	()V
    //   303: goto +8 -> 311
    //   306: astore_2
    //   307: aload_2
    //   308: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   311: aload_0
    //   312: ifnull +15 -> 327
    //   315: aload_0
    //   316: invokevirtual 336	java/io/FileInputStream:close	()V
    //   319: goto +8 -> 327
    //   322: astore_0
    //   323: aload_0
    //   324: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   327: aload_1
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramFile	File
    //   38	31	1	localFile	File
    //   85	2	1	localIOException1	IOException
    //   125	1	1	localObject1	Object
    //   134	17	1	localObject2	Object
    //   155	1	1	localObject3	Object
    //   172	156	1	localObject4	Object
    //   40	260	2	localObject5	Object
    //   306	2	2	localIOException2	IOException
    //   36	85	3	localBufferedReader	java.io.BufferedReader
    //   290	4	3	localObject6	Object
    //   7	277	4	localObject7	Object
    //   45	14	5	str	String
    //   105	1	5	localIOException3	IOException
    //   115	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	1	5	localIOException4	IOException
    //   143	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   163	28	5	localIOException5	IOException
    //   230	28	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   78	82	85	java/io/IOException
    //   90	94	97	java/io/IOException
    //   41	47	105	java/io/IOException
    //   56	64	105	java/io/IOException
    //   71	78	105	java/io/IOException
    //   41	47	115	java/io/FileNotFoundException
    //   56	64	115	java/io/FileNotFoundException
    //   71	78	115	java/io/FileNotFoundException
    //   18	37	125	finally
    //   18	37	131	java/io/IOException
    //   18	37	143	java/io/FileNotFoundException
    //   9	18	155	finally
    //   9	18	163	java/io/IOException
    //   199	203	206	java/io/IOException
    //   216	221	223	java/io/IOException
    //   283	288	223	java/io/IOException
    //   9	18	230	java/io/FileNotFoundException
    //   266	270	273	java/io/IOException
    //   41	47	290	finally
    //   56	64	290	finally
    //   71	78	290	finally
    //   175	185	290	finally
    //   190	195	290	finally
    //   242	252	290	finally
    //   257	262	290	finally
    //   299	303	306	java/io/IOException
    //   315	319	322	java/io/IOException
  }
  
  public static String c(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.indexOf(".zip"));
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      gk.c(paramString, "Utility", "getZipFileNameFromUrl");
    }
    return null;
  }
  
  /* Error */
  public static void c(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc -99
    //   2: aload_1
    //   3: invokestatic 266	com/amap/api/mapcore/util/dx:c	(Landroid/content/Context;)Ljava/lang/String;
    //   6: invokevirtual 20	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: new 365	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_1
    //   23: invokestatic 266	com/amap/api/mapcore/util/dx:c	(Landroid/content/Context;)Ljava/lang/String;
    //   26: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: ldc_w 371
    //   34: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: new 28	java/io/File
    //   41: dup
    //   42: aload_2
    //   43: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 252	java/io/File:exists	()Z
    //   54: ifne +26 -> 80
    //   57: aload_2
    //   58: invokevirtual 375	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: goto +18 -> 80
    //   65: astore_1
    //   66: aload_1
    //   67: ldc_w 377
    //   70: ldc_w 379
    //   73: invokestatic 152	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   80: invokestatic 381	com/amap/api/mapcore/util/bc:a	()J
    //   83: ldc2_w 382
    //   86: lcmp
    //   87: ifle +146 -> 233
    //   90: aconst_null
    //   91: astore_3
    //   92: aconst_null
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_1
    //   97: new 385	java/io/FileOutputStream
    //   100: dup
    //   101: aload_2
    //   102: invokespecial 386	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore_2
    //   106: aload_2
    //   107: aload_0
    //   108: ldc_w 317
    //   111: invokevirtual 390	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   114: invokevirtual 396	java/io/OutputStream:write	([B)V
    //   117: aload_2
    //   118: invokevirtual 397	java/io/OutputStream:close	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: astore_1
    //   131: goto +84 -> 215
    //   134: astore_1
    //   135: aload_2
    //   136: astore_0
    //   137: aload_1
    //   138: astore_2
    //   139: goto +18 -> 157
    //   142: astore_1
    //   143: aload_2
    //   144: astore_0
    //   145: aload_1
    //   146: astore_2
    //   147: goto +41 -> 188
    //   150: astore_0
    //   151: goto +64 -> 215
    //   154: astore_2
    //   155: aload_3
    //   156: astore_0
    //   157: aload_0
    //   158: astore_1
    //   159: aload_2
    //   160: ldc_w 377
    //   163: ldc_w 399
    //   166: invokestatic 152	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: astore_1
    //   171: aload_2
    //   172: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   175: aload_0
    //   176: ifnull +57 -> 233
    //   179: aload_0
    //   180: invokevirtual 397	java/io/OutputStream:close	()V
    //   183: return
    //   184: astore_2
    //   185: aload 4
    //   187: astore_0
    //   188: aload_0
    //   189: astore_1
    //   190: aload_2
    //   191: ldc_w 377
    //   194: ldc_w 401
    //   197: invokestatic 152	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: astore_1
    //   202: aload_2
    //   203: invokevirtual 341	java/io/FileNotFoundException:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull +26 -> 233
    //   210: aload_0
    //   211: invokevirtual 397	java/io/OutputStream:close	()V
    //   214: return
    //   215: aload_1
    //   216: ifnull +15 -> 231
    //   219: aload_1
    //   220: invokevirtual 397	java/io/OutputStream:close	()V
    //   223: goto +8 -> 231
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   231: aload_0
    //   232: athrow
    //   233: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramString	String
    //   0	234	1	paramContext	Context
    //   20	127	2	localObject1	Object
    //   154	18	2	localIOException	IOException
    //   184	19	2	localFileNotFoundException	java.io.FileNotFoundException
    //   91	65	3	localObject2	Object
    //   93	93	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   57	62	65	java/io/IOException
    //   117	121	122	java/io/IOException
    //   179	183	122	java/io/IOException
    //   210	214	122	java/io/IOException
    //   106	117	128	finally
    //   106	117	134	java/io/IOException
    //   106	117	142	java/io/FileNotFoundException
    //   97	106	150	finally
    //   159	169	150	finally
    //   171	175	150	finally
    //   190	200	150	finally
    //   202	206	150	finally
    //   97	106	154	java/io/IOException
    //   97	106	184	java/io/FileNotFoundException
    //   219	223	226	java/io/IOException
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if ("000001".equals(paramString)) {
      str = "100000";
    }
    return str;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */