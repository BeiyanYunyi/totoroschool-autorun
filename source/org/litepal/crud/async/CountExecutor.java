package org.litepal.crud.async;

import org.litepal.crud.callback.CountCallback;

public class CountExecutor
  extends AsyncExecutor
{
  private CountCallback cb;
  
  public CountCallback getListener()
  {
    return this.cb;
  }
  
  public void listen(CountCallback paramCountCallback)
  {
    this.cb = paramCountCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\CountExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */