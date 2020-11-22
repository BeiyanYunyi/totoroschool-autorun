package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context a;
  private final IX5JsVirtualMachine b;
  private final HashSet<WeakReference<a>> c = new HashSet();
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.a = paramContext;
    this.b = X5JsCore.a(paramContext, paramLooper);
  }
  
  protected IX5JsContext a()
  {
    if (this.b == null)
    {
      a locala = new a(this.a);
      this.c.add(new WeakReference(locala));
      return locala;
    }
    return this.b.createJsContext();
  }
  
  public void destroy()
  {
    if (this.b != null)
    {
      this.b.destroy();
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).destroy();
      }
    }
  }
  
  public Looper getLooper()
  {
    if (this.b != null) {
      return this.b.getLooper();
    }
    return Looper.myLooper();
  }
  
  public boolean isFallback()
  {
    return this.b == null;
  }
  
  public void onPause()
  {
    if (this.b != null)
    {
      this.b.onPause();
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).a();
      }
    }
  }
  
  public void onResume()
  {
    if (this.b != null)
    {
      this.b.onResume();
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).b();
      }
    }
  }
  
  private static class a
    implements IX5JsContext
  {
    private WebView a;
    
    public a(Context paramContext)
    {
      this.a = new WebView(paramContext);
      this.a.getSettings().setJavaScriptEnabled(true);
    }
    
    public void a()
    {
      if (this.a == null) {
        return;
      }
      this.a.onPause();
    }
    
    public void addJavascriptInterface(Object paramObject, String paramString)
    {
      if (this.a == null) {
        return;
      }
      this.a.addJavascriptInterface(paramObject, paramString);
      this.a.loadUrl("about:blank");
    }
    
    public void b()
    {
      if (this.a == null) {
        return;
      }
      this.a.onResume();
    }
    
    public void destroy()
    {
      if (this.a == null) {
        return;
      }
      this.a.clearHistory();
      this.a.clearCache(true);
      this.a.loadUrl("about:blank");
      this.a.freeMemory();
      this.a.pauseTimers();
      this.a.destroy();
      this.a = null;
    }
    
    public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
    {
      if (this.a == null) {
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {
        paramValueCallback = null;
      } else {
        paramValueCallback = new e(this, paramValueCallback);
      }
      paramURL.evaluateJavascript(paramString, paramValueCallback);
    }
    
    public IX5JsValue evaluateScript(String paramString, URL paramURL)
    {
      if (this.a == null) {
        return null;
      }
      this.a.evaluateJavascript(paramString, null);
      return null;
    }
    
    public void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
    {
      if (this.a == null) {
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {
        paramValueCallback = null;
      } else {
        paramValueCallback = new f(this, paramValueCallback);
      }
      paramURL.evaluateJavascript(paramString, paramValueCallback);
    }
    
    public void removeJavascriptInterface(String paramString)
    {
      if (this.a == null) {
        return;
      }
      this.a.removeJavascriptInterface(paramString);
    }
    
    public void setExceptionHandler(ValueCallback<IX5JsError> paramValueCallback) {}
    
    public void setName(String paramString) {}
    
    public void setPerContextData(Object paramObject) {}
    
    public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\JsVirtualMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */