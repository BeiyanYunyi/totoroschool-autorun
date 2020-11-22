package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint
{
  private final float x;
  private final float y;
  
  public ResultPoint(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  private static float crossProductZ(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    float f1 = paramResultPoint2.x;
    float f2 = paramResultPoint2.y;
    return (paramResultPoint3.x - f1) * (paramResultPoint1.y - f2) - (paramResultPoint3.y - f2) * (paramResultPoint1.x - f1);
  }
  
  public static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.distance(paramResultPoint1.x, paramResultPoint1.y, paramResultPoint2.x, paramResultPoint2.y);
  }
  
  public static void orderBestPatterns(ResultPoint[] paramArrayOfResultPoint)
  {
    float f1 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = distance(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    ResultPoint localResultPoint3;
    ResultPoint localResultPoint1;
    ResultPoint localResultPoint2;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localResultPoint3 = paramArrayOfResultPoint[0];
      localResultPoint1 = paramArrayOfResultPoint[1];
      localResultPoint2 = paramArrayOfResultPoint[2];
    }
    else if ((f3 >= f2) && (f3 >= f1))
    {
      localResultPoint3 = paramArrayOfResultPoint[1];
      localResultPoint1 = paramArrayOfResultPoint[0];
      localResultPoint2 = paramArrayOfResultPoint[2];
    }
    else
    {
      localResultPoint3 = paramArrayOfResultPoint[2];
      localResultPoint1 = paramArrayOfResultPoint[0];
      localResultPoint2 = paramArrayOfResultPoint[1];
    }
    ResultPoint localResultPoint5 = localResultPoint1;
    ResultPoint localResultPoint4 = localResultPoint2;
    if (crossProductZ(localResultPoint1, localResultPoint3, localResultPoint2) < 0.0F)
    {
      localResultPoint4 = localResultPoint1;
      localResultPoint5 = localResultPoint2;
    }
    paramArrayOfResultPoint[0] = localResultPoint5;
    paramArrayOfResultPoint[1] = localResultPoint3;
    paramArrayOfResultPoint[2] = localResultPoint4;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ResultPoint;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (ResultPoint)paramObject;
      bool1 = bool2;
      if (this.x == ((ResultPoint)paramObject).x)
      {
        bool1 = bool2;
        if (this.y == ((ResultPoint)paramObject).y) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public final float getX()
  {
    return this.x;
  }
  
  public final float getY()
  {
    return this.y;
  }
  
  public final int hashCode()
  {
    return Float.floatToIntBits(this.x) * 31 + Float.floatToIntBits(this.y);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(25);
    localStringBuilder.append('(');
    localStringBuilder.append(this.x);
    localStringBuilder.append(',');
    localStringBuilder.append(this.y);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\ResultPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */