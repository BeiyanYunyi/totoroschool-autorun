package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public abstract class BaseMapOverlay<T extends GLOverlay, E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Context mContext;
  protected int mEngineID = 1;
  protected T mGLOverlay;
  protected Vector<E> mItemList = null;
  protected int mLastFocusedIndex;
  protected IAMapDelegate mMapView;
  
  public BaseMapOverlay(int paramInt, Context paramContext, IAMap paramIAMap)
  {
    this.mEngineID = paramInt;
    this.mContext = paramContext;
    try
    {
      this.mMapView = ((IAMapDelegate)paramIAMap);
      this.mItemList = new Vector();
      iniGLOverlay();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
  }
  
  public abstract void addItem(E paramE);
  
  public boolean clear()
  {
    try
    {
      this.mItemList.clear();
      clearFocus();
      if (this.mGLOverlay != null) {
        this.mGLOverlay.removeAll();
      }
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public void clearFocus()
  {
    this.mLastFocusedIndex = -1;
    this.mGLOverlay.clearFocus();
  }
  
  public T getGLOverlay()
  {
    return this.mGLOverlay;
  }
  
  public final E getItem(int paramInt)
  {
    for (;;)
    {
      try
      {
        localVector = this.mItemList;
        if (paramInt < 0) {}
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Vector localVector;
        Object localObject1;
        return null;
      }
      try
      {
        if (paramInt <= this.mItemList.size() - 1)
        {
          localObject1 = this.mItemList.get(paramInt);
          return (E)localObject1;
        }
        return null;
      }
      finally {}
    }
    throw ((Throwable)localObject1);
  }
  
  public List<E> getItems()
  {
    return this.mItemList;
  }
  
  public int getSize()
  {
    return this.mItemList.size();
  }
  
  protected abstract void iniGLOverlay();
  
  public boolean isClickable()
  {
    if (this.mGLOverlay != null) {
      return this.mGLOverlay.isClickable();
    }
    return false;
  }
  
  public boolean isVisible()
  {
    if (this.mGLOverlay != null) {
      return this.mGLOverlay.isVisible();
    }
    return false;
  }
  
  public void releaseInstance()
  {
    this.mMapView.queueEvent(new Runnable()
    {
      public void run()
      {
        if (BaseMapOverlay.this.getGLOverlay() != null)
        {
          if ((BaseMapOverlay.this.mMapView != null) && (BaseMapOverlay.this.mMapView.isMaploaded())) {
            BaseMapOverlay.this.mMapView.removeEngineGLOverlay(BaseMapOverlay.this);
          }
          BaseMapOverlay.this.getGLOverlay().releaseInstance();
          BaseMapOverlay.this.mGLOverlay = null;
        }
      }
    });
  }
  
  public boolean removeAll()
  {
    return clear();
  }
  
  public void removeItem(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt > this.mItemList.size() - 1) {
        return;
      }
      if (paramInt == this.mLastFocusedIndex)
      {
        this.mLastFocusedIndex = -1;
        clearFocus();
      }
      this.mItemList.remove(paramInt);
      if (this.mGLOverlay != null) {
        this.mGLOverlay.removeItem(paramInt);
      }
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    return;
  }
  
  public void removeItem(E paramE)
  {
    if (paramE == null) {
      return;
    }
    try
    {
      synchronized (this.mItemList)
      {
        removeItem(this.mItemList.indexOf(paramE));
        return;
      }
      return;
    }
    catch (IndexOutOfBoundsException paramE) {}
  }
  
  public abstract void resumeMarker(Bitmap paramBitmap);
  
  public void setClickable(boolean paramBoolean)
  {
    if (this.mGLOverlay != null) {
      this.mGLOverlay.setClickable(paramBoolean);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.mGLOverlay != null) {
      this.mGLOverlay.setVisible(paramBoolean);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\gloverlay\BaseMapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */