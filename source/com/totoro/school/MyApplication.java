package com.totoro.school;

import com.pgyersdk.crash.PgyCrashManager;
import com.totoro.school.utilpub.network.d;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.LitePal;
import org.litepal.LitePalApplication;

public class MyApplication
  extends LitePalApplication
{
  private static MyApplication a;
  
  public static MyApplication a()
  {
    return a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a = this;
    d.a().b();
    LitePal.initialize(this);
    PgyCrashManager.register();
    SQLiteDatabase.loadLibs(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\MyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */