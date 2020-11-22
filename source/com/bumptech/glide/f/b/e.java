package com.bumptech.glide.f.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.f.a.c;
import com.bumptech.glide.f.a.c.a;

public abstract class e<Z>
  extends k<ImageView, Z>
  implements c.a
{
  public e(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  public void a(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  public void a(Exception paramException, Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  protected abstract void a(Z paramZ);
  
  public void a(Z paramZ, c<? super Z> paramc)
  {
    if ((paramc == null) || (!paramc.a(paramZ, this))) {
      a(paramZ);
    }
  }
  
  public Drawable b()
  {
    return ((ImageView)this.a).getDrawable();
  }
  
  public void b(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  public void c(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */