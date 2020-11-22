package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public final class Tile
  implements Parcelable
{
  public static final b CREATOR = new b();
  private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool(18);
  public final byte[] data;
  public final int height;
  private final int mVersionCode;
  public final int width;
  
  Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.data = paramArrayOfByte;
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public static Tile obtain(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Tile localTile = (Tile)M_POOL.acquire();
    if (localTile != null) {
      return localTile;
    }
    return new Tile(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mVersionCode);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeByteArray(this.data);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */