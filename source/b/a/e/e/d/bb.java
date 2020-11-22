package b.a.e.e.d;

import b.a.e.b.b;
import b.a.e.d.c;
import b.a.l;
import b.a.s;

public final class bb<T>
  extends l<T>
{
  final T[] a;
  
  public bb(T[] paramArrayOfT)
  {
    this.a = paramArrayOfT;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    a locala = new a(params, this.a);
    params.onSubscribe(locala);
    if (locala.d) {
      return;
    }
    locala.a();
  }
  
  static final class a<T>
    extends c<T>
  {
    final s<? super T> a;
    final T[] b;
    int c;
    boolean d;
    volatile boolean e;
    
    a(s<? super T> params, T[] paramArrayOfT)
    {
      this.a = params;
      this.b = paramArrayOfT;
    }
    
    void a()
    {
      Object localObject = this.b;
      int j = localObject.length;
      int i = 0;
      while ((i < j) && (!isDisposed()))
      {
        StringBuilder localStringBuilder = localObject[i];
        if (localStringBuilder == null)
        {
          localObject = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("The ");
          localStringBuilder.append(i);
          localStringBuilder.append("th element is null");
          ((s)localObject).onError(new NullPointerException(localStringBuilder.toString()));
          return;
        }
        this.a.onNext(localStringBuilder);
        i += 1;
      }
      if (!isDisposed()) {
        this.a.onComplete();
      }
    }
    
    public void clear()
    {
      this.c = this.b.length;
    }
    
    public void dispose()
    {
      this.e = true;
    }
    
    public boolean isDisposed()
    {
      return this.e;
    }
    
    public boolean isEmpty()
    {
      return this.c == this.b.length;
    }
    
    public T poll()
    {
      int i = this.c;
      Object[] arrayOfObject = this.b;
      if (i != arrayOfObject.length)
      {
        this.c = (i + 1);
        return (T)b.a(arrayOfObject[i], "The array element is null");
      }
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        this.d = true;
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */