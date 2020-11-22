package com.totoro.school.utilpub.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.google.gson.e;
import com.totoro.school.MyApplication;

public class a
{
  private static volatile a a;
  private e b = new e();
  private SharedPreferences c = MyApplication.a().getSharedPreferences("globals", 0);
  private SharedPreferences.Editor d = this.c.edit();
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    paramLatLng = this.b.a(paramLatLng);
    this.d.putString("location_latlng", com.totoro.school.utilpub.network.a.a.a(paramLatLng));
    this.d.commit();
  }
  
  public LatLng b()
  {
    String str = this.c.getString("location_latlng", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (LatLng)this.b.a(com.totoro.school.utilpub.network.a.a.b(str), LatLng.class);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */