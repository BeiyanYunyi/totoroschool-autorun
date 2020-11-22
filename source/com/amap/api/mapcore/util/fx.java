package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

@Deprecated
class fx
  extends ic
{
  private Map<String, String> d = new HashMap();
  private String e;
  private Map<String, String> f = new HashMap();
  
  void a(String paramString)
  {
    this.e = paramString;
  }
  
  void a(Map<String, String> paramMap)
  {
    this.d.clear();
    this.d.putAll(paramMap);
  }
  
  void b(Map<String, String> paramMap)
  {
    this.f.clear();
    this.f.putAll(paramMap);
  }
  
  public Map<String, String> getParams()
  {
    return this.f;
  }
  
  public Map<String, String> getRequestHead()
  {
    return this.d;
  }
  
  public String getURL()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */