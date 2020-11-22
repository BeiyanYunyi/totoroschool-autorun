package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class jx
  extends jy
{
  private String a;
  private hl b;
  private List<jy.a> c = new ArrayList();
  private Context d;
  private fv e;
  private ke f;
  private jn g;
  
  public jx(String paramString, hl paramhl, Context paramContext, fv paramfv, ke paramke, jn paramjn)
  {
    this.a = paramString;
    this.b = paramhl;
    this.d = paramContext;
    this.e = paramfv;
    this.f = paramke;
    this.g = paramjn;
    paramString = this.b.d();
    paramhl = new b(this.a, this.g, this.d, this.f);
    this.c.add(paramhl);
    paramString = new c(this.d, paramString, this.g, this.f);
    this.c.add(paramString);
    paramString = new a(this.g, this.f, this.b, this.d, this.e);
    this.c.add(paramString);
  }
  
  protected final List<jy.a> a()
  {
    return this.c;
  }
  
  protected final boolean b()
  {
    if (TextUtils.isEmpty(this.a)) {
      return false;
    }
    if (this.b != null)
    {
      if (this.b.d() == null) {
        return false;
      }
      if (this.d == null) {
        return false;
      }
      return this.g != null;
    }
    return false;
  }
  
  static final class a
    implements jy.a
  {
    private jn a;
    private ke b;
    private hl c;
    private Context d;
    private fv e;
    
    public a(jn paramjn, ke paramke, hl paramhl, Context paramContext, fv paramfv)
    {
      this.a = paramjn;
      this.b = paramke;
      this.c = paramhl;
      this.d = paramContext;
      this.e = paramfv;
    }
    
    public final int a()
    {
      jp localjp = this.c.d();
      ho.b(this.a.i());
      int i = 0;
      for (;;)
      {
        if (i >= localjp.d().size()) {
          break label80;
        }
        String str = ((jo)localjp.d().get(i)).a();
        try
        {
          ho.b(this.a.c(str), this.a.b(str));
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          label80:
          for (;;) {}
        }
      }
      return 1003;
      this.c.d(true);
      this.c.b(this.d, this.e);
      return 1000;
    }
    
    public final void b()
    {
      this.b.c(this.a.h());
      hl.c(this.d, this.e);
    }
  }
  
  static final class b
    implements jy.a
  {
    private String a;
    private jn b;
    private Context c;
    private ke d;
    
    public b(String paramString, jn paramjn, Context paramContext, ke paramke)
    {
      this.a = paramString;
      this.b = paramjn;
      this.c = paramContext;
      this.d = paramke;
    }
    
    public final int a()
    {
      try
      {
        ho.b(this.a, this.b.k());
        if (!kg.a(this.b.k())) {
          return 1003;
        }
        ho.a(this.b.k(), this.b);
        return 1000;
      }
      catch (Throwable localThrowable) {}
      return 1003;
    }
    
    public final void b()
    {
      this.d.c(this.b.h());
    }
  }
  
  static final class c
    implements jy.a
  {
    private Context a;
    private jp b;
    private jn c;
    private ke d;
    
    public c(Context paramContext, jp paramjp, jn paramjn, ke paramke)
    {
      this.a = paramContext;
      this.b = paramjp;
      this.c = paramjn;
      this.d = paramke;
    }
    
    public final int a()
    {
      if (this.b.a(this.c)) {
        return 1000;
      }
      return 1003;
    }
    
    public final void b()
    {
      this.d.c(this.c.h());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */