package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import org.json.JSONException;
import org.json.JSONObject;

@gp(a="update_item", b=true)
public class ao
  extends ar
{
  private String n = "";
  private Context o;
  
  public ao() {}
  
  public ao(OfflineMapCity paramOfflineMapCity, Context paramContext)
  {
    this.o = paramContext;
    this.a = paramOfflineMapCity.getCity();
    this.c = paramOfflineMapCity.getAdcode();
    this.b = paramOfflineMapCity.getUrl();
    this.g = paramOfflineMapCity.getSize();
    this.e = paramOfflineMapCity.getVersion();
    this.k = paramOfflineMapCity.getCode();
    this.i = 0;
    this.l = paramOfflineMapCity.getState();
    this.j = paramOfflineMapCity.getcompleteCode();
    this.m = paramOfflineMapCity.getPinyin();
    a();
  }
  
  public ao(OfflineMapProvince paramOfflineMapProvince, Context paramContext)
  {
    this.o = paramContext;
    this.a = paramOfflineMapProvince.getProvinceName();
    this.c = paramOfflineMapProvince.getProvinceCode();
    this.b = paramOfflineMapProvince.getUrl();
    this.g = paramOfflineMapProvince.getSize();
    this.e = paramOfflineMapProvince.getVersion();
    this.i = 1;
    this.l = paramOfflineMapProvince.getState();
    this.j = paramOfflineMapProvince.getcompleteCode();
    this.m = paramOfflineMapProvince.getPinyin();
    a();
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
  
  protected void a()
  {
    String str = dx.c(this.o);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.m);
    localStringBuilder.append(".zip.tmp");
    this.d = localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b(String paramString)
  {
    if (paramString != null)
    {
      try
      {
        if ("".equals(paramString)) {
          return;
        }
        paramString = new JSONObject(paramString).getJSONObject("file");
        if (paramString == null) {
          return;
        }
        this.a = paramString.optString("title");
        this.c = paramString.optString("code");
        this.b = paramString.optString("url");
        this.d = paramString.optString("fileName");
        this.f = paramString.optLong("lLocalLength");
        this.g = paramString.optLong("lRemoteLength");
        this.l = paramString.optInt("mState");
        this.e = paramString.optString("version");
        this.h = paramString.optString("localPath");
        this.n = paramString.optString("vMapFileNames");
        this.i = paramString.optInt("isSheng");
        this.j = paramString.optInt("mCompleteCode");
        this.k = paramString.optString("mCityCode");
        this.m = a(paramString, "pinyin");
        if ("".equals(this.m))
        {
          paramString = this.b.substring(this.b.lastIndexOf("/") + 1);
          this.m = paramString.substring(0, paramString.lastIndexOf("."));
          return;
        }
      }
      catch (Throwable paramString)
      {
        gk.c(paramString, "UpdateItem", "readFileToJSONObject");
        paramString.printStackTrace();
      }
      return;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: new 109	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 236	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: new 109	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 236	org/json/JSONObject:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc -91
    //   20: aload_0
    //   21: getfield 33	com/amap/api/mapcore/util/ao:a	Ljava/lang/String;
    //   24: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload_1
    //   29: ldc -89
    //   31: aload_0
    //   32: getfield 39	com/amap/api/mapcore/util/ao:c	Ljava/lang/String;
    //   35: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   38: pop
    //   39: aload_1
    //   40: ldc -87
    //   42: aload_0
    //   43: getfield 44	com/amap/api/mapcore/util/ao:b	Ljava/lang/String;
    //   46: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_1
    //   51: ldc -85
    //   53: aload_0
    //   54: getfield 152	com/amap/api/mapcore/util/ao:d	Ljava/lang/String;
    //   57: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload_1
    //   62: ldc -83
    //   64: aload_0
    //   65: getfield 180	com/amap/api/mapcore/util/ao:f	J
    //   68: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_1
    //   73: ldc -74
    //   75: aload_0
    //   76: getfield 52	com/amap/api/mapcore/util/ao:g	J
    //   79: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   82: pop
    //   83: aload_1
    //   84: ldc -72
    //   86: aload_0
    //   87: getfield 75	com/amap/api/mapcore/util/ao:l	I
    //   90: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_1
    //   95: ldc -66
    //   97: aload_0
    //   98: getfield 58	com/amap/api/mapcore/util/ao:e	Ljava/lang/String;
    //   101: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload_1
    //   106: ldc -64
    //   108: aload_0
    //   109: getfield 195	com/amap/api/mapcore/util/ao:h	Ljava/lang/String;
    //   112: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_0
    //   117: getfield 21	com/amap/api/mapcore/util/ao:n	Ljava/lang/String;
    //   120: ifnull +14 -> 134
    //   123: aload_1
    //   124: ldc -59
    //   126: aload_0
    //   127: getfield 21	com/amap/api/mapcore/util/ao:n	Ljava/lang/String;
    //   130: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_1
    //   135: ldc -57
    //   137: aload_0
    //   138: getfield 68	com/amap/api/mapcore/util/ao:i	I
    //   141: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload_1
    //   146: ldc -55
    //   148: aload_0
    //   149: getfield 81	com/amap/api/mapcore/util/ao:j	I
    //   152: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_1
    //   157: ldc -53
    //   159: aload_0
    //   160: getfield 64	com/amap/api/mapcore/util/ao:k	Ljava/lang/String;
    //   163: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_1
    //   168: ldc -51
    //   170: aload_0
    //   171: getfield 87	com/amap/api/mapcore/util/ao:m	Ljava/lang/String;
    //   174: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 4
    //   180: ldc -97
    //   182: aload_1
    //   183: invokevirtual 240	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: new 139	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   194: astore_1
    //   195: aload_1
    //   196: aload_0
    //   197: getfield 152	com/amap/api/mapcore/util/ao:d	Ljava/lang/String;
    //   200: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: ldc -8
    //   207: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: new 250	java/io/File
    //   214: dup
    //   215: aload_1
    //   216: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: aload_2
    //   224: invokevirtual 255	java/io/File:delete	()Z
    //   227: pop
    //   228: aconst_null
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_1
    //   232: new 257	java/io/OutputStreamWriter
    //   235: dup
    //   236: new 259	java/io/FileOutputStream
    //   239: dup
    //   240: aload_2
    //   241: iconst_1
    //   242: invokespecial 262	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   245: ldc_w 264
    //   248: invokespecial 267	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   251: astore_2
    //   252: aload_2
    //   253: aload 4
    //   255: invokevirtual 268	org/json/JSONObject:toString	()Ljava/lang/String;
    //   258: invokevirtual 271	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   261: aload_2
    //   262: invokevirtual 274	java/io/OutputStreamWriter:close	()V
    //   265: return
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 275	java/io/IOException:printStackTrace	()V
    //   271: return
    //   272: astore_3
    //   273: aload_2
    //   274: astore_1
    //   275: aload_3
    //   276: astore_2
    //   277: goto +46 -> 323
    //   280: astore_3
    //   281: goto +12 -> 293
    //   284: astore_2
    //   285: goto +38 -> 323
    //   288: astore_1
    //   289: aload_3
    //   290: astore_2
    //   291: aload_1
    //   292: astore_3
    //   293: aload_2
    //   294: astore_1
    //   295: aload_3
    //   296: ldc -33
    //   298: ldc_w 277
    //   301: invokestatic 230	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_2
    //   305: astore_1
    //   306: aload_3
    //   307: invokevirtual 275	java/io/IOException:printStackTrace	()V
    //   310: aload_2
    //   311: ifnull +44 -> 355
    //   314: aload_2
    //   315: invokevirtual 274	java/io/OutputStreamWriter:close	()V
    //   318: return
    //   319: astore_1
    //   320: goto -53 -> 267
    //   323: aload_1
    //   324: ifnull +15 -> 339
    //   327: aload_1
    //   328: invokevirtual 274	java/io/OutputStreamWriter:close	()V
    //   331: goto +8 -> 339
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 275	java/io/IOException:printStackTrace	()V
    //   339: aload_2
    //   340: athrow
    //   341: astore_1
    //   342: aload_1
    //   343: ldc -33
    //   345: ldc_w 279
    //   348: invokestatic 230	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_1
    //   352: invokevirtual 233	java/lang/Throwable:printStackTrace	()V
    //   355: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	ao
    //   16	216	1	localObject1	Object
    //   266	2	1	localIOException1	java.io.IOException
    //   274	1	1	localObject2	Object
    //   288	4	1	localIOException2	java.io.IOException
    //   294	12	1	localObject3	Object
    //   319	9	1	localIOException3	java.io.IOException
    //   334	2	1	localIOException4	java.io.IOException
    //   341	11	1	localThrowable	Throwable
    //   222	55	2	localObject4	Object
    //   284	1	2	localObject5	Object
    //   290	50	2	localObject6	Object
    //   229	1	3	localObject7	Object
    //   272	4	3	localObject8	Object
    //   280	10	3	localIOException5	java.io.IOException
    //   292	15	3	localIOException6	java.io.IOException
    //   7	247	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   261	265	266	java/io/IOException
    //   252	261	272	finally
    //   252	261	280	java/io/IOException
    //   232	252	284	finally
    //   295	304	284	finally
    //   306	310	284	finally
    //   232	252	288	java/io/IOException
    //   314	318	319	java/io/IOException
    //   327	331	334	java/io/IOException
    //   9	134	341	java/lang/Throwable
    //   134	228	341	java/lang/Throwable
    //   261	265	341	java/lang/Throwable
    //   267	271	341	java/lang/Throwable
    //   314	318	341	java/lang/Throwable
    //   327	331	341	java/lang/Throwable
    //   335	339	341	java/lang/Throwable
    //   339	341	341	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */