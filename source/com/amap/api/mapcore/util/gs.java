package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;

public class gs
  implements gn
{
  public void a(SQLiteDatabase paramSQLiteDatabase)
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
      gg.a(paramSQLiteDatabase, "DB", "onCreate");
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public String b()
  {
    return "logdb.db";
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */