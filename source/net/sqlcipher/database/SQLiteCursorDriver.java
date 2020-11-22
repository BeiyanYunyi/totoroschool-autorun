package net.sqlcipher.database;

public abstract interface SQLiteCursorDriver
{
  public abstract void cursorClosed();
  
  public abstract void cursorDeactivated();
  
  public abstract void cursorRequeried(android.database.Cursor paramCursor);
  
  public abstract net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString);
  
  public abstract void setBindArguments(String[] paramArrayOfString);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteCursorDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */