package com.totoro.school.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import org.angmarch.views.NiceSpinner;

public class InfoAuthActivity_ViewBinding
  implements Unbinder
{
  private InfoAuthActivity a;
  private View b;
  private View c;
  
  @UiThread
  public InfoAuthActivity_ViewBinding(final InfoAuthActivity paramInfoAuthActivity, View paramView)
  {
    this.a = paramInfoAuthActivity;
    paramInfoAuthActivity.tvSnCode = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296705, "field 'tvSnCode'", EditText.class));
    paramInfoAuthActivity.tvIdNumber = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296693, "field 'tvIdNumber'", EditText.class));
    paramInfoAuthActivity.tvStuName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131296706, "field 'tvStuName'", EditText.class));
    paramInfoAuthActivity.schoolSpinner = ((NiceSpinner)Utils.findRequiredViewAsType(paramView, 2131296559, "field 'schoolSpinner'", NiceSpinner.class));
    paramInfoAuthActivity.campusSpinner = ((NiceSpinner)Utils.findRequiredViewAsType(paramView, 2131296314, "field 'campusSpinner'", NiceSpinner.class));
    View localView = Utils.findRequiredView(paramView, 2131296680, "method 'auth'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramInfoAuthActivity.auth(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramInfoAuthActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    InfoAuthActivity localInfoAuthActivity = this.a;
    if (localInfoAuthActivity != null)
    {
      this.a = null;
      localInfoAuthActivity.tvSnCode = null;
      localInfoAuthActivity.tvIdNumber = null;
      localInfoAuthActivity.tvStuName = null;
      localInfoAuthActivity.schoolSpinner = null;
      localInfoAuthActivity.campusSpinner = null;
      this.b.setOnClickListener(null);
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\InfoAuthActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */