package com.amap.api.mapcore.util;

import java.io.File;

public class iy
  extends jc
{
  private int b;
  private String c;
  
  public iy(int paramInt, String paramString, jc paramjc)
  {
    super(paramjc);
    this.b = paramInt;
    this.c = paramString;
  }
  
  public int a(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return 0;
      }
      int i = paramString.list().length;
      return i;
    }
    catch (Throwable paramString)
    {
      gk.c(paramString, "fus", "gfn");
    }
    return 0;
  }
  
  protected boolean a()
  {
    return a(this.c) >= this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */