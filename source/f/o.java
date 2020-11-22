package f;

import javax.annotation.Nullable;

final class o
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  o f;
  o g;
  
  o()
  {
    this.a = new byte[' '];
    this.e = true;
    this.d = false;
  }
  
  o(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  final o a()
  {
    this.d = true;
    return new o(this.a, this.b, this.c, true, false);
  }
  
  public final o a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.c - this.b))
    {
      o localo;
      if (paramInt >= 1024)
      {
        localo = a();
      }
      else
      {
        localo = p.a();
        System.arraycopy(this.a, this.b, localo.a, 0, paramInt);
      }
      localo.c = (localo.b + paramInt);
      this.b += paramInt;
      this.g.a(localo);
      return localo;
    }
    throw new IllegalArgumentException();
  }
  
  public final o a(o paramo)
  {
    paramo.g = this;
    paramo.f = this.f;
    this.f.g = paramo;
    this.f = paramo;
    return paramo;
  }
  
  public final void a(o paramo, int paramInt)
  {
    if (paramo.e)
    {
      if (paramo.c + paramInt > 8192) {
        if (!paramo.d)
        {
          if (paramo.c + paramInt - paramo.b <= 8192)
          {
            System.arraycopy(paramo.a, paramo.b, paramo.a, 0, paramo.c - paramo.b);
            paramo.c -= paramo.b;
            paramo.b = 0;
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else {
          throw new IllegalArgumentException();
        }
      }
      System.arraycopy(this.a, this.b, paramo.a, paramo.c, paramInt);
      paramo.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public final o b()
  {
    o localo;
    if (this.f != this) {
      localo = this.f;
    } else {
      localo = null;
    }
    this.g.f = this.f;
    this.f.g = this.g;
    this.f = null;
    this.g = null;
    return localo;
  }
  
  public final void c()
  {
    if (this.g != this)
    {
      if (!this.g.e) {
        return;
      }
      int j = this.c - this.b;
      int k = this.g.c;
      int i;
      if (this.g.d) {
        i = 0;
      } else {
        i = this.g.b;
      }
      if (j > 8192 - k + i) {
        return;
      }
      a(this.g, j);
      b();
      p.a(this);
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */