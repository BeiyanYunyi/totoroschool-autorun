package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;

public abstract interface ICrossVectorOverlay
{
  public abstract void remove();
  
  public abstract void setAttribute(AVectorCrossAttr paramAVectorCrossAttr);
  
  public abstract int setData(byte[] paramArrayOfByte);
  
  public abstract void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener paramGenerateCrossImageListener);
  
  public abstract void setImageMode(boolean paramBoolean);
  
  public abstract void setVisible(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\ICrossVectorOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */