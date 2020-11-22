package com.bumptech.glide.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class f
  extends FilterInputStream
{
  private int a = Integer.MIN_VALUE;
  
  public f(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long a(long paramLong)
  {
    if (this.a == 0) {
      return -1L;
    }
    if ((this.a != Integer.MIN_VALUE) && (paramLong > this.a)) {
      return this.a;
    }
    return paramLong;
  }
  
  private void b(long paramLong)
  {
    if ((this.a != Integer.MIN_VALUE) && (paramLong != -1L)) {
      this.a = ((int)(this.a - paramLong));
    }
  }
  
  public int available()
    throws IOException
  {
    if (this.a == Integer.MIN_VALUE) {
      return super.available();
    }
    return Math.min(this.a, super.available());
  }
  
  public void mark(int paramInt)
  {
    super.mark(paramInt);
    this.a = paramInt;
  }
  
  public int read()
    throws IOException
  {
    if (a(1L) == -1L) {
      return -1;
    }
    int i = super.read();
    b(1L);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    b(paramInt1);
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    super.reset();
    this.a = Integer.MIN_VALUE;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = a(paramLong);
    if (paramLong == -1L) {
      return -1L;
    }
    paramLong = super.skip(paramLong);
    b(paramLong);
    return paramLong;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */