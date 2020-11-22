package com.amap.api.mapcore.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class as
  implements gn
{
  private static volatile as a;
  
  public static as a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new as();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      gk.c(paramSQLiteDatabase, "DB", "onCreate");
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    if (paramInt1 != 1) {
      return;
    }
    paramSQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
    Cursor localCursor = paramSQLiteDatabase.query("update_item", null, null, null, null, null, null);
    SQLiteDatabase localSQLiteDatabase = paramSQLiteDatabase;
    if (localCursor == null)
    {
      paramSQLiteDatabase.close();
      localSQLiteDatabase = null;
    }
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        paramSQLiteDatabase = localCursor.getString(localCursor.getColumnIndex("url"));
        String str = paramSQLiteDatabase.substring(paramSQLiteDatabase.lastIndexOf("/") + 1);
        localSQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[] { str.substring(0, str.lastIndexOf(".")), paramSQLiteDatabase });
      }
      localCursor.close();
    }
  }
  
  public String b()
  {
    return "offlineDbV4.db";
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */