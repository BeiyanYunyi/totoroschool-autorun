package com.amap.api.mapcore.util;

public class ed
{
  b a;
  
  public ed(int paramInt1, int paramInt2)
  {
    this.a = new b(new c(0, 0, paramInt1, paramInt2));
  }
  
  public int a()
  {
    return this.a.b.c;
  }
  
  public c a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.a.a(paramInt1, paramInt2, paramString);
    if (paramString != null) {
      return new c(paramString.b.a, paramString.b.b, paramString.b.c, paramString.b.d);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public int b()
  {
    return this.a.b.d;
  }
  
  static enum a
  {
    private a() {}
  }
  
  class b
  {
    String a;
    ed.c b;
    b c = null;
    b d = null;
    
    b(ed.c paramc)
    {
      this.b = paramc;
    }
    
    b a(int paramInt1, int paramInt2, String paramString)
    {
      if (!a())
      {
        b localb = this.c.a(paramInt1, paramInt2, paramString);
        localObject = localb;
        if (localb == null) {
          localObject = this.d.a(paramInt1, paramInt2, paramString);
        }
        return (b)localObject;
      }
      if (this.a != null) {
        return null;
      }
      Object localObject = b(paramInt1, paramInt2);
      switch (ed.1.a[localObject.ordinal()])
      {
      default: 
        break;
      case 3: 
        a(paramInt1, paramInt2);
        break;
      case 2: 
        this.a = paramString;
        return this;
      case 1: 
        return null;
      }
      return this.c.a(paramInt1, paramInt2, paramString);
    }
    
    void a(int paramInt1, int paramInt2)
    {
      int i = this.b.c - paramInt1;
      int j = this.b.d - paramInt2;
      if ((!e) && (i < 0)) {
        throw new AssertionError();
      }
      if ((!e) && (j < 0)) {
        throw new AssertionError();
      }
      ed.c localc1;
      ed.c localc2;
      if (i > j)
      {
        localc1 = new ed.c(this.b.a, this.b.b, paramInt1, this.b.d);
        localc2 = new ed.c(localc1.a + paramInt1, this.b.b, this.b.c - paramInt1, this.b.d);
      }
      else
      {
        localc1 = new ed.c(this.b.a, this.b.b, this.b.c, paramInt2);
        localc2 = new ed.c(this.b.a, localc1.b + paramInt2, this.b.c, this.b.d - paramInt2);
      }
      this.c = new b(ed.this, localc1);
      this.d = new b(ed.this, localc2);
    }
    
    boolean a()
    {
      return this.c == null;
    }
    
    boolean a(String paramString)
    {
      if (a())
      {
        if (paramString.equals(this.a))
        {
          this.a = null;
          return true;
        }
        return false;
      }
      boolean bool2 = this.c.a(paramString);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = this.d.a(paramString);
      }
      if ((bool1) && (!this.c.b()) && (!this.d.b()))
      {
        this.c = null;
        this.d = null;
      }
      return bool1;
    }
    
    ed.a b(int paramInt1, int paramInt2)
    {
      if ((paramInt1 <= this.b.c) && (paramInt2 <= this.b.d))
      {
        if ((paramInt1 == this.b.c) && (paramInt2 == this.b.d)) {
          return ed.a.b;
        }
        return ed.a.c;
      }
      return ed.a.a;
    }
    
    boolean b()
    {
      return (this.a != null) || (!a());
    }
  }
  
  public static class c
  {
    public int a;
    public int b;
    public int c;
    public int d;
    
    c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ x: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", y: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", w: ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", h: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */