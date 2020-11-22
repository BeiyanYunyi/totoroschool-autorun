package com.totoro.school.frament.sport;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;

public class SunshineRunFragment_ViewBinding
  implements Unbinder
{
  private SunshineRunFragment a;
  private View b;
  private View c;
  private View d;
  
  @UiThread
  public SunshineRunFragment_ViewBinding(final SunshineRunFragment paramSunshineRunFragment, View paramView)
  {
    this.a = paramSunshineRunFragment;
    paramSunshineRunFragment.headImage = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296404, "field 'headImage'", ImageView.class));
    paramSunshineRunFragment.stuName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296628, "field 'stuName'", TextView.class));
    paramSunshineRunFragment.collegeName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296330, "field 'collegeName'", TextView.class));
    paramSunshineRunFragment.currentDate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296341, "field 'currentDate'", TextView.class));
    paramSunshineRunFragment.weekAndLunar = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296729, "field 'weekAndLunar'", TextView.class));
    paramSunshineRunFragment.taskRun = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296640, "field 'taskRun'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131296397, "field 'freeRun' and method 'freeRun'");
    paramSunshineRunFragment.freeRun = ((TextView)Utils.castView(localView, 2131296397, "field 'freeRun'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramSunshineRunFragment.freeRun(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296621, "field 'startRun' and method 'startRun'");
    paramSunshineRunFragment.startRun = ((TextView)Utils.castView(localView, 2131296621, "field 'startRun'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramSunshineRunFragment.startRun(paramAnonymousView);
      }
    });
    paramSunshineRunFragment.tipsInfo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296658, "field 'tipsInfo'", TextView.class));
    paramSunshineRunFragment.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131296466, "field 'mMapView'", MapView.class));
    paramView = Utils.findRequiredView(paramView, 2131296641, "method 'taskRun'");
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramSunshineRunFragment.taskRun(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    SunshineRunFragment localSunshineRunFragment = this.a;
    if (localSunshineRunFragment != null)
    {
      this.a = null;
      localSunshineRunFragment.headImage = null;
      localSunshineRunFragment.stuName = null;
      localSunshineRunFragment.collegeName = null;
      localSunshineRunFragment.currentDate = null;
      localSunshineRunFragment.weekAndLunar = null;
      localSunshineRunFragment.taskRun = null;
      localSunshineRunFragment.freeRun = null;
      localSunshineRunFragment.startRun = null;
      localSunshineRunFragment.tipsInfo = null;
      localSunshineRunFragment.mMapView = null;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\sport\SunshineRunFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */