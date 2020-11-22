package c.e.a;

import c.a.as;
import c.e.b;
import c.e.f;
import c.e.i;
import c.e.j;
import c.e.m;

class cg
{
  private static c.b.c a = c.b.c.a(cg.class);
  private j b = null;
  private j c = null;
  private i d = null;
  private i e = null;
  private i f = null;
  private i g;
  
  private void g()
  {
    try
    {
      this.d = new i(d(), f.a);
      this.d.a(d());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void h()
  {
    try
    {
      this.f = new i(d(), new b(";;;"));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void i()
  {
    try
    {
      this.e = new i(e(), f.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void j()
  {
    try
    {
      this.b = new j(m.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void k()
  {
    try
    {
      this.c = new j(m.b);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void l()
  {
    try
    {
      this.g = new i(c.e.c.b);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public as a(as paramas)
  {
    Object localObject;
    if (paramas == m.c)
    {
      localObject = a();
    }
    else if (paramas == m.d)
    {
      localObject = c();
    }
    else if (paramas == m.e)
    {
      localObject = b();
    }
    else
    {
      localObject = paramas;
      if (paramas == t.a) {
        localObject = f();
      }
    }
    if (((as)localObject).m() == m.a)
    {
      ((as)localObject).a(d());
      return (as)localObject;
    }
    if (((as)localObject).m() == m.b) {
      ((as)localObject).a(e());
    }
    return (as)localObject;
  }
  
  public i a()
  {
    if (this.d == null) {
      g();
    }
    return this.d;
  }
  
  public i b()
  {
    if (this.f == null) {
      h();
    }
    return this.f;
  }
  
  public i c()
  {
    if (this.e == null) {
      i();
    }
    return this.e;
  }
  
  public j d()
  {
    if (this.b == null) {
      j();
    }
    return this.b;
  }
  
  public j e()
  {
    if (this.c == null) {
      k();
    }
    return this.c;
  }
  
  public i f()
  {
    if (this.g == null) {
      l();
    }
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */