package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapProvince
  extends Province
{
  public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator()
  {
    public OfflineMapProvince a(Parcel paramAnonymousParcel)
    {
      return new OfflineMapProvince(paramAnonymousParcel);
    }
    
    public OfflineMapProvince[] a(int paramAnonymousInt)
    {
      return new OfflineMapProvince[paramAnonymousInt];
    }
  };
  private String a;
  private int b = 6;
  private long c;
  private String d;
  private int e = 0;
  private ArrayList<OfflineMapCity> f;
  
  public OfflineMapProvince() {}
  
  public OfflineMapProvince(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.createTypedArrayList(OfflineMapCity.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<OfflineMapCity> getCityList()
  {
    if (this.f == null) {
      return new ArrayList();
    }
    return this.f;
  }
  
  public ArrayList<OfflineMapCity> getDownloadedCityList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.f == null) {
      return localArrayList;
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      OfflineMapCity localOfflineMapCity = (OfflineMapCity)localIterator.next();
      if (localOfflineMapCity.getState() != 6) {
        localArrayList.add(localOfflineMapCity);
      }
    }
    return localArrayList;
  }
  
  public long getSize()
  {
    return this.c;
  }
  
  public int getState()
  {
    return this.b;
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
  
  public void setCityList(ArrayList<OfflineMapCity> paramArrayList)
  {
    this.f = paramArrayList;
  }
  
  public void setCompleteCode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSize(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setState(int paramInt)
  {
    this.b = paramInt;
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
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeTypedList(this.f);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\OfflineMapProvince.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */