package com.google.zxing.common;

public final class BitSource
{
  private int bitOffset;
  private int byteOffset;
  private final byte[] bytes;
  
  public BitSource(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  public int available()
  {
    return (this.bytes.length - this.byteOffset) * 8 - this.bitOffset;
  }
  
  public int getBitOffset()
  {
    return this.bitOffset;
  }
  
  public int getByteOffset()
  {
    return this.byteOffset;
  }
  
  public int readBits(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 32) && (paramInt <= available()))
    {
      int i;
      if (this.bitOffset > 0)
      {
        j = 8 - this.bitOffset;
        if (paramInt < j) {
          i = paramInt;
        } else {
          i = j;
        }
        j -= i;
        j = (255 >> 8 - i << j & this.bytes[this.byteOffset]) >> j;
        int k = paramInt - i;
        this.bitOffset += i;
        paramInt = j;
        i = k;
        if (this.bitOffset == 8)
        {
          this.bitOffset = 0;
          this.byteOffset += 1;
          paramInt = j;
          i = k;
        }
      }
      else
      {
        j = 0;
        i = paramInt;
        paramInt = j;
      }
      int j = paramInt;
      if (i > 0)
      {
        while (i >= 8)
        {
          paramInt = paramInt << 8 | this.bytes[this.byteOffset] & 0xFF;
          this.byteOffset += 1;
          i -= 8;
        }
        j = paramInt;
        if (i > 0)
        {
          j = 8 - i;
          j = paramInt << i | (255 >> j << j & this.bytes[this.byteOffset]) >> j;
          this.bitOffset += i;
        }
      }
      return j;
    }
    throw new IllegalArgumentException(String.valueOf(paramInt));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\BitSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */