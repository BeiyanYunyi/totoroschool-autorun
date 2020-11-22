package com.totoro.school.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class QrCodeDialog_ViewBinding
  implements Unbinder
{
  private QrCodeDialog a;
  
  @UiThread
  public QrCodeDialog_ViewBinding(QrCodeDialog paramQrCodeDialog, View paramView)
  {
    this.a = paramQrCodeDialog;
    paramQrCodeDialog.rootView = Utils.findRequiredView(paramView, 2131296541, "field 'rootView'");
    paramQrCodeDialog.qrCodeView = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131296524, "field 'qrCodeView'", ImageView.class));
    paramQrCodeDialog.contentView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296336, "field 'contentView'", TextView.class));
    paramQrCodeDialog.confirmBtn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131296332, "field 'confirmBtn'", TextView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    QrCodeDialog localQrCodeDialog = this.a;
    if (localQrCodeDialog != null)
    {
      this.a = null;
      localQrCodeDialog.rootView = null;
      localQrCodeDialog.qrCodeView = null;
      localQrCodeDialog.contentView = null;
      localQrCodeDialog.confirmBtn = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\QrCodeDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */