package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class al
  extends HandlerThread
{
  private static al a;
  
  public al(String paramString)
  {
    super(paramString);
  }
  
  public static al a()
  {
    try
    {
      if (a == null)
      {
        a = new al("TbsHandlerThread");
        a.start();
      }
      al localal = a;
      return localal;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */