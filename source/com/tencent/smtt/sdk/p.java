package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;

public class p
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof SQLiteException)) {
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */