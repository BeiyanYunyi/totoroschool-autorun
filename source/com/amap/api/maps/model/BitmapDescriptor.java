package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;

public final class BitmapDescriptor
  implements Parcelable, Cloneable
{
  public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
  int a = 0;
  int b = 0;
  Bitmap c;
  private String mId;
  
  private BitmapDescriptor(Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBitmap;
    this.mId = paramString;
  }
  
  BitmapDescriptor(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null)
    {
      this.a = paramBitmap.getWidth();
      this.b = paramBitmap.getHeight();
      if (paramBitmap.getConfig() == null) {
        this.c = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      } else {
        this.c = paramBitmap.copy(paramBitmap.getConfig(), true);
      }
      this.mId = paramString;
    }
  }
  
  public BitmapDescriptor clone()
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(this.c.copy(this.c.getConfig(), true), this.a, this.b, this.mId);
      return localBitmapDescriptor;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this.c != null)
    {
      if (this.c.isRecycled()) {
        return false;
      }
      if (paramObject == null) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BitmapDescriptor)paramObject;
      if (((BitmapDescriptor)paramObject).c != null)
      {
        if (((BitmapDescriptor)paramObject).c.isRecycled()) {
          return false;
        }
        if (this.a == ((BitmapDescriptor)paramObject).getWidth()) {
          if (this.b != ((BitmapDescriptor)paramObject).getHeight()) {
            return false;
          }
        }
      }
    }
    try
    {
      boolean bool = this.c.sameAs(((BitmapDescriptor)paramObject).c);
      return bool;
    }
    catch (Throwable paramObject) {}
    return false;
    return false;
    return false;
    return false;
  }
  
  public Bitmap getBitmap()
  {
    return this.c;
  }
  
  public int getHeight()
  {
    return this.b;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public int getWidth()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public void recycle()
  {
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      if (Build.VERSION.SDK_INT <= 10) {
        this.c.recycle();
      }
      this.c = null;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\BitmapDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */