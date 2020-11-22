package com.google.zxing.client.result;

public final class WifiParsedResult
  extends ParsedResult
{
  private final boolean hidden;
  private final String networkEncryption;
  private final String password;
  private final String ssid;
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, false);
  }
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(ParsedResultType.WIFI);
    this.ssid = paramString2;
    this.networkEncryption = paramString1;
    this.password = paramString3;
    this.hidden = paramBoolean;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    maybeAppend(this.ssid, localStringBuilder);
    maybeAppend(this.networkEncryption, localStringBuilder);
    maybeAppend(this.password, localStringBuilder);
    maybeAppend(Boolean.toString(this.hidden), localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String getNetworkEncryption()
  {
    return this.networkEncryption;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\WifiParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */