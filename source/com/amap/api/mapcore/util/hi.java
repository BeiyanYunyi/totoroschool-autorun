package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class hi
{
  private fv a;
  private volatile int b = -1;
  
  private hi(fv paramfv)
  {
    this.a = paramfv;
  }
  
  public static hi a(fv paramfv)
  {
    if (a.a.get(paramfv.a()) == null) {
      a.a.put(paramfv.a(), new hi(paramfv));
    }
    return (hi)a.a.get(paramfv.a());
  }
  
  public static boolean b(fv paramfv)
  {
    return jr.a(paramfv);
  }
  
  private void e(Context paramContext)
  {
    new ka().a(paramContext, this.a);
  }
  
  public <T> T a(Context paramContext, String paramString, Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws fj
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass(paramString);
      if (paramContext != null)
      {
        paramContext = paramContext.getDeclaredConstructor(paramArrayOfClass);
        paramContext.setAccessible(true);
        paramContext = paramContext.newInstance(paramArrayOfObject);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      ho.a(paramContext, "tt");
      return null;
    }
    catch (ClassNotFoundException paramContext) {}
    return null;
  }
  
  public void a(Context paramContext, hk paramhk, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramhk == null) {
      return;
    }
    boolean bool1 = paramhk.e();
    boolean bool2 = paramhk.f();
    hl localhl1 = hl.a(paramContext, this.a);
    gv localgv = new gv(paramhk.b(), paramhk.c(), "", paramhk.g(), paramBoolean1);
    int k = 1;
    int j = k;
    if (localhl1 != null)
    {
      if (bool1 != localhl1.h())
      {
        localhl1.b(bool1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (bool2 != localhl1.i())
      {
        localhl1.c(bool2);
        i = 1;
      }
      if (i != 0) {
        localhl1.b(paramContext, this.a);
      }
      if (this.a == null) {}
      do
      {
        for (;;)
        {
          i = 0;
          break label276;
          if (localhl1.h()) {
            break;
          }
          e(paramContext);
        }
      } while ((!localhl1.i()) || (!this.a.b().equals(this.a.c())) || (!localgv.h()) || (!jh.b(localgv.j(), this.a.b())) || (jh.a(localgv.k(), this.a.b()) <= 0) || ((localhl1 != null) && (localhl1.a(paramContext)) && (jh.a(localgv.k(), localhl1.c().k()) <= 0)));
      int i = 1;
      label276:
      j = k;
      if (i == 0) {
        j = 0;
      }
    }
    if (j == 0) {
      return;
    }
    if (!TextUtils.isEmpty(paramhk.b()))
    {
      if (TextUtils.isEmpty(paramhk.d())) {
        return;
      }
      if (jr.a(this.a)) {
        return;
      }
      hn.a().a(paramContext);
      if (hn.a().a(localgv.i(), localgv.j(), localgv.k())) {
        return;
      }
      hl localhl2 = new hl(new js(paramhk.b(), paramhk.a(paramContext), "", paramhk.g(), paramBoolean1), new jp(localgv.i(), localgv.j(), localgv.k(), paramhk.c(paramContext)), paramhk.a(paramContext), paramhk.b(paramContext), false, paramhk.e(), paramhk.f(), fw.a(paramContext));
      localhl2.a(localhl1.e());
      paramContext = new jr(paramContext, localgv, localhl2, paramhk.a());
      paramContext.a(paramBoolean2);
      paramContext.a();
      return;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    fv localfv = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean1);
    hp.a(paramContext, localfv, "sckey", localStringBuilder.toString());
    if (paramBoolean1)
    {
      localfv = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean2);
      hp.a(paramContext, localfv, "scisf", localStringBuilder.toString());
    }
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = hp.a(paramContext, this.a, "sckey");
    try
    {
      boolean bool = Boolean.parseBoolean(paramContext);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean b(Context paramContext)
  {
    paramContext = hp.a(paramContext, this.a, "scisf");
    try
    {
      boolean bool = Boolean.parseBoolean(paramContext);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return true;
  }
  
  public boolean c(Context paramContext)
  {
    if (this.b == 1) {
      return false;
    }
    boolean bool = d(paramContext);
    if (!bool) {
      this.b = 1;
    }
    return bool;
  }
  
  public boolean d(Context paramContext)
  {
    hl localhl = hl.a(paramContext, this.a);
    if (localhl != null)
    {
      if (localhl.c() == null) {
        return false;
      }
      if (!kf.a(paramContext)) {
        return false;
      }
      if ((this.a != null) && (localhl != null) && (!TextUtils.isEmpty(this.a.c())) && (!TextUtils.isEmpty(this.a.b())) && (this.a.b().equals(this.a.c())) && (localhl != null) && (localhl.a(paramContext))) {
        if (!localhl.h())
        {
          e(paramContext);
        }
        else if ((localhl.i()) && (!TextUtils.isEmpty(localhl.c().j())) && (!TextUtils.isEmpty(localhl.c().k())) && (jh.a(this.a.b(), localhl.c().j()) == 0) && (jh.a(this.a.b(), localhl.c().k()) < 0))
        {
          i = 1;
          break label219;
        }
      }
      int i = 0;
      label219:
      if (i == 0)
      {
        hl.c(paramContext, this.a);
        return false;
      }
      jk localjk = new jk(paramContext, this.a);
      return new jz(localhl, localjk.b(), localjk.l()).a(paramContext, this.a);
    }
    return false;
  }
  
  static final class a
  {
    public static Map<String, hi> a = new HashMap();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */