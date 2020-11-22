package org.litepal.crud.async;

import org.litepal.crud.callback.SaveCallback;

public class SaveExecutor
  extends AsyncExecutor
{
  private SaveCallback cb;
  
  public SaveCallback getListener()
  {
    return this.cb;
  }
  
  public void listen(SaveCallback paramSaveCallback)
  {
    this.cb = paramSaveCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\SaveExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */