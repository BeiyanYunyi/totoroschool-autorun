package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class hq
{
  private WeakReference<Context> a;
  private jq b = new jq();
  
  public static hq a()
  {
    return a.a;
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramContext.getApplicationContext() == null) {
        return;
      }
      this.a = null;
      this.a = new WeakReference(paramContext.getApplicationContext());
      return;
    }
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public boolean a(Context paramContext, fv paramfv, jp paramjp, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramfv != null) && (paramjp != null) && (paramContext != null))
    {
      if ((!TextUtils.isEmpty(paramfv.c())) && (!TextUtils.isEmpty(paramfv.b())) && (!paramfv.b().equals(paramfv.c())))
      {
        if (!hi.b(paramfv))
        {
          a(paramString);
          return false;
        }
        if (!jh.b(paramfv.b(), paramjp.b()))
        {
          a(paramString);
          return false;
        }
        a(paramContext);
        jq localjq = this.b;
        if (this.a == null) {
          paramContext = null;
        } else {
          paramContext = (Context)this.a.get();
        }
        return localjq.a(paramContext, paramfv, paramjp, paramString);
      }
      a(paramString);
      return false;
    }
    a(paramString);
    return false;
  }
  
  static final class a
  {
    public static hq a = new hq((byte)0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */