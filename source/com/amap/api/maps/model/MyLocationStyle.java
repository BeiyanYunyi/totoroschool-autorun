package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class MyLocationStyle
  implements Parcelable
{
  public static final MyLocationStyleCreator CREATOR = new MyLocationStyleCreator();
  public static final String ERROR_CODE = "errorCode";
  public static final String ERROR_INFO = "errorInfo";
  public static final String LOCATION_TYPE = "locationType";
  public static final int LOCATION_TYPE_FOLLOW = 2;
  public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
  public static final int LOCATION_TYPE_LOCATE = 1;
  public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
  public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
  public static final int LOCATION_TYPE_MAP_ROTATE = 3;
  public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
  public static final int LOCATION_TYPE_SHOW = 0;
  private long interval = 2000L;
  private float mAnchorU = 0.5F;
  private float mAnchorV = 0.5F;
  private int mLocationType = 4;
  private BitmapDescriptor mMyLocationIcon;
  private int mRadiusFillColor = Color.argb(100, 0, 0, 180);
  private int mStrokeColor = Color.argb(255, 0, 0, 220);
  private float mStrokeWidth = 1.0F;
  private boolean myLocationVisible = true;
  
  public MyLocationStyle anchor(float paramFloat1, float paramFloat2)
  {
    this.mAnchorU = paramFloat1;
    this.mAnchorV = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.mAnchorU;
  }
  
  public float getAnchorV()
  {
    return this.mAnchorV;
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public BitmapDescriptor getMyLocationIcon()
  {
    return this.mMyLocationIcon;
  }
  
  public int getMyLocationType()
  {
    return this.mLocationType;
  }
  
  public int getRadiusFillColor()
  {
    return this.mRadiusFillColor;
  }
  
  public int getStrokeColor()
  {
    return this.mStrokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }
  
  public MyLocationStyle interval(long paramLong)
  {
    this.interval = paramLong;
    return this;
  }
  
  public boolean isMyLocationShowing()
  {
    return this.myLocationVisible;
  }
  
  public MyLocationStyle myLocationIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mMyLocationIcon = paramBitmapDescriptor;
    return this;
  }
  
  public MyLocationStyle myLocationType(int paramInt)
  {
    this.mLocationType = paramInt;
    return this;
  }
  
  public MyLocationStyle radiusFillColor(int paramInt)
  {
    this.mRadiusFillColor = paramInt;
    return this;
  }
  
  public MyLocationStyle showMyLocation(boolean paramBoolean)
  {
    this.myLocationVisible = paramBoolean;
    return this;
  }
  
  public MyLocationStyle strokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mMyLocationIcon, paramInt);
    paramParcel.writeFloat(this.mAnchorU);
    paramParcel.writeFloat(this.mAnchorV);
    paramParcel.writeInt(this.mRadiusFillColor);
    paramParcel.writeInt(this.mStrokeColor);
    paramParcel.writeFloat(this.mStrokeWidth);
    paramParcel.writeInt(this.mLocationType);
    paramParcel.writeLong(this.interval);
    paramParcel.writeBooleanArray(new boolean[] { this.myLocationVisible });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MyLocationStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */