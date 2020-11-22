package c.a;

import c.a.b.ar;
import c.a.b.t;
import c.a.b.v;
import c.a.b.w;
import c.b.a;
import c.b.c;
import c.m;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class q
{
  public static final b a = new b(0, "any");
  public static final b b = new b(1, "int");
  public static final b c = new b(2, "dec");
  public static final b d = new b(3, "list");
  public static final b e = new b(4, "date");
  public static final b f = new b(5, "time");
  public static final b g = new b(6, "strlen");
  public static final b h = new b(7, "form");
  public static final c i = new c(0);
  public static final c j = new c(1);
  public static final c k = new c(2);
  public static final a l = new a(0, "{0} <= x <= {1}");
  public static final a m = new a(1, "!({0} <= x <= {1}");
  public static final a n = new a(2, "x == {0}");
  public static final a o = new a(3, "x != {0}");
  public static final a p = new a(4, "x > {0}");
  public static final a q = new a(5, "x < {0}");
  public static final a r = new a(6, "x >= {0}");
  public static final a s = new a(7, "x <= {0}");
  private static c t = c.a(q.class);
  private static DecimalFormat u = new DecimalFormat("#.#");
  private boolean A;
  private boolean B;
  private boolean C;
  private String D;
  private String E;
  private String F;
  private String G;
  private w H;
  private String I;
  private w J;
  private String K;
  private int L;
  private int M;
  private int N;
  private int O;
  private boolean P;
  private boolean Q;
  private b v;
  private c w;
  private a x;
  private boolean y;
  private boolean z;
  
  public q(q paramq)
  {
    this.Q = true;
    this.v = paramq.v;
    this.w = paramq.w;
    this.x = paramq.x;
    this.y = paramq.y;
    this.z = paramq.z;
    this.A = paramq.A;
    this.B = paramq.B;
    this.C = paramq.C;
    this.D = paramq.D;
    this.F = paramq.F;
    this.E = paramq.E;
    this.G = paramq.G;
    this.P = paramq.P;
    this.M = paramq.M;
    this.O = paramq.O;
    this.L = paramq.L;
    this.N = paramq.N;
    if (paramq.I != null)
    {
      this.I = paramq.I;
      this.K = paramq.K;
      return;
    }
    for (;;)
    {
      try
      {
        this.I = paramq.H.b();
        if (paramq.J != null)
        {
          paramq = paramq.J.b();
          this.K = paramq;
          return;
        }
      }
      catch (v paramq)
      {
        c localc = t;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot parse validation formula:  ");
        localStringBuilder.append(paramq.getMessage());
        localc.b(localStringBuilder.toString());
        return;
      }
      paramq = null;
    }
  }
  
  public q(byte[] paramArrayOfByte, t paramt, ao paramao, m paramm)
  {
    boolean bool2 = true;
    if (paramao != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    this.Q = false;
    int i1 = ag.a(paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3]);
    this.v = b.a(i1 & 0xF);
    this.w = c.a((i1 & 0x70) >> 4);
    this.x = a.a((0xF00000 & i1) >> 20);
    if ((i1 & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.y = bool1;
    if ((i1 & 0x100) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.z = bool1;
    if ((i1 & 0x200) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.A = bool1;
    if ((0x40000 & i1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.B = bool1;
    if ((i1 & 0x80000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.C = bool1;
    int i2 = ag.a(paramArrayOfByte[4], paramArrayOfByte[5]);
    i1 = 7;
    if ((i2 > 0) && (paramArrayOfByte[6] == 0))
    {
      this.D = am.a(paramArrayOfByte, i2, 7, paramm);
      i1 = i2 + 3 + 4;
    }
    else if (i2 > 0)
    {
      this.D = am.a(paramArrayOfByte, i2, 7);
      i1 = i2 * 2 + 3 + 4;
    }
    i2 = ag.a(paramArrayOfByte[i1], paramArrayOfByte[(i1 + 1)]);
    if ((i2 > 0) && (paramArrayOfByte[(i1 + 2)] == 0))
    {
      this.E = am.a(paramArrayOfByte, i2, i1 + 3, paramm);
      i1 += i2 + 3;
    }
    else if (i2 > 0)
    {
      this.E = am.a(paramArrayOfByte, i2, i1 + 3);
      i1 += i2 * 2 + 3;
    }
    else
    {
      i1 += 3;
    }
    i2 = ag.a(paramArrayOfByte[i1], paramArrayOfByte[(i1 + 1)]);
    if ((i2 > 0) && (paramArrayOfByte[(i1 + 2)] == 0))
    {
      this.F = am.a(paramArrayOfByte, i2, i1 + 3, paramm);
      i1 += i2 + 3;
    }
    else if (i2 > 0)
    {
      this.F = am.a(paramArrayOfByte, i2, i1 + 3);
      i1 += i2 * 2 + 3;
    }
    else
    {
      i1 += 3;
    }
    i2 = ag.a(paramArrayOfByte[i1], paramArrayOfByte[(i1 + 1)]);
    if ((i2 > 0) && (paramArrayOfByte[(i1 + 2)] == 0))
    {
      this.G = am.a(paramArrayOfByte, i2, i1 + 3, paramm);
      i1 += i2 + 3;
    }
    else if (i2 > 0)
    {
      this.G = am.a(paramArrayOfByte, i2, i1 + 3);
      i1 += i2 * 2 + 3;
    }
    else
    {
      i1 += 3;
    }
    i2 = ag.a(paramArrayOfByte[i1], paramArrayOfByte[(i1 + 1)]);
    i1 += 4;
    int i4 = i1 + i2;
    int i3 = ag.a(paramArrayOfByte[i4], paramArrayOfByte[(i4 + 1)]);
    i4 += 4;
    int i5 = i4 + i3 + 2;
    this.M = ag.a(paramArrayOfByte[i5], paramArrayOfByte[(i5 + 1)]);
    i5 += 2;
    this.O = ag.a(paramArrayOfByte[i5], paramArrayOfByte[(i5 + 1)]);
    i5 += 2;
    this.L = ag.a(paramArrayOfByte[i5], paramArrayOfByte[(i5 + 1)]);
    i5 += 2;
    this.N = ag.a(paramArrayOfByte[i5], paramArrayOfByte[(i5 + 1)]);
    boolean bool1 = bool2;
    if (this.M == this.O)
    {
      bool1 = bool2;
      if (this.L == this.N) {
        bool1 = false;
      }
    }
    this.P = bool1;
    try
    {
      x localx = new x(this.L, this.M);
      byte[] arrayOfByte;
      if (i2 != 0)
      {
        arrayOfByte = new byte[i2];
        System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, i2);
        this.H = new w(arrayOfByte, localx, paramt, paramao, paramm, ar.b);
        this.H.a();
      }
      if (i3 != 0)
      {
        arrayOfByte = new byte[i3];
        System.arraycopy(paramArrayOfByte, i4, arrayOfByte, 0, i3);
        this.J = new w(arrayOfByte, localx, paramt, paramao, paramm, ar.b);
        this.J.a();
        return;
      }
    }
    catch (v paramArrayOfByte)
    {
      paramt = t;
      paramao = new StringBuilder();
      paramao.append(paramArrayOfByte.getMessage());
      paramao.append(" for cells ");
      paramao.append(k.a(this.L, this.M));
      paramao.append("-");
      paramao.append(k.a(this.N, this.O));
      paramt.b(paramao.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, t paramt, ao paramao, m paramm)
    throws v
  {
    if (this.P) {
      return;
    }
    this.M = paramInt2;
    this.O = paramInt2;
    this.L = paramInt1;
    this.N = paramInt1;
    this.H = new w(this.I, paramt, paramao, paramm, ar.b);
    this.H.a();
    if (this.K != null)
    {
      this.J = new w(this.K, paramt, paramao, paramm, ar.b);
      this.J.a();
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte1;
    if (this.H != null) {
      arrayOfByte1 = this.H.c();
    } else {
      arrayOfByte1 = new byte[0];
    }
    byte[] arrayOfByte2;
    if (this.J != null) {
      arrayOfByte2 = this.J.c();
    } else {
      arrayOfByte2 = new byte[0];
    }
    byte[] arrayOfByte3 = new byte[this.D.length() * 2 + 4 + 3 + this.E.length() * 2 + 3 + this.F.length() * 2 + 3 + this.G.length() * 2 + 3 + arrayOfByte1.length + 2 + arrayOfByte2.length + 2 + 4 + 10];
    int i2 = this.v.a() | 0x0 | this.w.a() << 4 | this.x.a() << 20;
    int i1 = i2;
    if (this.y) {
      i1 = i2 | 0x80;
    }
    i2 = i1;
    if (this.z) {
      i2 = i1 | 0x100;
    }
    i1 = i2;
    if (this.A) {
      i1 = i2 | 0x200;
    }
    i2 = i1;
    if (this.B) {
      i2 = i1 | 0x40000;
    }
    i1 = i2;
    if (this.C) {
      i1 = i2 | 0x80000;
    }
    ag.b(i1, arrayOfByte3, 0);
    ag.a(this.D.length(), arrayOfByte3, 4);
    arrayOfByte3[6] = 1;
    am.b(this.D, arrayOfByte3, 7);
    i1 = 7 + this.D.length() * 2;
    ag.a(this.E.length(), arrayOfByte3, i1);
    i1 += 2;
    arrayOfByte3[i1] = 1;
    i1 += 1;
    am.b(this.E, arrayOfByte3, i1);
    i1 += this.E.length() * 2;
    ag.a(this.F.length(), arrayOfByte3, i1);
    i1 += 2;
    arrayOfByte3[i1] = 1;
    i1 += 1;
    am.b(this.F, arrayOfByte3, i1);
    i1 += this.F.length() * 2;
    ag.a(this.G.length(), arrayOfByte3, i1);
    i1 += 2;
    arrayOfByte3[i1] = 1;
    i1 += 1;
    am.b(this.G, arrayOfByte3, i1);
    i1 += this.G.length() * 2;
    ag.a(arrayOfByte1.length, arrayOfByte3, i1);
    i1 += 4;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, i1, arrayOfByte1.length);
    i1 += arrayOfByte1.length;
    ag.a(arrayOfByte2.length, arrayOfByte3, i1);
    i1 += 4;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, i1, arrayOfByte2.length);
    i1 += arrayOfByte2.length;
    ag.a(1, arrayOfByte3, i1);
    i1 += 2;
    ag.a(this.M, arrayOfByte3, i1);
    i1 += 2;
    ag.a(this.O, arrayOfByte3, i1);
    i1 += 2;
    ag.a(this.L, arrayOfByte3, i1);
    ag.a(this.N, arrayOfByte3, i1 + 2);
    return arrayOfByte3;
  }
  
  public int b()
  {
    return this.L;
  }
  
  public int c()
  {
    return this.N;
  }
  
  public int d()
  {
    return this.M;
  }
  
  public int e()
  {
    return this.O;
  }
  
  public boolean f()
  {
    return this.P;
  }
  
  public boolean g()
  {
    return this.Q;
  }
  
  public static class a
  {
    private static a[] c = new a[0];
    private int a;
    private MessageFormat b;
    
    a(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = new MessageFormat(paramString);
      paramString = c;
      c = new a[paramString.length + 1];
      System.arraycopy(paramString, 0, c, 0, paramString.length);
      c[paramString.length] = this;
    }
    
    static a a(int paramInt)
    {
      a locala = null;
      int i = 0;
      while ((i < c.length) && (locala == null))
      {
        if (c[i].a == paramInt) {
          locala = c[i];
        }
        i += 1;
      }
      return locala;
    }
    
    public int a()
    {
      return this.a;
    }
  }
  
  public static class b
  {
    private static b[] c = new b[0];
    private int a;
    private String b;
    
    b(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
      paramString = c;
      c = new b[paramString.length + 1];
      System.arraycopy(paramString, 0, c, 0, paramString.length);
      c[paramString.length] = this;
    }
    
    static b a(int paramInt)
    {
      b localb = null;
      int i = 0;
      while ((i < c.length) && (localb == null))
      {
        if (c[i].a == paramInt) {
          localb = c[i];
        }
        i += 1;
      }
      return localb;
    }
    
    public int a()
    {
      return this.a;
    }
  }
  
  public static class c
  {
    private static c[] b = new c[0];
    private int a;
    
    c(int paramInt)
    {
      this.a = paramInt;
      c[] arrayOfc = b;
      b = new c[arrayOfc.length + 1];
      System.arraycopy(arrayOfc, 0, b, 0, arrayOfc.length);
      b[arrayOfc.length] = this;
    }
    
    static c a(int paramInt)
    {
      c localc = null;
      int i = 0;
      while ((i < b.length) && (localc == null))
      {
        if (b[i].a == paramInt) {
          localc = b[i];
        }
        i += 1;
      }
      return localc;
    }
    
    public int a()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */