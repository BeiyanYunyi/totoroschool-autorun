package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class hu
  implements Closeable
{
  private final InputStream a;
  private final Charset b;
  private byte[] c;
  private int d;
  private int e;
  
  public hu(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramInt >= 0)
      {
        if (paramCharset.equals(hv.a))
        {
          this.a = paramInputStream;
          this.b = paramCharset;
          this.c = new byte[paramInt];
          return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
      }
      throw new IllegalArgumentException("capacity <= 0");
    }
    throw new NullPointerException();
  }
  
  public hu(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void b()
    throws IOException
  {
    int i = this.a.read(this.c, 0, this.c.length);
    if (i != -1)
    {
      this.d = 0;
      this.e = i;
      return;
    }
    throw new EOFException();
  }
  
  public String a()
    throws IOException
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        if (this.c != null)
        {
          if (this.d >= this.e) {
            b();
          }
          i = this.d;
          Object localObject1;
          if (i != this.e)
          {
            if (this.c[i] != 10) {
              break label270;
            }
            if (i != this.d)
            {
              localObject1 = this.c;
              j = i - 1;
              if (localObject1[j] == 13)
              {
                localObject1 = new String(this.c, this.d, j - this.d, this.b.name());
                this.d = (i + 1);
                return (String)localObject1;
              }
            }
          }
          else
          {
            localObject1 = new ByteArrayOutputStream(this.e - this.d + 80)
            {
              public String toString()
              {
                int i;
                if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {
                  i = this.count - 1;
                } else {
                  i = this.count;
                }
                try
                {
                  String str = new String(this.buf, 0, i, hu.a(hu.this).name());
                  return str;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  throw new AssertionError(localUnsupportedEncodingException);
                }
              }
            };
            ((ByteArrayOutputStream)localObject1).write(this.c, this.d, this.e - this.d);
            this.e = -1;
            b();
            i = this.d;
            if (i == this.e) {
              continue;
            }
            if (this.c[i] != 10) {
              break label277;
            }
            if (i != this.d) {
              ((ByteArrayOutputStream)localObject1).write(this.c, this.d, i - this.d);
            }
            this.d = (i + 1);
            localObject1 = ((ByteArrayOutputStream)localObject1).toString();
            return (String)localObject1;
          }
        }
        else
        {
          throw new IOException("LineReader is closed");
        }
      }
      int j = i;
      continue;
      label270:
      i += 1;
      continue;
      label277:
      i += 1;
    }
  }
  
  public void close()
    throws IOException
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        this.c = null;
        this.a.close();
      }
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */