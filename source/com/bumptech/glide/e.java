package com.bumptech.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.c.a.d.a;
import com.bumptech.glide.load.c.b.b.a;
import com.bumptech.glide.load.c.b.f.a;
import com.bumptech.glide.load.c.b.g.a;
import com.bumptech.glide.load.c.b.h.a;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.manager.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static volatile e a;
  private final com.bumptech.glide.load.c.c b;
  private final com.bumptech.glide.load.b.c c;
  private final com.bumptech.glide.load.b.a.c d;
  private final com.bumptech.glide.load.b.b.h e;
  private final com.bumptech.glide.load.a f;
  private final com.bumptech.glide.f.b.f g = new com.bumptech.glide.f.b.f();
  private final com.bumptech.glide.load.resource.e.d h = new com.bumptech.glide.load.resource.e.d();
  private final com.bumptech.glide.e.c i;
  private final com.bumptech.glide.load.resource.bitmap.e j;
  private final com.bumptech.glide.load.resource.d.f k;
  private final i l;
  private final com.bumptech.glide.load.resource.d.f m;
  private final Handler n;
  private final com.bumptech.glide.load.b.d.a o;
  
  e(com.bumptech.glide.load.b.c paramc, com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.a.c paramc1, Context paramContext, com.bumptech.glide.load.a parama)
  {
    this.c = paramc;
    this.d = paramc1;
    this.e = paramh;
    this.f = parama;
    this.b = new com.bumptech.glide.load.c.c(paramContext);
    this.n = new Handler(Looper.getMainLooper());
    this.o = new com.bumptech.glide.load.b.d.a(paramh, paramc1, parama);
    this.i = new com.bumptech.glide.e.c();
    paramc = new o(paramc1, parama);
    this.i.a(InputStream.class, Bitmap.class, paramc);
    paramh = new com.bumptech.glide.load.resource.bitmap.g(paramc1, parama);
    this.i.a(ParcelFileDescriptor.class, Bitmap.class, paramh);
    paramc = new com.bumptech.glide.load.resource.bitmap.m(paramc, paramh);
    this.i.a(com.bumptech.glide.load.c.g.class, Bitmap.class, paramc);
    paramh = new com.bumptech.glide.load.resource.c.c(paramContext, paramc1);
    this.i.a(InputStream.class, com.bumptech.glide.load.resource.c.b.class, paramh);
    this.i.a(com.bumptech.glide.load.c.g.class, com.bumptech.glide.load.resource.d.a.class, new com.bumptech.glide.load.resource.d.g(paramc, paramh, paramc1));
    this.i.a(InputStream.class, File.class, new com.bumptech.glide.load.resource.b.d());
    a(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.c.a.a.a());
    a(File.class, InputStream.class, new com.bumptech.glide.load.c.b.c.a());
    a(Integer.TYPE, ParcelFileDescriptor.class, new com.bumptech.glide.load.c.a.c.a());
    a(Integer.TYPE, InputStream.class, new com.bumptech.glide.load.c.b.e.a());
    a(Integer.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.c.a.c.a());
    a(Integer.class, InputStream.class, new com.bumptech.glide.load.c.b.e.a());
    a(String.class, ParcelFileDescriptor.class, new d.a());
    a(String.class, InputStream.class, new f.a());
    a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.c.a.e.a());
    a(Uri.class, InputStream.class, new g.a());
    a(URL.class, InputStream.class, new h.a());
    a(com.bumptech.glide.load.c.d.class, InputStream.class, new com.bumptech.glide.load.c.b.a.a());
    a(byte[].class, InputStream.class, new b.a());
    this.h.a(Bitmap.class, com.bumptech.glide.load.resource.bitmap.j.class, new com.bumptech.glide.load.resource.e.b(paramContext.getResources(), paramc1));
    this.h.a(com.bumptech.glide.load.resource.d.a.class, com.bumptech.glide.load.resource.a.b.class, new com.bumptech.glide.load.resource.e.a(new com.bumptech.glide.load.resource.e.b(paramContext.getResources(), paramc1)));
    this.j = new com.bumptech.glide.load.resource.bitmap.e(paramc1);
    this.k = new com.bumptech.glide.load.resource.d.f(paramc1, this.j);
    this.l = new i(paramc1);
    this.m = new com.bumptech.glide.load.resource.d.f(paramc1, this.l);
  }
  
  public static e a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          paramContext = paramContext.getApplicationContext();
          Object localObject = new com.bumptech.glide.d.b(paramContext).a();
          f localf = new f(paramContext);
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext()) {
            ((com.bumptech.glide.d.a)localIterator.next()).a(paramContext, localf);
          }
          a = localf.a();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((com.bumptech.glide.d.a)((Iterator)localObject).next()).a(paramContext, a);
          }
        }
      }
      finally {}
    }
    return a;
  }
  
  public static h a(Activity paramActivity)
  {
    return k.a().a(paramActivity);
  }
  
  public static h a(FragmentActivity paramFragmentActivity)
  {
    return k.a().a(paramFragmentActivity);
  }
  
  public static <T> l<T, InputStream> a(Class<T> paramClass, Context paramContext)
  {
    return a(paramClass, InputStream.class, paramContext);
  }
  
  public static <T, Y> l<T, Y> a(Class<T> paramClass, Class<Y> paramClass1, Context paramContext)
  {
    if (paramClass == null)
    {
      if (Log.isLoggable("Glide", 3)) {
        Log.d("Glide", "Unable to load null model, setting placeholder only");
      }
      return null;
    }
    return a(paramContext).f().a(paramClass, paramClass1);
  }
  
  public static void a(com.bumptech.glide.f.b.j<?> paramj)
  {
    com.bumptech.glide.h.h.a();
    com.bumptech.glide.f.b localb = paramj.c();
    if (localb != null)
    {
      localb.d();
      paramj.a(null);
    }
  }
  
  public static h b(Context paramContext)
  {
    return k.a().a(paramContext);
  }
  
  public static <T> l<T, ParcelFileDescriptor> b(Class<T> paramClass, Context paramContext)
  {
    return a(paramClass, ParcelFileDescriptor.class, paramContext);
  }
  
  private com.bumptech.glide.load.c.c f()
  {
    return this.b;
  }
  
  <R> com.bumptech.glide.f.b.j<R> a(ImageView paramImageView, Class<R> paramClass)
  {
    return this.g.a(paramImageView, paramClass);
  }
  
  public com.bumptech.glide.load.b.a.c a()
  {
    return this.d;
  }
  
  <Z, R> com.bumptech.glide.load.resource.e.c<Z, R> a(Class<Z> paramClass, Class<R> paramClass1)
  {
    return this.h.a(paramClass, paramClass1);
  }
  
  public void a(int paramInt)
  {
    com.bumptech.glide.h.h.a();
    this.e.a(paramInt);
    this.d.a(paramInt);
  }
  
  public <T, Y> void a(Class<T> paramClass, Class<Y> paramClass1, com.bumptech.glide.load.c.m<T, Y> paramm)
  {
    paramClass = this.b.a(paramClass, paramClass1, paramm);
    if (paramClass != null) {
      paramClass.a();
    }
  }
  
  <T, Z> com.bumptech.glide.e.b<T, Z> b(Class<T> paramClass, Class<Z> paramClass1)
  {
    return this.i.a(paramClass, paramClass1);
  }
  
  com.bumptech.glide.load.b.c b()
  {
    return this.c;
  }
  
  com.bumptech.glide.load.resource.d.f c()
  {
    return this.k;
  }
  
  com.bumptech.glide.load.resource.d.f d()
  {
    return this.m;
  }
  
  public void e()
  {
    com.bumptech.glide.h.h.a();
    this.e.a();
    this.d.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */