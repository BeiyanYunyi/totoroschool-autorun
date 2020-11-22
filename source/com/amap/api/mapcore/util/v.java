package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap.CommonInfoWindowAdapter;
import com.amap.api.maps.AMap.ImageInfoWindowAdapter;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.MultiPositionInfoWindowAdapter;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

public class v
{
  AMap.InfoWindowAdapter a = null;
  AMap.CommonInfoWindowAdapter b = null;
  Context c;
  private boolean d = true;
  private View e;
  private TextView f;
  private TextView g;
  private Drawable h = null;
  private IInfoWindowAction i;
  private IInfoWindowAction j;
  private AMap.InfoWindowAdapter k = new AMap.InfoWindowAdapter()
  {
    public View getInfoContents(Marker paramAnonymousMarker)
    {
      return null;
    }
    
    public View getInfoWindow(Marker paramAnonymousMarker)
    {
      try
      {
        if (v.a(v.this) == null) {
          v.a(v.this, dm.a(v.this.c, "infowindow_bg.9.png"));
        }
        if (v.b(v.this) == null)
        {
          v.a(v.this, new LinearLayout(v.this.c));
          v.b(v.this).setBackground(v.a(v.this));
          v.a(v.this, new TextView(v.this.c));
          v.c(v.this).setText(paramAnonymousMarker.getTitle());
          v.c(v.this).setTextColor(-16777216);
          v.b(v.this, new TextView(v.this.c));
          v.d(v.this).setTextColor(-16777216);
          v.d(v.this).setText(paramAnonymousMarker.getSnippet());
          ((LinearLayout)v.b(v.this)).setOrientation(1);
          ((LinearLayout)v.b(v.this)).addView(v.c(v.this));
          ((LinearLayout)v.b(v.this)).addView(v.d(v.this));
        }
      }
      catch (Throwable paramAnonymousMarker)
      {
        gk.c(paramAnonymousMarker, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
        paramAnonymousMarker.printStackTrace();
      }
      return v.b(v.this);
    }
  };
  private AMap.CommonInfoWindowAdapter l = new AMap.CommonInfoWindowAdapter()
  {
    public InfoWindowParams getInfoWindowParams(BasePointOverlay paramAnonymousBasePointOverlay)
    {
      try
      {
        paramAnonymousBasePointOverlay = new InfoWindowParams();
        if (v.a(v.this) == null) {
          v.a(v.this, dm.a(v.this.c, "infowindow_bg.9.png"));
        }
        v.a(v.this, new LinearLayout(v.this.c));
        v.b(v.this).setBackground(v.a(v.this));
        v.a(v.this, new TextView(v.this.c));
        v.c(v.this).setText("标题");
        v.c(v.this).setTextColor(-16777216);
        v.b(v.this, new TextView(v.this.c));
        v.d(v.this).setTextColor(-16777216);
        v.d(v.this).setText("内容");
        ((LinearLayout)v.b(v.this)).setOrientation(1);
        ((LinearLayout)v.b(v.this)).addView(v.c(v.this));
        ((LinearLayout)v.b(v.this)).addView(v.d(v.this));
        paramAnonymousBasePointOverlay.setInfoWindowType(2);
        paramAnonymousBasePointOverlay.setInfoWindow(v.b(v.this));
        return paramAnonymousBasePointOverlay;
      }
      catch (Throwable paramAnonymousBasePointOverlay)
      {
        gk.c(paramAnonymousBasePointOverlay, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
        paramAnonymousBasePointOverlay.printStackTrace();
      }
      return null;
    }
  };
  
  public v(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public View a(BasePointOverlay paramBasePointOverlay)
  {
    if (this.a != null) {
      return this.a.getInfoWindow((Marker)paramBasePointOverlay);
    }
    if (this.b != null)
    {
      InfoWindowParams localInfoWindowParams = this.b.getInfoWindowParams(paramBasePointOverlay);
      if (localInfoWindowParams != null) {
        return localInfoWindowParams.getInfoWindow();
      }
    }
    paramBasePointOverlay = this.l.getInfoWindowParams(paramBasePointOverlay);
    if (paramBasePointOverlay != null) {
      return paramBasePointOverlay.getInfoWindow();
    }
    return null;
  }
  
  public View a(Marker paramMarker)
  {
    if ((this.a != null) && ((this.a instanceof AMap.MultiPositionInfoWindowAdapter))) {
      return ((AMap.MultiPositionInfoWindowAdapter)this.a).getInfoWindowClick(paramMarker);
    }
    return null;
  }
  
  public void a(AMap.CommonInfoWindowAdapter paramCommonInfoWindowAdapter)
  {
    try
    {
      this.b = paramCommonInfoWindowAdapter;
      this.a = null;
      if (this.b == null)
      {
        this.b = this.l;
        this.d = true;
      }
      else
      {
        this.d = false;
      }
      if (this.j != null) {
        this.j.hideInfoWindow();
      }
      if (this.i != null) {
        this.i.hideInfoWindow();
      }
      return;
    }
    finally {}
  }
  
  public void a(AMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    try
    {
      this.a = paramInfoWindowAdapter;
      this.b = null;
      if (this.a == null)
      {
        this.a = this.k;
        this.d = true;
      }
      else
      {
        this.d = false;
      }
      if (this.j != null) {
        this.j.hideInfoWindow();
      }
      if (this.i != null) {
        this.i.hideInfoWindow();
      }
      return;
    }
    finally {}
  }
  
  public void a(BaseOverlayImp paramBaseOverlayImp)
    throws RemoteException
  {
    IInfoWindowAction localIInfoWindowAction = d();
    if (localIInfoWindowAction != null) {
      localIInfoWindowAction.showInfoWindow(paramBaseOverlayImp);
    }
  }
  
  public void a(IInfoWindowAction paramIInfoWindowAction)
  {
    try
    {
      this.i = paramIInfoWindowAction;
      if (this.i != null) {
        this.i.setInfoWindowAdapterManager(this);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.f != null)
    {
      this.f.requestLayout();
      this.f.setText(paramString1);
    }
    if (this.g != null)
    {
      this.g.requestLayout();
      this.g.setText(paramString2);
    }
    if (this.e != null) {
      this.e.requestLayout();
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    IInfoWindowAction localIInfoWindowAction = d();
    if (localIInfoWindowAction != null) {
      return localIInfoWindowAction.onInfoWindowTap(paramMotionEvent);
    }
    return false;
  }
  
  public View b(BasePointOverlay paramBasePointOverlay)
  {
    if (this.a != null) {
      return this.a.getInfoContents((Marker)paramBasePointOverlay);
    }
    if (this.b != null)
    {
      InfoWindowParams localInfoWindowParams = this.b.getInfoWindowParams(paramBasePointOverlay);
      if (localInfoWindowParams != null) {
        return localInfoWindowParams.getInfoContents();
      }
    }
    paramBasePointOverlay = this.l.getInfoWindowParams(paramBasePointOverlay);
    if (paramBasePointOverlay != null) {
      return paramBasePointOverlay.getInfoContents();
    }
    return null;
  }
  
  public View b(Marker paramMarker)
  {
    if ((this.a != null) && ((this.a instanceof AMap.MultiPositionInfoWindowAdapter))) {
      return ((AMap.MultiPositionInfoWindowAdapter)this.a).getOverturnInfoWindow(paramMarker);
    }
    return null;
  }
  
  public void b()
  {
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = null;
    try
    {
      dx.a(this.h);
      this.h = null;
      this.k = null;
      this.a = null;
      this.b = null;
      this.i = null;
      this.j = null;
      return;
    }
    finally {}
  }
  
  public void b(IInfoWindowAction paramIInfoWindowAction)
  {
    try
    {
      this.j = paramIInfoWindowAction;
      if (this.j != null) {
        this.j.setInfoWindowAdapterManager(this);
      }
      return;
    }
    finally {}
  }
  
  public long c(BasePointOverlay paramBasePointOverlay)
  {
    if ((this.a != null) && ((this.a instanceof AMap.ImageInfoWindowAdapter))) {
      return ((AMap.ImageInfoWindowAdapter)this.a).getInfoWindowUpdateTime();
    }
    if (this.b != null)
    {
      paramBasePointOverlay = this.b.getInfoWindowParams(paramBasePointOverlay);
      if (paramBasePointOverlay != null) {
        return paramBasePointOverlay.getInfoWindowUpdateTime();
      }
    }
    return 0L;
  }
  
  public View c(Marker paramMarker)
  {
    if ((this.a != null) && ((this.a instanceof AMap.MultiPositionInfoWindowAdapter))) {
      return ((AMap.MultiPositionInfoWindowAdapter)this.a).getOverturnInfoWindowClick(paramMarker);
    }
    return null;
  }
  
  public void c()
  {
    IInfoWindowAction localIInfoWindowAction = d();
    if (localIInfoWindowAction != null) {
      localIInfoWindowAction.redrawInfoWindow();
    }
  }
  
  public IInfoWindowAction d()
  {
    try
    {
      if (this.a != null)
      {
        if ((this.a instanceof AMap.ImageInfoWindowAdapter))
        {
          localIInfoWindowAction = this.j;
          return localIInfoWindowAction;
        }
        if ((this.a instanceof AMap.MultiPositionInfoWindowAdapter))
        {
          localIInfoWindowAction = this.j;
          return localIInfoWindowAction;
        }
      }
      if ((this.b != null) && (this.b.getInfoWindowParams(null).getInfoWindowType() == 1))
      {
        localIInfoWindowAction = this.j;
        return localIInfoWindowAction;
      }
      IInfoWindowAction localIInfoWindowAction = this.i;
      return localIInfoWindowAction;
    }
    finally {}
  }
  
  public void e()
  {
    IInfoWindowAction localIInfoWindowAction = d();
    if (localIInfoWindowAction != null) {
      localIInfoWindowAction.hideInfoWindow();
    }
  }
  
  public boolean f()
  {
    IInfoWindowAction localIInfoWindowAction = d();
    if (localIInfoWindowAction != null) {
      return localIInfoWindowAction.isInfoWindowShown();
    }
    return false;
  }
  
  public Drawable g()
  {
    if (this.h == null) {
      try
      {
        this.h = dm.a(this.c, "infowindow_bg.9.png");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return this.h;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */