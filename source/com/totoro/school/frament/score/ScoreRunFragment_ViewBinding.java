package com.totoro.school.frament.score;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ScoreRunFragment_ViewBinding
  implements Unbinder
{
  private ScoreRunFragment a;
  
  @UiThread
  public ScoreRunFragment_ViewBinding(ScoreRunFragment paramScoreRunFragment, View paramView)
  {
    this.a = paramScoreRunFragment;
    paramScoreRunFragment.yearLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131296734, "field 'yearLayout'", RelativeLayout.class));
    paramScoreRunFragment.yearName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296735, "field 'yearName'", TextView.class));
    paramScoreRunFragment.leftNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296439, "field 'leftNumber'", TextView.class));
    paramScoreRunFragment.centerNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296319, "field 'centerNumber'", TextView.class));
    paramScoreRunFragment.rightNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296536, "field 'rightNumber'", TextView.class));
    paramScoreRunFragment.noDataView = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296488, "field 'noDataView'", LinearLayout.class));
    paramScoreRunFragment.scoreLayout = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296560, "field 'scoreLayout'", LinearLayout.class));
    paramScoreRunFragment.runRecyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131296564, "field 'runRecyclerView'", RecyclerView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    ScoreRunFragment localScoreRunFragment = this.a;
    if (localScoreRunFragment != null)
    {
      this.a = null;
      localScoreRunFragment.yearLayout = null;
      localScoreRunFragment.yearName = null;
      localScoreRunFragment.leftNumber = null;
      localScoreRunFragment.centerNumber = null;
      localScoreRunFragment.rightNumber = null;
      localScoreRunFragment.noDataView = null;
      localScoreRunFragment.scoreLayout = null;
      localScoreRunFragment.runRecyclerView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\score\ScoreRunFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */