package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TileProjection
  implements Parcelable
{
  public static final TileProjection CREATOR = new TileProjection(0, 0, 0, 0, 0, 0);
  public final int maxX;
  public final int maxY;
  public final int minX;
  public final int minY;
  public final int offsetX;
  public final int offsetY;
  
  public TileProjection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.offsetX = paramInt1;
    this.offsetY = paramInt2;
    this.minX = paramInt3;
    this.maxX = paramInt4;
    this.minY = paramInt5;
    this.maxY = paramInt6;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.offsetX);
    paramParcel.writeInt(this.offsetY);
    paramParcel.writeInt(this.minX);
    paramParcel.writeInt(this.maxX);
    paramParcel.writeInt(this.maxX);
    paramParcel.writeInt(this.maxY);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */