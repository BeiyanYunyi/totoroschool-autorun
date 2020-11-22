package com.amap.api.mapcore.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class iv
  extends iw
{
  public iv() {}
  
  public iv(iw paramiw)
  {
    super(paramiw);
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
    ((StringBuffer)localObject).append(" ");
    ((StringBuffer)localObject).append(UUID.randomUUID().toString());
    ((StringBuffer)localObject).append(" ");
    if (((StringBuffer)localObject).length() != 53) {
      return new byte[0];
    }
    localObject = fw.a(((StringBuffer)localObject).toString());
    byte[] arrayOfByte = new byte[localObject.length + paramArrayOfByte.length];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, localObject.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\iv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */