package com.bumptech.glide.h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class c
  extends InputStream
{
  private static final Queue<c> a = h.a(0);
  private InputStream b;
  private IOException c;
  
  public static c a(InputStream paramInputStream)
  {
    synchronized (a)
    {
      c localc = (c)a.poll();
      ??? = localc;
      if (localc == null) {
        ??? = new c();
      }
      ((c)???).b(paramInputStream);
      return (c)???;
    }
  }
  
  public IOException a()
  {
    return this.c;
  }
  
  public int available()
    throws IOException
  {
    return this.b.available();
  }
  
  public void b()
  {
    this.c = null;
    this.b = null;
    synchronized (a)
    {
      a.offer(this);
      return;
    }
  }
  
  void b(InputStream paramInputStream)
  {
    this.b = paramInputStream;
  }
  
  public void close()
    throws IOException
  {
    this.b.close();
  }
  
  public void mark(int paramInt)
  {
    this.b.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.b.markSupported();
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = this.b.read();
      return i;
    }
    catch (IOException localIOException)
    {
      this.c = localIOException;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      int i = this.b.read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
    }
    return -1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.b.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      paramLong = this.b.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      this.c = localIOException;
    }
    return 0L;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */