package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

public abstract class ea
{
  private eb a;
  private eb.a b;
  protected boolean c = false;
  protected Resources d;
  private boolean e = false;
  private final Object f = new Object();
  private c g = null;
  
  protected ea(Context paramContext)
  {
    this.d = paramContext.getResources();
  }
  
  public static void a(cj.a parama)
  {
    parama = c(parama);
    if (parama != null) {
      parama.a(true);
    }
  }
  
  private static a c(cj.a parama)
  {
    if (parama != null) {
      return parama.j;
    }
    return null;
  }
  
  protected abstract Bitmap a(Object paramObject);
  
  protected eb a()
  {
    return this.a;
  }
  
  public void a(c paramc)
  {
    this.g = paramc;
  }
  
  public void a(eb.a parama)
  {
    this.b = parama;
    this.a = eb.a(this.b);
    new b().c(new Object[] { Integer.valueOf(1) });
  }
  
  public void a(String paramString)
  {
    this.b.b(paramString);
    new b().c(new Object[] { Integer.valueOf(4) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    b(false);
  }
  
  public void a(boolean paramBoolean, cj.a parama)
  {
    if (parama == null) {
      return;
    }
    Object localObject = null;
    try
    {
      if (this.a != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(parama.a);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(parama.b);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(parama.c);
        localObject = this.a.a(((StringBuilder)localObject).toString());
      }
      if (localObject != null)
      {
        parama.a((Bitmap)localObject);
        return;
      }
      localObject = new a(parama);
      parama.j = ((a)localObject);
      ((a)localObject).a(cx.c, new Boolean[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Throwable parama)
    {
      parama.printStackTrace();
    }
  }
  
  protected void b()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.f)
    {
      this.c = paramBoolean;
      paramBoolean = this.c;
      if (!paramBoolean) {
        try
        {
          this.f.notifyAll();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
  }
  
  protected void c()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.a(paramBoolean);
      this.a = null;
    }
  }
  
  protected void d()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    new b().c(new Object[] { Integer.valueOf(3), Boolean.valueOf(paramBoolean) });
  }
  
  protected void e()
  {
    if (this.a != null)
    {
      this.a.a(false);
      this.a.a();
    }
  }
  
  public void f()
  {
    new b().c(new Object[] { Integer.valueOf(0) });
  }
  
  public class a
    extends cx<Boolean, Void, Bitmap>
  {
    private final WeakReference<cj.a> e;
    
    public a(cj.a parama)
    {
      this.e = new WeakReference(parama);
    }
    
    private cj.a e()
    {
      cj.a locala = (cj.a)this.e.get();
      if (this == ea.b(locala)) {
        return locala;
      }
      return null;
    }
    
    protected Bitmap a(Boolean... arg1)
    {
      for (;;)
      {
        try
        {
          boolean bool = ???[0].booleanValue();
          cj.a locala = (cj.a)this.e.get();
          if (locala == null) {
            return null;
          }
          ??? = new StringBuilder();
          ???.append(locala.a);
          ???.append("-");
          ???.append(locala.b);
          ???.append("-");
          ???.append(locala.c);
          String str = ???.toString();
          synchronized (ea.a(ea.this))
          {
            if ((ea.this.c) && (!d()))
            {
              ea.a(ea.this).wait();
              continue;
            }
            if ((ea.b(ea.this) != null) && (!d()) && (e() != null) && (!ea.c(ea.this)))
            {
              ??? = ea.b(ea.this).b(str);
              Object localObject1 = ???;
              if (bool)
              {
                localObject1 = ???;
                if (??? == null)
                {
                  localObject1 = ???;
                  if (!d())
                  {
                    localObject1 = ???;
                    if (e() != null)
                    {
                      localObject1 = ???;
                      if (!ea.c(ea.this)) {
                        try
                        {
                          localObject1 = ea.this.a(locala);
                        }
                        finally {}
                      }
                    }
                  }
                }
              }
              if ((localObject1 != null) && (ea.b(ea.this) != null)) {
                ea.b(ea.this).a(str, (Bitmap)localObject1);
              }
              return (Bitmap)localObject1;
            }
          }
          ??? = null;
        }
        catch (Throwable ???)
        {
          ???.printStackTrace();
          return null;
        }
      }
    }
    
    protected void a(Bitmap paramBitmap)
    {
      for (;;)
      {
        try
        {
          if ((d()) || (ea.c(ea.this))) {
            break label74;
          }
          cj.a locala = e();
          if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (locala != null))
          {
            locala.a(paramBitmap);
            if (ea.d(ea.this) != null)
            {
              ea.d(ea.this).a();
              return;
            }
          }
        }
        catch (Throwable paramBitmap)
        {
          paramBitmap.printStackTrace();
        }
        return;
        label74:
        paramBitmap = null;
      }
    }
    
    protected void b(Bitmap arg1)
    {
      super.b(???);
      try
      {
        synchronized (ea.a(ea.this))
        {
          ea.a(ea.this).notifyAll();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
  }
  
  protected class b
    extends cx<Object, Void, Void>
  {
    protected b() {}
    
    protected Void d(Object... paramVarArgs)
    {
      try
      {
        switch (((Integer)paramVarArgs[0]).intValue())
        {
        case 4: 
          ea.this.e();
        }
      }
      catch (Throwable paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      ea.this.c(((Boolean)paramVarArgs[1]).booleanValue());
      break label108;
      ea.this.d();
      break label108;
      ea.this.b();
      break label108;
      ea.this.c();
      for (;;)
      {
        label108:
        return null;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */