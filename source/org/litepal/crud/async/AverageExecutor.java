package org.litepal.crud.async;

import org.litepal.crud.callback.AverageCallback;

public class AverageExecutor
  extends AsyncExecutor
{
  private AverageCallback cb;
  
  public AverageCallback getListener()
  {
    return this.cb;
  }
  
  public void listen(AverageCallback paramAverageCallback)
  {
    this.cb = paramAverageCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\AverageExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */