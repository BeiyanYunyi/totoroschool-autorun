package com.loc;

import android.database.sqlite.SQLiteDatabase;

public class cy
  implements am
{
  public final String a()
  {
    return "alsn20170807.db";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      dg.a(paramSQLiteDatabase, "SdCardDbCreator", "onCreate");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */