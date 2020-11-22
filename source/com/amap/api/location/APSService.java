package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.az;
import com.loc.dg;
import com.loc.dl;
import com.loc.g;
import com.loc.w;

public class APSService
  extends Service
{
  APSServiceBase a;
  int b = 0;
  boolean c = false;
  
  public IBinder onBind(Intent paramIntent)
  {
    try
    {
      paramIntent = this.a.onBind(paramIntent);
      return paramIntent;
    }
    catch (Throwable paramIntent)
    {
      dg.a(paramIntent, "APSService", "onBind");
    }
    return null;
  }
  
  public void onCreate()
  {
    onCreate(this);
  }
  
  public void onCreate(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (dl.d(paramContext))
        {
          localObject = (APSServiceBase)az.a(paramContext, dg.b(), w.c("AY29tLmFtYXAuYXBpLmxvY2F0aW9uLkFQU1NlcnZpY2VXcmFwcGVy"), g.class, new Class[] { Context.class }, new Object[] { paramContext });
          this.a = ((APSServiceBase)localObject);
        }
        else if (this.a == null)
        {
          localObject = new g(paramContext);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      try
      {
        if (this.a == null) {
          this.a = new g(paramContext);
        }
        this.a.onCreate();
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "APSService", "onCreate");
      }
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    try
    {
      this.a.onDestroy();
      if (this.c) {
        stopForeground(true);
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "APSService", "onDestroy");
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        i = paramIntent.getIntExtra("g", 0);
        if (i == 1)
        {
          i = paramIntent.getIntExtra("i", 0);
          Notification localNotification = (Notification)paramIntent.getParcelableExtra("h");
          if ((i != 0) && (localNotification != null))
          {
            startForeground(i, localNotification);
            this.c = true;
            this.b += 1;
          }
        }
        else if (i == 2)
        {
          if ((paramIntent.getBooleanExtra("j", true)) && (this.b > 0)) {
            this.b -= 1;
          }
          if (this.b <= 0)
          {
            stopForeground(true);
            this.c = false;
          }
          else
          {
            stopForeground(false);
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        int i;
        continue;
      }
      try
      {
        i = this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
        return i;
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "APSService", "onStartCommand");
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\APSService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */