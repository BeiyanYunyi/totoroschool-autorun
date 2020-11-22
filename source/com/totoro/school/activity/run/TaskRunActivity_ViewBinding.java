package com.totoro.school.activity.run;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.totoro.school.view.RingLoadButton;

public class TaskRunActivity_ViewBinding
  implements Unbinder
{
  private TaskRunActivity a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  @UiThread
  public TaskRunActivity_ViewBinding(final TaskRunActivity paramTaskRunActivity, View paramView)
  {
    this.a = paramTaskRunActivity;
    paramTaskRunActivity.stuInfoView = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296627, "field 'stuInfoView'", LinearLayout.class));
    paramTaskRunActivity.gpsLayout = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296400, "field 'gpsLayout'", LinearLayout.class));
    paramTaskRunActivity.bottomLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131296307, "field 'bottomLayout'", RelativeLayout.class));
    paramTaskRunActivity.runLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131296549, "field 'runLayout'", RelativeLayout.class));
    paramTaskRunActivity.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramTaskRunActivity.stuName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296628, "field 'stuName'", TextView.class));
    paramTaskRunActivity.headImage = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296404, "field 'headImage'", ImageView.class));
    paramTaskRunActivity.collegeName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296330, "field 'collegeName'", TextView.class));
    paramTaskRunActivity.currentDate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296341, "field 'currentDate'", TextView.class));
    paramTaskRunActivity.weekAndLunar = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296729, "field 'weekAndLunar'", TextView.class));
    paramTaskRunActivity.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131296466, "field 'mMapView'", MapView.class));
    paramTaskRunActivity.runBtn = ((RingLoadButton)Utils.findRequiredViewAsType(paramView, 2131296548, "field 'runBtn'", RingLoadButton.class));
    View localView = Utils.findRequiredView(paramView, 2131296338, "field 'continueRun' and method 'continueRun'");
    paramTaskRunActivity.continueRun = ((ImageView)Utils.castView(localView, 2131296338, "field 'continueRun'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramTaskRunActivity.continueRun(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131296625, "field 'stopRun' and method 'stopRun'");
    paramTaskRunActivity.stopRun = ((ImageView)Utils.castView(localView, 2131296625, "field 'stopRun'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramTaskRunActivity.stopRun(paramAnonymousView);
      }
    });
    paramTaskRunActivity.kmValue = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296430, "field 'kmValue'", TextView.class));
    paramTaskRunActivity.speedValue = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296608, "field 'speedValue'", TextView.class));
    paramTaskRunActivity.usedTime = ((Chronometer)Utils.findRequiredViewAsType(paramView, 2131296715, "field 'usedTime'", Chronometer.class));
    paramTaskRunActivity.kcalValue = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296428, "field 'kcalValue'", TextView.class));
    paramTaskRunActivity.gpsSingle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296401, "field 'gpsSingle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131296342, "field 'currentPosition' and method 'currentPosition'");
    paramTaskRunActivity.currentPosition = ((ImageView)Utils.castView(localView, 2131296342, "field 'currentPosition'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramTaskRunActivity.currentPosition(paramAnonymousView);
      }
    });
    paramTaskRunActivity.mTv_countdown = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296685, "field 'mTv_countdown'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.e = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramTaskRunActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    TaskRunActivity localTaskRunActivity = this.a;
    if (localTaskRunActivity != null)
    {
      this.a = null;
      localTaskRunActivity.stuInfoView = null;
      localTaskRunActivity.gpsLayout = null;
      localTaskRunActivity.bottomLayout = null;
      localTaskRunActivity.runLayout = null;
      localTaskRunActivity.titleView = null;
      localTaskRunActivity.stuName = null;
      localTaskRunActivity.headImage = null;
      localTaskRunActivity.collegeName = null;
      localTaskRunActivity.currentDate = null;
      localTaskRunActivity.weekAndLunar = null;
      localTaskRunActivity.mMapView = null;
      localTaskRunActivity.runBtn = null;
      localTaskRunActivity.continueRun = null;
      localTaskRunActivity.stopRun = null;
      localTaskRunActivity.kmValue = null;
      localTaskRunActivity.speedValue = null;
      localTaskRunActivity.usedTime = null;
      localTaskRunActivity.kcalValue = null;
      localTaskRunActivity.gpsSingle = null;
      localTaskRunActivity.currentPosition = null;
      localTaskRunActivity.mTv_countdown = null;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\run\TaskRunActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */