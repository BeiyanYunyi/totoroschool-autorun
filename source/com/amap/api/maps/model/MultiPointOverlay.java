package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.List;

public class MultiPointOverlay
{
  IMultiPointOverlay a;
  
  public MultiPointOverlay(IMultiPointOverlay paramIMultiPointOverlay)
  {
    this.a = paramIMultiPointOverlay;
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy(true);
    }
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.remove(true);
    }
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.a != null) {
      this.a.setAnchor(paramFloat1, paramFloat2);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
  }
  
  public void setItems(List<MultiPointItem> paramList)
  {
    if (this.a != null) {
      this.a.addItems(paramList);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MultiPointOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */