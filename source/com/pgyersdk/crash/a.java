package com.pgyersdk.crash;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.PgyerProvider;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private boolean a = false;
  private Thread.UncaughtExceptionHandler b;
  e c;
  
  public a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, e parame)
  {
    this.b = paramUncaughtExceptionHandler;
    this.c = parame;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    this.a = PgyCrashManager.isIsIgnoreDefaultHander();
    if (com.pgyersdk.c.a.a == null)
    {
      this.b.uncaughtException(paramThread, paramThrowable);
      return;
    }
    this.c.notifyObservers(paramThread, paramThrowable);
    if (!this.a)
    {
      this.b.uncaughtException(paramThread, paramThrowable);
      Process.killProcess(Process.myPid());
      System.exit(10);
      return;
    }
    paramThread = new Intent(PgyerProvider.a, PgyerActivityManager.getInstance().getCurrentActivity().getClass());
    paramThread.setFlags(268435456);
    paramThread.putExtra("crash", true);
    paramThread = PendingIntent.getActivity(PgyerProvider.a, 0, paramThread, 1073741824);
    ((AlarmManager)PgyerProvider.a.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000L, paramThread);
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */