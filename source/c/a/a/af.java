package c.a.a;

import c.b.c;
import c.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class af
{
  private static c a = c.a(af.class);
  private ArrayList b;
  private boolean c;
  private d[] d = new d[0];
  
  public af(m paramm) {}
  
  private void b(c.e.a.ae paramae)
    throws IOException
  {
    if ((this.d.length == 0) && (this.b.size() == 0)) {
      return;
    }
    if ((this.d.length == 0) && (this.b.size() != 0))
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (r)((Iterator)localObject1).next();
        paramae.a(((r)localObject2).b());
        ((r)localObject2).a(paramae);
      }
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((r)((Iterator)localObject1).next()).b(paramae);
      }
      return;
    }
    int j = this.b.size();
    int i = 0;
    if ((j == 0) && (this.d.length != 0))
    {
      while (i < this.d.length)
      {
        localObject1 = this.d[i];
        if (((d)localObject1).c() != null) {
          paramae.a(((d)localObject1).c());
        }
        if (((d)localObject1).d() != null) {
          paramae.a(((d)localObject1).d());
        }
        paramae.a((c.a.j)localObject1);
        i += 1;
      }
      return;
    }
    int m = this.b.size();
    t[] arrayOft = new t[this.d.length + m];
    boolean[] arrayOfBoolean = new boolean[this.d.length + m];
    j = 0;
    for (i = 0; j < m; i = k)
    {
      localObject1 = (r)this.b.get(j);
      arrayOft[j] = ((r)localObject1).c();
      k = i;
      if (j > 0) {
        k = i + arrayOft[j].g();
      }
      if (((r)localObject1).g()) {
        arrayOfBoolean[j] = true;
      }
      j += 1;
    }
    int k = 0;
    j = i;
    i = k;
    while (i < this.d.length)
    {
      k = i + m;
      arrayOft[k] = this.d[i].b();
      j += arrayOft[k].g();
      i += 1;
    }
    Object localObject1 = new k();
    ((k)localObject1).a(new j(this.d.length + m));
    Object localObject2 = new aj();
    ah localah = new ah();
    localah.a(new ai());
    localah.a(new ag(ae.a, 1024, 5));
    ((aj)localObject2).a(localah);
    ((aj)localObject2).a(arrayOft[0]);
    ((k)localObject1).a((u)localObject2);
    localObject2 = ((k)localObject1).a();
    c.a.ag.b(c.a.ag.a(localObject2[4], localObject2[5], localObject2[6], localObject2[7]) + j, (byte[])localObject2, 4);
    c.a.ag.b(c.a.ag.a(localObject2[28], localObject2[29], localObject2[30], localObject2[31]) + j, (byte[])localObject2, 28);
    localObject1 = localObject2;
    if (arrayOfBoolean[0] == 1)
    {
      localObject1 = new byte[localObject2.length - 8];
      System.arraycopy(localObject2, 0, localObject1, 0, localObject1.length);
    }
    paramae.a(new z((byte[])localObject1));
    ((r)this.b.get(0)).a(paramae);
    i = 1;
    while (i < arrayOft.length)
    {
      localObject1 = arrayOft[i].l();
      localObject2 = arrayOft[i].a((byte[])localObject1);
      localObject1 = localObject2;
      if (arrayOfBoolean[i] == 1)
      {
        localObject1 = new byte[localObject2.length - 8];
        System.arraycopy(localObject2, 0, localObject1, 0, localObject1.length);
      }
      paramae.a(new z((byte[])localObject1));
      if (i < m)
      {
        ((r)this.b.get(i)).a(paramae);
      }
      else
      {
        localObject1 = this.d[(i - m)];
        paramae.a(((d)localObject1).d());
        paramae.a((c.a.j)localObject1);
      }
      i += 1;
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((r)((Iterator)localObject1).next()).b(paramae);
    }
  }
  
  public void a(c.e.a.ae paramae)
    throws IOException
  {
    if ((this.b.size() == 0) && (this.d.length == 0)) {
      return;
    }
    boolean bool1 = this.c;
    int n = this.b.size();
    Object localObject1 = this.b.iterator();
    int m;
    for (;;)
    {
      bool2 = ((Iterator)localObject1).hasNext();
      m = 1;
      if ((!bool2) || (bool1)) {
        break;
      }
      if (((r)((Iterator)localObject1).next()).d() != ad.a) {
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
    if (n > 0)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!((r)this.b.get(0)).f()) {
          bool2 = true;
        }
      }
    }
    bool1 = bool2;
    if (n == 0)
    {
      bool1 = bool2;
      if (this.d.length == 1)
      {
        bool1 = bool2;
        if (this.d[0].c() == null) {
          bool1 = false;
        }
      }
    }
    if (!bool1)
    {
      b(paramae);
      return;
    }
    Object[] arrayOfObject = new Object[this.d.length + n];
    localObject1 = null;
    int j = 0;
    int i = 0;
    while (j < n)
    {
      localObject3 = ((r)this.b.get(j)).c();
      k = i;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = ((t)localObject3).a();
        arrayOfObject[j] = localObject2;
        if (j == 0)
        {
          localObject2 = localObject3;
          k = i;
        }
        else
        {
          k = i + localObject2.length;
          localObject2 = localObject1;
        }
      }
      j += 1;
      i = k;
      localObject1 = localObject2;
    }
    int k = 0;
    j = i;
    i = k;
    while (i < this.d.length)
    {
      localObject2 = this.d[i].b();
      localObject3 = ((t)localObject2).a(((t)localObject2).l());
      arrayOfObject[(i + n)] = localObject3;
      if ((i == 0) && (n == 0)) {
        localObject1 = localObject2;
      } else {
        j += localObject3.length;
      }
      i += 1;
    }
    Object localObject2 = new k();
    ((k)localObject2).a(new j(this.d.length + n));
    Object localObject3 = new aj();
    ah localah = new ah();
    localah.a(new ai());
    localah.a(new ag(ae.a, 1024, 5));
    ((aj)localObject3).a(localah);
    ((aj)localObject3).a((u)localObject1);
    ((k)localObject2).a((u)localObject3);
    localObject2 = ((k)localObject2).a();
    c.a.ag.b(c.a.ag.a(localObject2[4], localObject2[5], localObject2[6], localObject2[7]) + j, (byte[])localObject2, 4);
    c.a.ag.b(c.a.ag.a(localObject2[28], localObject2[29], localObject2[30], localObject2[31]) + j, (byte[])localObject2, 28);
    localObject1 = localObject2;
    if (n > 0)
    {
      localObject1 = localObject2;
      if (((r)this.b.get(0)).g())
      {
        localObject1 = new byte[localObject2.length - 8];
        System.arraycopy(localObject2, 0, localObject1, 0, localObject1.length);
      }
    }
    paramae.a(new z((byte[])localObject1));
    if (n > 0)
    {
      ((r)this.b.get(0)).a(paramae);
      i = m;
    }
    else
    {
      localObject1 = this.d[0];
      paramae.a(((d)localObject1).d());
      paramae.a((c.a.j)localObject1);
      i = m;
    }
    while (i < arrayOfObject.length)
    {
      localObject2 = (byte[])arrayOfObject[i];
      localObject1 = localObject2;
      if (i < n)
      {
        localObject1 = localObject2;
        if (((r)this.b.get(i)).g())
        {
          localObject1 = new byte[localObject2.length - 8];
          System.arraycopy(localObject2, 0, localObject1, 0, localObject1.length);
        }
      }
      paramae.a(new z((byte[])localObject1));
      if (i < n)
      {
        ((r)this.b.get(i)).a(paramae);
      }
      else
      {
        localObject1 = this.d[(i - n)];
        paramae.a(((d)localObject1).d());
        paramae.a((c.a.j)localObject1);
      }
      i += 1;
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((r)((Iterator)localObject1).next()).b(paramae);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.b = paramArrayList;
    this.c = paramBoolean;
  }
  
  public d[] a()
  {
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */