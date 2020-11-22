package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class PolylineOptionsCreator
  implements Parcelable.Creator<PolylineOptions>
{
  public PolylineOptions createFromParcel(Parcel paramParcel)
  {
    PolylineOptions localPolylineOptions = new PolylineOptions();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readTypedList(localArrayList, LatLng.CREATOR);
    float f1 = paramParcel.readFloat();
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    float f2 = paramParcel.readFloat();
    float f3 = paramParcel.readFloat();
    localPolylineOptions.a = paramParcel.readString();
    localPolylineOptions.lineCapType(PolylineOptions.LineCapType.valueOf(paramParcel.readInt()));
    localPolylineOptions.lineJoinType(PolylineOptions.LineJoinType.valueOf(paramParcel.readInt()));
    boolean[] arrayOfBoolean = new boolean[5];
    paramParcel.readBooleanArray(arrayOfBoolean);
    BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader());
    localPolylineOptions.addAll(localArrayList);
    localPolylineOptions.width(f1);
    localPolylineOptions.color(i);
    localPolylineOptions.setDottedLineType(j);
    localPolylineOptions.zIndex(f2);
    localPolylineOptions.transparency(f3);
    localPolylineOptions.visible(arrayOfBoolean[0]);
    localPolylineOptions.setDottedLine(arrayOfBoolean[1]);
    localPolylineOptions.geodesic(arrayOfBoolean[2]);
    localPolylineOptions.useGradient(arrayOfBoolean[3]);
    localPolylineOptions.aboveMaskLayer(arrayOfBoolean[4]);
    localPolylineOptions.setCustomTexture(localBitmapDescriptor);
    localPolylineOptions.setCustomTextureList(paramParcel.readArrayList(BitmapDescriptor.class.getClassLoader()));
    localPolylineOptions.setCustomTextureIndex(paramParcel.readArrayList(Integer.class.getClassLoader()));
    localPolylineOptions.colorValues(paramParcel.readArrayList(Integer.class.getClassLoader()));
    localPolylineOptions.setShownRatio(paramParcel.readFloat());
    return localPolylineOptions;
  }
  
  public PolylineOptions[] newArray(int paramInt)
  {
    return new PolylineOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\PolylineOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */