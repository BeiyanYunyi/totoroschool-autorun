package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ArcOptionsCreator
  implements Parcelable.Creator<ArcOptions>
{
  public ArcOptions createFromParcel(Parcel paramParcel)
  {
    ArcOptions localArcOptions = new ArcOptions();
    Bundle localBundle = paramParcel.readBundle();
    localArcOptions.point(new LatLng(localBundle.getDouble("startlat"), localBundle.getDouble("startlng")), new LatLng(localBundle.getDouble("passedlat"), localBundle.getDouble("passedlng")), new LatLng(localBundle.getDouble("endlat"), localBundle.getDouble("endlng")));
    localArcOptions.strokeWidth(paramParcel.readFloat());
    localArcOptions.strokeColor(paramParcel.readInt());
    localArcOptions.zIndex(paramParcel.readFloat());
    int i = paramParcel.readByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localArcOptions.visible(bool);
    localArcOptions.a = paramParcel.readString();
    return localArcOptions;
  }
  
  public ArcOptions[] newArray(int paramInt)
  {
    return new ArcOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\ArcOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */