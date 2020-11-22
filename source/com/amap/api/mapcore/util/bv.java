package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.model.BuildingOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeBuildingRenderer;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.List;

public class bv
  implements IBuildingDelegate, IOverlayDelegate
{
  long a = -1L;
  private lo b;
  private BuildingOverlayOptions c;
  private List<BuildingOverlayOptions> d = new ArrayList();
  private List<BuildingOverlayOptions> e;
  private boolean f = true;
  private String g;
  private float h;
  private boolean i;
  private cl j;
  
  public bv(lo paramlo)
  {
    try
    {
      this.b = paramlo;
      if (this.c == null)
      {
        this.c = new BuildingOverlayOptions();
        this.c.setVisible(true);
        paramlo = new ArrayList();
        paramlo.add(new LatLng(84.9D, -179.9D));
        paramlo.add(new LatLng(84.9D, 179.9D));
        paramlo.add(new LatLng(-84.9D, 179.9D));
        paramlo.add(new LatLng(-84.9D, -179.9D));
        this.c.setBuildingLatlngs(paramlo);
        this.c.setBuildingTopColor(-65536);
        this.c.setBuildingSideColor(-12303292);
        this.c.setVisible(true);
        this.c.setZIndex(1.0F);
        this.d.add(this.c);
        a(true);
      }
      try
      {
        this.g = getId();
        return;
      }
      catch (Exception paramlo)
      {
        gk.c(paramlo, "BuildingOverlayDelegateImp", "create");
        paramlo.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramlo)
    {
      paramlo.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        return;
      }
      try
      {
        this.d.set(0, this.c);
        continue;
        this.d.removeAll(this.e);
        this.d.set(0, this.c);
        this.d.addAll(this.e);
        this.i = true;
        return;
      }
      finally {}
    }
    throw ((Throwable)localObject1);
  }
  
  public void a(cl paramcl)
  {
    this.j = paramcl;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    return false;
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public void destroy()
  {
    try
    {
      if (this.a != -1L)
      {
        AMapNativeBuildingRenderer.nativeDestory(this.a);
        if (this.d != null) {
          this.d.clear();
        }
        this.e = null;
        this.c = null;
        this.a = -1L;
      }
      return;
    }
    finally {}
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if (paramMapConfig == null) {
      return;
    }
    try
    {
      if (this.a != -1L) {
        try
        {
          if (this.a != -1L)
          {
            if (this.i)
            {
              AMapNativeBuildingRenderer.nativeClearBuildingOptions(this.a);
              int k = 0;
              while (k < this.d.size())
              {
                BuildingOverlayOptions localBuildingOverlayOptions = (BuildingOverlayOptions)this.d.get(k);
                AMapNativeBuildingRenderer.addBuildingOptions(this.a, localBuildingOverlayOptions);
                k += 1;
              }
              this.i = false;
            }
            AMapNativeBuildingRenderer.render(this.a, paramMapConfig.getViewMatrix(), paramMapConfig.getProjectionMatrix(), (int)paramMapConfig.getSX(), (int)paramMapConfig.getSY(), paramMapConfig.getSZ(), paramMapConfig.getCurTileIds());
          }
          return;
        }
        finally {}
      }
      this.a = AMapNativeBuildingRenderer.nativeCreate();
      if ((this.a != -1L) && (this.j != null))
      {
        AMapNativeBuildingRenderer.nativeSetGLShaderManager(this.a, this.j.a());
        return;
      }
    }
    catch (Exception paramMapConfig)
    {
      paramMapConfig.printStackTrace();
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return false;
  }
  
  public List<BuildingOverlayOptions> getCustomOptions()
  {
    return this.e;
  }
  
  public BuildingOverlayOptions getDefaultOptions()
  {
    try
    {
      BuildingOverlayOptions localBuildingOverlayOptions = this.c;
      return localBuildingOverlayOptions;
    }
    finally {}
  }
  
  public String getId()
  {
    if (this.g == null) {
      this.g = this.b.a("Building");
    }
    return this.g;
  }
  
  public float getZIndex()
  {
    return this.h;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return 0;
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return this.f;
  }
  
  public void remove()
    throws RemoteException
  {
    if ((this.b != null) && (!this.b.a(this.g, true))) {
      destroy();
    }
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setCustomOptions(List<BuildingOverlayOptions> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        this.e = paramList;
        a(false);
        return;
      }
      finally {}
    }
  }
  
  public void setDefaultOptions(BuildingOverlayOptions paramBuildingOverlayOptions)
  {
    if (paramBuildingOverlayOptions != null) {
      try
      {
        this.c = paramBuildingOverlayOptions;
        a(true);
        return;
      }
      finally {}
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setZIndex(float paramFloat)
  {
    try
    {
      this.h = paramFloat;
      this.b.e();
      try
      {
        this.c.setZIndex(this.h);
        a(true);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */