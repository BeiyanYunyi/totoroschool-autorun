package com.amap.api.trace;

public class TraceLocation
{
  private double a;
  private double b;
  private float c;
  private float d;
  private long e;
  
  public TraceLocation() {}
  
  public TraceLocation(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, long paramLong)
  {
    this.a = a(paramDouble1);
    this.b = a(paramDouble2);
    this.c = ((int)(paramFloat1 * 3600.0F / 1000.0F));
    this.d = ((int)paramFloat2);
    this.e = paramLong;
  }
  
  private static double a(double paramDouble)
  {
    paramDouble = Math.round(paramDouble * 1000000.0D);
    Double.isNaN(paramDouble);
    return paramDouble / 1000000.0D;
  }
  
  public TraceLocation copy()
  {
    TraceLocation localTraceLocation = new TraceLocation();
    localTraceLocation.d = this.d;
    localTraceLocation.a = this.a;
    localTraceLocation.b = this.b;
    localTraceLocation.c = this.c;
    localTraceLocation.e = this.e;
    return localTraceLocation;
  }
  
  public float getBearing()
  {
    return this.d;
  }
  
  public double getLatitude()
  {
    return this.a;
  }
  
  public double getLongitude()
  {
    return this.b;
  }
  
  public float getSpeed()
  {
    return this.c;
  }
  
  public long getTime()
  {
    return this.e;
  }
  
  public void setBearing(float paramFloat)
  {
    this.d = ((int)paramFloat);
  }
  
  public void setLatitude(double paramDouble)
  {
    this.a = a(paramDouble);
  }
  
  public void setLongitude(double paramDouble)
  {
    this.b = a(paramDouble);
  }
  
  public void setSpeed(float paramFloat)
  {
    this.c = ((int)(paramFloat * 3600.0F / 1000.0F));
  }
  
  public void setTime(long paramLong)
  {
    this.e = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(",longtitude ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",speed ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",bearing ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",time ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\TraceLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */