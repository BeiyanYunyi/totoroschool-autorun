package com.totoro.school.activity.morning;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.totoro.school.zxing.view.ViewfinderView;

public class MorningExercisesActivity_ViewBinding
  implements Unbinder
{
  private MorningExercisesActivity a;
  private View b;
  
  @UiThread
  public MorningExercisesActivity_ViewBinding(final MorningExercisesActivity paramMorningExercisesActivity, View paramView)
  {
    this.a = paramMorningExercisesActivity;
    paramMorningExercisesActivity.viewfinderView = ((ViewfinderView)Utils.findRequiredViewAsType(paramView, 2131296723, "field 'viewfinderView'", ViewfinderView.class));
    paramMorningExercisesActivity.surfaceView = ((SurfaceView)Utils.findRequiredViewAsType(paramView, 2131296515, "field 'surfaceView'", SurfaceView.class));
    paramMorningExercisesActivity.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131296298, "method 'back'");
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramMorningExercisesActivity.back(paramAnonymousView);
      }
    });
  }
  
  @CallSuper
  public void unbind()
  {
    MorningExercisesActivity localMorningExercisesActivity = this.a;
    if (localMorningExercisesActivity != null)
    {
      this.a = null;
      localMorningExercisesActivity.viewfinderView = null;
      localMorningExercisesActivity.surfaceView = null;
      localMorningExercisesActivity.titleView = null;
      this.b.setOnClickListener(null);
      this.b = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\morning\MorningExercisesActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */