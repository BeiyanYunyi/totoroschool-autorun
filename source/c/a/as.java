package c.a;

import c.c.b;
import c.c.d;
import c.c.g;
import c.c.h;
import c.c.l;
import c.c.p;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class as
  extends aq
  implements d
{
  private static final int[] N = { 14, 15, 16, 17, 18, 19, 20, 21, 22, 45, 46, 47 };
  private static final DateFormat[] O = { SimpleDateFormat.getDateInstance(3), SimpleDateFormat.getDateInstance(2), new SimpleDateFormat("d-MMM"), new SimpleDateFormat("MMM-yy"), new SimpleDateFormat("h:mm a"), new SimpleDateFormat("h:mm:ss a"), new SimpleDateFormat("H:mm"), new SimpleDateFormat("H:mm:ss"), new SimpleDateFormat("M/d/yy H:mm"), new SimpleDateFormat("mm:ss"), new SimpleDateFormat("H:mm:ss"), new SimpleDateFormat("mm:ss.S") };
  private static int[] P = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 37, 38, 39, 40, 41, 42, 43, 44, 48 };
  private static NumberFormat[] Q = { new DecimalFormat("0"), new DecimalFormat("0.00"), new DecimalFormat("#,##0"), new DecimalFormat("#,##0.00"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("0%"), new DecimalFormat("0.00%"), new DecimalFormat("0.00E00"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("##0.0E0") };
  public static final a b = new a(null);
  public static final a c = new a(null);
  protected static final b d = new b(null);
  protected static final b e = new b(null);
  private static c.b.c f = c.b.c.a(as.class);
  private c.c.e A;
  private c.c.e B;
  private l C;
  private int D;
  private int E;
  private aa F;
  private v G;
  private boolean H;
  private boolean I;
  private g J;
  private boolean K;
  private boolean L;
  private ad M;
  private a R;
  public int a;
  private int g;
  private b h;
  private NumberFormat i;
  private byte j;
  private int k;
  private boolean l;
  private boolean m;
  private c.c.a n;
  private p o;
  private h p;
  private boolean q;
  private int r;
  private boolean s;
  private c.c.c t;
  private c.c.c u;
  private c.c.c v;
  private c.c.c w;
  private c.c.e x;
  private c.c.e y;
  private c.c.e z;
  
  public as(aa paramaa, v paramv)
  {
    super(an.H);
    boolean bool2 = false;
    this.H = false;
    this.l = true;
    this.m = false;
    this.n = c.c.a.a;
    this.o = p.c;
    this.p = h.a;
    this.q = false;
    this.t = c.c.c.a;
    this.u = c.c.c.a;
    this.v = c.c.c.a;
    this.w = c.c.c.a;
    this.x = c.c.e.ai;
    this.y = c.c.e.ai;
    this.z = c.c.e.ai;
    this.A = c.c.e.ai;
    this.C = l.a;
    this.B = c.c.e.e;
    this.r = 0;
    this.s = false;
    this.j = 124;
    this.g = 0;
    this.h = null;
    this.F = paramaa;
    this.G = paramv;
    this.R = b;
    this.I = false;
    this.L = false;
    this.K = true;
    if (this.F != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    c.b.a.a(bool1);
    boolean bool1 = bool2;
    if (this.G != null) {
      bool1 = true;
    }
    c.b.a.a(bool1);
  }
  
  protected as(as paramas)
  {
    super(an.H);
    this.H = false;
    this.l = paramas.l;
    this.m = paramas.m;
    this.n = paramas.n;
    this.o = paramas.o;
    this.p = paramas.p;
    this.q = paramas.q;
    this.t = paramas.t;
    this.u = paramas.u;
    this.v = paramas.v;
    this.w = paramas.w;
    this.x = paramas.x;
    this.y = paramas.y;
    this.z = paramas.z;
    this.A = paramas.A;
    this.C = paramas.C;
    this.h = paramas.h;
    this.r = paramas.r;
    this.s = paramas.s;
    this.g = paramas.g;
    this.B = paramas.B;
    this.F = paramas.F;
    this.G = paramas.G;
    this.k = paramas.k;
    this.a = paramas.a;
    this.K = paramas.K;
    this.R = b;
    this.I = false;
    this.L = true;
  }
  
  private void p()
  {
    if ((this.a < f.a.length) && (f.a[this.a] != null)) {
      this.J = f.a[this.a];
    } else {
      this.J = this.M.a(this.a);
    }
    this.F = this.M.a().a(this.k);
    byte[] arrayOfByte = l_().a();
    int i1 = ag.a(arrayOfByte[4], arrayOfByte[5]);
    this.g = ((0xFFF0 & i1) >> 4);
    b localb;
    if ((i1 & 0x4) == 0) {
      localb = d;
    } else {
      localb = e;
    }
    this.h = localb;
    boolean bool2 = false;
    if ((i1 & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    if ((i1 & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    if ((this.h == d) && ((this.g & 0xFFF) == 4095))
    {
      this.g = 0;
      f.b("Invalid parent format found - ignoring");
    }
    i1 = ag.a(arrayOfByte[6], arrayOfByte[7]);
    if ((i1 & 0x8) != 0) {
      this.q = true;
    }
    this.n = c.c.a.a(i1 & 0x7);
    this.o = p.a(i1 >> 4 & 0x7);
    this.p = h.a(i1 >> 8 & 0xFF);
    i1 = ag.a(arrayOfByte[8], arrayOfByte[9]);
    this.r = (i1 & 0xF);
    boolean bool1 = bool2;
    if ((i1 & 0x10) != 0) {
      bool1 = true;
    }
    this.s = bool1;
    if (this.R == b) {
      this.j = arrayOfByte[9];
    }
    i1 = ag.a(arrayOfByte[10], arrayOfByte[11]);
    this.t = c.c.c.a(i1 & 0x7);
    this.u = c.c.c.a(i1 >> 4 & 0x7);
    this.v = c.c.c.a(i1 >> 8 & 0x7);
    this.w = c.c.c.a(i1 >> 12 & 0x7);
    i1 = ag.a(arrayOfByte[12], arrayOfByte[13]);
    this.x = c.c.e.a(i1 & 0x7F);
    this.y = c.c.e.a((i1 & 0x3F80) >> 7);
    i1 = ag.a(arrayOfByte[14], arrayOfByte[15]);
    this.z = c.c.e.a(i1 & 0x7F);
    this.A = c.c.e.a((i1 & 0x3F80) >> 7);
    if (this.R == b)
    {
      this.C = l.a((ag.a(arrayOfByte[16], arrayOfByte[17]) & 0xFC00) >> 10);
      this.B = c.c.e.a(ag.a(arrayOfByte[18], arrayOfByte[19]) & 0x3F);
      if ((this.B == c.c.e.a) || (this.B == c.c.e.d)) {
        this.B = c.c.e.e;
      }
    }
    else
    {
      this.C = l.a;
      this.B = c.c.e.e;
    }
    this.K = true;
  }
  
  public c.c.c a(b paramb)
  {
    if ((paramb != b.a) && (paramb != b.b))
    {
      if (!this.K) {
        p();
      }
      if (paramb == b.e) {
        return this.t;
      }
      if (paramb == b.f) {
        return this.u;
      }
      if (paramb == b.c) {
        return this.v;
      }
      if (paramb == b.d) {
        return this.w;
      }
      return c.c.c.a;
    }
    return c.c.c.a;
  }
  
  protected final void a(int paramInt)
  {
    this.D = (paramInt | this.D);
  }
  
  public final void a(int paramInt, ad paramad, ab paramab)
    throws ai
  {
    this.E = paramInt;
    this.M = paramad;
    if ((!this.I) && (!this.L))
    {
      if (!this.F.c()) {
        paramab.a(this.F);
      }
      if (!this.G.g_()) {
        paramad.a(this.G);
      }
      this.k = this.F.e();
      this.a = this.G.f_();
      this.H = true;
      return;
    }
    this.H = true;
  }
  
  public void a(aa paramaa)
  {
    this.F = paramaa;
  }
  
  void a(af paramaf)
  {
    this.E = paramaf.a(this.E);
    if (this.h == d) {
      this.g = paramaf.a(this.g);
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    this.h = paramb;
    this.g = paramInt;
  }
  
  protected void a(b paramb, c.c.c paramc, c.c.e parame)
  {
    c.b.a.a(this.H ^ true);
    c.c.e locale;
    if (parame != c.c.e.b)
    {
      locale = parame;
      if (parame != c.c.e.a) {}
    }
    else
    {
      locale = c.c.e.f;
    }
    if (paramb == b.e)
    {
      this.t = paramc;
      this.x = locale;
    }
    else if (paramb == b.f)
    {
      this.u = paramc;
      this.y = locale;
    }
    else if (paramb == b.c)
    {
      this.v = paramc;
      this.z = locale;
    }
    else if (paramb == b.d)
    {
      this.w = paramc;
      this.A = locale;
    }
    this.j = ((byte)(this.j | 0x20));
  }
  
  protected final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    this.j = ((byte)(this.j | 0x80));
  }
  
  public byte[] a()
  {
    if (!this.K) {
      p();
    }
    byte[] arrayOfByte = new byte[20];
    int i1 = this.k;
    int i2 = 0;
    ag.a(i1, arrayOfByte, 0);
    ag.a(this.a, arrayOfByte, 2);
    if (e()) {
      i2 = 1;
    }
    i1 = i2;
    if (f()) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (this.h == e)
    {
      i2 = i1 | 0x4;
      this.g = 65535;
    }
    ag.a(this.g << 4 | i2, arrayOfByte, 4);
    i2 = this.n.a();
    i1 = i2;
    if (this.q) {
      i1 = i2 | 0x8;
    }
    ag.a(i1 | this.o.a() << 4 | this.p.a() << 8, arrayOfByte, 6);
    arrayOfByte[9] = 16;
    i1 = this.t.a();
    i1 = this.u.a() << 4 | i1 | this.v.a() << 8 | this.w.a() << 12;
    ag.a(i1, arrayOfByte, 10);
    if (i1 != 0)
    {
      i1 = (byte)this.x.a();
      i2 = (byte)this.y.a();
      int i3 = (byte)this.z.a();
      int i4 = (byte)this.A.a();
      ag.a(i1 & 0x7F | (i2 & 0x7F) << 7, arrayOfByte, 12);
      ag.a(i3 & 0x7F | (i4 & 0x7F) << 7, arrayOfByte, 14);
    }
    ag.a(this.C.a() << 10, arrayOfByte, 16);
    ag.a(this.B.a() | 0x2000, arrayOfByte, 18);
    this.D |= this.r & 0xF;
    if (this.s) {
      this.D = (0x10 | this.D);
    } else {
      this.D &= 0xEF;
    }
    arrayOfByte[8] = ((byte)this.D);
    if (this.R == b) {
      arrayOfByte[9] = this.j;
    }
    return arrayOfByte;
  }
  
  public c.c.e b(b paramb)
  {
    if ((paramb != b.a) && (paramb != b.b))
    {
      if (!this.K) {
        p();
      }
      if (paramb == b.e) {
        return this.x;
      }
      if (paramb == b.f) {
        return this.y;
      }
      if (paramb == b.c) {
        return this.z;
      }
      if (paramb == b.d) {
        return this.A;
      }
      return c.c.e.b;
    }
    return c.c.e.f;
  }
  
  void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public NumberFormat c()
  {
    return this.i;
  }
  
  void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int d()
  {
    return this.a;
  }
  
  protected final boolean e()
  {
    return this.l;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof as)) {
      return false;
    }
    paramObject = (as)paramObject;
    if (!this.K) {
      p();
    }
    if (!((as)paramObject).K) {
      ((as)paramObject).p();
    }
    if ((this.h == ((as)paramObject).h) && (this.g == ((as)paramObject).g) && (this.l == ((as)paramObject).l) && (this.m == ((as)paramObject).m))
    {
      if (this.j != ((as)paramObject).j) {
        return false;
      }
      if ((this.n == ((as)paramObject).n) && (this.o == ((as)paramObject).o) && (this.p == ((as)paramObject).p) && (this.q == ((as)paramObject).q) && (this.s == ((as)paramObject).s))
      {
        if (this.r != ((as)paramObject).r) {
          return false;
        }
        if ((this.t == ((as)paramObject).t) && (this.u == ((as)paramObject).u) && (this.v == ((as)paramObject).v))
        {
          if (this.w != ((as)paramObject).w) {
            return false;
          }
          if ((this.x == ((as)paramObject).x) && (this.y == ((as)paramObject).y) && (this.z == ((as)paramObject).z))
          {
            if (this.A != ((as)paramObject).A) {
              return false;
            }
            if (this.B == ((as)paramObject).B)
            {
              if (this.C != ((as)paramObject).C) {
                return false;
              }
              if ((this.H) && (((as)paramObject).H))
              {
                if ((this.k != ((as)paramObject).k) || (this.a != ((as)paramObject).a)) {
                  return false;
                }
              }
              else
              {
                if (!this.F.equals(((as)paramObject).F)) {
                  break label354;
                }
                if (!this.G.equals(((as)paramObject).G)) {
                  return false;
                }
              }
              return true;
              label354:
              return false;
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  protected final boolean f()
  {
    return this.m;
  }
  
  public final boolean h()
  {
    if (!this.K) {
      p();
    }
    return (this.t != c.c.c.a) || (this.u != c.c.c.a) || (this.v != c.c.c.a) || (this.w != c.c.c.a);
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void i()
  {
    if (this.H == true) {
      f.b("A default format has been initialized");
    }
    this.H = false;
  }
  
  public final int j()
  {
    return this.E;
  }
  
  public final boolean k()
  {
    return this.H;
  }
  
  public final boolean l()
  {
    return this.I;
  }
  
  public c.c.f m()
  {
    if (!this.K) {
      p();
    }
    return this.F;
  }
  
  public int n()
  {
    return this.k;
  }
  
  private static class a {}
  
  private static class b {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */