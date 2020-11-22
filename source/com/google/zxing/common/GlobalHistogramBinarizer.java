package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer
  extends Binarizer
{
  private static final byte[] EMPTY = new byte[0];
  private static final int LUMINANCE_BITS = 5;
  private static final int LUMINANCE_BUCKETS = 32;
  private static final int LUMINANCE_SHIFT = 3;
  private final int[] buckets = new int[32];
  private byte[] luminances = EMPTY;
  
  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int estimateBlackPoint(int[] paramArrayOfInt)
    throws NotFoundException
  {
    int i3 = paramArrayOfInt.length;
    int i2 = 0;
    int j = 0;
    int n = 0;
    int m = 0;
    int i = 0;
    int i1;
    while (j < i3)
    {
      k = n;
      if (paramArrayOfInt[j] > n)
      {
        k = paramArrayOfInt[j];
        i = j;
      }
      i1 = m;
      if (paramArrayOfInt[j] > m) {
        i1 = paramArrayOfInt[j];
      }
      j += 1;
      n = k;
      m = i1;
    }
    n = 0;
    j = 0;
    int k = i2;
    while (k < i3)
    {
      i1 = k - i;
      i2 = paramArrayOfInt[k] * i1 * i1;
      i1 = n;
      if (i2 > n)
      {
        j = k;
        i1 = i2;
      }
      k += 1;
      n = i1;
    }
    n = j;
    k = i;
    if (i > j)
    {
      k = j;
      n = i;
    }
    if (n - k > i3 / 16)
    {
      i = n - 1;
      j = -1;
      i1 = i;
      while (i > k)
      {
        i2 = i - k;
        i3 = i2 * i2 * (n - i) * (m - paramArrayOfInt[i]);
        i2 = j;
        if (i3 > j)
        {
          i1 = i;
          i2 = i3;
        }
        i -= 1;
        j = i2;
      }
      return i1 << 3;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void initArrays(int paramInt)
  {
    if (this.luminances.length < paramInt) {
      this.luminances = new byte[paramInt];
    }
    paramInt = 0;
    while (paramInt < 32)
    {
      this.buckets[paramInt] = 0;
      paramInt += 1;
    }
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new GlobalHistogramBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix()
    throws NotFoundException
  {
    Object localObject = getLuminanceSource();
    int k = ((LuminanceSource)localObject).getWidth();
    int m = ((LuminanceSource)localObject).getHeight();
    BitMatrix localBitMatrix = new BitMatrix(k, m);
    initArrays(k);
    int[] arrayOfInt = this.buckets;
    int i = 1;
    int j;
    while (i < 5)
    {
      byte[] arrayOfByte = ((LuminanceSource)localObject).getRow(m * i / 5, this.luminances);
      n = k * 4 / 5;
      j = k / 5;
      while (j < n)
      {
        int i1 = (arrayOfByte[j] & 0xFF) >> 3;
        arrayOfInt[i1] += 1;
        j += 1;
      }
      i += 1;
    }
    int n = estimateBlackPoint(arrayOfInt);
    localObject = ((LuminanceSource)localObject).getMatrix();
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        if ((localObject[(i * k + j)] & 0xFF) < n) {
          localBitMatrix.set(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return localBitMatrix;
  }
  
  public BitArray getBlackRow(int paramInt, BitArray paramBitArray)
    throws NotFoundException
  {
    Object localObject = getLuminanceSource();
    int n = ((LuminanceSource)localObject).getWidth();
    if ((paramBitArray != null) && (paramBitArray.getSize() >= n)) {
      paramBitArray.clear();
    } else {
      paramBitArray = new BitArray(n);
    }
    initArrays(n);
    localObject = ((LuminanceSource)localObject).getRow(paramInt, this.luminances);
    int[] arrayOfInt = this.buckets;
    paramInt = 0;
    while (paramInt < n)
    {
      i = (localObject[paramInt] & 0xFF) >> 3;
      arrayOfInt[i] += 1;
      paramInt += 1;
    }
    int i1 = estimateBlackPoint(arrayOfInt);
    int i = localObject[0];
    paramInt = localObject[1] & 0xFF;
    int j = i & 0xFF;
    i = 1;
    while (i < n - 1)
    {
      int m = i + 1;
      int k = localObject[m] & 0xFF;
      if ((paramInt * 4 - j - k) / 2 < i1) {
        paramBitArray.set(i);
      }
      j = paramInt;
      i = m;
      paramInt = k;
    }
    return paramBitArray;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\GlobalHistogramBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */