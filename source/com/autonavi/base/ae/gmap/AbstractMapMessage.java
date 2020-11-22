package com.autonavi.base.ae.gmap;

public abstract class AbstractMapMessage
{
  public static final int GESTURE_STATE_BEGIN = 100;
  public static final int GESTURE_STATE_CHANGE = 101;
  public static final int GESTURE_STATE_END = 102;
  public static final int MSGTYPE_NAVIOVERLAY_STATE = 13;
  
  public abstract int getType();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\AbstractMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */