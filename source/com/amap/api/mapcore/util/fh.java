package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class fh
  implements Handler.Callback
{
  private Map<Integer, lt> a = new Hashtable();
  private Handler b;
  private HandlerThread c;
  private bf d;
  private boolean e = false;
  
  public fh(Context paramContext, bf parambf, IGLSurfaceView paramIGLSurfaceView)
  {
    this.d = parambf;
    this.c = new HandlerThread("AMapMessageHandler");
    this.c.start();
    this.b = new Handler(this.c.getLooper(), this);
    this.e = false;
  }
  
  public void a()
  {
    this.e = true;
    if (this.c != null) {
      this.c.quit();
    }
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(lt paramlt)
  {
    do
    {
      try
      {
        if (!this.e) {
          continue;
        }
        return;
      }
      catch (Exception paramlt)
      {
        int i;
        Map localMap;
        paramlt.printStackTrace();
      }
      i = paramlt.a;
      if (paramlt.a == 153)
      {
        if ((this.a != null) && (this.a.size() > 0)) {
          this.b.obtainMessage(153).sendToTarget();
        }
      }
      else
      {
        localMap = this.a;
        if (i >= 33) {}
      }
      try
      {
        this.a.put(Integer.valueOf(i), paramlt);
        return;
      }
      finally
      {
        for (;;) {}
      }
      throw paramlt;
      return;
    } while (paramlt != null);
  }
  
  public boolean handleMessage(Message arg1)
  {
    do
    {
      try
      {
        if (!this.e) {
          continue;
        }
        return false;
      }
      catch (Exception ???)
      {
        Object localObject1;
        int i;
        ???.printStackTrace();
        return false;
      }
      localObject1 = (lt)???.obj;
      i = ???.what;
      if (i != 1)
      {
        if (i != 153) {
          return false;
        }
        synchronized (this.a)
        {
          localObject1 = this.a.keySet();
          if (((Set)localObject1).size() > 0)
          {
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject3 = (Integer)((Iterator)localObject1).next();
              localObject3 = (lt)this.a.remove(localObject3);
              this.b.obtainMessage(((lt)localObject3).a, localObject3).sendToTarget();
            }
          }
          return false;
        }
      }
      this.d.g(((Integer)((lt)localObject2).b).intValue());
      return false;
    } while (??? != null);
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */