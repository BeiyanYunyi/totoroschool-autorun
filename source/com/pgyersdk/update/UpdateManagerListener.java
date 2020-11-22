package com.pgyersdk.update;

import com.pgyersdk.update.javabean.AppBean;

public abstract interface UpdateManagerListener
{
  public abstract void checkUpdateFailed(Exception paramException);
  
  public abstract void onNoUpdateAvailable();
  
  public abstract void onUpdateAvailable(AppBean paramAppBean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\UpdateManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */