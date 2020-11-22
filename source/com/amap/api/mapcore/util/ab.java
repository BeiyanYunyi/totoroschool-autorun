package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.AMap.OnMultiPointClickListener;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ab
{
  cl a;
  private List<z> b = new ArrayList();
  private AMap.OnMultiPointClickListener c;
  private IAMapDelegate d;
  
  public ab(IAMapDelegate paramIAMapDelegate)
  {
    this.d = paramIAMapDelegate;
  }
  
  private void a(z paramz)
    throws RemoteException
  {
    synchronized (this.b)
    {
      this.b.add(paramz);
      return;
    }
  }
  
  public cl a()
  {
    this.a = this.d.getGLShaderManager();
    return this.a;
  }
  
  public IMultiPointOverlay a(MultiPointOverlayOptions paramMultiPointOverlayOptions)
    throws RemoteException
  {
    if (paramMultiPointOverlayOptions == null) {
      return null;
    }
    try
    {
      paramMultiPointOverlayOptions = new aa(paramMultiPointOverlayOptions, this);
      a(paramMultiPointOverlayOptions);
      return paramMultiPointOverlayOptions;
    }
    finally
    {
      paramMultiPointOverlayOptions = finally;
      throw paramMultiPointOverlayOptions;
    }
  }
  
  public void a(aa paramaa)
  {
    this.b.remove(paramaa);
  }
  
  public void a(AMap.OnMultiPointClickListener paramOnMultiPointClickListener)
  {
    this.c = paramOnMultiPointClickListener;
  }
  
  public void a(MapConfig paramMapConfig, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    try
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
          ((z)localIterator.next()).a(paramMapConfig, paramArrayOfFloat1, paramArrayOfFloat2);
        }
        return;
      }
      return;
    }
    catch (Throwable paramMapConfig)
    {
      gk.c(paramMapConfig, "MultiPointOverlayManagerLayer", "draw");
      paramMapConfig.printStackTrace();
    }
  }
  
  public boolean a(IPoint paramIPoint)
  {
    ??? = this.c;
    boolean bool = false;
    if (??? == null) {
      return false;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (IMultiPointOverlay)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = ((IMultiPointOverlay)localObject2).onClick(paramIPoint);
          if (localObject2 != null)
          {
            if (this.c != null) {
              bool = this.c.onPointClick((MultiPointItem)localObject2);
            }
            return bool;
          }
        }
      }
      return false;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 59	com/amap/api/mapcore/util/ab:c	Lcom/amap/api/maps/AMap$OnMultiPointClickListener;
    //   7: aload_0
    //   8: getfield 23	com/amap/api/mapcore/util/ab:b	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 23	com/amap/api/mapcore/util/ab:b	Ljava/util/List;
    //   18: invokeinterface 66 1 0
    //   23: astore_2
    //   24: aload_2
    //   25: invokeinterface 72 1 0
    //   30: ifeq +21 -> 51
    //   33: aload_2
    //   34: invokeinterface 76 1 0
    //   39: checkcast 95	com/autonavi/amap/mapcore/interfaces/IMultiPointOverlay
    //   42: iconst_0
    //   43: invokeinterface 109 2 0
    //   48: goto -24 -> 24
    //   51: aload_0
    //   52: getfield 23	com/amap/api/mapcore/util/ab:b	Ljava/util/List;
    //   55: invokeinterface 112 1 0
    //   60: aload_1
    //   61: monitorexit
    //   62: goto +21 -> 83
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 82
    //   74: ldc 114
    //   76: invokestatic 89	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	ab
    //   70	10	1	localThrowable	Throwable
    //   86	4	1	localObject1	Object
    //   23	11	2	localIterator	Iterator
    //   65	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	65	finally
    //   24	48	65	finally
    //   51	62	65	finally
    //   66	68	65	finally
    //   7	14	70	java/lang/Throwable
    //   68	70	70	java/lang/Throwable
    //   2	7	86	finally
    //   7	14	86	finally
    //   68	70	86	finally
    //   71	83	86	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/amap/api/mapcore/util/ab:b	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 23	com/amap/api/mapcore/util/ab:b	Ljava/util/List;
    //   13: invokeinterface 112 1 0
    //   18: aload_1
    //   19: monitorexit
    //   20: goto +25 -> 45
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: astore_1
    //   29: goto +19 -> 48
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 82
    //   36: ldc 115
    //   38: invokestatic 89	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ab
    //   28	1	1	localObject1	Object
    //   32	19	1	localThrowable	Throwable
    //   23	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	26	23	finally
    //   2	9	28	finally
    //   26	28	28	finally
    //   33	45	28	finally
    //   2	9	32	java/lang/Throwable
    //   26	28	32	java/lang/Throwable
  }
  
  public void d()
  {
    if (this.d != null) {
      this.d.setRunLowFrame(false);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */