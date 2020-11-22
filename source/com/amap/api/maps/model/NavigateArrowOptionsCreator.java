package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class NavigateArrowOptionsCreator
  implements Parcelable.Creator<NavigateArrowOptions>
{
  public NavigateArrowOptions createFromParcel(Parcel paramParcel)
  {
    NavigateArrowOptions localNavigateArrowOptions = new NavigateArrowOptions();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readTypedList(localArrayList, LatLng.CREATOR);
    float f1 = paramParcel.readFloat();
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    float f2 = paramParcel.readFloat();
    int k = paramParcel.readByte();
    boolean bool2 = false;
    boolean bool1;
    if (k == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramParcel.readByte() == 1) {
      bool2 = true;
    }
    localNavigateArrowOptions.addAll(localArrayList);
    localNavigateArrowOptions.width(f1);
    localNavigateArrowOptions.topColor(i);
    localNavigateArrowOptions.sideColor(j);
    localNavigateArrowOptions.zIndex(f2);
    localNavigateArrowOptions.visible(bool1);
    localNavigateArrowOptions.a = paramParcel.readString();
    localNavigateArrowOptions.set3DModel(bool2);
    return localNavigateArrowOptions;
  }
  
  public NavigateArrowOptions[] newArray(int paramInt)
  {
    return new NavigateArrowOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\NavigateArrowOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */