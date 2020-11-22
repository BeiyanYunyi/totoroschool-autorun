package b.a.e.e.d;

import b.a.e.a.d;
import b.a.l;
import b.a.s;
import b.a.u;
import b.a.v;

public final class j<T>
  extends u<Boolean>
  implements b.a.e.c.a<Boolean>
{
  final b.a.q<T> a;
  final b.a.d.q<? super T> b;
  
  public j(b.a.q<T> paramq, b.a.d.q<? super T> paramq1)
  {
    this.a = paramq;
    this.b = paramq1;
  }
  
  protected void b(v<? super Boolean> paramv)
  {
    this.a.subscribe(new a(paramv, this.b));
  }
  
  public l<Boolean> e_()
  {
    return b.a.h.a.a(new i(this.a, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final v<? super Boolean> a;
    final b.a.d.q<? super T> b;
    b.a.b.b c;
    boolean d;
    
    a(v<? super Boolean> paramv, b.a.d.q<? super T> paramq)
    {
      this.a = paramv;
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
        this.a.onSuccess(Boolean.valueOf(false));
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
          this.a.onSuccess(Boolean.valueOf(true));
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */