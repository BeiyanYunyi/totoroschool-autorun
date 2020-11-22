package net.sqlcipher;

import net.sqlcipher.database.SQLiteDatabase;

public abstract interface DatabaseErrorHandler
{
  public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\DatabaseErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */