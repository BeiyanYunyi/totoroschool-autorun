package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class ju
  extends jy
{
  private gv a;
  private jk b;
  private Context c;
  private String d;
  private ke e;
  private hl f;
  private List<jy.a> g = new ArrayList();
  
  public ju(gv paramgv, jk paramjk, Context paramContext, String paramString, ke paramke, hl paramhl)
  {
    this.a = paramgv;
    this.b = paramjk;
    this.c = paramContext;
    this.d = paramString;
    this.e = paramke;
    this.f = paramhl;
  }
  
  protected final List<jy.a> a()
  {
    a locala = new a(this.d, this.a.b(), this.b, this.e, this.f, this.c);
    this.g.add(locala);
    return this.g;
  }
  
  protected final boolean b()
  {
    return (!TextUtils.isEmpty(this.d)) && (this.a != null);
  }
  
  static final class a
    implements jy.a
  {
    private String a;
    private String b;
    private jk c;
    private ke d;
    private hl e;
    private Context f;
    
    public a(String paramString1, String paramString2, jk paramjk, ke paramke, hl paramhl, Context paramContext)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramjk;
      this.d = paramke;
      this.e = paramhl;
      this.f = paramContext;
    }
    
    public final int a()
    {
      String str = this.c.k();
      ho.a(this.a, str);
      if (!ho.e(str)) {
        return 1003;
      }
      if (!kg.a(str)) {
        return 1003;
      }
      ho.b(str, this.c.i());
      if (!ho.d(this.b, str)) {
        return 1003;
      }
      ho.c(this.c.b());
      ho.a(str, this.c.b());
      if (!ho.e(this.c.b())) {
        return 1003;
      }
      return 1000;
    }
    
    public final void b()
    {
      this.d.b(this.c.k());
      this.d.b(this.a);
      this.d.c(this.c.b());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */