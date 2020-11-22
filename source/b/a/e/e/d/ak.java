package b.a.e.e.d;

import b.a.d.d;
import b.a.d.h;
import b.a.e.c.b;
import b.a.q;
import b.a.s;

public final class ak<T, K>
  extends a<T, T>
{
  final h<? super T, K> b;
  final d<? super K, ? super K> c;
  
  public ak(q<T> paramq, h<? super T, K> paramh, d<? super K, ? super K> paramd)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramd;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c));
  }
  
  static final class a<T, K>
    extends b.a.e.d.a<T, T>
  {
    final h<? super T, K> f;
    final d<? super K, ? super K> g;
    K h;
    boolean i;
    
    a(s<? super T> params, h<? super T, K> paramh, d<? super K, ? super K> paramd)
    {
      super();
      this.f = paramh;
      this.g = paramd;
    }
    
    public void onNext(T paramT)
    {
      if (this.d) {
        return;
      }
      if (this.e != 0)
      {
        this.a.onNext(paramT);
        return;
      }
      try
      {
        Object localObject = this.f.apply(paramT);
        if (this.i)
        {
          boolean bool = this.g.a(this.h, localObject);
          this.h = localObject;
          if (!bool) {}
        }
        else
        {
          this.i = true;
          this.h = localObject;
        }
        this.a.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        a(paramT);
      }
    }
    
    public T poll()
      throws Exception
    {
      for (;;)
      {
        Object localObject1 = this.c.poll();
        if (localObject1 == null) {
          return null;
        }
        Object localObject2 = this.f.apply(localObject1);
        if (!this.i)
        {
          this.i = true;
          this.h = localObject2;
          return (T)localObject1;
        }
        if (!this.g.a(this.h, localObject2))
        {
          this.h = localObject2;
          return (T)localObject1;
        }
        this.h = localObject2;
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return a(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */