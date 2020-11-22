package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.ae.a;
import com.amap.api.mapcore.util.ai;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.bj;
import com.amap.api.mapcore.util.dv;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.fr;
import com.amap.api.mapcore.util.gk;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager
{
  ai a;
  ae b;
  private Context c;
  private OfflineMapDownloadListener d;
  private OfflineLoadedListener e;
  private Handler f;
  private Handler g;
  
  public OfflineMapManager(Context paramContext, OfflineMapDownloadListener paramOfflineMapDownloadListener)
  {
    this.d = paramOfflineMapDownloadListener;
    this.c = paramContext.getApplicationContext();
    this.f = new Handler(this.c.getMainLooper());
    this.g = new Handler(this.c.getMainLooper());
    a(paramContext);
    fr.a().a(this.c);
  }
  
  public OfflineMapManager(Context paramContext, OfflineMapDownloadListener paramOfflineMapDownloadListener, AMap paramAMap)
  {
    this.d = paramOfflineMapDownloadListener;
    this.c = paramContext.getApplicationContext();
    this.f = new Handler(this.c.getMainLooper());
    this.g = new Handler(this.c.getMainLooper());
    try
    {
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a()
    throws AMapException
  {
    if (dx.d(this.c)) {
      return;
    }
    throw new AMapException("http连接失败 - ConnectionException");
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    ae.b = false;
    this.b = ae.a(this.c);
    this.b.a(new ae.a()
    {
      public void a()
      {
        if (OfflineMapManager.c(OfflineMapManager.this) != null) {
          OfflineMapManager.b(OfflineMapManager.this).post(new Runnable()
          {
            public void run()
            {
              try
              {
                OfflineMapManager.c(OfflineMapManager.this).onVerifyComplete();
                return;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
          });
        }
      }
      
      public void a(final az paramAnonymousaz)
      {
        if ((OfflineMapManager.a(OfflineMapManager.this) != null) && (paramAnonymousaz != null)) {
          OfflineMapManager.b(OfflineMapManager.this).post(new Runnable()
          {
            public void run()
            {
              try
              {
                OfflineMapManager.a(OfflineMapManager.this).onDownload(paramAnonymousaz.c().b(), paramAnonymousaz.getcompleteCode(), paramAnonymousaz.getCity());
                return;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
          });
        }
      }
      
      public void b(final az paramAnonymousaz)
      {
        if ((OfflineMapManager.a(OfflineMapManager.this) != null) && (paramAnonymousaz != null)) {
          OfflineMapManager.b(OfflineMapManager.this).post(new Runnable()
          {
            public void run()
            {
              try
              {
                if ((!paramAnonymousaz.c().equals(paramAnonymousaz.g)) && (!paramAnonymousaz.c().equals(paramAnonymousaz.a)))
                {
                  OfflineMapManager.a(OfflineMapManager.this).onCheckUpdate(false, paramAnonymousaz.getCity());
                  return;
                }
                OfflineMapManager.a(OfflineMapManager.this).onCheckUpdate(true, paramAnonymousaz.getCity());
                return;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
          });
        }
      }
      
      public void c(final az paramAnonymousaz)
      {
        if ((OfflineMapManager.a(OfflineMapManager.this) != null) && (paramAnonymousaz != null)) {
          OfflineMapManager.b(OfflineMapManager.this).post(new Runnable()
          {
            public void run()
            {
              try
              {
                if (paramAnonymousaz.c().equals(paramAnonymousaz.a))
                {
                  OfflineMapManager.a(OfflineMapManager.this).onRemove(true, paramAnonymousaz.getCity(), "");
                  return;
                }
                OfflineMapManager.a(OfflineMapManager.this).onRemove(false, paramAnonymousaz.getCity(), "");
                return;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
          });
        }
      }
    });
    try
    {
      this.b.a();
      this.a = this.b.f;
      dv.b(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2)
    throws AMapException
  {
    this.b.a(paramString1);
  }
  
  private void b()
  {
    this.d = null;
  }
  
  public void destroy()
  {
    try
    {
      if (this.b != null) {
        this.b.e();
      }
      b();
      if (this.f != null) {
        this.f.removeCallbacksAndMessages(null);
      }
      this.f = null;
      if (this.g != null) {
        this.g.removeCallbacksAndMessages(null);
      }
      this.g = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void downloadByCityCode(String paramString)
    throws AMapException
  {
    try
    {
      this.b.e(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void downloadByCityName(String paramString)
    throws AMapException
  {
    try
    {
      this.b.d(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void downloadByProvinceName(String paramString)
    throws AMapException
  {
    try
    {
      a();
      paramString = getItemByProvinceName(paramString);
      if (paramString != null)
      {
        paramString = paramString.getCityList().iterator();
        while (paramString.hasNext())
        {
          final String str = ((OfflineMapCity)paramString.next()).getCity();
          this.g.post(new Runnable()
          {
            public void run()
            {
              try
              {
                OfflineMapManager.this.b.d(str);
                return;
              }
              catch (AMapException localAMapException)
              {
                gk.c(localAMapException, "OfflineMapManager", "downloadByProvinceName");
              }
            }
          });
        }
      }
      throw new AMapException("无效的参数 - IllegalArgumentException");
    }
    catch (Throwable paramString)
    {
      if (!(paramString instanceof AMapException))
      {
        gk.c(paramString, "OfflineMapManager", "downloadByProvinceName");
        return;
      }
      throw ((AMapException)paramString);
    }
  }
  
  public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList()
  {
    return this.a.c();
  }
  
  public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList()
  {
    return this.a.d();
  }
  
  public ArrayList<OfflineMapCity> getDownloadingCityList()
  {
    return this.a.e();
  }
  
  public ArrayList<OfflineMapProvince> getDownloadingProvinceList()
  {
    return this.a.f();
  }
  
  public OfflineMapCity getItemByCityCode(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public OfflineMapCity getItemByCityName(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public OfflineMapProvince getItemByProvinceName(String paramString)
  {
    return this.a.c(paramString);
  }
  
  public ArrayList<OfflineMapCity> getOfflineMapCityList()
  {
    return this.a.b();
  }
  
  public ArrayList<OfflineMapProvince> getOfflineMapProvinceList()
  {
    return this.a.a();
  }
  
  public void pause()
  {
    this.b.d();
  }
  
  public void remove(String paramString)
  {
    try
    {
      if (this.b.b(paramString))
      {
        this.b.c(paramString);
        return;
      }
      final Object localObject = this.a.c(paramString);
      if ((localObject != null) && (((OfflineMapProvince)localObject).getCityList() != null)) {
        paramString = ((OfflineMapProvince)localObject).getCityList().iterator();
      }
      while (paramString.hasNext())
      {
        localObject = ((OfflineMapCity)paramString.next()).getCity();
        this.g.post(new Runnable()
        {
          public void run()
          {
            OfflineMapManager.this.b.c(localObject);
          }
        });
        continue;
        if (this.d != null) {
          this.d.onRemove(false, paramString, "没有该城市");
        }
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void restart() {}
  
  public void setOnOfflineLoadedListener(OfflineLoadedListener paramOfflineLoadedListener)
  {
    this.e = paramOfflineLoadedListener;
  }
  
  public void stop()
  {
    this.b.c();
  }
  
  public void updateOfflineCityByCode(String paramString)
    throws AMapException
  {
    paramString = getItemByCityCode(paramString);
    if ((paramString != null) && (paramString.getCity() != null))
    {
      a(paramString.getCity(), "cityname");
      return;
    }
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public void updateOfflineCityByName(String paramString)
    throws AMapException
  {
    a(paramString, "cityname");
  }
  
  public void updateOfflineMapProvinceByName(String paramString)
    throws AMapException
  {
    a(paramString, "cityname");
  }
  
  public static abstract interface OfflineLoadedListener
  {
    public abstract void onVerifyComplete();
  }
  
  public static abstract interface OfflineMapDownloadListener
  {
    public abstract void onCheckUpdate(boolean paramBoolean, String paramString);
    
    public abstract void onDownload(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onRemove(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\OfflineMapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */