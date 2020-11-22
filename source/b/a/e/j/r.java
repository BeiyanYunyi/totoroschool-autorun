package b.a.e.j;

import b.a.e.c.f;
import b.a.e.c.g;
import b.a.e.f.c;
import b.a.s;

public final class r
{
  public static <T> g<T> a(int paramInt)
  {
    if (paramInt < 0) {
      return new c(-paramInt);
    }
    return new b.a.e.f.b(paramInt);
  }
  
  public static <T, U> void a(f<T> paramf, s<? super U> params, boolean paramBoolean, b.a.b.b paramb, o<T, U> paramo)
  {
    int i = 1;
    if (a(paramo.b(), paramf.isEmpty(), params, paramBoolean, paramf, paramb, paramo)) {
      return;
    }
    for (;;)
    {
      boolean bool2 = paramo.b();
      Object localObject = paramf.poll();
      boolean bool1;
      if (localObject == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (a(bool2, bool1, params, paramBoolean, paramf, paramb, paramo)) {
        return;
      }
      if (bool1)
      {
        int j = paramo.a(-i);
        i = j;
        if (j != 0) {
          break;
        }
        return;
      }
      paramo.a(params, localObject);
    }
  }
  
  public static <T, U> boolean a(boolean paramBoolean1, boolean paramBoolean2, s<?> params, boolean paramBoolean3, g<?> paramg, b.a.b.b paramb, o<T, U> paramo)
  {
    if (paramo.a())
    {
      paramg.clear();
      paramb.dispose();
      return true;
    }
    if (paramBoolean1) {
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          if (paramb != null) {
            paramb.dispose();
          }
          paramg = paramo.e();
          if (paramg != null)
          {
            params.onError(paramg);
            return true;
          }
          params.onComplete();
          return true;
        }
      }
      else
      {
        paramo = paramo.e();
        if (paramo != null)
        {
          paramg.clear();
          if (paramb != null) {
            paramb.dispose();
          }
          params.onError(paramo);
          return true;
        }
        if (paramBoolean2)
        {
          if (paramb != null) {
            paramb.dispose();
          }
          params.onComplete();
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */