package com.autonavi.amap.mapcore;

import android.location.Location;
import com.amap.api.mapcore.util.lf;
import com.amap.api.mapcore.util.lj;
import org.json.JSONObject;

public class Inner_3dMap_location
  extends Location
  implements Cloneable
{
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
  public static final int LOCATION_TYPE_OFFLINE = 8;
  public static final int LOCATION_TYPE_SAME_REQ = 2;
  public static final int LOCATION_TYPE_WIFI = 5;
  private String adCode = "";
  private String address = "";
  private String aoiName = "";
  protected String buildingId = "";
  private String city = "";
  private String cityCode = "";
  private String country = "";
  protected String desc = "";
  private String district = "";
  private int errorCode = 0;
  private String errorInfo = "success";
  protected String floor = "";
  private boolean isOffset = true;
  private double latitude = 0.0D;
  private String locationDetail = "";
  private int locationType = 0;
  private double longitude = 0.0D;
  private String number = "";
  private String poiName = "";
  private String province = "";
  private String road = "";
  private int satellites = 0;
  private int signalIntensity = -1;
  private String street = "";
  
  public Inner_3dMap_location(Location paramLocation)
  {
    super(paramLocation);
    this.latitude = paramLocation.getLatitude();
    this.longitude = paramLocation.getLongitude();
  }
  
  public Inner_3dMap_location(String paramString)
  {
    super(paramString);
  }
  
  public Inner_3dMap_location clone()
  {
    try
    {
      super.clone();
      Inner_3dMap_location localInner_3dMap_location = new Inner_3dMap_location(this);
      localInner_3dMap_location.setProvince(this.province);
      localInner_3dMap_location.setCity(this.city);
      localInner_3dMap_location.setDistrict(this.district);
      localInner_3dMap_location.setCityCode(this.cityCode);
      localInner_3dMap_location.setAdCode(this.adCode);
      localInner_3dMap_location.setAddress(this.address);
      localInner_3dMap_location.setPoiName(this.poiName);
      localInner_3dMap_location.setCountry(this.country);
      localInner_3dMap_location.setRoad(this.road);
      localInner_3dMap_location.setStreet(this.street);
      localInner_3dMap_location.setNumber(this.number);
      localInner_3dMap_location.setOffset(this.isOffset);
      localInner_3dMap_location.setErrorCode(this.errorCode);
      localInner_3dMap_location.setErrorInfo(this.errorInfo);
      localInner_3dMap_location.setLocationDetail(this.locationDetail);
      localInner_3dMap_location.setLocationType(this.locationType);
      localInner_3dMap_location.setLatitude(this.latitude);
      localInner_3dMap_location.setLongitude(this.longitude);
      localInner_3dMap_location.setSatellites(this.satellites);
      localInner_3dMap_location.setAoiName(this.aoiName);
      localInner_3dMap_location.setBuildingId(this.buildingId);
      localInner_3dMap_location.setFloor(this.floor);
      localInner_3dMap_location.setGpsAccuracyStatus(this.signalIntensity);
      localInner_3dMap_location.setExtras(getExtras());
      return localInner_3dMap_location;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public float getAccuracy()
  {
    return super.getAccuracy();
  }
  
  public String getAdCode()
  {
    return this.adCode;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public double getAltitude()
  {
    return super.getAltitude();
  }
  
  public String getAoiName()
  {
    return this.aoiName;
  }
  
  public float getBearing()
  {
    return super.getBearing();
  }
  
  public String getBuildingId()
  {
    return this.buildingId;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getDistrict()
  {
    return this.district;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorInfo()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.errorInfo);
    if (this.errorCode != 0)
    {
      localStringBuilder1.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
      StringBuilder localStringBuilder2 = new StringBuilder(",错误详细信息:");
      localStringBuilder2.append(this.locationDetail);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    this.errorInfo = localStringBuilder1.toString();
    return this.errorInfo;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public int getGpsAccuracyStatus()
  {
    return this.signalIntensity;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public String getLocationDetail()
  {
    return this.locationDetail;
  }
  
  public int getLocationType()
  {
    return this.locationType;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getPoiName()
  {
    return this.poiName;
  }
  
  public String getProvider()
  {
    return super.getProvider();
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public String getRoad()
  {
    return this.road;
  }
  
  public int getSatellites()
  {
    return this.satellites;
  }
  
  public float getSpeed()
  {
    return super.getSpeed();
  }
  
  public String getStreet()
  {
    return this.street;
  }
  
  public String getStreetNum()
  {
    return this.number;
  }
  
  public boolean isOffset()
  {
    return this.isOffset;
  }
  
  public void setAdCode(String paramString)
  {
    this.adCode = paramString;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAoiName(String paramString)
  {
    this.aoiName = paramString;
  }
  
  public void setBuildingId(String paramString)
  {
    this.buildingId = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public void setDistrict(String paramString)
  {
    this.district = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    if (this.errorCode != 0) {
      return;
    }
    this.errorInfo = lj.b(paramInt);
    this.errorCode = paramInt;
  }
  
  public void setErrorInfo(String paramString)
  {
    this.errorInfo = paramString;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setGpsAccuracyStatus(int paramInt)
  {
    this.signalIntensity = paramInt;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLocationDetail(String paramString)
  {
    this.locationDetail = paramString;
  }
  
  public void setLocationType(int paramInt)
  {
    this.locationType = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setNumber(String paramString)
  {
    this.number = paramString;
  }
  
  public void setOffset(boolean paramBoolean)
  {
    this.isOffset = paramBoolean;
  }
  
  public void setPoiName(String paramString)
  {
    this.poiName = paramString;
  }
  
  public void setProvince(String paramString)
  {
    this.province = paramString;
  }
  
  public void setRoad(String paramString)
  {
    this.road = paramString;
  }
  
  public void setSatellites(int paramInt)
  {
    this.satellites = paramInt;
  }
  
  public void setStreet(String paramString)
  {
    this.street = paramString;
  }
  
  /* Error */
  protected JSONObject toJson(int paramInt)
  {
    // Byte code:
    //   0: new 306	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 307	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: tableswitch	default:+27->36, 1:+29->38, 2:+295->304, 3:+307->316
    //   36: aload_2
    //   37: areturn
    //   38: aload_2
    //   39: ldc_w 309
    //   42: aload_0
    //   43: invokevirtual 310	com/autonavi/amap/mapcore/Inner_3dMap_location:getAltitude	()D
    //   46: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_2
    //   51: ldc_w 316
    //   54: aload_0
    //   55: invokevirtual 317	com/autonavi/amap/mapcore/Inner_3dMap_location:getSpeed	()F
    //   58: f2d
    //   59: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_2
    //   64: ldc_w 319
    //   67: aload_0
    //   68: invokevirtual 320	com/autonavi/amap/mapcore/Inner_3dMap_location:getBearing	()F
    //   71: f2d
    //   72: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload_2
    //   77: ldc_w 322
    //   80: aload_0
    //   81: getfield 92	com/autonavi/amap/mapcore/Inner_3dMap_location:cityCode	Ljava/lang/String;
    //   84: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_2
    //   89: ldc_w 326
    //   92: aload_0
    //   93: getfield 134	com/autonavi/amap/mapcore/Inner_3dMap_location:desc	Ljava/lang/String;
    //   96: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_2
    //   101: ldc_w 328
    //   104: aload_0
    //   105: getfield 94	com/autonavi/amap/mapcore/Inner_3dMap_location:adCode	Ljava/lang/String;
    //   108: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_2
    //   113: ldc_w 329
    //   116: aload_0
    //   117: getfield 100	com/autonavi/amap/mapcore/Inner_3dMap_location:country	Ljava/lang/String;
    //   120: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload_2
    //   125: ldc_w 330
    //   128: aload_0
    //   129: getfield 86	com/autonavi/amap/mapcore/Inner_3dMap_location:province	Ljava/lang/String;
    //   132: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 331
    //   140: aload_0
    //   141: getfield 88	com/autonavi/amap/mapcore/Inner_3dMap_location:city	Ljava/lang/String;
    //   144: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_2
    //   149: ldc_w 332
    //   152: aload_0
    //   153: getfield 90	com/autonavi/amap/mapcore/Inner_3dMap_location:district	Ljava/lang/String;
    //   156: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 333
    //   164: aload_0
    //   165: getfield 102	com/autonavi/amap/mapcore/Inner_3dMap_location:road	Ljava/lang/String;
    //   168: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload_2
    //   173: ldc_w 334
    //   176: aload_0
    //   177: getfield 104	com/autonavi/amap/mapcore/Inner_3dMap_location:street	Ljava/lang/String;
    //   180: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload_2
    //   185: ldc_w 335
    //   188: aload_0
    //   189: getfield 106	com/autonavi/amap/mapcore/Inner_3dMap_location:number	Ljava/lang/String;
    //   192: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_2
    //   197: ldc_w 337
    //   200: aload_0
    //   201: getfield 98	com/autonavi/amap/mapcore/Inner_3dMap_location:poiName	Ljava/lang/String;
    //   204: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_2
    //   209: ldc_w 338
    //   212: aload_0
    //   213: getfield 110	com/autonavi/amap/mapcore/Inner_3dMap_location:errorCode	I
    //   216: invokevirtual 341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 342
    //   224: aload_0
    //   225: getfield 114	com/autonavi/amap/mapcore/Inner_3dMap_location:errorInfo	Ljava/lang/String;
    //   228: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload_2
    //   233: ldc_w 343
    //   236: aload_0
    //   237: getfield 118	com/autonavi/amap/mapcore/Inner_3dMap_location:locationType	I
    //   240: invokevirtual 341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload_2
    //   245: ldc_w 344
    //   248: aload_0
    //   249: getfield 116	com/autonavi/amap/mapcore/Inner_3dMap_location:locationDetail	Ljava/lang/String;
    //   252: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_2
    //   257: ldc_w 346
    //   260: aload_0
    //   261: getfield 126	com/autonavi/amap/mapcore/Inner_3dMap_location:aoiName	Ljava/lang/String;
    //   264: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_2
    //   269: ldc_w 347
    //   272: aload_0
    //   273: getfield 96	com/autonavi/amap/mapcore/Inner_3dMap_location:address	Ljava/lang/String;
    //   276: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 349
    //   284: aload_0
    //   285: getfield 130	com/autonavi/amap/mapcore/Inner_3dMap_location:buildingId	Ljava/lang/String;
    //   288: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload_2
    //   293: ldc_w 350
    //   296: aload_0
    //   297: getfield 132	com/autonavi/amap/mapcore/Inner_3dMap_location:floor	Ljava/lang/String;
    //   300: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_2
    //   305: ldc_w 352
    //   308: aload_0
    //   309: invokevirtual 356	com/autonavi/amap/mapcore/Inner_3dMap_location:getTime	()J
    //   312: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   315: pop
    //   316: aload_2
    //   317: ldc_w 361
    //   320: aload_0
    //   321: invokevirtual 362	com/autonavi/amap/mapcore/Inner_3dMap_location:getProvider	()Ljava/lang/String;
    //   324: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload_2
    //   329: ldc_w 364
    //   332: aload_0
    //   333: invokevirtual 365	com/autonavi/amap/mapcore/Inner_3dMap_location:getLongitude	()D
    //   336: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 367
    //   344: aload_0
    //   345: invokevirtual 368	com/autonavi/amap/mapcore/Inner_3dMap_location:getLatitude	()D
    //   348: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_2
    //   353: ldc_w 370
    //   356: aload_0
    //   357: invokevirtual 371	com/autonavi/amap/mapcore/Inner_3dMap_location:getAccuracy	()F
    //   360: f2d
    //   361: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload_2
    //   366: ldc_w 372
    //   369: aload_0
    //   370: getfield 108	com/autonavi/amap/mapcore/Inner_3dMap_location:isOffset	Z
    //   373: invokevirtual 375	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload_2
    //   378: areturn
    //   379: astore_2
    //   380: aload_2
    //   381: ldc_w 377
    //   384: ldc_w 379
    //   387: invokestatic 385	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   390: aconst_null
    //   391: areturn
    //   392: astore_3
    //   393: goto -317 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	Inner_3dMap_location
    //   0	396	1	paramInt	int
    //   7	371	2	localJSONObject	JSONObject
    //   379	2	2	localThrowable1	Throwable
    //   392	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	379	java/lang/Throwable
    //   76	304	379	java/lang/Throwable
    //   304	316	379	java/lang/Throwable
    //   316	377	379	java/lang/Throwable
    //   38	76	392	java/lang/Throwable
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
      lf.a(localThrowable, "AMapLocation", "toStr part2");
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
      localStringBuilder.append(this.latitude);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("longitude=");
      localStringBuilder.append(this.longitude);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("province=");
      localStringBuilder.append(this.province);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("city=");
      localStringBuilder.append(this.city);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("district=");
      localStringBuilder.append(this.district);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("cityCode=");
      localStringBuilder.append(this.cityCode);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("adCode=");
      localStringBuilder.append(this.adCode);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("address=");
      localStringBuilder.append(this.address);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("country=");
      localStringBuilder.append(this.country);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("road=");
      localStringBuilder.append(this.road);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("poiName=");
      localStringBuilder.append(this.poiName);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("street=");
      localStringBuilder.append(this.street);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("streetNum=");
      localStringBuilder.append(this.number);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("aoiName=");
      localStringBuilder.append(this.aoiName);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("poiid=");
      localStringBuilder.append(this.buildingId);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("floor=");
      localStringBuilder.append(this.floor);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("errorCode=");
      localStringBuilder.append(this.errorCode);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("errorInfo=");
      localStringBuilder.append(this.errorInfo);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("locationDetail=");
      localStringBuilder.append(this.locationDetail);
      localStringBuilder.append("#");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("locationType=");
      localStringBuilder.append(this.locationType);
      localStringBuffer.append(localStringBuilder.toString());
      return localStringBuffer.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\Inner_3dMap_location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */