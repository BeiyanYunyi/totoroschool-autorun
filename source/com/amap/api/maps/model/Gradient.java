package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient
{
  private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
  private boolean isAvailable = true;
  private int mColorMapSize;
  private int[] mColors;
  private float[] mStartPoints;
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this(paramArrayOfInt, paramArrayOfFloat, 1000);
  }
  
  private Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfFloat != null)) {}
    try
    {
      if (paramArrayOfInt.length == paramArrayOfFloat.length)
      {
        if (paramArrayOfInt.length != 0)
        {
          int i = 1;
          while (i < paramArrayOfFloat.length) {
            if (paramArrayOfFloat[i] >= paramArrayOfFloat[(i - 1)]) {
              i += 1;
            } else {
              throw new AMapException("startPoints should be in increasing order");
            }
          }
          this.mColorMapSize = paramInt;
          this.mColors = new int[paramArrayOfInt.length];
          this.mStartPoints = new float[paramArrayOfFloat.length];
          System.arraycopy(paramArrayOfInt, 0, this.mColors, 0, paramArrayOfInt.length);
          System.arraycopy(paramArrayOfFloat, 0, this.mStartPoints, 0, paramArrayOfFloat.length);
          this.isAvailable = true;
          return;
        }
        throw new AMapException("No colors have been defined");
      }
      throw new AMapException("colors and startPoints should be same length");
    }
    catch (AMapException paramArrayOfInt)
    {
      this.isAvailable = false;
      Log.e("amap", paramArrayOfInt.getErrorMessage());
      paramArrayOfInt.printStackTrace();
    }
    throw new AMapException("colors and startPoints should not be null");
  }
  
  static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = (int)((Color.alpha(paramInt2) - Color.alpha(paramInt1)) * paramFloat + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    paramInt1 = 0;
    float f1 = arrayOfFloat1[0];
    float f2 = arrayOfFloat2[0];
    float f3 = '´';
    if (f1 - f2 > f3) {
      arrayOfFloat2[0] += 'Ũ';
    } else if (arrayOfFloat2[0] - arrayOfFloat1[0] > f3) {
      arrayOfFloat1[0] += 'Ũ';
    }
    float[] arrayOfFloat3 = new float[3];
    while (paramInt1 < 3)
    {
      arrayOfFloat3[paramInt1] = ((arrayOfFloat2[paramInt1] - arrayOfFloat1[paramInt1]) * paramFloat + arrayOfFloat1[paramInt1]);
      paramInt1 += 1;
    }
    return Color.HSVToColor(i, arrayOfFloat3);
  }
  
  private HashMap<Integer, a> a()
  {
    HashMap localHashMap = new HashMap(32);
    if (this.mStartPoints[0] != 0.0F) {
      localHashMap.put(Integer.valueOf(0), new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], null));
    }
    int i = 1;
    while (i < this.mColors.length)
    {
      float f = this.mColorMapSize;
      float[] arrayOfFloat = this.mStartPoints;
      int j = i - 1;
      localHashMap.put(Integer.valueOf((int)(f * arrayOfFloat[j])), new a(this.mColors[j], this.mColors[i], this.mColorMapSize * (this.mStartPoints[i] - this.mStartPoints[j]), null));
      i += 1;
    }
    if (this.mStartPoints[(this.mStartPoints.length - 1)] != 1.0F)
    {
      i = this.mStartPoints.length - 1;
      localHashMap.put(Integer.valueOf((int)(this.mColorMapSize * this.mStartPoints[i])), new a(this.mColors[i], this.mColors[i], this.mColorMapSize * (1.0F - this.mStartPoints[i]), null));
    }
    return localHashMap;
  }
  
  protected int[] generateColorMap(double paramDouble)
  {
    HashMap localHashMap = a();
    int[] arrayOfInt = new int[this.mColorMapSize];
    int k = 0;
    a locala = (a)localHashMap.get(Integer.valueOf(0));
    int i = 0;
    int j = 0;
    while (i < this.mColorMapSize)
    {
      if (localHashMap.containsKey(Integer.valueOf(i)))
      {
        locala = (a)localHashMap.get(Integer.valueOf(i));
        j = i;
      }
      float f = (i - j) / a.a(locala);
      arrayOfInt[i] = a(a.b(locala), a.c(locala), f);
      i += 1;
    }
    if (paramDouble != 1.0D)
    {
      i = k;
      while (i < this.mColorMapSize)
      {
        j = arrayOfInt[i];
        double d = Color.alpha(j);
        Double.isNaN(d);
        arrayOfInt[i] = Color.argb((int)(d * paramDouble), Color.red(j), Color.green(j), Color.blue(j));
        i += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int[] getColors()
  {
    return this.mColors;
  }
  
  public float[] getStartPoints()
  {
    return this.mStartPoints;
  }
  
  protected boolean isAvailable()
  {
    return this.isAvailable;
  }
  
  private static class a
  {
    private final int a;
    private final int b;
    private final float c;
    
    private a(int paramInt1, int paramInt2, float paramFloat)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramFloat;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Gradient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */