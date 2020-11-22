package com.bumptech.glide.c;

import java.io.IOException;
import java.io.OutputStream;

class b
{
  int a;
  int b = 12;
  int c;
  int d = 4096;
  int[] e = new int['ᎋ'];
  int[] f = new int['ᎋ'];
  int g = 5003;
  int h = 0;
  boolean i = false;
  int j;
  int k;
  int l;
  int m = 0;
  int n = 0;
  int[] o = { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535 };
  int p;
  byte[] q = new byte['Ā'];
  private int r;
  private int s;
  private byte[] t;
  private int u;
  private int v;
  private int w;
  
  b(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    this.t = paramArrayOfByte;
    this.u = Math.max(2, paramInt3);
  }
  
  private int a()
  {
    if (this.v == 0) {
      return -1;
    }
    this.v -= 1;
    byte[] arrayOfByte = this.t;
    int i1 = this.w;
    this.w = (i1 + 1);
    return arrayOfByte[i1] & 0xFF;
  }
  
  void a(byte paramByte, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = this.q;
    int i1 = this.p;
    this.p = (i1 + 1);
    arrayOfByte[i1] = paramByte;
    if (this.p >= 254) {
      c(paramOutputStream);
    }
  }
  
  void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.e[i1] = -1;
      i1 += 1;
    }
  }
  
  void a(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    this.j = paramInt;
    int i2 = 0;
    this.i = false;
    this.a = this.j;
    this.c = b(this.a);
    this.k = (1 << paramInt - 1);
    this.l = (this.k + 1);
    this.h = (this.k + 2);
    this.p = 0;
    int i1 = a();
    paramInt = this.g;
    while (paramInt < 65536)
    {
      i2 += 1;
      paramInt *= 2;
    }
    int i6 = this.g;
    a(i6);
    b(this.k, paramOutputStream);
    paramInt = i1;
    for (;;)
    {
      int i5 = a();
      if (i5 == -1) {
        break;
      }
      int i7 = (i5 << this.b) + paramInt;
      i1 = i5 << 8 - i2 ^ paramInt;
      if (this.e[i1] == i7)
      {
        paramInt = this.f[i1];
      }
      else
      {
        int i3 = i1;
        if (this.e[i1] >= 0)
        {
          i3 = i6 - i1;
          int i4 = i1;
          if (i1 == 0)
          {
            i3 = 1;
            i4 = i1;
          }
          do
          {
            i4 -= i3;
            i1 = i4;
            if (i4 < 0) {
              i1 = i4 + i6;
            }
            if (this.e[i1] == i7)
            {
              paramInt = this.f[i1];
              break;
            }
            i4 = i1;
          } while (this.e[i1] >= 0);
          i3 = i1;
        }
        b(paramInt, paramOutputStream);
        if (this.h < this.d)
        {
          int[] arrayOfInt = this.f;
          paramInt = this.h;
          this.h = (paramInt + 1);
          arrayOfInt[i3] = paramInt;
          this.e[i3] = i7;
        }
        else
        {
          a(paramOutputStream);
        }
        paramInt = i5;
      }
    }
    b(paramInt, paramOutputStream);
    b(this.l, paramOutputStream);
  }
  
  void a(OutputStream paramOutputStream)
    throws IOException
  {
    a(this.g);
    this.h = (this.k + 2);
    this.i = true;
    b(this.k, paramOutputStream);
  }
  
  final int b(int paramInt)
  {
    return (1 << paramInt) - 1;
  }
  
  void b(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    this.m &= this.o[this.n];
    if (this.n > 0) {
      this.m |= paramInt << this.n;
    } else {
      this.m = paramInt;
    }
    for (this.n += this.a; this.n >= 8; this.n -= 8)
    {
      a((byte)(this.m & 0xFF), paramOutputStream);
      this.m >>= 8;
    }
    if ((this.h > this.c) || (this.i)) {
      if (this.i)
      {
        int i1 = this.j;
        this.a = i1;
        this.c = b(i1);
        this.i = false;
      }
      else
      {
        this.a += 1;
        if (this.a == this.b) {
          this.c = this.d;
        } else {
          this.c = b(this.a);
        }
      }
    }
    if (paramInt == this.l)
    {
      while (this.n > 0)
      {
        a((byte)(this.m & 0xFF), paramOutputStream);
        this.m >>= 8;
        this.n -= 8;
      }
      c(paramOutputStream);
    }
  }
  
  void b(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.u);
    this.v = (this.r * this.s);
    this.w = 0;
    a(this.u + 1, paramOutputStream);
    paramOutputStream.write(0);
  }
  
  void c(OutputStream paramOutputStream)
    throws IOException
  {
    if (this.p > 0)
    {
      paramOutputStream.write(this.p);
      paramOutputStream.write(this.q, 0, this.p);
      this.p = 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */