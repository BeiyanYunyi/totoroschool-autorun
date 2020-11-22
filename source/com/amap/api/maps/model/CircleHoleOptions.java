package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CircleHoleOptions
  extends BaseHoleOptions
  implements Parcelable
{
  public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator()
  {
    public CircleHoleOptions a(Parcel paramAnonymousParcel)
    {
      return new CircleHoleOptions(paramAnonymousParcel);
    }
    
    public CircleHoleOptions[] a(int paramAnonymousInt)
    {
      return new CircleHoleOptions[paramAnonymousInt];
    }
  };
  private LatLng point = null;
  private double radius = 0.0D;
  
  public CircleHoleOptions()
  {
    this.isPolygonHoleOptions = false;
  }
  
  protected CircleHoleOptions(Parcel paramParcel)
  {
    Bundle localBundle = paramParcel.readBundle();
    this.point = new LatLng(localBundle.getDouble("lat"), localBundle.getDouble("lng"));
    this.radius = paramParcel.readDouble();
  }
  
  public CircleHoleOptions center(LatLng paramLatLng)
  {
    this.point = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getCenter()
  {
    return this.point;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public CircleHoleOptions radius(double paramDouble)
  {
    this.radius = paramDouble;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (this.point != null)
    {
      localBundle.putDouble("lat", this.point.latitude);
      localBundle.putDouble("lng", this.point.longitude);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeDouble(this.radius);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CircleHoleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */