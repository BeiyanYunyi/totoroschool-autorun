package b.a.e.e.d;

import b.a.e.a.d;
import b.a.s;

public final class i<T>
  extends a<T, Boolean>
{
  final b.a.d.q<? super T> b;
  
  public i(b.a.q<T> paramq, b.a.d.q<? super T> paramq1)
  {
    super(paramq);
    this.b = paramq1;
  }
  
  protected void subscribeActual(s<? super Boolean> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final s<? super Boolean> a;
    final b.a.d.q<? super T> b;
    b.a.b.b c;
    boolean d;
    
    a(s<? super Boolean> params, b.a.d.q<? super T> paramq)
    {
      this.a = params;
      this.b = paramq;
    }
    
    public void dispose()
    {
      this.c.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.c.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.d)
      {
        this.d = true;
        this.a.onNext(Boolean.valueOf(false));
        this.a.onComplete();
      }
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
    
    public void onNext(T paramT)
    {
      if (this.d) {
        return;
      }
      try
      {
        boolean bool = this.b.a(paramT);
        if (bool)
        {
          this.d = true;
          this.c.dispose();
          this.a.onNext(Boolean.valueOf(true));
          this.a.onComplete();
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.c.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */