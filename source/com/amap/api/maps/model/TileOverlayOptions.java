package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions
  implements Parcelable
{
  public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
  private String diskCacheDir = null;
  private boolean diskCacheEnabled = true;
  private long diskCacheSize = 20971520L;
  private TileProvider mTileProvider;
  private final int mVersionCode;
  private boolean mVisible = true;
  private float mZIndex;
  private int memCacheSize = 5242880;
  private boolean memoryCacheEnabled = true;
  
  public TileOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean, float paramFloat)
  {
    this.mVersionCode = paramInt;
    this.mVisible = paramBoolean;
    this.mZIndex = paramFloat;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions diskCacheDir(String paramString)
  {
    this.diskCacheDir = paramString;
    return this;
  }
  
  public TileOverlayOptions diskCacheEnabled(boolean paramBoolean)
  {
    this.diskCacheEnabled = paramBoolean;
    return this;
  }
  
  public TileOverlayOptions diskCacheSize(int paramInt)
  {
    this.diskCacheSize = (paramInt * 1024);
    return this;
  }
  
  public String getDiskCacheDir()
  {
    return this.diskCacheDir;
  }
  
  public boolean getDiskCacheEnabled()
  {
    return this.diskCacheEnabled;
  }
  
  public long getDiskCacheSize()
  {
    return this.diskCacheSize;
  }
  
  public int getMemCacheSize()
  {
    return this.memCacheSize;
  }
  
  public boolean getMemoryCacheEnabled()
  {
    return this.memoryCacheEnabled;
  }
  
  public TileProvider getTileProvider()
  {
    return this.mTileProvider;
  }
  
  public float getZIndex()
  {
    return this.mZIndex;
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public TileOverlayOptions memCacheSize(int paramInt)
  {
    this.memCacheSize = paramInt;
    return this;
  }
  
  public TileOverlayOptions memoryCacheEnabled(boolean paramBoolean)
  {
    this.memoryCacheEnabled = paramBoolean;
    return this;
  }
  
  public TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.mTileProvider = paramTileProvider;
    return this;
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.mVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mVersionCode);
    paramParcel.writeValue(this.mTileProvider);
    paramParcel.writeByte((byte)this.mVisible);
    paramParcel.writeFloat(this.mZIndex);
    paramParcel.writeInt(this.memCacheSize);
    paramParcel.writeLong(this.diskCacheSize);
    paramParcel.writeString(this.diskCacheDir);
    paramParcel.writeByte((byte)this.memoryCacheEnabled);
    paramParcel.writeByte((byte)this.diskCacheEnabled);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.mZIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */