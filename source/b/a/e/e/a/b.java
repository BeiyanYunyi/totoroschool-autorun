package b.a.e.e.a;

import b.a.f;
import b.a.l;
import b.a.s;
import org.a.c;

public final class b<T>
  extends f<T>
{
  private final l<T> b;
  
  public b(l<T> paraml)
  {
    this.b = paraml;
  }
  
  protected void b(org.a.b<? super T> paramb)
  {
    this.b.subscribe(new a(paramb));
  }
  
  static class a<T>
    implements s<T>, c
  {
    private final org.a.b<? super T> a;
    private b.a.b.b b;
    
    a(org.a.b<? super T> paramb)
    {
      this.a = paramb;
    }
    
    public void cancel()
    {
      this.b.dispose();
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
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.b = paramb;
      this.a.onSubscribe(this);
    }
    
    public void request(long paramLong) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */