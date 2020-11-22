package com.amap.api.location;

import android.content.Intent;
import android.os.IBinder;

public abstract interface APSServiceBase
{
  public abstract IBinder onBind(Intent paramIntent);
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\APSServiceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */