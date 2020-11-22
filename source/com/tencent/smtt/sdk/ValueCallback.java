package com.tencent.smtt.sdk;

public abstract interface ValueCallback<T>
  extends android.webkit.ValueCallback<T>
{
  public abstract void onReceiveValue(T paramT);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */