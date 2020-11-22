package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.g.a;
import com.bumptech.glide.manager.c.a;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.m;
import java.io.File;

public class h
  implements com.bumptech.glide.manager.h
{
  private final Context a;
  private final g b;
  private final com.bumptech.glide.manager.l c;
  private final m d;
  private final e e;
  private final c f;
  private a g;
  
  public h(Context paramContext, g paramg, com.bumptech.glide.manager.l paraml)
  {
    this(paramContext, paramg, paraml, new m(), new com.bumptech.glide.manager.d());
  }
  
  h(Context paramContext, final g paramg, com.bumptech.glide.manager.l paraml, m paramm, com.bumptech.glide.manager.d paramd)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramg;
    this.c = paraml;
    this.d = paramm;
    this.e = e.a(paramContext);
    this.f = new c();
    paramContext = paramd.a(paramContext, new d(paramm));
    if (com.bumptech.glide.h.h.c()) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          paramg.a(h.this);
        }
      });
    } else {
      paramg.a(this);
    }
    paramg.a(paramContext);
  }
  
  private <T> b<T> a(Class<T> paramClass)
  {
    Object localObject = e.a(paramClass, this.a);
    com.bumptech.glide.load.c.l locall = e.b(paramClass, this.a);
    if ((paramClass != null) && (localObject == null) && (locall == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown type ");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append(". You must provide a Model of a type for");
      ((StringBuilder)localObject).append(" which there is a registered ModelLoader, if you are using a custom model, you must first call");
      ((StringBuilder)localObject).append(" Glide#register with a ModelLoaderFactory for your custom model class");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (b)this.f.a(new b(paramClass, (com.bumptech.glide.load.c.l)localObject, locall, this.a, this.e, this.d, this.b, this.f));
  }
  
  private static <T> Class<T> b(T paramT)
  {
    if (paramT != null) {
      return paramT.getClass();
    }
    return null;
  }
  
  public b<File> a(File paramFile)
  {
    return (b)h().a(paramFile);
  }
  
  public b<Integer> a(Integer paramInteger)
  {
    return (b)i().a(paramInteger);
  }
  
  public b<String> a(String paramString)
  {
    return (b)g().a(paramString);
  }
  
  public <A, T> b<A, T> a(com.bumptech.glide.load.c.l<A, T> paraml, Class<T> paramClass)
  {
    return new b(paraml, paramClass);
  }
  
  public void a()
  {
    this.e.e();
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void b()
  {
    com.bumptech.glide.h.h.a();
    this.d.a();
  }
  
  public void c()
  {
    com.bumptech.glide.h.h.a();
    this.d.b();
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    this.d.c();
  }
  
  public b<String> g()
  {
    return a(String.class);
  }
  
  public b<File> h()
  {
    return a(File.class);
  }
  
  public b<Integer> i()
  {
    return (b)a(Integer.class).a(a.a(this.a));
  }
  
  public static abstract interface a
  {
    public abstract <T> void a(c<T, ?, ?, ?> paramc);
  }
  
  public final class b<A, T>
  {
    private final com.bumptech.glide.load.c.l<A, T> b;
    private final Class<T> c;
    
    b(Class<T> paramClass)
    {
      this.b = paramClass;
      Class localClass;
      this.c = localClass;
    }
    
    public b<A, T>.a a(A paramA)
    {
      return new a(paramA);
    }
    
    public final class a
    {
      private final A b;
      private final Class<A> c;
      private final boolean d = true;
      
      a()
      {
        Object localObject;
        this.b = localObject;
        this.c = h.a(localObject);
      }
      
      public <Z> d<A, T, Z> a(Class<Z> paramClass)
      {
        paramClass = (d)h.e(h.this).a(new d(h.a(h.this), h.b(h.this), this.c, h.b.a(h.b.this), h.b.b(h.b.this), paramClass, h.c(h.this), h.d(h.this), h.e(h.this)));
        if (this.d) {
          paramClass.b(this.b);
        }
        return paramClass;
      }
    }
  }
  
  class c
  {
    c() {}
    
    public <A, X extends c<A, ?, ?, ?>> X a(X paramX)
    {
      if (h.f(h.this) != null) {
        h.f(h.this).a(paramX);
      }
      return paramX;
    }
  }
  
  private static class d
    implements c.a
  {
    private final m a;
    
    public d(m paramm)
    {
      this.a = paramm;
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.a.d();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */