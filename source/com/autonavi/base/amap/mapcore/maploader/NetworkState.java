package com.autonavi.base.amap.mapcore.maploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;

public class NetworkState
{
  private boolean isNetReceiverRegistered = false;
  private NetworkChangeListener mNetworkListener;
  private MyBroadcastReceiver netChangeReceiver = null;
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localObject == null) {
          return null;
        }
        paramContext = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return paramContext;
        }
        localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
        if (localObject != null) {
          break label91;
        }
        return null;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        paramContext.printStackTrace();
        return null;
      }
      if (i < localObject.length)
      {
        if ((localObject[i] != null) && (localObject[i].isConnected()))
        {
          paramContext = localObject[i];
          return paramContext;
        }
        i += 1;
      }
      else
      {
        return paramContext;
        label91:
        i = 0;
      }
    }
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public void registerNetChangeReceiver(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.isNetReceiverRegistered)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.netChangeReceiver == null) {
          this.netChangeReceiver = new MyBroadcastReceiver(this.mNetworkListener);
        }
        paramContext.registerReceiver(this.netChangeReceiver, localIntentFilter);
      }
    }
    else if ((this.isNetReceiverRegistered) && (this.netChangeReceiver != null))
    {
      paramContext.unregisterReceiver(this.netChangeReceiver);
      this.netChangeReceiver = null;
    }
    this.isNetReceiverRegistered = paramBoolean;
  }
  
  public void setNetworkListener(NetworkChangeListener paramNetworkChangeListener)
  {
    this.mNetworkListener = paramNetworkChangeListener;
  }
  
  static class MyBroadcastReceiver
    extends BroadcastReceiver
  {
    WeakReference<NetworkState.NetworkChangeListener> reference = null;
    
    public MyBroadcastReceiver(NetworkState.NetworkChangeListener paramNetworkChangeListener)
    {
      this.reference = new WeakReference(paramNetworkChangeListener);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((this.reference != null) && (this.reference.get() != null)) {
        ((NetworkState.NetworkChangeListener)this.reference.get()).networkStateChanged(paramContext);
      }
    }
  }
  
  public static abstract interface NetworkChangeListener
  {
    public abstract void networkStateChanged(Context paramContext);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\maploader\NetworkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */