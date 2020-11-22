package org.litepal.crud.async;

import org.litepal.crud.callback.FindMultiCallback;

public class FindMultiExecutor<T>
  extends AsyncExecutor
{
  private FindMultiCallback<T> cb;
  
  public FindMultiCallback<T> getListener()
  {
    return this.cb;
  }
  
  public void listen(FindMultiCallback<T> paramFindMultiCallback)
  {
    this.cb = paramFindMultiCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\FindMultiExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */