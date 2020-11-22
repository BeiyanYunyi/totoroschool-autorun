package com.autonavi.base.amap.mapcore;

public class FPoint3
  extends FPoint
{
  public int colorIndex = -1;
  
  public FPoint3() {}
  
  public FPoint3(float paramFloat1, float paramFloat2, int paramInt)
  {
    super(paramFloat1, paramFloat2);
    this.colorIndex = paramInt;
  }
  
  public void setColorIndex(int paramInt)
  {
    this.colorIndex = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\FPoint3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */