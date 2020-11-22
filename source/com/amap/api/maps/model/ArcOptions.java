package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class ArcOptions
  extends BaseOptions
  implements Parcelable
{
  public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
  String a;
  private LatLng endpoint;
  private boolean isVisible = true;
  private LatLng passedpoint;
  private LatLng startpoint;
  private int strokeColor = -16777216;
  private float strokeWidth = 10.0F;
  private final String type = "ArcOptions";
  private float zIndex = 0.0F;
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getEnd()
  {
    return this.endpoint;
  }
  
  public LatLng getPassed()
  {
    return this.passedpoint;
  }
  
  public LatLng getStart()
  {
    return this.startpoint;
  }
  
  public int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public ArcOptions point(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    this.startpoint = paramLatLng1;
    this.passedpoint = paramLatLng2;
    this.endpoint = paramLatLng3;
    return this;
  }
  
  public ArcOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public ArcOptions strokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
    return this;
  }
  
  public ArcOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (this.startpoint != null)
    {
      localBundle.putDouble("startlat", this.startpoint.latitude);
      localBundle.putDouble("startlng", this.startpoint.longitude);
    }
    if (this.passedpoint != null)
    {
      localBundle.putDouble("passedlat", this.passedpoint.latitude);
      localBundle.putDouble("passedlng", this.passedpoint.longitude);
    }
    if (this.endpoint != null)
    {
      localBundle.putDouble("endlat", this.endpoint.latitude);
      localBundle.putDouble("endlng", this.endpoint.longitude);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeFloat(this.strokeWidth);
    paramParcel.writeInt(this.strokeColor);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    paramParcel.writeString(this.a);
  }
  
  public ArcOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\ArcOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */