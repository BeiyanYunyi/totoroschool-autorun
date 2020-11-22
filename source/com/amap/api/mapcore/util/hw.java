package com.amap.api.mapcore.util;

import java.util.Map;

public class hw
  extends ic
{
  private byte[] d;
  private Map<String, String> e;
  
  public hw(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this.d = paramArrayOfByte;
    this.e = paramMap;
  }
  
  public byte[] getEntityBytes()
  {
    return this.d;
  }
  
  public Map<String, String> getParams()
  {
    return this.e;
  }
  
  public Map<String, String> getRequestHead()
  {
    return null;
  }
  
  public String getURL()
  {
    return "https://adiu.amap.com/ws/device/adius";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */