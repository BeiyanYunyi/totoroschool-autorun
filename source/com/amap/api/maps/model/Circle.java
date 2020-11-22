package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.ICircle;
import java.lang.ref.WeakReference;
import java.util.List;

public final class Circle
  extends BaseOverlay
{
  WeakReference<IGlOverlayLayer> a;
  private ICircle iCircleDel;
  private CircleOptions options;
  
  public Circle(IGlOverlayLayer paramIGlOverlayLayer, CircleOptions paramCircleOptions)
  {
    this.a = new WeakReference(paramIGlOverlayLayer);
    this.options = paramCircleOptions;
  }
  
  public Circle(ICircle paramICircle)
  {
    this.iCircleDel = paramICircle;
  }
  
  private void a()
  {
    try
    {
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.a.get();
      if (localIGlOverlayLayer != null) {
        localIGlOverlayLayer.processCircleHoleOption(this.options);
      }
      if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
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
      if (this.iCircleDel != null) {
        return this.iCircleDel.contains(paramLatLng);
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.a.get();
      if (localIGlOverlayLayer != null)
      {
        boolean bool = localIGlOverlayLayer.IsCircleContainPoint(this.options, paramLatLng);
        return bool;
      }
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
      if (!(paramObject instanceof Circle)) {
        return false;
      }
      try
      {
        if (this.iCircleDel != null) {
          return this.iCircleDel.equalsRemote(((Circle)paramObject).iCircleDel);
        }
        if (!super.equals(paramObject))
        {
          paramObject = ((Circle)paramObject).getId();
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
  
  public LatLng getCenter()
  {
    LatLng localLatLng = null;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getCenter();
      }
      if (this.options != null) {
        localLatLng = this.options.getCenter();
      }
      return localLatLng;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public int getFillColor()
  {
    int i = 0;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getFillColor();
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
      if (this.iCircleDel != null) {
        return this.iCircleDel.getHoleOptions();
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
      if (this.iCircleDel != null) {
        return this.iCircleDel.getId();
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
  
  public double getRadius()
  {
    double d = 0.0D;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getRadius();
      }
      if (this.options != null) {
        d = this.options.getRadius();
      }
      return d;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0D;
  }
  
  public int getStrokeColor()
  {
    int i = 0;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getStrokeColor();
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
  
  public int getStrokeDottedLineType()
  {
    int i = -1;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getDottedLineType();
      }
      if (this.options != null) {
        i = this.options.getStrokeDottedLineType();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1;
  }
  
  public float getStrokeWidth()
  {
    float f = 0.0F;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.getStrokeWidth();
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
      if (this.iCircleDel != null) {
        return this.iCircleDel.getZIndex();
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
      if (this.iCircleDel != null) {
        return this.iCircleDel.hashCodeRemote();
      }
      int i = super.hashCode();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public boolean isVisible()
  {
    boolean bool = false;
    try
    {
      if (this.iCircleDel != null) {
        return this.iCircleDel.isVisible();
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
      if (this.iCircleDel != null)
      {
        this.iCircleDel.remove();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.a.get();
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
  
  public void setCenter(LatLng paramLatLng)
  {
    try
    {
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setCenter(paramLatLng);
        return;
      }
      if (this.options != null)
      {
        this.options.center(paramLatLng);
        a();
        return;
      }
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setFillColor(int paramInt)
  {
    try
    {
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setFillColor(paramInt);
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
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setHoleOptions(paramList);
        return;
      }
      if (paramList != null) {
        try
        {
          this.options.getHoleOptions().clear();
          this.options.addHoles(paramList);
          a();
          return;
        }
        finally {}
      }
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setRadius(double paramDouble)
  {
    try
    {
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setRadius(paramDouble);
        return;
      }
      if (this.options != null)
      {
        this.options.radius(paramDouble);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    try
    {
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setStrokeColor(paramInt);
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
  
  public void setStrokeDottedLineType(int paramInt)
  {
    try
    {
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setDottedLineType(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.setStrokeDottedLineType(paramInt);
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
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setStrokeWidth(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.strokeWidth(paramFloat);
        a();
        return;
      }
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
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setVisible(paramBoolean);
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
      if (this.iCircleDel != null)
      {
        this.iCircleDel.setZIndex(paramFloat);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Circle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */