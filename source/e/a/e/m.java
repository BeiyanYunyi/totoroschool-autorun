package e.a.e;

import java.util.Arrays;

public final class m
{
  private int a;
  private final int[] b = new int[10];
  
  m a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= this.b.length) {
        return this;
      }
      this.a = (1 << paramInt1 | this.a);
      this.b[paramInt1] = paramInt2;
      return this;
    }
    return this;
  }
  
  void a()
  {
    this.a = 0;
    Arrays.fill(this.b, 0);
  }
  
  void a(m paramm)
  {
    int i = 0;
    while (i < 10)
    {
      if (paramm.a(i)) {
        a(i, paramm.b(i));
      }
      i += 1;
    }
  }
  
  boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  int b()
  {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt)
  {
    return this.b[paramInt];
  }
  
  int c()
  {
    if ((this.a & 0x2) != 0) {
      return this.b[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    if ((this.a & 0x10) != 0) {
      paramInt = this.b[4];
    }
    return paramInt;
  }
  
  int d()
  {
    if ((this.a & 0x80) != 0) {
      return this.b[7];
    }
    return 65535;
  }
  
  int d(int paramInt)
  {
    if ((this.a & 0x20) != 0) {
      paramInt = this.b[5];
    }
    return paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */