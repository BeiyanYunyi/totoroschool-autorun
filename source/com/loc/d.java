package com.loc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class d
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator() {};
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  private String e;
  private String f;
  private String g = "first";
  private String h = "";
  private String i = null;
  
  public final long a()
  {
    if (this.d - this.c <= 0L) {
      return 0L;
    }
    return this.d - this.c;
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.i = paramString;
  }
  
  public final String b()
  {
    return this.i;
  }
  
  public final void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void b(String paramString)
  {
    this.e = paramString;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final void c(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void c(String paramString)
  {
    this.f = paramString;
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final void d(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void d(String paramString)
  {
    this.g = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final void e(String paramString)
  {
    this.h = paramString;
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public final long g()
  {
    if (this.b <= this.a) {
      return 0L;
    }
    return this.b - this.a;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeLong(this.a);
      paramParcel.writeLong(this.b);
      paramParcel.writeLong(this.c);
      paramParcel.writeLong(this.d);
      return;
    }
    catch (Throwable paramParcel) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */