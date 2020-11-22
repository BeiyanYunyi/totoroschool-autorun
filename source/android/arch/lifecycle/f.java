package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b.d;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class f
  extends c
{
  private a<d, a> a = new a();
  private c.b b;
  private final WeakReference<e> c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ArrayList<c.b> g = new ArrayList();
  
  public f(@NonNull e parame)
  {
    this.c = new WeakReference(parame);
    this.b = c.b.INITIALIZED;
  }
  
  static c.b a(@NonNull c.b paramb1, @Nullable c.b paramb2)
  {
    c.b localb = paramb1;
    if (paramb2 != null)
    {
      localb = paramb1;
      if (paramb2.compareTo(paramb1) < 0) {
        localb = paramb2;
      }
    }
    return localb;
  }
  
  private void a(e parame)
  {
    b.d locald = this.a.c();
    while ((locald.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) < 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        c(locala.a);
        locala.a(parame, e(locala.a));
        c();
      }
    }
  }
  
  static c.b b(c.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected event value ");
      localStringBuilder.append(parama);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return c.b.DESTROYED;
    case 5: 
      return c.b.RESUMED;
    case 3: 
    case 4: 
      return c.b.STARTED;
    }
    return c.b.CREATED;
  }
  
  private void b(c.b paramb)
  {
    if (this.b == paramb) {
      return;
    }
    this.b = paramb;
    if ((!this.e) && (this.d == 0))
    {
      this.e = true;
      d();
      this.e = false;
      return;
    }
    this.f = true;
  }
  
  private void b(e parame)
  {
    Iterator localIterator = this.a.b();
    while ((localIterator.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) > 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        c.a locala1 = d(locala.a);
        c(b(locala1));
        locala.a(parame, locala1);
        c();
      }
    }
  }
  
  private boolean b()
  {
    if (this.a.a() == 0) {
      return true;
    }
    c.b localb1 = ((a)this.a.d().getValue()).a;
    c.b localb2 = ((a)this.a.e().getValue()).a;
    return (localb1 == localb2) && (this.b == localb2);
  }
  
  private c.b c(d paramd)
  {
    paramd = this.a.d(paramd);
    c.b localb = null;
    if (paramd != null) {
      paramd = ((a)paramd.getValue()).a;
    } else {
      paramd = null;
    }
    if (!this.g.isEmpty()) {
      localb = (c.b)this.g.get(this.g.size() - 1);
    }
    return a(a(this.b, paramd), localb);
  }
  
  private void c()
  {
    this.g.remove(this.g.size() - 1);
  }
  
  private void c(c.b paramb)
  {
    this.g.add(paramb);
  }
  
  private static c.a d(c.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected state value ");
      localStringBuilder.append(paramb);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 5: 
      throw new IllegalArgumentException();
    case 4: 
      return c.a.ON_PAUSE;
    case 3: 
      return c.a.ON_STOP;
    case 2: 
      return c.a.ON_DESTROY;
    }
    throw new IllegalArgumentException();
  }
  
  private void d()
  {
    e locale = (e)this.c.get();
    if (locale == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!b())
    {
      this.f = false;
      if (this.b.compareTo(((a)this.a.d().getValue()).a) < 0) {
        b(locale);
      }
      Map.Entry localEntry = this.a.e();
      if ((!this.f) && (localEntry != null) && (this.b.compareTo(((a)localEntry.getValue()).a) > 0)) {
        a(locale);
      }
    }
    this.f = false;
  }
  
  private static c.a e(c.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected state value ");
      localStringBuilder.append(paramb);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 4: 
      throw new IllegalArgumentException();
    case 3: 
      return c.a.ON_RESUME;
    case 2: 
      return c.a.ON_START;
    }
    return c.a.ON_CREATE;
  }
  
  @NonNull
  public c.b a()
  {
    return this.b;
  }
  
  public void a(@NonNull c.a parama)
  {
    b(b(parama));
  }
  
  @MainThread
  public void a(@NonNull c.b paramb)
  {
    b(paramb);
  }
  
  public void a(@NonNull d paramd)
  {
    if (this.b == c.b.DESTROYED) {
      localb = c.b.DESTROYED;
    } else {
      localb = c.b.INITIALIZED;
    }
    a locala = new a(paramd, localb);
    if ((a)this.a.a(paramd, locala) != null) {
      return;
    }
    e locale = (e)this.c.get();
    if (locale == null) {
      return;
    }
    int i;
    if ((this.d == 0) && (!this.e)) {
      i = 0;
    } else {
      i = 1;
    }
    c.b localb = c(paramd);
    this.d += 1;
    while ((locala.a.compareTo(localb) < 0) && (this.a.c(paramd)))
    {
      c(locala.a);
      locala.a(locale, e(locala.a));
      c();
      localb = c(paramd);
    }
    if (i == 0) {
      d();
    }
    this.d -= 1;
  }
  
  public void b(@NonNull d paramd)
  {
    this.a.b(paramd);
  }
  
  static class a
  {
    c.b a;
    GenericLifecycleObserver b;
    
    a(d paramd, c.b paramb)
    {
      this.b = h.a(paramd);
      this.a = paramb;
    }
    
    void a(e parame, c.a parama)
    {
      c.b localb = f.b(parama);
      this.a = f.a(this.a, localb);
      this.b.a(parame, parama);
      this.a = localb;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */