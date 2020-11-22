package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.c.c;
import com.bumptech.glide.load.c.d;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.r;
import java.io.InputStream;
import java.net.URL;

public class h
  extends r<InputStream>
{
  public h(l<d, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<URL, InputStream>
  {
    public l<URL, InputStream> a(Context paramContext, c paramc)
    {
      return new h(paramc.a(d.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */