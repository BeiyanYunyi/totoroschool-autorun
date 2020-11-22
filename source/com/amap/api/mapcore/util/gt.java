package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public class gt
{
  private go a;
  private Context b;
  
  public gt(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    this.a = a(this.b, paramBoolean);
  }
  
  private go a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = new go(paramContext, go.a(gs.class));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!paramBoolean) {
        gk.c(paramContext, "sd", "gdb");
      }
    }
    return null;
  }
  
  private boolean a(List<fv> paramList, fv paramfv)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((fv)paramList.next()).equals(paramfv)) {
        return false;
      }
    }
    return true;
  }
  
  public List<fv> a()
  {
    try
    {
      Object localObject = fv.h();
      localObject = this.a.a((String)localObject, fv.class, true);
      return (List<fv>)localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public void a(fv paramfv)
  {
    if (paramfv == null) {
      return;
    }
    try
    {
      if (this.a == null) {
        this.a = a(this.b, false);
      }
      String str = fv.a(paramfv.a());
      List localList = this.a.b(str, fv.class);
      if ((localList != null) && (localList.size() != 0))
      {
        if (a(localList, paramfv)) {
          this.a.a(str, paramfv);
        }
      }
      else
      {
        this.a.a(paramfv);
        return;
      }
    }
    catch (Throwable paramfv)
    {
      gk.c(paramfv, "sd", "it");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */