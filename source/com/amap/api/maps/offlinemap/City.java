package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class City
  implements Parcelable
{
  public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator()
  {
    public City a(Parcel paramAnonymousParcel)
    {
      return new City(paramAnonymousParcel);
    }
    
    public City[] a(int paramAnonymousInt)
    {
      return new City[paramAnonymousInt];
    }
  };
  private String a = "";
  private String b = "";
  private String c;
  private String d;
  private String e = "";
  
  public City() {}
  
  public City(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAdcode()
  {
    return this.e;
  }
  
  public String getCity()
  {
    return this.a;
  }
  
  public String getCode()
  {
    return this.b;
  }
  
  public String getJianpin()
  {
    return this.c;
  }
  
  public String getPinyin()
  {
    return this.d;
  }
  
  public void setAdcode(String paramString)
  {
    this.e = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCode(String paramString)
  {
    if ((paramString != null) && (!"[]".equals(paramString))) {
      this.b = paramString;
    }
  }
  
  public void setJianpin(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPinyin(String paramString)
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
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\City.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */