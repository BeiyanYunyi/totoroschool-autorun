package com.totoro.school.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TwoButtonDialog_ViewBinding
  implements Unbinder
{
  private TwoButtonDialog a;
  
  @UiThread
  public TwoButtonDialog_ViewBinding(TwoButtonDialog paramTwoButtonDialog, View paramView)
  {
    this.a = paramTwoButtonDialog;
    paramTwoButtonDialog.rootView = Utils.findRequiredView(paramView, 2131296541, "field 'rootView'");
    paramTwoButtonDialog.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramTwoButtonDialog.contentView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296336, "field 'contentView'", TextView.class));
    paramTwoButtonDialog.leftBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296437, "field 'leftBtn'", TextView.class));
    paramTwoButtonDialog.rightBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296533, "field 'rightBtn'", TextView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    TwoButtonDialog localTwoButtonDialog = this.a;
    if (localTwoButtonDialog != null)
    {
      this.a = null;
      localTwoButtonDialog.rootView = null;
      localTwoButtonDialog.titleView = null;
      localTwoButtonDialog.contentView = null;
      localTwoButtonDialog.leftBtn = null;
      localTwoButtonDialog.rightBtn = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\TwoButtonDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */