package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

final class PDF417CodewordDecoder
{
  private static final float[][] RATIOS_TABLE = (float[][])Array.newInstance(Float.TYPE, new int[] { PDF417Common.SYMBOL_TABLE.length, 8 });
  
  static
  {
    int i = 0;
    while (i < PDF417Common.SYMBOL_TABLE.length)
    {
      int m = PDF417Common.SYMBOL_TABLE[i];
      int j = m & 0x1;
      int k = 0;
      while (k < 8)
      {
        float f = 0.0F;
        int n;
        for (;;)
        {
          n = m & 0x1;
          if (n != j) {
            break;
          }
          f += 1.0F;
          m >>= 1;
        }
        RATIOS_TABLE[i][(8 - k - 1)] = (f / 17.0F);
        k += 1;
        j = n;
      }
      i += 1;
    }
  }
  
  private static int getBitValue(int[] paramArrayOfInt)
  {
    long l = 0L;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = 0;
      while (j < paramArrayOfInt[i])
      {
        int k = 1;
        if (i % 2 != 0) {
          k = 0;
        }
        l = l << 1 | k;
        j += 1;
      }
      i += 1;
    }
    return (int)l;
  }
  
  private static int getClosestDecodedValue(int[] paramArrayOfInt)
  {
    int j = PDF417Common.getBitCountSum(paramArrayOfInt);
    float[] arrayOfFloat = new float[8];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = (paramArrayOfInt[i] / j);
      i += 1;
    }
    j = -1;
    i = 0;
    float f1;
    for (float f3 = Float.MAX_VALUE; i < RATIOS_TABLE.length; f3 = f1)
    {
      paramArrayOfInt = RATIOS_TABLE[i];
      int k = 0;
      f1 = 0.0F;
      float f2;
      for (;;)
      {
        f2 = f1;
        if (k >= 8) {
          break;
        }
        f2 = paramArrayOfInt[k] - arrayOfFloat[k];
        f1 += f2 * f2;
        if (f1 >= f3)
        {
          f2 = f1;
          break;
        }
        k += 1;
      }
      f1 = f3;
      if (f2 < f3)
      {
        j = PDF417Common.SYMBOL_TABLE[i];
        f1 = f2;
      }
      i += 1;
    }
    return j;
  }
  
  private static int getDecodedCodewordValue(int[] paramArrayOfInt)
  {
    int j = getBitValue(paramArrayOfInt);
    int i = j;
    if (PDF417Common.getCodeword(j) == -1) {
      i = -1;
    }
    return i;
  }
  
  static int getDecodedValue(int[] paramArrayOfInt)
  {
    int i = getDecodedCodewordValue(sampleBitCounts(paramArrayOfInt));
    if (i != -1) {
      return i;
    }
    return getClosestDecodedValue(paramArrayOfInt);
  }
  
  private static int[] sampleBitCounts(int[] paramArrayOfInt)
  {
    float f1 = PDF417Common.getBitCountSum(paramArrayOfInt);
    int[] arrayOfInt = new int[8];
    int j = 0;
    int m = 0;
    int k;
    for (int i = 0; j < 17; i = k)
    {
      float f2 = f1 / 34.0F;
      float f3 = j * f1 / 17.0F;
      int n = m;
      k = i;
      if (paramArrayOfInt[i] + m <= f2 + f3)
      {
        n = m + paramArrayOfInt[i];
        k = i + 1;
      }
      arrayOfInt[k] += 1;
      j += 1;
      m = n;
    }
    return arrayOfInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417CodewordDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */