package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class b
  implements SensorEventListener
{
  private SensorManager a;
  private Sensor b;
  private long c = 0L;
  private float d;
  private Context e;
  private IAMapDelegate f;
  private Marker g;
  private boolean h = true;
  
  public b(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.e = paramContext.getApplicationContext();
    this.f = paramIAMapDelegate;
    try
    {
      this.a = ((SensorManager)paramContext.getSystemService("sensor"));
      if (this.a != null)
      {
        this.b = this.a.getDefaultSensor(3);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext != null)
      {
        switch (paramContext.getDefaultDisplay().getRotation())
        {
        default: 
          return 0;
        case 3: 
          return -90;
        case 2: 
          return 180;
        case 1: 
          return 90;
        }
        return 0;
      }
    }
    return 0;
  }
  
  public void a()
  {
    if ((this.a != null) && (this.b != null)) {
      this.a.registerListener(this, this.b, 3);
    }
  }
  
  public void a(Marker paramMarker)
  {
    this.g = paramMarker;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b()
  {
    if ((this.a != null) && (this.b != null)) {
      this.a.unregisterListener(this, this.b);
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    for (;;)
    {
      float f2;
      try
      {
        if (System.currentTimeMillis() - this.c < 100L) {
          return;
        }
        if ((this.f.getGLMapEngine() != null) && (this.f.getGLMapEngine().getAnimateionsCount() > 0)) {
          return;
        }
        if (paramSensorEvent.sensor.getType() != 3) {
          return;
        }
        f2 = (paramSensorEvent.values[0] + a(this.e)) % 360.0F;
        if (f2 > 180.0F)
        {
          f1 = f2 - 360.0F;
          if (Math.abs(this.d - f1) < 3.0F) {
            return;
          }
          f2 = f1;
          if (Float.isNaN(f1)) {
            f2 = 0.0F;
          }
          this.d = f2;
          paramSensorEvent = this.g;
          if (paramSensorEvent != null) {
            try
            {
              if (this.h)
              {
                this.f.moveCamera(k.d(this.d));
                this.g.setRotateAngle(-this.d);
              }
              else
              {
                this.g.setRotateAngle(360.0F - this.d);
              }
            }
            catch (Throwable paramSensorEvent)
            {
              paramSensorEvent.printStackTrace();
            }
          }
          this.c = System.currentTimeMillis();
          return;
        }
      }
      catch (Throwable paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
        return;
      }
      float f1 = f2;
      if (f2 < -180.0F) {
        f1 = f2 + 360.0F;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */