package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

public class hj
  extends Thread
{
  private static int c = 0;
  private static int d = 3;
  private static long e = 30000L;
  private static boolean g = false;
  private WeakReference<Context> a = null;
  private IAMapDelegate b;
  private a f = null;
  private Handler h = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (hj.b()) {
        return;
      }
      if (hj.a(hj.this) == null)
      {
        hj localhj = hj.this;
        IAMapDelegate localIAMapDelegate = hj.b(hj.this);
        if (hj.c(hj.this) == null) {
          paramAnonymousMessage = null;
        } else {
          paramAnonymousMessage = (Context)hj.c(hj.this).get();
        }
        hj.a(localhj, new hj.a(localIAMapDelegate, paramAnonymousMessage));
      }
      dw.a().a(hj.a(hj.this));
    }
  };
  
  public hj(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    if (paramContext != null) {
      this.a = new WeakReference(paramContext);
    }
    this.b = paramIAMapDelegate;
    a();
  }
  
  public static void a()
  {
    c = 0;
    g = false;
  }
  
  private void f()
  {
    if (!g)
    {
      int i = 0;
      while (i <= d)
      {
        Handler localHandler = this.h;
        i += 1;
        localHandler.sendEmptyMessageDelayed(0, i * e);
      }
    }
  }
  
  public void interrupt()
  {
    this.b = null;
    this.a = null;
    if (this.h != null) {
      this.h.removeCallbacksAndMessages(null);
    }
    this.h = null;
    this.f = null;
    a();
    super.interrupt();
  }
  
  public void run()
  {
    try
    {
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "AMapDelegateImpGLSurfaceView", "mVerfy");
      localThrowable.printStackTrace();
    }
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<IAMapDelegate> a = null;
    private WeakReference<Context> b = null;
    private ik c;
    
    public a(IAMapDelegate paramIAMapDelegate, Context paramContext)
    {
      this.a = new WeakReference(paramIAMapDelegate);
      if (paramContext != null) {
        this.b = new WeakReference(paramContext);
      }
    }
    
    private void a()
    {
      if ((this.a != null) && (this.a.get() != null))
      {
        final IAMapDelegate localIAMapDelegate = (IAMapDelegate)this.a.get();
        if ((localIAMapDelegate != null) && (localIAMapDelegate.getMapConfig() != null)) {
          localIAMapDelegate.queueEvent(new Runnable()
          {
            public void run()
            {
              if ((localIAMapDelegate != null) && (localIAMapDelegate.getMapConfig() != null))
              {
                Object localObject = localIAMapDelegate.getMapConfig();
                ((MapConfig)localObject).setProFunctionAuthEnable(false);
                if (((MapConfig)localObject).isUseProFunction())
                {
                  localIAMapDelegate.setMapCustomEnable(((MapConfig)localObject).isCustomStyleEnable(), true);
                  localIAMapDelegate.reloadMapCustomStyle();
                  if (hj.a.a(hj.a.this) == null) {
                    localObject = null;
                  } else {
                    localObject = (Context)hj.a.a(hj.a.this).get();
                  }
                  cz.a((Context)localObject);
                }
              }
            }
          });
        }
      }
    }
    
    public void run()
    {
      try
      {
        if (hj.b()) {
          return;
        }
        if ((this.c == null) && (this.b != null) && (this.b.get() != null)) {
          this.c = new ik((Context)this.b.get(), "");
        }
        hj.c();
        if (hj.d() > hj.e())
        {
          hj.a(true);
          a();
          return;
        }
        if (this.c != null)
        {
          ik.a locala = (ik.a)this.c.a();
          if (locala != null)
          {
            if (!locala.d) {
              a();
            }
            hj.a(true);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "authForPro", "loadConfigData_uploadException");
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */