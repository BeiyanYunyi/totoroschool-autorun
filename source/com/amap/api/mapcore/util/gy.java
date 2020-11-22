package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;

public class gy
  implements gn
{
  private static gy a;
  
  public static gy a()
  {
    try
    {
      if (a == null) {
        a = new gy();
      }
      gy localgy = a;
      return localgy;
    }
    finally {}
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      hd.a(paramSQLiteDatabase, "DynamicFileDBCreator", "onCreate");
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public String b()
  {
    return "dafile.db";
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */