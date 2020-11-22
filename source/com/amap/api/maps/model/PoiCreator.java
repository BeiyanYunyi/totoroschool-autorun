package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PoiCreator
  implements Parcelable.Creator<Poi>
{
  public Poi createFromParcel(Parcel paramParcel)
  {
    return new Poi(paramParcel.readString(), (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()), paramParcel.readString());
  }
  
  public Poi[] newArray(int paramInt)
  {
    return new Poi[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\PoiCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */