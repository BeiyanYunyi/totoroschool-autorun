package b.a.e.d;

import b.a.b.b;
import b.a.e.c.f;
import b.a.e.j.o;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class p<T, U, V>
  extends r
  implements o<U, V>, s<T>
{
  protected final s<? super V> a;
  protected final f<U> b;
  protected volatile boolean c;
  protected volatile boolean d;
  protected Throwable e;
  
  public p(s<? super V> params, f<U> paramf)
  {
    this.a = params;
    this.b = paramf;
  }
  
  public final int a(int paramInt)
  {
    return this.f.addAndGet(paramInt);
  }
  
  public void a(s<? super V> params, U paramU) {}
  
  protected final void a(U paramU, boolean paramBoolean, b paramb)
  {
    s locals = this.a;
    f localf = this.b;
    if ((this.f.get() == 0) && (this.f.compareAndSet(0, 1)))
    {
      a(locals, paramU);
      if (a(-1) != 0) {}
    }
    else
    {
      localf.offer(paramU);
      if (!c()) {
        return;
      }
    }
    b.a.e.j.r.a(localf, locals, paramBoolean, paramb, this);
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  protected final void b(U paramU, boolean paramBoolean, b paramb)
  {
    s locals = this.a;
    f localf = this.b;
    if ((this.f.get() == 0) && (this.f.compareAndSet(0, 1)))
    {
      if (localf.isEmpty())
      {
        a(locals, paramU);
        if (a(-1) != 0) {}
      }
      else
      {
        localf.offer(paramU);
      }
    }
    else
    {
      localf.offer(paramU);
      if (!c()) {
        return;
      }
    }
    b.a.e.j.r.a(localf, locals, paramBoolean, paramb, this);
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final boolean c()
  {
    return this.f.getAndIncrement() == 0;
  }
  
  public final boolean d()
  {
    return (this.f.get() == 0) && (this.f.compareAndSet(0, 1));
  }
  
  public final Throwable e()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */