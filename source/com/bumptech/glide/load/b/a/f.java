package com.bumptech.glide.load.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class f
  implements c
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private final g b;
  private final Set<Bitmap.Config> c;
  private final int d;
  private final a e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public f(int paramInt)
  {
    this(paramInt, e(), f());
  }
  
  f(int paramInt, g paramg, Set<Bitmap.Config> paramSet)
  {
    this.d = paramInt;
    this.f = paramInt;
    this.b = paramg;
    this.c = paramSet;
    this.e = new b(null);
  }
  
  private void b()
  {
    b(this.f);
  }
  
  private void b(int paramInt)
  {
    try
    {
      while (this.g > paramInt)
      {
        Bitmap localBitmap = this.b.a();
        if (localBitmap == null)
        {
          if (Log.isLoggable("LruBitmapPool", 5))
          {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            d();
          }
          this.g = 0;
          return;
        }
        this.e.b(localBitmap);
        this.g -= this.b.c(localBitmap);
        localBitmap.recycle();
        this.k += 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Evicting bitmap=");
          localStringBuilder.append(this.b.b(localBitmap));
          Log.d("LruBitmapPool", localStringBuilder.toString());
        }
        c();
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      d();
    }
  }
  
  private void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hits=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", misses=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", puts=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", evictions=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", currentSize=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", maxSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nStrategy=");
    localStringBuilder.append(this.b);
    Log.v("LruBitmapPool", localStringBuilder.toString());
  }
  
  private static g e()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new i();
    }
    return new a();
  }
  
  private static Set<Bitmap.Config> f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(Arrays.asList(Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19) {
      localHashSet.add(null);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = b(paramInt1, paramInt2, paramConfig);
      if (paramConfig != null) {
        paramConfig.eraseColor(0);
      }
      return paramConfig;
    }
    finally {}
  }
  
  public void a()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    b(0);
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimMemory, level=");
      localStringBuilder.append(paramInt);
      Log.d("LruBitmapPool", localStringBuilder.toString());
    }
    if (paramInt >= 60)
    {
      a();
      return;
    }
    if (paramInt >= 40) {
      b(this.f / 2);
    }
  }
  
  public boolean a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      StringBuilder localStringBuilder;
      if ((paramBitmap.isMutable()) && (this.b.c(paramBitmap) <= this.f) && (this.c.contains(paramBitmap.getConfig())))
      {
        int m = this.b.c(paramBitmap);
        this.b.a(paramBitmap);
        this.e.a(paramBitmap);
        this.j += 1;
        this.g += m;
        if (Log.isLoggable("LruBitmapPool", 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Put bitmap in pool=");
          localStringBuilder.append(this.b.b(paramBitmap));
          Log.v("LruBitmapPool", localStringBuilder.toString());
        }
        c();
        b();
        return true;
      }
      if (Log.isLoggable("LruBitmapPool", 2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Reject bitmap from pool, bitmap: ");
        localStringBuilder.append(this.b.b(paramBitmap));
        localStringBuilder.append(", is mutable: ");
        localStringBuilder.append(paramBitmap.isMutable());
        localStringBuilder.append(", is allowed config: ");
        localStringBuilder.append(this.c.contains(paramBitmap.getConfig()));
        Log.v("LruBitmapPool", localStringBuilder.toString());
      }
      return false;
    }
    finally {}
    throw new NullPointerException("Bitmap must not be null");
  }
  
  @TargetApi(12)
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Object localObject2 = this.b;
      if (paramConfig != null) {
        localObject1 = paramConfig;
      } else {
        localObject1 = a;
      }
      Object localObject1 = ((g)localObject2).a(paramInt1, paramInt2, (Bitmap.Config)localObject1);
      if (localObject1 == null)
      {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Missing bitmap=");
          ((StringBuilder)localObject2).append(this.b.b(paramInt1, paramInt2, paramConfig));
          Log.d("LruBitmapPool", ((StringBuilder)localObject2).toString());
        }
        this.i += 1;
      }
      else
      {
        this.h += 1;
        this.g -= this.b.c((Bitmap)localObject1);
        this.e.b((Bitmap)localObject1);
        if (Build.VERSION.SDK_INT >= 12) {
          ((Bitmap)localObject1).setHasAlpha(true);
        }
      }
      if (Log.isLoggable("LruBitmapPool", 2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Get bitmap=");
        ((StringBuilder)localObject2).append(this.b.b(paramInt1, paramInt2, paramConfig));
        Log.v("LruBitmapPool", ((StringBuilder)localObject2).toString());
      }
      c();
      return (Bitmap)localObject1;
    }
    finally {}
  }
  
  private static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
    
    public abstract void b(Bitmap paramBitmap);
  }
  
  private static class b
    implements f.a
  {
    public void a(Bitmap paramBitmap) {}
    
    public void b(Bitmap paramBitmap) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */