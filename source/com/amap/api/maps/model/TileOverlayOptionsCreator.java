package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class TileOverlayOptionsCreator
  implements Parcelable.Creator<TileOverlayOptions>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public TileOverlayOptions createFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    TileProvider localTileProvider = (TileProvider)paramParcel.readValue(TileProvider.class.getClassLoader());
    int j = paramParcel.readByte();
    boolean bool3 = false;
    boolean bool1;
    if (j != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    float f = paramParcel.readFloat();
    j = paramParcel.readInt();
    int k = paramParcel.readInt();
    String str = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramParcel.readByte() != 0) {
      bool3 = true;
    }
    paramParcel = new TileOverlayOptions(i, null, bool1, f);
    if (localTileProvider != null) {
      paramParcel.tileProvider(localTileProvider);
    }
    paramParcel.memCacheSize(j);
    paramParcel.diskCacheSize(k);
    paramParcel.diskCacheDir(str);
    paramParcel.memoryCacheEnabled(bool2);
    paramParcel.diskCacheEnabled(bool3);
    return paramParcel;
  }
  
  public TileOverlayOptions[] newArray(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileOverlayOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */