package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class jv
  extends jy
{
  private Context a;
  private fv b;
  private gv c;
  private ke d;
  private hl e;
  private jm f;
  private jk g;
  private ji h;
  private jn i;
  private List<jy.a> j = new ArrayList();
  
  public jv(Context paramContext, fv paramfv, gv paramgv, ke paramke, hl paramhl, jm paramjm, jk paramjk, jn paramjn, ji paramji)
  {
    this.a = paramContext;
    this.b = paramfv;
    this.c = paramgv;
    this.d = paramke;
    this.e = paramhl;
    this.f = paramjm;
    this.g = paramjk;
    this.i = paramjn;
    this.h = paramji;
    paramContext = new c(this.a, this.b, this.f.j(), this.d);
    this.j.add(paramContext);
    paramContext = new jw(this.f.j(), this.c.b(), this.d);
    this.j.add(paramContext);
    paramContext = new e(this.f.j(), this.f, this.d);
    this.j.add(paramContext);
    paramContext = new a(this.e, this.d, this.h, this.f.m());
    this.j.add(paramContext);
    paramContext = new b(this.e.c(), this.g, this.a, this.f.l(), this.d, this.e);
    this.j.add(paramContext);
    paramContext = new d(this.f.b(), this.e, this.a, this.b, this.d, this.i);
    this.j.add(paramContext);
  }
  
  protected final List<jy.a> a()
  {
    return this.j;
  }
  
  protected final boolean b()
  {
    if (this.a == null) {
      return false;
    }
    if (this.c != null)
    {
      if (TextUtils.isEmpty(this.c.b())) {
        return false;
      }
      if (this.e != null)
      {
        if (this.e.c() == null) {
          return false;
        }
        if (this.f == null) {
          return false;
        }
        if (this.g == null) {
          return false;
        }
        return this.i != null;
      }
      return false;
    }
    return false;
  }
  
  static final class a
    implements jy.a
  {
    private jt a;
    
    public a(hl paramhl, ke paramke, ji paramji, String paramString)
    {
      this.a = new jt(paramhl, paramke, paramji, paramString);
    }
    
    public final int a()
    {
      return this.a.c();
    }
    
    public final void b() {}
  }
  
  static final class b
    implements jy.a
  {
    private ju a;
    
    public b(gv paramgv, jk paramjk, Context paramContext, String paramString, ke paramke, hl paramhl)
    {
      this.a = new ju(paramgv, paramjk, paramContext, paramString, paramke, paramhl);
    }
    
    public final int a()
    {
      if (this.a == null) {
        return 1003;
      }
      return this.a.c();
    }
    
    public final void b() {}
  }
  
  static final class c
    implements jy.a
  {
    private String a;
    private ke b;
    private fv c;
    private Context d;
    
    public c(Context paramContext, fv paramfv, String paramString, ke paramke)
    {
      this.d = paramContext;
      this.a = paramString;
      this.b = paramke;
      this.c = paramfv;
    }
    
    public final int a()
    {
      if (!ho.e(this.a)) {
        return 1003;
      }
      return 1000;
    }
    
    public final void b()
    {
      hl.c(this.d, this.c);
      this.b.b(this.a);
    }
  }
  
  static final class d
    implements jy.a
  {
    private jx a;
    
    public d(String paramString, hl paramhl, Context paramContext, fv paramfv, ke paramke, jn paramjn)
    {
      this.a = new jx(paramString, paramhl, paramContext, paramfv, paramke, paramjn);
    }
    
    public final int a()
    {
      return this.a.c();
    }
    
    public final void b() {}
  }
  
  static final class e
    implements jy.a
  {
    private String a = null;
    private jm b;
    private ke c;
    
    public e(String paramString, jm paramjm, ke paramke)
    {
      this.a = paramString;
      this.b = paramjm;
      this.c = paramke;
    }
    
    public final int a()
    {
      String str1 = this.b.n();
      String str2 = this.b.l();
      String str3 = this.b.b();
      String str4 = this.b.m();
      ho.c(this.a, str1);
      if (!kg.a(str1)) {
        return 1003;
      }
      ho.a(str1, str2, str3, str4);
      return 1000;
    }
    
    public final void b()
    {
      String str1 = this.b.n();
      String str2 = this.b.i();
      String str3 = this.b.l();
      String str4 = this.b.b();
      String str5 = this.b.m();
      ke.a(str3);
      this.c.b(str4);
      this.c.b(str1);
      this.c.b(str5);
      this.c.c(str2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */