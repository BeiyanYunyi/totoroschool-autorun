package com.loc;

import java.util.HashMap;
import java.util.Map;

@ao(a="file")
public class ay
{
  @ap(a="fname", b=6)
  private String a;
  @ap(a="md", b=6)
  private String b;
  @ap(a="sname", b=6)
  private String c;
  @ap(a="version", b=6)
  private String d;
  @ap(a="dversion", b=6)
  private String e;
  @ap(a="status", b=6)
  private String f;
  
  private ay() {}
  
  public ay(a parama)
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
    return an.a(localHashMap);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sname", paramString1);
    localHashMap.put("dversion", paramString2);
    return an.a(localHashMap);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fname", paramString1);
    localHashMap.put("sname", paramString2);
    localHashMap.put("dversion", paramString4);
    localHashMap.put("version", paramString3);
    return an.a(localHashMap);
  }
  
  public static String b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fname", paramString);
    return an.a(localHashMap);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sname", paramString1);
    localHashMap.put("status", paramString2);
    return an.a(localHashMap);
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final void c(String paramString)
  {
    this.f = paramString;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final String f()
  {
    return this.f;
  }
  
  public static final class a
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
    
    public final a a(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public final ay a()
    {
      return new ay(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */