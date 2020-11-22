package b.a.e.a;

import b.a.c.a;
import b.a.e.j.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements b.a.b.b, c
{
  List<b.a.b.b> a;
  volatile boolean b;
  
  void a(List<b.a.b.b> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<b.a.b.b>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (b.a.b.b)localIterator.next();
      try
      {
        ((b.a.b.b)localObject).dispose();
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localThrowable);
        paramList = (List<b.a.b.b>)localObject;
      }
    }
    if (paramList != null)
    {
      if (paramList.size() == 1) {
        throw j.a((Throwable)paramList.get(0));
      }
      throw new a(paramList);
    }
  }
  
  public boolean a(b.a.b.b paramb)
  {
    b.a.e.b.b.a(paramb, "d is null");
    if (!this.b) {
      try
      {
        if (!this.b)
        {
          List localList = this.a;
          Object localObject = localList;
          if (localList == null)
          {
            localObject = new LinkedList();
            this.a = ((List)localObject);
          }
          ((List)localObject).add(paramb);
          return true;
        }
      }
      finally {}
    }
    paramb.dispose();
    return false;
  }
  
  public boolean b(b.a.b.b paramb)
  {
    if (c(paramb))
    {
      paramb.dispose();
      return true;
    }
    return false;
  }
  
  public boolean c(b.a.b.b paramb)
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
      List localList = this.a;
      return (localList != null) && (localList.remove(paramb));
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
      List localList = this.a;
      this.a = null;
      a(localList);
      return;
    }
    finally {}
  }
  
  public boolean isDisposed()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */