package com.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class bn
{
  int c = 20000;
  int d = 20000;
  Proxy e = null;
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(Proxy paramProxy)
  {
    this.e = paramProxy;
  }
  
  public abstract Map<String, String> b();
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public abstract Map<String, String> b_();
  
  public abstract String c();
  
  public byte[] d()
  {
    return null;
  }
  
  protected String j()
  {
    return "";
  }
  
  protected final boolean k()
  {
    return !TextUtils.isEmpty(j());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */