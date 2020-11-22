package com.loc;

import android.database.sqlite.SQLiteDatabase;

public final class ax
  implements am
{
  private static ax a;
  
  public static ax b()
  {
    try
    {
      if (a == null) {
        a = new ax();
      }
      ax localax = a;
      return localax;
    }
    finally {}
  }
  
  public final String a()
  {
    return "dafile.db";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      ag.a(paramSQLiteDatabase, "DynamicFileDBCreator", "onCreate");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */