package net.sqlcipher.database;

public abstract interface SQLiteDatabaseHook
{
  public abstract void postKey(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void preKey(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteDatabaseHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */