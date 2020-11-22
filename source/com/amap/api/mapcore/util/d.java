package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

class d
  implements IUiSettingsDelegate
{
  final Handler a = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage != null)
      {
        if (d.a(d.this) == null) {
          return;
        }
        try
        {
          switch (paramAnonymousMessage.what)
          {
          case 6: 
            d.a(d.this).refreshLogo();
            return;
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          gk.c(paramAnonymousMessage, "UiSettingsDelegateImp", "handleMessage");
          return;
        }
        d.a(d.this).showLogoEnabled(d.g(d.this));
        return;
        d.a(d.this).showIndoorSwitchControlsEnabled(d.f(d.this));
        return;
        d.a(d.this).showMyLocationButtonEnabled(d.e(d.this));
        return;
        d.a(d.this).showCompassEnabled(d.d(d.this));
        return;
        d.a(d.this).showScaleEnabled(d.c(d.this));
        return;
        d.a(d.this).showZoomControlsEnabled(d.b(d.this));
        return;
      }
      return;
    }
  };
  private IAMapDelegate b;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private boolean j = false;
  private boolean k = true;
  private int l = 0;
  private int m = 1;
  private boolean n = true;
  private boolean o = false;
  private boolean p = false;
  
  d(IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramIAMapDelegate;
  }
  
  public float getLogoMarginRate(int paramInt)
  {
    return this.b.getLogoMarginRate(paramInt);
  }
  
  public int getLogoPosition()
    throws RemoteException
  {
    return this.l;
  }
  
  public int getZoomPosition()
    throws RemoteException
  {
    return this.m;
  }
  
  public boolean isCompassEnabled()
    throws RemoteException
  {
    return this.i;
  }
  
  public boolean isGestureScaleByMapCenter()
    throws RemoteException
  {
    return this.p;
  }
  
  public boolean isIndoorSwitchEnabled()
    throws RemoteException
  {
    return this.n;
  }
  
  public boolean isLogoEnable()
  {
    return this.k;
  }
  
  public boolean isMyLocationButtonEnabled()
    throws RemoteException
  {
    return this.f;
  }
  
  public boolean isRotateGesturesEnabled()
    throws RemoteException
  {
    return this.c;
  }
  
  public boolean isScaleControlsEnabled()
    throws RemoteException
  {
    return this.j;
  }
  
  public boolean isScrollGesturesEnabled()
    throws RemoteException
  {
    return this.d;
  }
  
  public boolean isTiltGesturesEnabled()
    throws RemoteException
  {
    return this.e;
  }
  
  public boolean isZoomControlsEnabled()
    throws RemoteException
  {
    return this.h;
  }
  
  public boolean isZoomGesturesEnabled()
    throws RemoteException
  {
    return this.g;
  }
  
  public boolean isZoomInByScreenCenter()
  {
    return this.o;
  }
  
  public void requestRefreshLogo()
  {
    this.a.obtainMessage(6).sendToTarget();
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    setRotateGesturesEnabled(paramBoolean);
    setTiltGesturesEnabled(paramBoolean);
    setZoomGesturesEnabled(paramBoolean);
    setScrollGesturesEnabled(paramBoolean);
  }
  
  public void setCompassEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.i = paramBoolean;
    this.a.obtainMessage(2).sendToTarget();
  }
  
  public void setGestureScaleByMapCenter(boolean paramBoolean)
    throws RemoteException
  {
    this.p = paramBoolean;
  }
  
  public void setIndoorSwitchEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.n = paramBoolean;
    this.a.obtainMessage(4).sendToTarget();
  }
  
  public void setLogoBottomMargin(int paramInt)
  {
    this.b.setLogoBottomMargin(paramInt);
  }
  
  public void setLogoEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.a.obtainMessage(5).sendToTarget();
  }
  
  public void setLogoLeftMargin(int paramInt)
  {
    this.b.setLogoLeftMargin(paramInt);
  }
  
  public void setLogoMarginRate(int paramInt, float paramFloat)
  {
    this.b.setLogoMarginRate(paramInt, paramFloat);
  }
  
  public void setLogoPosition(int paramInt)
    throws RemoteException
  {
    this.l = paramInt;
    this.b.setLogoPosition(paramInt);
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.f = paramBoolean;
    this.a.obtainMessage(3).sendToTarget();
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.c = paramBoolean;
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.j = paramBoolean;
    this.a.obtainMessage(1).sendToTarget();
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.d = paramBoolean;
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.e = paramBoolean;
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.h = paramBoolean;
    this.a.obtainMessage(0).sendToTarget();
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    this.g = paramBoolean;
  }
  
  public void setZoomInByScreenCenter(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setZoomPosition(int paramInt)
    throws RemoteException
  {
    this.m = paramInt;
    this.b.setZoomPosition(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */