package com.totoro.school.frament.sport;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.totoro.school.view.calendar.base.CalendarLayout;
import com.totoro.school.view.calendar.base.CalendarView;

public class MorningFragment_ViewBinding
  implements Unbinder
{
  private MorningFragment a;
  private View b;
  private View c;
  private View d;
  
  @UiThread
  public MorningFragment_ViewBinding(final MorningFragment paramMorningFragment, View paramView)
  {
    this.a = paramMorningFragment;
    paramMorningFragment.mCalendarLayout = ((CalendarLayout)Utils.findRequiredViewAsType(paramView, 2131296312, "field 'mCalendarLayout'", CalendarLayout.class));
    paramMorningFragment.mCalendarView = ((CalendarView)Utils.findRequiredViewAsType(paramView, 2131296313, "field 'mCalendarView'", CalendarView.class));
    View localView = Utils.findRequiredView(paramView, 2131296596, "field 'shrinkBtn' and method 'shrinkClick'");
    paramMorningFragment.shrinkBtn = ((LinearLayout)Utils.castView(localView, 2131296596, "field 'shrinkBtn'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMorningFragment.shrinkClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296599, "field 'signBtn' and method 'signClick'");
    paramMorningFragment.signBtn = ((ImageView)Utils.castView(localView, 2131296599, "field 'signBtn'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMorningFragment.signClick();
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296405, "field 'helpBtn' and method 'helpClick'");
    paramMorningFragment.helpBtn = ((ImageView)Utils.castView(localView, 2131296405, "field 'helpBtn'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMorningFragment.helpClick();
      }
    });
    paramMorningFragment.headImage = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296404, "field 'headImage'", ImageView.class));
    paramMorningFragment.stuName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296628, "field 'stuName'", TextView.class));
    paramMorningFragment.collegeName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296330, "field 'collegeName'", TextView.class));
    paramMorningFragment.currentDate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296341, "field 'currentDate'", TextView.class));
    paramMorningFragment.weekAndLunar = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296729, "field 'weekAndLunar'", TextView.class));
    paramMorningFragment.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131296466, "field 'mMapView'", MapView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    MorningFragment localMorningFragment = this.a;
    if (localMorningFragment != null)
    {
      this.a = null;
      localMorningFragment.mCalendarLayout = null;
      localMorningFragment.mCalendarView = null;
      localMorningFragment.shrinkBtn = null;
      localMorningFragment.signBtn = null;
      localMorningFragment.helpBtn = null;
      localMorningFragment.headImage = null;
      localMorningFragment.stuName = null;
      localMorningFragment.collegeName = null;
      localMorningFragment.currentDate = null;
      localMorningFragment.weekAndLunar = null;
      localMorningFragment.mMapView = null;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\sport\MorningFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */