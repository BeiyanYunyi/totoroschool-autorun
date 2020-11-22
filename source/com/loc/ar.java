package com.loc;

import android.database.sqlite.SQLiteDatabase;

public class ar
  implements am
{
  public final String a()
  {
    return "logdb.db";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[] { "b" }));
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[] { "c" }));
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[] { "d" }));
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      ag.a(paramSQLiteDatabase, "DB", "onCreate");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */