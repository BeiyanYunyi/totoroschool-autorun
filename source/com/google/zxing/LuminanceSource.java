package com.google.zxing;

public abstract class LuminanceSource
{
  private final int height;
  private final int width;
  
  protected LuminanceSource(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public abstract byte[] getMatrix();
  
  public abstract byte[] getRow(int paramInt, byte[] paramArrayOfByte);
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public LuminanceSource invert()
  {
    return new InvertedLuminanceSource(this);
  }
  
  public boolean isCropSupported()
  {
    return false;
  }
  
  public boolean isRotateSupported()
  {
    return false;
  }
  
  public LuminanceSource rotateCounterClockwise()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
  }
  
  public LuminanceSource rotateCounterClockwise45()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
  }
  
  public final String toString()
  {
    byte[] arrayOfByte = new byte[this.width];
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      arrayOfByte = getRow(i, arrayOfByte);
      int j = 0;
      while (j < this.width)
      {
        int k = arrayOfByte[j] & 0xFF;
        char c;
        if (k < 64) {
          c = '#';
        } else if (k < 128) {
          c = '+';
        } else if (k < 192) {
          c = '.';
        } else {
          c = ' ';
        }
        localStringBuilder.append(c);
        j += 1;
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\LuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */