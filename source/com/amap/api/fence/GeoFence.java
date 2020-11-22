package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.loc.dn;
import java.util.ArrayList;
import java.util.List;

public class GeoFence
  implements Parcelable
{
  public static final int ADDGEOFENCE_SUCCESS = 0;
  public static final String BUNDLE_KEY_CUSTOMID = "customId";
  public static final String BUNDLE_KEY_FENCE = "fence";
  public static final String BUNDLE_KEY_FENCEID = "fenceid";
  public static final String BUNDLE_KEY_FENCESTATUS = "event";
  public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
  public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator() {};
  public static final int ERROR_CODE_EXISTS = 17;
  public static final int ERROR_CODE_FAILURE_AUTH = 7;
  public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
  public static final int ERROR_CODE_FAILURE_PARSER = 5;
  public static final int ERROR_CODE_INVALID_PARAMETER = 1;
  public static final int ERROR_CODE_UNKNOWN = 8;
  public static final int ERROR_NO_VALIDFENCE = 16;
  public static final int STATUS_IN = 1;
  public static final int STATUS_LOCFAIL = 4;
  public static final int STATUS_OUT = 2;
  public static final int STATUS_STAYED = 3;
  public static final int STATUS_UNKNOWN = 0;
  public static final int TYPE_AMAPPOI = 2;
  public static final int TYPE_DISTRICT = 3;
  public static final int TYPE_POLYGON = 1;
  public static final int TYPE_ROUND = 0;
  private String a;
  private String b;
  private String c;
  private PendingIntent d = null;
  private int e;
  private PoiItem f;
  private List<DistrictItem> g;
  private List<List<DPoint>> h;
  private float i;
  private long j;
  private int k;
  private float l;
  private float m;
  private DPoint n;
  private int o;
  private long p;
  private boolean q;
  private AMapLocation r;
  
  public GeoFence()
  {
    this.e = 0;
    this.f = null;
    this.g = null;
    this.i = 0.0F;
    this.j = -1L;
    this.k = 1;
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = null;
    this.o = 0;
    this.p = -1L;
    this.q = true;
    this.r = null;
  }
  
  protected GeoFence(Parcel paramParcel)
  {
    boolean bool = false;
    this.e = 0;
    this.f = null;
    this.g = null;
    this.i = 0.0F;
    this.j = -1L;
    this.k = 1;
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = null;
    this.o = 0;
    this.p = -1L;
    this.q = true;
    this.r = null;
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    this.e = paramParcel.readInt();
    this.f = ((PoiItem)paramParcel.readParcelable(PoiItem.class.getClassLoader()));
    this.g = paramParcel.createTypedArrayList(DistrictItem.CREATOR);
    this.i = paramParcel.readFloat();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readFloat();
    this.m = paramParcel.readFloat();
    this.n = ((DPoint)paramParcel.readParcelable(DPoint.class.getClassLoader()));
    this.o = paramParcel.readInt();
    this.p = paramParcel.readLong();
    int i2 = paramParcel.readInt();
    if (i2 != 0)
    {
      this.h = new ArrayList();
      int i1 = 0;
      while (i1 < i2)
      {
        this.h.add(paramParcel.createTypedArrayList(DPoint.CREATOR));
        i1 += 1;
      }
    }
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.q = bool;
    this.r = ((AMapLocation)paramParcel.readParcelable(AMapLocation.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GeoFence)) {
      return false;
    }
    paramObject = (GeoFence)paramObject;
    if (TextUtils.isEmpty(this.b))
    {
      if (!TextUtils.isEmpty(((GeoFence)paramObject).b)) {
        return false;
      }
    }
    else if (!this.b.equals(((GeoFence)paramObject).b)) {
      return false;
    }
    if (this.n == null)
    {
      if (((GeoFence)paramObject).n != null) {
        return false;
      }
    }
    else if (!this.n.equals(((GeoFence)paramObject).n)) {
      return false;
    }
    if (this.i != ((GeoFence)paramObject).i) {
      return false;
    }
    if (this.h == null)
    {
      if (((GeoFence)paramObject).h != null) {
        return false;
      }
    }
    else if (!this.h.equals(((GeoFence)paramObject).h)) {
      return false;
    }
    return true;
  }
  
  public int getActivatesAction()
  {
    return this.k;
  }
  
  public DPoint getCenter()
  {
    return this.n;
  }
  
  public AMapLocation getCurrentLocation()
  {
    return this.r;
  }
  
  public String getCustomId()
  {
    return this.b;
  }
  
  public List<DistrictItem> getDistrictItemList()
  {
    return this.g;
  }
  
  public long getEnterTime()
  {
    return this.p;
  }
  
  public long getExpiration()
  {
    return this.j;
  }
  
  public String getFenceId()
  {
    return this.a;
  }
  
  public float getMaxDis2Center()
  {
    return this.m;
  }
  
  public float getMinDis2Center()
  {
    return this.l;
  }
  
  public PendingIntent getPendingIntent()
  {
    return this.d;
  }
  
  public String getPendingIntentAction()
  {
    return this.c;
  }
  
  public PoiItem getPoiItem()
  {
    return this.f;
  }
  
  public List<List<DPoint>> getPointList()
  {
    return this.h;
  }
  
  public float getRadius()
  {
    return this.i;
  }
  
  public int getStatus()
  {
    return this.o;
  }
  
  public int getType()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return this.b.hashCode() + this.h.hashCode() + this.n.hashCode() + (int)(this.i * 100.0F);
  }
  
  public boolean isAble()
  {
    return this.q;
  }
  
  public void setAble(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setActivatesAction(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setCenter(DPoint paramDPoint)
  {
    this.n = paramDPoint;
  }
  
  public void setCurrentLocation(AMapLocation paramAMapLocation)
  {
    this.r = paramAMapLocation.clone();
  }
  
  public void setCustomId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDistrictItemList(List<DistrictItem> paramList)
  {
    this.g = paramList;
  }
  
  public void setEnterTime(long paramLong)
  {
    this.p = paramLong;
  }
  
  public void setExpiration(long paramLong)
  {
    if (paramLong < 0L) {}
    for (paramLong = -1L;; paramLong += dn.b())
    {
      this.j = paramLong;
      return;
    }
  }
  
  public void setFenceId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setMaxDis2Center(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  public void setMinDis2Center(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void setPendingIntent(PendingIntent paramPendingIntent)
  {
    this.d = paramPendingIntent;
  }
  
  public void setPendingIntentAction(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPoiItem(PoiItem paramPoiItem)
  {
    this.f = paramPoiItem;
  }
  
  public void setPointList(List<List<DPoint>> paramList)
  {
    this.h = paramList;
  }
  
  public void setRadius(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setStatus(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\GeoFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */