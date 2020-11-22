package com.totoro.school.activity.load;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.totoro.school.activity.MainFragmentActivity;
import com.totoro.school.activity.login.LoginActivity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import d.b;

public final class LoadPageActivity
  extends Activity
{
  private LoginReturnModel a;
  
  private final void a()
  {
    this.a = i.a();
    new Handler().postDelayed((Runnable)new a(this), 2000L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492904);
    a();
  }
  
  static final class a
    implements Runnable
  {
    a(LoadPageActivity paramLoadPageActivity) {}
    
    public final void run()
    {
      Intent localIntent = new Intent();
      Object localObject = n.b(this.a.getApplicationContext(), "autoLogin", Boolean.valueOf(false));
      if (localObject != null)
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        if ((LoadPageActivity.a(this.a) != null) && (bool)) {
          localIntent.setClass((Context)this.a, MainFragmentActivity.class);
        } else {
          localIntent.setClass((Context)this.a, LoginActivity.class);
        }
        this.a.startActivity(localIntent);
        this.a.finish();
        return;
      }
      throw new b("null cannot be cast to non-null type kotlin.Boolean");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\load\LoadPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */