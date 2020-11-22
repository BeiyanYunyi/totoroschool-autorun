package com.loc;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public final class as
{
  private an a;
  private Context b;
  
  public as(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    this.a = a(this.b, paramBoolean);
  }
  
  private static an a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = new an(paramContext, an.a(ar.class));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!paramBoolean) {
        aj.b(paramContext, "sd", "gdb");
      }
    }
    return null;
  }
  
  public final List<v> a()
  {
    try
    {
      Object localObject = v.g();
      localObject = this.a.a((String)localObject, v.class, true);
      return (List<v>)localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public final void a(v paramv)
  {
    if (paramv == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.a;
        i = 0;
        if (localObject1 == null) {
          this.a = a(this.b, false);
        }
        localObject1 = v.a(paramv.a());
        Object localObject2 = this.a.a((String)localObject1, v.class, false);
        if (((List)localObject2).size() == 0)
        {
          this.a.a(paramv);
          return;
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          if (!((v)((Iterator)localObject2).next()).equals(paramv)) {
            continue;
          }
          if (i != 0) {
            this.a.a((String)localObject1, paramv);
          }
          return;
        }
      }
      catch (Throwable paramv)
      {
        aj.b(paramv, "sd", "it");
        return;
      }
      int i = 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */