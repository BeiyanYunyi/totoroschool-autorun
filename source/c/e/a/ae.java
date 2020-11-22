package c.e.a;

import c.a.j;
import c.m;
import java.io.IOException;
import java.io.OutputStream;

public final class ae
{
  private static c.b.c b = c.b.c.a(ae.class);
  c.d.a.c a;
  private aa c;
  private OutputStream d;
  private int e;
  private int f;
  private m g;
  
  ae(OutputStream paramOutputStream, m paramm, c.d.a.c paramc)
    throws IOException
  {
    this.d = paramOutputStream;
    this.g = paramm;
    this.a = paramc;
    b();
  }
  
  private void b()
    throws IOException
  {
    if (this.g.k())
    {
      this.c = new af(this.g.l());
      return;
    }
    this.e = this.g.b();
    this.f = this.g.a();
    this.c = new ay(this.e, this.f);
  }
  
  int a()
    throws IOException
  {
    return this.c.a();
  }
  
  public void a(j paramj)
    throws IOException
  {
    paramj = paramj.g();
    this.c.a(paramj);
  }
  
  void a(boolean paramBoolean)
    throws IOException, at
  {
    new n(this.c, this.c.a(), this.d, this.a).a();
    this.d.flush();
    this.c.b();
    if (paramBoolean) {
      this.d.close();
    }
    this.c = null;
    if (!this.g.d()) {
      System.gc();
    }
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    this.c.a(paramArrayOfByte, paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */