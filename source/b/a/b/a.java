package b.a.b;

import b.a.e.a.c;
import b.a.e.j.j;
import b.a.e.j.p;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements b, c
{
  p<b> a;
  volatile boolean b;
  
  public int a()
  {
    boolean bool = this.b;
    int i = 0;
    if (bool) {
      return 0;
    }
    try
    {
      if (this.b) {
        return 0;
      }
      p localp = this.a;
      if (localp != null) {
        i = localp.c();
      }
      return i;
    }
    finally {}
  }
  
  void a(p<b> paramp)
  {
    if (paramp == null) {
      return;
    }
    Object[] arrayOfObject = paramp.b();
    int j = arrayOfObject.length;
    paramp = null;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfObject[i];
      Object localObject1 = paramp;
      if ((localObject2 instanceof b)) {
        try
        {
          ((b)localObject2).dispose();
          localObject1 = paramp;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          localObject1 = paramp;
          if (paramp == null) {
            localObject1 = new ArrayList();
          }
          ((List)localObject1).add(localThrowable);
        }
      }
      i += 1;
      paramp = (p<b>)localObject1;
    }
    if (paramp != null)
    {
      if (paramp.size() == 1) {
        throw j.a((Throwable)paramp.get(0));
      }
      throw new b.a.c.a(paramp);
    }
  }
  
  public boolean a(b paramb)
  {
    b.a.e.b.b.a(paramb, "d is null");
    if (!this.b) {
      try
      {
        if (!this.b)
        {
          p localp2 = this.a;
          p localp1 = localp2;
          if (localp2 == null)
          {
            localp1 = new p();
            this.a = localp1;
          }
          localp1.a(paramb);
          return true;
        }
      }
      finally {}
    }
    paramb.dispose();
    return false;
  }
  
  public boolean b(b paramb)
  {
    if (c(paramb))
    {
      paramb.dispose();
      return true;
    }
    return false;
  }
  
  public boolean c(b paramb)
  {
    b.a.e.b.b.a(paramb, "Disposable item is null");
    if (this.b) {
      return false;
    }
    try
    {
      if (this.b) {
        return false;
      }
      p localp = this.a;
      return (localp != null) && (localp.b(paramb));
    }
    finally {}
  }
  
  public void dispose()
  {
    if (this.b) {
      return;
    }
    try
    {
      if (this.b) {
        return;
      }
      this.b = true;
      p localp = this.a;
      this.a = null;
      a(localp);
      return;
    }
    finally {}
  }
  
  public boolean isDisposed()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */