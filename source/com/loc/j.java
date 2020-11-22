package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

public final class j
{
  static cx b;
  static an e;
  static long g;
  String a = null;
  cx c = null;
  cx d = null;
  long f = 0L;
  boolean h = false;
  private Context i;
  
  public j(Context paramContext)
  {
    this.i = paramContext.getApplicationContext();
  }
  
  private void e()
  {
    if ((b == null) || (dn.b() - g > 180000L))
    {
      cx localcx = f();
      g = dn.b();
      if ((localcx != null) && (dn.a(localcx.a()))) {
        b = localcx;
      }
    }
  }
  
  private cx f()
  {
    Object localObject1 = this.i;
    Object localObject4 = null;
    AMapLocation localAMapLocation = null;
    if (localObject1 == null) {
      return null;
    }
    a();
    for (;;)
    {
      Object localObject3;
      try
      {
        if (e == null) {
          return null;
        }
        localObject1 = e.a("_id=1", cx.class, false);
        if (((List)localObject1).size() <= 0) {
          break label306;
        }
        localObject4 = (cx)((List)localObject1).get(0);
        localObject3 = localObject4;
        try
        {
          localObject1 = q.b(((cx)localObject4).c());
          if (localObject1 == null) {
            break label301;
          }
          localObject3 = localObject4;
          if (localObject1.length <= 0) {
            break label301;
          }
          localObject3 = localObject4;
          localObject1 = cv.c((byte[])localObject1, this.a);
          if (localObject1 == null) {
            break label301;
          }
          localObject3 = localObject4;
          if (localObject1.length <= 0) {
            break label301;
          }
          localObject3 = localObject4;
          localObject1 = new String((byte[])localObject1, "UTF-8");
          localObject3 = localObject4;
          byte[] arrayOfByte = q.b(((cx)localObject4).b());
          localObject5 = localAMapLocation;
          if (arrayOfByte != null)
          {
            localObject5 = localAMapLocation;
            localObject3 = localObject4;
            if (arrayOfByte.length > 0)
            {
              localObject3 = localObject4;
              arrayOfByte = cv.c(arrayOfByte, this.a);
              localObject5 = localAMapLocation;
              if (arrayOfByte != null)
              {
                localObject5 = localAMapLocation;
                localObject3 = localObject4;
                if (arrayOfByte.length > 0)
                {
                  localObject3 = localObject4;
                  localObject5 = new String(arrayOfByte, "UTF-8");
                }
              }
            }
          }
          localObject3 = localObject4;
          ((cx)localObject4).a((String)localObject5);
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject5 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label298;
          }
          localObject3 = localObject1;
          localAMapLocation = new AMapLocation("");
          localObject3 = localObject1;
          dg.a(localAMapLocation, new JSONObject((String)localObject4));
          localObject3 = localObject1;
          localObject5 = localObject1;
          if (!dn.b(localAMapLocation)) {
            break label298;
          }
          localObject3 = localObject1;
          ((cx)localObject1).a(localAMapLocation);
          return (cx)localObject1;
        }
        catch (Throwable localThrowable1) {}
        dg.a(localThrowable2, "LastLocationManager", "readLastFix");
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = null;
      }
      Object localObject5 = localObject3;
      label298:
      return (cx)localObject5;
      label301:
      Object localObject2 = null;
      continue;
      label306:
      localObject2 = null;
    }
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation, String paramString, long paramLong)
  {
    if (paramAMapLocation == null) {
      return paramAMapLocation;
    }
    AMapLocation localAMapLocation = paramAMapLocation;
    if (paramAMapLocation.getErrorCode() != 0)
    {
      localAMapLocation = paramAMapLocation;
      if (paramAMapLocation.getLocationType() != 1)
      {
        if (paramAMapLocation.getErrorCode() == 7) {
          return paramAMapLocation;
        }
        try
        {
          e();
          if (b != null)
          {
            if (b.a() == null) {
              return paramAMapLocation;
            }
            boolean bool2 = false;
            boolean bool1;
            if (TextUtils.isEmpty(paramString))
            {
              long l = dn.b() - b.d();
              bool1 = bool2;
              if (l >= 0L)
              {
                bool1 = bool2;
                if (l <= paramLong) {
                  bool1 = true;
                }
              }
              paramAMapLocation.setTrustedLevel(3);
            }
            else
            {
              bool1 = dn.a(b.b(), paramString);
              paramAMapLocation.setTrustedLevel(2);
            }
            localAMapLocation = paramAMapLocation;
            if (!bool1) {
              break label193;
            }
            localAMapLocation = b.a();
            try
            {
              localAMapLocation.setLocationType(9);
              localAMapLocation.setFixLastLocation(true);
              localAMapLocation.setLocationDetail(paramAMapLocation.getLocationDetail());
              return localAMapLocation;
            }
            catch (Throwable paramString)
            {
              paramAMapLocation = localAMapLocation;
            }
          }
          else
          {
            return paramAMapLocation;
          }
        }
        catch (Throwable paramString)
        {
          dg.a(paramString, "LastLocationManager", "fixLastLocation");
          localAMapLocation = paramAMapLocation;
        }
      }
    }
    label193:
    return localAMapLocation;
  }
  
  public final void a()
  {
    if (this.h) {
      return;
    }
    try
    {
      if (this.a == null) {
        this.a = cv.a("MD5", p.w(this.i));
      }
      if (e == null)
      {
        am localam = an.a(cy.class);
        e = new an(this.i, localam);
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "LastLocationManager", "<init>:DBOperation");
    }
    this.h = true;
  }
  
  public final boolean a(AMapLocation paramAMapLocation, String paramString)
  {
    if (this.i != null)
    {
      if (paramAMapLocation == null) {
        return false;
      }
      if ((dn.a(paramAMapLocation)) && (paramAMapLocation.getLocationType() != 2) && (!paramAMapLocation.isMock()))
      {
        if (paramAMapLocation.isFixLastLocation()) {
          return false;
        }
        cx localcx = new cx();
        localcx.a(paramAMapLocation);
        if (paramAMapLocation.getLocationType() == 1) {
          localcx.a(null);
        } else {
          localcx.a(paramString);
        }
        try
        {
          b = localcx;
          g = dn.b();
          this.c = localcx;
          if ((this.d != null) && (dn.a(this.d.a(), localcx.a()) <= 500.0F)) {
            return false;
          }
          long l1 = dn.b();
          long l2 = this.f;
          if (l1 - l2 > 30000L) {
            return true;
          }
        }
        catch (Throwable paramAMapLocation)
        {
          dg.a(paramAMapLocation, "LastLocationManager", "setLastFix");
        }
      }
    }
    return false;
  }
  
  public final AMapLocation b()
  {
    e();
    if (b == null) {
      return null;
    }
    if (!dn.a(b.a())) {
      return null;
    }
    return b.a();
  }
  
  public final void c()
  {
    try
    {
      d();
      this.f = 0L;
      this.h = false;
      this.c = null;
      this.d = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "LastLocationManager", "destroy");
    }
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        a();
        if ((this.c != null) && (dn.a(this.c.a())) && (e != null) && (this.c != this.d))
        {
          if (this.c.d() != 0L) {
            return;
          }
          Object localObject1 = this.c.a().toStr();
          String str2 = this.c.b();
          this.d = this.c;
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          String str1 = null;
          if (bool) {
            break label225;
          }
          Object localObject3 = q.b(cv.b(((String)localObject1).getBytes("UTF-8"), this.a));
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(str2))
          {
            str1 = q.b(cv.b(str2.getBytes("UTF-8"), this.a));
            localObject1 = localObject3;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new cx();
            ((cx)localObject3).b((String)localObject1);
            ((cx)localObject3).a(dn.b());
            ((cx)localObject3).a(str1);
            e.a(localObject3, "_id=1");
            this.f = dn.b();
            if (b != null) {
              b.a(dn.b());
            }
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "LastLocationManager", "saveLastFix");
        return;
      }
      label225:
      Object localObject2 = null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */