package net.sqlcipher;

import android.database.CrossProcessCursor;
import android.database.CursorWindow;

public class CrossProcessCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  public CrossProcessCursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    DatabaseUtils.cursorFillWindow(this, paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\CrossProcessCursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */