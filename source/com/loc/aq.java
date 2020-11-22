package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class aq
  extends SQLiteOpenHelper
{
  private static boolean b = true;
  private static boolean c = false;
  private am a;
  
  public aq(Context paramContext, String paramString, am paramam)
  {
    super(paramContext, paramString, null, 1);
    this.a = paramam;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.a(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */