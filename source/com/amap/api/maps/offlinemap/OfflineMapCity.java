package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OfflineMapCity
  extends City
{
  public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator()
  {
    public OfflineMapCity a(Parcel paramAnonymousParcel)
    {
      return new OfflineMapCity(paramAnonymousParcel);
    }
    
    public OfflineMapCity[] a(int paramAnonymousInt)
    {
      return new OfflineMapCity[paramAnonymousInt];
    }
  };
  private String a = "";
  private long b = 0L;
  private int c = 6;
  private String d = "";
  private int e = 0;
  
  public OfflineMapCity() {}
  
  public OfflineMapCity(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getSize()
  {
    return this.b;
  }
  
  public int getState()
  {
    return this.c;
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public String getVersion()
  {
    return this.d;
  }
  
  public int getcompleteCode()
  {
    return this.e;
  }
  
  public void setCompleteCode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSize(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setState(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.a = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.d = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\OfflineMapCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */