package com.amap.api.mapcore.util;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.opengles.GL10;

public abstract class bt
{
  private IAMapDelegate map;
  
  public void destroy()
  {
    IAMapDelegate localIAMapDelegate = this.map;
  }
  
  public abstract int getZIndex();
  
  public abstract void onDrawFrame(GL10 paramGL10);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */