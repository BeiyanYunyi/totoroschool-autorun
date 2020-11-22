package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.c.b;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.File;
import java.io.InputStream;

public class c
  extends b<InputStream>
  implements d<File>
{
  public c(l<Uri, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<File, InputStream>
  {
    public l<File, InputStream> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new c(paramc.a(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */