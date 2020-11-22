package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.dq;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.gk;

public final class CameraPosition
  implements Parcelable
{
  private static final String CLASSNAME = "CameraPosition";
  public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
  public final float bearing;
  public final boolean isAbroad;
  public final LatLng target;
  public final float tilt;
  public final float zoom;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramLatLng == null) {
      Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null");
    }
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.tilt = paramFloat2;
    paramFloat1 = paramFloat3;
    if (paramFloat3 <= 0.0D) {
      paramFloat1 = paramFloat3 % 360.0F + 360.0F;
    }
    this.bearing = (paramFloat1 % 360.0F);
    if (paramLatLng != null)
    {
      this.isAbroad = (dq.a(paramLatLng.latitude, paramLatLng.longitude) ^ true);
      return;
    }
    this.isAbroad = false;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CameraPosition)) {
      return false;
    }
    paramObject = (CameraPosition)paramObject;
    return (this.target.equals(((CameraPosition)paramObject).target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(((CameraPosition)paramObject).zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(((CameraPosition)paramObject).tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((CameraPosition)paramObject).bearing));
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return dx.a(new String[] { dx.a("target", this.target), dx.a("zoom", Float.valueOf(this.zoom)), dx.a("tilt", Float.valueOf(this.tilt)), dx.a("bearing", Float.valueOf(this.bearing)) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.bearing);
    paramParcel.writeFloat((float)this.target.latitude);
    paramParcel.writeFloat((float)this.target.longitude);
    paramParcel.writeFloat(this.tilt);
    paramParcel.writeFloat(this.zoom);
  }
  
  public static final class Builder
  {
    private float bearing;
    private LatLng target;
    private float tilt;
    private float zoom;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      target(paramCameraPosition.target).bearing(paramCameraPosition.bearing).tilt(paramCameraPosition.tilt).zoom(paramCameraPosition.zoom);
    }
    
    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }
    
    public CameraPosition build()
    {
      try
      {
        if (this.target == null)
        {
          Log.w("CameraPosition", "target is null");
          return null;
        }
        CameraPosition localCameraPosition = new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
        return localCameraPosition;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "CameraPosition", "build");
      }
      return null;
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.target = paramLatLng;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.zoom = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */