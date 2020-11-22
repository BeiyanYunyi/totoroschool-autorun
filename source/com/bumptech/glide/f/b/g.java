package com.bumptech.glide.f.b;

public abstract class g<Z>
  extends a<Z>
{
  private final int a;
  private final int b;
  
  public g()
  {
    this(Integer.MIN_VALUE, Integer.MIN_VALUE);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final void a(h paramh)
  {
    if (com.bumptech.glide.h.h.a(this.a, this.b))
    {
      paramh.a(this.a, this.b);
      return;
    }
    paramh = new StringBuilder();
    paramh.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    paramh.append(this.a);
    paramh.append(" and height: ");
    paramh.append(this.b);
    paramh.append(", either provide dimensions in the constructor");
    paramh.append(" or call override()");
    throw new IllegalArgumentException(paramh.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */