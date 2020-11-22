package c.e.a;

import c.a.af;
import c.a.ag;
import c.a.aq;
import c.a.as;

class m
  extends aq
{
  private byte[] a;
  private int b;
  private as c;
  private int d;
  private int e;
  private boolean f;
  private int g;
  private boolean h;
  
  void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  void a(af paramaf)
  {
    this.d = paramaf.a(this.d);
  }
  
  public byte[] a()
  {
    this.a = new byte[12];
    ag.a(this.b, this.a, 0);
    ag.a(this.b, this.a, 2);
    ag.a(this.e, this.a, 4);
    ag.a(this.d, this.a, 6);
    int j = this.g << 8 | 0x6;
    int i = j;
    if (this.f) {
      i = j | 0x1;
    }
    this.g = ((i & 0x700) / 256);
    j = i;
    if (this.h) {
      j = i | 0x1000;
    }
    ag.a(j, this.a, 8);
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public as d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof m)) {
      return false;
    }
    paramObject = (m)paramObject;
    if ((this.b == ((m)paramObject).b) && (this.d == ((m)paramObject).d) && (this.e == ((m)paramObject).e) && (this.f == ((m)paramObject).f) && (this.g == ((m)paramObject).g))
    {
      if (this.h != ((m)paramObject).h) {
        return false;
      }
      if (((this.c == null) && (((m)paramObject).c != null)) || ((this.c != null) && (((m)paramObject).c == null))) {
        return false;
      }
      return this.c.equals(((m)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */