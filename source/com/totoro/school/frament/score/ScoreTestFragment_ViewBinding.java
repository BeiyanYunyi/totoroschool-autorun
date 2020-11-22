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

public class ScoreTestFragment_ViewBinding
  implements Unbinder
{
  private ScoreTestFragment a;
  
  @UiThread
  public ScoreTestFragment_ViewBinding(ScoreTestFragment paramScoreTestFragment, View paramView)
  {
    this.a = paramScoreTestFragment;
    paramScoreTestFragment.yearLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131296734, "field 'yearLayout'", RelativeLayout.class));
    paramScoreTestFragment.yearName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296735, "field 'yearName'", TextView.class));
    paramScoreTestFragment.leftText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296440, "field 'leftText'", TextView.class));
    paramScoreTestFragment.centerText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296320, "field 'centerText'", TextView.class));
    paramScoreTestFragment.rightText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296538, "field 'rightText'", TextView.class));
    paramScoreTestFragment.leftNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296439, "field 'leftNumber'", TextView.class));
    paramScoreTestFragment.centerNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296319, "field 'centerNumber'", TextView.class));
    paramScoreTestFragment.rightNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296536, "field 'rightNumber'", TextView.class));
    paramScoreTestFragment.noDataView = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296488, "field 'noDataView'", LinearLayout.class));
    paramScoreTestFragment.scoreLayout = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131296560, "field 'scoreLayout'", LinearLayout.class));
    paramScoreTestFragment.testRecyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131296566, "field 'testRecyclerView'", RecyclerView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    ScoreTestFragment localScoreTestFragment = this.a;
    if (localScoreTestFragment != null)
    {
      this.a = null;
      localScoreTestFragment.yearLayout = null;
      localScoreTestFragment.yearName = null;
      localScoreTestFragment.leftText = null;
      localScoreTestFragment.centerText = null;
      localScoreTestFragment.rightText = null;
      localScoreTestFragment.leftNumber = null;
      localScoreTestFragment.centerNumber = null;
      localScoreTestFragment.rightNumber = null;
      localScoreTestFragment.noDataView = null;
      localScoreTestFragment.scoreLayout = null;
      localScoreTestFragment.testRecyclerView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\score\ScoreTestFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */