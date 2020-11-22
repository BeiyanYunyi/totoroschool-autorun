package com.bumptech.glide.load.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
{
  private final Map<com.bumptech.glide.load.c, a> a = new HashMap();
  private final b b = new b(null);
  
  void a(com.bumptech.glide.load.c paramc)
  {
    try
    {
      a locala2 = (a)this.a.get(paramc);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = this.b.a();
        this.a.put(paramc, locala1);
      }
      locala1.b += 1;
      locala1.a.lock();
      return;
    }
    finally {}
  }
  
  void b(com.bumptech.glide.load.c paramc)
  {
    try
    {
      a locala = (a)this.a.get(paramc);
      int i;
      if ((locala != null) && (locala.b > 0))
      {
        i = locala.b - 1;
        locala.b = i;
        if (i == 0)
        {
          localObject = (a)this.a.remove(paramc);
          if (localObject.equals(locala))
          {
            this.b.a((a)localObject);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Removed the wrong lock, expected to remove: ");
            localStringBuilder.append(locala);
            localStringBuilder.append(", but actually removed: ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", key: ");
            localStringBuilder.append(paramc);
            throw new IllegalStateException(localStringBuilder.toString());
          }
        }
        locala.a.unlock();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot release a lock that is not held, key: ");
      ((StringBuilder)localObject).append(paramc);
      ((StringBuilder)localObject).append(", interestedThreads: ");
      if (locala == null) {
        i = 0;
      } else {
        i = locala.b;
      }
      ((StringBuilder)localObject).append(i);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    finally {}
  }
  
  private static class a
  {
    final Lock a = new ReentrantLock();
    int b;
  }
  
  private static class b
  {
    private final Queue<c.a> a = new ArrayDeque();
    
    c.a a()
    {
      synchronized (this.a)
      {
        c.a locala = (c.a)this.a.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new c.a(null);
        }
        return (c.a)???;
      }
    }
    
    void a(c.a parama)
    {
      synchronized (this.a)
      {
        if (this.a.size() < 10) {
          this.a.offer(parama);
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */