package com.bumptech.glide.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends FilterInputStream
{
  private final long a;
  private int b;
  
  b(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.a = paramLong;
  }
  
  private int a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      this.b += paramInt;
      return paramInt;
    }
    if (this.a - this.b <= 0L) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to read all expected data, expected: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", but read: ");
    localStringBuilder.append(this.b);
    throw new IOException(localStringBuilder.toString());
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong)
  {
    return new b(paramInputStream, paramLong);
  }
  
  public int available()
    throws IOException
  {
    try
    {
      long l = Math.max(this.a - this.b, this.in.available());
      int i = (int)l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = a(super.read());
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = a(super.read(paramArrayOfByte, paramInt1, paramInt2));
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */