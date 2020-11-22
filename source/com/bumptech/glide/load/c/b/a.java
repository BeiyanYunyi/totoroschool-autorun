package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.a.f;
import com.bumptech.glide.load.c.d;
import com.bumptech.glide.load.c.k;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.InputStream;

public class a
  implements l<d, InputStream>
{
  private final k<d, d> a;
  
  public a()
  {
    this(null);
  }
  
  public a(k<d, d> paramk)
  {
    this.a = paramk;
  }
  
  public com.bumptech.glide.load.a.c<InputStream> a(d paramd, int paramInt1, int paramInt2)
  {
    d locald = paramd;
    if (this.a != null)
    {
      locald = (d)this.a.a(paramd, 0, 0);
      if (locald == null)
      {
        this.a.a(paramd, 0, 0, paramd);
        locald = paramd;
      }
    }
    return new f(locald);
  }
  
  public static class a
    implements m<d, InputStream>
  {
    private final k<d, d> a = new k(500);
    
    public l<d, InputStream> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new a(this.a);
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */