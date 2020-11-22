package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Poi
  implements Parcelable
{
  public static final PoiCreator CREATOR = new PoiCreator();
  private final LatLng coordinate;
  private final String name;
  private final String poiid;
  
  public Poi(String paramString1, LatLng paramLatLng, String paramString2)
  {
    this.name = paramString1;
    this.coordinate = paramLatLng;
    this.poiid = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof Poi)) {
        return false;
      }
      paramObject = (Poi)paramObject;
      return (((Poi)paramObject).getName().equals(this.name)) && (((Poi)paramObject).getCoordinate().equals(this.coordinate)) && (((Poi)paramObject).getPoiId().equals(this.poiid));
    }
    return false;
  }
  
  public LatLng getCoordinate()
  {
    return this.coordinate;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPoiId()
  {
    return this.poiid;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poiid ");
    localStringBuilder.append(this.poiid);
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.name);
    localStringBuilder.append("  coordinate:");
    localStringBuilder.append(this.coordinate.toString());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeParcelable(this.coordinate, paramInt);
    paramParcel.writeString(this.poiid);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Poi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */