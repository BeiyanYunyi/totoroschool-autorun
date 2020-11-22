package b.a.e.e.c;

import b.a.c;
import b.a.d;
import b.a.d.h;
import b.a.e.a.e;
import b.a.e.e.b.a;
import b.a.j;
import b.a.s;
import b.a.w;
import java.util.concurrent.Callable;

final class g
{
  static <T> boolean a(Object paramObject, h<? super T, ? extends d> paramh, c paramc)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (d)b.a.e.b.b.a(paramh.apply(localObject), "The mapper returned a null CompletableSource");
        }
        if (paramObject == null)
        {
          e.complete(paramc);
          return true;
        }
        ((d)paramObject).a(paramc);
        return true;
      }
      catch (Throwable paramObject)
      {
        b.a.c.b.b((Throwable)paramObject);
        e.error((Throwable)paramObject, paramc);
        return true;
      }
    }
    return false;
  }
  
  static <T, R> boolean a(Object paramObject, h<? super T, ? extends j<? extends R>> paramh, s<? super R> params)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (j)b.a.e.b.b.a(paramh.apply(localObject), "The mapper returned a null MaybeSource");
        }
        if (paramObject == null)
        {
          e.complete(params);
          return true;
        }
        ((j)paramObject).a(a.a(params));
        return true;
      }
      catch (Throwable paramObject)
      {
        b.a.c.b.b((Throwable)paramObject);
        e.error((Throwable)paramObject, params);
        return true;
      }
    }
    return false;
  }
  
  static <T, R> boolean b(Object paramObject, h<? super T, ? extends w<? extends R>> paramh, s<? super R> params)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (w)b.a.e.b.b.a(paramh.apply(localObject), "The mapper returned a null SingleSource");
        }
        if (paramObject == null)
        {
          e.complete(params);
          return true;
        }
        ((w)paramObject).a(b.a.e.e.e.b.a(params));
        return true;
      }
      catch (Throwable paramObject)
      {
        b.a.c.b.b((Throwable)paramObject);
        e.error((Throwable)paramObject, params);
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */