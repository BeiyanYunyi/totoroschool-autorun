package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class gr
  extends SQLiteOpenHelper
{
  private static boolean b = true;
  private static boolean c = false;
  private gn a;
  
  public gr(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, gn paramgn)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.a = paramgn;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */