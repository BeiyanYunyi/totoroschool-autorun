package com.google.zxing.client.result;

public final class GeoParsedResult
  extends ParsedResult
{
  private final double altitude;
  private final double latitude;
  private final double longitude;
  private final String query;
  
  GeoParsedResult(double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    super(ParsedResultType.GEO);
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.altitude = paramDouble3;
    this.query = paramString;
  }
  
  public double getAltitude()
  {
    return this.altitude;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(this.latitude);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.longitude);
    if (this.altitude > 0.0D)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(this.altitude);
      localStringBuilder.append('m');
    }
    if (this.query != null)
    {
      localStringBuilder.append(" (");
      localStringBuilder.append(this.query);
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
  
  public String getGeoURI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("geo:");
    localStringBuilder.append(this.latitude);
    localStringBuilder.append(',');
    localStringBuilder.append(this.longitude);
    if (this.altitude > 0.0D)
    {
      localStringBuilder.append(',');
      localStringBuilder.append(this.altitude);
    }
    if (this.query != null)
    {
      localStringBuilder.append('?');
      localStringBuilder.append(this.query);
    }
    return localStringBuilder.toString();
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getQuery()
  {
    return this.query;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\GeoParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */