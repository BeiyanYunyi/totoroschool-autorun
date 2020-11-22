package com.bumptech.glide;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.load.b.a.d;
import com.bumptech.glide.load.b.b.a.a;
import com.bumptech.glide.load.b.b.g;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.b.i;
import java.util.concurrent.ExecutorService;

public class f
{
  private final Context a;
  private com.bumptech.glide.load.b.c b;
  private com.bumptech.glide.load.b.a.c c;
  private h d;
  private ExecutorService e;
  private ExecutorService f;
  private com.bumptech.glide.load.a g;
  private a.a h;
  
  public f(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  e a()
  {
    if (this.e == null) {
      this.e = new com.bumptech.glide.load.b.c.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
    }
    if (this.f == null) {
      this.f = new com.bumptech.glide.load.b.c.a(1);
    }
    i locali = new i(this.a);
    if (this.c == null) {
      if (Build.VERSION.SDK_INT >= 11) {
        this.c = new com.bumptech.glide.load.b.a.f(locali.b());
      } else {
        this.c = new d();
      }
    }
    if (this.d == null) {
      this.d = new g(locali.a());
    }
    if (this.h == null) {
      this.h = new com.bumptech.glide.load.b.b.f(this.a);
    }
    if (this.b == null) {
      this.b = new com.bumptech.glide.load.b.c(this.d, this.h, this.f, this.e);
    }
    if (this.g == null) {
      this.g = com.bumptech.glide.load.a.DEFAULT;
    }
    return new e(this.b, this.d, this.c, this.a, this.g);
  }
  
  public f a(com.bumptech.glide.load.a parama)
  {
    this.g = parama;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */