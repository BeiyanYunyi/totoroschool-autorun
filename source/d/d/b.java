package d.d;

import d.a.o;
import java.util.NoSuchElementException;

public final class b
  extends o
{
  private final int a;
  private boolean b;
  private int c;
  private final int d;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt3;
    this.a = paramInt2;
    paramInt3 = this.d;
    boolean bool = false;
    if (paramInt3 > 0)
    {
      if (paramInt1 > paramInt2) {}
    }
    else {
      while (paramInt1 >= paramInt2)
      {
        bool = true;
        break;
      }
    }
    this.b = bool;
    if (!this.b) {
      paramInt1 = this.a;
    }
    this.c = paramInt1;
  }
  
  public int b()
  {
    int i = this.c;
    if (i == this.a)
    {
      if (this.b)
      {
        this.b = false;
        return i;
      }
      throw ((Throwable)new NoSuchElementException());
    }
    this.c += this.d;
    return i;
  }
  
  public boolean hasNext()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */