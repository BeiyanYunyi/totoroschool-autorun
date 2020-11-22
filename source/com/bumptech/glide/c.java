package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.f.b.j;
import com.bumptech.glide.h.h;
import com.bumptech.glide.manager.m;

public class c<ModelType, DataType, ResourceType, TranscodeType>
  implements Cloneable
{
  private boolean A;
  private Drawable B;
  private int C;
  protected final Class<ModelType> a;
  protected final Context b;
  protected final e c;
  protected final Class<TranscodeType> d;
  protected final m e;
  protected final com.bumptech.glide.manager.g f;
  private com.bumptech.glide.e.a<ModelType, DataType, ResourceType, TranscodeType> g;
  private ModelType h;
  private com.bumptech.glide.load.c i = com.bumptech.glide.g.b.a();
  private boolean j;
  private int k;
  private int l;
  private com.bumptech.glide.f.d<? super ModelType, TranscodeType> m;
  private Float n;
  private c<?, ?, ?, TranscodeType> o;
  private Float p = Float.valueOf(1.0F);
  private Drawable q;
  private Drawable r;
  private g s;
  private boolean t;
  private com.bumptech.glide.f.a.d<TranscodeType> u;
  private int v;
  private int w;
  private com.bumptech.glide.load.b.b x;
  private com.bumptech.glide.load.g<ResourceType> y;
  private boolean z;
  
  c(Context paramContext, Class<ModelType> paramClass, com.bumptech.glide.e.f<ModelType, DataType, ResourceType, TranscodeType> paramf, Class<TranscodeType> paramClass1, e parame, m paramm, com.bumptech.glide.manager.g paramg)
  {
    Object localObject = null;
    this.s = null;
    this.t = true;
    this.u = com.bumptech.glide.f.a.e.a();
    this.v = -1;
    this.w = -1;
    this.x = com.bumptech.glide.load.b.b.RESULT;
    this.y = com.bumptech.glide.load.resource.d.b();
    this.b = paramContext;
    this.a = paramClass;
    this.d = paramClass1;
    this.c = parame;
    this.e = paramm;
    this.f = paramg;
    paramClass1 = (Class<TranscodeType>)localObject;
    if (paramf != null) {
      paramClass1 = new com.bumptech.glide.e.a(paramf);
    }
    this.g = paramClass1;
    if (paramContext != null)
    {
      if (paramClass != null)
      {
        if (paramf != null) {
          return;
        }
        throw new NullPointerException("LoadProvider must not be null");
      }
      return;
    }
    throw new NullPointerException("Context can't be null");
  }
  
  private com.bumptech.glide.f.b a(j<TranscodeType> paramj, float paramFloat, g paramg, com.bumptech.glide.f.c paramc)
  {
    return com.bumptech.glide.f.a.a(this.g, this.h, this.i, this.b, paramg, paramj, paramFloat, this.q, this.k, this.r, this.l, this.B, this.C, this.m, paramc, this.c.b(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
  }
  
  private com.bumptech.glide.f.b a(j<TranscodeType> paramj, com.bumptech.glide.f.f paramf)
  {
    if (this.o != null)
    {
      if (!this.A)
      {
        if (this.o.u.equals(com.bumptech.glide.f.a.e.a())) {
          this.o.u = this.u;
        }
        if (this.o.s == null) {
          this.o.s = a();
        }
        if ((h.a(this.w, this.v)) && (!h.a(this.o.w, this.o.v))) {
          this.o.b(this.w, this.v);
        }
        paramf = new com.bumptech.glide.f.f(paramf);
        com.bumptech.glide.f.b localb = a(paramj, this.p.floatValue(), this.s, paramf);
        this.A = true;
        paramj = this.o.a(paramj, paramf);
        this.A = false;
        paramf.a(localb, paramj);
        return paramf;
      }
      throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    }
    if (this.n != null)
    {
      paramf = new com.bumptech.glide.f.f(paramf);
      paramf.a(a(paramj, this.p.floatValue(), this.s, paramf), a(paramj, this.n.floatValue(), a(), paramf));
      return paramf;
    }
    return a(paramj, this.p.floatValue(), this.s, paramf);
  }
  
  private g a()
  {
    if (this.s == g.LOW) {
      return g.NORMAL;
    }
    if (this.s == g.NORMAL) {
      return g.HIGH;
    }
    return g.IMMEDIATE;
  }
  
  private com.bumptech.glide.f.b b(j<TranscodeType> paramj)
  {
    if (this.s == null) {
      this.s = g.NORMAL;
    }
    return a(paramj, null);
  }
  
  c<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.f.a.d<TranscodeType> paramd)
  {
    if (paramd != null)
    {
      this.u = paramd;
      return this;
    }
    throw new NullPointerException("Animation factory must not be null!");
  }
  
  public j<TranscodeType> a(ImageView paramImageView)
  {
    
    if (paramImageView != null)
    {
      if ((!this.z) && (paramImageView.getScaleType() != null)) {
        switch (1.a[paramImageView.getScaleType().ordinal()])
        {
        default: 
          break;
        case 2: 
        case 3: 
        case 4: 
          f();
          break;
        case 1: 
          g();
        }
      }
      return a(this.c.a(paramImageView, this.d));
    }
    throw new IllegalArgumentException("You must pass in a non null View");
  }
  
  public <Y extends j<TranscodeType>> Y a(Y paramY)
  {
    
    if (paramY != null)
    {
      if (this.j)
      {
        com.bumptech.glide.f.b localb = paramY.c();
        if (localb != null)
        {
          localb.d();
          this.e.b(localb);
          localb.a();
        }
        localb = b(paramY);
        paramY.a(localb);
        this.f.a(paramY);
        this.e.a(localb);
        return paramY;
      }
      throw new IllegalArgumentException("You must first set a model (try #load())");
    }
    throw new IllegalArgumentException("You must pass in a non null Target");
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(int paramInt1, int paramInt2)
  {
    if (h.a(paramInt1, paramInt2))
    {
      this.w = paramInt1;
      this.v = paramInt2;
      return this;
    }
    throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.b.b paramb)
  {
    this.x = paramb;
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.b<DataType> paramb)
  {
    if (this.g != null) {
      this.g.a(paramb);
    }
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.c paramc)
  {
    if (paramc != null)
    {
      this.i = paramc;
      return this;
    }
    throw new NullPointerException("Signature must not be null");
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(com.bumptech.glide.load.e<DataType, ResourceType> parame)
  {
    if (this.g != null) {
      this.g.a(parame);
    }
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(ModelType paramModelType)
  {
    this.h = paramModelType;
    this.j = true;
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> b(boolean paramBoolean)
  {
    this.t = (paramBoolean ^ true);
    return this;
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> c(com.bumptech.glide.load.g<ResourceType>... paramVarArgs)
  {
    this.z = true;
    if (paramVarArgs.length == 1)
    {
      this.y = paramVarArgs[0];
      return this;
    }
    this.y = new com.bumptech.glide.load.d(paramVarArgs);
    return this;
  }
  
  void f() {}
  
  void g() {}
  
  public c<ModelType, DataType, ResourceType, TranscodeType> h()
  {
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        if (this.g != null)
        {
          com.bumptech.glide.e.a locala = this.g.g();
          localc.g = locala;
          return localc;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new RuntimeException(localCloneNotSupportedException);
      }
      Object localObject = null;
    }
  }
  
  public c<ModelType, DataType, ResourceType, TranscodeType> i()
  {
    return a(com.bumptech.glide.f.a.e.a());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */