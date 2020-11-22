package e;

import e.a.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class n
{
  private int b = 64;
  private int c = 5;
  @Nullable
  private Runnable d;
  @Nullable
  private ExecutorService e;
  private final Deque<z.a> f = new ArrayDeque();
  private final Deque<z.a> g = new ArrayDeque();
  private final Deque<z> h = new ArrayDeque();
  
  private <T> void a(Deque<T> paramDeque, T paramT)
  {
    try
    {
      if (paramDeque.remove(paramT))
      {
        paramDeque = this.d;
        if ((!c()) && (paramDeque != null)) {
          paramDeque.run();
        }
        return;
      }
      throw new AssertionError("Call wasn't in-flight!");
    }
    finally {}
  }
  
  private int c(z.a parama)
  {
    Iterator localIterator = this.g.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      z.a locala = (z.a)localIterator.next();
      if ((!locala.b().e) && (locala.a().equals(parama.a()))) {
        i += 1;
      }
    }
    return i;
  }
  
  private boolean c()
  {
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.f.iterator();
        if (localIterator.hasNext())
        {
          z.a locala = (z.a)localIterator.next();
          if (this.g.size() < this.b)
          {
            if (c(locala) >= this.c) {
              continue;
            }
            localIterator.remove();
            localArrayList.add(locala);
            this.g.add(locala);
            continue;
          }
        }
        int j = b();
        int i = 0;
        if (j > 0)
        {
          bool = true;
          j = localArrayList.size();
          if (i < j)
          {
            ((z.a)localArrayList.get(i)).a(a());
            i += 1;
            continue;
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public ExecutorService a()
  {
    try
    {
      if (this.e == null) {
        this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.e;
      return localExecutorService;
    }
    finally {}
  }
  
  void a(z.a parama)
  {
    try
    {
      this.f.add(parama);
      c();
      return;
    }
    finally {}
  }
  
  void a(z paramz)
  {
    try
    {
      this.h.add(paramz);
      return;
    }
    finally
    {
      paramz = finally;
      throw paramz;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.g.size();
      int j = this.h.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void b(z.a parama)
  {
    a(this.g, parama);
  }
  
  void b(z paramz)
  {
    a(this.h, paramz);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */