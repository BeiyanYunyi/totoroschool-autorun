package com.bumptech.glide.f.a;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class a<T extends Drawable>
  implements d<T>
{
  private final g<T> a;
  private final int b;
  private b<T> c;
  private b<T> d;
  
  public a()
  {
    this(300);
  }
  
  public a(int paramInt)
  {
    this(new g(new a(paramInt)), paramInt);
  }
  
  a(g<T> paramg, int paramInt)
  {
    this.a = paramg;
    this.b = paramInt;
  }
  
  private c<T> a()
  {
    if (this.c == null) {
      this.c = new b(this.a.a(false, true), this.b);
    }
    return this.c;
  }
  
  private c<T> b()
  {
    if (this.d == null) {
      this.d = new b(this.a.a(false, false), this.b);
    }
    return this.d;
  }
  
  public c<T> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return e.b();
    }
    if (paramBoolean2) {
      return a();
    }
    return b();
  }
  
  private static class a
    implements f.a
  {
    private final int a;
    
    a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public Animation a()
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(this.a);
      return localAlphaAnimation;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */