package b.a.e.j;

import b.a.d.q;
import b.a.s;

public class a<T>
{
  final int a;
  final Object[] b;
  Object[] c;
  int d;
  
  public a(int paramInt)
  {
    this.a = paramInt;
    this.b = new Object[paramInt + 1];
    this.c = this.b;
  }
  
  public void a(a<? super T> parama)
  {
    Object[] arrayOfObject = this.b;
    int j = this.a;
    while (arrayOfObject != null)
    {
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfObject[i];
        if (localObject == null) {
          break;
        }
        if (parama.a(localObject)) {
          return;
        }
        i += 1;
      }
      arrayOfObject = (Object[])arrayOfObject[j];
    }
  }
  
  public void a(T paramT)
  {
    int k = this.a;
    int j = this.d;
    int i = j;
    if (j == k)
    {
      Object[] arrayOfObject = new Object[k + 1];
      this.c[k] = arrayOfObject;
      this.c = arrayOfObject;
      i = 0;
    }
    this.c[i] = paramT;
    this.d = (i + 1);
  }
  
  public <U> boolean a(s<? super U> params)
  {
    Object[] arrayOfObject = this.b;
    int j = this.a;
    for (;;)
    {
      int i = 0;
      if (arrayOfObject == null) {
        break;
      }
      while (i < j)
      {
        Object localObject = arrayOfObject[i];
        if (localObject == null) {
          break;
        }
        if (n.acceptFull(localObject, params)) {
          return true;
        }
        i += 1;
      }
      arrayOfObject = (Object[])arrayOfObject[j];
    }
    return false;
  }
  
  public void b(T paramT)
  {
    this.b[0] = paramT;
  }
  
  public static abstract interface a<T>
    extends q<T>
  {
    public abstract boolean a(T paramT);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */