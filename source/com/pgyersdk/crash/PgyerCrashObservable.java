package com.pgyersdk.crash;

public class PgyerCrashObservable
  extends e
{
  PgyerObserver b = new d();
  
  private PgyerCrashObservable()
  {
    attach(this.b);
  }
  
  private void b()
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (localUncaughtExceptionHandler != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Current handler class = ");
      localStringBuilder.append(localUncaughtExceptionHandler.getClass().getName());
      com.pgyersdk.f.f.a("PgyerSDK", localStringBuilder.toString());
    }
    if ((localUncaughtExceptionHandler instanceof a))
    {
      com.pgyersdk.f.f.a("PgyerSDK", "ExceptionHandler is already reset");
      return;
    }
    Thread.setDefaultUncaughtExceptionHandler(new a(localUncaughtExceptionHandler, this));
  }
  
  public static PgyerCrashObservable get()
  {
    return a.a();
  }
  
  protected void a()
  {
    com.pgyersdk.f.a.a(new f());
    b();
  }
  
  public void detach(PgyerObserver paramPgyerObserver)
  {
    if (!paramPgyerObserver.equals(this.b))
    {
      super.detach(paramPgyerObserver);
      return;
    }
    com.pgyersdk.f.f.d("PgyerSDK", "Can't detach pgyer default observer.");
  }
  
  private static class a
  {
    private static final PgyerCrashObservable a = new PgyerCrashObservable(null);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\PgyerCrashObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */