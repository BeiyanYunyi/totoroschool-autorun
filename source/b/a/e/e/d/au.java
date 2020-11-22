package b.a.e.e.d;

import b.a.e.c.b;
import b.a.s;

public final class au<T>
  extends a<T, T>
{
  final b.a.d.q<? super T> b;
  
  public au(b.a.q<T> paramq, b.a.d.q<? super T> paramq1)
  {
    super(paramq);
    this.b = paramq1;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends b.a.e.d.a<T, T>
  {
    final b.a.d.q<? super T> f;
    
    a(s<? super T> params, b.a.d.q<? super T> paramq)
    {
      super();
      this.f = paramq;
    }
    
    public void onNext(T paramT)
    {
      if (this.e == 0) {
        try
        {
          boolean bool = this.f.a(paramT);
          if (!bool) {
            return;
          }
          this.a.onNext(paramT);
          return;
        }
        catch (Throwable paramT)
        {
          a(paramT);
          return;
        }
      } else {
        this.a.onNext(null);
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject;
      do
      {
        localObject = this.c.poll();
      } while ((localObject != null) && (!this.f.a(localObject)));
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return a(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */