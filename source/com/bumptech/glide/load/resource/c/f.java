package com.bumptech.glide.load.resource.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
import com.bumptech.glide.h.b;
import com.bumptech.glide.h.b.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

class f
{
  private final b a;
  private final com.bumptech.glide.b.a b;
  private final Handler c;
  private boolean d = false;
  private boolean e = false;
  private com.bumptech.glide.c<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> f;
  private a g;
  private boolean h;
  
  public f(Context paramContext, b paramb, com.bumptech.glide.b.a parama, int paramInt1, int paramInt2)
  {
    this(paramb, parama, null, a(paramContext, parama, paramInt1, paramInt2, e.a(paramContext).a()));
  }
  
  f(b paramb, com.bumptech.glide.b.a parama, Handler paramHandler, com.bumptech.glide.c<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> paramc)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper(), new c(null));
    }
    this.a = paramb;
    this.b = parama;
    this.c = localHandler;
    this.f = paramc;
  }
  
  private static com.bumptech.glide.c<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> a(Context paramContext, com.bumptech.glide.b.a parama, int paramInt1, int paramInt2, com.bumptech.glide.load.b.a.c paramc)
  {
    paramc = new h(paramc);
    g localg = new g();
    com.bumptech.glide.load.b localb = com.bumptech.glide.load.resource.a.b();
    return e.b(paramContext).a(localg, com.bumptech.glide.b.a.class).a(parama).a(Bitmap.class).b(localb).b(paramc).b(true).b(com.bumptech.glide.load.b.b.NONE).b(paramInt1, paramInt2);
  }
  
  private void e()
  {
    if (this.d)
    {
      if (this.e) {
        return;
      }
      this.e = true;
      this.b.a();
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.b.b();
      a locala = new a(this.c, this.b.d(), l1 + l2);
      this.f.b(new d()).a(locala);
      return;
    }
  }
  
  public void a()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.h = false;
    e();
  }
  
  public void a(com.bumptech.glide.load.g<Bitmap> paramg)
  {
    if (paramg != null)
    {
      this.f = this.f.c(new com.bumptech.glide.load.g[] { paramg });
      return;
    }
    throw new NullPointerException("Transformation must not be null");
  }
  
  void a(a parama)
  {
    if (this.h)
    {
      this.c.obtainMessage(2, parama).sendToTarget();
      return;
    }
    a locala = this.g;
    this.g = parama;
    this.a.b(a.a(parama));
    if (locala != null) {
      this.c.obtainMessage(2, locala).sendToTarget();
    }
    this.e = false;
    e();
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void c()
  {
    b();
    if (this.g != null)
    {
      e.a(this.g);
      this.g = null;
    }
    this.h = true;
  }
  
  public Bitmap d()
  {
    if (this.g != null) {
      return this.g.a();
    }
    return null;
  }
  
  static class a
    extends com.bumptech.glide.f.b.g<Bitmap>
  {
    private final Handler a;
    private final int b;
    private final long c;
    private Bitmap d;
    
    public a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.a = paramHandler;
      this.b = paramInt;
      this.c = paramLong;
    }
    
    public Bitmap a()
    {
      return this.d;
    }
    
    public void a(Bitmap paramBitmap, com.bumptech.glide.f.a.c<? super Bitmap> paramc)
    {
      this.d = paramBitmap;
      paramBitmap = this.a.obtainMessage(1, this);
      this.a.sendMessageAtTime(paramBitmap, this.c);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(int paramInt);
  }
  
  private class c
    implements Handler.Callback
  {
    private c() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        paramMessage = (f.a)paramMessage.obj;
        f.this.a(paramMessage);
        return true;
      }
      if (paramMessage.what == 2) {
        e.a((f.a)paramMessage.obj);
      }
      return false;
    }
  }
  
  static class d
    implements com.bumptech.glide.load.c
  {
    private final UUID a;
    
    public d()
    {
      this(UUID.randomUUID());
    }
    
    d(UUID paramUUID)
    {
      this.a = paramUUID;
    }
    
    public void a(MessageDigest paramMessageDigest)
      throws UnsupportedEncodingException
    {
      throw new UnsupportedOperationException("Not implemented");
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d)) {
        return ((d)paramObject).a.equals(this.a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */