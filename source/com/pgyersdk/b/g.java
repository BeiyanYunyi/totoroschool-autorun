package com.pgyersdk.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.pgyersdk.b.a.b;

public class g
{
  public static long a;
  private static volatile g b;
  private static Handler c;
  private a d = new a();
  private com.pgyersdk.b.c.c e;
  public com.pgyersdk.b.b.a f;
  
  private g(Activity paramActivity)
  {
    this.d.a(paramActivity);
    this.e = b();
  }
  
  public static g a(Activity paramActivity)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new g(paramActivity);
        } else {
          b.b(paramActivity);
        }
      }
      finally {}
    }
    b.b(paramActivity);
    return b;
  }
  
  private com.pgyersdk.b.c.c b()
  {
    if (this.d.a() != null) {
      return new com.pgyersdk.b.c.c();
    }
    throw new IllegalArgumentException("Your Acticity may be destroyed");
  }
  
  private void b(Activity paramActivity)
  {
    this.d.a(paramActivity);
  }
  
  protected g a(com.pgyersdk.b.b.a parama)
  {
    this.f = parama;
    return b;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(View[] paramArrayOfView)
  {
    c = new f(this, Looper.getMainLooper());
    b(paramArrayOfView);
  }
  
  public void b(View[] paramArrayOfView)
  {
    a = System.currentTimeMillis();
    Activity localActivity = this.d.a();
    if (localActivity != null)
    {
      com.pgyersdk.b.b.a locala = this.f;
      if (locala != null) {
        locala.a();
      }
      try
      {
        this.e.a(localActivity, paramArrayOfView, c);
        return;
      }
      catch (Exception paramArrayOfView)
      {
        paramArrayOfView.printStackTrace();
        this.f.a(new b("Sorry,Capture is failed."));
        return;
      }
      catch (com.pgyersdk.b.a.c paramArrayOfView)
      {
        paramArrayOfView.printStackTrace();
        this.f.a(new b("Sorry,Capture is failed."));
        return;
      }
    }
    throw new com.pgyersdk.b.a.a("Is your activity running?");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */