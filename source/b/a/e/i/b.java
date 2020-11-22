package b.a.e.i;

import b.a.c.e;
import b.a.e.j.d;
import b.a.h.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public enum b
  implements c
{
  private b() {}
  
  public static boolean cancel(AtomicReference<c> paramAtomicReference)
  {
    if ((c)paramAtomicReference.get() != CANCELLED)
    {
      paramAtomicReference = (c)paramAtomicReference.getAndSet(CANCELLED);
      if (paramAtomicReference != CANCELLED)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.cancel();
        }
        return true;
      }
    }
    return false;
  }
  
  public static void deferredRequest(AtomicReference<c> paramAtomicReference, AtomicLong paramAtomicLong, long paramLong)
  {
    c localc = (c)paramAtomicReference.get();
    if (localc != null)
    {
      localc.request(paramLong);
      return;
    }
    if (validate(paramLong))
    {
      d.a(paramAtomicLong, paramLong);
      paramAtomicReference = (c)paramAtomicReference.get();
      if (paramAtomicReference != null)
      {
        paramLong = paramAtomicLong.getAndSet(0L);
        if (paramLong != 0L) {
          paramAtomicReference.request(paramLong);
        }
      }
    }
  }
  
  public static boolean deferredSetOnce(AtomicReference<c> paramAtomicReference, AtomicLong paramAtomicLong, c paramc)
  {
    if (setOnce(paramAtomicReference, paramc))
    {
      long l = paramAtomicLong.getAndSet(0L);
      if (l != 0L) {
        paramc.request(l);
      }
      return true;
    }
    return false;
  }
  
  public static boolean isCancelled(c paramc)
  {
    return paramc == CANCELLED;
  }
  
  public static boolean replace(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    return true;
  }
  
  public static void reportMoreProduced(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("More produced than requested: ");
    localStringBuilder.append(paramLong);
    a.a(new e(localStringBuilder.toString()));
  }
  
  public static void reportSubscriptionSet()
  {
    a.a(new e("Subscription already set!"));
  }
  
  public static boolean set(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    if (localc != null) {
      localc.cancel();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<c> paramAtomicReference, c paramc)
  {
    b.a.e.b.b.a(paramc, "s is null");
    if (!paramAtomicReference.compareAndSet(null, paramc))
    {
      paramc.cancel();
      if (paramAtomicReference.get() != CANCELLED) {
        reportSubscriptionSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<c> paramAtomicReference, c paramc, long paramLong)
  {
    if (setOnce(paramAtomicReference, paramc))
    {
      paramc.request(paramLong);
      return true;
    }
    return false;
  }
  
  public static boolean validate(long paramLong)
  {
    if (paramLong <= 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("n > 0 required but it was ");
      localStringBuilder.append(paramLong);
      a.a(new IllegalArgumentException(localStringBuilder.toString()));
      return false;
    }
    return true;
  }
  
  public static boolean validate(c paramc1, c paramc2)
  {
    if (paramc2 == null)
    {
      a.a(new NullPointerException("next is null"));
      return false;
    }
    if (paramc1 != null)
    {
      paramc2.cancel();
      reportSubscriptionSet();
      return false;
    }
    return true;
  }
  
  public void cancel() {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */