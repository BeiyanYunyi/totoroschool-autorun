package c.e.a;

import c.a.al;
import c.b.c;
import c.d;
import c.e.g;
import c.e.l;
import c.e.n;
import c.i;
import c.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class az
{
  private static c a = c.a(az.class);
  private ArrayList b = new ArrayList();
  private l c;
  
  public az(l paraml)
  {
    this.c = paraml;
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList(this.b.size());
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      al localal = (al)localIterator1.next();
      Iterator localIterator2 = localArrayList.iterator();
      int i = 0;
      while ((localIterator2.hasNext()) && (i == 0)) {
        if (((al)localIterator2.next()).a(localal))
        {
          c localc = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not merge cells ");
          localStringBuilder.append(localal);
          localStringBuilder.append(" as they clash with an existing set of merged cells.");
          localc.b(localStringBuilder.toString());
          i = 1;
        }
      }
      if (i == 0) {
        localArrayList.add(localal);
      }
    }
    this.b = localArrayList;
  }
  
  private void c()
  {
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        al localal = (al)this.b.get(i);
        c.a locala1 = localal.a();
        c.a locala2 = localal.b();
        int j = locala1.b();
        int k = 0;
        while (j <= locala2.b())
        {
          int m = locala1.j_();
          while (m <= locala2.j_())
          {
            int n = k;
            if (this.c.a(j, m).c() != d.a) {
              if (k == 0)
              {
                n = 1;
              }
              else
              {
                Object localObject = a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Range ");
                localStringBuilder.append(localal);
                localStringBuilder.append(" contains more than one data cell.  ");
                localStringBuilder.append("Setting the other cells to blank.");
                ((c)localObject).b(localStringBuilder.toString());
                localObject = new c.e.a(j, m);
                this.c.a((g)localObject);
                n = k;
              }
            }
            m += 1;
            k = n;
          }
          j += 1;
        }
        i += 1;
      }
    }
    catch (n localn)
    {
      for (;;) {}
    }
    c.b.a.a(false);
  }
  
  void a(ae paramae)
    throws IOException
  {
    if (this.b.size() == 0) {
      return;
    }
    if (!((cv)this.c).f().f())
    {
      b();
      c();
    }
    if (this.b.size() < 1020)
    {
      paramae.a(new ba(this.b));
      return;
    }
    int m = this.b.size() / 1020;
    int i = 0;
    int j = 0;
    while (i < m + 1)
    {
      int n = Math.min(1020, this.b.size() - j);
      ArrayList localArrayList = new ArrayList(n);
      int k = 0;
      while (k < n)
      {
        localArrayList.add(this.b.get(j + k));
        k += 1;
      }
      paramae.a(new ba(localArrayList));
      j += n;
      i += 1;
    }
  }
  
  i[] a()
  {
    i[] arrayOfi = new i[this.b.size()];
    int i = 0;
    while (i < arrayOfi.length)
    {
      arrayOfi[i] = ((i)this.b.get(i));
      i += 1;
    }
    return arrayOfi;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */