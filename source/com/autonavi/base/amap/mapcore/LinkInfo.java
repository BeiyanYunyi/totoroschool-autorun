package com.autonavi.base.amap.mapcore;

public class LinkInfo
{
  private int length = 0;
  private int state = 0;
  private int time = 0;
  
  public int getLength()
  {
    return this.length;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public void setLength(int paramInt)
  {
    this.length = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("状态：");
    localStringBuilder.append(this.state);
    localStringBuilder.append("|");
    localStringBuilder.append("时间：");
    localStringBuilder.append(this.time);
    localStringBuilder.append("|");
    localStringBuilder.append("长度：");
    localStringBuilder.append(this.length);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\LinkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */