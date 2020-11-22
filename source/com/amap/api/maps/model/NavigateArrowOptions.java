package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class NavigateArrowOptions
  extends BaseOptions
  implements Parcelable
{
  public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();
  String a;
  private int arrowLineInnerResId = 111;
  private int arrowLineOuterResId = 222;
  private int arrowLineShadowResId = 333;
  private boolean is3DModel = false;
  private boolean isVisible = true;
  private final List<LatLng> points = new ArrayList();
  private int sideColor = Color.argb(170, 0, 172, 146);
  private int topColor = Color.argb(221, 87, 235, 204);
  private final String type = "NavigateArrowOptions";
  private float width = 10.0F;
  private float zIndex = 0.0F;
  
  public NavigateArrowOptions add(LatLng paramLatLng)
  {
    this.points.add(paramLatLng);
    return this;
  }
  
  public NavigateArrowOptions add(LatLng... paramVarArgs)
  {
    this.points.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public NavigateArrowOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public int getSideColor()
  {
    return this.sideColor;
  }
  
  public int getTopColor()
  {
    return this.topColor;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public boolean is3DModel()
  {
    return this.is3DModel;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public NavigateArrowOptions set3DModel(boolean paramBoolean)
  {
    this.is3DModel = paramBoolean;
    return this;
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if ((paramList != null) && (this.points != paramList)) {
      try
      {
        this.points.clear();
        this.points.addAll(paramList);
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public NavigateArrowOptions sideColor(int paramInt)
  {
    this.sideColor = paramInt;
    return this;
  }
  
  public NavigateArrowOptions topColor(int paramInt)
  {
    this.topColor = paramInt;
    return this;
  }
  
  public NavigateArrowOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public NavigateArrowOptions width(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.points);
    paramParcel.writeFloat(this.width);
    paramParcel.writeInt(this.topColor);
    paramParcel.writeInt(this.sideColor);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    paramParcel.writeString(this.a);
    paramParcel.writeByte((byte)this.is3DModel);
  }
  
  public NavigateArrowOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\NavigateArrowOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */