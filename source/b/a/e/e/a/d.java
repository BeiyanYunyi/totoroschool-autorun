package b.a.e.e.a;

import b.a.f;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;

public final class d<T>
  extends a<T, T>
  implements b.a.d.g<T>
{
  final b.a.d.g<? super T> c = this;
  
  public d(f<T> paramf)
  {
    super(paramf);
  }
  
  public void accept(T paramT) {}
  
  protected void b(org.a.b<? super T> paramb)
  {
    this.b.a(new a(paramb, this.c));
  }
  
  static final class a<T>
    extends AtomicLong
    implements b.a.g<T>, c
  {
    private static final long serialVersionUID = -6246093802440953054L;
    final org.a.b<? super T> actual;
    boolean done;
    final b.a.d.g<? super T> onDrop;
    c s;
    
    a(org.a.b<? super T> paramb, b.a.d.g<? super T> paramg)
    {
      this.actual = paramb;
      this.onDrop = paramg;
    }
    
    public void cancel()
    {
      this.s.cancel();
    }
    
    public void onComplete()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.done = true;
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      if (get() != 0L)
      {
        this.actual.onNext(paramT);
        b.a.e.j.d.b(this, 1L);
        return;
      }
      try
      {
        this.onDrop.accept(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        cancel();
        onError(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (b.a.e.i.b.validate(this.s, paramc))
      {
        this.s = paramc;
        this.actual.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public void request(long paramLong)
    {
      if (b.a.e.i.b.validate(paramLong)) {
        b.a.e.j.d.a(this, paramLong);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */