package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class u
  extends WebChromeClient.FileChooserParams
{
  u(q paramq, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.a.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.a.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.a.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.a.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.a.isCaptureEnabled();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */