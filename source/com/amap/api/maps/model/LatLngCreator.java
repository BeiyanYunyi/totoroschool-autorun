package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class LatLngCreator
  implements Parcelable.Creator<LatLng>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public LatLng createFromParcel(Parcel paramParcel)
  {
    double d = paramParcel.readDouble();
    return new LatLng(paramParcel.readDouble(), d);
  }
  
  public LatLng[] newArray(int paramInt)
  {
    return new LatLng[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\LatLngCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */