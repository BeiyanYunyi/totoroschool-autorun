package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PolygonHoleOptions
  extends BaseHoleOptions
  implements Parcelable
{
  public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = new Parcelable.Creator()
  {
    public PolygonHoleOptions a(Parcel paramAnonymousParcel)
    {
      return new PolygonHoleOptions(paramAnonymousParcel);
    }
    
    public PolygonHoleOptions[] a(int paramAnonymousInt)
    {
      return new PolygonHoleOptions[paramAnonymousInt];
    }
  };
  private final List<LatLng> points;
  
  public PolygonHoleOptions()
  {
    this.points = new ArrayList();
    this.isPolygonHoleOptions = true;
  }
  
  protected PolygonHoleOptions(Parcel paramParcel)
  {
    this.points = paramParcel.createTypedArrayList(LatLng.CREATOR);
    this.isPolygonHoleOptions = true;
  }
  
  public PolygonHoleOptions addAll(Iterable<LatLng> paramIterable)
  {
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.points.add(localLatLng);
      }
      return this;
    }
    catch (Throwable paramIterable)
    {
      paramIterable.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.points);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\PolygonHoleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */