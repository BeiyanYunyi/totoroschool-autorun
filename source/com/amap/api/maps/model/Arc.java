package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IArc;
import java.lang.ref.WeakReference;

public final class Arc
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private IArc iArcDel;
  private ArcOptions options;
  
  public Arc(IGlOverlayLayer paramIGlOverlayLayer, ArcOptions paramArcOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramArcOptions;
    this.overlayName = "";
  }
  
  public Arc(IArc paramIArc)
  {
    this.iArcDel = paramIArc;
  }
  
  private void a()
  {
    try
    {
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
        localIGlOverlayLayer.updateOption(this.overlayName, this.options);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null)
    {
      if (!(paramObject instanceof Arc)) {
        return false;
      }
      try
      {
        if (this.iArcDel != null) {
          return this.iArcDel.equalsRemote(((Arc)paramObject).iArcDel);
        }
        if (!super.equals(paramObject))
        {
          paramObject = ((Arc)paramObject).getId();
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
      if (this.iArcDel != null) {
        return this.iArcDel.getId();
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
  
  public int getStrokeColor()
  {
    int i = 0;
    try
    {
      if (this.iArcDel != null) {
        return this.iArcDel.getStrokeColor();
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
      if (this.iArcDel != null) {
        return this.iArcDel.getStrokeWidth();
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
      if (this.iArcDel != null) {
        return this.iArcDel.getZIndex();
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
      if (this.iArcDel != null) {
        return this.iArcDel.hashCodeRemote();
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
      if (this.iArcDel != null) {
        return this.iArcDel.isVisible();
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
      if (this.iArcDel != null)
      {
        this.iArcDel.remove();
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
  
  public void setStrokeColor(int paramInt)
  {
    try
    {
      if (this.iArcDel != null)
      {
        this.iArcDel.setStrokeColor(paramInt);
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
      if (this.iArcDel != null)
      {
        this.iArcDel.setStrokeWidth(paramFloat);
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
      if (this.iArcDel != null)
      {
        this.iArcDel.setVisible(paramBoolean);
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
      if (this.iArcDel != null)
      {
        this.iArcDel.setZIndex(paramFloat);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Arc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */