package b.a.e.j;

import java.util.ArrayList;
import java.util.List;

public class m
{
  final int h;
  Object[] i;
  Object[] j;
  volatile int k;
  int l;
  
  public m(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(Object paramObject)
  {
    if (this.k == 0)
    {
      this.i = new Object[this.h + 1];
      this.j = this.i;
      this.i[0] = paramObject;
      this.l = 1;
      this.k = 1;
      return;
    }
    if (this.l == this.h)
    {
      Object[] arrayOfObject = new Object[this.h + 1];
      arrayOfObject[0] = paramObject;
      this.j[this.h] = arrayOfObject;
      this.j = arrayOfObject;
      this.l = 1;
      this.k += 1;
      return;
    }
    this.j[this.l] = paramObject;
    this.l += 1;
    this.k += 1;
  }
  
  public Object[] b()
  {
    return this.i;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public String toString()
  {
    int i3 = this.h;
    int i4 = this.k;
    ArrayList localArrayList = new ArrayList(i4 + 1);
    Object[] arrayOfObject = b();
    int i1;
    for (int m = 0;; m = i1)
    {
      int n = 0;
      int i2;
      do
      {
        if (m >= i4) {
          break;
        }
        localArrayList.add(arrayOfObject[n]);
        i1 = m + 1;
        i2 = n + 1;
        m = i1;
        n = i2;
      } while (i2 != i3);
      arrayOfObject = (Object[])arrayOfObject[i3];
    }
    return localArrayList.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */