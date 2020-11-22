package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.List;

public final class jt
  extends jy
{
  private hl a;
  private List<jy.a> b = new ArrayList();
  private ke c;
  private ji d;
  private String e;
  
  public jt(hl paramhl, ke paramke, ji paramji, String paramString)
  {
    this.a = paramhl;
    this.c = paramke;
    this.d = paramji;
    this.e = paramString;
    paramhl = new a(this.e, this.d, this.c, this.a.g());
    this.b.clear();
    this.b.add(paramhl);
  }
  
  protected final List<jy.a> a()
  {
    return this.b;
  }
  
  protected final boolean b()
  {
    return true;
  }
  
  static final class a
    implements jy.a
  {
    private String a;
    private ji b;
    private ke c;
    private String d;
    
    public a(String paramString1, ji paramji, ke paramke, String paramString2)
    {
      this.a = paramString1;
      this.b = paramji;
      this.c = paramke;
      this.d = paramString2;
    }
    
    public final int a()
    {
      if (!ho.e(this.a)) {
        return 1003;
      }
      if (!kg.a(this.a)) {
        return 1003;
      }
      String str = this.b.b();
      ho.a(this.a, str);
      if (!ho.d(this.d, str)) {
        return 1003;
      }
      return 1000;
    }
    
    public final void b()
    {
      this.c.b(this.a);
      this.c.b(this.b.b());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */