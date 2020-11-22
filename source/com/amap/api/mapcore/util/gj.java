package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

public class gj
  extends ic
{
  private byte[] d;
  private String e = "1";
  
  public gj(byte[] paramArrayOfByte, String paramString)
  {
    this.d = ((byte[])paramArrayOfByte.clone());
    this.e = paramString;
  }
  
  private String a()
  {
    byte[] arrayOfByte1 = fw.a(ge.b);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 50];
    System.arraycopy(this.d, 0, arrayOfByte2, 0, 50);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 50, arrayOfByte1.length);
    return fs.a(arrayOfByte2);
  }
  
  public byte[] getEntityBytes()
  {
    return this.d;
  }
  
  public Map<String, String> getParams()
  {
    return null;
  }
  
  public Map<String, String> getRequestHead()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/zip");
    localHashMap.put("Content-Length", String.valueOf(this.d.length));
    return localHashMap;
  }
  
  public String getURL()
  {
    return String.format(fw.c(ge.c), new Object[] { "1", this.e, "1", "open", a() });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */