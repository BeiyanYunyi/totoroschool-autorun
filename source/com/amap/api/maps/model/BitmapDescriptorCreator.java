package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BitmapDescriptorCreator
  implements Parcelable.Creator<BitmapDescriptor>
{
  public BitmapDescriptor createFromParcel(Parcel paramParcel)
  {
    BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(null, paramParcel.readString());
    localBitmapDescriptor.c = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    localBitmapDescriptor.a = paramParcel.readInt();
    localBitmapDescriptor.b = paramParcel.readInt();
    return localBitmapDescriptor;
  }
  
  public BitmapDescriptor[] newArray(int paramInt)
  {
    return new BitmapDescriptor[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\BitmapDescriptorCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */