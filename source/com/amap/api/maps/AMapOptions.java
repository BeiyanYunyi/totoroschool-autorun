package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

public class AMapOptions
  implements Parcelable
{
  public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
  public static final int LOGO_MARGIN_BOTTOM = 2;
  public static final int LOGO_MARGIN_LEFT = 0;
  public static final int LOGO_MARGIN_RIGHT = 1;
  public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
  public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
  public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
  public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
  public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
  private int a = 1;
  private boolean b = true;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private CameraPosition h;
  private boolean i = false;
  private boolean j = false;
  private int k = 0;
  
  public AMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.h = paramCameraPosition;
    return this;
  }
  
  public AMapOptions compassEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CameraPosition getCamera()
  {
    return this.h;
  }
  
  public boolean getCompassEnabled()
  {
    return this.i;
  }
  
  public int getLogoPosition()
  {
    return this.k;
  }
  
  public int getMapType()
  {
    return this.a;
  }
  
  public boolean getRotateGesturesEnabled()
  {
    return this.b;
  }
  
  public boolean getScaleControlsEnabled()
  {
    return this.j;
  }
  
  public boolean getScrollGesturesEnabled()
  {
    return this.c;
  }
  
  public boolean getTiltGesturesEnabled()
  {
    return this.d;
  }
  
  public boolean getZOrderOnTop()
  {
    return this.g;
  }
  
  public boolean getZoomControlsEnabled()
  {
    return this.f;
  }
  
  public boolean getZoomGesturesEnabled()
  {
    return this.e;
  }
  
  public AMapOptions logoPosition(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public AMapOptions mapType(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public AMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public AMapOptions scaleControlsEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public AMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public AMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.h, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeBooleanArray(new boolean[] { this.b, this.c, this.d, this.e, this.f, this.g, this.i, this.j });
  }
  
  public AMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public AMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public AMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\AMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */