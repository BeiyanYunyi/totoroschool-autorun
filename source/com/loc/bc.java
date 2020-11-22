package com.loc;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

abstract class bc
  extends ClassLoader
{
  protected final Context a;
  protected final Map<String, Class<?>> b = new HashMap();
  protected DexFile c = null;
  volatile boolean d = true;
  protected v e;
  protected String f;
  protected volatile boolean g = false;
  protected volatile boolean h = false;
  
  public bc(Context paramContext, v paramv)
  {
    super(paramContext.getClassLoader());
    this.a = paramContext;
    this.e = paramv;
  }
  
  public final boolean a()
  {
    return this.c != null;
  }
  
  protected final void b()
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
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ag.a(localThrowable, "BaseLoader", "releaseDexFile()");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */