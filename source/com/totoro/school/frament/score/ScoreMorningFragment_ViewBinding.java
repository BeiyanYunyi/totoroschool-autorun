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

public class ScoreMorningFragment_ViewBinding
  implements Unbinder
{
  private ScoreMorningFragment a;
  
  @UiThread
  public ScoreMorningFragment_ViewBinding(ScoreMorningFragment paramScoreMorningFragment, View paramView)
  {
    this.a = paramScoreMorningFragment;
    paramScoreMorningFragment.yearLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131296734, "field 'yearLayout'", RelativeLayout.class));
    paramScoreMorningFragment.yearName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296735, "field 'yearName'", TextView.class));
    paramScoreMorningFragment.leftNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296439, "field 'leftNumber'", TextView.class));
    paramScoreMorningFragment.centerNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296319, "field 'centerNumber'", TextView.class));
    paramScoreMorningFragment.rightNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296536, "field 'rightNumber'", TextView.class));
    paramScoreMorningFragment.noDataView = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296488, "field 'noDataView'", LinearLayout.class));
    paramScoreMorningFragment.scoreLayout = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296560, "field 'scoreLayout'", LinearLayout.class));
    paramScoreMorningFragment.runRecyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131296562, "field 'runRecyclerView'", RecyclerView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    ScoreMorningFragment localScoreMorningFragment = this.a;
    if (localScoreMorningFragment != null)
    {
      this.a = null;
      localScoreMorningFragment.yearLayout = null;
      localScoreMorningFragment.yearName = null;
      localScoreMorningFragment.leftNumber = null;
      localScoreMorningFragment.centerNumber = null;
      localScoreMorningFragment.rightNumber = null;
      localScoreMorningFragment.noDataView = null;
      localScoreMorningFragment.scoreLayout = null;
      localScoreMorningFragment.runRecyclerView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\score\ScoreMorningFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */