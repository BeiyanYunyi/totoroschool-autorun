package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;

public class CrossOverlayOptions
{
  AVectorCrossAttr a = null;
  private Bitmap bitmapDescriptor = null;
  
  public AVectorCrossAttr getAttribute()
  {
    return this.a;
  }
  
  public Bitmap getRes()
  {
    return this.bitmapDescriptor;
  }
  
  public CrossOverlayOptions setAttribute(AVectorCrossAttr paramAVectorCrossAttr)
  {
    this.a = paramAVectorCrossAttr;
    return this;
  }
  
  public CrossOverlayOptions setRes(Bitmap paramBitmap)
  {
    this.bitmapDescriptor = paramBitmap;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CrossOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */