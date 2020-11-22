package com.bumptech.glide.manager;

import com.bumptech.glide.f.b;
import com.bumptech.glide.h.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class m
{
  private final Set<b> a = Collections.newSetFromMap(new WeakHashMap());
  private final List<b> b = new ArrayList();
  private boolean c;
  
  public void a()
  {
    this.c = true;
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.f())
      {
        localb.e();
        this.b.add(localb);
      }
    }
  }
  
  public void a(b paramb)
  {
    this.a.add(paramb);
    if (!this.c)
    {
      paramb.b();
      return;
    }
    this.b.add(paramb);
  }
  
  public void b()
  {
    this.c = false;
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!localb.g()) && (!localb.i()) && (!localb.f())) {
        localb.b();
      }
    }
    this.b.clear();
  }
  
  public void b(b paramb)
  {
    this.a.remove(paramb);
    this.b.remove(paramb);
  }
  
  public void c()
  {
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).d();
    }
    this.b.clear();
  }
  
  public void d()
  {
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!localb.g()) && (!localb.i()))
      {
        localb.e();
        if (!this.c) {
          localb.b();
        } else {
          this.b.add(localb);
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */