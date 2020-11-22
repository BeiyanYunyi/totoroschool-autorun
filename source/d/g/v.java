package d.g;

import d.c.b.h;
import d.d.c;
import d.d.d;

class v
  extends u
{
  public static final int a(CharSequence paramCharSequence)
  {
    h.b(paramCharSequence, "$this$lastIndex");
    return paramCharSequence.length() - 1;
  }
  
  private static final int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    d.d.a locala;
    if (!paramBoolean2) {
      locala = (d.d.a)new c(d.c(paramInt1, 0), d.d(paramInt2, paramCharSequence1.length()));
    } else {
      locala = d.a(d.d(paramInt1, m.a(paramCharSequence1)), d.c(paramInt2, 0));
    }
    int i;
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      paramInt1 = locala.a();
      paramInt2 = locala.b();
      i = locala.c();
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (m.a((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    else
    {
      paramInt1 = locala.a();
      paramInt2 = locala.b();
      i = locala.c();
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (m.a(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    return -1;
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    h.b(paramCharSequence, "$this$indexOf");
    h.b(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).indexOf(paramString, paramInt);
    }
    return a(paramCharSequence, (CharSequence)paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16, null);
  }
  
  public static final boolean a(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    h.b(paramCharSequence1, "$this$regionMatchesImpl");
    h.b(paramCharSequence2, "other");
    if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 <= paramCharSequence1.length() - paramInt3))
    {
      if (paramInt2 > paramCharSequence2.length() - paramInt3) {
        return false;
      }
      int i = 0;
      while (i < paramInt3)
      {
        if (!a.a(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    h.b(paramCharSequence1, "$this$contains");
    h.b(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String))
    {
      if (m.a(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2, null) < 0) {}
    }
    else {
      while (a(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean, false, 16, null) >= 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */