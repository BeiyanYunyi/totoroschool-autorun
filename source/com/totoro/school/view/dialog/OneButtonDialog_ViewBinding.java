package com.totoro.school.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OneButtonDialog_ViewBinding
  implements Unbinder
{
  private OneButtonDialog a;
  
  @UiThread
  public OneButtonDialog_ViewBinding(OneButtonDialog paramOneButtonDialog, View paramView)
  {
    this.a = paramOneButtonDialog;
    paramOneButtonDialog.rootView = Utils.findRequiredView(paramView, 2131296541, "field 'rootView'");
    paramOneButtonDialog.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramOneButtonDialog.contentView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296336, "field 'contentView'", TextView.class));
    paramOneButtonDialog.confirmBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296332, "field 'confirmBtn'", TextView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    OneButtonDialog localOneButtonDialog = this.a;
    if (localOneButtonDialog != null)
    {
      this.a = null;
      localOneButtonDialog.rootView = null;
      localOneButtonDialog.titleView = null;
      localOneButtonDialog.contentView = null;
      localOneButtonDialog.confirmBtn = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\OneButtonDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */