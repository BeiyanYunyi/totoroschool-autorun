package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class a
  implements g
{
  private final Set<h> a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  void a()
  {
    this.b = true;
    Iterator localIterator = com.bumptech.glide.h.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).d();
    }
  }
  
  public void a(h paramh)
  {
    this.a.add(paramh);
    if (this.c)
    {
      paramh.f();
      return;
    }
    if (this.b)
    {
      paramh.d();
      return;
    }
    paramh.e();
  }
  
  void b()
  {
    this.b = false;
    Iterator localIterator = com.bumptech.glide.h.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).e();
    }
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = com.bumptech.glide.h.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).f();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */