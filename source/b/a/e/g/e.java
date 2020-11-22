package b.a.e.g;

import b.a.t;
import b.a.t.c;
import java.util.concurrent.ThreadFactory;

public final class e
  extends t
{
  private static final h c = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
  final ThreadFactory b;
  
  public e()
  {
    this(c);
  }
  
  public e(ThreadFactory paramThreadFactory)
  {
    this.b = paramThreadFactory;
  }
  
  public t.c a()
  {
    return new f(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */