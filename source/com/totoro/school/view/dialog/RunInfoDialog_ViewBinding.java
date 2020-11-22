package com.totoro.school.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class RunInfoDialog_ViewBinding
  implements Unbinder
{
  private RunInfoDialog a;
  
  @UiThread
  public RunInfoDialog_ViewBinding(RunInfoDialog paramRunInfoDialog, View paramView)
  {
    this.a = paramRunInfoDialog;
    paramRunInfoDialog.rootView = Utils.findRequiredView(paramView, 2131296541, "field 'rootView'");
    paramRunInfoDialog.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramRunInfoDialog.mileageView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296471, "field 'mileageView'", TextView.class));
    paramRunInfoDialog.useTimeView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296714, "field 'useTimeView'", TextView.class));
    paramRunInfoDialog.confirmBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296332, "field 'confirmBtn'", TextView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    RunInfoDialog localRunInfoDialog = this.a;
    if (localRunInfoDialog != null)
    {
      this.a = null;
      localRunInfoDialog.rootView = null;
      localRunInfoDialog.titleView = null;
      localRunInfoDialog.mileageView = null;
      localRunInfoDialog.useTimeView = null;
      localRunInfoDialog.confirmBtn = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\RunInfoDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */