package org.litepal.crud.async;

import org.litepal.crud.callback.FindCallback;

public class FindExecutor<T>
  extends AsyncExecutor
{
  private FindCallback<T> cb;
  
  public FindCallback<T> getListener()
  {
    return this.cb;
  }
  
  public void listen(FindCallback<T> paramFindCallback)
  {
    this.cb = paramFindCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\FindExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */