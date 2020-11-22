package b.a.e.e.d;

import b.a.g;
import b.a.l;
import b.a.s;
import org.a.a;
import org.a.c;

public final class bf<T>
  extends l<T>
{
  final a<? extends T> a;
  
  public bf(a<? extends T> parama)
  {
    this.a = parama;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.a(new a(params));
  }
  
  static final class a<T>
    implements b.a.b.b, g<T>
  {
    final s<? super T> a;
    c b;
    
    a(s<? super T> params)
    {
      this.a = params;
    }
    
    public void dispose()
    {
      this.b.cancel();
      this.b = b.a.e.i.b.CANCELLED;
    }
    
    public boolean isDisposed()
    {
      return this.b == b.a.e.i.b.CANCELLED;
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      if (b.a.e.i.b.validate(this.b, paramc))
      {
        this.b = paramc;
        this.a.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */