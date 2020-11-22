package com.amap.api.mapcore.util;

import android.content.Context;

public final class jq
{
  private static volatile boolean b = false;
  private static volatile fv c;
  private jg a;
  
  private jg a(Context paramContext, fv paramfv, jp paramjp)
  {
    if (this.a == null) {
      this.a = new jg(paramContext, paramfv, paramjp);
    }
    return this.a;
  }
  
  private boolean b(Context paramContext, fv paramfv, jp paramjp, String paramString)
  {
    if (paramfv == null) {
      return false;
    }
    try
    {
      paramContext = a(paramContext, paramfv, paramjp);
      if (paramContext == null) {
        return false;
      }
      boolean bool = paramContext.a(paramString);
      return bool;
    }
    catch (Throwable paramContext)
    {
      paramfv = new StringBuilder("SoManagerCore ex ");
      paramfv.append(paramContext);
      ho.a(paramfv.toString());
    }
    return false;
  }
  
  public final boolean a(Context paramContext, fv paramfv, jp paramjp, String paramString)
  {
    return b(paramContext, paramfv, paramjp, paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */