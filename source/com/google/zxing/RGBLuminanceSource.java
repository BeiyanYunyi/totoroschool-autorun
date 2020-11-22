package com.google.zxing;

public final class RGBLuminanceSource
  extends LuminanceSource
{
  private final int dataHeight;
  private final int dataWidth;
  private final int left;
  private final byte[] luminances;
  private final int top;
  
  public RGBLuminanceSource(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super(paramInt1, paramInt2);
    this.dataWidth = paramInt1;
    this.dataHeight = paramInt2;
    this.left = 0;
    this.top = 0;
    this.luminances = new byte[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        int k = i * paramInt1 + j;
        int i1 = paramArrayOfInt[k];
        int m = i1 >> 16 & 0xFF;
        int n = i1 >> 8 & 0xFF;
        i1 &= 0xFF;
        if ((m == n) && (n == i1)) {
          this.luminances[k] = ((byte)m);
        } else {
          this.luminances[k] = ((byte)((m + n * 2 + i1) / 4));
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private RGBLuminanceSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt5, paramInt6);
    if ((paramInt5 + paramInt3 <= paramInt1) && (paramInt6 + paramInt4 <= paramInt2))
    {
      this.luminances = paramArrayOfByte;
      this.dataWidth = paramInt1;
      this.dataHeight = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      return;
    }
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + paramInt1, this.top + paramInt2, paramInt3, paramInt4);
  }
  
  public byte[] getMatrix()
  {
    int k = getWidth();
    int m = getHeight();
    if ((k == this.dataWidth) && (m == this.dataHeight)) {
      return this.luminances;
    }
    int n = k * m;
    byte[] arrayOfByte1 = new byte[n];
    int j = this.top * this.dataWidth + this.left;
    int i1 = this.dataWidth;
    int i = 0;
    if (k == i1)
    {
      System.arraycopy(this.luminances, j, arrayOfByte1, 0, n);
      return arrayOfByte1;
    }
    byte[] arrayOfByte2 = this.luminances;
    while (i < m)
    {
      System.arraycopy(arrayOfByte2, j, arrayOfByte1, i * k, k);
      j += this.dataWidth;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt >= 0) && (paramInt < getHeight()))
    {
      int i = getWidth();
      byte[] arrayOfByte;
      if (paramArrayOfByte != null)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte.length >= i) {}
      }
      else
      {
        arrayOfByte = new byte[i];
      }
      int j = this.top;
      int k = this.dataWidth;
      int m = this.left;
      System.arraycopy(this.luminances, (paramInt + j) * k + m, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Requested row is outside the image: ");
    paramArrayOfByte.append(paramInt);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public boolean isCropSupported()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\RGBLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */