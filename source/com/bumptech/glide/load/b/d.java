package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class d
  implements i.a
{
  private static final a a = new a();
  private static final Handler b = new Handler(Looper.getMainLooper(), new b(null));
  private final List<com.bumptech.glide.f.e> c = new ArrayList();
  private final a d;
  private final e e;
  private final c f;
  private final ExecutorService g;
  private final ExecutorService h;
  private final boolean i;
  private boolean j;
  private k<?> k;
  private boolean l;
  private Exception m;
  private boolean n;
  private Set<com.bumptech.glide.f.e> o;
  private i p;
  private h<?> q;
  private volatile Future<?> r;
  
  public d(c paramc, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, boolean paramBoolean, e parame)
  {
    this(paramc, paramExecutorService1, paramExecutorService2, paramBoolean, parame, a);
  }
  
  public d(c paramc, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, boolean paramBoolean, e parame, a parama)
  {
    this.f = paramc;
    this.g = paramExecutorService1;
    this.h = paramExecutorService2;
    this.i = paramBoolean;
    this.e = parame;
    this.d = parama;
  }
  
  private void b()
  {
    if (this.j)
    {
      this.k.d();
      return;
    }
    if (!this.c.isEmpty())
    {
      this.q = this.d.a(this.k, this.i);
      this.l = true;
      this.q.e();
      this.e.a(this.f, this.q);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        com.bumptech.glide.f.e locale = (com.bumptech.glide.f.e)localIterator.next();
        if (!d(locale))
        {
          this.q.e();
          locale.a(this.q);
        }
      }
      this.q.f();
      return;
    }
    throw new IllegalStateException("Received a resource without any callbacks to notify");
  }
  
  private void c()
  {
    if (this.j) {
      return;
    }
    if (!this.c.isEmpty())
    {
      this.n = true;
      this.e.a(this.f, null);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        com.bumptech.glide.f.e locale = (com.bumptech.glide.f.e)localIterator.next();
        if (!d(locale)) {
          locale.a(this.m);
        }
      }
      return;
    }
    throw new IllegalStateException("Received an exception without any callbacks to notify");
  }
  
  private void c(com.bumptech.glide.f.e parame)
  {
    if (this.o == null) {
      this.o = new HashSet();
    }
    this.o.add(parame);
  }
  
  private boolean d(com.bumptech.glide.f.e parame)
  {
    return (this.o != null) && (this.o.contains(parame));
  }
  
  void a()
  {
    if ((!this.n) && (!this.l))
    {
      if (this.j) {
        return;
      }
      this.p.a();
      Future localFuture = this.r;
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      this.j = true;
      this.e.a(this, this.f);
      return;
    }
  }
  
  public void a(com.bumptech.glide.f.e parame)
  {
    
    if (this.l)
    {
      parame.a(this.q);
      return;
    }
    if (this.n)
    {
      parame.a(this.m);
      return;
    }
    this.c.add(parame);
  }
  
  public void a(i parami)
  {
    this.p = parami;
    this.r = this.g.submit(parami);
  }
  
  public void a(k<?> paramk)
  {
    this.k = paramk;
    b.obtainMessage(1, this).sendToTarget();
  }
  
  public void a(Exception paramException)
  {
    this.m = paramException;
    b.obtainMessage(2, this).sendToTarget();
  }
  
  public void b(com.bumptech.glide.f.e parame)
  {
    
    if ((!this.l) && (!this.n))
    {
      this.c.remove(parame);
      if (this.c.isEmpty()) {
        a();
      }
    }
    else
    {
      c(parame);
    }
  }
  
  public void b(i parami)
  {
    this.r = this.h.submit(parami);
  }
  
  static class a
  {
    public <R> h<R> a(k<R> paramk, boolean paramBoolean)
    {
      return new h(paramk, paramBoolean);
    }
  }
  
  private static class b
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      if ((1 != paramMessage.what) && (2 != paramMessage.what)) {
        return false;
      }
      d locald = (d)paramMessage.obj;
      if (1 == paramMessage.what)
      {
        d.a(locald);
        return true;
      }
      d.b(locald);
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */