package d.f;

import java.util.Iterator;

public final class i<T, R>
  implements b<R>
{
  private final b<T> a;
  private final d.c.a.b<T, R> b;
  
  public i(b<? extends T> paramb, d.c.a.b<? super T, ? extends R> paramb1)
  {
    this.a = paramb;
    this.b = paramb1;
  }
  
  public Iterator<R> a()
  {
    return (Iterator)new a(this);
  }
  
  public static final class a
    implements Iterator<R>
  {
    private final Iterator<T> b;
    
    a()
    {
      this.b = i.b(locali).a();
    }
    
    public boolean hasNext()
    {
      return this.b.hasNext();
    }
    
    public R next()
    {
      return (R)i.a(this.a).invoke(this.b.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */