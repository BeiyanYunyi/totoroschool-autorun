package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class TextOptions
  implements Parcelable
{
  public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
  String a;
  private int alignX = 4;
  private int alignY = 32;
  private int backgroundColor = -1;
  private int fontColor = -16777216;
  private int fontSize = 20;
  private boolean isVisible = true;
  private Object object;
  private LatLng position;
  private float rotate;
  private String text;
  private Typeface typeface = Typeface.DEFAULT;
  private float zIndex = 0.0F;
  
  public TextOptions align(int paramInt1, int paramInt2)
  {
    this.alignX = paramInt1;
    this.alignY = paramInt2;
    return this;
  }
  
  public TextOptions backgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TextOptions fontColor(int paramInt)
  {
    this.fontColor = paramInt;
    return this;
  }
  
  public TextOptions fontSize(int paramInt)
  {
    this.fontSize = paramInt;
    return this;
  }
  
  public int getAlignX()
  {
    return this.alignX;
  }
  
  public int getAlignY()
  {
    return this.alignY;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public int getFontColor()
  {
    return this.fontColor;
  }
  
  public int getFontSize()
  {
    return this.fontSize;
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public LatLng getPosition()
  {
    return this.position;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public Typeface getTypeface()
  {
    return this.typeface;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public TextOptions position(LatLng paramLatLng)
  {
    this.position = paramLatLng;
    return this;
  }
  
  public TextOptions rotate(float paramFloat)
  {
    this.rotate = paramFloat;
    return this;
  }
  
  public TextOptions setObject(Object paramObject)
  {
    this.object = paramObject;
    return this;
  }
  
  public TextOptions text(String paramString)
  {
    this.text = paramString;
    return this;
  }
  
  public TextOptions typeface(Typeface paramTypeface)
  {
    if (paramTypeface != null) {
      this.typeface = paramTypeface;
    }
    return this;
  }
  
  public TextOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    Bundle localBundle = new Bundle();
    if (this.position != null)
    {
      localBundle.putDouble("lat", this.position.latitude);
      localBundle.putDouble("lng", this.position.longitude);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeString(this.text);
    paramParcel.writeInt(this.typeface.getStyle());
    paramParcel.writeFloat(this.rotate);
    paramParcel.writeInt(this.alignX);
    paramParcel.writeInt(this.alignY);
    paramParcel.writeInt(this.backgroundColor);
    paramParcel.writeInt(this.fontColor);
    paramParcel.writeInt(this.fontSize);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeByte((byte)this.isVisible);
    if ((this.object instanceof Parcelable))
    {
      localBundle = new Bundle();
      localBundle.putParcelable("obj", (Parcelable)this.object);
      paramParcel.writeBundle(localBundle);
    }
  }
  
  public TextOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TextOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */