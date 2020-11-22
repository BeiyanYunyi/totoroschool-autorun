package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import java.util.Map;

public abstract class cw
  extends ic
{
  protected boolean isPostFlag = true;
  
  public Map<String, String> getParams()
  {
    return null;
  }
  
  public Map<String, String> getRequestHead()
  {
    return null;
  }
  
  protected byte[] makeHttpRequest()
    throws fj
  {
    int i = MapsInitializer.getProtocol();
    ib localib = ib.a(false);
    if (i == 1)
    {
      if (this.isPostFlag) {
        return localib.b(this);
      }
      return localib.d(this);
    }
    if (i == 2)
    {
      if (this.isPostFlag) {
        return localib.a(this);
      }
      return localib.e(this);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */