package com.bumptech.glide.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = "a";
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private int[] c;
  private ByteBuffer d;
  private final byte[] e = new byte['Ā'];
  private short[] f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  private int[] j;
  private int k;
  private byte[] l;
  private c m;
  private a n;
  private Bitmap o;
  private boolean p;
  private int q;
  
  public a(a parama)
  {
    this.n = parama;
    this.m = new c();
  }
  
  private Bitmap a(b paramb1, b paramb2)
  {
    int i8 = this.m.f;
    int i9 = this.m.g;
    int[] arrayOfInt = this.j;
    int i4 = 0;
    int i1;
    if ((paramb2 != null) && (paramb2.g > 0)) {
      if (paramb2.g == 2)
      {
        if (!paramb1.f) {
          i1 = this.m.l;
        } else {
          i1 = 0;
        }
        Arrays.fill(arrayOfInt, i1);
      }
      else if ((paramb2.g == 3) && (this.o != null))
      {
        this.o.getPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
      }
    }
    a(paramb1);
    int i3 = 0;
    int i6 = 1;
    int i5 = 8;
    while (i4 < paramb1.d)
    {
      int i7;
      int i2;
      if (paramb1.e)
      {
        i7 = i6;
        i2 = i5;
        i1 = i3;
        if (i3 >= paramb1.d)
        {
          i7 = i6 + 1;
          switch (i7)
          {
          default: 
            i2 = i5;
            i1 = i3;
            break;
          case 4: 
            i1 = 1;
            i2 = 2;
            break;
          case 3: 
            i1 = 2;
            i2 = 4;
            break;
          case 2: 
            i1 = 4;
            i2 = i5;
          }
        }
        i3 = i1 + i2;
        i6 = i7;
        i5 = i2;
        i2 = i3;
      }
      else
      {
        i2 = i3;
        i1 = i4;
      }
      i1 += paramb1.b;
      if (i1 < this.m.g)
      {
        int i10 = i1 * this.m.f;
        i7 = paramb1.a + i10;
        i3 = paramb1.c + i7;
        i1 = i3;
        if (this.m.f + i10 < i3) {
          i1 = this.m.f + i10;
        }
        i3 = paramb1.c * i4;
        while (i7 < i1)
        {
          i10 = this.i[i3];
          i10 = this.c[(i10 & 0xFF)];
          if (i10 != 0) {
            arrayOfInt[i7] = i10;
          }
          i7 += 1;
          i3 += 1;
        }
      }
      i4 += 1;
      i3 = i2;
    }
    if ((this.p) && ((paramb1.g == 0) || (paramb1.g == 1)))
    {
      if (this.o == null) {
        this.o = j();
      }
      this.o.setPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
    }
    paramb1 = j();
    paramb1.setPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
    return paramb1;
  }
  
  @TargetApi(12)
  private static void a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {
      paramBitmap.setHasAlpha(true);
    }
  }
  
  private void a(b paramb)
  {
    if (paramb != null) {
      this.d.position(paramb.j);
    }
    int i17;
    if (paramb == null)
    {
      i17 = this.m.f * this.m.g;
    }
    else
    {
      i2 = paramb.c;
      i17 = paramb.d * i2;
    }
    if ((this.i == null) || (this.i.length < i17)) {
      this.i = new byte[i17];
    }
    if (this.f == null) {
      this.f = new short['က'];
    }
    if (this.g == null) {
      this.g = new byte['က'];
    }
    if (this.h == null) {
      this.h = new byte['ခ'];
    }
    int i2 = h();
    int i22 = 1 << i2;
    int i18 = i22 + 2;
    int i10 = i2 + 1;
    int i19 = (1 << i10) - 1;
    i2 = 0;
    while (i2 < i22)
    {
      this.f[i2] = 0;
      this.g[i2] = ((byte)i2);
      i2 += 1;
    }
    int i3 = -1;
    int i4 = i10;
    int i5 = i18;
    int i8 = i19;
    int i7 = 0;
    int i12 = 0;
    i2 = 0;
    int i14 = 0;
    int i13 = 0;
    int i15 = 0;
    int i9 = 0;
    int i11 = 0;
    int i6 = -1;
    int i16 = i22;
    int i20;
    for (;;)
    {
      i20 = i2;
      if (i7 >= i17) {
        break;
      }
      int i21 = 3;
      i20 = i12;
      if (i12 == 0)
      {
        i20 = i();
        if (i20 <= 0)
        {
          this.q = 3;
          i20 = i2;
          break;
        }
        i13 = 0;
      }
      i14 += ((this.e[i13] & 0xFF) << i15);
      int i23 = i13 + 1;
      int i24 = i20 + i3;
      i15 += 8;
      i13 = i9;
      i9 = i6;
      i12 = i2;
      i2 = i5;
      i6 = i4;
      i5 = i12;
      i4 = i7;
      i7 = i2;
      i12 = i3;
      i20 = i21;
      i3 = i16;
      i2 = i10;
      while (i15 >= i6)
      {
        i12 = i14 & i8;
        i16 = i14 >> i6;
        i10 = i15 - i6;
        if (i12 == i3)
        {
          i6 = i2;
          i7 = i18;
          i8 = i19;
          i9 = -1;
          i12 = i3;
          i3 = i9;
          i14 = -1;
          i15 = i10;
          i9 = i3;
          i3 = i12;
          i12 = i14;
          i14 = i16;
        }
        else
        {
          if (i12 > i7) {
            this.q = i20;
          } else {
            if (i12 != i22 + 1) {
              break label482;
            }
          }
          i12 = -1;
          i14 = i16;
          i15 = i10;
          break;
          label482:
          if (i9 == -1)
          {
            this.h[i11] = this.g[i12];
            i9 = i12;
            i11 += 1;
            i15 = i3;
            i3 = i10;
          }
          for (;;)
          {
            i20 = 3;
            i10 = i3;
            i3 = i12;
            i12 = i15;
            i13 = i9;
            break;
            if (i12 >= i7)
            {
              this.h[i11] = ((byte)i13);
              i13 = i9;
              i15 = i11 + 1;
              i11 = i10;
            }
            else
            {
              i13 = i12;
              i15 = i11;
              i11 = i10;
            }
            while (i13 >= i3)
            {
              this.h[i15] = this.g[i13];
              i13 = this.f[i13];
              i15 += 1;
            }
            i20 = this.g[i13] & 0xFF;
            paramb = this.h;
            int i1 = (byte)i20;
            paramb[i15] = i1;
            i14 = i6;
            i13 = i7;
            i10 = i8;
            if (i7 < 4096)
            {
              this.f[i7] = ((short)i9);
              this.g[i7] = i1;
              i7 += 1;
              if ((i7 & i8) == 0)
              {
                i14 = i6;
                i13 = i7;
                i10 = i8;
                if (i7 < 4096)
                {
                  i14 = i6 + 1;
                  i10 = i8 + i7;
                  i13 = i7;
                }
              }
              else
              {
                i10 = i8;
                i13 = i7;
                i14 = i6;
              }
            }
            i8 = i15 + 1;
            while (i8 > 0)
            {
              i8 -= 1;
              this.i[i5] = this.h[i8];
              i4 += 1;
              i5 += 1;
            }
            i9 = i20;
            i15 = i3;
            i3 = i11;
            i6 = i14;
            i7 = i13;
            i11 = i8;
            i8 = i10;
          }
        }
      }
      i20 = i9;
      i21 = i7;
      i9 = i13;
      i10 = i2;
      i16 = i3;
      i3 = i12;
      i7 = i4;
      i12 = i24;
      i2 = i5;
      i13 = i23;
      i5 = i21;
      i4 = i6;
      i6 = i20;
    }
    while (i20 < i17)
    {
      this.i[i20] = 0;
      i20 += 1;
    }
  }
  
  private int h()
  {
    try
    {
      int i1 = this.d.get();
      return i1 & 0xFF;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.q = 1;
    return 0;
  }
  
  private int i()
  {
    int i3 = h();
    int i2 = 0;
    int i1 = 0;
    if (i3 > 0) {
      for (;;)
      {
        i2 = i1;
        if (i1 < i3)
        {
          i2 = i3 - i1;
          try
          {
            this.d.get(this.e, i1, i2);
            i1 += i2;
          }
          catch (Exception localException)
          {
            Log.w(a, "Error Reading Block", localException);
            this.q = 1;
            i2 = i1;
          }
        }
      }
    }
    return i2;
  }
  
  private Bitmap j()
  {
    Bitmap localBitmap2 = this.n.a(this.m.f, this.m.g, b);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = Bitmap.createBitmap(this.m.f, this.m.g, b);
    }
    a(localBitmap1);
    return localBitmap1;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.c)) {
      return ((b)this.m.e.get(paramInt)).i;
    }
    return -1;
  }
  
  public void a()
  {
    this.k = ((this.k + 1) % this.m.c);
  }
  
  public void a(c paramc, byte[] paramArrayOfByte)
  {
    this.m = paramc;
    this.l = paramArrayOfByte;
    this.q = 0;
    this.k = -1;
    this.d = ByteBuffer.wrap(paramArrayOfByte);
    this.d.rewind();
    this.d.order(ByteOrder.LITTLE_ENDIAN);
    this.p = false;
    paramArrayOfByte = paramc.e.iterator();
    while (paramArrayOfByte.hasNext()) {
      if (((b)paramArrayOfByte.next()).g == 3) {
        this.p = true;
      }
    }
    this.i = new byte[paramc.f * paramc.g];
    this.j = new int[paramc.f * paramc.g];
  }
  
  public int b()
  {
    if ((this.m.c > 0) && (this.k >= 0)) {
      return a(this.k);
    }
    return -1;
  }
  
  public int c()
  {
    return this.m.c;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public int e()
  {
    return this.m.m;
  }
  
  public Bitmap f()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject4;
        if ((this.m.c <= 0) || (this.k < 0))
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("unable to decode frame, frameCount=");
            ((StringBuilder)localObject4).append(this.m.c);
            ((StringBuilder)localObject4).append(" framePointer=");
            ((StringBuilder)localObject4).append(this.k);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          this.q = 1;
        }
        if ((this.q != 1) && (this.q != 2))
        {
          int i1 = 0;
          this.q = 0;
          localObject4 = (b)this.m.e.get(this.k);
          int i2 = this.k - 1;
          if (i2 >= 0)
          {
            localObject1 = (b)this.m.e.get(i2);
            if (((b)localObject4).k == null)
            {
              this.c = this.m.a;
            }
            else
            {
              this.c = ((b)localObject4).k;
              if (this.m.j == ((b)localObject4).h) {
                this.m.l = 0;
              }
            }
            if (((b)localObject4).f)
            {
              i1 = this.c[localObject4.h];
              this.c[localObject4.h] = 0;
            }
            if (this.c == null)
            {
              if (Log.isLoggable(a, 3)) {
                Log.d(a, "No Valid Color Table");
              }
              this.q = 1;
              return null;
            }
            localObject1 = a((b)localObject4, (b)localObject1);
            if (((b)localObject4).f) {
              this.c[localObject4.h] = i1;
            }
            return (Bitmap)localObject1;
          }
        }
        else
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, status=");
            ((StringBuilder)localObject4).append(this.q);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          return null;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public void g()
  {
    this.m = null;
    this.l = null;
    this.i = null;
    this.j = null;
    if (this.o != null) {
      this.n.a(this.o);
    }
    this.o = null;
    this.d = null;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
    
    public abstract void a(Bitmap paramBitmap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */