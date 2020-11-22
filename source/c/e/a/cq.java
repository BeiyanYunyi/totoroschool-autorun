package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.k;

class cq
  extends aq
{
  private byte[] a;
  
  public cq(k paramk)
  {
    super(an.as);
    if (paramk.D()) {
      i = 2;
    } else {
      i = 0;
    }
    int j = i | 0x4 | 0x0;
    int i = j;
    if (paramk.C()) {
      i = j | 0x10;
    }
    j = i | 0x20 | 0x80;
    if (paramk.H() == 0)
    {
      i = j;
      if (paramk.I() == 0) {}
    }
    else
    {
      i = j | 0x8 | 0x100;
    }
    j = i;
    if (paramk.h()) {
      j = i | 0x600;
    }
    i = j;
    if (paramk.E()) {
      i = j | 0x800;
    }
    this.a = new byte[18];
    ag.a(i, this.a, 0);
    ag.a(64, this.a, 6);
    ag.a(paramk.A(), this.a, 10);
    ag.a(paramk.B(), this.a, 12);
  }
  
  public byte[] a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */