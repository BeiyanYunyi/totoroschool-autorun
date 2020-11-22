package com.totoro.school.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class GpsWeakDialog_ViewBinding
  implements Unbinder
{
  private GpsWeakDialog a;
  
  @UiThread
  public GpsWeakDialog_ViewBinding(GpsWeakDialog paramGpsWeakDialog, View paramView)
  {
    this.a = paramGpsWeakDialog;
    paramGpsWeakDialog.rootView = Utils.findRequiredView(paramView, 2131296541, "field 'rootView'");
    paramGpsWeakDialog.titleView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296664, "field 'titleView'", TextView.class));
    paramGpsWeakDialog.contentView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296336, "field 'contentView'", TextView.class));
    paramGpsWeakDialog.confirmBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296332, "field 'confirmBtn'", TextView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    GpsWeakDialog localGpsWeakDialog = this.a;
    if (localGpsWeakDialog != null)
    {
      this.a = null;
      localGpsWeakDialog.rootView = null;
      localGpsWeakDialog.titleView = null;
      localGpsWeakDialog.contentView = null;
      localGpsWeakDialog.confirmBtn = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\GpsWeakDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */