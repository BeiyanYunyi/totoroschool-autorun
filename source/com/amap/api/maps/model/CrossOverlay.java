package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

public class CrossOverlay
{
  ICrossVectorOverlay a = null;
  
  public CrossOverlay(CrossOverlayOptions paramCrossOverlayOptions, ICrossVectorOverlay paramICrossVectorOverlay)
  {
    this.a = paramICrossVectorOverlay;
  }
  
  public void remove()
  {
    if (this.a != null) {
      try
      {
        this.a.remove();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void setAttribute(AVectorCrossAttr paramAVectorCrossAttr)
  {
    try
    {
      this.a.setAttribute(paramAVectorCrossAttr);
      return;
    }
    catch (Throwable paramAVectorCrossAttr)
    {
      paramAVectorCrossAttr.printStackTrace();
    }
  }
  
  public int setData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.a != null)) {
      try
      {
        int i = this.a.setData(paramArrayOfByte);
        return i;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return -1;
  }
  
  public void setGenerateCrossImageListener(GenerateCrossImageListener paramGenerateCrossImageListener)
  {
    if (this.a != null) {
      try
      {
        this.a.setGenerateCrossImageListener(paramGenerateCrossImageListener);
        return;
      }
      catch (Throwable paramGenerateCrossImageListener)
      {
        paramGenerateCrossImageListener.printStackTrace();
      }
    }
  }
  
  public void setImageMode(boolean paramBoolean)
  {
    if (this.a != null) {
      try
      {
        this.a.setImageMode(paramBoolean);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.a != null) {
      try
      {
        this.a.setVisible(paramBoolean);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static abstract interface GenerateCrossImageListener
  {
    public abstract void onGenerateComplete(Bitmap paramBitmap, int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CrossOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */