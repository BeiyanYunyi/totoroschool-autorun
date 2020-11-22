package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.c.c;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.p;
import java.io.InputStream;

public class f
  extends p<InputStream>
  implements d<String>
{
  public f(l<Uri, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<String, InputStream>
  {
    public l<String, InputStream> a(Context paramContext, c paramc)
    {
      return new f(paramc.a(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */