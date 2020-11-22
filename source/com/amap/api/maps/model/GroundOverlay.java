package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;
import java.lang.ref.WeakReference;

public final class GroundOverlay
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private float high;
  private IGroundOverlay iGroundOverlayDelegate;
  private GroundOverlayOptions options;
  private LatLng point;
  private float width;
  
  public GroundOverlay(IGlOverlayLayer paramIGlOverlayLayer, GroundOverlayOptions paramGroundOverlayOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramGroundOverlayOptions;
    this.overlayName = "";
  }
  
  public GroundOverlay(IGroundOverlay paramIGroundOverlay)
  {
    this.iGroundOverlayDelegate = paramIGroundOverlay;
  }
  
  private void a()
  {
    IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
    if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
      localIGlOverlayLayer.updateOption(this.overlayName, this.options);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.destroy();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null) {
        localIGlOverlayLayer.removeOverlay(this.overlayName);
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
      if (!(paramObject instanceof GroundOverlay)) {
        return false;
      }
      try
      {
        if (this.iGroundOverlayDelegate != null) {
          return this.iGroundOverlayDelegate.equalsRemote(((GroundOverlay)paramObject).iGroundOverlayDelegate);
        }
        if (!super.equals(paramObject))
        {
          paramObject = ((GroundOverlay)paramObject).getId();
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
  
  public float getBearing()
  {
    float f = 0.0F;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getBearing();
      }
      if (this.options != null) {
        f = this.options.getBearing();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public LatLngBounds getBounds()
  {
    LatLngBounds localLatLngBounds = null;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getBounds();
      }
      if (this.options != null) {
        localLatLngBounds = this.options.getBounds();
      }
      return localLatLngBounds;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getHeight()
  {
    float f = 0.0F;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getHeight();
      }
      if (this.options != null) {
        f = this.options.getHeight();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public String getId()
  {
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getId();
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
  
  public LatLng getPosition()
  {
    LatLng localLatLng = null;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getPosition();
      }
      if (this.options != null) {
        localLatLng = this.options.getLocation();
      }
      return localLatLng;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getTransparency()
  {
    float f = 0.0F;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getTransparency();
      }
      if (this.options != null) {
        f = this.options.getTransparency();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public float getWidth()
  {
    float f = 0.0F;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getWidth();
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
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.getZIndex();
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
    if (this.iGroundOverlayDelegate != null) {
      return this.iGroundOverlayDelegate.hashCode();
    }
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    boolean bool = false;
    try
    {
      if (this.iGroundOverlayDelegate != null) {
        return this.iGroundOverlayDelegate.isVisible();
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
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.remove();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null) {
        localIGlOverlayLayer.removeOverlay(this.overlayName);
      }
      if ((this.options != null) && (this.options.getImage() != null))
      {
        this.options.getImage().recycle();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setBearing(float paramFloat)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setBearing(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.bearing(paramFloat);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDimensions(float paramFloat)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setDimensions(paramFloat);
        return;
      }
      if (this.options != null)
      {
        LatLng localLatLng;
        if (this.point != null) {
          localLatLng = this.point;
        } else {
          localLatLng = this.options.getLocation();
        }
        if (localLatLng == null)
        {
          this.width = paramFloat;
          return;
        }
        this.options.position(localLatLng, paramFloat);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDimensions(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setDimensions(paramFloat1, paramFloat2);
        return;
      }
      if (this.options != null)
      {
        LatLng localLatLng;
        if (this.point != null) {
          localLatLng = this.point;
        } else {
          localLatLng = this.options.getLocation();
        }
        if (localLatLng == null)
        {
          this.width = paramFloat1;
          this.high = paramFloat2;
          return;
        }
        this.options.position(this.options.getLocation(), paramFloat1, paramFloat2);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setImage(paramBitmapDescriptor);
        return;
      }
      if (this.options != null)
      {
        this.options.image(paramBitmapDescriptor);
        a();
        return;
      }
    }
    catch (Throwable paramBitmapDescriptor)
    {
      paramBitmapDescriptor.printStackTrace();
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setPosition(paramLatLng);
        return;
      }
      if ((this.options != null) && (paramLatLng != null))
      {
        float f1;
        if (this.width > 0.0F) {
          f1 = this.width;
        } else {
          f1 = this.options.getWidth();
        }
        float f2;
        if (this.high > 0.0F) {
          f2 = this.high;
        } else {
          f2 = this.options.getHeight();
        }
        if (f1 == 0.0F)
        {
          this.point = paramLatLng;
          return;
        }
        if (f2 == 0.0F)
        {
          this.options.position(paramLatLng, f1);
          a();
          return;
        }
        if (f2 > 0.0F)
        {
          this.options.position(paramLatLng, f1, f2);
          a();
          return;
        }
      }
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setPositionFromBounds(paramLatLngBounds);
        return;
      }
      if ((this.options != null) && (paramLatLngBounds != null))
      {
        this.options.positionFromBounds(paramLatLngBounds);
        a();
        return;
      }
    }
    catch (Throwable paramLatLngBounds)
    {
      paramLatLngBounds.printStackTrace();
    }
  }
  
  public void setTransparency(float paramFloat)
  {
    try
    {
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setTransparency(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.transparency(paramFloat);
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
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setVisible(paramBoolean);
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
      if (this.iGroundOverlayDelegate != null)
      {
        this.iGroundOverlayDelegate.setZIndex(paramFloat);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\GroundOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */