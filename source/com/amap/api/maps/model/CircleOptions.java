package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CircleOptions
  extends BaseOptions
  implements Parcelable
{
  public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
  String a;
  private int dottedLineType = -1;
  private int fillColor = 0;
  private List<BaseHoleOptions> holeOptions = new ArrayList();
  private boolean isCenterUpdated = false;
  private boolean isHoleOptionsUpdated = false;
  private boolean isRadiusUpdated = false;
  private boolean isUsePolylineStroke = false;
  private boolean isVisible = true;
  private LatLng point = null;
  private double radius = 0.0D;
  private int strokeColor = -16777216;
  private float strokeWidth = 10.0F;
  private final String type = "CircleOptions";
  private float zIndex = 0.0F;
  
  public CircleOptions addHoles(Iterable<BaseHoleOptions> paramIterable)
  {
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)paramIterable.next();
        this.holeOptions.add(localBaseHoleOptions);
      }
      this.isHoleOptionsUpdated = true;
      return this;
    }
    catch (Throwable paramIterable)
    {
      paramIterable.printStackTrace();
    }
    return this;
  }
  
  public CircleOptions addHoles(BaseHoleOptions... paramVarArgs)
  {
    try
    {
      this.holeOptions.addAll(Arrays.asList(paramVarArgs));
      this.isHoleOptionsUpdated = true;
      return this;
    }
    catch (Throwable paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return this;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.point = paramLatLng;
    this.isCenterUpdated = true;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.point;
  }
  
  public int getFillColor()
  {
    return this.fillColor;
  }
  
  public List<BaseHoleOptions> getHoleOptions()
  {
    return this.holeOptions;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public int getStrokeDottedLineType()
  {
    return this.dottedLineType;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public boolean isUsePolylineStroke()
  {
    return this.isUsePolylineStroke;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.radius = paramDouble;
    this.isRadiusUpdated = true;
    return this;
  }
  
  public CircleOptions setStrokeDottedLineType(int paramInt)
  {
    this.dottedLineType = paramInt;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
    return this;
  }
  
  public CircleOptions usePolylineStroke(boolean paramBoolean)
  {
    this.isUsePolylineStroke = paramBoolean;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (this.point != null)
    {
      localBundle.putDouble("lat", this.point.latitude);
      localBundle.putDouble("lng", this.point.longitude);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeDouble(this.radius);
    paramParcel.writeFloat(this.strokeWidth);
    paramParcel.writeInt(this.strokeColor);
    paramParcel.writeInt(this.fillColor);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.holeOptions);
    paramParcel.writeInt(this.dottedLineType);
    paramParcel.writeByte((byte)this.isUsePolylineStroke);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */