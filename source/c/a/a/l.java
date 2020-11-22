package c.a.a;

import c.a.ag;
import c.b.c;
import java.util.ArrayList;

class l
  extends s
{
  private static c a = c.a(l.class);
  private byte[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  private ArrayList g;
  
  public l(int paramInt1, int paramInt2)
  {
    super(w.g);
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = new ArrayList();
  }
  
  public l(v paramv)
  {
    super(paramv);
    this.g = new ArrayList();
    paramv = l();
    int i = 0;
    this.d = ag.a(paramv[0], paramv[1], paramv[2], paramv[3]);
    this.c = ag.a(paramv[4], paramv[5], paramv[6], paramv[7]);
    this.e = ag.a(paramv[8], paramv[9], paramv[10], paramv[11]);
    this.f = ag.a(paramv[12], paramv[13], paramv[14], paramv[15]);
    int j = 16;
    while (i < this.c)
    {
      a locala = new a(ag.a(paramv[j], paramv[(j + 1)]), ag.a(paramv[(j + 2)], paramv[(j + 3)]));
      this.g.add(locala);
      j += 4;
      i += 1;
    }
  }
  
  a a(int paramInt)
  {
    return (a)this.g.get(paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a locala = new a(paramInt1, paramInt2);
    this.g.add(locala);
  }
  
  byte[] a()
  {
    this.c = this.g.size();
    int i = this.c;
    int j = 16;
    this.b = new byte[i * 4 + 16];
    int k = this.e;
    Object localObject = this.b;
    i = 0;
    ag.b(k + 1024, (byte[])localObject, 0);
    ag.b(this.c, this.b, 4);
    ag.b(this.e, this.b, 8);
    ag.b(1, this.b, 12);
    while (i < this.c)
    {
      localObject = (a)this.g.get(i);
      ag.a(((a)localObject).a, this.b, j);
      ag.a(((a)localObject).b, this.b, j + 2);
      j += 4;
      i += 1;
    }
    return a(this.b);
  }
  
  static final class a
  {
    int a;
    int b;
    
    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */