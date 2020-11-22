package com.pgyersdk.update.javabean;

public class AppBean
{
  private String a;
  private String b;
  private String c;
  private String d;
  private boolean e;
  
  public String getDownloadURL()
  {
    return this.c;
  }
  
  public String getReleaseNote()
  {
    return this.b;
  }
  
  public String getVersionCode()
  {
    return this.d;
  }
  
  public String getVersionName()
  {
    return this.a;
  }
  
  public boolean isShouldForceToUpdate()
  {
    return this.e;
  }
  
  public void setDownloadURL(String paramString)
  {
    this.c = paramString;
  }
  
  public void setReleaseNote(String paramString)
  {
    this.b = paramString;
  }
  
  public void setShouldForceToUpdate(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setVersionCode(String paramString)
  {
    this.d = paramString;
  }
  
  public void setVersionName(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\javabean\AppBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */