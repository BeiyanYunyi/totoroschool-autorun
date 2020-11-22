package com.totoro.school.activity.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.totoro.school.R.id;
import com.totoro.school.activity.login.LoginActivity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import d.c.b.h;
import java.util.HashMap;

public final class AccountManageActivity
  extends Activity
{
  private LoginReturnModel a;
  private HashMap b;
  
  private final void a()
  {
    Object localObject = (TextView)a(R.id.title_text);
    h.a(localObject, "title_text");
    ((TextView)localObject).setText((CharSequence)getString(2131689515));
    TextView localTextView = (TextView)a(R.id.phone_number);
    h.a(localTextView, "phone_number");
    localObject = this.a;
    if (localObject != null) {
      localObject = ((LoginReturnModel)localObject).getPhoneNumber();
    } else {
      localObject = null;
    }
    localTextView.setText((CharSequence)localObject);
  }
  
  private final void b()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
    ((TextView)a(R.id.exit_btn)).setOnClickListener((View.OnClickListener)new b(this));
    ((TextView)a(R.id.change_pwd)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.phone_number)).setOnClickListener((View.OnClickListener)new d(this));
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492893);
    this.a = i.a();
    a();
    b();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(AccountManageActivity paramAccountManageActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(AccountManageActivity paramAccountManageActivity) {}
    
    public final void onClick(View paramView)
    {
      System.gc();
      n.a(this.a.getApplicationContext(), "autoLogin", Boolean.valueOf(false));
      paramView = new Intent((Context)this.a, LoginActivity.class);
      paramView.setFlags(268468224);
      this.a.startActivity(paramView);
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(AccountManageActivity paramAccountManageActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a, ChangePwdActivity.class);
      this.a.startActivity(paramView);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(AccountManageActivity paramAccountManageActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a, ChangePhoneActivity.class);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\mine\AccountManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */