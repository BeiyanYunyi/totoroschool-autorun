package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.location.DPoint;
import java.util.List;

public class DistrictItem
  implements Parcelable
{
  public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator() {};
  private String a = "";
  private String b = null;
  private String c = null;
  private List<DPoint> d = null;
  
  public DistrictItem() {}
  
  protected DistrictItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.createTypedArrayList(DPoint.CREATOR);
  }
  
  public static Parcelable.Creator<DistrictItem> getCreator()
  {
    return CREATOR;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAdcode()
  {
    return this.c;
  }
  
  public String getCitycode()
  {
    return this.b;
  }
  
  public String getDistrictName()
  {
    return this.a;
  }
  
  public List<DPoint> getPolyline()
  {
    return this.d;
  }
  
  public void setAdcode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCitycode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDistrictName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPolyline(List<DPoint> paramList)
  {
    this.d = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeTypedList(this.d);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\DistrictItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */