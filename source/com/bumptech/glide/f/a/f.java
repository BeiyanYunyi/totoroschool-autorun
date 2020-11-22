package com.bumptech.glide.f.a;

import android.view.View;
import android.view.animation.Animation;

public class f<R>
  implements c<R>
{
  private final a a;
  
  f(a parama)
  {
    this.a = parama;
  }
  
  public boolean a(R paramR, c.a parama)
  {
    paramR = parama.a();
    if (paramR != null)
    {
      paramR.clearAnimation();
      paramR.startAnimation(this.a.a());
    }
    return false;
  }
  
  static abstract interface a
  {
    public abstract Animation a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */