package c.e.a;

import c.a.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class cc
{
  private HashMap a = new HashMap(100);
  private ArrayList b = new ArrayList(100);
  private int c = 0;
  
  private bw a(String paramString, int paramInt, ae paramae)
    throws IOException
  {
    Object localObject = null;
    int i = paramInt;
    while (i != 0)
    {
      bw localbw = new bw();
      if ((i != paramString.length()) && (paramString.length() != 0)) {
        paramInt = localbw.a(paramString.substring(paramString.length() - i), false);
      } else {
        paramInt = localbw.a(paramString, true);
      }
      localObject = localbw;
      i = paramInt;
      if (paramInt != 0)
      {
        paramae.a(localbw);
        localObject = new bw();
        i = paramInt;
      }
    }
    return (bw)localObject;
  }
  
  public int a(String paramString)
  {
    Integer localInteger2 = (Integer)this.a.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = new Integer(this.a.size());
      this.a.put(paramString, localInteger1);
      this.b.add(paramString);
    }
    this.c += 1;
    return localInteger1.intValue();
  }
  
  public String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public void a(ae paramae)
    throws IOException
  {
    Object localObject2 = new bx(this.c, this.b.size());
    ab localab = new ab(this.b.size());
    int k = localab.d();
    Iterator localIterator = this.b.iterator();
    int j = 0;
    Object localObject1 = null;
    int i = 0;
    int m;
    while ((localIterator.hasNext()) && (j == 0))
    {
      localObject1 = (String)localIterator.next();
      m = ((bx)localObject2).c();
      j = ((bx)localObject2).a((String)localObject1);
      if (i % k == 0) {
        localab.a(paramae.a(), m + 4);
      }
      i += 1;
    }
    paramae.a((j)localObject2);
    if ((j != 0) || (localIterator.hasNext()))
    {
      localObject1 = a((String)localObject1, j, paramae);
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        j = ((bw)localObject1).c();
        m = ((bw)localObject1).a((String)localObject2);
        if (i % k == 0) {
          localab.a(paramae.a(), j + 4);
        }
        j = i + 1;
        i = j;
        if (m != 0)
        {
          paramae.a((j)localObject1);
          localObject1 = a((String)localObject2, m, paramae);
          i = j;
        }
      }
      paramae.a((j)localObject1);
    }
    paramae.a(localab);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */