package c.a;

import c.b.a;
import c.b.c;
import c.e.a.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ad
{
  private static c a = c.a(ad.class);
  private HashMap b = new HashMap(10);
  private ArrayList c = new ArrayList(10);
  private ArrayList d = new ArrayList(10);
  private int e;
  private ab f;
  private aj g;
  
  public ad(ab paramab)
  {
    this.f = paramab;
    this.e = 164;
  }
  
  protected final ab a()
  {
    return this.f;
  }
  
  ac a(int paramInt)
  {
    return (ac)this.b.get(new Integer(paramInt));
  }
  
  public af a(af paramaf1, af paramaf2)
  {
    Object localObject1 = this.d.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (as)((Iterator)localObject1).next();
      if (((as)localObject2).d() >= 164) {
        ((as)localObject2).b(paramaf2.a(((as)localObject2).d()));
      }
      ((as)localObject2).c(paramaf1.a(((as)localObject2).n()));
    }
    int j = 21;
    paramaf1 = new ArrayList(21);
    paramaf2 = new af(this.d.size());
    int k = Math.min(21, this.d.size());
    int i = 0;
    while (i < k)
    {
      paramaf1.add(this.d.get(i));
      paramaf2.a(i, i);
      i += 1;
    }
    if (k < 21)
    {
      a.b("There are less than the expected minimum number of XF records");
      return paramaf2;
    }
    i = 0;
    while (j < this.d.size())
    {
      localObject1 = (as)this.d.get(j);
      localObject2 = paramaf1.iterator();
      k = 0;
      while ((((Iterator)localObject2).hasNext()) && (k == 0))
      {
        as localas = (as)((Iterator)localObject2).next();
        if (localas.equals(localObject1))
        {
          paramaf2.a(j, paramaf2.a(localas.j()));
          i += 1;
          k = 1;
        }
      }
      if (k == 0)
      {
        paramaf1.add(localObject1);
        paramaf2.a(j, j - i);
      }
      j += 1;
    }
    localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((as)((Iterator)localObject1).next()).a(paramaf2);
    }
    this.d = paramaf1;
    return paramaf2;
  }
  
  public final void a(as paramas)
    throws ai
  {
    if (!paramas.k())
    {
      paramas.a(this.d.size(), this, this.f);
      this.d.add(paramas);
      return;
    }
    if (paramas.j() >= this.d.size()) {
      this.d.add(paramas);
    }
  }
  
  public final void a(v paramv)
    throws ai
  {
    if ((paramv.g_()) && (paramv.f_() >= 441))
    {
      a.b("Format index exceeds Excel maximum - assigning custom number");
      paramv.a(this.e);
      this.e += 1;
    }
    if (!paramv.g_())
    {
      paramv.a(this.e);
      this.e += 1;
    }
    if (this.e <= 441)
    {
      if (paramv.f_() >= this.e) {
        this.e = (paramv.f_() + 1);
      }
      if (!paramv.c())
      {
        this.c.add(paramv);
        this.b.put(new Integer(paramv.f_()), paramv);
      }
      return;
    }
    this.e = 441;
    throw new ai();
  }
  
  public void a(ae paramae)
    throws IOException
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      paramae.a((ac)localIterator.next());
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      paramae.a((as)localIterator.next());
    }
    paramae.a(new h(16, 3));
    paramae.a(new h(17, 6));
    paramae.a(new h(18, 4));
    paramae.a(new h(19, 7));
    paramae.a(new h(0, 0));
    paramae.a(new h(20, 5));
  }
  
  public af b()
  {
    return this.f.a();
  }
  
  public af c()
  {
    Object localObject1 = new ArrayList();
    af localaf = new af(this.e);
    Object localObject2 = this.c.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      v localv1 = (v)((Iterator)localObject2).next();
      a.a(localv1.c() ^ true);
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int j = 0;
      while ((localIterator.hasNext()) && (j == 0))
      {
        v localv2 = (v)localIterator.next();
        if (localv2.equals(localv1))
        {
          localaf.a(localv1.f_(), localaf.a(localv2.f_()));
          i += 1;
          j = 1;
        }
      }
      if (j == 0)
      {
        ((ArrayList)localObject1).add(localv1);
        if (localv1.f_() - i > 441) {
          a.b("Too many number formats - using default format.");
        }
        localaf.a(localv1.f_(), localv1.f_() - i);
      }
    }
    this.c = ((ArrayList)localObject1);
    localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (v)((Iterator)localObject1).next();
      ((v)localObject2).a(localaf.a(((v)localObject2).f_()));
    }
    return localaf;
  }
  
  public aj d()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */