package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class bg
  implements Closeable
{
  private final InputStream a;
  private final Charset b;
  private byte[] c;
  private int d;
  private int e;
  
  public bg(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, paramCharset, (byte)0);
  }
  
  private bg(InputStream paramInputStream, Charset paramCharset, byte paramByte)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramCharset.equals(bh.a))
      {
        this.a = paramInputStream;
        this.b = paramCharset;
        this.c = new byte[' '];
        return;
      }
      throw new IllegalArgumentException("Unsupported encoding");
    }
    throw new NullPointerException();
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
  
  public final String a()
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
              public final String toString()
              {
                int i;
                if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {
                  i = this.count - 1;
                } else {
                  i = this.count;
                }
                try
                {
                  String str = new String(this.buf, 0, i, bg.a(bg.this).name());
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
  
  public final void close()
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */