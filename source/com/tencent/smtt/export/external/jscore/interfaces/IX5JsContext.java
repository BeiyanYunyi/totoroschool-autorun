package com.tencent.smtt.export.external.jscore.interfaces;

import android.webkit.ValueCallback;
import java.net.URL;

public abstract interface IX5JsContext
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void destroy();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL);
  
  public abstract IX5JsValue evaluateScript(String paramString, URL paramURL);
  
  public abstract void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL);
  
  public abstract void removeJavascriptInterface(String paramString);
  
  public abstract void setExceptionHandler(ValueCallback<IX5JsError> paramValueCallback);
  
  public abstract void setName(String paramString);
  
  public abstract void setPerContextData(Object paramObject);
  
  public abstract void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\jscore\interfaces\IX5JsContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */