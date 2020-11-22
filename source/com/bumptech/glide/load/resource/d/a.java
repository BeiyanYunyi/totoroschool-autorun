package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.resource.c.b;

public class a
{
  private final k<b> a;
  private final k<Bitmap> b;
  
  public a(k<Bitmap> paramk, k<b> paramk1)
  {
    if ((paramk != null) && (paramk1 != null)) {
      throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
    }
    if ((paramk == null) && (paramk1 == null)) {
      throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
    }
    this.b = paramk;
    this.a = paramk1;
  }
  
  public int a()
  {
    if (this.b != null) {
      return this.b.c();
    }
    return this.a.c();
  }
  
  public k<Bitmap> b()
  {
    return this.b;
  }
  
  public k<b> c()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */