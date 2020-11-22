package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import java.util.ArrayList;
import java.util.Iterator;

class ad
  extends aq
{
  private ArrayList a = new ArrayList();
  
  public ad()
  {
    super(an.f);
  }
  
  public int a(int paramInt)
  {
    return ((a)this.a.get(paramInt)).a;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a.iterator();
    int j = 0;
    int i = 0;
    while ((((Iterator)localObject).hasNext()) && (j == 0))
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.a == paramInt1) && (locala.b == paramInt2)) {
        j = 1;
      } else {
        i += 1;
      }
    }
    if (j == 0)
    {
      localObject = new a(paramInt1, paramInt2, paramInt2);
      this.a.add(localObject);
      i = this.a.size() - 1;
    }
    return i;
  }
  
  public byte[] a()
  {
    int j = this.a.size();
    int i = 2;
    byte[] arrayOfByte = new byte[j * 6 + 2];
    ag.a(this.a.size(), arrayOfByte, 0);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      ag.a(locala.a, arrayOfByte, i);
      ag.a(locala.b, arrayOfByte, i + 2);
      ag.a(locala.c, arrayOfByte, i + 4);
      i += 6;
    }
    return arrayOfByte;
  }
  
  public int b(int paramInt)
  {
    return ((a)this.a.get(paramInt)).b;
  }
  
  void c(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
  }
  
  private static class a
  {
    int a;
    int b;
    int c;
    
    a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
    
    void a(int paramInt)
    {
      if (this.b >= paramInt) {
        this.b += 1;
      }
      if (this.c >= paramInt) {
        this.c += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */