package com.bumptech.glide.f.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class b<T extends Drawable>
  implements c<T>
{
  private final c<T> a;
  private final int b;
  
  public b(c<T> paramc, int paramInt)
  {
    this.a = paramc;
    this.b = paramInt;
  }
  
  public boolean a(T paramT, c.a parama)
  {
    Drawable localDrawable = parama.b();
    if (localDrawable != null)
    {
      paramT = new TransitionDrawable(new Drawable[] { localDrawable, paramT });
      paramT.setCrossFadeEnabled(true);
      paramT.startTransition(this.b);
      parama.a(paramT);
      return true;
    }
    this.a.a(paramT, parama);
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */