package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class dg
{
  static String a = "http://apilocate.amap.com/mobile/binary";
  static String b = "";
  static String c;
  public static String d;
  public static String e;
  public static int f;
  public static String g;
  public static String h;
  static String i;
  static HashMap<String, String> j;
  static boolean k = false;
  static boolean l = false;
  private static final String[] m = { "com.amap.api.location", "com.loc", "com.amap.api.fence" };
  private static v n;
  private static boolean o;
  private static boolean p;
  
  static
  {
    c = "001;11B;11F;11G;11H;11I;11K;135;13J;13S;14S;157;15O;15U;17J";
    d = null;
    e = null;
    f = 30000;
    g = null;
    h = null;
    n = null;
    o = false;
    p = false;
  }
  
  public static Bundle a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    Bundle localBundle = new Bundle();
    AMapLocationClientOption localAMapLocationClientOption = paramAMapLocationClientOption;
    if (paramAMapLocationClientOption == null) {
      localAMapLocationClientOption = new AMapLocationClientOption();
    }
    try
    {
      localBundle.putParcelable("opt", localAMapLocationClientOption);
      return localBundle;
    }
    catch (Throwable paramAMapLocationClientOption)
    {
      a(paramAMapLocationClientOption, "CoreUtil", "getOptionBundle");
    }
    return localBundle;
  }
  
  public static AMapLocation a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2)
  {
    if (paramAMapLocation2 == null) {
      return paramAMapLocation1;
    }
    try
    {
      paramAMapLocation1.setCountry(paramAMapLocation2.getCountry());
      paramAMapLocation1.setRoad(paramAMapLocation2.getRoad());
      paramAMapLocation1.setPoiName(paramAMapLocation2.getPoiName());
      paramAMapLocation1.setStreet(paramAMapLocation2.getStreet());
      paramAMapLocation1.setNumber(paramAMapLocation2.getStreetNum());
      Object localObject = paramAMapLocation2.getCityCode();
      String str = paramAMapLocation2.getAdCode();
      paramAMapLocation1.setCityCode((String)localObject);
      paramAMapLocation1.setAdCode(str);
      paramAMapLocation1.setCity(paramAMapLocation2.getCity());
      paramAMapLocation1.setDistrict(paramAMapLocation2.getDistrict());
      paramAMapLocation1.setProvince(paramAMapLocation2.getProvince());
      paramAMapLocation1.setAoiName(paramAMapLocation2.getAoiName());
      paramAMapLocation1.setAddress(paramAMapLocation2.getAddress());
      paramAMapLocation1.setDescription(paramAMapLocation2.getDescription());
      if (paramAMapLocation1.getExtras() != null)
      {
        paramAMapLocation1.getExtras().putString("citycode", paramAMapLocation2.getCityCode());
        paramAMapLocation1.getExtras().putString("desc", paramAMapLocation2.getExtras().getString("desc"));
        paramAMapLocation1.getExtras().putString("adcode", paramAMapLocation2.getAdCode());
        return paramAMapLocation1;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("citycode", paramAMapLocation2.getCityCode());
      ((Bundle)localObject).putString("desc", paramAMapLocation2.getExtras().getString("desc"));
      ((Bundle)localObject).putString("adcode", paramAMapLocation2.getAdCode());
      paramAMapLocation1.setExtras((Bundle)localObject);
      return paramAMapLocation1;
    }
    catch (Throwable paramAMapLocation2) {}
    return paramAMapLocation1;
  }
  
  public static AMapLocationClientOption a(Bundle paramBundle)
  {
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    if (paramBundle == null) {
      return localAMapLocationClientOption;
    }
    try
    {
      paramBundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
      paramBundle = (AMapLocationClientOption)paramBundle.getParcelable("opt");
      return paramBundle;
    }
    catch (Throwable paramBundle)
    {
      a(paramBundle, "CoreUtil", "getOptionFromBundle");
    }
    return localAMapLocationClientOption;
  }
  
  public static v a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new v.a(paramString1, paramString2, "AMAP_Location_SDK_Android 4.8.0").a(e()).a();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1, "CoreUtil", "getSDKInfo");
    }
    return null;
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (w.a(paramContext, false))
      {
        a = "http://abroad.apilocate.amap.com/mobile/binary";
        return;
      }
      try
      {
        if (j == null) {
          j = new HashMap(16);
        }
        j.clear();
        j.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
        j.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
        j.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
      }
      catch (Throwable localThrowable)
      {
        a(localThrowable, "CoreUtil", "initUrlHash");
      }
      String str1 = cv.a(l.f(paramContext));
      i = str1;
      if (str1 != null) {
        try
        {
          if (str1.length() == 0) {
            return;
          }
          if (j == null) {
            return;
          }
          if (!j.containsKey(str1)) {
            return;
          }
          String str2 = (String)j.get(str1);
          Object localObject = null;
          paramContext = (Context)localObject;
          if (str2 != null)
          {
            paramContext = (Context)localObject;
            if (str2.length() > 0) {
              paramContext = new String(cv.c(a(str2), str1), "utf-8");
            }
          }
          if ((paramContext != null) && (paramContext.length() > 0) && (paramContext.contains("http:")))
          {
            b = paramContext;
            a = paramContext;
          }
          return;
        }
        catch (Throwable paramContext)
        {
          a(paramContext, "CoreUtil", "checkUrl");
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      a(paramContext, "CoreUtil", "checkUrl");
    }
  }
  
  /* Error */
  public static void a(AMapLocation paramAMapLocation, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +583 -> 584
    //   4: aload_0
    //   5: ifnull +579 -> 584
    //   8: aload_1
    //   9: ldc_w 318
    //   12: aload_0
    //   13: invokevirtual 322	com/amap/api/location/AMapLocation:getLatitude	()D
    //   16: invokevirtual 328	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   19: dstore_2
    //   20: aload_1
    //   21: ldc_w 330
    //   24: aload_0
    //   25: invokevirtual 333	com/amap/api/location/AMapLocation:getLongitude	()D
    //   28: invokevirtual 328	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   31: dstore 4
    //   33: aload_0
    //   34: aload_1
    //   35: ldc_w 335
    //   38: aload_0
    //   39: invokevirtual 338	com/amap/api/location/AMapLocation:getProvider	()Ljava/lang/String;
    //   42: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 345	com/amap/api/location/AMapLocation:setProvider	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: dload_2
    //   50: invokevirtual 349	com/amap/api/location/AMapLocation:setLatitude	(D)V
    //   53: aload_0
    //   54: dload 4
    //   56: invokevirtual 352	com/amap/api/location/AMapLocation:setLongitude	(D)V
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 354
    //   64: aload_0
    //   65: invokevirtual 357	com/amap/api/location/AMapLocation:getAltitude	()D
    //   68: invokevirtual 328	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   71: invokevirtual 360	com/amap/api/location/AMapLocation:setAltitude	(D)V
    //   74: aload_1
    //   75: ldc_w 362
    //   78: invokevirtual 364	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 7
    //   83: aload 7
    //   85: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +12 -> 100
    //   91: aload_0
    //   92: aload 7
    //   94: invokestatic 375	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   97: invokevirtual 379	com/amap/api/location/AMapLocation:setAccuracy	(F)V
    //   100: aload_1
    //   101: ldc_w 381
    //   104: invokevirtual 364	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 7
    //   109: aload 7
    //   111: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +12 -> 126
    //   117: aload_0
    //   118: aload 7
    //   120: invokestatic 375	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   123: invokevirtual 384	com/amap/api/location/AMapLocation:setSpeed	(F)V
    //   126: aload_1
    //   127: ldc_w 386
    //   130: invokevirtual 364	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 7
    //   135: aload 7
    //   137: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifne +12 -> 152
    //   143: aload_0
    //   144: aload 7
    //   146: invokestatic 375	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   149: invokevirtual 389	com/amap/api/location/AMapLocation:setBearing	(F)V
    //   152: aload_0
    //   153: aload_1
    //   154: ldc -63
    //   156: aload_0
    //   157: invokevirtual 133	com/amap/api/location/AMapLocation:getAdCode	()Ljava/lang/String;
    //   160: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: invokevirtual 139	com/amap/api/location/AMapLocation:setAdCode	(Ljava/lang/String;)V
    //   166: aload_0
    //   167: aload_1
    //   168: ldc -75
    //   170: aload_0
    //   171: invokevirtual 130	com/amap/api/location/AMapLocation:getCityCode	()Ljava/lang/String;
    //   174: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 136	com/amap/api/location/AMapLocation:setCityCode	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: aload_1
    //   182: ldc_w 391
    //   185: aload_0
    //   186: invokevirtual 166	com/amap/api/location/AMapLocation:getAddress	()Ljava/lang/String;
    //   189: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: invokevirtual 169	com/amap/api/location/AMapLocation:setAddress	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: ldc -69
    //   198: ldc 11
    //   200: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore 7
    //   205: aload_0
    //   206: aload_1
    //   207: ldc_w 393
    //   210: aload_0
    //   211: invokevirtual 99	com/amap/api/location/AMapLocation:getCountry	()Ljava/lang/String;
    //   214: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 103	com/amap/api/location/AMapLocation:setCountry	(Ljava/lang/String;)V
    //   220: aload_0
    //   221: aload_1
    //   222: ldc_w 395
    //   225: aload_0
    //   226: invokevirtual 154	com/amap/api/location/AMapLocation:getProvince	()Ljava/lang/String;
    //   229: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: invokevirtual 157	com/amap/api/location/AMapLocation:setProvince	(Ljava/lang/String;)V
    //   235: aload_0
    //   236: aload_1
    //   237: ldc_w 397
    //   240: aload_0
    //   241: invokevirtual 142	com/amap/api/location/AMapLocation:getCity	()Ljava/lang/String;
    //   244: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   247: invokevirtual 145	com/amap/api/location/AMapLocation:setCity	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: aload_1
    //   252: ldc_w 399
    //   255: aload_0
    //   256: invokevirtual 148	com/amap/api/location/AMapLocation:getDistrict	()Ljava/lang/String;
    //   259: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 151	com/amap/api/location/AMapLocation:setDistrict	(Ljava/lang/String;)V
    //   265: aload_0
    //   266: aload_1
    //   267: ldc_w 401
    //   270: aload_0
    //   271: invokevirtual 106	com/amap/api/location/AMapLocation:getRoad	()Ljava/lang/String;
    //   274: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   277: invokevirtual 109	com/amap/api/location/AMapLocation:setRoad	(Ljava/lang/String;)V
    //   280: aload_0
    //   281: aload_1
    //   282: ldc_w 403
    //   285: aload_0
    //   286: invokevirtual 118	com/amap/api/location/AMapLocation:getStreet	()Ljava/lang/String;
    //   289: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 121	com/amap/api/location/AMapLocation:setStreet	(Ljava/lang/String;)V
    //   295: aload_0
    //   296: aload_1
    //   297: ldc_w 405
    //   300: aload_0
    //   301: invokevirtual 124	com/amap/api/location/AMapLocation:getStreetNum	()Ljava/lang/String;
    //   304: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   307: invokevirtual 127	com/amap/api/location/AMapLocation:setNumber	(Ljava/lang/String;)V
    //   310: aload_0
    //   311: aload_1
    //   312: ldc_w 407
    //   315: aload_0
    //   316: invokevirtual 112	com/amap/api/location/AMapLocation:getPoiName	()Ljava/lang/String;
    //   319: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 115	com/amap/api/location/AMapLocation:setPoiName	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: aload_1
    //   327: ldc_w 409
    //   330: aload_0
    //   331: invokevirtual 160	com/amap/api/location/AMapLocation:getAoiName	()Ljava/lang/String;
    //   334: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   337: invokevirtual 163	com/amap/api/location/AMapLocation:setAoiName	(Ljava/lang/String;)V
    //   340: aload_0
    //   341: aload_1
    //   342: ldc_w 411
    //   345: aload_0
    //   346: invokevirtual 414	com/amap/api/location/AMapLocation:getErrorCode	()I
    //   349: invokevirtual 418	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   352: invokevirtual 421	com/amap/api/location/AMapLocation:setErrorCode	(I)V
    //   355: aload_0
    //   356: aload_1
    //   357: ldc_w 423
    //   360: aload_0
    //   361: invokevirtual 426	com/amap/api/location/AMapLocation:getErrorInfo	()Ljava/lang/String;
    //   364: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 429	com/amap/api/location/AMapLocation:setErrorInfo	(Ljava/lang/String;)V
    //   370: aload_0
    //   371: aload_1
    //   372: ldc_w 431
    //   375: aload_0
    //   376: invokevirtual 434	com/amap/api/location/AMapLocation:getLocationType	()I
    //   379: invokevirtual 418	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   382: invokevirtual 437	com/amap/api/location/AMapLocation:setLocationType	(I)V
    //   385: aload_0
    //   386: aload_1
    //   387: ldc_w 439
    //   390: aload_0
    //   391: invokevirtual 442	com/amap/api/location/AMapLocation:getLocationDetail	()Ljava/lang/String;
    //   394: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   397: invokevirtual 445	com/amap/api/location/AMapLocation:setLocationDetail	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: aload_1
    //   402: ldc_w 447
    //   405: aload_0
    //   406: invokevirtual 451	com/amap/api/location/AMapLocation:getTime	()J
    //   409: invokevirtual 455	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   412: invokevirtual 459	com/amap/api/location/AMapLocation:setTime	(J)V
    //   415: aload_1
    //   416: ldc_w 461
    //   419: aload_0
    //   420: invokevirtual 464	com/amap/api/location/AMapLocation:isOffset	()Z
    //   423: invokevirtual 468	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   426: istore 6
    //   428: aload_0
    //   429: iload 6
    //   431: invokevirtual 472	com/amap/api/location/AMapLocation:setOffset	(Z)V
    //   434: aload_0
    //   435: aload_1
    //   436: ldc_w 474
    //   439: aload_0
    //   440: invokevirtual 477	com/amap/api/location/AMapLocation:getBuildingId	()Ljava/lang/String;
    //   443: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   446: invokevirtual 480	com/amap/api/location/AMapLocation:setBuildingId	(Ljava/lang/String;)V
    //   449: aload_0
    //   450: aload_1
    //   451: ldc_w 482
    //   454: aload_0
    //   455: invokevirtual 485	com/amap/api/location/AMapLocation:getFloor	()Ljava/lang/String;
    //   458: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   461: invokevirtual 488	com/amap/api/location/AMapLocation:setFloor	(Ljava/lang/String;)V
    //   464: aload_0
    //   465: aload_1
    //   466: ldc_w 490
    //   469: aload_0
    //   470: invokevirtual 172	com/amap/api/location/AMapLocation:getDescription	()Ljava/lang/String;
    //   473: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   476: invokevirtual 175	com/amap/api/location/AMapLocation:setDescription	(Ljava/lang/String;)V
    //   479: aload_1
    //   480: ldc_w 492
    //   483: invokevirtual 496	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   486: ifeq +22 -> 508
    //   489: aload_1
    //   490: ldc_w 492
    //   493: ldc_w 498
    //   496: invokevirtual 342	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   499: astore_1
    //   500: aload_0
    //   501: aload_1
    //   502: invokevirtual 501	com/amap/api/location/AMapLocation:setCoordType	(Ljava/lang/String;)V
    //   505: goto +24 -> 529
    //   508: dload_2
    //   509: dload 4
    //   511: invokestatic 504	com/loc/dg:a	(DD)Z
    //   514: ifeq +86 -> 600
    //   517: iload 6
    //   519: ifeq +81 -> 600
    //   522: ldc_w 498
    //   525: astore_1
    //   526: goto -26 -> 500
    //   529: new 73	android/os/Bundle
    //   532: dup
    //   533: invokespecial 76	android/os/Bundle:<init>	()V
    //   536: astore_1
    //   537: aload_1
    //   538: ldc -75
    //   540: aload_0
    //   541: invokevirtual 130	com/amap/api/location/AMapLocation:getCityCode	()Ljava/lang/String;
    //   544: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_1
    //   548: ldc -69
    //   550: aload 7
    //   552: invokevirtual 507	java/lang/String:toString	()Ljava/lang/String;
    //   555: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_1
    //   559: ldc -63
    //   561: aload_0
    //   562: invokevirtual 133	com/amap/api/location/AMapLocation:getAdCode	()Ljava/lang/String;
    //   565: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload_0
    //   569: aload_1
    //   570: invokevirtual 197	com/amap/api/location/AMapLocation:setExtras	(Landroid/os/Bundle;)V
    //   573: return
    //   574: astore_0
    //   575: aload_0
    //   576: ldc 87
    //   578: ldc_w 509
    //   581: invokestatic 92	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   584: return
    //   585: astore 7
    //   587: goto -487 -> 100
    //   590: astore 7
    //   592: goto -466 -> 126
    //   595: astore 7
    //   597: goto -445 -> 152
    //   600: ldc_w 511
    //   603: astore_1
    //   604: goto -104 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramAMapLocation	AMapLocation
    //   0	607	1	paramJSONObject	org.json.JSONObject
    //   19	490	2	d1	double
    //   31	479	4	d2	double
    //   426	92	6	bool	boolean
    //   81	470	7	str	String
    //   585	1	7	localThrowable1	Throwable
    //   590	1	7	localThrowable2	Throwable
    //   595	1	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	74	574	java/lang/Throwable
    //   152	500	574	java/lang/Throwable
    //   500	505	574	java/lang/Throwable
    //   508	517	574	java/lang/Throwable
    //   529	573	574	java/lang/Throwable
    //   74	100	585	java/lang/Throwable
    //   100	126	590	java/lang/Throwable
    //   126	152	595	java/lang/Throwable
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if ("reportError".equals(paramString2)) {
      return;
    }
    if ((paramThrowable instanceof k)) {
      return;
    }
    try
    {
      aj.b(paramThrowable, paramString1, paramString2);
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    int i1 = (int)((paramDouble2 - 73.0D) / 0.5D);
    int i2 = (int)((paramDouble1 - 3.5D) / 0.5D);
    if ((i2 >= 0) && (i2 < 101) && (i1 >= 0))
    {
      if (i1 >= 124) {
        return false;
      }
      try
      {
        i1 = "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt(i2 * 124 + i1);
        return i1 == 49;
      }
      catch (Throwable localThrowable)
      {
        a(localThrowable, "CoreUtil", "isChina");
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (Math.abs((paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2)) < 1.0E-9D) && ((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D) && ((paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D);
  }
  
  public static boolean a(DPoint paramDPoint, List<DPoint> paramList)
  {
    double d1 = paramDPoint.getLongitude();
    double d2 = paramDPoint.getLatitude();
    double d3 = paramDPoint.getLatitude();
    if (!((DPoint)paramList.get(0)).equals(paramList.get(paramList.size() - 1))) {
      paramList.add(paramList.get(0));
    }
    int i3 = 0;
    int i2;
    for (int i1 = 0; i3 < paramList.size() - 1; i1 = i2)
    {
      double d5 = ((DPoint)paramList.get(i3)).getLongitude();
      double d8 = ((DPoint)paramList.get(i3)).getLatitude();
      int i4 = i3 + 1;
      double d6 = ((DPoint)paramList.get(i4)).getLongitude();
      double d7 = ((DPoint)paramList.get(i4)).getLatitude();
      if (a(d1, d2, d5, d8, d6, d7)) {
        return true;
      }
      double d4 = d7 - d8;
      i2 = i1;
      if (Math.abs(d4) >= 1.0E-9D) {
        if (a(d5, d8, d1, d2, 180.0D, d3))
        {
          i2 = i1;
          if (d8 <= d7) {}
        }
        else
        {
          label387:
          do
          {
            for (;;)
            {
              i2 = i1 + 1;
              break label399;
              if (!a(d6, d7, d1, d2, 180.0D, d3)) {
                break;
              }
              i2 = i1;
              if (d7 <= d8) {
                break label399;
              }
            }
            d6 -= d5;
            double d9 = d3 - d2;
            double d10 = 180.0D - d1;
            d7 = d6 * d9 - d4 * d10;
            if (d7 != 0.0D)
            {
              d8 -= d2;
              d5 -= d1;
              d9 = (d10 * d8 - d9 * d5) / d7;
              d4 = (d8 * d6 - d5 * d4) / d7;
              if ((d9 >= 0.0D) && (d9 <= 1.0D) && (d4 >= 0.0D) && (d4 <= 1.0D))
              {
                i3 = 1;
                break label387;
              }
            }
            i3 = 0;
            i2 = i1;
          } while (i3 != 0);
        }
      }
      label399:
      i3 = i4;
    }
    boolean bool = false;
    if (i1 % 2 != 0) {
      bool = true;
    }
    return bool;
  }
  
  private static byte[] a(String paramString)
  {
    int i1 = 0;
    if ((paramString != null) && (paramString.length() >= 2))
    {
      paramString = paramString.toLowerCase(Locale.US);
      int i2 = paramString.length() / 2;
      byte[] arrayOfByte = new byte[i2];
      while (i1 < i2)
      {
        int i3 = i1 * 2;
        arrayOfByte[i1] = ((byte)(dn.i(paramString.substring(i3, i3 + 2)) & 0xFF));
        i1 += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static v b()
  {
    try
    {
      if (n == null) {
        n = new v.a("loc", "4.8.0", "AMAP_Location_SDK_Android 4.8.0").a(e()).a("4.8.0").a();
      }
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable, "CoreUtil", "getSDKInfo");
    }
    return n;
  }
  
  public static String b(Context paramContext)
  {
    return s.b(l.e(paramContext));
  }
  
  public static String c()
  {
    return c;
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      if (w.a(paramContext, false))
      {
        a = "http://abroad.apilocate.amap.com/mobile/binary";
        return;
      }
      if (TextUtils.isEmpty(b))
      {
        a = "http://apilocate.amap.com/mobile/binary";
        return;
      }
      a = b;
      return;
    }
    catch (Throwable paramContext)
    {
      a(paramContext, "CoreUtil", "changeUrl");
    }
  }
  
  public static boolean d()
  {
    if (!k)
    {
      k = true;
      l = false;
    }
    return l;
  }
  
  private static String[] e()
  {
    return (String[])m.clone();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */