package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.maps.model.CameraPosition;

public class AMapOptionsCreator
  implements Parcelable.Creator<AMapOptions>
{
  public AMapOptions createFromParcel(Parcel paramParcel)
  {
    AMapOptions localAMapOptions = new AMapOptions();
    CameraPosition localCameraPosition = (CameraPosition)paramParcel.readParcelable(CameraPosition.class.getClassLoader());
    localAMapOptions.mapType(paramParcel.readInt());
    localAMapOptions.camera(localCameraPosition);
    paramParcel = paramParcel.createBooleanArray();
    if ((paramParcel != null) && (paramParcel.length >= 6))
    {
      localAMapOptions.rotateGesturesEnabled(paramParcel[0]);
      localAMapOptions.scrollGesturesEnabled(paramParcel[1]);
      localAMapOptions.tiltGesturesEnabled(paramParcel[2]);
      localAMapOptions.zoomGesturesEnabled(paramParcel[3]);
      localAMapOptions.zoomControlsEnabled(paramParcel[4]);
      localAMapOptions.zOrderOnTop(paramParcel[5]);
      localAMapOptions.compassEnabled(paramParcel[6]);
      localAMapOptions.scaleControlsEnabled(paramParcel[7]);
    }
    return localAMapOptions;
  }
  
  public AMapOptions[] newArray(int paramInt)
  {
    return new AMapOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\AMapOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */