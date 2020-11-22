package com.amap.api.mapcore.util;

public enum cs
{
  private String m;
  private int n;
  
  private cs(String paramString, int paramInt)
  {
    this.m = paramString;
    this.n = paramInt;
  }
  
  public static int a(String paramString)
  {
    cs[] arrayOfcs = values();
    int i2 = arrayOfcs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      cs localcs = arrayOfcs[i1];
      if (localcs.a().equals(paramString)) {
        return localcs.n;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public String a()
  {
    return this.m;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */