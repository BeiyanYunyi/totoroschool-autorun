package com.bumptech.glide.load.resource.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.b.k;

public abstract class a<T extends Drawable>
  implements k<T>
{
  protected final T a;
  
  public a(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      return;
    }
    throw new NullPointerException("Drawable must not be null!");
  }
  
  public final T a()
  {
    return this.a.getConstantState().newDrawable();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */