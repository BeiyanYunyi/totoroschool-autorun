package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class c
{
  List<ITileOverlayDelegate> a = new ArrayList();
  a b = new a();
  List<Integer> c = new ArrayList();
  cj d = null;
  float[] e = new float[16];
  private IAMapDelegate f;
  private Context g;
  
  public c(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.f = paramIAMapDelegate;
    this.g = paramContext;
    paramContext = new da(256, 256, this.f.getMapConfig());
    paramContext = new TileOverlayOptions().tileProvider(paramContext);
    paramContext.memCacheSize(10485760);
    paramContext.diskCacheSize(20480);
    this.d = new cj(paramContext, this, true);
  }
  
  private boolean j()
  {
    if (this.f == null) {
      return false;
    }
    return (MapsInitializer.isLoadWorldGridMap()) || (this.f.getMapConfig().getMapLanguage().equals("en"));
  }
  
  public TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException
  {
    if (paramTileOverlayOptions != null)
    {
      if (paramTileOverlayOptions.getTileProvider() == null) {
        return null;
      }
      try
      {
        paramTileOverlayOptions = new cj(paramTileOverlayOptions, this, false);
        a(paramTileOverlayOptions);
        paramTileOverlayOptions.refresh(true);
        this.f.setRunLowFrame(false);
        paramTileOverlayOptions = new TileOverlay(paramTileOverlayOptions);
        return paramTileOverlayOptions;
      }
      catch (Throwable paramTileOverlayOptions)
      {
        paramTileOverlayOptions.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public IAMapDelegate a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.c.add(Integer.valueOf(paramInt));
  }
  
  public void a(ITileOverlayDelegate paramITileOverlayDelegate)
  {
    synchronized (this.a)
    {
      b(paramITileOverlayDelegate);
      this.a.add(paramITileOverlayDelegate);
      d();
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.d != null) {
      this.d.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (j())
        {
          ??? = this.f.getCameraPosition();
          if (??? == null) {
            return;
          }
          if ((((CameraPosition)???).isAbroad) && (((CameraPosition)???).zoom > 7.0F))
          {
            if (this.f.getMapType() == 1)
            {
              if (this.d != null) {
                this.d.refresh(paramBoolean);
              }
            }
            else if (this.d != null) {
              this.d.a();
            }
          }
          else if (this.d != null) {
            if (this.f.getMapConfig().getMapLanguage().equals("en")) {
              this.d.refresh(paramBoolean);
            } else {
              this.d.a();
            }
          }
        }
        int i;
        synchronized (this.a)
        {
          int j = this.a.size();
          i = 0;
          if (i < j)
          {
            ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
            if ((localITileOverlayDelegate != null) && (localITileOverlayDelegate.isVisible())) {
              localITileOverlayDelegate.refresh(paramBoolean);
            }
          }
          else
          {
            return;
          }
        }
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "TileOverlayView", "refresh");
        return;
      }
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        ??? = this.c.iterator();
        if (((Iterator)???).hasNext())
        {
          dx.b(((Integer)((Iterator)???).next()).intValue());
        }
        else
        {
          this.c.clear();
          if ((j()) && (this.d != null)) {
            this.d.drawTiles();
          }
          int i;
          synchronized (this.a)
          {
            int j = this.a.size();
            i = 0;
            if (i < j)
            {
              ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
              if (localITileOverlayDelegate.isVisible()) {
                localITileOverlayDelegate.drawTiles();
              }
            }
            else
            {
              return;
            }
          }
          i += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.onFling(paramBoolean);
    }
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        int j = this.a.size();
        i = 0;
        if (i < j)
        {
          ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
          if (localITileOverlayDelegate != null) {
            localITileOverlayDelegate.onFling(paramBoolean);
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
    }
  }
  
  public boolean b(ITileOverlayDelegate paramITileOverlayDelegate)
  {
    synchronized (this.a)
    {
      boolean bool = this.a.remove(paramITileOverlayDelegate);
      return bool;
    }
  }
  
  public void c()
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        int j = this.a.size();
        i = 0;
        if (i < j)
        {
          ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
          if (localITileOverlayDelegate != null) {
            localITileOverlayDelegate.destroy(true);
          }
        }
        else
        {
          this.a.clear();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      Collections.sort(this.a, this.b);
      return;
    }
  }
  
  public void e()
  {
    if (this.d != null) {
      this.d.onResume();
    }
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        int j = this.a.size();
        i = 0;
        if (i < j)
        {
          ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
          if (localITileOverlayDelegate != null) {
            localITileOverlayDelegate.onResume();
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
    }
  }
  
  public Context f()
  {
    return this.g;
  }
  
  public void g()
  {
    c();
    if (this.d != null)
    {
      this.d.onPause();
      this.d.destroy(false);
    }
    this.d = null;
  }
  
  public float[] h()
  {
    if (this.f != null) {
      return this.f.getFinalMatrix();
    }
    return this.e;
  }
  
  public void i()
  {
    if (this.d != null)
    {
      this.d.clearTileCache();
      dn.a(this.g, "Map3DCache", "time", Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        int j = this.a.size();
        i = 0;
        if (i < j)
        {
          ITileOverlayDelegate localITileOverlayDelegate = (ITileOverlayDelegate)this.a.get(i);
          if (localITileOverlayDelegate != null) {
            localITileOverlayDelegate.clearTileCache();
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
    }
  }
  
  static class a
    implements Serializable, Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (ITileOverlayDelegate)paramObject1;
      paramObject2 = (ITileOverlayDelegate)paramObject2;
      if ((paramObject1 != null) && (paramObject2 != null)) {
        try
        {
          int i = Float.compare(((ITileOverlayDelegate)paramObject1).getZIndex(), ((ITileOverlayDelegate)paramObject2).getZIndex());
          return i;
        }
        catch (Throwable paramObject1)
        {
          gk.c((Throwable)paramObject1, "TileOverlayView", "compare");
          ((Throwable)paramObject1).printStackTrace();
        }
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */