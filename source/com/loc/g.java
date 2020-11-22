package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.location.APSServiceBase;

public class g
  implements APSServiceBase
{
  f a = null;
  Context b = null;
  Messenger c = null;
  
  public g(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new f(this.b);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = this.a;
    String str = paramIntent.getStringExtra("a");
    if (!TextUtils.isEmpty(str)) {
      m.a(((f)localObject).e, str);
    }
    ((f)localObject).a = paramIntent.getStringExtra("b");
    l.a(((f)localObject).a);
    localObject = paramIntent.getStringExtra("d");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      p.a((String)localObject);
    }
    df.a = paramIntent.getBooleanExtra("f", true);
    localObject = this.a;
    if (("true".equals(paramIntent.getStringExtra("as"))) && (((f)localObject).d != null)) {
      ((f)localObject).d.sendEmptyMessageDelayed(9, 100L);
    }
    this.c = new Messenger(this.a.d);
    return this.c.getBinder();
  }
  
  public void onCreate()
  {
    try
    {
      f.c();
      this.a.j = dn.b();
      this.a.k = dn.a();
      f localf = this.a;
      try
      {
        localf.i = new dk();
        localf.b = new f.b(localf, "amapLocCoreThread");
        localf.b.setPriority(5);
        localf.b.start();
        localf.d = new f.a(localf, localf.b.getLooper());
        return;
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "ApsServiceCore", "onCreate");
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      dg.a(localThrowable2, "ApsServiceCore", "onCreate");
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.a != null) {
        this.a.d.sendEmptyMessage(11);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ApsServiceCore", "onDestroy");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */