package com.totoro.school.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

public class d
{
  public static String a()
  {
    return Build.BRAND;
  }
  
  public static String a(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramActivity.getSystemService("phone");
    String str = localTelephonyManager.getNetworkOperator();
    int k;
    if (str.isEmpty()) {
      k = 0;
    } else {
      k = Integer.parseInt(str.substring(0, 3));
    }
    int m;
    if (str.isEmpty()) {
      m = 0;
    } else {
      m = Integer.parseInt(str.substring(3));
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = ContextCompat.checkSelfPermission(paramActivity, "android.permission.ACCESS_FINE_LOCATION");
      j = ContextCompat.checkSelfPermission(paramActivity, "android.permission.ACCESS_COARSE_LOCATION");
      if ((i == 0) && (j == 0))
      {
        if ((localTelephonyManager.getCellLocation() instanceof GsmCellLocation))
        {
          paramActivity = (GsmCellLocation)localTelephonyManager.getCellLocation();
          if (paramActivity != null)
          {
            i = paramActivity.getLac();
            j = paramActivity.getCid();
            break label283;
          }
        }
        else if ((localTelephonyManager.getCellLocation() instanceof CdmaCellLocation))
        {
          paramActivity = (CdmaCellLocation)localTelephonyManager.getCellLocation();
          if (paramActivity != null)
          {
            i = paramActivity.getNetworkId();
            j = paramActivity.getBaseStationId();
            break label283;
          }
        }
      }
      else {
        ActivityCompat.requestPermissions(paramActivity, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 1);
      }
    }
    else if ((localTelephonyManager.getCellLocation() instanceof GsmCellLocation))
    {
      paramActivity = (GsmCellLocation)localTelephonyManager.getCellLocation();
      if (paramActivity != null)
      {
        i = paramActivity.getLac();
        j = paramActivity.getCid();
        break label283;
      }
    }
    else if ((localTelephonyManager.getCellLocation() instanceof CdmaCellLocation))
    {
      paramActivity = (CdmaCellLocation)localTelephonyManager.getCellLocation();
      if (paramActivity != null)
      {
        i = paramActivity.getNetworkId();
        j = paramActivity.getBaseStationId();
        break label283;
      }
    }
    int j = 0;
    int i = 0;
    label283:
    paramActivity = new StringBuilder();
    paramActivity.append("mcc:");
    paramActivity.append(k);
    paramActivity.append(" ");
    localStringBuilder.append(paramActivity.toString());
    paramActivity = new StringBuilder();
    paramActivity.append("mnc:");
    paramActivity.append(m);
    paramActivity.append(" ");
    localStringBuilder.append(paramActivity.toString());
    paramActivity = new StringBuilder();
    paramActivity.append("lac:");
    paramActivity.append(i);
    paramActivity.append(" ");
    localStringBuilder.append(paramActivity.toString());
    paramActivity = new StringBuilder();
    paramActivity.append("ci:");
    paramActivity.append(j);
    paramActivity.append(" ");
    localStringBuilder.append(paramActivity.toString());
    paramActivity = new StringBuilder();
    paramActivity.append("strength:");
    paramActivity.append(0);
    localStringBuilder.append(paramActivity.toString());
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null) {
      return paramContext.getDeviceId();
    }
    return null;
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static String c()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */