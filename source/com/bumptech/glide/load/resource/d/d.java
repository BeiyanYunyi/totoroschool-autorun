package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.c.b;
import java.io.OutputStream;

public class d
  implements f<a>
{
  private final f<Bitmap> a;
  private final f<b> b;
  private String c;
  
  public d(f<Bitmap> paramf, f<b> paramf1)
  {
    this.a = paramf;
    this.b = paramf1;
  }
  
  public String a()
  {
    if (this.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(this.b.a());
      this.c = localStringBuilder.toString();
    }
    return this.c;
  }
  
  public boolean a(k<a> paramk, OutputStream paramOutputStream)
  {
    paramk = (a)paramk.b();
    k localk = paramk.b();
    if (localk != null) {
      return this.a.a(localk, paramOutputStream);
    }
    return this.b.a(paramk.c(), paramOutputStream);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */