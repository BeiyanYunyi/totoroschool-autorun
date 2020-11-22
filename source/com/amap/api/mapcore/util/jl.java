package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class jl
  extends Thread
{
  WeakReference<IAMapDelegate> a = null;
  private Context b;
  
  public jl(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramContext;
    this.a = new WeakReference(paramIAMapDelegate);
  }
  
  private void a(Context paramContext, fv paramfv, fl.a parama)
  {
    if (parama != null) {
      if (parama.w == null) {
        return;
      }
    }
    try
    {
      Object localObject = parama.w.optJSONObject("15S");
      paramContext = ((JSONObject)localObject).optString("url", "");
      String str1 = ((JSONObject)localObject).optString("md5", "");
      boolean bool1 = fl.a(((JSONObject)localObject).optString("able", ""), false);
      boolean bool2 = fl.a(((JSONObject)localObject).optString("on", ""), false);
      boolean bool3 = fl.a(((JSONObject)localObject).optString("mobileable", ""), false);
      boolean bool4 = fl.a(((JSONObject)localObject).optString("di", ""), false);
      boolean bool5 = fl.a(((JSONObject)localObject).optString("ig", ""), false);
      String str2 = ((JSONObject)localObject).optString("dis", "");
      if ((bool4) && (!fw.f(str2))) {
        return;
      }
      localObject = ((JSONObject)localObject).optString("cg");
      paramContext = hk.a(dx.e(), paramContext, str1, bool1, bool2, bool3, (String)localObject);
      hi.a(paramfv).a(this.b, paramContext, parama.a(), bool5);
      return;
    }
    catch (Throwable paramContext) {}
    return;
  }
  
  private void a(fl.a parama)
  {
    for (;;)
    {
      int i;
      try
      {
        parama = parama.x;
        if (parama == null) {
          break label111;
        }
        boolean bool = parama.a;
        du.a(this.b, "maploc", "ue", Boolean.valueOf(bool));
        parama = parama.c;
        k = parama.optInt("fn", 1000);
        j = parama.optInt("mpn", 0);
        i = j;
        if (j <= 500) {
          break label112;
        }
        i = 500;
      }
      catch (Throwable parama)
      {
        int k;
        gk.c(parama, "AuthUtil", "loadConfigDataUploadException");
      }
      im.a(k, fl.a(parama.optString("igu"), false));
      du.a(this.b, "maploc", "opn", Integer.valueOf(j));
      return;
      label111:
      return;
      label112:
      int j = i;
      if (i < 30) {
        j = 30;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("16G");
      boolean bool1 = fl.a(paramJSONObject.optString("able", ""), false);
      boolean bool2 = fl.a(paramJSONObject.optString("removeCache", ""), false);
      boolean bool3 = fl.a(paramJSONObject.optString("uploadInfo", ""), false);
      do.a(bool1);
      do.b(bool2);
      do.c(bool3);
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  private void b(Context paramContext, fv paramfv, fl.a parama)
  {
    if (parama != null) {
      if (parama.w == null) {
        return;
      }
    }
    try
    {
      parama = parama.w.optJSONObject("16V");
      boolean bool1 = fl.a(parama.optString("di", ""), false);
      String str = parama.optString("dis", "");
      boolean bool2 = fl.a(parama.optString("able", ""), false);
      boolean bool3 = fl.a(parama.optString("isFilter", ""), true);
      if ((bool1) && (!fw.f(str))) {
        return;
      }
      hi.a(paramfv).a(paramContext, bool2, bool3);
      return;
    }
    catch (Throwable paramContext) {}
    return;
  }
  
  public void run()
  {
    try
    {
      if (!MapsInitializer.getNetWorkEnable()) {
        return;
      }
      fr.a().a(this.b);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("14S");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("11K");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("001");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("14M");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("14L");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("16V");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("14Z");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("154");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("156");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("15C");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("15S");
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append("16G");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = fl.a(this.b, dx.e(), (String)localObject1, null);
      Object localObject2;
      if ((fl.a != 1) && (localObject1 != null) && (this.a != null) && (this.a.get() != null))
      {
        localObject2 = ((IAMapDelegate)this.a.get()).getMainHandler().obtainMessage();
        ((Message)localObject2).what = 2;
        if (((fl.a)localObject1).a != null) {
          ((Message)localObject2).obj = ((fl.a)localObject1).a;
        }
        ((IAMapDelegate)this.a.get()).getMainHandler().sendMessage((Message)localObject2);
      }
      final Object localObject4;
      if ((localObject1 != null) && (((fl.a)localObject1).w != null))
      {
        localObject4 = ((fl.a)localObject1).w.optJSONObject("154");
        if ((localObject4 != null) && (fl.a(((JSONObject)localObject4).getString("able"), true)))
        {
          localObject2 = ((JSONObject)localObject4).optString("mc");
          localObject4 = ((JSONObject)localObject4).optString("si");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            dn.a(this.b, "approval_number", "mc", localObject2);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            dn.a(this.b, "approval_number", "si", localObject4);
          }
        }
      }
      if ((localObject1 != null) && (((fl.a)localObject1).x != null))
      {
        localObject2 = dx.e();
        if (localObject2 != null) {
          ((fv)localObject2).a(((fl.a)localObject1).x.a);
        }
      }
      if ((MapsInitializer.isDownloadCoordinateConvertLibrary()) && (localObject1 != null) && (((fl.a)localObject1).B != null))
      {
        localObject2 = new fo(this.b, "3dmap", ((fl.a)localObject1).B.a, ((fl.a)localObject1).B.b);
        ((fo)localObject2).a(((fl.a)localObject1).a());
        ((fo)localObject2).a();
      }
      if (localObject1 != null) {
        a((fl.a)localObject1);
      }
      if (localObject1 != null) {
        try
        {
          if (((fl.a)localObject1).w != null)
          {
            localObject2 = ((fl.a)localObject1).w.optJSONObject("14M");
            if ((localObject2 != null) && (((JSONObject)localObject2).has("able")) && (fl.a(((JSONObject)localObject2).getString("able"), true)))
            {
              int i = 2592000;
              if (((JSONObject)localObject2).has("time")) {
                i = Math.max(60, ((JSONObject)localObject2).getInt("time"));
              }
              long l = dn.a(this.b, "Map3DCache", "time", Long.valueOf(0L)).longValue();
              if ((System.currentTimeMillis() - l > i * 1000) && (this.a != null) && (this.a.get() != null)) {
                ((IAMapDelegate)this.a.get()).clearTileCache();
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
      }
      final boolean bool;
      if (localObject1 != null)
      {
        JSONObject localJSONObject = ((fl.a)localObject1).w;
        if (localJSONObject != null) {
          try
          {
            localJSONObject = ((fl.a)localObject1).w.optJSONObject("14L");
            if ((localJSONObject != null) && (localJSONObject.has("able")))
            {
              bool = fl.a(localJSONObject.getString("able"), false);
              if ((this.a != null) && (this.a.get() != null)) {
                ((IAMapDelegate)this.a.get()).setHideLogoEnble(bool ^ true);
              }
            }
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
          }
        }
      }
      final Object localObject5;
      final Object localObject3;
      if ((localObject1 != null) && (((fl.a)localObject1).y != null))
      {
        localObject5 = ((fl.a)localObject1).y;
        if (localObject5 != null)
        {
          localObject3 = ((fl.a.d)localObject5).b;
          localObject4 = ((fl.a.d)localObject5).a;
          localObject5 = ((fl.a.d)localObject5).c;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
          {
            localObject3 = new gv((String)localObject4, (String)localObject3, (String)localObject5, ((fl.a)localObject1).a());
            new gu(this.b, (gv)localObject3, dx.e()).a();
          }
          else
          {
            new gu(this.b, null, dx.e()).a();
          }
        }
        else
        {
          new gu(this.b, null, dx.e()).a();
        }
      }
      if ((localObject1 != null) && (((fl.a)localObject1).w != null))
      {
        localObject3 = ((fl.a)localObject1).w.optJSONObject("156");
        if (localObject3 != null) {
          dh.a(fl.a(((JSONObject)localObject3).optString("able"), false));
        }
      }
      if ((localObject1 != null) && (((fl.a)localObject1).w != null))
      {
        final Object localObject6 = ((fl.a)localObject1).w.optJSONObject("15C");
        if (localObject6 != null)
        {
          bool = fl.a(((JSONObject)localObject6).optString("able"), false);
          localObject3 = ((JSONObject)localObject6).optString("logo_day_url");
          localObject4 = ((JSONObject)localObject6).optString("logo_day_md5");
          localObject5 = ((JSONObject)localObject6).optString("logo_night_url");
          localObject6 = ((JSONObject)localObject6).optString("logo_night_md5");
          dw.a().a(new Runnable()
          {
            public void run()
            {
              boolean bool;
              String str1;
              Object localObject;
              String str2;
              if ((!TextUtils.isEmpty(localObject4)) && (!TextUtils.isEmpty(localObject3)))
              {
                bool = bool;
                str1 = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                localObject = localObject3;
                str2 = localObject4;
                if (bool)
                {
                  localObject = new km.d((String)localObject, str2, str1);
                  ((km.d)localObject).a("amap_web_logo", "md5_day");
                  new km(jl.a(jl.this), (km.a)localObject, dx.e()).a();
                }
                if ((jl.this.a != null) && (jl.this.a.get() != null)) {
                  ((IAMapDelegate)jl.this.a.get()).changeLogoIconStyle(str1, bool, 0);
                }
              }
              if ((!TextUtils.isEmpty(localObject6)) && (!TextUtils.isEmpty(localObject5)))
              {
                bool = bool;
                str1 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
                localObject = localObject5;
                str2 = localObject6;
                if (bool)
                {
                  localObject = new km.d((String)localObject, str2, str1);
                  ((km.d)localObject).a("amap_web_logo", "md5_night");
                  new km(jl.a(jl.this), (km.a)localObject, dx.e()).a();
                }
                if ((jl.this.a != null) && (jl.this.a.get() != null)) {
                  ((IAMapDelegate)jl.this.a.get()).changeLogoIconStyle(str1, bool, 1);
                }
              }
            }
          });
        }
      }
      if ((localObject1 != null) && (((fl.a)localObject1).w != null))
      {
        a(this.b, dx.e(), (fl.a)localObject1);
        b(this.b, dx.e(), (fl.a)localObject1);
      }
      if ((localObject1 != null) && (((fl.a)localObject1).w != null)) {
        a(((fl.a)localObject1).w);
      }
      gk.a(this.b, dx.e());
      interrupt();
      if ((this.a != null) && (this.a.get() != null))
      {
        ((IAMapDelegate)this.a.get()).setRunLowFrame(false);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      interrupt();
      gk.c(localThrowable1, "AMapDelegateImpGLSurfaceView", "mVerfy");
      localThrowable1.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */