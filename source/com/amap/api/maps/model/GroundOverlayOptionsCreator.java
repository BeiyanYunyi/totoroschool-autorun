package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GroundOverlayOptionsCreator
  implements Parcelable.Creator<GroundOverlayOptions>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public GroundOverlayOptions createFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader());
    LatLng localLatLng = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
    float f1 = paramParcel.readFloat();
    float f2 = paramParcel.readFloat();
    LatLngBounds localLatLngBounds = (LatLngBounds)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
    float f3 = paramParcel.readFloat();
    float f4 = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramParcel = new GroundOverlayOptions(i, null, localLatLng, f1, f2, localLatLngBounds, f3, f4, bool, paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
    paramParcel.image(localBitmapDescriptor);
    return paramParcel;
  }
  
  public GroundOverlayOptions[] newArray(int paramInt)
  {
    return new GroundOverlayOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\GroundOverlayOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */