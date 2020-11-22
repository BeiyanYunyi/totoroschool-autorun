package b.a.e.j;

import b.a.h.a;
import java.util.concurrent.atomic.AtomicLong;

public final class d
{
  public static long a(long paramLong1, long paramLong2)
  {
    paramLong1 += paramLong2;
    if (paramLong1 < 0L) {
      return Long.MAX_VALUE;
    }
    return paramLong1;
  }
  
  public static long a(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if (l == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l, a(l, paramLong)));
    return l;
  }
  
  public static long b(AtomicLong paramAtomicLong, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLong.get();
      if (l3 == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      long l2 = l3 - paramLong;
      l1 = l2;
      if (l2 < 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("More produced than requested: ");
        localStringBuilder.append(l2);
        a.a(new IllegalStateException(localStringBuilder.toString()));
        l1 = 0L;
      }
    } while (!paramAtomicLong.compareAndSet(l3, l1));
    return l1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */