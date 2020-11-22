package com.bumptech.glide.f.b;

import android.widget.ImageView;
import com.bumptech.glide.f.a.c;
import com.bumptech.glide.load.resource.a.b;

public class d
  extends e<b>
{
  private int b;
  private b c;
  
  public d(ImageView paramImageView)
  {
    this(paramImageView, -1);
  }
  
  public d(ImageView paramImageView, int paramInt)
  {
    super(paramImageView);
    this.b = paramInt;
  }
  
  protected void a(b paramb)
  {
    ((ImageView)this.a).setImageDrawable(paramb);
  }
  
  public void a(b paramb, c<? super b> paramc)
  {
    Object localObject = paramb;
    if (!paramb.a())
    {
      float f1 = ((ImageView)this.a).getWidth() / ((ImageView)this.a).getHeight();
      float f2 = paramb.getIntrinsicWidth() / paramb.getIntrinsicHeight();
      localObject = paramb;
      if (Math.abs(f1 - 1.0F) <= 0.05F)
      {
        localObject = paramb;
        if (Math.abs(f2 - 1.0F) <= 0.05F) {
          localObject = new i(paramb, ((ImageView)this.a).getWidth());
        }
      }
    }
    super.a(localObject, paramc);
    this.c = ((b)localObject);
    ((b)localObject).a(this.b);
    ((b)localObject).start();
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.start();
    }
  }
  
  public void e()
  {
    if (this.c != null) {
      this.c.stop();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */