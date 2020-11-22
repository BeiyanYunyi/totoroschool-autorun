package com.bumptech.glide.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.e.f;
import com.bumptech.glide.f.b.j;
import com.bumptech.glide.load.b.c.c;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.l;
import java.util.Queue;

public final class a<A, T, Z, R>
  implements b, com.bumptech.glide.f.b.h, e
{
  private static final Queue<a<?, ?, ?, ?>> a = com.bumptech.glide.h.h.a(0);
  private k<?> A;
  private c.c B;
  private long C;
  private a D;
  private final String b = String.valueOf(hashCode());
  private com.bumptech.glide.load.c c;
  private Drawable d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private com.bumptech.glide.load.g<Z> i;
  private f<A, T, Z, R> j;
  private c k;
  private A l;
  private Class<R> m;
  private boolean n;
  private com.bumptech.glide.g o;
  private j<R> p;
  private d<? super A, R> q;
  private float r;
  private com.bumptech.glide.load.b.c s;
  private com.bumptech.glide.f.a.d<R> t;
  private int u;
  private int v;
  private com.bumptech.glide.load.b.b w;
  private Drawable x;
  private Drawable y;
  private boolean z;
  
  public static <A, T, Z, R> a<A, T, Z, R> a(f<A, T, Z, R> paramf, A paramA, com.bumptech.glide.load.c paramc, Context paramContext, com.bumptech.glide.g paramg, j<R> paramj, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, d<? super A, R> paramd, c paramc1, com.bumptech.glide.load.b.c paramc2, com.bumptech.glide.load.g<Z> paramg1, Class<R> paramClass, boolean paramBoolean, com.bumptech.glide.f.a.d<R> paramd1, int paramInt4, int paramInt5, com.bumptech.glide.load.b.b paramb)
  {
    a locala2 = (a)a.poll();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.b(paramf, paramA, paramc, paramContext, paramg, paramj, paramFloat, paramDrawable1, paramInt1, paramDrawable2, paramInt2, paramDrawable3, paramInt3, paramd, paramc1, paramc2, paramg1, paramClass, paramBoolean, paramd1, paramInt4, paramInt5, paramb);
    return locala1;
  }
  
  private void a(k<?> paramk, R paramR)
  {
    boolean bool = p();
    this.D = a.COMPLETE;
    this.A = paramk;
    if ((this.q == null) || (!this.q.a(paramR, this.l, this.p, this.z, bool)))
    {
      com.bumptech.glide.f.a.c localc = this.t.a(this.z, bool);
      this.p.a(paramR, localc);
    }
    q();
    if (Log.isLoggable("GenericRequest", 2))
    {
      paramR = new StringBuilder();
      paramR.append("Resource ready in ");
      paramR.append(com.bumptech.glide.h.d.a(this.C));
      paramR.append(" size: ");
      double d1 = paramk.c();
      Double.isNaN(d1);
      paramR.append(d1 * 9.5367431640625E-7D);
      paramR.append(" fromCache: ");
      paramR.append(this.z);
      a(paramR.toString());
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" this: ");
    localStringBuilder.append(this.b);
    Log.v("GenericRequest", localStringBuilder.toString());
  }
  
  private static void a(String paramString1, Object paramObject, String paramString2)
  {
    if (paramObject == null)
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.append(" must not be null");
      if (paramString2 != null)
      {
        paramString1.append(", ");
        paramString1.append(paramString2);
      }
      throw new NullPointerException(paramString1.toString());
    }
  }
  
  private void b(f<A, T, Z, R> paramf, A paramA, com.bumptech.glide.load.c paramc, Context paramContext, com.bumptech.glide.g paramg, j<R> paramj, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, d<? super A, R> paramd, c paramc1, com.bumptech.glide.load.b.c paramc2, com.bumptech.glide.load.g<Z> paramg1, Class<R> paramClass, boolean paramBoolean, com.bumptech.glide.f.a.d<R> paramd1, int paramInt4, int paramInt5, com.bumptech.glide.load.b.b paramb)
  {
    this.j = paramf;
    this.l = paramA;
    this.c = paramc;
    this.d = paramDrawable3;
    this.e = paramInt3;
    this.h = paramContext.getApplicationContext();
    this.o = paramg;
    this.p = paramj;
    this.r = paramFloat;
    this.x = paramDrawable1;
    this.f = paramInt1;
    this.y = paramDrawable2;
    this.g = paramInt2;
    this.q = paramd;
    this.k = paramc1;
    this.s = paramc2;
    this.i = paramg1;
    this.m = paramClass;
    this.n = paramBoolean;
    this.t = paramd1;
    this.u = paramInt4;
    this.v = paramInt5;
    this.w = paramb;
    this.D = a.PENDING;
    if (paramA != null)
    {
      a("ModelLoader", paramf.e(), "try .using(ModelLoader)");
      a("Transcoder", paramf.f(), "try .as*(Class).transcode(ResourceTranscoder)");
      a("Transformation", paramg1, "try .transform(UnitTransformation.get())");
      if (paramb.cacheSource()) {
        a("SourceEncoder", paramf.c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
      } else {
        a("SourceDecoder", paramf.b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
      }
      if ((paramb.cacheSource()) || (paramb.cacheResult())) {
        a("CacheDecoder", paramf.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
      }
      if (paramb.cacheResult()) {
        a("Encoder", paramf.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
      }
    }
  }
  
  private void b(k paramk)
  {
    this.s.a(paramk);
    this.A = null;
  }
  
  private void b(Exception paramException)
  {
    if (!o()) {
      return;
    }
    if (this.l == null) {
      localObject2 = k();
    } else {
      localObject2 = null;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = l();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = m();
    }
    this.p.a(paramException, (Drawable)localObject2);
  }
  
  private Drawable k()
  {
    if ((this.d == null) && (this.e > 0)) {
      this.d = this.h.getResources().getDrawable(this.e);
    }
    return this.d;
  }
  
  private Drawable l()
  {
    if ((this.y == null) && (this.g > 0)) {
      this.y = this.h.getResources().getDrawable(this.g);
    }
    return this.y;
  }
  
  private Drawable m()
  {
    if ((this.x == null) && (this.f > 0)) {
      this.x = this.h.getResources().getDrawable(this.f);
    }
    return this.x;
  }
  
  private boolean n()
  {
    return (this.k == null) || (this.k.a(this));
  }
  
  private boolean o()
  {
    return (this.k == null) || (this.k.b(this));
  }
  
  private boolean p()
  {
    return (this.k == null) || (!this.k.c());
  }
  
  private void q()
  {
    if (this.k != null) {
      this.k.c(this);
    }
  }
  
  public void a()
  {
    this.j = null;
    this.l = null;
    this.h = null;
    this.p = null;
    this.x = null;
    this.y = null;
    this.d = null;
    this.q = null;
    this.k = null;
    this.i = null;
    this.t = null;
    this.z = false;
    this.B = null;
    a.offer(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Log.isLoggable("GenericRequest", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Got onSizeReady in ");
      ((StringBuilder)localObject).append(com.bumptech.glide.h.d.a(this.C));
      a(((StringBuilder)localObject).toString());
    }
    if (this.D != a.WAITING_FOR_SIZE) {
      return;
    }
    this.D = a.RUNNING;
    paramInt1 = Math.round(this.r * paramInt1);
    paramInt2 = Math.round(this.r * paramInt2);
    Object localObject = this.j.e().a(this.l, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to load model: '");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append("'");
      a(new Exception(((StringBuilder)localObject).toString()));
      return;
    }
    com.bumptech.glide.load.resource.e.c localc = this.j.f();
    if (Log.isLoggable("GenericRequest", 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finished setup for calling load in ");
      localStringBuilder.append(com.bumptech.glide.h.d.a(this.C));
      a(localStringBuilder.toString());
    }
    boolean bool = true;
    this.z = true;
    this.B = this.s.a(this.c, paramInt1, paramInt2, (com.bumptech.glide.load.a.c)localObject, this.j, this.i, localc, this.o, this.n, this.w, this);
    if (this.A == null) {
      bool = false;
    }
    this.z = bool;
    if (Log.isLoggable("GenericRequest", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finished onSizeReady in ");
      ((StringBuilder)localObject).append(com.bumptech.glide.h.d.a(this.C));
      a(((StringBuilder)localObject).toString());
    }
  }
  
  public void a(k<?> paramk)
  {
    if (paramk == null)
    {
      paramk = new StringBuilder();
      paramk.append("Expected to receive a Resource<R> with an object of ");
      paramk.append(this.m);
      paramk.append(" inside, but instead got null.");
      a(new Exception(paramk.toString()));
      return;
    }
    Object localObject2 = paramk.b();
    if ((localObject2 != null) && (this.m.isAssignableFrom(localObject2.getClass())))
    {
      if (!n())
      {
        b(paramk);
        this.D = a.COMPLETE;
        return;
      }
      a(paramk, localObject2);
      return;
    }
    b(paramk);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to receive an object of ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" but instead got ");
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = localObject2.getClass();
    } else {
      localObject1 = "";
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append("{");
    localStringBuilder.append(localObject2);
    localStringBuilder.append("}");
    localStringBuilder.append(" inside Resource{");
    localStringBuilder.append(paramk);
    localStringBuilder.append("}.");
    if (localObject2 != null) {
      paramk = "";
    } else {
      paramk = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
    }
    localStringBuilder.append(paramk);
    a(new Exception(localStringBuilder.toString()));
  }
  
  public void a(Exception paramException)
  {
    if (Log.isLoggable("GenericRequest", 3)) {
      Log.d("GenericRequest", "load failed", paramException);
    }
    this.D = a.FAILED;
    if ((this.q == null) || (!this.q.a(paramException, this.l, this.p, p()))) {
      b(paramException);
    }
  }
  
  public void b()
  {
    this.C = com.bumptech.glide.h.d.a();
    if (this.l == null)
    {
      a(null);
      return;
    }
    this.D = a.WAITING_FOR_SIZE;
    if (com.bumptech.glide.h.h.a(this.u, this.v)) {
      a(this.u, this.v);
    } else {
      this.p.a(this);
    }
    if ((!g()) && (!j()) && (o())) {
      this.p.c(m());
    }
    if (Log.isLoggable("GenericRequest", 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finished run method in ");
      localStringBuilder.append(com.bumptech.glide.h.d.a(this.C));
      a(localStringBuilder.toString());
    }
  }
  
  void c()
  {
    this.D = a.CANCELLED;
    if (this.B != null)
    {
      this.B.a();
      this.B = null;
    }
  }
  
  public void d()
  {
    
    if (this.D == a.CLEARED) {
      return;
    }
    c();
    if (this.A != null) {
      b(this.A);
    }
    if (o()) {
      this.p.b(m());
    }
    this.D = a.CLEARED;
  }
  
  public void e()
  {
    d();
    this.D = a.PAUSED;
  }
  
  public boolean f()
  {
    return (this.D == a.RUNNING) || (this.D == a.WAITING_FOR_SIZE);
  }
  
  public boolean g()
  {
    return this.D == a.COMPLETE;
  }
  
  public boolean h()
  {
    return g();
  }
  
  public boolean i()
  {
    return (this.D == a.CANCELLED) || (this.D == a.CLEARED);
  }
  
  public boolean j()
  {
    return this.D == a.FAILED;
  }
  
  private static enum a
  {
    static
    {
      COMPLETE = new a("COMPLETE", 3);
      FAILED = new a("FAILED", 4);
    }
    
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */