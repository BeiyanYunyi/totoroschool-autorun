package com.totoro.school.frament.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class FindFragment_ViewBinding
  implements Unbinder
{
  private FindFragment a;
  
  @UiThread
  public FindFragment_ViewBinding(FindFragment paramFindFragment, View paramView)
  {
    this.a = paramFindFragment;
    paramFindFragment.mWebView = ((WebView)Utils.findRequiredViewAsType(paramView, 2131296727, "field 'mWebView'", WebView.class));
  }
  
  @CallSuper
  public void unbind()
  {
    FindFragment localFindFragment = this.a;
    if (localFindFragment != null)
    {
      this.a = null;
      localFindFragment.mWebView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\FindFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */