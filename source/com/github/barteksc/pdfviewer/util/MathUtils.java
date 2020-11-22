package com.github.barteksc.pdfviewer.util;

public class MathUtils
{
  private static final double BIG_ENOUGH_CEIL = 16384.999999999996D;
  private static final double BIG_ENOUGH_FLOOR = 16384.0D;
  private static final int BIG_ENOUGH_INT = 16384;
  
  public static int ceil(float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (int)(d + 16384.999999999996D) - 16384;
  }
  
  public static int floor(float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (int)(d + 16384.0D) - 16384;
  }
  
  public static float limit(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 >= paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static int limit(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2) {
      return paramInt2;
    }
    if (paramInt1 >= paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static float max(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static int max(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static float min(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static int min(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\util\MathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */