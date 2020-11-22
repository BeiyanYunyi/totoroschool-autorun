package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.amap.api.mapcore.util.ep;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.es;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

public class OfflineMapActivity
  extends AMapPermissionActivity
  implements View.OnClickListener
{
  private static int a;
  private a b;
  private ep c;
  private ep[] d = new ep[32];
  private int e = -1;
  private eq f;
  
  private void a(ep paramep)
  {
    try
    {
      if (this.b != null)
      {
        this.b.c();
        this.b = null;
      }
      this.b = c(paramep);
      if (this.b != null)
      {
        this.c = paramep;
        this.b.a(this);
        this.b.a(this.c.b);
        this.b.a();
        return;
      }
    }
    catch (Throwable paramep)
    {
      paramep.printStackTrace();
    }
  }
  
  private boolean a(Bundle paramBundle)
  {
    try
    {
      if ((a == 1) && (this.b != null)) {
        return false;
      }
      if (a > 1)
      {
        a -= 1;
        this.e = ((this.e - 1 + 32) % 32);
        ep localep = this.d[this.e];
        localep.b = paramBundle;
        a(localep);
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return false;
  }
  
  private void b(ep paramep)
  {
    try
    {
      a += 1;
      a(paramep);
      this.e = ((this.e + 1) % 32);
      this.d[this.e] = paramep;
      return;
    }
    catch (Throwable paramep)
    {
      paramep.printStackTrace();
    }
  }
  
  private a c(ep paramep)
  {
    try
    {
      if (paramep.a == 1)
      {
        if (this.f == null) {
          this.f = new eq();
        }
        paramep = this.f;
        return paramep;
      }
    }
    catch (Throwable paramep)
    {
      paramep.printStackTrace();
    }
    return null;
  }
  
  public void closeScr()
  {
    try
    {
      if (!a(null))
      {
        if (this.b != null) {
          this.b.c();
        }
        finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void closeScr(Bundle paramBundle)
  {
    try
    {
      if (!a(paramBundle))
      {
        if (this.b != null) {
          this.b.c();
        }
        finish();
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      if (this.b != null)
      {
        this.b.a(paramView);
        return;
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    try
    {
      super.onConfigurationChanged(paramConfiguration);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      paramConfiguration.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      getWindow().setSoftInputMode(32);
      getWindow().setFormat(-3);
      requestWindowFeature(1);
      es.a(getApplicationContext());
      this.e = -1;
      a = 0;
      b(new ep(1, null));
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.b != null)
      {
        this.b.c();
        this.b = null;
      }
      this.c = null;
      this.d = null;
      if (this.f != null)
      {
        this.f.c();
        this.f = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        if ((this.b != null) && (!this.b.e())) {
          return true;
        }
        if (a(null)) {
          return false;
        }
        if (paramKeyEvent == null)
        {
          if (a != 1) {
            break label75;
          }
          finish();
          return false;
        }
        this.e = -1;
        a = 0;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
    label75:
    return false;
  }
  
  protected void onPause()
  {
    try
    {
      super.onPause();
      if (this.b != null)
      {
        this.b.i();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void onResume()
  {
    try
    {
      super.onResume();
      if (this.b != null)
      {
        this.b.g();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void onStart()
  {
    try
    {
      super.onStart();
      if (this.b != null)
      {
        this.b.f();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void onStop()
  {
    try
    {
      super.onStop();
      if (this.b != null)
      {
        this.b.h();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void showScr()
  {
    try
    {
      setContentView(this.b.b());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\OfflineMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */