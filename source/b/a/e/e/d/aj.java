package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.e;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class aj<T, K>
  extends a<T, T>
{
  final h<? super T, K> b;
  final Callable<? extends Collection<? super K>> c;
  
  public aj(q<T> paramq, h<? super T, K> paramh, Callable<? extends Collection<? super K>> paramCallable)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramCallable;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    try
    {
      Collection localCollection = (Collection)b.a.e.b.b.a(this.c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.a.subscribe(new a(params, this.b, localCollection));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T, K>
    extends b.a.e.d.a<T, T>
  {
    final Collection<? super K> f;
    final h<? super T, K> g;
    
    a(s<? super T> params, h<? super T, K> paramh, Collection<? super K> paramCollection)
    {
      super();
      this.g = paramh;
      this.f = paramCollection;
    }
    
    public void clear()
    {
      this.f.clear();
      super.clear();
    }
    
    public void onComplete()
    {
      if (!this.d)
      {
        this.d = true;
        this.f.clear();
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
      this.f.clear();
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.d) {
        return;
      }
      if (this.e == 0) {
        try
        {
          Object localObject = b.a.e.b.b.a(this.g.apply(paramT), "The keySelector returned a null key");
          boolean bool = this.f.add(localObject);
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
      } while ((localObject != null) && (!this.f.add(b.a.e.b.b.a(this.g.apply(localObject), "The keySelector returned a null key"))));
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return a(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */