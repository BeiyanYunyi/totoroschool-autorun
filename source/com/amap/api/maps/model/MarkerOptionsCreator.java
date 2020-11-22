package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class MarkerOptionsCreator
  implements Parcelable.Creator<MarkerOptions>
{
  public MarkerOptions createFromParcel(Parcel paramParcel)
  {
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    localMarkerOptions.title(paramParcel.readString());
    localMarkerOptions.snippet(paramParcel.readString());
    localMarkerOptions.anchor(paramParcel.readFloat(), paramParcel.readFloat());
    localMarkerOptions.setInfoWindowOffset(paramParcel.readInt(), paramParcel.readInt());
    boolean[] arrayOfBoolean = new boolean[8];
    paramParcel.readBooleanArray(arrayOfBoolean);
    localMarkerOptions.visible(arrayOfBoolean[0]);
    localMarkerOptions.draggable(arrayOfBoolean[1]);
    localMarkerOptions.setGps(arrayOfBoolean[2]);
    localMarkerOptions.setFlat(arrayOfBoolean[3]);
    localMarkerOptions.autoOverturnInfoWindow(arrayOfBoolean[4]);
    localMarkerOptions.infoWindowEnable(arrayOfBoolean[5]);
    localMarkerOptions.belowMaskLayer(arrayOfBoolean[6]);
    localMarkerOptions.setRotatingMode(arrayOfBoolean[7]);
    localMarkerOptions.a = paramParcel.readString();
    localMarkerOptions.period(paramParcel.readInt());
    localMarkerOptions.icons(paramParcel.readArrayList(BitmapDescriptor.class.getClassLoader()));
    localMarkerOptions.zIndex(paramParcel.readFloat());
    localMarkerOptions.alpha(paramParcel.readFloat());
    localMarkerOptions.displayLevel(paramParcel.readInt());
    localMarkerOptions.rotateAngle(paramParcel.readFloat());
    paramParcel = (BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader());
    if (paramParcel != null) {
      localMarkerOptions.icon(paramParcel);
    }
    return localMarkerOptions;
  }
  
  public MarkerOptions[] newArray(int paramInt)
  {
    return new MarkerOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MarkerOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */