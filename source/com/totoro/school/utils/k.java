package com.totoro.school.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class k
{
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */