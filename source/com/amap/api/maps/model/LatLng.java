package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;

public final class LatLng
  implements Parcelable, Cloneable
{
  public static final LatLngCreator CREATOR = new LatLngCreator();
  public final double latitude;
  public final double longitude;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    this(paramDouble1, paramDouble2, true);
  }
  
  public LatLng(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {
        this.longitude = paramDouble2;
      } else {
        this.longitude = (((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D);
      }
      if ((paramDouble1 < -90.0D) || (paramDouble1 > 90.0D)) {
        try
        {
          throw new AMapException("非法坐标值");
        }
        catch (AMapException localAMapException)
        {
          localAMapException.printStackTrace();
        }
      }
      this.latitude = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
      return;
    }
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }
  
  public LatLng clone()
  {
    return new LatLng(this.latitude, this.longitude);
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
    if (!(paramObject instanceof LatLng)) {
      return false;
    }
    paramObject = (LatLng)paramObject;
    return (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(((LatLng)paramObject).latitude)) && (Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(((LatLng)paramObject).longitude));
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    return (i + 31) * 31 + (int)(l >>> 32 ^ l);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lat/lng: (");
    localStringBuilder.append(this.latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(this.longitude);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.latitude);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */