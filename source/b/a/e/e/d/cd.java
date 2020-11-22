package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.g;
import b.a.q;
import b.a.s;

public final class cd<T>
  extends a<T, T>
{
  final h<? super Throwable, ? extends q<? extends T>> b;
  final boolean c;
  
  public cd(q<T> paramq, h<? super Throwable, ? extends q<? extends T>> paramh, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    a locala = new a(params, this.b, this.c);
    params.onSubscribe(locala.d);
    this.a.subscribe(locala);
  }
  
  static final class a<T>
    implements s<T>
  {
    final s<? super T> a;
    final h<? super Throwable, ? extends q<? extends T>> b;
    final boolean c;
    final g d;
    boolean e;
    boolean f;
    
    a(s<? super T> params, h<? super Throwable, ? extends q<? extends T>> paramh, boolean paramBoolean)
    {
      this.a = params;
      this.b = paramh;
      this.c = paramBoolean;
      this.d = new g();
    }
    
    public void onComplete()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      this.e = true;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        if (this.f)
        {
          b.a.h.a.a(paramThrowable);
          return;
        }
        this.a.onError(paramThrowable);
        return;
      }
      this.e = true;
      if ((this.c) && (!(paramThrowable instanceof Exception)))
      {
        this.a.onError(paramThrowable);
        return;
      }
      try
      {
        Object localObject = (q)this.b.apply(paramThrowable);
        if (localObject == null)
        {
          localObject = new NullPointerException("Observable is null");
          ((NullPointerException)localObject).initCause(paramThrowable);
          this.a.onError((Throwable)localObject);
          return;
        }
        ((q)localObject).subscribe(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.a.onError(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.f) {
        return;
      }
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.d.replace(paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */