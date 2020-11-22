package b.a.e.g;

import java.util.concurrent.Callable;

public final class j
  extends a
  implements Callable<Void>
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public j(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public Void call()
    throws Exception
  {
    this.runner = Thread.currentThread();
    try
    {
      this.runnable.run();
      return null;
    }
    finally
    {
      lazySet(FINISHED);
      this.runner = null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */