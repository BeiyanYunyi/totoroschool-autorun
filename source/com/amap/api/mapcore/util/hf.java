package com.amap.api.mapcore.util;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

abstract class hf
  extends ClassLoader
{
  protected final Context a;
  protected final Map<String, Class<?>> b = new HashMap();
  protected DexFile c = null;
  volatile boolean d = true;
  protected fv e;
  protected String f;
  protected volatile boolean g = false;
  protected volatile boolean h = false;
  
  public hf(Context paramContext, fv paramfv, boolean paramBoolean)
  {
    super(paramContext.getClassLoader());
    this.a = paramContext;
    this.e = paramfv;
  }
  
  public boolean a()
  {
    return this.c != null;
  }
  
  protected void b()
  {
    try
    {
      synchronized (this.b)
      {
        this.b.clear();
        if (this.c != null)
        {
          if (this.h) {
            synchronized (this.c)
            {
              this.c.wait();
            }
          }
          this.g = true;
          this.c.close();
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      hd.a(localThrowable, "BaseLoader", "releaseDexFile()");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */