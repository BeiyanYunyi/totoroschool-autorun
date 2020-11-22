package com.totoro.school.utilpub.network.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

public class c
{
  public static int a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return 0;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      if (!localNetworkInfo.isAvailable()) {
        return 0;
      }
      localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
      if (localObject != null)
      {
        localObject = ((NetworkInfo)localObject).getState();
        if ((localObject != null) && ((localObject == NetworkInfo.State.CONNECTED) || (localObject == NetworkInfo.State.CONNECTING))) {
          return 1;
        }
      }
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default: 
        return 5;
      case 13: 
        return 4;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return 3;
      }
      return 2;
    }
    return 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */