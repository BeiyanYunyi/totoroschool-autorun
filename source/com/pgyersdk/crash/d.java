package com.pgyersdk.crash;

import com.pgyersdk.f.m;

class d
  implements PgyerObserver
{
  public void receivedCrash(Thread paramThread, Throwable paramThrowable)
  {
    PgyCrashManager.a(m.a(paramThrowable), PgyCrashManager.a.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */