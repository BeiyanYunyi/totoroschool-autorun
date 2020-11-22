package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.amap.api.mapcore.util.gk;
import com.amap.api.mapcore.util.lv;
import com.amap.api.mapcore.util.lv.a;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class CrossVectorOverlay
  extends BaseMapOverlay<GLCrossVector, Object>
  implements lv.a, ICrossVectorOverlay
{
  AVectorCrossAttr attr = null;
  private CrossOverlay.GenerateCrossImageListener imageListener;
  private boolean isImageMode = false;
  private lv pluginTexture;
  
  public CrossVectorOverlay(int paramInt, Context paramContext, IAMap paramIAMap)
  {
    super(paramInt, paramContext, paramIAMap);
  }
  
  private void drawVectorFailed(int paramInt)
  {
    if (this.pluginTexture != null) {
      this.pluginTexture.b();
    }
    if (this.imageListener != null) {
      this.imageListener.onGenerateComplete(null, paramInt);
    }
  }
  
  private void initImageMode(int paramInt1, int paramInt2)
  {
    if (this.pluginTexture == null)
    {
      this.pluginTexture = new lv(this.mMapView);
      this.pluginTexture.a(this.imageListener);
      this.pluginTexture.a(this);
      int i = this.attr.stAreaRect.width();
      int j = this.attr.stAreaRect.height();
      this.pluginTexture.b(i, j);
    }
    if (this.mGLOverlay != null) {
      ((GLCrossVector)this.mGLOverlay).initFBOTexture(paramInt1, paramInt2);
    }
  }
  
  public void addItem(Object paramObject) {}
  
  public void addOverlayTexture(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    GLTextureProperty localGLTextureProperty = new GLTextureProperty();
    localGLTextureProperty.mId = paramInt1;
    localGLTextureProperty.mAnchor = paramInt2;
    localGLTextureProperty.mBitmap = paramBitmap;
    localGLTextureProperty.mXRatio = 0.0F;
    localGLTextureProperty.mYRatio = 0.0F;
    localGLTextureProperty.isGenMimps = true;
    this.mMapView.addOverlayTexture(this.mEngineID, localGLTextureProperty);
  }
  
  public int dipToPixel(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return paramInt;
    }
    float f = paramInt;
    try
    {
      f = TypedValue.applyDimension(1, f, paramContext.getResources().getDisplayMetrics());
      return (int)f;
    }
    catch (Exception paramContext) {}
    return paramInt;
  }
  
  public int getTextureID()
  {
    return ((GLCrossVector)this.mGLOverlay).getFBOTextureId();
  }
  
  protected void iniGLOverlay()
  {
    this.mGLOverlay = new GLCrossVector(this.mEngineID, this.mMapView, hashCode());
  }
  
  public void remove()
  {
    if (this.pluginTexture != null)
    {
      this.pluginTexture.b();
      this.pluginTexture = null;
    }
    this.imageListener = null;
    setVisible(false);
    releaseInstance();
  }
  
  public void resumeMarker(Bitmap paramBitmap)
  {
    addOverlayTexture(paramBitmap, 12345, 4);
    ((GLCrossVector)this.mGLOverlay).setArrowResId(false, 12345);
    ((GLCrossVector)this.mGLOverlay).setCarResId(12345);
    paramBitmap = BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
    if (paramBitmap != null) {
      paramBitmap = paramBitmap.getBitmap();
    } else {
      paramBitmap = null;
    }
    addOverlayTexture(paramBitmap, 54321, 0);
    ((GLCrossVector)this.mGLOverlay).setBackgroundResId(54321);
  }
  
  public void setAttribute(AVectorCrossAttr paramAVectorCrossAttr)
  {
    this.attr = paramAVectorCrossAttr;
  }
  
  public int setData(byte[] paramArrayOfByte)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return -1;
    }
    if (this.attr == null)
    {
      this.attr = new AVectorCrossAttr();
      this.attr.stAreaRect = new Rect(0, 0, this.mMapView.getMapWidth(), this.mMapView.getMapHeight() * 4 / 11);
      this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
      this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
      this.attr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
      this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
      this.attr.stArrowLineColor = Color.argb(255, 255, 253, 65);
      this.attr.dayMode = false;
    }
    int i;
    if ((paramArrayOfByte != null) && (this.attr != null))
    {
      final int k = this.mMapView.getMapWidth();
      final int m = this.mMapView.getMapHeight();
      if ((this.isImageMode) && (this.imageListener != null)) {
        initImageMode(k, m);
      }
      int j = ((GLCrossVector)this.mGLOverlay).addVectorItem(this.attr, paramArrayOfByte, paramArrayOfByte.length);
      ((GLCrossVector)this.mGLOverlay).setVisible(true);
      i = j;
      if (this.isImageMode)
      {
        i = j;
        if (this.imageListener != null)
        {
          this.mMapView.queueEvent(new Runnable()
          {
            public void run()
            {
              try
              {
                if ((CrossVectorOverlay.this.mGLOverlay != null) && (((GLCrossVector)CrossVectorOverlay.this.mGLOverlay).isVisible()) && (CrossVectorOverlay.this.pluginTexture != null) && (!CrossVectorOverlay.this.pluginTexture.c()))
                {
                  CrossVectorOverlay.this.pluginTexture.a(k, m);
                  CrossVectorOverlay.this.pluginTexture.a();
                  return;
                }
              }
              catch (Throwable localThrowable)
              {
                gk.c(localThrowable, "CrossVectorOverlay", "setData");
              }
            }
          });
          i = j;
        }
      }
    }
    else
    {
      i = -1;
    }
    if (i == -1) {
      drawVectorFailed(i);
    }
    return i;
  }
  
  public void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener paramGenerateCrossImageListener)
  {
    this.imageListener = paramGenerateCrossImageListener;
    if (this.pluginTexture != null) {
      this.pluginTexture.a(this.imageListener);
    }
  }
  
  public void setImageMode(boolean paramBoolean)
  {
    this.isImageMode = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\gloverlay\CrossVectorOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */