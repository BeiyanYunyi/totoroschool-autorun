package c.a.b;

import c.a.ao;
import c.b.c;
import c.m;

public class w
{
  private static final c a = c.a(w.class);
  private at b;
  
  public w(String paramString, t paramt, ao paramao, m paramm, ar paramar)
  {
    this.b = new ba(paramString, paramt, paramao, paramm, paramar);
  }
  
  public w(byte[] paramArrayOfByte, c.a parama, t paramt, ao paramao, m paramm, ar paramar)
    throws v
  {
    if ((paramt.a() != null) && (!paramt.a().a())) {
      throw new v(v.BIFF8_SUPPORTED);
    }
    boolean bool;
    if (paramao != null) {
      bool = true;
    } else {
      bool = false;
    }
    c.b.a.a(bool);
    this.b = new bi(paramArrayOfByte, parama, paramt, paramao, paramm, paramar);
  }
  
  public void a()
    throws v
  {
    this.b.a();
  }
  
  public String b()
    throws v
  {
    return this.b.b();
  }
  
  public byte[] c()
  {
    return this.b.c();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */