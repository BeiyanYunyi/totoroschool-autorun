package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class n
  extends FilterInputStream
{
  private volatile byte[] a;
  private int b;
  private int c;
  private int d = -1;
  private int e;
  
  public n(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      this.a = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("buffer is null or empty");
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((this.d != -1) && (this.e - this.d < this.c))
    {
      Object localObject;
      if ((this.d == 0) && (this.c > paramArrayOfByte.length) && (this.b == paramArrayOfByte.length))
      {
        j = paramArrayOfByte.length * 2;
        i = j;
        if (j > this.c) {
          i = this.c;
        }
        if (Log.isLoggable("BufferedIs", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("allocate buffer of length: ");
          ((StringBuilder)localObject).append(i);
          Log.d("BufferedIs", ((StringBuilder)localObject).toString());
        }
        localObject = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
        this.a = ((byte[])localObject);
      }
      else
      {
        localObject = paramArrayOfByte;
        if (this.d > 0)
        {
          System.arraycopy(paramArrayOfByte, this.d, paramArrayOfByte, 0, paramArrayOfByte.length - this.d);
          localObject = paramArrayOfByte;
        }
      }
      this.e -= this.d;
      this.d = 0;
      this.b = 0;
      int j = paramInputStream.read((byte[])localObject, this.e, localObject.length - this.e);
      if (j <= 0) {
        i = this.e;
      } else {
        i = this.e + j;
      }
      this.b = i;
      return j;
    }
    int i = paramInputStream.read(paramArrayOfByte);
    if (i > 0)
    {
      this.d = -1;
      this.e = 0;
      this.b = i;
    }
    return i;
  }
  
  private static IOException b()
    throws IOException
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public void a()
  {
    try
    {
      this.c = this.a.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int available()
    throws IOException
  {
    try
    {
      InputStream localInputStream = this.in;
      if ((this.a != null) && (localInputStream != null))
      {
        int i = this.b;
        int j = this.e;
        int k = localInputStream.available();
        return i - j + k;
      }
      throw b();
    }
    finally {}
  }
  
  public void close()
    throws IOException
  {
    this.a = null;
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.c = Math.max(this.c, paramInt);
      this.d = this.e;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.a;
      Object localObject1 = this.in;
      if ((arrayOfByte != null) && (localObject1 != null))
      {
        int i;
        if (this.e >= this.b)
        {
          i = a((InputStream)localObject1, arrayOfByte);
          if (i == -1) {
            return -1;
          }
        }
        localObject1 = arrayOfByte;
        if (arrayOfByte != this.a)
        {
          localObject1 = this.a;
          if (localObject1 == null) {
            throw b();
          }
        }
        if (this.b - this.e > 0)
        {
          i = this.e;
          this.e = (i + 1);
          i = localObject1[i];
          return i & 0xFF;
        }
        return -1;
      }
      throw b();
    }
    finally {}
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        if (paramInt2 == 0) {
          return 0;
        }
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          int i;
          int j;
          if (this.e < this.b)
          {
            if (this.b - this.e >= paramInt2) {
              i = paramInt2;
            } else {
              i = this.b - this.e;
            }
            System.arraycopy(localObject1, this.e, paramArrayOfByte, paramInt1, i);
            this.e += i;
            if (i != paramInt2)
            {
              j = localInputStream.available();
              if (j != 0)
              {
                j = paramInt1 + i;
                paramInt1 = paramInt2 - i;
                i = j;
                break label150;
              }
            }
            return i;
          }
          else
          {
            j = paramInt2;
            i = paramInt1;
            paramInt1 = j;
          }
          for (;;)
          {
            label150:
            int k = this.d;
            j = -1;
            if ((k == -1) && (paramInt1 >= localObject1.length))
            {
              int m = localInputStream.read(paramArrayOfByte, i, paramInt1);
              k = m;
              if (m == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
            }
            else
            {
              k = a(localInputStream, (byte[])localObject1);
              if (k == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
              Object localObject2 = localObject1;
              if (localObject1 != this.a)
              {
                localObject2 = this.a;
                if (localObject2 == null) {
                  throw b();
                }
              }
              if (this.b - this.e >= paramInt1) {
                j = paramInt1;
              } else {
                j = this.b - this.e;
              }
              System.arraycopy(localObject2, this.e, paramArrayOfByte, i, j);
              this.e += j;
              k = j;
              localObject1 = localObject2;
            }
            paramInt1 -= k;
            if (paramInt1 == 0) {
              return paramInt2;
            }
            j = localInputStream.available();
            if (j == 0) {
              return paramInt2 - paramInt1;
            }
            i += k;
          }
        }
        throw b();
      }
      throw b();
    }
    finally {}
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (this.a != null)
      {
        if (-1 != this.d)
        {
          this.e = this.d;
          return;
        }
        throw new a("Mark has been invalidated");
      }
      throw new IOException("Stream is closed");
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.a;
      InputStream localInputStream = this.in;
      if (arrayOfByte != null)
      {
        if (paramLong < 1L) {
          return 0L;
        }
        if (localInputStream != null)
        {
          if (this.b - this.e >= paramLong)
          {
            this.e = ((int)(this.e + paramLong));
            return paramLong;
          }
          long l1 = this.b - this.e;
          this.e = this.b;
          if ((this.d != -1) && (paramLong <= this.c))
          {
            int i = a(localInputStream, arrayOfByte);
            if (i == -1) {
              return l1;
            }
            long l2 = this.b - this.e;
            long l3 = paramLong - l1;
            if (l2 >= l3)
            {
              this.e = ((int)(this.e + l3));
              return paramLong;
            }
            paramLong = this.b;
            l2 = this.e;
            this.e = this.b;
            return l1 + paramLong - l2;
          }
          paramLong = localInputStream.skip(paramLong - l1);
          return l1 + paramLong;
        }
        throw b();
      }
      throw b();
    }
    finally {}
  }
  
  public static class a
    extends RuntimeException
  {
    private static final long serialVersionUID = -4338378848813561757L;
    
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */