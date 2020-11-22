package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.loc.dg;

public class AMapLocationClientOption
  implements Parcelable, Cloneable
{
  private static boolean A = true;
  public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator() {};
  public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
  public static long SCAN_WIFI_INTERVAL = 30000L;
  static String a;
  private static int d = 0;
  private static int e = 1;
  private static int f = 2;
  private static int g = 4;
  private static AMapLocationProtocol p = AMapLocationProtocol.HTTP;
  private float B;
  private AMapLocationPurpose C;
  boolean b;
  String c;
  private long h = 2000L;
  private long i = dg.f;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private AMapLocationMode o;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private long x;
  private long y;
  private GeoLanguage z;
  
  static
  {
    a = "";
  }
  
  public AMapLocationClientOption()
  {
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = AMapLocationMode.Hight_Accuracy;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = true;
    this.u = false;
    this.v = false;
    this.w = true;
    this.x = 30000L;
    this.y = 30000L;
    this.z = GeoLanguage.DEFAULT;
    this.B = 0.0F;
    this.C = null;
    this.b = false;
    this.c = null;
  }
  
  protected AMapLocationClientOption(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = AMapLocationMode.Hight_Accuracy;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = true;
    this.u = false;
    this.v = false;
    this.w = true;
    this.x = 30000L;
    this.y = 30000L;
    this.z = GeoLanguage.DEFAULT;
    this.B = 0.0F;
    Object localObject2 = null;
    this.C = null;
    this.b = false;
    this.c = null;
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.n = bool1;
    int i1 = paramParcel.readInt();
    Object localObject1;
    if (i1 == -1) {
      localObject1 = AMapLocationMode.Hight_Accuracy;
    } else {
      localObject1 = AMapLocationMode.values()[i1];
    }
    this.o = ((AMapLocationMode)localObject1);
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.q = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.r = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.t = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.u = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.v = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.w = bool1;
    this.x = paramParcel.readLong();
    i1 = paramParcel.readInt();
    if (i1 == -1) {
      localObject1 = AMapLocationProtocol.HTTP;
    } else {
      localObject1 = AMapLocationProtocol.values()[i1];
    }
    p = (AMapLocationProtocol)localObject1;
    i1 = paramParcel.readInt();
    if (i1 == -1) {
      localObject1 = GeoLanguage.DEFAULT;
    } else {
      localObject1 = GeoLanguage.values()[i1];
    }
    this.z = ((GeoLanguage)localObject1);
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    A = bool1;
    this.B = paramParcel.readFloat();
    i1 = paramParcel.readInt();
    if (i1 == -1) {
      localObject1 = localObject2;
    } else {
      localObject1 = AMapLocationPurpose.values()[i1];
    }
    this.C = ((AMapLocationPurpose)localObject1);
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    OPEN_ALWAYS_SCAN_WIFI = bool1;
    this.y = paramParcel.readLong();
  }
  
  public static String getAPIKEY()
  {
    return a;
  }
  
  public static boolean isDownloadCoordinateConvertLibrary()
  {
    return A;
  }
  
  public static boolean isOpenAlwaysScanWifi()
  {
    return OPEN_ALWAYS_SCAN_WIFI;
  }
  
  public static void setDownloadCoordinateConvertLibrary(boolean paramBoolean)
  {
    A = paramBoolean;
  }
  
  public static void setLocationProtocol(AMapLocationProtocol paramAMapLocationProtocol)
  {
    p = paramAMapLocationProtocol;
  }
  
  public static void setOpenAlwaysScanWifi(boolean paramBoolean)
  {
    OPEN_ALWAYS_SCAN_WIFI = paramBoolean;
  }
  
  public static void setScanWifiInterval(long paramLong)
  {
    SCAN_WIFI_INTERVAL = paramLong;
  }
  
  public AMapLocationClientOption clone()
  {
    try
    {
      super.clone();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    localAMapLocationClientOption.h = this.h;
    localAMapLocationClientOption.j = this.j;
    localAMapLocationClientOption.o = this.o;
    localAMapLocationClientOption.k = this.k;
    localAMapLocationClientOption.q = this.q;
    localAMapLocationClientOption.r = this.r;
    localAMapLocationClientOption.l = this.l;
    localAMapLocationClientOption.m = this.m;
    localAMapLocationClientOption.i = this.i;
    localAMapLocationClientOption.s = this.s;
    localAMapLocationClientOption.t = this.t;
    localAMapLocationClientOption.u = this.u;
    localAMapLocationClientOption.v = isSensorEnable();
    localAMapLocationClientOption.w = isWifiScan();
    localAMapLocationClientOption.x = this.x;
    setLocationProtocol(getLocationProtocol());
    localAMapLocationClientOption.z = this.z;
    setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
    localAMapLocationClientOption.B = this.B;
    localAMapLocationClientOption.C = this.C;
    setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
    setScanWifiInterval(getScanWifiInterval());
    localAMapLocationClientOption.y = this.y;
    return localAMapLocationClientOption;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getDeviceModeDistanceFilter()
  {
    return this.B;
  }
  
  public GeoLanguage getGeoLanguage()
  {
    return this.z;
  }
  
  public long getGpsFirstTimeout()
  {
    return this.y;
  }
  
  public long getHttpTimeOut()
  {
    return this.i;
  }
  
  public long getInterval()
  {
    return this.h;
  }
  
  public long getLastLocationLifeCycle()
  {
    return this.x;
  }
  
  public AMapLocationMode getLocationMode()
  {
    return this.o;
  }
  
  public AMapLocationProtocol getLocationProtocol()
  {
    return p;
  }
  
  public AMapLocationPurpose getLocationPurpose()
  {
    return this.C;
  }
  
  public long getScanWifiInterval()
  {
    return SCAN_WIFI_INTERVAL;
  }
  
  public boolean isGpsFirst()
  {
    return this.r;
  }
  
  public boolean isKillProcess()
  {
    return this.q;
  }
  
  public boolean isLocationCacheEnable()
  {
    return this.t;
  }
  
  public boolean isMockEnable()
  {
    return this.k;
  }
  
  public boolean isNeedAddress()
  {
    return this.l;
  }
  
  public boolean isOffset()
  {
    return this.s;
  }
  
  public boolean isOnceLocation()
  {
    return this.j;
  }
  
  public boolean isOnceLocationLatest()
  {
    return this.u;
  }
  
  public boolean isSensorEnable()
  {
    return this.v;
  }
  
  public boolean isWifiActiveScan()
  {
    return this.m;
  }
  
  public boolean isWifiScan()
  {
    return this.w;
  }
  
  public AMapLocationClientOption setDeviceModeDistanceFilter(float paramFloat)
  {
    this.B = paramFloat;
    return this;
  }
  
  public AMapLocationClientOption setGeoLanguage(GeoLanguage paramGeoLanguage)
  {
    this.z = paramGeoLanguage;
    return this;
  }
  
  public AMapLocationClientOption setGpsFirst(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setGpsFirstTimeout(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 5000L) {
      l1 = 5000L;
    }
    paramLong = l1;
    if (l1 > 30000L) {
      paramLong = 30000L;
    }
    this.y = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setHttpTimeOut(long paramLong)
  {
    this.i = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setInterval(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong <= 800L) {
      l1 = 800L;
    }
    this.h = l1;
    return this;
  }
  
  public AMapLocationClientOption setKillProcess(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setLastLocationLifeCycle(long paramLong)
  {
    this.x = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setLocationCacheEnable(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setLocationMode(AMapLocationMode paramAMapLocationMode)
  {
    this.o = paramAMapLocationMode;
    return this;
  }
  
  public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose paramAMapLocationPurpose)
  {
    this.C = paramAMapLocationPurpose;
    if (paramAMapLocationPurpose != null)
    {
      switch (2.a[paramAMapLocationPurpose.ordinal()])
      {
      default: 
        return this;
      case 3: 
        if ((d & g) == 0)
        {
          this.b = true;
          d |= g;
          paramAMapLocationPurpose = "sport";
        }
        break;
      case 2: 
        if ((d & f) == 0)
        {
          this.b = true;
          d |= f;
          paramAMapLocationPurpose = "transport";
          this.c = paramAMapLocationPurpose;
        }
        this.o = AMapLocationMode.Hight_Accuracy;
        this.j = false;
        this.u = false;
        this.r = true;
        this.k = false;
        this.w = true;
        return this;
      }
      this.o = AMapLocationMode.Hight_Accuracy;
      this.j = true;
      this.u = true;
      this.r = false;
      this.k = false;
      this.w = true;
      if ((d & e) == 0)
      {
        this.b = true;
        d |= e;
        this.c = "signin";
      }
    }
    return this;
  }
  
  public AMapLocationClientOption setMockEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setNeedAddress(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOffset(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOnceLocation(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOnceLocationLatest(boolean paramBoolean)
  {
    this.u = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setSensorEnable(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setWifiActiveScan(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.n = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setWifiScan(boolean paramBoolean)
  {
    this.w = paramBoolean;
    if (this.w) {}
    for (paramBoolean = this.n;; paramBoolean = false)
    {
      this.m = paramBoolean;
      return this;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interval:");
    localStringBuilder.append(String.valueOf(this.h));
    localStringBuilder.append("#");
    localStringBuilder.append("isOnceLocation:");
    localStringBuilder.append(String.valueOf(this.j));
    localStringBuilder.append("#");
    localStringBuilder.append("locationMode:");
    localStringBuilder.append(String.valueOf(this.o));
    localStringBuilder.append("#");
    localStringBuilder.append("locationProtocol:");
    localStringBuilder.append(String.valueOf(p));
    localStringBuilder.append("#");
    localStringBuilder.append("isMockEnable:");
    localStringBuilder.append(String.valueOf(this.k));
    localStringBuilder.append("#");
    localStringBuilder.append("isKillProcess:");
    localStringBuilder.append(String.valueOf(this.q));
    localStringBuilder.append("#");
    localStringBuilder.append("isGpsFirst:");
    localStringBuilder.append(String.valueOf(this.r));
    localStringBuilder.append("#");
    localStringBuilder.append("isNeedAddress:");
    localStringBuilder.append(String.valueOf(this.l));
    localStringBuilder.append("#");
    localStringBuilder.append("isWifiActiveScan:");
    localStringBuilder.append(String.valueOf(this.m));
    localStringBuilder.append("#");
    localStringBuilder.append("wifiScan:");
    localStringBuilder.append(String.valueOf(this.w));
    localStringBuilder.append("#");
    localStringBuilder.append("httpTimeOut:");
    localStringBuilder.append(String.valueOf(this.i));
    localStringBuilder.append("#");
    localStringBuilder.append("isLocationCacheEnable:");
    localStringBuilder.append(String.valueOf(this.t));
    localStringBuilder.append("#");
    localStringBuilder.append("isOnceLocationLatest:");
    localStringBuilder.append(String.valueOf(this.u));
    localStringBuilder.append("#");
    localStringBuilder.append("sensorEnable:");
    localStringBuilder.append(String.valueOf(this.v));
    localStringBuilder.append("#");
    localStringBuilder.append("geoLanguage:");
    localStringBuilder.append(String.valueOf(this.z));
    localStringBuilder.append("#");
    localStringBuilder.append("locationPurpose:");
    localStringBuilder.append(String.valueOf(this.C));
    localStringBuilder.append("#");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static enum AMapLocationMode
  {
    private AMapLocationMode() {}
  }
  
  public static enum AMapLocationProtocol
  {
    private int a;
    
    private AMapLocationProtocol(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final int getValue()
    {
      return this.a;
    }
  }
  
  public static enum AMapLocationPurpose
  {
    private AMapLocationPurpose() {}
  }
  
  public static enum GeoLanguage
  {
    private GeoLanguage() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\AMapLocationClientOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */