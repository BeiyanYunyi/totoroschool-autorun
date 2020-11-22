package com.bumptech.glide.load.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class e<K extends h, V>
{
  private final a<K, V> a = new a();
  private final Map<K, a<K, V>> b = new HashMap();
  
  private void a(a<K, V> parama)
  {
    d(parama);
    parama.b = this.a;
    parama.a = this.a.a;
    c(parama);
  }
  
  private void b(a<K, V> parama)
  {
    d(parama);
    parama.b = this.a.b;
    parama.a = this.a;
    c(parama);
  }
  
  private static <K, V> void c(a<K, V> parama)
  {
    parama.a.b = parama;
    parama.b.a = parama;
  }
  
  private static <K, V> void d(a<K, V> parama)
  {
    parama.b.a = parama.a;
    parama.a.b = parama.b;
  }
  
  public V a()
  {
    for (a locala = this.a.b; !locala.equals(this.a); locala = locala.b)
    {
      Object localObject = locala.a();
      if (localObject != null) {
        return (V)localObject;
      }
      d(locala);
      this.b.remove(a.a(locala));
      ((h)a.a(locala)).a();
    }
    return null;
  }
  
  public V a(K paramK)
  {
    a locala = (a)this.b.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      this.b.put(paramK, locala);
      paramK = locala;
    }
    else
    {
      paramK.a();
      paramK = locala;
    }
    a(paramK);
    return (V)paramK.a();
  }
  
  public void a(K paramK, V paramV)
  {
    a locala = (a)this.b.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      b(locala);
      this.b.put(paramK, locala);
      paramK = locala;
    }
    else
    {
      paramK.a();
      paramK = locala;
    }
    paramK.a(paramV);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    a locala = this.a.a;
    int i = 0;
    while (!locala.equals(this.a))
    {
      i = 1;
      localStringBuilder.append('{');
      localStringBuilder.append(a.a(locala));
      localStringBuilder.append(':');
      localStringBuilder.append(locala.b());
      localStringBuilder.append("}, ");
      locala = locala.a;
    }
    if (i != 0) {
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    }
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
  
  private static class a<K, V>
  {
    a<K, V> a = this;
    a<K, V> b = this;
    private final K c;
    private List<V> d;
    
    public a()
    {
      this(null);
    }
    
    public a(K paramK)
    {
      this.c = paramK;
    }
    
    public V a()
    {
      int i = b();
      if (i > 0) {
        return (V)this.d.remove(i - 1);
      }
      return null;
    }
    
    public void a(V paramV)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(paramV);
    }
    
    public int b()
    {
      if (this.d != null) {
        return this.d.size();
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */