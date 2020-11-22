package c.a.a;

import c.b.a;
import c.b.c;
import java.util.ArrayList;

public class o
  implements x
{
  private static c a = c.a(o.class);
  private byte[] b = null;
  private int c = 0;
  private boolean d = false;
  private u[] e;
  
  private void a(t paramt, ArrayList paramArrayList)
  {
    paramt = paramt.b();
    int i = 0;
    while (i < paramt.length)
    {
      if (paramt[i].k() == w.f) {
        paramArrayList.add(paramt[i]);
      } else if (paramt[i].k() == w.e) {
        a((t)paramt[i], paramArrayList);
      } else {
        a.b("Spgr Containers contains a record other than Sp/Spgr containers");
      }
      i += 1;
    }
  }
  
  private void b()
  {
    int k = 0;
    Object localObject1 = new v(this, 0);
    a.a(((v)localObject1).a());
    localObject1 = new t((v)localObject1);
    ((t)localObject1).b();
    Object localObject2 = ((t)localObject1).b();
    localObject1 = null;
    int i = 0;
    while ((i < localObject2.length) && (localObject1 == null))
    {
      Object localObject3 = localObject2[i];
      if (((u)localObject3).k() == w.e) {
        localObject1 = (t)localObject3;
      }
      i += 1;
    }
    boolean bool;
    if (localObject1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    localObject2 = ((t)localObject1).b();
    int j = 0;
    i = k;
    while ((i < localObject2.length) && (j == 0))
    {
      if (localObject2[i].k() == w.e) {
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      this.e = ((u[])localObject2);
    }
    else
    {
      localObject2 = new ArrayList();
      a((t)localObject1, (ArrayList)localObject2);
      this.e = new u[((ArrayList)localObject2).size()];
      this.e = ((u[])((ArrayList)localObject2).toArray(this.e));
    }
    this.d = true;
  }
  
  t a(int paramInt)
  {
    if (!this.d) {
      b();
    }
    boolean bool = true;
    paramInt += 1;
    if (paramInt < this.e.length)
    {
      t localt = (t)this.e[paramInt];
      if (localt == null) {
        bool = false;
      }
      a.a(bool);
      return localt;
    }
    throw new p();
  }
  
  public byte[] a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */