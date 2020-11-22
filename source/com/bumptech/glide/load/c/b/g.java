package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.q;
import java.io.InputStream;

public class g
  extends q<InputStream>
  implements d<Uri>
{
  public g(Context paramContext, l<com.bumptech.glide.load.c.d, InputStream> paraml)
  {
    super(paramContext, paraml);
  }
  
  protected com.bumptech.glide.load.a.c<InputStream> a(Context paramContext, Uri paramUri)
  {
    return new i(paramContext, paramUri);
  }
  
  protected com.bumptech.glide.load.a.c<InputStream> a(Context paramContext, String paramString)
  {
    return new h(paramContext.getApplicationContext().getAssets(), paramString);
  }
  
  public static class a
    implements m<Uri, InputStream>
  {
    public l<Uri, InputStream> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new g(paramContext, paramc.a(com.bumptech.glide.load.c.d.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */