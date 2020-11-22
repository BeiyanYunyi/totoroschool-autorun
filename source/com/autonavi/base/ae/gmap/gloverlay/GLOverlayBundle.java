package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>>
{
  private int mEngineID;
  private long mNativeInstance = 0L;
  private final List<E> mOverlayList = new ArrayList();
  private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray();
  
  public GLOverlayBundle(int paramInt, IAMapDelegate paramIAMapDelegate)
  {
    this.mEngineID = paramInt;
    if (paramIAMapDelegate != null) {}
    try
    {
      this.mNativeInstance = paramIAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
      return;
    }
    catch (Throwable paramIAMapDelegate) {}
  }
  
  private int getOverlyExType(E paramE)
  {
    return 0;
  }
  
  public static void intClr2PVRClr(float[] paramArrayOfFloat, int paramInt)
  {
    paramArrayOfFloat[2] = ((paramInt & 0xFF) / 255.0F);
    paramArrayOfFloat[1] = ((paramInt >> 8 & 0xFF) / 255.0F);
    paramArrayOfFloat[0] = ((paramInt >> 16 & 0xFF) / 255.0F);
    paramArrayOfFloat[3] = ((paramInt >> 24 & 0xFF) / 255.0F);
  }
  
  private static native void nativeAddGLOverlay(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void nativeAddGLOverlayEx(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  private static native void nativeClearAllGLOverlay(long paramLong, boolean paramBoolean);
  
  private static native boolean nativeOnSingleTapLineOverlay(long paramLong, int paramInt1, int paramInt2, long[] paramArrayOfLong);
  
  private static native boolean nativeOnSingleTapPointOverlay(long paramLong, int paramInt1, int paramInt2, long[] paramArrayOfLong);
  
  private static native void nativeRemoveGLOverlay(long paramLong1, long paramLong2);
  
  private static native void nativeRemoveGLOverlayEx(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nativeSortAllGLOverlay(long paramLong);
  
  public void addOverlay(E paramE)
  {
    if (paramE == null) {
      return;
    }
    nativeAddGLOverlay(this.mNativeInstance, paramE.getGLOverlay().getNativeInstatnce(), paramE.getGLOverlay().getCode());
    paramE.getGLOverlay().mIsInBundle = true;
    synchronized (this.mOverlayList)
    {
      this.mOverlayList.add(paramE);
      return;
    }
  }
  
  public boolean addOverlayTextureItem(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    GLOverlayTexture localGLOverlayTexture = new GLOverlayTexture(paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3, paramInt4);
    synchronized (this.mTextureCaches)
    {
      this.mTextureCaches.put(paramInt1, localGLOverlayTexture);
      return true;
    }
  }
  
  public boolean addOverlayTextureItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLOverlayTexture localGLOverlayTexture = new GLOverlayTexture(paramInt1, paramInt2, paramInt3, paramInt4);
    synchronized (this.mTextureCaches)
    {
      this.mTextureCaches.put(paramInt1, localGLOverlayTexture);
      return true;
    }
  }
  
  public long checkSingleTapOnLine(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = new long[3];
    if (nativeOnSingleTapLineOverlay(this.mNativeInstance, paramInt1, paramInt2, arrayOfLong)) {
      return arrayOfLong[0];
    }
    return -1L;
  }
  
  public long checkSingleTapOnPoint(int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = new long[3];
    if (nativeOnSingleTapPointOverlay(this.mNativeInstance, paramInt1, paramInt2, arrayOfLong)) {
      return arrayOfLong[0];
    }
    return -1L;
  }
  
  public void clearFocus()
  {
    List localList;
    int i;
    if (this.mOverlayList != null)
    {
      localList = this.mOverlayList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mOverlayList.size())
        {
          BaseMapOverlay localBaseMapOverlay = (BaseMapOverlay)this.mOverlayList.get(i);
          if (localBaseMapOverlay == null) {
            break label63;
          }
          localBaseMapOverlay.clearFocus();
          break label63;
        }
        return;
      }
      finally {}
      return;
      label63:
      i += 1;
    }
  }
  
  public void clearOverlayTexture()
  {
    synchronized (this.mTextureCaches)
    {
      this.mTextureCaches.clear();
      return;
    }
  }
  
  public boolean cotainsOverlay(E paramE)
  {
    if (paramE == null) {
      return false;
    }
    synchronized (this.mOverlayList)
    {
      boolean bool = this.mOverlayList.contains(paramE);
      return bool;
    }
  }
  
  public E getOverlay(int paramInt)
  {
    List localList = this.mOverlayList;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt <= this.mOverlayList.size() - 1)
      {
        localBaseMapOverlay = (BaseMapOverlay)this.mOverlayList.get(paramInt);
        return localBaseMapOverlay;
      }
      return null;
    }
    finally
    {
      BaseMapOverlay localBaseMapOverlay;
      for (;;) {}
    }
    throw localBaseMapOverlay;
  }
  
  public int getOverlayCount()
  {
    synchronized (this.mOverlayList)
    {
      int i = this.mOverlayList.size();
      return i;
    }
  }
  
  public GLOverlayTexture getOverlayTextureItem(int paramInt)
  {
    synchronized (this.mTextureCaches)
    {
      GLOverlayTexture localGLOverlayTexture = (GLOverlayTexture)this.mTextureCaches.get(paramInt);
      return localGLOverlayTexture;
    }
  }
  
  public boolean onSingleTap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt4 & 0x1) == 1) {
      bool = onSingleTapPoints(paramInt1, paramInt2, paramInt3);
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    if ((paramInt4 & 0x2) == 2) {
      bool = onSingleTapLines(paramInt1, paramInt2, paramInt3);
    }
    return bool;
  }
  
  boolean onSingleTapLines(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  boolean onSingleTapPoints(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public void reculateRouteBoard(IAMapDelegate paramIAMapDelegate) {}
  
  public void removeAll(boolean paramBoolean)
  {
    nativeClearAllGLOverlay(this.mNativeInstance, paramBoolean);
    List localList = this.mOverlayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mOverlayList.size())
        {
          BaseMapOverlay localBaseMapOverlay = (BaseMapOverlay)this.mOverlayList.get(i);
          if (localBaseMapOverlay != null)
          {
            localBaseMapOverlay.getGLOverlay().mIsInBundle = false;
            localBaseMapOverlay.getGLOverlay().releaseInstance();
          }
        }
        else
        {
          this.mOverlayList.clear();
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void removeOverlay(E paramE)
  {
    if (paramE == null) {
      return;
    }
    nativeRemoveGLOverlay(this.mNativeInstance, paramE.getGLOverlay().getNativeInstatnce());
    paramE.getGLOverlay().mIsInBundle = false;
    synchronized (this.mOverlayList)
    {
      this.mOverlayList.remove(paramE);
      return;
    }
  }
  
  public void sortOverlay()
  {
    nativeSortAllGLOverlay(this.mNativeInstance);
  }
  
  public static class GLAmapFocusHits
  {
    public long mHitedIndex = 0L;
    public long mHitedTimes = 1000L;
    public long mOverlayHashCode = 0L;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\gloverlay\GLOverlayBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */