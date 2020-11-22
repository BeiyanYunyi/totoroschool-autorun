package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions
  implements Parcelable
{
  public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
  String a;
  private float anchorU = 0.5F;
  private float anchorV = 1.0F;
  private float angleOffset = 0.0F;
  float b = 1.0F;
  private ArrayList<BitmapDescriptor> bitmapDescriptors = new ArrayList();
  boolean c = false;
  boolean d = true;
  int e = 5;
  float f;
  private boolean isBelowMaskLayer;
  private boolean isDraggable = false;
  private boolean isFlat = false;
  private boolean isGps = false;
  private boolean isRotatingMode = false;
  private boolean isVisible = true;
  private LatLng latLng;
  private int offsetX = 0;
  private int offsetY = 0;
  private int period = 20;
  private boolean perspective = false;
  private String snippet;
  private String title;
  private float zIndex = 0.0F;
  
  private void a()
  {
    if (this.bitmapDescriptors == null) {
      try
      {
        this.bitmapDescriptors = new ArrayList();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    return this;
  }
  
  protected MarkerOptions angleOffset(float paramFloat)
  {
    this.angleOffset = paramFloat;
    return this;
  }
  
  public MarkerOptions autoOverturnInfoWindow(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public MarkerOptions belowMaskLayer(boolean paramBoolean)
  {
    this.isBelowMaskLayer = paramBoolean;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions displayLevel(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.isDraggable = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.b;
  }
  
  public float getAnchorU()
  {
    return this.anchorU;
  }
  
  public float getAnchorV()
  {
    return this.anchorV;
  }
  
  public float getAngleOffset()
  {
    return this.angleOffset;
  }
  
  public int getDisplayLevel()
  {
    return this.e;
  }
  
  public BitmapDescriptor getIcon()
  {
    if ((this.bitmapDescriptors != null) && (this.bitmapDescriptors.size() != 0)) {
      return (BitmapDescriptor)this.bitmapDescriptors.get(0);
    }
    return null;
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    return this.bitmapDescriptors;
  }
  
  public int getInfoWindowOffsetX()
  {
    return this.offsetX;
  }
  
  public int getInfoWindowOffsetY()
  {
    return this.offsetY;
  }
  
  public int getPeriod()
  {
    return this.period;
  }
  
  public LatLng getPosition()
  {
    return this.latLng;
  }
  
  public float getRotateAngle()
  {
    return this.f;
  }
  
  public String getSnippet()
  {
    return this.snippet;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    try
    {
      a();
      this.bitmapDescriptors.clear();
      this.bitmapDescriptors.add(paramBitmapDescriptor);
      this.isRotatingMode = false;
      return this;
    }
    catch (Throwable paramBitmapDescriptor)
    {
      paramBitmapDescriptor.printStackTrace();
    }
    return this;
  }
  
  public MarkerOptions icons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.bitmapDescriptors = paramArrayList;
      this.isRotatingMode = false;
    }
    return this;
  }
  
  public MarkerOptions infoWindowEnable(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean isBelowMaskLayer()
  {
    return this.isBelowMaskLayer;
  }
  
  public boolean isDraggable()
  {
    return this.isDraggable;
  }
  
  public boolean isFlat()
  {
    return this.isFlat;
  }
  
  public boolean isGps()
  {
    return this.isGps;
  }
  
  public boolean isInfoWindowAutoOverturn()
  {
    return this.c;
  }
  
  public boolean isInfoWindowEnable()
  {
    return this.d;
  }
  
  public boolean isPerspective()
  {
    return this.perspective;
  }
  
  public boolean isRotatingMode()
  {
    return this.isRotatingMode;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public MarkerOptions period(int paramInt)
  {
    if (paramInt <= 1)
    {
      this.period = 1;
      return this;
    }
    this.period = paramInt;
    return this;
  }
  
  public MarkerOptions perspective(boolean paramBoolean)
  {
    this.perspective = paramBoolean;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotateAngle(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }
  
  public MarkerOptions rotatingIcons(ArrayList<BitmapDescriptor> paramArrayList, float paramFloat)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.bitmapDescriptors = paramArrayList;
      if (paramFloat != 0.0F) {
        this.angleOffset = paramFloat;
      } else {
        this.angleOffset = (360.0F / paramArrayList.size());
      }
      this.isRotatingMode = true;
    }
    return this;
  }
  
  public MarkerOptions setFlat(boolean paramBoolean)
  {
    this.isFlat = paramBoolean;
    return this;
  }
  
  public MarkerOptions setGps(boolean paramBoolean)
  {
    this.isGps = paramBoolean;
    return this;
  }
  
  public MarkerOptions setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    this.offsetX = paramInt1;
    this.offsetY = paramInt2;
    return this;
  }
  
  protected MarkerOptions setRotatingMode(boolean paramBoolean)
  {
    this.isRotatingMode = paramBoolean;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.snippet = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.title = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.latLng, paramInt);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.snippet);
    paramParcel.writeFloat(this.anchorU);
    paramParcel.writeFloat(this.anchorV);
    paramParcel.writeInt(this.offsetX);
    paramParcel.writeInt(this.offsetY);
    paramParcel.writeBooleanArray(new boolean[] { this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.c, this.d, this.isBelowMaskLayer, this.isRotatingMode });
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.period);
    paramParcel.writeList(this.bitmapDescriptors);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeFloat(this.b);
    paramParcel.writeInt(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.angleOffset);
    if ((this.bitmapDescriptors != null) && (this.bitmapDescriptors.size() != 0)) {
      paramParcel.writeParcelable((Parcelable)this.bitmapDescriptors.get(0), paramInt);
    }
  }
  
  public MarkerOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */