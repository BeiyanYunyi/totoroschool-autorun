package f;

import javax.annotation.Nullable;

final class p
{
  @Nullable
  static o a;
  static long b;
  
  static o a()
  {
    try
    {
      if (a != null)
      {
        o localo = a;
        a = localo.f;
        localo.f = null;
        b -= 8192L;
        return localo;
      }
      return new o();
    }
    finally {}
  }
  
  static void a(o paramo)
  {
    if ((paramo.f == null) && (paramo.g == null))
    {
      if (paramo.d) {
        return;
      }
      try
      {
        if (b + 8192L > 65536L) {
          return;
        }
        b += 8192L;
        paramo.f = a;
        paramo.c = 0;
        paramo.b = 0;
        a = paramo;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */