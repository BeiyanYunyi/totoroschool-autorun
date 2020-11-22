package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import java.util.NoSuchElementException;

public final class ap<T>
  extends a<T, T>
{
  final long b;
  final T c;
  final boolean d;
  
  public ap(q<T> paramq, long paramLong, T paramT, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramT;
    this.d = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final s<? super T> a;
    final long b;
    final T c;
    final boolean d;
    b e;
    long f;
    boolean g;
    
    a(s<? super T> params, long paramLong, T paramT, boolean paramBoolean)
    {
      this.a = params;
      this.b = paramLong;
      this.c = paramT;
      this.d = paramBoolean;
    }
    
    public void dispose()
    {
      this.e.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.e.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.g)
      {
        this.g = true;
        Object localObject = this.c;
        if ((localObject == null) && (this.d))
        {
          this.a.onError(new NoSuchElementException());
          return;
        }
        if (localObject != null) {
          this.a.onNext(localObject);
        }
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.g)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.g = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.g) {
        return;
      }
      long l = this.f;
      if (l == this.b)
      {
        this.g = true;
        this.e.dispose();
        this.a.onNext(paramT);
        this.a.onComplete();
        return;
      }
      this.f = (l + 1L);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.e, paramb))
      {
        this.e = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */