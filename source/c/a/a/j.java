package c.a.a;

import c.a.ag;

class j
  extends s
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  
  public j(int paramInt)
  {
    super(w.i);
    this.b = 1;
    this.c = (paramInt + 1);
    this.d = (this.c + 1024 + 1);
    b(this.b);
  }
  
  public j(v paramv)
  {
    super(paramv);
    this.b = j();
    paramv = l();
    this.c = ag.a(paramv[0], paramv[1], paramv[2], paramv[3]);
    this.d = ag.a(paramv[4], paramv[5], paramv[6], paramv[7]);
  }
  
  byte[] a()
  {
    this.a = new byte[8];
    ag.b(this.c, this.a, 0);
    ag.b(this.d, this.a, 4);
    return a(this.a);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */