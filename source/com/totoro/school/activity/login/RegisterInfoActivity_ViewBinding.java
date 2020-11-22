package com.totoro.school.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RegisterInfoActivity_ViewBinding
  implements Unbinder
{
  private RegisterInfoActivity a;
  private View b;
  private View c;
  private View d;
  
  @UiThread
  public RegisterInfoActivity_ViewBinding(final RegisterInfoActivity paramRegisterInfoActivity, View paramView)
  {
    this.a = paramRegisterInfoActivity;
    paramRegisterInfoActivity.tvUsername = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296708, "field 'tvUsername'", EditText.class));
    paramRegisterInfoActivity.etPassword = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296376, "field 'etPassword'", EditText.class));
    paramRegisterInfoActivity.tvTwoPassword = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296381, "field 'tvTwoPassword'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131296404, "field 'headImage' and method 'headmage'");
    paramRegisterInfoActivity.headImage = ((ImageView)Utils.castView(localView, 2131296404, "field 'headImage'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramRegisterInfoActivity.headmage(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296686, "method 'register'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramRegisterInfoActivity.register(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramRegisterInfoActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    RegisterInfoActivity localRegisterInfoActivity = this.a;
    if (localRegisterInfoActivity != null)
    {
      this.a = null;
      localRegisterInfoActivity.tvUsername = null;
      localRegisterInfoActivity.etPassword = null;
      localRegisterInfoActivity.tvTwoPassword = null;
      localRegisterInfoActivity.headImage = null;
      this.b.setOnClickListener(null);
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\RegisterInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */