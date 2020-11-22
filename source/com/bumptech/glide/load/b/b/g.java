package com.bumptech.glide.load.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.h.e;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c;

public class g
  extends e<c, k<?>>
  implements h
{
  private h.a a;
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(k<?> paramk)
  {
    return paramk.c();
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (paramInt >= 60)
    {
      a();
      return;
    }
    if (paramInt >= 40) {
      b(b() / 2);
    }
  }
  
  public void a(h.a parama)
  {
    this.a = parama;
  }
  
  protected void a(c paramc, k<?> paramk)
  {
    if (this.a != null) {
      this.a.b(paramk);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */