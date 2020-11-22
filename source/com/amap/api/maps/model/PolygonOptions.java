package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  extends BaseOptions
  implements Parcelable
{
  public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
  String a;
  private int fillColor = -16777216;
  private List<BaseHoleOptions> holeOptions = new ArrayList();
  private boolean isHoleOptionsUpdated = false;
  private boolean isPointsUpdated = false;
  private boolean isUsePolylineStroke = false;
  private boolean isVisible = true;
  private AMapPara.LineJoinType lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
  private int nLineCapType = 3;
  private int nLineJoinType = 0;
  private double[] pointList;
  private final List<LatLng> points = new ArrayList();
  private int strokeColor = -16777216;
  private float strokeWidth = 10.0F;
  private final String type = "PolygonOptions";
  private float zIndex = 0.0F;
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    try
    {
      this.points.add(paramLatLng);
      this.isPointsUpdated = true;
      return this;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    try
    {
      this.points.addAll(Arrays.asList(paramVarArgs));
      this.isPointsUpdated = true;
      return this;
    }
    catch (Throwable paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.points.add(localLatLng);
      }
      this.isPointsUpdated = true;
      return this;
    }
    catch (Throwable paramIterable)
    {
      paramIterable.printStackTrace();
    }
    return this;
  }
  
  public PolygonOptions addHoles(Iterable<BaseHoleOptions> paramIterable)
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
  
  public PolygonOptions addHoles(BaseHoleOptions... paramVarArgs)
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public int getFillColor()
  {
    return this.fillColor;
  }
  
  public List<BaseHoleOptions> getHoleOptions()
  {
    return this.holeOptions;
  }
  
  public AMapPara.LineJoinType getLineJoinType()
  {
    return this.lineJoinType;
  }
  
  public List<LatLng> getPoints()
  {
    return this.points;
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
  
  public boolean isUsePolylineStroke()
  {
    return this.isUsePolylineStroke;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public PolygonOptions lineJoinType(AMapPara.LineJoinType paramLineJoinType)
  {
    if (paramLineJoinType != null)
    {
      this.lineJoinType = paramLineJoinType;
      this.nLineJoinType = paramLineJoinType.getTypeValue();
    }
    return this;
  }
  
  public void setHoleOptions(List<BaseHoleOptions> paramList)
  {
    try
    {
      this.holeOptions.clear();
      this.holeOptions.addAll(paramList);
      this.isHoleOptionsUpdated = true;
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    try
    {
      this.points.clear();
      this.points.addAll(paramList);
      this.isPointsUpdated = true;
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
    return this;
  }
  
  public PolygonOptions usePolylineStroke(boolean paramBoolean)
  {
    this.isUsePolylineStroke = paramBoolean;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.points);
    paramParcel.writeFloat(this.strokeWidth);
    paramParcel.writeInt(this.strokeColor);
    paramParcel.writeInt(this.fillColor);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.holeOptions);
    paramParcel.writeInt(this.lineJoinType.getTypeValue());
    paramParcel.writeByte((byte)this.isUsePolylineStroke);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */