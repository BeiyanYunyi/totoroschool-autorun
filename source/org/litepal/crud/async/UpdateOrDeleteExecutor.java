package org.litepal.crud.async;

import org.litepal.crud.callback.UpdateOrDeleteCallback;

public class UpdateOrDeleteExecutor
  extends AsyncExecutor
{
  private UpdateOrDeleteCallback cb;
  
  public UpdateOrDeleteCallback getListener()
  {
    return this.cb;
  }
  
  public void listen(UpdateOrDeleteCallback paramUpdateOrDeleteCallback)
  {
    this.cb = paramUpdateOrDeleteCallback;
    execute();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\async\UpdateOrDeleteExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */