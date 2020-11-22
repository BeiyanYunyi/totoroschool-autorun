package b.a.e.d;

import b.a.e.a.d;
import b.a.s;

public abstract class a<T, R>
  implements b.a.e.c.b<R>, s<T>
{
  protected final s<? super R> a;
  protected b.a.b.b b;
  protected b.a.e.c.b<T> c;
  protected boolean d;
  protected int e;
  
  public a(s<? super R> params)
  {
    this.a = params;
  }
  
  protected final int a(int paramInt)
  {
    b.a.e.c.b localb = this.c;
    if ((localb != null) && ((paramInt & 0x4) == 0))
    {
      paramInt = localb.requestFusion(paramInt);
      if (paramInt != 0) {
        this.e = paramInt;
      }
      return paramInt;
    }
    return 0;
  }
  
  protected final void a(Throwable paramThrowable)
  {
    b.a.c.b.b(paramThrowable);
    this.b.dispose();
    onError(paramThrowable);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b() {}
  
  public void clear()
  {
    this.c.clear();
  }
  
  public void dispose()
  {
    this.b.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.b.isDisposed();
  }
  
  public boolean isEmpty()
  {
    return this.c.isEmpty();
  }
  
  public final boolean offer(R paramR)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public void onComplete()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.a.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.d)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    this.d = true;
    this.a.onError(paramThrowable);
  }
  
  public final void onSubscribe(b.a.b.b paramb)
  {
    if (d.validate(this.b, paramb))
    {
      this.b = paramb;
      if ((paramb instanceof b.a.e.c.b)) {
        this.c = ((b.a.e.c.b)paramb);
      }
      if (a())
      {
        this.a.onSubscribe(this);
        b();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */