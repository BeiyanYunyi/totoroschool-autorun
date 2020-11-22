package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DPoint
  implements Parcelable
{
  public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator() {};
  private double a = 0.0D;
  private double b = 0.0D;
  
  public DPoint() {}
  
  public DPoint(double paramDouble1, double paramDouble2)
  {
    double d1 = paramDouble2;
    if (paramDouble2 > 180.0D) {
      d1 = 180.0D;
    }
    double d2 = d1;
    if (d1 < -180.0D) {
      d2 = -180.0D;
    }
    paramDouble2 = paramDouble1;
    if (paramDouble1 > 90.0D) {
      paramDouble2 = 90.0D;
    }
    paramDouble1 = paramDouble2;
    if (paramDouble2 < -90.0D) {
      paramDouble1 = -90.0D;
    }
    this.a = d2;
    this.b = paramDouble1;
  }
  
  protected DPoint(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DPoint)) {
      return false;
    }
    paramObject = (DPoint)paramObject;
    if (this.b != ((DPoint)paramObject).b) {
      return false;
    }
    return this.a == ((DPoint)paramObject).a;
  }
  
  public double getLatitude()
  {
    return this.b;
  }
  
  public double getLongitude()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return Double.valueOf((this.b + this.a) * 1000000.0D).intValue();
  }
  
  public void setLatitude(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 90.0D) {
      d = 90.0D;
    }
    paramDouble = d;
    if (d < -90.0D) {
      paramDouble = -90.0D;
    }
    this.b = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 180.0D) {
      d = 180.0D;
    }
    paramDouble = d;
    if (d < -180.0D) {
      paramDouble = -180.0D;
    }
    this.a = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\DPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */