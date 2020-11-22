package com.totoro.school.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MainActivity_ViewBinding
  implements Unbinder
{
  private MainActivity a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  @UiThread
  public MainActivity_ViewBinding(final MainActivity paramMainActivity, View paramView)
  {
    this.a = paramMainActivity;
    paramMainActivity.content = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131296336, "field 'content'", FrameLayout.class));
    paramMainActivity.ivRun = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296424, "field 'ivRun'", ImageView.class));
    paramMainActivity.tvRun = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296703, "field 'tvRun'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131296456, "field 'llRun' and method 'changeTab'");
    paramMainActivity.llRun = ((LinearLayout)Utils.castView(localView, 2131296456, "field 'llRun'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMainActivity.changeTab(paramAnonymousView);
      }
    });
    paramMainActivity.ivFound = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296421, "field 'ivFound'", ImageView.class));
    paramMainActivity.tvFound = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296690, "field 'tvFound'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131296452, "field 'llFound' and method 'changeTab'");
    paramMainActivity.llFound = ((LinearLayout)Utils.castView(localView, 2131296452, "field 'llFound'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMainActivity.changeTab(paramAnonymousView);
      }
    });
    paramMainActivity.ivRecord = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296423, "field 'ivRecord'", ImageView.class));
    paramMainActivity.tvRecord = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296700, "field 'tvRecord'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131296455, "field 'llRecord' and method 'changeTab'");
    paramMainActivity.llRecord = ((LinearLayout)Utils.castView(localView, 2131296455, "field 'llRecord'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMainActivity.changeTab(paramAnonymousView);
      }
    });
    paramMainActivity.ivMe = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296422, "field 'ivMe'", ImageView.class));
    paramMainActivity.tvMe = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296679, "field 'tvMe'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131296454, "field 'llMe' and method 'changeTab'");
    paramMainActivity.llMe = ((LinearLayout)Utils.castView(paramView, 2131296454, "field 'llMe'", LinearLayout.class));
    this.e = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMainActivity.changeTab(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    MainActivity localMainActivity = this.a;
    if (localMainActivity != null)
    {
      this.a = null;
      localMainActivity.content = null;
      localMainActivity.ivRun = null;
      localMainActivity.tvRun = null;
      localMainActivity.llRun = null;
      localMainActivity.ivFound = null;
      localMainActivity.tvFound = null;
      localMainActivity.llFound = null;
      localMainActivity.ivRecord = null;
      localMainActivity.tvRecord = null;
      localMainActivity.llRecord = null;
      localMainActivity.ivMe = null;
      localMainActivity.tvMe = null;
      localMainActivity.llMe = null;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\MainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */