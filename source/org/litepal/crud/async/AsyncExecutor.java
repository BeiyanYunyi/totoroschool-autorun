package org.litepal.crud.async;

public abstract class AsyncExecutor
{
  private Runnable pendingTask;
  
  void execute()
  {
    if (this.pendingTask != null) {
      new Thread(this.pendingTask).start();
    }
  }
  
  public void submit(Runnable paramRunnable)
  {
    this.pendingTask = paramRunnable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\AsyncExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */