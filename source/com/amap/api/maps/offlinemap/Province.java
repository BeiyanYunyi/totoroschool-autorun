package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Province
  implements Parcelable
{
  public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator()
  {
    public Province a(Parcel paramAnonymousParcel)
    {
      return new Province(paramAnonymousParcel);
    }
    
    public Province[] a(int paramAnonymousInt)
    {
      return new Province[paramAnonymousInt];
    }
  };
  private String a = "";
  private String b;
  private String c;
  private String d = "";
  
  public Province() {}
  
  public Province(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getJianpin()
  {
    return this.b;
  }
  
  public String getPinyin()
  {
    return this.c;
  }
  
  public String getProvinceCode()
  {
    return this.d;
  }
  
  public String getProvinceName()
  {
    return this.a;
  }
  
  public void setJianpin(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPinyin(String paramString)
  {
    this.c = paramString;
  }
  
  public void setProvinceCode(String paramString)
  {
    this.d = paramString;
  }
  
  public void setProvinceName(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\Province.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */