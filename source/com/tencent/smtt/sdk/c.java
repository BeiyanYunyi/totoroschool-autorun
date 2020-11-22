package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

class c
  implements ValueCallback<IX5JsValue>
{
  c(JsContext paramJsContext, ValueCallback paramValueCallback) {}
  
  public void a(IX5JsValue paramIX5JsValue)
  {
    ValueCallback localValueCallback = this.a;
    if (paramIX5JsValue == null) {
      paramIX5JsValue = null;
    } else {
      paramIX5JsValue = new JsValue(this.b, paramIX5JsValue);
    }
    localValueCallback.onReceiveValue(paramIX5JsValue);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */