package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer
  extends GlobalHistogramBinarizer
{
  private static final int BLOCK_SIZE = 8;
  private static final int BLOCK_SIZE_MASK = 7;
  private static final int BLOCK_SIZE_POWER = 3;
  private static final int MINIMUM_DIMENSION = 40;
  private static final int MIN_DYNAMIC_RANGE = 24;
  private BitMatrix matrix;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int[][] calculateBlackPoints(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt2, paramInt1 });
    int i1 = 0;
    while (i1 < paramInt2)
    {
      int i = i1 << 3;
      int j = paramInt4 - 8;
      int i2 = i;
      if (i > j) {
        i2 = j;
      }
      int i3 = 0;
      while (i3 < paramInt1)
      {
        j = i3 << 3;
        int k = paramInt3 - 8;
        i = j;
        if (j > k) {
          i = k;
        }
        j = i2 * paramInt3 + i;
        i = 0;
        int m = 0;
        k = 0;
        int i4 = 255;
        while (i < 8)
        {
          int i5 = k;
          k = m;
          int n = 0;
          m = i5;
          int i7;
          while (n < 8)
          {
            i6 = paramArrayOfByte[(j + n)] & 0xFF;
            i7 = k + i6;
            i5 = i4;
            if (i6 < i4) {
              i5 = i6;
            }
            k = m;
            if (i6 > m) {
              k = i6;
            }
            n += 1;
            m = k;
            k = i7;
            i4 = i5;
          }
          int i6 = i;
          n = k;
          i5 = j;
          if (m - i4 > 24)
          {
            n = j;
            i7 = i;
            i = i7 + 1;
            j = n + paramInt3;
            i6 = i;
            n = k;
            i5 = j;
            if (i < 8)
            {
              i5 = 0;
              i6 = k;
              for (;;)
              {
                i7 = i;
                k = i6;
                n = j;
                if (i5 >= 8) {
                  break;
                }
                i6 += (paramArrayOfByte[(j + i5)] & 0xFF);
                i5 += 1;
              }
            }
          }
          i = i6 + 1;
          j = i5 + paramInt3;
          k = m;
          m = n;
        }
        i = m >> 6;
        if (k - i4 <= 24)
        {
          j = i4 / 2;
          i = j;
          if (i1 > 0)
          {
            i = j;
            if (i3 > 0)
            {
              i = i1 - 1;
              k = arrayOfInt[i][i3];
              int[] arrayOfInt1 = arrayOfInt[i1];
              m = i3 - 1;
              k = (k + arrayOfInt1[m] * 2 + arrayOfInt[i][m]) / 4;
              i = j;
              if (i4 < k) {
                i = k;
              }
            }
          }
        }
        arrayOfInt[i1][i3] = i;
        i3 += 1;
      }
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private static void calculateThresholdForBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int k = i << 3;
      int m = paramInt4 - 8;
      int j = k;
      if (k > m) {
        j = m;
      }
      k = 0;
      while (k < paramInt1)
      {
        m = k << 3;
        int n = paramInt3 - 8;
        if (m > n) {
          m = n;
        }
        int i2 = cap(k, 2, paramInt1 - 3);
        int i3 = cap(i, 2, paramInt2 - 3);
        n = -2;
        int i1 = 0;
        while (n <= 2)
        {
          int[] arrayOfInt = paramArrayOfInt[(i3 + n)];
          i1 += arrayOfInt[(i2 - 2)] + arrayOfInt[(i2 - 1)] + arrayOfInt[i2] + arrayOfInt[(i2 + 1)] + arrayOfInt[(i2 + 2)];
          n += 1;
        }
        thresholdBlock(paramArrayOfByte, m, j, i1 / 25, paramInt3, paramBitMatrix);
        k += 1;
      }
      i += 1;
    }
  }
  
  private static int cap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > paramInt3) {
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  private static void thresholdBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int i = paramInt2 * paramInt4 + paramInt1;
    int j = 0;
    while (j < 8)
    {
      int k = 0;
      while (k < 8)
      {
        if ((paramArrayOfByte[(i + k)] & 0xFF) <= paramInt3) {
          paramBitMatrix.set(paramInt1 + k, paramInt2 + j);
        }
        k += 1;
      }
      j += 1;
      i += paramInt4;
    }
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix()
    throws NotFoundException
  {
    if (this.matrix != null) {
      return this.matrix;
    }
    Object localObject = getLuminanceSource();
    int m = ((LuminanceSource)localObject).getWidth();
    int n = ((LuminanceSource)localObject).getHeight();
    if ((m >= 40) && (n >= 40))
    {
      localObject = ((LuminanceSource)localObject).getMatrix();
      int j = m >> 3;
      int i = j;
      if ((m & 0x7) != 0) {
        i = j + 1;
      }
      int k = n >> 3;
      j = k;
      if ((n & 0x7) != 0) {
        j = k + 1;
      }
      int[][] arrayOfInt = calculateBlackPoints((byte[])localObject, i, j, m, n);
      BitMatrix localBitMatrix = new BitMatrix(m, n);
      calculateThresholdForBlock((byte[])localObject, i, j, m, n, arrayOfInt, localBitMatrix);
      this.matrix = localBitMatrix;
    }
    else
    {
      this.matrix = super.getBlackMatrix();
    }
    return this.matrix;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\HybridBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */