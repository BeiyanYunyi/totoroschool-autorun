package android.support.transition;

import android.os.IBinder;

class WindowIdApi14
  implements WindowIdImpl
{
  private final IBinder mToken;
  
  WindowIdApi14(IBinder paramIBinder)
  {
    this.mToken = paramIBinder;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WindowIdApi14)) && (((WindowIdApi14)paramObject).mToken.equals(this.mToken));
  }
  
  public int hashCode()
  {
    return this.mToken.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\WindowIdApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */