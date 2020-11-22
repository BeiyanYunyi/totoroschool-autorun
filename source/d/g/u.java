package d.g;

import d.c.b.h;

class u
  extends t
{
  public static final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    h.b(paramString1, "$this$regionMatches");
    h.b(paramString2, "other");
    if (!paramBoolean) {
      return paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
    }
    return paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
  }
  
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    if (!paramBoolean) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public static final boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    h.b(paramString1, "$this$startsWith");
    h.b(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2);
    }
    return m.a(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */