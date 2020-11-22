package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.gk;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolygon;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class Polygon
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private PolygonOptions options;
  private IPolygon polygonDelegate;
  
  public Polygon(IGlOverlayLayer paramIGlOverlayLayer, PolygonOptions paramPolygonOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramPolygonOptions;
  }
  
  public Polygon(IPolygon paramIPolygon)
  {
    this.polygonDelegate = paramIPolygon;
  }
  
  private void a()
  {
    try
    {
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null))
      {
        setOptionPointList(this.options);
        localIGlOverlayLayer.processPolygonHoleOption(this.options);
        localIGlOverlayLayer.updateOption(this.overlayName, this.options);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.contains(paramLatLng);
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null)
      {
        boolean bool = localIGlOverlayLayer.IsPolygonContainsPoint(this.options, paramLatLng);
        return bool;
      }
      return false;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null)
    {
      if (!(paramObject instanceof Polygon)) {
        return false;
      }
      try
      {
        if (this.polygonDelegate != null) {
          return this.polygonDelegate.equalsRemote(((Polygon)paramObject).polygonDelegate);
        }
        if (!super.equals(paramObject))
        {
          paramObject = ((Polygon)paramObject).getId();
          String str = getId();
          if (paramObject != str) {}
        }
        else
        {
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramObject)
      {
        ((Throwable)paramObject).printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public int getFillColor()
  {
    int i = 0;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getFillColor();
      }
      if (this.options != null) {
        i = this.options.getFillColor();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public List<BaseHoleOptions> getHoleOptions()
  {
    List localList = null;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getHoleOptions();
      }
      if (this.options != null) {
        localList = this.options.getHoleOptions();
      }
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public String getId()
  {
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getId();
      }
      String str = this.overlayName;
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public List<LatLng> getPoints()
  {
    List localList = null;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getPoints();
      }
      if (this.options != null) {
        localList = this.options.getPoints();
      }
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public int getStrokeColor()
  {
    int i = 0;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getStrokeColor();
      }
      if (this.options != null) {
        i = this.options.getStrokeColor();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public float getStrokeWidth()
  {
    float f = 0.0F;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getStrokeWidth();
      }
      if (this.options != null) {
        f = this.options.getStrokeWidth();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    float f = 0.0F;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.getZIndex();
      }
      if (this.options != null) {
        f = this.options.getZIndex();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public int hashCode()
  {
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.hashCodeRemote();
      }
      int i = super.hashCode();
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    boolean bool = false;
    try
    {
      if (this.polygonDelegate != null) {
        return this.polygonDelegate.isVisible();
      }
      if (this.options != null) {
        bool = this.options.isVisible();
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public void remove()
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.remove();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null)
      {
        localIGlOverlayLayer.removeOverlay(this.overlayName);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setFillColor(int paramInt)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setFillColor(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.fillColor(paramInt);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setHoleOptions(List<BaseHoleOptions> paramList)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setHoleOptions(paramList);
        return;
      }
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      this.options.setHoleOptions((List)localObject);
      a();
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void setOptionPointList(Object paramObject)
  {
    try
    {
      Object localObject1 = paramObject.getClass();
      Object localObject2 = ((Class)localObject1).getDeclaredField("isPointsUpdated");
      if (localObject2 == null) {
        return;
      }
      ((Field)localObject2).setAccessible(true);
      if (((Field)localObject2).getBoolean(paramObject))
      {
        List localList = ((PolygonOptions)paramObject).getPoints();
        localObject2 = new double[localList.size() * 2];
        int i = 0;
        while (i < localList.size())
        {
          int j = i * 2;
          localObject2[j] = ((LatLng)localList.get(i)).latitude;
          localObject2[(j + 1)] = ((LatLng)localList.get(i)).longitude;
          i += 1;
        }
        localObject1 = ((Class)localObject1).getDeclaredField("pointList");
        if (localObject1 == null) {
          return;
        }
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).set(paramObject, localObject2);
        return;
      }
    }
    catch (Throwable paramObject)
    {
      gk.c((Throwable)paramObject, "Polygon", "setOptionPointList");
    }
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setPoints(paramList);
        return;
      }
      this.options.setPoints(paramList);
      a();
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setStrokeColor(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.strokeColor(paramInt);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setStrokeWidth(paramFloat);
        return;
      }
      this.options.strokeWidth(paramFloat);
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setVisible(paramBoolean);
        return;
      }
      if (this.options != null)
      {
        this.options.visible(paramBoolean);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    try
    {
      if (this.polygonDelegate != null)
      {
        this.polygonDelegate.setZIndex(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.zIndex(paramFloat);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Polygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */