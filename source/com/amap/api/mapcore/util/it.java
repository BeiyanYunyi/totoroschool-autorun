package com.amap.api.mapcore.util;

public class it
  extends iw
{
  private StringBuilder a = new StringBuilder();
  private boolean b = true;
  
  public it() {}
  
  public it(iw paramiw)
  {
    super(paramiw);
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = fw.a(this.a.toString());
    c(paramArrayOfByte);
    this.b = true;
    this.a.delete(0, this.a.length());
    return paramArrayOfByte;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = fw.a(paramArrayOfByte);
    if (this.b) {
      this.b = false;
    } else {
      this.a.append(",");
    }
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.append("{\"log\":\"");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("\"}");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\it.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */