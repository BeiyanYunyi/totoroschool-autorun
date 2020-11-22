package com.amap.api.offlineservice;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

public abstract class a
{
  protected OfflineMapActivity a = null;
  
  public int a(float paramFloat)
  {
    if (this.a != null) {
      return (int)(paramFloat * (this.a.getResources().getDisplayMetrics().densityDpi / 160.0F) + 0.5F);
    }
    return (int)paramFloat;
  }
  
  public abstract void a();
  
  public void a(Bundle paramBundle)
  {
    this.a.showScr();
  }
  
  public abstract void a(View paramView);
  
  public void a(OfflineMapActivity paramOfflineMapActivity)
  {
    this.a = paramOfflineMapActivity;
  }
  
  public abstract RelativeLayout b();
  
  public abstract void c();
  
  public boolean e()
  {
    return true;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\offlineservice\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */