package com.totoro.school.frament.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.totoro.school.view.NoScrollViewPager;

public class SportsFragment_ViewBinding
  implements Unbinder
{
  private SportsFragment a;
  
  @UiThread
  public SportsFragment_ViewBinding(SportsFragment paramSportsFragment, View paramView)
  {
    this.a = paramSportsFragment;
    paramSportsFragment.mViewPager = ((NoScrollViewPager)Utils.findRequiredViewAsType(paramView, 2131296720, "field 'mViewPager'", NoScrollViewPager.class));
    paramSportsFragment.mTabLayout = ((TabLayout)Utils.findRequiredViewAsType(paramView, 2131296642, "field 'mTabLayout'", TabLayout.class));
  }
  
  @CallSuper
  public void unbind()
  {
    SportsFragment localSportsFragment = this.a;
    if (localSportsFragment != null)
    {
      this.a = null;
      localSportsFragment.mViewPager = null;
      localSportsFragment.mTabLayout = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\SportsFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */