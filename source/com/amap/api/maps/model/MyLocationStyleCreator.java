package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class MyLocationStyleCreator
  implements Parcelable.Creator<MyLocationStyle>
{
  public MyLocationStyle createFromParcel(Parcel paramParcel)
  {
    MyLocationStyle localMyLocationStyle = new MyLocationStyle();
    localMyLocationStyle.myLocationIcon((BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
    localMyLocationStyle.anchor(paramParcel.readFloat(), paramParcel.readFloat());
    localMyLocationStyle.radiusFillColor(paramParcel.readInt());
    localMyLocationStyle.strokeColor(paramParcel.readInt());
    localMyLocationStyle.strokeWidth(paramParcel.readFloat());
    localMyLocationStyle.myLocationType(paramParcel.readInt());
    localMyLocationStyle.interval(paramParcel.readLong());
    boolean[] arrayOfBoolean = new boolean[7];
    paramParcel.readBooleanArray(arrayOfBoolean);
    localMyLocationStyle.showMyLocation(arrayOfBoolean[0]);
    return localMyLocationStyle;
  }
  
  public MyLocationStyle[] newArray(int paramInt)
  {
    return new MyLocationStyle[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MyLocationStyleCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */