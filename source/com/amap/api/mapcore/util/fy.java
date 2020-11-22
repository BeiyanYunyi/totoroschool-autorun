package com.amap.api.mapcore.util;

public class fy
  extends ga
{
  fy() {}
  
  public fy(ga paramga)
  {
    super(paramga);
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(fw.a(paramArrayOfByte));
    localStringBuilder.append("||");
    localStringBuilder.append(1);
    return fw.a(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */