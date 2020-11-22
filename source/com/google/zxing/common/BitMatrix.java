package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix
  implements Cloneable
{
  private final int[] bits;
  private final int height;
  private final int rowSize;
  private final int width;
  
  public BitMatrix(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rowSize = ((paramInt1 + 31) / 32);
      this.bits = new int[this.rowSize * paramInt2];
      return;
    }
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  private BitMatrix(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowSize = paramInt3;
    this.bits = paramArrayOfInt;
  }
  
  public static BitMatrix parse(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      boolean[] arrayOfBoolean = new boolean[paramString1.length()];
      int i4 = 0;
      int k = 0;
      int j = 0;
      int n = 0;
      int i = -1;
      int m = 0;
      while (k < paramString1.length()) {
        if ((paramString1.charAt(k) != '\n') && (paramString1.charAt(k) != '\r'))
        {
          if (paramString1.substring(k, paramString2.length() + k).equals(paramString2))
          {
            k += paramString2.length();
            arrayOfBoolean[j] = true;
            j += 1;
          }
          else if (paramString1.substring(k, paramString3.length() + k).equals(paramString3))
          {
            k += paramString3.length();
            arrayOfBoolean[j] = false;
            j += 1;
          }
          else
          {
            paramString2 = new StringBuilder();
            paramString2.append("illegal character encountered: ");
            paramString2.append(paramString1.substring(k));
            throw new IllegalArgumentException(paramString2.toString());
          }
        }
        else
        {
          i1 = n;
          int i2 = i;
          int i3 = m;
          if (j > n)
          {
            if (i == -1) {
              i = j - n;
            } else {
              if (j - n != i) {
                break label246;
              }
            }
            i3 = m + 1;
            i1 = j;
            i2 = i;
            break label256;
            label246:
            throw new IllegalArgumentException("row lengths do not match");
          }
          label256:
          k += 1;
          n = i1;
          i = i2;
          m = i3;
        }
      }
      k = i;
      int i1 = m;
      if (j > n)
      {
        if (i == -1) {
          i = j - n;
        } else {
          if (j - n != i) {
            break label325;
          }
        }
        i1 = m + 1;
        k = i;
        break label335;
        label325:
        throw new IllegalArgumentException("row lengths do not match");
      }
      label335:
      paramString1 = new BitMatrix(k, i1);
      i = i4;
      while (i < j)
      {
        if (arrayOfBoolean[i] != 0) {
          paramString1.set(i % k, i / k);
        }
        i += 1;
      }
      return paramString1;
    }
    throw new IllegalArgumentException();
  }
  
  public void clear()
  {
    int j = this.bits.length;
    int i = 0;
    while (i < j)
    {
      this.bits[i] = 0;
      i += 1;
    }
  }
  
  public BitMatrix clone()
  {
    return new BitMatrix(this.width, this.height, this.rowSize, (int[])this.bits.clone());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BitMatrix;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BitMatrix)paramObject;
    bool1 = bool2;
    if (this.width == ((BitMatrix)paramObject).width)
    {
      bool1 = bool2;
      if (this.height == ((BitMatrix)paramObject).height)
      {
        bool1 = bool2;
        if (this.rowSize == ((BitMatrix)paramObject).rowSize)
        {
          bool1 = bool2;
          if (Arrays.equals(this.bits, ((BitMatrix)paramObject).bits)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void flip(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = (1 << (paramInt1 & 0x1F) ^ arrayOfInt[paramInt2]);
  }
  
  public boolean get(int paramInt1, int paramInt2)
  {
    int i = this.rowSize;
    int j = paramInt1 / 32;
    return (this.bits[(paramInt2 * i + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int[] getBottomRightOnBit()
  {
    int i = this.bits.length - 1;
    while ((i >= 0) && (this.bits[i] == 0)) {
      i -= 1;
    }
    if (i < 0) {
      return null;
    }
    int k = i / this.rowSize;
    int m = this.rowSize;
    int n = this.bits[i];
    int j = 31;
    while (n >>> j == 0) {
      j -= 1;
    }
    return new int[] { i % m * 32 + j, k };
  }
  
  public int[] getEnclosingRectangle()
  {
    int j = this.width;
    int i1 = this.height;
    int k = -1;
    int m = -1;
    int i = 0;
    while (i < this.height)
    {
      int n = m;
      m = k;
      int i2 = 0;
      int i4;
      for (k = n; i2 < this.rowSize; k = i4)
      {
        int i8 = this.bits[(this.rowSize * i + i2)];
        int i5 = j;
        int i6 = m;
        int i3 = i1;
        i4 = k;
        if (i8 != 0)
        {
          n = i1;
          if (i < i1) {
            n = i;
          }
          i1 = k;
          if (i > k) {
            i1 = i;
          }
          int i9 = i2 * 32;
          int i7 = 31;
          k = j;
          if (i9 < j)
          {
            k = 0;
            while (i8 << 31 - k == 0) {
              k += 1;
            }
            i3 = k + i9;
            k = j;
            if (i3 < j) {
              k = i3;
            }
          }
          i5 = k;
          i6 = m;
          i3 = n;
          i4 = i1;
          if (i9 + 31 > m)
          {
            j = i7;
            while (i8 >>> j == 0) {
              j -= 1;
            }
            j = i9 + j;
            i5 = k;
            i6 = m;
            i3 = n;
            i4 = i1;
            if (j > m)
            {
              i6 = j;
              i4 = i1;
              i3 = n;
              i5 = k;
            }
          }
        }
        i2 += 1;
        j = i5;
        m = i6;
        i1 = i3;
      }
      i += 1;
      n = k;
      k = m;
      m = n;
    }
    i = k - j;
    k = m - i1;
    if ((i >= 0) && (k >= 0)) {
      return new int[] { j, i1, i, k };
    }
    return null;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public BitArray getRow(int paramInt, BitArray paramBitArray)
  {
    if ((paramBitArray != null) && (paramBitArray.getSize() >= this.width)) {
      paramBitArray.clear();
    } else {
      paramBitArray = new BitArray(this.width);
    }
    int j = this.rowSize;
    int i = 0;
    while (i < this.rowSize)
    {
      paramBitArray.setBulk(i * 32, this.bits[(paramInt * j + i)]);
      i += 1;
    }
    return paramBitArray;
  }
  
  public int getRowSize()
  {
    return this.rowSize;
  }
  
  public int[] getTopLeftOnBit()
  {
    int i = 0;
    while ((i < this.bits.length) && (this.bits[i] == 0)) {
      i += 1;
    }
    if (i == this.bits.length) {
      return null;
    }
    int k = i / this.rowSize;
    int m = this.rowSize;
    int n = this.bits[i];
    int j = 0;
    while (n << 31 - j == 0) {
      j += 1;
    }
    return new int[] { i % m * 32 + j, k };
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return (((this.width * 31 + this.width) * 31 + this.height) * 31 + this.rowSize) * 31 + Arrays.hashCode(this.bits);
  }
  
  public void rotate180()
  {
    int i = getWidth();
    int j = getHeight();
    BitArray localBitArray2 = new BitArray(i);
    BitArray localBitArray1 = new BitArray(i);
    i = 0;
    while (i < (j + 1) / 2)
    {
      localBitArray2 = getRow(i, localBitArray2);
      int k = j - 1 - i;
      localBitArray1 = getRow(k, localBitArray1);
      localBitArray2.reverse();
      localBitArray1.reverse();
      setRow(i, localBitArray1);
      setRow(k, localBitArray2);
      i += 1;
    }
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = (1 << (paramInt1 & 0x1F) | arrayOfInt[paramInt2]);
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 >= 0) && (paramInt1 >= 0))
    {
      if ((paramInt4 >= 1) && (paramInt3 >= 1))
      {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if ((paramInt4 <= this.height) && (i <= this.width))
        {
          while (paramInt2 < paramInt4)
          {
            int j = this.rowSize;
            paramInt3 = paramInt1;
            while (paramInt3 < i)
            {
              int[] arrayOfInt = this.bits;
              int k = paramInt3 / 32 + j * paramInt2;
              arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
              paramInt3 += 1;
            }
            paramInt2 += 1;
          }
          return;
        }
        throw new IllegalArgumentException("The region must fit inside the matrix");
      }
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    throw new IllegalArgumentException("Left and top must be nonnegative");
  }
  
  public void setRow(int paramInt, BitArray paramBitArray)
  {
    System.arraycopy(paramBitArray.getBitArray(), 0, this.bits, paramInt * this.rowSize, this.rowSize);
  }
  
  public String toString()
  {
    return toString("X ", "  ");
  }
  
  public String toString(String paramString1, String paramString2)
  {
    return toString(paramString1, paramString2, "\n");
  }
  
  @Deprecated
  public String toString(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      while (j < this.width)
      {
        String str;
        if (get(j, i)) {
          str = paramString1;
        } else {
          str = paramString2;
        }
        localStringBuilder.append(str);
        j += 1;
      }
      localStringBuilder.append(paramString3);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void unset(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = ((1 << (paramInt1 & 0x1F) ^ 0xFFFFFFFF) & arrayOfInt[paramInt2]);
  }
  
  public void xor(BitMatrix paramBitMatrix)
  {
    if ((this.width == paramBitMatrix.getWidth()) && (this.height == paramBitMatrix.getHeight()) && (this.rowSize == paramBitMatrix.getRowSize()))
    {
      BitArray localBitArray = new BitArray(this.width / 32 + 1);
      int i = 0;
      while (i < this.height)
      {
        int k = this.rowSize;
        int[] arrayOfInt1 = paramBitMatrix.getRow(i, localBitArray).getBitArray();
        int j = 0;
        while (j < this.rowSize)
        {
          int[] arrayOfInt2 = this.bits;
          int m = k * i + j;
          arrayOfInt2[m] ^= arrayOfInt1[j];
          j += 1;
        }
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("input matrix dimensions do not match");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\BitMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */