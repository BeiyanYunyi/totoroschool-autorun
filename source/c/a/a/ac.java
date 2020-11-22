package c.a.a;

import c.a.ag;
import c.a.am;
import c.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class ac
  extends s
{
  private static c a = c.a(ac.class);
  private byte[] b;
  private int c;
  private ArrayList d;
  
  public ac()
  {
    super(w.l);
    this.d = new ArrayList();
    c(3);
  }
  
  public ac(v paramv)
  {
    super(paramv);
    this.c = j();
    b();
  }
  
  private void b()
  {
    this.d = new ArrayList();
    byte[] arrayOfByte = l();
    int j = 0;
    int i = 0;
    while (j < this.c)
    {
      int k = ag.a(arrayOfByte[i], arrayOfByte[(i + 1)]);
      int m = ag.a(arrayOfByte[(i + 2)], arrayOfByte[(i + 3)], arrayOfByte[(i + 4)], arrayOfByte[(i + 5)]);
      boolean bool2 = true;
      boolean bool1;
      if ((k & 0x4000) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((k & 0x8000) == 0) {
        bool2 = false;
      }
      localObject = new a(k & 0x3FFF, bool1, bool2, m);
      i += 6;
      this.d.add(localObject);
      j += 1;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.c)
      {
        locala.e = am.a(arrayOfByte, locala.d / 2, i);
        i += locala.d;
      }
    }
  }
  
  a a(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    while ((localIterator.hasNext()) && (i == 0))
    {
      a locala = (a)localIterator.next();
      localObject1 = locala;
      if (locala.a == paramInt)
      {
        i = 1;
        localObject1 = locala;
      }
    }
    if (i != 0) {
      localObject2 = localObject1;
    }
    return (a)localObject2;
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    a locala = new a(paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    this.d.add(locala);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString)
  {
    paramString = new a(paramInt1, paramBoolean1, paramBoolean2, paramInt2, paramString);
    this.d.add(paramString);
  }
  
  byte[] a()
  {
    this.c = this.d.size();
    b(this.c);
    this.b = new byte[this.c * 6];
    Iterator localIterator = this.d.iterator();
    int j = 0;
    a locala;
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      int k = locala.a & 0x3FFF;
      int i = k;
      if (locala.b) {
        i = k | 0x4000;
      }
      k = i;
      if (locala.c) {
        k = i | 0x8000;
      }
      ag.a(k, this.b, j);
      ag.b(locala.d, this.b, j + 2);
      j += 6;
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.c) && (locala.e != null))
      {
        byte[] arrayOfByte = new byte[this.b.length + locala.e.length() * 2];
        System.arraycopy(this.b, 0, arrayOfByte, 0, this.b.length);
        am.b(locala.e, arrayOfByte, this.b.length);
        this.b = arrayOfByte;
      }
    }
    return a(this.b);
  }
  
  static final class a
  {
    int a;
    boolean b;
    boolean c;
    int d;
    String e;
    
    public a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramInt2;
    }
    
    public a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramInt2;
      this.e = paramString;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */