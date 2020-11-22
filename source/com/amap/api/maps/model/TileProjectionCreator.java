package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class TileProjectionCreator
  implements Parcelable.Creator<TileProjection>
{
  public TileProjection createFromParcel(Parcel paramParcel)
  {
    return new TileProjection(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public TileProjection[] newArray(int paramInt)
  {
    return new TileProjection[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileProjectionCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */