package com.totoro.school.zxing.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.zxing.LuminanceSource;

public final class e
  extends LuminanceSource
{
  private final byte[] a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  
  public e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt5, paramInt6);
    if ((paramInt5 + paramInt3 <= paramInt1) && (paramInt6 + paramInt4 <= paramInt2))
    {
      this.a = paramArrayOfByte;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      return;
    }
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  public Bitmap a()
  {
    int m = getWidth();
    int n = getHeight();
    int[] arrayOfInt = new int[m * n];
    Object localObject = this.a;
    int j = this.e * this.b + this.d;
    int i = 0;
    while (i < n)
    {
      int k = 0;
      while (k < m)
      {
        arrayOfInt[(i * m + k)] = ((localObject[(j + k)] & 0xFF) * 65793 | 0xFF000000);
        k += 1;
      }
      j += this.b;
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(arrayOfInt, 0, m, 0, 0, m, n);
    return (Bitmap)localObject;
  }
  
  public byte[] getMatrix()
  {
    int k = getWidth();
    int m = getHeight();
    if ((k == this.b) && (m == this.c)) {
      return this.a;
    }
    int n = k * m;
    byte[] arrayOfByte1 = new byte[n];
    int j = this.e * this.b + this.d;
    int i1 = this.b;
    int i = 0;
    if (k == i1)
    {
      System.arraycopy(this.a, j, arrayOfByte1, 0, n);
      return arrayOfByte1;
    }
    byte[] arrayOfByte2 = this.a;
    while (i < m)
    {
      System.arraycopy(arrayOfByte2, j, arrayOfByte1, i * k, k);
      j += this.b;
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
      int j = this.e;
      int k = this.b;
      int m = this.d;
      System.arraycopy(this.a, (paramInt + j) * k + m, arrayOfByte, 0, i);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */