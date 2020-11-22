package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public final class GroundOverlayOptions
  extends BaseOptions
  implements Parcelable
{
  private static final String CLASSNAME = "GroundOverlayOptions";
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private final double NF_PI = 0.01745329251994329D;
  private final double R = 6371000.79D;
  private float anchorU = 0.5F;
  private float anchorV = 0.5F;
  private float bearing;
  private BitmapDescriptor bitmapDescriptor;
  private String bitmapSymbol;
  private float height;
  private boolean isVisible = true;
  private LatLng latLng;
  private LatLngBounds latlngBounds;
  private final int mVersionCode;
  private LatLng northeast;
  private LatLng southwest;
  private float transparency = 0.0F;
  private final String type = "GroundOverlayOptions";
  private float width;
  private float zIndex = 0.0F;
  
  public GroundOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.mVersionCode = paramInt;
    this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
    this.latLng = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.latlngBounds = paramLatLngBounds;
    this.bearing = paramFloat3;
    this.zIndex = paramFloat4;
    this.isVisible = paramBoolean;
    this.transparency = paramFloat5;
    this.anchorU = paramFloat6;
    this.anchorV = paramFloat7;
    this.southwest = paramLatLngBounds.southwest;
    this.northeast = paramLatLngBounds.northeast;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.latLng = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    b();
    return this;
  }
  
  private void a()
  {
    if (this.southwest != null)
    {
      if (this.northeast == null) {
        return;
      }
      double d1 = this.southwest.latitude;
      double d2 = 1.0F - this.anchorV;
      double d3 = this.northeast.latitude;
      double d4 = this.southwest.latitude;
      Double.isNaN(d2);
      double d5 = this.southwest.longitude;
      double d6 = this.anchorU;
      double d7 = this.northeast.longitude;
      double d8 = this.southwest.longitude;
      Double.isNaN(d6);
      this.latLng = new LatLng(d1 + d2 * (d3 - d4), d5 + d6 * (d7 - d8));
      this.width = ((float)(Math.cos(this.latLng.latitude * 0.01745329251994329D) * 6371000.79D * (this.northeast.longitude - this.southwest.longitude) * 0.01745329251994329D));
      this.height = ((float)((this.northeast.latitude - this.southwest.latitude) * 6371000.79D * 0.01745329251994329D));
      return;
    }
  }
  
  private void b()
  {
    if (this.latLng == null) {
      return;
    }
    double d1 = this.width;
    double d2 = Math.cos(this.latLng.latitude * 0.01745329251994329D);
    Double.isNaN(d1);
    d1 /= d2 * 6371000.79D * 0.01745329251994329D;
    d2 = this.height;
    Double.isNaN(d2);
    d2 /= 111194.94043265979D;
    try
    {
      double d3 = this.latLng.latitude;
      float f = this.anchorV;
      double d4 = 1.0F - f;
      Double.isNaN(d4);
      double d5 = this.latLng.longitude;
      f = this.anchorU;
      double d6 = f;
      Double.isNaN(d6);
      LatLng localLatLng = new LatLng(d3 - d4 * d2, d5 - d6 * d1);
      d3 = this.latLng.latitude;
      f = this.anchorV;
      d4 = f;
      Double.isNaN(d4);
      d5 = this.latLng.longitude;
      f = this.anchorU;
      d6 = 1.0F - f;
      Double.isNaN(d6);
      this.latlngBounds = new LatLngBounds(localLatLng, new LatLng(d3 + d4 * d2, d5 + d6 * d1));
      this.southwest = this.latlngBounds.southwest;
      this.northeast = this.latlngBounds.northeast;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    if (this.latlngBounds != null)
    {
      a();
      return this;
    }
    if (this.latLng != null) {
      b();
    }
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.anchorU;
  }
  
  public float getAnchorV()
  {
    return this.anchorV;
  }
  
  public float getBearing()
  {
    return this.bearing;
  }
  
  public LatLngBounds getBounds()
  {
    return this.latlngBounds;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.bitmapDescriptor;
  }
  
  public LatLng getLocation()
  {
    return this.latLng;
  }
  
  public float getTransparency()
  {
    return this.transparency;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDescriptor = paramBitmapDescriptor;
    if (this.bitmapDescriptor != null) {
      this.bitmapSymbol = this.bitmapDescriptor.getId();
    }
    return this;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    if (this.latlngBounds != null) {
      Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
    }
    if (paramLatLng == null) {
      Log.w("GroundOverlayOptions", "Location must be specified");
    }
    if (paramFloat <= 0.0F) {
      Log.w("GroundOverlayOptions", "Width must be non-negative");
    }
    return a(paramLatLng, paramFloat, paramFloat);
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    if (this.latlngBounds != null) {
      Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
    }
    if (paramLatLng == null) {
      Log.w("GroundOverlayOptions", "Location must be specified");
    }
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      Log.w("GroundOverlayOptions", "Width and Height must be non-negative");
    }
    return a(paramLatLng, paramFloat1, paramFloat2);
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    this.latlngBounds = paramLatLngBounds;
    this.southwest = paramLatLngBounds.southwest;
    this.northeast = paramLatLngBounds.northeast;
    a();
    return this;
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F)
    {
      Log.w("GroundOverlayOptions", "Transparency must be in the range [0..1]");
      f = 0.0F;
    }
    this.transparency = f;
    return this;
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mVersionCode);
    paramParcel.writeParcelable(this.bitmapDescriptor, paramInt);
    paramParcel.writeParcelable(this.latLng, paramInt);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeParcelable(this.latlngBounds, paramInt);
    paramParcel.writeFloat(this.bearing);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    paramParcel.writeFloat(this.transparency);
    paramParcel.writeFloat(this.anchorU);
    paramParcel.writeFloat(this.anchorV);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */