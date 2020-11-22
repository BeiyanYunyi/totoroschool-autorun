package com.amap.api.maps.model;

import android.os.RemoteException;

public final class RuntimeRemoteException
  extends RuntimeException
{
  private static final long serialVersionUID = -3541841807100437802L;
  
  public RuntimeRemoteException(RemoteException paramRemoteException)
  {
    super(paramRemoteException);
  }
  
  public RuntimeRemoteException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\RuntimeRemoteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */