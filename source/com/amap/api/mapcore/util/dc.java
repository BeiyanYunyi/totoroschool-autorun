package com.amap.api.mapcore.util;

public class dc
{
  private final dt a = new dt();
  private short[] b;
  private double[] c;
  private int d;
  private final di e = new di();
  private final dt f = new dt();
  
  private static int a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (int)Math.signum(paramDouble1 * (paramDouble6 - paramDouble4) + paramDouble3 * (paramDouble2 - paramDouble6) + paramDouble5 * (paramDouble4 - paramDouble2));
  }
  
  private int a(int paramInt)
  {
    Object localObject = this.b;
    int i = localObject[d(paramInt)] * 2;
    int j = localObject[paramInt] * 2;
    paramInt = localObject[e(paramInt)] * 2;
    localObject = this.c;
    return a(localObject[i], localObject[(i + 1)], localObject[j], localObject[(j + 1)], localObject[paramInt], localObject[(paramInt + 1)]);
  }
  
  private void a()
  {
    Object localObject = this.e.a;
    while (this.d > 3)
    {
      int j = b();
      c(j);
      int k = d(j);
      int i = j;
      if (j == this.d) {
        i = 0;
      }
      localObject[k] = a(k);
      localObject[i] = a(i);
    }
    if (this.d == 3)
    {
      localObject = this.f;
      short[] arrayOfShort = this.b;
      ((dt)localObject).a(arrayOfShort[0]);
      ((dt)localObject).a(arrayOfShort[1]);
      ((dt)localObject).a(arrayOfShort[2]);
    }
  }
  
  private int b()
  {
    int j = this.d;
    int i = 0;
    while (i < j)
    {
      if (b(i)) {
        return i;
      }
      i += 1;
    }
    int[] arrayOfInt = this.e.a;
    i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] != -1) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private boolean b(int paramInt)
  {
    int[] arrayOfInt = this.e.a;
    if (arrayOfInt[paramInt] == -1) {
      return false;
    }
    int i = d(paramInt);
    int j = e(paramInt);
    short[] arrayOfShort = this.b;
    int k = arrayOfShort[i] * 2;
    paramInt = arrayOfShort[paramInt] * 2;
    int m = arrayOfShort[j] * 2;
    double[] arrayOfDouble = this.c;
    double d1 = arrayOfDouble[k];
    double d2 = arrayOfDouble[(k + 1)];
    double d3 = arrayOfDouble[paramInt];
    double d4 = arrayOfDouble[(paramInt + 1)];
    double d5 = arrayOfDouble[m];
    double d6 = arrayOfDouble[(m + 1)];
    for (paramInt = e(j); paramInt != i; paramInt = e(paramInt)) {
      if (arrayOfInt[paramInt] != 1)
      {
        j = arrayOfShort[paramInt] * 2;
        double d7 = arrayOfDouble[j];
        double d8 = arrayOfDouble[(j + 1)];
        if ((a(d5, d6, d1, d2, d7, d8) >= 0) && (a(d1, d2, d3, d4, d7, d8) >= 0) && (a(d3, d4, d5, d6, d7, d8) >= 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    short[] arrayOfShort = this.b;
    dt localdt = this.f;
    localdt.a(arrayOfShort[d(paramInt)]);
    localdt.a(arrayOfShort[paramInt]);
    localdt.a(arrayOfShort[e(paramInt)]);
    this.a.b(paramInt);
    this.e.b(paramInt);
    this.d -= 1;
  }
  
  private int d(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.d;
    }
    return i - 1;
  }
  
  private int e(int paramInt)
  {
    return (paramInt + 1) % this.d;
  }
  
  public dt a(double[] paramArrayOfDouble)
  {
    return a(paramArrayOfDouble, 0, paramArrayOfDouble.length);
  }
  
  public dt a(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    this.c = paramArrayOfDouble;
    paramInt2 /= 2;
    this.d = paramInt2;
    int i = paramInt1 / 2;
    paramArrayOfDouble = this.a;
    paramArrayOfDouble.a();
    paramArrayOfDouble.c(paramInt2);
    paramArrayOfDouble.b = paramInt2;
    paramArrayOfDouble = paramArrayOfDouble.a;
    this.b = paramArrayOfDouble;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayOfDouble[paramInt1] = ((short)(i + (paramInt2 - 1) - paramInt1));
      paramInt1 += 1;
    }
    paramArrayOfDouble = this.e;
    paramArrayOfDouble.a();
    paramArrayOfDouble.c(paramInt2);
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayOfDouble.a(a(paramInt1));
      paramInt1 += 1;
    }
    paramArrayOfDouble = this.f;
    paramArrayOfDouble.a();
    paramArrayOfDouble.c(Math.max(0, paramInt2 - 2) * 3);
    a();
    return paramArrayOfDouble;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */