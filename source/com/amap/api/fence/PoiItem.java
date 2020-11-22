package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PoiItem
  implements Parcelable
{
  public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator() {};
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private double f = 0.0D;
  private double g = 0.0D;
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  
  public PoiItem() {}
  
  protected PoiItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readDouble();
    this.g = paramParcel.readDouble();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
  }
  
  public static Parcelable.Creator<PoiItem> getCreator()
  {
    return CREATOR;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.e;
  }
  
  public String getAdname()
  {
    return this.k;
  }
  
  public String getCity()
  {
    return this.j;
  }
  
  public double getLatitude()
  {
    return this.f;
  }
  
  public double getLongitude()
  {
    return this.g;
  }
  
  public String getPoiId()
  {
    return this.b;
  }
  
  public String getPoiName()
  {
    return this.a;
  }
  
  public String getPoiType()
  {
    return this.c;
  }
  
  public String getProvince()
  {
    return this.i;
  }
  
  public String getTel()
  {
    return this.h;
  }
  
  public String getTypeCode()
  {
    return this.d;
  }
  
  public void setAddress(String paramString)
  {
    this.e = paramString;
  }
  
  public void setAdname(String paramString)
  {
    this.k = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.j = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void setPoiId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPoiName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPoiType(String paramString)
  {
    this.c = paramString;
  }
  
  public void setProvince(String paramString)
  {
    this.i = paramString;
  }
  
  public void setTel(String paramString)
  {
    this.h = paramString;
  }
  
  public void setTypeCode(String paramString)
  {
    this.d = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeDouble(this.f);
    paramParcel.writeDouble(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\PoiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */