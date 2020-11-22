package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class LatLngBoundsCreator
  implements Parcelable.Creator<LatLngBounds>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(paramLatLngBounds.a());
    paramParcel.writeParcelable(paramLatLngBounds.southwest, paramInt);
    paramParcel.writeParcelable(paramLatLngBounds.northeast, paramInt);
  }
  
  public LatLngBounds createFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    try
    {
      Object localObject = (LatLng)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
      try
      {
        LatLng localLatLng2 = (LatLng)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
        paramParcel = (Parcel)localObject;
        localObject = localLatLng2;
      }
      catch (BadParcelableException localBadParcelableException2)
      {
        paramParcel = (Parcel)localObject;
        localObject = localBadParcelableException2;
      }
      localBadParcelableException1.printStackTrace();
    }
    catch (BadParcelableException localBadParcelableException1)
    {
      paramParcel = null;
    }
    LatLng localLatLng1 = null;
    return new LatLngBounds(i, paramParcel, localLatLng1);
  }
  
  public LatLngBounds[] newArray(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\LatLngBoundsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */