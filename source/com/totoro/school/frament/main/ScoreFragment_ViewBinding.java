package com.totoro.school.frament.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ScoreFragment_ViewBinding
  implements Unbinder
{
  private ScoreFragment a;
  
  @UiThread
  public ScoreFragment_ViewBinding(ScoreFragment paramScoreFragment, View paramView)
  {
    this.a = paramScoreFragment;
    paramScoreFragment.mViewPager = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131296568, "field 'mViewPager'", ViewPager.class));
    paramScoreFragment.mTabLayout = ((TabLayout)Utils.findRequiredViewAsType(paramView, 2131296565, "field 'mTabLayout'", TabLayout.class));
  }
  
  @CallSuper
  public void unbind()
  {
    ScoreFragment localScoreFragment = this.a;
    if (localScoreFragment != null)
    {
      this.a = null;
      localScoreFragment.mViewPager = null;
      localScoreFragment.mTabLayout = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\ScoreFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */