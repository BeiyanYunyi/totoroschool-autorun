package com.totoro.school.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoginActivity_ViewBinding
  implements Unbinder
{
  private LoginActivity a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity paramLoginActivity, View paramView)
  {
    this.a = paramLoginActivity;
    paramLoginActivity.appName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296290, "field 'appName'", TextView.class));
    paramLoginActivity.tvUsername = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296709, "field 'tvUsername'", EditText.class));
    paramLoginActivity.tvPassword = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296698, "field 'tvPassword'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131296296, "field 'cbAutoLogin' and method 'automaticLogon'");
    paramLoginActivity.cbAutoLogin = ((CheckBox)Utils.castView(localView, 2131296296, "field 'cbAutoLogin'", CheckBox.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramLoginActivity.automaticLogon(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296689, "method 'forgetPassword'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramLoginActivity.forgetPassword(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296694, "method 'loginImmediately'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramLoginActivity.loginImmediately(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131296702, "method 'certification'");
    this.e = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramLoginActivity.certification(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    LoginActivity localLoginActivity = this.a;
    if (localLoginActivity != null)
    {
      this.a = null;
      localLoginActivity.appName = null;
      localLoginActivity.tvUsername = null;
      localLoginActivity.tvPassword = null;
      localLoginActivity.cbAutoLogin = null;
      this.b.setOnClickListener(null);
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\LoginActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */