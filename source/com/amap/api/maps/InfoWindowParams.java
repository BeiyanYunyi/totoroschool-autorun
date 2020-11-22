package com.amap.api.maps;

import android.view.View;

public class InfoWindowParams
{
  public static final int INFOWINDOW_TYPE_IMAGE = 1;
  public static final int INFOWINDOW_TYPE_VIEW = 2;
  private int a = 2;
  private int b;
  private View c;
  private View d;
  
  public View getInfoContents()
  {
    return this.d;
  }
  
  public View getInfoWindow()
  {
    return this.c;
  }
  
  public int getInfoWindowType()
  {
    return this.a;
  }
  
  public long getInfoWindowUpdateTime()
  {
    return this.b;
  }
  
  public void setInfoContent(View paramView)
  {
    this.d = paramView;
  }
  
  public void setInfoWindow(View paramView)
  {
    this.c = paramView;
  }
  
  public void setInfoWindowType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setInfoWindowUpdateTime(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\InfoWindowParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */