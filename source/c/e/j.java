package c.e;

import c.c.e;
import c.c.f;
import c.c.n;
import c.c.o;
import c.e.a.cs;

public class j
  extends cs
{
  public static final b b = new b("Arial");
  public static final b c = new b("Times New Roman");
  public static final b d = new b("Courier New");
  public static final b e = new b("Tahoma");
  public static final a f = new a(400);
  public static final a g = new a(700);
  
  public j(f paramf)
  {
    super(paramf);
  }
  
  public j(b paramb)
  {
    this(paramb, 10, f, false, o.a, e.b, n.a);
  }
  
  public j(b paramb, int paramInt, a parama, boolean paramBoolean, o paramo, e parame)
  {
    this(paramb, paramInt, parama, paramBoolean, paramo, parame, n.a);
  }
  
  public j(b paramb, int paramInt, a parama, boolean paramBoolean, o paramo, e parame, n paramn)
  {
    super(paramb.a, paramInt, parama.a, paramBoolean, paramo.a(), parame.a(), paramn.a());
  }
  
  public boolean n()
  {
    return super.n();
  }
  
  static class a
  {
    public int a;
    
    a(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static class b
  {
    String a;
    
    b(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */