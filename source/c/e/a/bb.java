package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.e.e;
import java.util.List;

class bb
  extends aq
{
  private int a;
  private int b;
  private int c;
  private int[] d;
  private int[] e;
  
  public bb(List paramList)
  {
    super(an.o);
    int i = 0;
    this.a = ((e)paramList.get(0)).j_();
    this.b = ((e)paramList.get(0)).b();
    this.c = (this.b + paramList.size() - 1);
    this.d = new int[paramList.size()];
    this.e = new int[paramList.size()];
    while (i < paramList.size())
    {
      this.d[i] = ((int)((e)paramList.get(i)).l());
      this.e[i] = ((j)paramList.get(i)).i();
      i += 1;
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = new byte[this.d.length * 6 + 6];
    int j = this.a;
    int i = 0;
    ag.a(j, arrayOfByte1, 0);
    ag.a(this.b, arrayOfByte1, 2);
    j = 4;
    byte[] arrayOfByte2 = new byte[4];
    while (i < this.d.length)
    {
      ag.a(this.e[i], arrayOfByte1, j);
      ag.b(this.d[i] << 2 | 0x2, arrayOfByte1, j + 2);
      j += 6;
      i += 1;
    }
    ag.a(this.c, arrayOfByte1, j);
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */