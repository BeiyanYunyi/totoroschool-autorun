package com.pgyersdk.crash;

public abstract interface PgyerObserver
{
  public abstract void receivedCrash(Thread paramThread, Throwable paramThrowable);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\PgyerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */