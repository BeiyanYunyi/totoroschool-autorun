package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator
  implements Parcelable.Creator<PolygonOptions>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public PolygonOptions createFromParcel(Parcel paramParcel)
  {
    PolygonOptions localPolygonOptions = new PolygonOptions();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readTypedList(localArrayList, LatLng.CREATOR);
    float f1 = paramParcel.readFloat();
    int j = paramParcel.readInt();
    int k = paramParcel.readInt();
    float f2 = paramParcel.readFloat();
    int i = paramParcel.readByte();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    LatLng[] arrayOfLatLng = new LatLng[localArrayList.size()];
    i = 0;
    while (i < localArrayList.size())
    {
      arrayOfLatLng[i] = ((LatLng)localArrayList.get(i));
      i += 1;
    }
    localPolygonOptions.add(arrayOfLatLng);
    localPolygonOptions.strokeWidth(f1);
    localPolygonOptions.strokeColor(j);
    localPolygonOptions.fillColor(k);
    localPolygonOptions.zIndex(f2);
    localPolygonOptions.visible(bool1);
    localPolygonOptions.a = paramParcel.readString();
    localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, BaseHoleOptions.class.getClassLoader());
    localPolygonOptions.addHoles(localArrayList);
    localPolygonOptions.lineJoinType(AMapPara.LineJoinType.valueOf(paramParcel.readInt()));
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    localPolygonOptions.usePolylineStroke(bool1);
    return localPolygonOptions;
  }
  
  public PolygonOptions[] newArray(int paramInt)
  {
    return new PolygonOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\PolygonOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */