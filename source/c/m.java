package c;

import c.a.b.y;
import c.a.p;
import c.b.c;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public final class m
{
  private static c a = c.a(m.class);
  private int A = 0;
  private int b = 5242880;
  private int c = 1048576;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private File o;
  private Locale p;
  private y q;
  private String r;
  private String s = p.a.b();
  private String t = p.j.b();
  private HashMap u = new HashMap();
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private String z;
  
  public m()
  {
    try
    {
      a(Boolean.getBoolean("jxl.nowarnings"));
      this.d = Boolean.getBoolean("jxl.nodrawings");
      this.e = Boolean.getBoolean("jxl.nonames");
      this.g = Boolean.getBoolean("jxl.nogc");
      this.h = Boolean.getBoolean("jxl.norat");
      this.i = Boolean.getBoolean("jxl.nomergedcellchecks");
      this.f = Boolean.getBoolean("jxl.noformulaadjust");
      this.j = Boolean.getBoolean("jxl.nopropertysets");
      this.l = Boolean.getBoolean("jxl.ignoreblanks");
      this.k = Boolean.getBoolean("jxl.nocellvalidation");
      this.m = (Boolean.getBoolean("jxl.autofilter") ^ true);
      this.n = Boolean.getBoolean("jxl.usetemporaryfileduringwrite");
      String str = System.getProperty("jxl.temporaryfileduringwritedirectory");
      if (str != null) {
        this.o = new File(str);
      }
      this.r = System.getProperty("file.encoding");
    }
    catch (SecurityException localSecurityException1)
    {
      a.a("Error accessing system properties.", localSecurityException1);
    }
    try
    {
      if ((System.getProperty("jxl.lang") != null) && (System.getProperty("jxl.country") != null)) {
        this.p = new Locale(System.getProperty("jxl.lang"), System.getProperty("jxl.country"));
      } else {
        this.p = Locale.getDefault();
      }
      if (System.getProperty("jxl.encoding") != null)
      {
        this.r = System.getProperty("jxl.encoding");
        return;
      }
    }
    catch (SecurityException localSecurityException2)
    {
      a.a("Error accessing system properties.", localSecurityException2);
      this.p = Locale.getDefault();
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    a.a(paramBoolean);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.r;
  }
  
  public y h()
  {
    if (this.q == null)
    {
      this.q = ((y)this.u.get(this.p));
      if (this.q == null)
      {
        this.q = new y(this.p);
        this.u.put(this.p, this.q);
      }
    }
    return this.q;
  }
  
  public String i()
  {
    return this.s;
  }
  
  public String j()
  {
    return this.t;
  }
  
  public boolean k()
  {
    return this.n;
  }
  
  public File l()
  {
    return this.o;
  }
  
  public boolean m()
  {
    return this.v;
  }
  
  public boolean n()
  {
    return this.w;
  }
  
  public boolean o()
  {
    return this.x;
  }
  
  public boolean p()
  {
    return this.y;
  }
  
  public int q()
  {
    return this.A;
  }
  
  public String r()
  {
    return this.z;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */