package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class CircleOptionsCreator
  implements Parcelable.Creator<CircleOptions>
{
  public CircleOptions createFromParcel(Parcel paramParcel)
  {
    CircleOptions localCircleOptions = new CircleOptions();
    Object localObject = paramParcel.readBundle();
    localCircleOptions.center(new LatLng(((Bundle)localObject).getDouble("lat"), ((Bundle)localObject).getDouble("lng")));
    localCircleOptions.radius(paramParcel.readDouble());
    localCircleOptions.strokeWidth(paramParcel.readFloat());
    localCircleOptions.strokeColor(paramParcel.readInt());
    localCircleOptions.fillColor(paramParcel.readInt());
    localCircleOptions.zIndex(paramParcel.readFloat());
    int i = paramParcel.readByte();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localCircleOptions.visible(bool1);
    localCircleOptions.a = paramParcel.readString();
    localObject = new ArrayList();
    paramParcel.readList((List)localObject, BaseHoleOptions.class.getClassLoader());
    localCircleOptions.addHoles((Iterable)localObject);
    localCircleOptions.setStrokeDottedLineType(paramParcel.readInt());
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    localCircleOptions.usePolylineStroke(bool1);
    return localCircleOptions;
  }
  
  public CircleOptions[] newArray(int paramInt)
  {
    return new CircleOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CircleOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */