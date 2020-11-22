package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import java.util.ArrayList;
import java.util.Iterator;

class q
  extends aq
{
  private int a;
  private int b;
  private ArrayList c;
  private int d;
  
  public q(int paramInt)
  {
    super(an.q);
    this.a = paramInt;
    this.c = new ArrayList(10);
  }
  
  void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected byte[] a()
  {
    int j = this.c.size();
    int i = 4;
    byte[] arrayOfByte = new byte[j * 2 + 4];
    ag.b(this.d - this.a, arrayOfByte, 0);
    j = this.b;
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      int k = ((Integer)localIterator.next()).intValue();
      ag.a(k - j, arrayOfByte, i);
      i += 2;
      j = k;
    }
    return arrayOfByte;
  }
  
  void b(int paramInt)
  {
    this.c.add(new Integer(paramInt));
  }
  
  void c(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */