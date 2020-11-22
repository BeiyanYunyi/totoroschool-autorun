package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray
  implements Cloneable
{
  private int[] bits;
  private int size;
  
  public BitArray()
  {
    this.size = 0;
    this.bits = new int[1];
  }
  
  public BitArray(int paramInt)
  {
    this.size = paramInt;
    this.bits = makeArray(paramInt);
  }
  
  BitArray(int[] paramArrayOfInt, int paramInt)
  {
    this.bits = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.bits.length * 32)
    {
      int[] arrayOfInt = makeArray(paramInt);
      System.arraycopy(this.bits, 0, arrayOfInt, 0, this.bits.length);
      this.bits = arrayOfInt;
    }
  }
  
  private static int[] makeArray(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }
  
  public void appendBit(boolean paramBoolean)
  {
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.bits;
      int i = this.size / 32;
      arrayOfInt[i] |= 1 << (this.size & 0x1F);
    }
    this.size += 1;
  }
  
  public void appendBitArray(BitArray paramBitArray)
  {
    int j = paramBitArray.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      appendBit(paramBitArray.get(i));
      i += 1;
    }
  }
  
  public void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      ensureCapacity(this.size + paramInt2);
      while (paramInt2 > 0)
      {
        boolean bool = true;
        if ((paramInt1 >> paramInt2 - 1 & 0x1) != 1) {
          bool = false;
        }
        appendBit(bool);
        paramInt2 -= 1;
      }
      return;
    }
    throw new IllegalArgumentException("Num bits must be between 0 and 32");
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
  
  public BitArray clone()
  {
    return new BitArray((int[])this.bits.clone(), this.size);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BitArray;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BitArray)paramObject;
    bool1 = bool2;
    if (this.size == ((BitArray)paramObject).size)
    {
      bool1 = bool2;
      if (Arrays.equals(this.bits, ((BitArray)paramObject).bits)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void flip(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = (1 << (paramInt & 0x1F) ^ arrayOfInt[i]);
  }
  
  public boolean get(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.bits[(paramInt / 32)]) != 0;
  }
  
  public int[] getBitArray()
  {
    return this.bits;
  }
  
  public int getNextSet(int paramInt)
  {
    if (paramInt >= this.size) {
      return this.size;
    }
    int j = paramInt / 32;
    int i = ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF) & this.bits[j];
    paramInt = j;
    while (i == 0)
    {
      paramInt += 1;
      if (paramInt == this.bits.length) {
        return this.size;
      }
      i = this.bits[paramInt];
    }
    i = paramInt * 32 + Integer.numberOfTrailingZeros(i);
    paramInt = i;
    if (i > this.size) {
      paramInt = this.size;
    }
    return paramInt;
  }
  
  public int getNextUnset(int paramInt)
  {
    if (paramInt >= this.size) {
      return this.size;
    }
    int j = paramInt / 32;
    int i = ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF) & (this.bits[j] ^ 0xFFFFFFFF);
    paramInt = j;
    while (i == 0)
    {
      paramInt += 1;
      if (paramInt == this.bits.length) {
        return this.size;
      }
      i = this.bits[paramInt] ^ 0xFFFFFFFF;
    }
    i = paramInt * 32 + Integer.numberOfTrailingZeros(i);
    paramInt = i;
    if (i > this.size) {
      paramInt = this.size;
    }
    return paramInt;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getSizeInBytes()
  {
    return (this.size + 7) / 8;
  }
  
  public int hashCode()
  {
    return this.size * 31 + Arrays.hashCode(this.bits);
  }
  
  public boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 == paramInt1) {
        return true;
      }
      int i1 = paramInt2 - 1;
      int n = paramInt1 / 32;
      int i2 = i1 / 32;
      int j = n;
      while (j <= i2)
      {
        if (j > n) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1 & 0x1F;
        }
        if (j < i2) {
          k = 31;
        } else {
          k = i1 & 0x1F;
        }
        int i;
        if ((paramInt2 == 0) && (k == 31))
        {
          paramInt2 = -1;
        }
        else
        {
          i = 0;
          int m = paramInt2;
          for (;;)
          {
            paramInt2 = i;
            if (m > k) {
              break;
            }
            i |= 1 << m;
            m += 1;
          }
        }
        int k = this.bits[j];
        if (paramBoolean) {
          i = paramInt2;
        } else {
          i = 0;
        }
        if ((k & paramInt2) != i) {
          return false;
        }
        j += 1;
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
  
  public void reverse()
  {
    int[] arrayOfInt = new int[this.bits.length];
    int j = (this.size - 1) / 32;
    int m = j + 1;
    int i = 0;
    while (i < m)
    {
      long l = this.bits[i];
      l = (l & 0x55555555) << 1 | l >> 1 & 0x55555555;
      l = (l & 0x33333333) << 2 | l >> 2 & 0x33333333;
      l = (l & 0xF0F0F0F) << 4 | l >> 4 & 0xF0F0F0F;
      l = (l & 0xFF00FF) << 8 | l >> 8 & 0xFF00FF;
      arrayOfInt[(j - i)] = ((int)((l & 0xFFFF) << 16 | l >> 16 & 0xFFFF));
      i += 1;
    }
    i = this.size;
    j = m * 32;
    if (i != j)
    {
      int n = j - this.size;
      j = 0;
      i = 1;
      while (j < 31 - n)
      {
        i = i << 1 | 0x1;
        j += 1;
      }
      int k = arrayOfInt[0] >> n & i;
      j = 1;
      while (j < m)
      {
        int i1 = arrayOfInt[j];
        arrayOfInt[(j - 1)] = (k | i1 << 32 - n);
        k = i1 >> n & i;
        j += 1;
      }
      arrayOfInt[(m - 1)] = k;
    }
    this.bits = arrayOfInt;
  }
  
  public void set(int paramInt)
  {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = (1 << (paramInt & 0x1F) | arrayOfInt[i]);
  }
  
  public void setBulk(int paramInt1, int paramInt2)
  {
    this.bits[(paramInt1 / 32)] = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 == paramInt1) {
        return;
      }
      int i2 = paramInt2 - 1;
      int n = paramInt1 / 32;
      int i3 = i2 / 32;
      int j = n;
      while (j <= i3)
      {
        int i1 = 0;
        if (j > n) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1 & 0x1F;
        }
        int k;
        if (j < i3) {
          k = 31;
        } else {
          k = i2 & 0x1F;
        }
        int i = i1;
        int m = paramInt2;
        if (paramInt2 == 0)
        {
          i = i1;
          m = paramInt2;
          if (k == 31)
          {
            paramInt2 = -1;
            break label134;
          }
        }
        for (;;)
        {
          paramInt2 = i;
          if (m > k) {
            break;
          }
          i |= 1 << m;
          m += 1;
        }
        label134:
        int[] arrayOfInt = this.bits;
        arrayOfInt[j] = (paramInt2 | arrayOfInt[j]);
        j += 1;
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (get(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.size);
    int i = 0;
    while (i < this.size)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      char c;
      if (get(i)) {
        c = 'X';
      } else {
        c = '.';
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void xor(BitArray paramBitArray)
  {
    if (this.bits.length == paramBitArray.bits.length)
    {
      int i = 0;
      while (i < this.bits.length)
      {
        int[] arrayOfInt = this.bits;
        arrayOfInt[i] ^= paramBitArray.bits[i];
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("Sizes don't match");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\BitArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */