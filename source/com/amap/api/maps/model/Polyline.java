package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.gk;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class Polyline
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private PolylineOptions options;
  private IPolyline polylineDelegate;
  
  public Polyline(IGlOverlayLayer paramIGlOverlayLayer, PolylineOptions paramPolylineOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramPolylineOptions;
  }
  
  public Polyline(IGlOverlayLayer paramIGlOverlayLayer, PolylineOptions paramPolylineOptions, String paramString)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramPolylineOptions;
    this.overlayName = paramString;
  }
  
  public Polyline(IPolyline paramIPolyline)
  {
    this.polylineDelegate = paramIPolyline;
  }
  
  private void a()
  {
    try
    {
      try
      {
        IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
        if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null))
        {
          setOptionPointList(this.options);
          if (localIGlOverlayLayer != null) {
            localIGlOverlayLayer.updateOption(this.overlayName, this.options);
          }
        }
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof Polyline;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.equalsRemote(((Polyline)paramObject).polylineDelegate);
      }
      if (!super.equals(paramObject))
      {
        paramObject = ((Polyline)paramObject).getId();
        String str = getId();
        if (paramObject != str) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable paramObject)
    {
      ((Throwable)paramObject).printStackTrace();
    }
    return false;
  }
  
  public int getColor()
  {
    int i = 0;
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getColor();
      }
      if (this.options != null) {
        i = this.options.getColor();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public String getId()
  {
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getId();
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
  
  public LatLng getNearestLatLng(LatLng paramLatLng)
  {
    if (this.polylineDelegate != null) {
      return this.polylineDelegate.getNearestLatLng(paramLatLng);
    }
    IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
    if (localIGlOverlayLayer != null) {
      return localIGlOverlayLayer.getNearestLatLng(this.options, paramLatLng);
    }
    return null;
  }
  
  public PolylineOptions getOptions()
  {
    if (this.polylineDelegate != null) {
      return this.polylineDelegate.getOptions();
    }
    return this.options;
  }
  
  public List<LatLng> getPoints()
  {
    List localList = null;
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getPoints();
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
  
  public float getShownRatio()
  {
    float f = -1.0F;
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getShownRatio();
      }
      if (this.options != null) {
        f = this.options.getShownRatio();
      }
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1.0F;
  }
  
  public float getWidth()
  {
    float f = 0.0F;
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getWidth();
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
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.getZIndex();
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
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.hashCodeRemote();
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
  
  public boolean isDottedLine()
  {
    if (this.polylineDelegate != null) {
      return this.polylineDelegate.isDottedLine();
    }
    if (this.options != null) {
      return this.options.isDottedLine();
    }
    return false;
  }
  
  public boolean isGeodesic()
  {
    if (this.polylineDelegate.isGeodesic()) {
      return true;
    }
    return (this.options != null) && (this.options.isGeodesic());
  }
  
  public boolean isVisible()
  {
    boolean bool = false;
    try
    {
      if (this.polylineDelegate != null) {
        return this.polylineDelegate.isVisible();
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
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.remove();
        return;
      }
      Object localObject = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localObject != null) {
        ((IGlOverlayLayer)localObject).removeOverlay(this.overlayName);
      }
      localObject = this.options.getCustomTexture();
      if (localObject != null) {
        ((BitmapDescriptor)localObject).recycle();
      }
      if (this.options.getCustomTextureList() != null)
      {
        localObject = this.options.getCustomTextureList().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BitmapDescriptor)((Iterator)localObject).next()).recycle();
        }
        this.options.getCustomTextureList().clear();
      }
      this.options = null;
      this.overlayName = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setAboveMaskLayer(boolean paramBoolean)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setAboveMaskLayer(paramBoolean);
      return;
    }
    if (this.options != null)
    {
      this.options.aboveMaskLayer(paramBoolean);
      a();
    }
  }
  
  public void setColor(int paramInt)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setColor(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.color(paramInt);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setCustemTextureIndex(List<Integer> paramList)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setCustemTextureIndex(paramList);
      return;
    }
    try
    {
      if (this.options != null)
      {
        this.options.setCustomTextureIndex(paramList);
        a();
      }
      return;
    }
    finally {}
  }
  
  public void setCustomTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setCustomTexture(paramBitmapDescriptor);
      return;
    }
    if (this.options != null)
    {
      this.options.setCustomTexture(paramBitmapDescriptor);
      a();
    }
  }
  
  public void setCustomTextureList(List<BitmapDescriptor> paramList)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setCustomTextureList(paramList);
        return;
      }
      this.options.setCustomTextureList(paramList);
      a();
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setDottedLine(boolean paramBoolean)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setDottedLine(paramBoolean);
      return;
    }
    if (this.options != null)
    {
      this.options.setDottedLine(paramBoolean);
      a();
    }
  }
  
  public void setGeodesic(boolean paramBoolean)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        if (this.polylineDelegate.isGeodesic() != paramBoolean)
        {
          List localList = getPoints();
          this.polylineDelegate.setGeodesic(paramBoolean);
          setPoints(localList);
        }
      }
      else if (this.options != null)
      {
        this.options.geodesic(paramBoolean);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
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
        List localList = ((PolylineOptions)paramObject).getPoints();
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
      gk.c((Throwable)paramObject, "Polyline", "setOptionPointList");
    }
  }
  
  public void setOptions(PolylineOptions paramPolylineOptions)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setOptions(paramPolylineOptions);
      return;
    }
    this.options = paramPolylineOptions;
    a();
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setPoints(paramList);
        return;
      }
      try
      {
        if (this.options != null)
        {
          this.options.setPoints(paramList);
          a();
        }
        return;
      }
      finally {}
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setShownRange(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setShowRange(paramFloat1, paramFloat2);
        return;
      }
      if (this.options != null)
      {
        this.options.setShownRange(paramFloat1, paramFloat2);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setShownRatio(float paramFloat)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setShownRatio(paramFloat);
        return;
      }
      if (this.options != null)
      {
        this.options.setShownRatio(paramFloat);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setTransparency(float paramFloat)
  {
    if (this.polylineDelegate != null)
    {
      this.polylineDelegate.setTransparency(paramFloat);
      return;
    }
    if (this.options != null)
    {
      this.options.transparency(paramFloat);
      a();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setVisible(paramBoolean);
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
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setWidth(paramFloat);
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
      if (this.polylineDelegate != null)
      {
        this.polylineDelegate.setZIndex(paramFloat);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Polyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */