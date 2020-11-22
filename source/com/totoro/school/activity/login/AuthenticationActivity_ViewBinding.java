package com.totoro.school.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import org.angmarch.views.NiceSpinner;

public class AuthenticationActivity_ViewBinding
  implements Unbinder
{
  private AuthenticationActivity a;
  private View b;
  private View c;
  
  @UiThread
  public AuthenticationActivity_ViewBinding(final AuthenticationActivity paramAuthenticationActivity, View paramView)
  {
    this.a = paramAuthenticationActivity;
    paramAuthenticationActivity.tvSnCode = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296705, "field 'tvSnCode'", EditText.class));
    paramAuthenticationActivity.tvIdNumber = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296693, "field 'tvIdNumber'", EditText.class));
    paramAuthenticationActivity.tvStuName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296706, "field 'tvStuName'", EditText.class));
    paramAuthenticationActivity.schoolSpinner = ((NiceSpinner)Utils.findRequiredViewAsType(paramView, 2131296559, "field 'schoolSpinner'", NiceSpinner.class));
    paramAuthenticationActivity.campusSpinner = ((NiceSpinner)Utils.findRequiredViewAsType(paramView, 2131296314, "field 'campusSpinner'", NiceSpinner.class));
    View localView = Utils.findRequiredView(paramView, 2131296680, "method 'auth'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramAuthenticationActivity.auth(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramAuthenticationActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    AuthenticationActivity localAuthenticationActivity = this.a;
    if (localAuthenticationActivity != null)
    {
      this.a = null;
      localAuthenticationActivity.tvSnCode = null;
      localAuthenticationActivity.tvIdNumber = null;
      localAuthenticationActivity.tvStuName = null;
      localAuthenticationActivity.schoolSpinner = null;
      localAuthenticationActivity.campusSpinner = null;
      this.b.setOnClickListener(null);
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\AuthenticationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */