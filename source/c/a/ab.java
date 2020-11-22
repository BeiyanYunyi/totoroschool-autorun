package c.a;

import c.b.a;
import c.e.a.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ab
{
  private ArrayList a = new ArrayList();
  
  public aa a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 4) {
      i = paramInt - 1;
    }
    return (aa)this.a.get(i);
  }
  
  af a()
  {
    af localaf = new af(this.a.size() + 1);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 4)
    {
      localObject1 = (aa)this.a.get(i);
      localArrayList.add(localObject1);
      localaf.a(((aa)localObject1).e(), ((aa)localObject1).e());
      i += 1;
    }
    int j = 4;
    i = 0;
    Object localObject2;
    while (j < this.a.size())
    {
      localObject1 = (aa)this.a.get(j);
      localObject2 = localArrayList.iterator();
      int k = 0;
      while ((((Iterator)localObject2).hasNext()) && (k == 0))
      {
        aa localaa = (aa)((Iterator)localObject2).next();
        if (((aa)localObject1).equals(localaa))
        {
          localaf.a(((aa)localObject1).e(), localaf.a(localaa.e()));
          i += 1;
          k = 1;
        }
      }
      if (k == 0)
      {
        localArrayList.add(localObject1);
        k = ((aa)localObject1).e() - i;
        boolean bool;
        if (k > 4) {
          bool = true;
        } else {
          bool = false;
        }
        a.a(bool);
        localaf.a(((aa)localObject1).e(), k);
      }
      j += 1;
    }
    Object localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aa)((Iterator)localObject1).next();
      ((aa)localObject2).a(localaf.a(((aa)localObject2).e()));
    }
    this.a = localArrayList;
    return localaf;
  }
  
  public void a(aa paramaa)
  {
    if (!paramaa.c())
    {
      int j = this.a.size();
      int i = j;
      if (j >= 4) {
        i = j + 1;
      }
      paramaa.a(i);
      this.a.add(paramaa);
    }
  }
  
  public void a(ae paramae)
    throws IOException
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      paramae.a((aa)localIterator.next());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */