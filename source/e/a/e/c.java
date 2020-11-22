package e.a.e;

import e.s;
import f.f;

public final class c
{
  public static final f a = f.encodeUtf8(":");
  public static final f b = f.encodeUtf8(":status");
  public static final f c = f.encodeUtf8(":method");
  public static final f d = f.encodeUtf8(":path");
  public static final f e = f.encodeUtf8(":scheme");
  public static final f f = f.encodeUtf8(":authority");
  public final f g;
  public final f h;
  final int i;
  
  public c(f paramf1, f paramf2)
  {
    this.g = paramf1;
    this.h = paramf2;
    this.i = (paramf1.size() + 32 + paramf2.size());
  }
  
  public c(f paramf, String paramString)
  {
    this(paramf, f.encodeUtf8(paramString));
  }
  
  public c(String paramString1, String paramString2)
  {
    this(f.encodeUtf8(paramString1), f.encodeUtf8(paramString2));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof c;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (c)paramObject;
      bool1 = bool2;
      if (this.g.equals(((c)paramObject).g))
      {
        bool1 = bool2;
        if (this.h.equals(((c)paramObject).h)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.g.hashCode()) * 31 + this.h.hashCode();
  }
  
  public String toString()
  {
    return e.a.c.a("%s: %s", new Object[] { this.g.utf8(), this.h.utf8() });
  }
  
  static abstract interface a
  {
    public abstract void a(s params);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */