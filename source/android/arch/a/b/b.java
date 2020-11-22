package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private c<K, V> a;
  private c<K, V> b;
  private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
  private int d = 0;
  
  public int a()
  {
    return this.d;
  }
  
  protected c<K, V> a(K paramK)
  {
    for (c localc = this.a; localc != null; localc = localc.c) {
      if (localc.a.equals(paramK)) {
        return localc;
      }
    }
    return localc;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    c localc = a(paramK);
    if (localc != null) {
      return (V)localc.b;
    }
    b(paramK, paramV);
    return null;
  }
  
  protected c<K, V> b(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new c(paramK, paramV);
    this.d += 1;
    if (this.b == null)
    {
      this.a = paramK;
      this.b = this.a;
      return paramK;
    }
    this.b.c = paramK;
    paramK.d = this.b;
    this.b = paramK;
    return paramK;
  }
  
  public V b(@NonNull K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.d -= 1;
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).a_(paramK);
      }
    }
    if (paramK.d != null) {
      paramK.d.c = paramK.c;
    } else {
      this.a = paramK.c;
    }
    if (paramK.c != null) {
      paramK.c.d = paramK.d;
    } else {
      this.b = paramK.d;
    }
    paramK.c = null;
    paramK.d = null;
    return (V)paramK.b;
  }
  
  public Iterator<Map.Entry<K, V>> b()
  {
    b localb = new b(this.b, this.a);
    this.c.put(localb, Boolean.valueOf(false));
    return localb;
  }
  
  public b<K, V>.d c()
  {
    d locald = new d(null);
    this.c.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public Map.Entry<K, V> d()
  {
    return this.a;
  }
  
  public Map.Entry<K, V> e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (a() != ((b)localObject1).a()) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    while ((((Iterator)paramObject).hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2)))) {
        return false;
      }
    }
    return (!((Iterator)paramObject).hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  @NonNull
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.a, this.b);
    this.c.put(locala, Boolean.valueOf(false));
    return locala;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static class a<K, V>
    extends b.e<K, V>
  {
    a(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.c;
    }
    
    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.d;
    }
  }
  
  private static class b<K, V>
    extends b.e<K, V>
  {
    b(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.d;
    }
    
    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.c;
    }
  }
  
  static class c<K, V>
    implements Map.Entry<K, V>
  {
    @NonNull
    final K a;
    @NonNull
    final V b;
    c<K, V> c;
    c<K, V> d;
    
    c(@NonNull K paramK, @NonNull V paramV)
    {
      this.a = paramK;
      this.b = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      return (this.a.equals(((c)paramObject).a)) && (this.b.equals(((c)paramObject).b));
    }
    
    @NonNull
    public K getKey()
    {
      return (K)this.a;
    }
    
    @NonNull
    public V getValue()
    {
      return (V)this.b;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("=");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  private class d
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private b.c<K, V> b;
    private boolean c = true;
    
    private d() {}
    
    public Map.Entry<K, V> a()
    {
      if (this.c)
      {
        this.c = false;
        this.b = b.a(b.this);
      }
      else
      {
        b.c localc;
        if (this.b != null) {
          localc = this.b.c;
        } else {
          localc = null;
        }
        this.b = localc;
      }
      return this.b;
    }
    
    public void a_(@NonNull b.c<K, V> paramc)
    {
      if (paramc == this.b)
      {
        this.b = this.b.d;
        boolean bool;
        if (this.b == null) {
          bool = true;
        } else {
          bool = false;
        }
        this.c = bool;
      }
    }
    
    public boolean hasNext()
    {
      boolean bool3 = this.c;
      boolean bool2 = false;
      boolean bool1 = false;
      if (bool3)
      {
        if (b.a(b.this) != null) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (this.b != null)
      {
        bool1 = bool2;
        if (this.b.c != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private static abstract class e<K, V>
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    b.c<K, V> a;
    b.c<K, V> b;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.a = paramc2;
      this.b = paramc1;
    }
    
    private b.c<K, V> b()
    {
      if ((this.b != this.a) && (this.a != null)) {
        return a(this.b);
      }
      return null;
    }
    
    abstract b.c<K, V> a(b.c<K, V> paramc);
    
    public Map.Entry<K, V> a()
    {
      b.c localc = this.b;
      this.b = b();
      return localc;
    }
    
    public void a_(@NonNull b.c<K, V> paramc)
    {
      if ((this.a == paramc) && (paramc == this.b))
      {
        this.b = null;
        this.a = null;
      }
      if (this.a == paramc) {
        this.a = b(this.a);
      }
      if (this.b == paramc) {
        this.b = b();
      }
    }
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public boolean hasNext()
    {
      return this.b != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void a_(@NonNull b.c<K, V> paramc);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */