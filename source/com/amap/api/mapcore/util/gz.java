package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

@gp(a="file")
public class gz
{
  @gq(a="fname", b=6)
  private String a;
  @gq(a="md", b=6)
  private String b;
  @gq(a="sname", b=6)
  private String c;
  @gq(a="version", b=6)
  private String d;
  @gq(a="dversion", b=6)
  private String e;
  @gq(a="status", b=6)
  private String f;
  
  private gz() {}
  
  public gz(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
  }
  
  public static String a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sname", paramString);
    return go.a(localHashMap);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sname", paramString1);
    localHashMap.put("dversion", paramString2);
    return go.a(localHashMap);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fname", paramString1);
    localHashMap.put("sname", paramString2);
    localHashMap.put("dversion", paramString4);
    localHashMap.put("version", paramString3);
    return go.a(localHashMap);
  }
  
  public static String b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fname", paramString);
    return go.a(localHashMap);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sname", paramString1);
    localHashMap.put("status", paramString2);
    return go.a(localHashMap);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f = "copy";
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
    }
    
    public a a(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public gz a()
    {
      return new gz(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */