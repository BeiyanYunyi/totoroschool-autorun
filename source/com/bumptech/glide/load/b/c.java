package com.bumptech.glide.load.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class c
  implements com.bumptech.glide.load.b.b.h.a, e, h.a
{
  private final Map<com.bumptech.glide.load.c, d> a;
  private final g b;
  private final com.bumptech.glide.load.b.b.h c;
  private final a d;
  private final Map<com.bumptech.glide.load.c, WeakReference<h<?>>> e;
  private final l f;
  private final b g;
  private ReferenceQueue<h<?>> h;
  
  public c(com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.b.a.a parama, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2)
  {
    this(paramh, parama, paramExecutorService1, paramExecutorService2, null, null, null, null, null);
  }
  
  c(com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.b.a.a parama, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, Map<com.bumptech.glide.load.c, d> paramMap, g paramg, Map<com.bumptech.glide.load.c, WeakReference<h<?>>> paramMap1, a parama1, l paraml)
  {
    this.c = paramh;
    this.g = new b(parama);
    parama = paramMap1;
    if (paramMap1 == null) {
      parama = new HashMap();
    }
    this.e = parama;
    parama = paramg;
    if (paramg == null) {
      parama = new g();
    }
    this.b = parama;
    parama = paramMap;
    if (paramMap == null) {
      parama = new HashMap();
    }
    this.a = parama;
    parama = parama1;
    if (parama1 == null) {
      parama = new a(paramExecutorService1, paramExecutorService2, this);
    }
    this.d = parama;
    parama = paraml;
    if (paraml == null) {
      parama = new l();
    }
    this.f = parama;
    paramh.a(this);
  }
  
  private h<?> a(com.bumptech.glide.load.c paramc)
  {
    paramc = this.c.a(paramc);
    if (paramc == null) {
      return null;
    }
    if ((paramc instanceof h)) {
      return (h)paramc;
    }
    return new h(paramc, true);
  }
  
  private h<?> a(com.bumptech.glide.load.c paramc, boolean paramBoolean)
  {
    h localh = null;
    if (!paramBoolean) {
      return null;
    }
    WeakReference localWeakReference = (WeakReference)this.e.get(paramc);
    if (localWeakReference != null)
    {
      localh = (h)localWeakReference.get();
      if (localh != null)
      {
        localh.e();
        return localh;
      }
      this.e.remove(paramc);
    }
    return localh;
  }
  
  private ReferenceQueue<h<?>> a()
  {
    if (this.h == null)
    {
      this.h = new ReferenceQueue();
      Looper.myQueue().addIdleHandler(new d(this.e, this.h));
    }
    return this.h;
  }
  
  private static void a(String paramString, long paramLong, com.bumptech.glide.load.c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in ");
    localStringBuilder.append(com.bumptech.glide.h.d.a(paramLong));
    localStringBuilder.append("ms, key: ");
    localStringBuilder.append(paramc);
    Log.v("Engine", localStringBuilder.toString());
  }
  
  private h<?> b(com.bumptech.glide.load.c paramc, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    h localh = a(paramc);
    if (localh != null)
    {
      localh.e();
      this.e.put(paramc, new e(paramc, localh, a()));
    }
    return localh;
  }
  
  public <T, Z, R> c a(com.bumptech.glide.load.c paramc, int paramInt1, int paramInt2, com.bumptech.glide.load.a.c<T> paramc1, com.bumptech.glide.e.b<T, Z> paramb, com.bumptech.glide.load.g<Z> paramg, com.bumptech.glide.load.resource.e.c<Z, R> paramc2, com.bumptech.glide.g paramg1, boolean paramBoolean, b paramb1, com.bumptech.glide.f.e parame)
  {
    com.bumptech.glide.h.h.a();
    long l = com.bumptech.glide.h.d.a();
    Object localObject = paramc1.b();
    paramc = this.b.a((String)localObject, paramc, paramInt1, paramInt2, paramb.a(), paramb.b(), paramg, paramb.d(), paramc2, paramb.c());
    localObject = b(paramc, paramBoolean);
    if (localObject != null)
    {
      parame.a((k)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from cache", l, paramc);
      }
      return null;
    }
    localObject = a(paramc, paramBoolean);
    if (localObject != null)
    {
      parame.a((k)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from active resources", l, paramc);
      }
      return null;
    }
    localObject = (d)this.a.get(paramc);
    if (localObject != null)
    {
      ((d)localObject).a(parame);
      if (Log.isLoggable("Engine", 2)) {
        a("Added to existing load", l, paramc);
      }
      return new c(parame, (d)localObject);
    }
    localObject = this.d.a(paramc, paramBoolean);
    paramc1 = new i((i.a)localObject, new a(paramc, paramInt1, paramInt2, paramc1, paramb, paramg, paramc2, this.g, paramb1, paramg1), paramg1);
    this.a.put(paramc, localObject);
    ((d)localObject).a(parame);
    ((d)localObject).a(paramc1);
    if (Log.isLoggable("Engine", 2)) {
      a("Started new load", l, paramc);
    }
    return new c(parame, (d)localObject);
  }
  
  public void a(d paramd, com.bumptech.glide.load.c paramc)
  {
    
    if (paramd.equals((d)this.a.get(paramc))) {
      this.a.remove(paramc);
    }
  }
  
  public void a(k paramk)
  {
    
    if ((paramk instanceof h))
    {
      ((h)paramk).f();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  public void a(com.bumptech.glide.load.c paramc, h<?> paramh)
  {
    
    if (paramh != null)
    {
      paramh.a(paramc, this);
      if (paramh.a()) {
        this.e.put(paramc, new e(paramc, paramh, a()));
      }
    }
    this.a.remove(paramc);
  }
  
  public void b(k<?> paramk)
  {
    com.bumptech.glide.h.h.a();
    this.f.a(paramk);
  }
  
  public void b(com.bumptech.glide.load.c paramc, h paramh)
  {
    com.bumptech.glide.h.h.a();
    this.e.remove(paramc);
    if (paramh.a())
    {
      this.c.b(paramc, paramh);
      return;
    }
    this.f.a(paramh);
  }
  
  static class a
  {
    private final ExecutorService a;
    private final ExecutorService b;
    private final e c;
    
    public a(ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, e parame)
    {
      this.a = paramExecutorService1;
      this.b = paramExecutorService2;
      this.c = parame;
    }
    
    public d a(com.bumptech.glide.load.c paramc, boolean paramBoolean)
    {
      return new d(paramc, this.a, this.b, paramBoolean, this.c);
    }
  }
  
  private static class b
    implements a.a
  {
    private final com.bumptech.glide.load.b.b.a.a a;
    private volatile com.bumptech.glide.load.b.b.a b;
    
    public b(com.bumptech.glide.load.b.b.a.a parama)
    {
      this.a = parama;
    }
    
    public com.bumptech.glide.load.b.b.a a()
    {
      if (this.b == null) {
        try
        {
          if (this.b == null) {
            this.b = this.a.a();
          }
          if (this.b == null) {
            this.b = new com.bumptech.glide.load.b.b.b();
          }
        }
        finally {}
      }
      return this.b;
    }
  }
  
  public static class c
  {
    private final d a;
    private final com.bumptech.glide.f.e b;
    
    public c(com.bumptech.glide.f.e parame, d paramd)
    {
      this.b = parame;
      this.a = paramd;
    }
    
    public void a()
    {
      this.a.b(this.b);
    }
  }
  
  private static class d
    implements MessageQueue.IdleHandler
  {
    private final Map<com.bumptech.glide.load.c, WeakReference<h<?>>> a;
    private final ReferenceQueue<h<?>> b;
    
    public d(Map<com.bumptech.glide.load.c, WeakReference<h<?>>> paramMap, ReferenceQueue<h<?>> paramReferenceQueue)
    {
      this.a = paramMap;
      this.b = paramReferenceQueue;
    }
    
    public boolean queueIdle()
    {
      c.e locale = (c.e)this.b.poll();
      if (locale != null) {
        this.a.remove(c.e.a(locale));
      }
      return true;
    }
  }
  
  private static class e
    extends WeakReference<h<?>>
  {
    private final com.bumptech.glide.load.c a;
    
    public e(com.bumptech.glide.load.c paramc, h<?> paramh, ReferenceQueue<? super h<?>> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.a = paramc;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */