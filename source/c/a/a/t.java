package c.a.a;

import c.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class t
  extends u
{
  private static c a = c.a(t.class);
  private boolean b;
  private ArrayList c;
  
  public t(v paramv)
  {
    super(paramv);
    this.b = false;
    this.c = new ArrayList();
  }
  
  protected t(w paramw)
  {
    super(paramw);
    a(true);
    this.c = new ArrayList();
  }
  
  private void c()
  {
    int i = i() + 8;
    int j = Math.min(i() + g(), m());
    while (i < j)
    {
      Object localObject = new v(h(), i);
      w localw = ((v)localObject).d();
      if (localw == w.g) {
        localObject = new l((v)localObject);
      } else if (localw == w.i) {
        localObject = new j((v)localObject);
      } else if (localw == w.c) {
        localObject = new a((v)localObject);
      } else if (localw == w.e) {
        localObject = new aj((v)localObject);
      } else if (localw == w.f) {
        localObject = new ah((v)localObject);
      } else if (localw == w.j) {
        localObject = new ai((v)localObject);
      } else if (localw == w.k) {
        localObject = new ag((v)localObject);
      } else if (localw == w.m) {
        localObject = new e((v)localObject);
      } else if (localw == w.n) {
        localObject = new f((v)localObject);
      } else if (localw == w.h) {
        localObject = new b((v)localObject);
      } else if (localw == w.l) {
        localObject = new ac((v)localObject);
      } else if (localw == w.p) {
        localObject = new ak((v)localObject);
      } else if (localw == w.o) {
        localObject = new g((v)localObject);
      } else {
        localObject = new s((v)localObject);
      }
      this.c.add(localObject);
      i += ((u)localObject).g();
    }
    this.b = true;
  }
  
  public void a(u paramu)
  {
    this.c.add(paramu);
  }
  
  byte[] a()
  {
    if (!this.b) {
      c();
    }
    Object localObject = new byte[0];
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte2 = ((u)localIterator.next()).a();
      if (arrayOfByte2 != null)
      {
        byte[] arrayOfByte1 = new byte[localObject.length + arrayOfByte2.length];
        System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, localObject.length, arrayOfByte2.length);
        localObject = arrayOfByte1;
      }
    }
    return a((byte[])localObject);
  }
  
  public u[] b()
  {
    if (!this.b) {
      c();
    }
    return (u[])this.c.toArray(new u[this.c.size()]);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */