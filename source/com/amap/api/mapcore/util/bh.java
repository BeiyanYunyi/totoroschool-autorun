package com.amap.api.mapcore.util;

import java.util.Hashtable;
import java.util.Map;

public class bh
  extends cw
{
  private String d;
  
  public bh(String paramString)
  {
    this.d = paramString;
  }
  
  public Map<String, String> getParams()
  {
    return null;
  }
  
  public Map<String, String> getRequestHead()
  {
    Hashtable localHashtable = new Hashtable(32);
    localHashtable.put("User-Agent", "MAC=channel:amapapi");
    return localHashtable;
  }
  
  public String getURL()
  {
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */