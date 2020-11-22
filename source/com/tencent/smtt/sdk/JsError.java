package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError
{
  private final IX5JsError a;
  
  protected JsError(IX5JsError paramIX5JsError)
  {
    this.a = paramIX5JsError;
  }
  
  public String getMessage()
  {
    return this.a.getMessage();
  }
  
  public String getStack()
  {
    return this.a.getStack();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\JsError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */