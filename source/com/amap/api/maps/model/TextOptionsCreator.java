package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class TextOptionsCreator
  implements Parcelable.Creator<TextOptions>
{
  public TextOptions createFromParcel(Parcel paramParcel)
  {
    TextOptions localTextOptions = new TextOptions();
    localTextOptions.a = paramParcel.readString();
    Bundle localBundle = paramParcel.readBundle();
    localTextOptions.position(new LatLng(localBundle.getDouble("lat"), localBundle.getDouble("lng")));
    localTextOptions.text(paramParcel.readString());
    localTextOptions.typeface(Typeface.defaultFromStyle(paramParcel.readInt()));
    localTextOptions.rotate(paramParcel.readFloat());
    localTextOptions.align(paramParcel.readInt(), paramParcel.readInt());
    localTextOptions.backgroundColor(paramParcel.readInt());
    localTextOptions.fontColor(paramParcel.readInt());
    localTextOptions.fontSize(paramParcel.readInt());
    localTextOptions.zIndex(paramParcel.readFloat());
    int i = paramParcel.readByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localTextOptions.visible(bool);
    try
    {
      paramParcel = paramParcel.readBundle().getParcelable("obj");
      if (paramParcel != null)
      {
        localTextOptions.setObject(paramParcel);
        return localTextOptions;
      }
    }
    catch (Throwable paramParcel)
    {
      paramParcel.printStackTrace();
    }
    return localTextOptions;
  }
  
  public TextOptions[] newArray(int paramInt)
  {
    return new TextOptions[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TextOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */