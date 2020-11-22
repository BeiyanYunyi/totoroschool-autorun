package b.a.e.g;

public final class i
  extends a
  implements Runnable
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public i(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public void run()
  {
    this.runner = Thread.currentThread();
    try
    {
      this.runnable.run();
      this.runner = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.runner = null;
      lazySet(FINISHED);
      b.a.h.a.a(localThrowable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */