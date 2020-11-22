package com.bumptech.glide.b;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class d
{
  private final byte[] a = new byte['Ā'];
  private ByteBuffer b;
  private c c;
  private int d = 0;
  
  private int[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.b.get(arrayOfByte);
      int[] arrayOfInt2 = new int['Ā'];
      int i = 0;
      int j = 0;
      int[] arrayOfInt1;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i >= paramInt) {
          break;
        }
        int k = j + 1;
        j = arrayOfByte[j];
        int m = k + 1;
        arrayOfInt2[i] = ((j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        j = m + 1;
        i += 1;
      }
      return arrayOfInt1;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      arrayOfInt1 = null;
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.c.b = 1;
    }
  }
  
  private void c()
  {
    this.b = null;
    Arrays.fill(this.a, (byte)0);
    this.c = new c();
    this.d = 0;
  }
  
  private void d()
  {
    int i = 0;
    while ((i == 0) && (!o()))
    {
      int j = m();
      if (j != 33)
      {
        if (j != 44)
        {
          if (j != 59) {
            this.c.b = 1;
          } else {
            i = 1;
          }
        }
        else
        {
          if (this.c.d == null) {
            this.c.d = new b();
          }
          f();
        }
      }
      else
      {
        j = m();
        if (j != 1)
        {
          if (j != 249)
          {
            switch (j)
            {
            default: 
              k();
              break;
            case 255: 
              l();
              String str = "";
              j = 0;
              while (j < 11)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str);
                localStringBuilder.append((char)this.a[j]);
                str = localStringBuilder.toString();
                j += 1;
              }
              if (str.equals("NETSCAPE2.0"))
              {
                g();
                continue;
              }
              k();
              break;
            case 254: 
              k();
              break;
            }
          }
          else
          {
            this.c.d = new b();
            e();
          }
        }
        else {
          k();
        }
      }
    }
  }
  
  private void e()
  {
    m();
    int i = m();
    this.c.d.g = ((i & 0x1C) >> 2);
    int j = this.c.d.g;
    boolean bool = true;
    if (j == 0) {
      this.c.d.g = 1;
    }
    b localb = this.c.d;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    localb.f = bool;
    j = n();
    i = j;
    if (j < 3) {
      i = 10;
    }
    this.c.d.i = (i * 10);
    this.c.d.h = m();
    m();
  }
  
  private void f()
  {
    this.c.d.a = n();
    this.c.d.b = n();
    this.c.d.c = n();
    this.c.d.d = n();
    int j = m();
    boolean bool = false;
    int i;
    if ((j & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int k = (int)Math.pow(2.0D, (j & 0x7) + 1);
    Object localObject = this.c.d;
    if ((j & 0x40) != 0) {
      bool = true;
    }
    ((b)localObject).e = bool;
    if (i != 0) {
      this.c.d.k = a(k);
    } else {
      this.c.d.k = null;
    }
    this.c.d.j = this.b.position();
    j();
    if (o()) {
      return;
    }
    localObject = this.c;
    ((c)localObject).c += 1;
    this.c.e.add(this.c.d);
  }
  
  private void g()
  {
    do
    {
      l();
      if (this.a[0] == 1)
      {
        int i = this.a[1];
        int j = this.a[2];
        this.c.m = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.d > 0) && (!o()));
  }
  
  private void h()
  {
    String str = "";
    int i = 0;
    while (i < 6)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((char)m());
      str = localStringBuilder.toString();
      i += 1;
    }
    if (!str.startsWith("GIF"))
    {
      this.c.b = 1;
      return;
    }
    i();
    if ((this.c.h) && (!o()))
    {
      this.c.a = a(this.c.i);
      this.c.l = this.c.a[this.c.j];
    }
  }
  
  private void i()
  {
    this.c.f = n();
    this.c.g = n();
    int i = m();
    c localc = this.c;
    boolean bool;
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localc.h = bool;
    this.c.i = (2 << (i & 0x7));
    this.c.j = m();
    this.c.k = m();
  }
  
  private void j()
  {
    m();
    k();
  }
  
  private void k()
  {
    int i;
    do
    {
      i = m();
      this.b.position(this.b.position() + i);
    } while (i > 0);
  }
  
  private int l()
  {
    this.d = m();
    int j = this.d;
    int k = 0;
    int i = 0;
    if (j > 0)
    {
      j = 0;
      for (;;)
      {
        int m = j;
        k = i;
        try
        {
          if (i < this.d)
          {
            m = j;
            j = this.d - i;
            m = j;
            this.b.get(this.a, i, j);
            i += j;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error Reading Block n: ");
            localStringBuilder.append(i);
            localStringBuilder.append(" count: ");
            localStringBuilder.append(m);
            localStringBuilder.append(" blockSize: ");
            localStringBuilder.append(this.d);
            Log.d("GifHeaderParser", localStringBuilder.toString(), localException);
          }
          this.c.b = 1;
          k = i;
        }
      }
    }
    return k;
  }
  
  private int m()
  {
    try
    {
      int i = this.b.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.c.b = 1;
    return 0;
  }
  
  private int n()
  {
    return this.b.getShort();
  }
  
  private boolean o()
  {
    return this.c.b != 0;
  }
  
  public d a(byte[] paramArrayOfByte)
  {
    c();
    if (paramArrayOfByte != null)
    {
      this.b = ByteBuffer.wrap(paramArrayOfByte);
      this.b.rewind();
      this.b.order(ByteOrder.LITTLE_ENDIAN);
      return this;
    }
    this.b = null;
    this.c.b = 2;
    return this;
  }
  
  public void a()
  {
    this.b = null;
    this.c = null;
  }
  
  public c b()
  {
    if (this.b != null)
    {
      if (o()) {
        return this.c;
      }
      h();
      if (!o())
      {
        d();
        if (this.c.c < 0) {
          this.c.b = 1;
        }
      }
      return this.c;
    }
    throw new IllegalStateException("You must call setData() before parseHeader()");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */