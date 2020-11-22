package com.loc;

import java.util.HashMap;
import java.util.Map;

public final class ai
  extends bn
{
  private byte[] a;
  private String b = "1";
  
  public ai(byte[] paramArrayOfByte, String paramString)
  {
    this.a = ((byte[])paramArrayOfByte.clone());
    this.b = paramString;
  }
  
  public final Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/zip");
    localHashMap.put("Content-Length", String.valueOf(this.a.length));
    return localHashMap;
  }
  
  public final Map<String, String> b_()
  {
    return null;
  }
  
  public final String c()
  {
    String str1 = w.c(x.c);
    String str2 = this.b;
    byte[] arrayOfByte1 = w.a(x.b);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 50];
    System.arraycopy(this.a, 0, arrayOfByte2, 0, 50);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 50, arrayOfByte1.length);
    return String.format(str1, new Object[] { "1", str2, "1", "open", s.a(arrayOfByte2) });
  }
  
  public final byte[] d()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */