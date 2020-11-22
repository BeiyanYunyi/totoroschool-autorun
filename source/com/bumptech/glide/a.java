package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.f.b.j;
import com.bumptech.glide.load.resource.bitmap.d;
import com.bumptech.glide.manager.m;

public class a<ModelType>
  extends c<ModelType, com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a, com.bumptech.glide.load.resource.a.b>
{
  a(Context paramContext, Class<ModelType> paramClass, com.bumptech.glide.e.f<ModelType, com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a, com.bumptech.glide.load.resource.a.b> paramf, e parame, m paramm, com.bumptech.glide.manager.g paramg)
  {
    super(paramContext, paramClass, paramf, com.bumptech.glide.load.resource.a.b.class, parame, paramm, paramg);
    c();
  }
  
  public a<ModelType> a()
  {
    return b(new com.bumptech.glide.load.g[] { this.c.c() });
  }
  
  public a<ModelType> a(int paramInt)
  {
    super.b(paramInt);
    return this;
  }
  
  public a<ModelType> a(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    return this;
  }
  
  public a<ModelType> a(com.bumptech.glide.load.b.b paramb)
  {
    super.b(paramb);
    return this;
  }
  
  public a<ModelType> a(com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> paramb)
  {
    super.b(paramb);
    return this;
  }
  
  public a<ModelType> a(com.bumptech.glide.load.c paramc)
  {
    super.b(paramc);
    return this;
  }
  
  public a<ModelType> a(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a> parame)
  {
    super.b(parame);
    return this;
  }
  
  public a<ModelType> a(ModelType paramModelType)
  {
    super.b(paramModelType);
    return this;
  }
  
  public a<ModelType> a(boolean paramBoolean)
  {
    super.b(paramBoolean);
    return this;
  }
  
  public a<ModelType> a(com.bumptech.glide.load.g<Bitmap>... paramVarArgs)
  {
    com.bumptech.glide.load.resource.d.f[] arrayOff = new com.bumptech.glide.load.resource.d.f[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOff[i] = new com.bumptech.glide.load.resource.d.f(this.c.a(), paramVarArgs[i]);
      i += 1;
    }
    return b(arrayOff);
  }
  
  public a<ModelType> a(d... paramVarArgs)
  {
    return a(paramVarArgs);
  }
  
  public j<com.bumptech.glide.load.resource.a.b> a(ImageView paramImageView)
  {
    return super.a(paramImageView);
  }
  
  public a<ModelType> b()
  {
    return b(new com.bumptech.glide.load.g[] { this.c.d() });
  }
  
  public a<ModelType> b(com.bumptech.glide.load.g<com.bumptech.glide.load.resource.d.a>... paramVarArgs)
  {
    super.c(paramVarArgs);
    return this;
  }
  
  public final a<ModelType> c()
  {
    super.a(new com.bumptech.glide.f.a.a());
    return this;
  }
  
  public a<ModelType> d()
  {
    super.i();
    return this;
  }
  
  public a<ModelType> e()
  {
    return (a)super.h();
  }
  
  void f()
  {
    b();
  }
  
  void g()
  {
    a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */