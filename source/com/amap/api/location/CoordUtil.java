package com.amap.api.location;

public class CoordUtil
{
  private static boolean a = false;
  
  public static native int convertToGcj(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static boolean isLoadedSo()
  {
    return a;
  }
  
  public static void setLoadedSo(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\CoordUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */