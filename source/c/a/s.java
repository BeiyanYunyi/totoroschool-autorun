package c.a;

import c.b.a;
import c.b.c;
import c.e.a.ae;
import c.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class s
{
  private static c a = c.a(s.class);
  private t b;
  private ArrayList c;
  private ao d;
  private c.a.b.t e;
  private m f;
  private int g;
  private boolean h;
  
  public s(int paramInt, c.a.b.t paramt, ao paramao, m paramm)
  {
    this.d = paramao;
    this.e = paramt;
    this.f = paramm;
    this.c = new ArrayList();
    this.g = paramInt;
    this.h = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if ((localu.c() == paramInt1) && (localu.d() == paramInt1) && (localu.e() == paramInt2) && (localu.f() == paramInt2))
      {
        localIterator.remove();
        this.b.c();
      }
    }
  }
  
  public void a(u paramu)
  {
    this.c.add(paramu);
    paramu.a(this);
    if (this.h)
    {
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      }
      a.a(bool);
      this.b.d();
    }
  }
  
  public void a(ae paramae)
    throws IOException
  {
    if (this.c.size() > 65533)
    {
      a.b("Maximum number of data validations exceeded - truncating...");
      localObject = this.c;
      boolean bool = false;
      this.c = new ArrayList(((ArrayList)localObject).subList(0, 65532));
      if (this.c.size() <= 65533) {
        bool = true;
      }
      a.a(bool);
    }
    if (this.b == null) {
      this.b = new t(new r(this.g, this.c.size()));
    }
    if (!this.b.e()) {
      return;
    }
    paramae.a(this.b);
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramae.a((u)((Iterator)localObject).next());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */