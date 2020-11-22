package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.INavigateArrow;
import java.lang.ref.WeakReference;
import java.util.List;

public class NavigateArrow
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private INavigateArrow navigateArrowDelegate;
  private NavigateArrowOptions options;
  
  public NavigateArrow(IGlOverlayLayer paramIGlOverlayLayer, NavigateArrowOptions paramNavigateArrowOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramNavigateArrowOptions;
  }
  
  public NavigateArrow(INavigateArrow paramINavigateArrow)
  {
    this.navigateArrowDelegate = paramINavigateArrow;
  }
  
  private void a()
  {
    IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
    if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
      localIGlOverlayLayer.updateOption(this.overlayName, this.options);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null)
    {
      if (!(paramObject instanceof NavigateArrow)) {
        return false;
      }
      try
      {
        if (this.navigateArrowDelegate != null) {
          return this.navigateArrowDelegate.equalsRemote(((NavigateArrow)paramObject).navigateArrowDelegate);
        }
        if (!super.equals(paramObject))
        {
          paramObject = ((NavigateArrow)paramObject).getId();
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
  
  public String getId()
  {
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getId();
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
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getPoints();
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
  
  @Deprecated
  public int getSideColor()
  {
    int i = 0;
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getSideColor();
      }
      if (this.options != null) {
        i = this.options.getSideColor();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getTopColor()
  {
    int i = 0;
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getTopColor();
      }
      if (this.options != null) {
        i = this.options.getTopColor();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public float getWidth()
  {
    float f = 0.0F;
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getWidth();
      }
      if (this.options != null) {
        f = this.options.getWidth();
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
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.getZIndex();
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
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.hashCodeRemote();
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
  
  public boolean is3DModel()
  {
    boolean bool = false;
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.is3DModel();
      }
      if (this.options != null) {
        bool = this.options.is3DModel();
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isVisible()
  {
    boolean bool = false;
    try
    {
      if (this.navigateArrowDelegate != null) {
        return this.navigateArrowDelegate.isVisible();
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
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.remove();
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
  
  public void set3DModel(boolean paramBoolean)
  {
    try
    {
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.set3DModel(paramBoolean);
        return;
      }
      if (this.options != null)
      {
        this.options.set3DModel(paramBoolean);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    try
    {
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setPoints(paramList);
        return;
      }
      if (this.options != null)
      {
        a();
        return;
      }
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setSideColor(int paramInt)
  {
    try
    {
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setSideColor(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.sideColor(paramInt);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setTopColor(int paramInt)
  {
    try
    {
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setTopColor(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.topColor(paramInt);
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
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setVisible(paramBoolean);
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
  
  public void setWidth(float paramFloat)
  {
    try
    {
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setWidth(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.width(paramFloat);
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
      if (this.navigateArrowDelegate != null)
      {
        this.navigateArrowDelegate.setZIndex(paramFloat);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\NavigateArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */