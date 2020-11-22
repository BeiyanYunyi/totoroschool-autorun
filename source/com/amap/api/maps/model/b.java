package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class b
  implements Parcelable.Creator<Tile>
{
  public Tile a(Parcel paramParcel)
  {
    return new Tile(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.createByteArray());
  }
  
  public Tile[] a(int paramInt)
  {
    return new Tile[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */