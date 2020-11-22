package com.amap.api.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.loc.dg;
import com.loc.dn;
import org.json.JSONObject;

public class AMapLocation
  extends Location
  implements Parcelable, Cloneable
{
  public static final String COORD_TYPE_GCJ02 = "GCJ02";
  public static final String COORD_TYPE_WGS84 = "WGS84";
  public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator() {};
  public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
  public static final int ERROR_CODE_FAILURE_AUTH = 7;
  public static final int ERROR_CODE_FAILURE_CELL = 11;
  public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
  public static final int ERROR_CODE_FAILURE_INIT = 9;
  public static final int ERROR_CODE_FAILURE_LOCATION = 6;
  public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
  public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
  public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
  public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
  public static final int ERROR_CODE_FAILURE_PARSER = 5;
  public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
  public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
  public static final int ERROR_CODE_INVALID_PARAMETER = 1;
  public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
  public static final int ERROR_CODE_SERVICE_FAIL = 10;
  public static final int ERROR_CODE_UNKNOWN = 8;
  public static final int GPS_ACCURACY_BAD = 0;
  public static final int GPS_ACCURACY_GOOD = 1;
  public static final int GPS_ACCURACY_UNKNOWN = -1;
  public static final int LOCATION_SUCCESS = 0;
  public static final int LOCATION_TYPE_AMAP = 7;
  public static final int LOCATION_TYPE_CELL = 6;
  public static final int LOCATION_TYPE_FAST = 3;
  public static final int LOCATION_TYPE_FIX_CACHE = 4;
  public static final int LOCATION_TYPE_GPS = 1;
  public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
  public static final int LOCATION_TYPE_OFFLINE = 8;
  public static final int LOCATION_TYPE_SAME_REQ = 2;
  public static final int LOCATION_TYPE_WIFI = 5;
  public static final int TRUSTED_LEVEL_BAD = 4;
  public static final int TRUSTED_LEVEL_HIGH = 1;
  public static final int TRUSTED_LEVEL_LOW = 3;
  public static final int TRUSTED_LEVEL_NORMAL = 2;
  private boolean A = false;
  private String B = "GCJ02";
  private int C = 1;
  private int D;
  protected String a = "";
  protected String b = "";
  AMapLocationQualityReport c = new AMapLocationQualityReport();
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private boolean o = true;
  private int p = 0;
  private String q = "success";
  private String r = "";
  private int s = 0;
  private double t = 0.0D;
  private double u = 0.0D;
  private int v = 0;
  private String w = "";
  private int x = -1;
  private boolean y = false;
  private String z = "";
  
  public AMapLocation(Location paramLocation)
  {
    super(paramLocation);
    this.t = paramLocation.getLatitude();
    this.u = paramLocation.getLongitude();
  }
  
  public AMapLocation(String paramString)
  {
    super(paramString);
  }
  
  public AMapLocation clone()
  {
    try
    {
      super.clone();
      AMapLocation localAMapLocation = new AMapLocation(this);
      try
      {
        localAMapLocation.setLatitude(this.t);
        localAMapLocation.setLongitude(this.u);
        localAMapLocation.setAdCode(this.h);
        localAMapLocation.setAddress(this.i);
        localAMapLocation.setAoiName(this.w);
        localAMapLocation.setBuildingId(this.a);
        localAMapLocation.setCity(this.e);
        localAMapLocation.setCityCode(this.g);
        localAMapLocation.setCountry(this.k);
        localAMapLocation.setDistrict(this.f);
        localAMapLocation.setErrorCode(this.p);
        localAMapLocation.setErrorInfo(this.q);
        localAMapLocation.setFloor(this.b);
        localAMapLocation.setFixLastLocation(this.A);
        localAMapLocation.setOffset(this.o);
        localAMapLocation.setLocationDetail(this.r);
        localAMapLocation.setLocationType(this.s);
        localAMapLocation.setMock(this.y);
        localAMapLocation.setNumber(this.n);
        localAMapLocation.setPoiName(this.j);
        localAMapLocation.setProvince(this.d);
        localAMapLocation.setRoad(this.l);
        localAMapLocation.setSatellites(this.v);
        localAMapLocation.setGpsAccuracyStatus(this.x);
        localAMapLocation.setStreet(this.m);
        localAMapLocation.setDescription(this.z);
        localAMapLocation.setExtras(getExtras());
        if (this.c != null) {
          localAMapLocation.setLocationQualityReport(this.c.clone());
        }
        localAMapLocation.setCoordType(this.B);
        localAMapLocation.setTrustedLevel(this.C);
        localAMapLocation.setConScenario(this.D);
        return localAMapLocation;
      }
      catch (Throwable localThrowable2)
      {
        dg.a(localThrowable2, "AMapLocation", "clone");
        return localAMapLocation;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;) {}
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAccuracy()
  {
    return super.getAccuracy();
  }
  
  public String getAdCode()
  {
    return this.h;
  }
  
  public String getAddress()
  {
    return this.i;
  }
  
  public double getAltitude()
  {
    return super.getAltitude();
  }
  
  public String getAoiName()
  {
    return this.w;
  }
  
  public float getBearing()
  {
    return super.getBearing();
  }
  
  public String getBuildingId()
  {
    return this.a;
  }
  
  public String getCity()
  {
    return this.e;
  }
  
  public String getCityCode()
  {
    return this.g;
  }
  
  public int getConScenario()
  {
    return this.D;
  }
  
  public String getCoordType()
  {
    return this.B;
  }
  
  public String getCountry()
  {
    return this.k;
  }
  
  public String getDescription()
  {
    return this.z;
  }
  
  public String getDistrict()
  {
    return this.f;
  }
  
  public int getErrorCode()
  {
    return this.p;
  }
  
  public String getErrorInfo()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.q);
    if (this.p != 0)
    {
      localStringBuilder1.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
      StringBuilder localStringBuilder2 = new StringBuilder(",错误详细信息:");
      localStringBuilder2.append(this.r);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public String getFloor()
  {
    return this.b;
  }
  
  public int getGpsAccuracyStatus()
  {
    return this.x;
  }
  
  public double getLatitude()
  {
    return this.t;
  }
  
  public String getLocationDetail()
  {
    return this.r;
  }
  
  public AMapLocationQualityReport getLocationQualityReport()
  {
    return this.c;
  }
  
  public int getLocationType()
  {
    return this.s;
  }
  
  public double getLongitude()
  {
    return this.u;
  }
  
  public String getPoiName()
  {
    return this.j;
  }
  
  public String getProvider()
  {
    return super.getProvider();
  }
  
  public String getProvince()
  {
    return this.d;
  }
  
  public String getRoad()
  {
    return this.l;
  }
  
  public int getSatellites()
  {
    return this.v;
  }
  
  public float getSpeed()
  {
    return super.getSpeed();
  }
  
  public String getStreet()
  {
    return this.m;
  }
  
  public String getStreetNum()
  {
    return this.n;
  }
  
  public int getTrustedLevel()
  {
    return this.C;
  }
  
  public boolean isFixLastLocation()
  {
    return this.A;
  }
  
  public boolean isMock()
  {
    return this.y;
  }
  
  public boolean isOffset()
  {
    return this.o;
  }
  
  public void setAdCode(String paramString)
  {
    this.h = paramString;
  }
  
  public void setAddress(String paramString)
  {
    this.i = paramString;
  }
  
  public void setAoiName(String paramString)
  {
    this.w = paramString;
  }
  
  public void setBuildingId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.e = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.g = paramString;
  }
  
  public void setConScenario(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void setCoordType(String paramString)
  {
    this.B = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.k = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.z = paramString;
  }
  
  public void setDistrict(String paramString)
  {
    this.f = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    if (this.p != 0) {
      return;
    }
    this.q = dn.b(paramInt);
    this.p = paramInt;
  }
  
  public void setErrorInfo(String paramString)
  {
    this.q = paramString;
  }
  
  public void setFixLastLocation(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void setFloor(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString.replace("F", "");
      try
      {
        Integer.parseInt(str);
      }
      catch (Throwable paramString)
      {
        dg.a(paramString, "AmapLoc", "setFloor");
        str = null;
      }
    }
    this.b = str;
  }
  
  public void setGpsAccuracyStatus(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.t = paramDouble;
  }
  
  public void setLocationDetail(String paramString)
  {
    this.r = paramString;
  }
  
  public void setLocationQualityReport(AMapLocationQualityReport paramAMapLocationQualityReport)
  {
    if (paramAMapLocationQualityReport == null) {
      return;
    }
    this.c = paramAMapLocationQualityReport;
  }
  
  public void setLocationType(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.u = paramDouble;
  }
  
  public void setMock(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setNumber(String paramString)
  {
    this.n = paramString;
  }
  
  public void setOffset(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setPoiName(String paramString)
  {
    this.j = paramString;
  }
  
  public void setProvince(String paramString)
  {
    this.d = paramString;
  }
  
  public void setRoad(String paramString)
  {
    this.l = paramString;
  }
  
  public void setSatellites(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setStreet(String paramString)
  {
    this.m = paramString;
  }
  
  public void setTrustedLevel(int paramInt)
  {
    this.C = paramInt;
  }
  
  /* Error */
  public JSONObject toJson(int paramInt)
  {
    // Byte code:
    //   0: new 421	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 422	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: tableswitch	default:+27->36, 1:+29->38, 2:+295->304, 3:+307->316
    //   36: aload_2
    //   37: areturn
    //   38: aload_2
    //   39: ldc_w 424
    //   42: aload_0
    //   43: invokevirtual 425	com/amap/api/location/AMapLocation:getAltitude	()D
    //   46: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_2
    //   51: ldc_w 431
    //   54: aload_0
    //   55: invokevirtual 432	com/amap/api/location/AMapLocation:getSpeed	()F
    //   58: f2d
    //   59: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_2
    //   64: ldc_w 434
    //   67: aload_0
    //   68: invokevirtual 435	com/amap/api/location/AMapLocation:getBearing	()F
    //   71: f2d
    //   72: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload_2
    //   77: ldc_w 437
    //   80: aload_0
    //   81: getfield 127	com/amap/api/location/AMapLocation:g	Ljava/lang/String;
    //   84: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_2
    //   89: ldc_w 442
    //   92: aload_0
    //   93: getfield 129	com/amap/api/location/AMapLocation:h	Ljava/lang/String;
    //   96: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_2
    //   101: ldc_w 444
    //   104: aload_0
    //   105: getfield 135	com/amap/api/location/AMapLocation:k	Ljava/lang/String;
    //   108: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_2
    //   113: ldc_w 446
    //   116: aload_0
    //   117: getfield 121	com/amap/api/location/AMapLocation:d	Ljava/lang/String;
    //   120: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload_2
    //   125: ldc_w 448
    //   128: aload_0
    //   129: getfield 123	com/amap/api/location/AMapLocation:e	Ljava/lang/String;
    //   132: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 450
    //   140: aload_0
    //   141: getfield 125	com/amap/api/location/AMapLocation:f	Ljava/lang/String;
    //   144: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_2
    //   149: ldc_w 452
    //   152: aload_0
    //   153: getfield 137	com/amap/api/location/AMapLocation:l	Ljava/lang/String;
    //   156: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 454
    //   164: aload_0
    //   165: getfield 139	com/amap/api/location/AMapLocation:m	Ljava/lang/String;
    //   168: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload_2
    //   173: ldc_w 456
    //   176: aload_0
    //   177: getfield 141	com/amap/api/location/AMapLocation:n	Ljava/lang/String;
    //   180: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload_2
    //   185: ldc_w 458
    //   188: aload_0
    //   189: getfield 133	com/amap/api/location/AMapLocation:j	Ljava/lang/String;
    //   192: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_2
    //   197: ldc_w 460
    //   200: aload_0
    //   201: getfield 145	com/amap/api/location/AMapLocation:p	I
    //   204: invokevirtual 463	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_2
    //   209: ldc_w 465
    //   212: aload_0
    //   213: getfield 149	com/amap/api/location/AMapLocation:q	Ljava/lang/String;
    //   216: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 467
    //   224: aload_0
    //   225: getfield 153	com/amap/api/location/AMapLocation:s	I
    //   228: invokevirtual 463	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload_2
    //   233: ldc_w 469
    //   236: aload_0
    //   237: getfield 151	com/amap/api/location/AMapLocation:r	Ljava/lang/String;
    //   240: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload_2
    //   245: ldc_w 471
    //   248: aload_0
    //   249: getfield 161	com/amap/api/location/AMapLocation:w	Ljava/lang/String;
    //   252: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_2
    //   257: ldc_w 473
    //   260: aload_0
    //   261: getfield 131	com/amap/api/location/AMapLocation:i	Ljava/lang/String;
    //   264: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_2
    //   269: ldc_w 475
    //   272: aload_0
    //   273: getfield 171	com/amap/api/location/AMapLocation:a	Ljava/lang/String;
    //   276: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 477
    //   284: aload_0
    //   285: getfield 173	com/amap/api/location/AMapLocation:b	Ljava/lang/String;
    //   288: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload_2
    //   293: ldc_w 479
    //   296: aload_0
    //   297: getfield 167	com/amap/api/location/AMapLocation:z	Ljava/lang/String;
    //   300: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_2
    //   305: ldc_w 481
    //   308: aload_0
    //   309: invokevirtual 485	com/amap/api/location/AMapLocation:getTime	()J
    //   312: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   315: pop
    //   316: aload_2
    //   317: ldc_w 490
    //   320: aload_0
    //   321: invokevirtual 491	com/amap/api/location/AMapLocation:getProvider	()Ljava/lang/String;
    //   324: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload_2
    //   329: ldc_w 493
    //   332: aload_0
    //   333: invokevirtual 494	com/amap/api/location/AMapLocation:getLongitude	()D
    //   336: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 496
    //   344: aload_0
    //   345: invokevirtual 497	com/amap/api/location/AMapLocation:getLatitude	()D
    //   348: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_2
    //   353: ldc_w 499
    //   356: aload_0
    //   357: invokevirtual 500	com/amap/api/location/AMapLocation:getAccuracy	()F
    //   360: f2d
    //   361: invokevirtual 429	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload_2
    //   366: ldc_w 501
    //   369: aload_0
    //   370: getfield 143	com/amap/api/location/AMapLocation:o	Z
    //   373: invokevirtual 504	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload_2
    //   378: ldc_w 505
    //   381: aload_0
    //   382: getfield 169	com/amap/api/location/AMapLocation:A	Z
    //   385: invokevirtual 504	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload_2
    //   390: ldc_w 507
    //   393: aload_0
    //   394: getfield 180	com/amap/api/location/AMapLocation:B	Ljava/lang/String;
    //   397: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload_2
    //   402: areturn
    //   403: astore_2
    //   404: aload_2
    //   405: ldc_w 416
    //   408: ldc_w 509
    //   411: invokestatic 321	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   414: aconst_null
    //   415: areturn
    //   416: astore_3
    //   417: goto -341 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	AMapLocation
    //   0	420	1	paramInt	int
    //   7	395	2	localJSONObject	JSONObject
    //   403	2	2	localThrowable1	Throwable
    //   416	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	403	java/lang/Throwable
    //   76	304	403	java/lang/Throwable
    //   304	316	403	java/lang/Throwable
    //   316	401	403	java/lang/Throwable
    //   38	76	416	java/lang/Throwable
  }
  
  public String toStr()
  {
    return toStr(1);
  }
  
  public String toStr(int paramInt)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = toJson(paramInt);
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocation", "toStr part2");
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    return ((JSONObject)localObject).toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("latitude=");
      localStringBuilder.append(this.t);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("longitude=");
      localStringBuilder.append(this.u);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("province=");
      localStringBuilder.append(this.d);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("coordType=");
      localStringBuilder.append(this.B);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("city=");
      localStringBuilder.append(this.e);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("district=");
      localStringBuilder.append(this.f);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("cityCode=");
      localStringBuilder.append(this.g);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("adCode=");
      localStringBuilder.append(this.h);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("address=");
      localStringBuilder.append(this.i);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("country=");
      localStringBuilder.append(this.k);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("road=");
      localStringBuilder.append(this.l);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("poiName=");
      localStringBuilder.append(this.j);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("street=");
      localStringBuilder.append(this.m);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("streetNum=");
      localStringBuilder.append(this.n);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("aoiName=");
      localStringBuilder.append(this.w);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("poiid=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("floor=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("errorCode=");
      localStringBuilder.append(this.p);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("errorInfo=");
      localStringBuilder.append(this.q);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("locationDetail=");
      localStringBuilder.append(this.r);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("description=");
      localStringBuilder.append(this.z);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("locationType=");
      localStringBuilder.append(this.s);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("conScenario=");
      localStringBuilder.append(this.D);
      localStringBuffer.append(localStringBuilder.toString());
      return localStringBuffer.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\AMapLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */