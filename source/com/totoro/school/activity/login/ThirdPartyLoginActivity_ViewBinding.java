package com.totoro.school.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ThirdPartyLoginActivity_ViewBinding
  implements Unbinder
{
  private ThirdPartyLoginActivity a;
  private View b;
  private View c;
  
  @UiThread
  public ThirdPartyLoginActivity_ViewBinding(final ThirdPartyLoginActivity paramThirdPartyLoginActivity, View paramView)
  {
    this.a = paramThirdPartyLoginActivity;
    View localView = Utils.findRequiredView(paramView, 2131296692, "method 'homePage'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramThirdPartyLoginActivity.homePage(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramThirdPartyLoginActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    if (this.a != null)
    {
      this.a = null;
      this.b.setOnClickListener(null);
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\ThirdPartyLoginActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */