package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

class d
  implements ValueCallback<IX5JsError>
{
  d(JsContext paramJsContext) {}
  
  public void a(IX5JsError paramIX5JsError)
  {
    JsContext.a(this.a).handleException(this.a, new JsError(paramIX5JsError));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */