package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j
  implements Iterable<j>
{
  private final List<j> a = new ArrayList();
  
  public Number a()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).a();
    }
    throw new IllegalStateException();
  }
  
  public void a(j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = l.a;
    }
    this.a.add(localObject);
  }
  
  public String b()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).b();
    }
    throw new IllegalStateException();
  }
  
  public double c()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).c();
    }
    throw new IllegalStateException();
  }
  
  public long d()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).d();
    }
    throw new IllegalStateException();
  }
  
  public int e()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof g)) && (((g)paramObject).a.equals(this.a)));
  }
  
  public boolean f()
  {
    if (this.a.size() == 1) {
      return ((j)this.a.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Iterator<j> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */