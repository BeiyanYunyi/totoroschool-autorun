package com.bumptech.glide.load.b.a;

import java.util.Queue;

abstract class b<T extends h>
{
  private final Queue<T> a = com.bumptech.glide.h.h.a(20);
  
  public void a(T paramT)
  {
    if (this.a.size() < 20) {
      this.a.offer(paramT);
    }
  }
  
  protected abstract T b();
  
  protected T c()
  {
    h localh2 = (h)this.a.poll();
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = b();
    }
    return localh1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */