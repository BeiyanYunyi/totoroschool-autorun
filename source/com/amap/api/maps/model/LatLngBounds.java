package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.dx;

public final class LatLngBounds
  implements Parcelable
{
  private static final String CLASSNAME = "LatLngBounds";
  public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
  private final int mVersionCode;
  public final LatLng northeast;
  public final LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 != null)) {}
    try
    {
      if (paramLatLng2.latitude >= paramLatLng1.latitude)
      {
        i = 1;
        break label134;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("southern latitude exceeds northern latitude (");
      localStringBuilder.append(paramLatLng1.latitude);
      localStringBuilder.append(" > ");
      localStringBuilder.append(paramLatLng2.latitude);
      localStringBuilder.append(")");
      throw new RuntimeRemoteException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      Log.e("LatLngBounds", "the structure parameters are illegal!");
      localThrowable.printStackTrace();
      int i = 0;
      label134:
      if (i != 0) {
        break label144;
      }
      paramInt = 0;
      label144:
      this.mVersionCode = paramInt;
      Object localObject = null;
      if (i != 0) {
        break label162;
      }
      paramLatLng1 = null;
      label162:
      this.southwest = paramLatLng1;
      paramLatLng1 = (LatLng)localObject;
      if (i == 0) {
        break label177;
      }
      paramLatLng1 = paramLatLng2;
      label177:
      this.northeast = paramLatLng1;
    }
    throw new RuntimeRemoteException("null northeast");
    throw new RuntimeRemoteException("null southwest");
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  private boolean a(double paramDouble)
  {
    return (this.southwest.latitude <= paramDouble) && (paramDouble <= this.northeast.latitude);
  }
  
  private boolean a(LatLngBounds paramLatLngBounds)
  {
    boolean bool2 = false;
    if ((paramLatLngBounds != null) && (paramLatLngBounds.northeast != null))
    {
      if (paramLatLngBounds.southwest == null) {
        return false;
      }
      double d1 = paramLatLngBounds.northeast.longitude;
      double d2 = paramLatLngBounds.southwest.longitude;
      double d3 = this.northeast.longitude;
      double d4 = this.southwest.longitude;
      double d5 = this.northeast.longitude;
      double d6 = this.southwest.longitude;
      double d7 = paramLatLngBounds.northeast.longitude;
      double d8 = this.southwest.longitude;
      double d9 = paramLatLngBounds.northeast.latitude;
      double d10 = paramLatLngBounds.southwest.latitude;
      double d11 = this.northeast.latitude;
      double d12 = this.southwest.latitude;
      double d13 = this.northeast.latitude;
      double d14 = this.southwest.latitude;
      double d15 = paramLatLngBounds.northeast.latitude;
      double d16 = paramLatLngBounds.southwest.latitude;
      boolean bool1 = bool2;
      if (Math.abs(d1 + d2 - d3 - d4) < d5 - d6 + d7 - d8)
      {
        bool1 = bool2;
        if (Math.abs(d9 + d10 - d11 - d12) < d13 - d14 + d15 - d16) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  private boolean b(double paramDouble)
  {
    double d1 = this.southwest.longitude;
    double d2 = this.northeast.longitude;
    boolean bool = true;
    if (d1 <= d2) {
      return (this.southwest.longitude <= paramDouble) && (paramDouble <= this.northeast.longitude);
    }
    if (this.southwest.longitude > paramDouble)
    {
      if (paramDouble <= this.northeast.longitude) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  int a()
  {
    return this.mVersionCode;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    boolean bool2 = false;
    if (paramLatLng == null) {
      return false;
    }
    if ((this.northeast != null) && (this.southwest != null))
    {
      boolean bool1 = bool2;
      if (a(paramLatLng.latitude))
      {
        bool1 = bool2;
        if (b(paramLatLng.longitude)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
    return false;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    boolean bool2 = false;
    if (paramLatLngBounds == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (contains(paramLatLngBounds.southwest))
    {
      bool1 = bool2;
      if (contains(paramLatLngBounds.northeast)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LatLngBounds)) {
      return false;
    }
    paramObject = (LatLngBounds)paramObject;
    return (this.southwest.equals(((LatLngBounds)paramObject).southwest)) && (this.northeast.equals(((LatLngBounds)paramObject).northeast));
  }
  
  public int hashCode()
  {
    return dx.a(new Object[] { this.southwest, this.northeast });
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return this;
    }
    if ((this.northeast != null) && (this.southwest != null))
    {
      double d5 = Math.min(this.southwest.latitude, paramLatLng.latitude);
      double d6 = Math.max(this.northeast.latitude, paramLatLng.latitude);
      double d4 = this.northeast.longitude;
      double d2 = this.southwest.longitude;
      double d3 = paramLatLng.longitude;
      double d1 = d2;
      if (!b(d3)) {
        if (c(d2, d3) < d(d4, d3))
        {
          d1 = d3;
        }
        else
        {
          d1 = d2;
          break label125;
        }
      }
      d3 = d4;
      try
      {
        label125:
        paramLatLng = new LatLngBounds(new LatLng(d5, d1, false), new LatLng(d6, d3, false));
        return paramLatLng;
      }
      catch (Throwable paramLatLng)
      {
        paramLatLng.printStackTrace();
        return this;
      }
    }
    Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
    return this;
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    boolean bool = false;
    if (paramLatLngBounds == null) {
      return false;
    }
    if ((this.northeast != null) && (this.southwest != null))
    {
      if ((a(paramLatLngBounds)) || (paramLatLngBounds.a(this))) {
        bool = true;
      }
      return bool;
    }
    Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
    return false;
  }
  
  public String toString()
  {
    return dx.a(new String[] { dx.a("southwest", this.southwest), dx.a("northeast", this.northeast) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LatLngBoundsCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private double mEast = NaN.0D;
    private double mNorth = Double.NEGATIVE_INFINITY;
    private double mSouth = Double.POSITIVE_INFINITY;
    private double mWest = NaN.0D;
    
    private boolean a(double paramDouble)
    {
      double d1 = this.mWest;
      double d2 = this.mEast;
      boolean bool = true;
      if (d1 <= d2) {
        return (this.mWest <= paramDouble) && (paramDouble <= this.mEast);
      }
      if (this.mWest > paramDouble)
      {
        if (paramDouble <= this.mEast) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    
    public LatLngBounds build()
    {
      if (Double.isNaN(this.mWest))
      {
        Log.w("LatLngBounds", "no included points");
        return null;
      }
      double d;
      if (this.mWest > this.mEast)
      {
        d = this.mWest;
        this.mWest = this.mEast;
        this.mEast = d;
      }
      if (this.mSouth > this.mNorth)
      {
        d = this.mSouth;
        this.mSouth = this.mNorth;
        this.mNorth = d;
      }
      return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
    }
    
    public Builder include(LatLng paramLatLng)
    {
      if (paramLatLng == null) {
        return this;
      }
      this.mSouth = Math.min(this.mSouth, paramLatLng.latitude);
      this.mNorth = Math.max(this.mNorth, paramLatLng.latitude);
      double d = paramLatLng.longitude;
      if (Double.isNaN(this.mWest))
      {
        this.mWest = d;
        this.mEast = d;
        return this;
      }
      if (!a(d))
      {
        if (LatLngBounds.a(this.mWest, d) < LatLngBounds.b(this.mEast, d))
        {
          this.mWest = d;
          return this;
        }
        this.mEast = d;
      }
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */