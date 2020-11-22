package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

public final class cp
  implements SensorEventListener
{
  SensorManager a;
  Sensor b;
  Sensor c;
  Sensor d;
  public boolean e;
  public double f;
  public float g;
  Handler h;
  double i;
  double j;
  double k;
  double l;
  double[] m;
  volatile double n;
  long o;
  long p;
  final int q;
  final int r;
  private Context s;
  private float t;
  private float u;
  
  /* Error */
  public cp(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 46	com/loc/cp:s	Landroid/content/Context;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 50	com/loc/cp:b	Landroid/hardware/Sensor;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 52	com/loc/cp:c	Landroid/hardware/Sensor;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 54	com/loc/cp:d	Landroid/hardware/Sensor;
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 56	com/loc/cp:e	Z
    //   34: aload_0
    //   35: dconst_0
    //   36: putfield 58	com/loc/cp:f	D
    //   39: aload_0
    //   40: fconst_0
    //   41: putfield 60	com/loc/cp:g	F
    //   44: aload_0
    //   45: ldc 61
    //   47: putfield 63	com/loc/cp:t	F
    //   50: aload_0
    //   51: fconst_0
    //   52: putfield 65	com/loc/cp:u	F
    //   55: aload_0
    //   56: new 67	android/os/Handler
    //   59: dup
    //   60: invokespecial 68	android/os/Handler:<init>	()V
    //   63: putfield 70	com/loc/cp:h	Landroid/os/Handler;
    //   66: aload_0
    //   67: dconst_0
    //   68: putfield 72	com/loc/cp:i	D
    //   71: aload_0
    //   72: dconst_0
    //   73: putfield 74	com/loc/cp:j	D
    //   76: aload_0
    //   77: dconst_0
    //   78: putfield 76	com/loc/cp:k	D
    //   81: aload_0
    //   82: dconst_0
    //   83: putfield 78	com/loc/cp:l	D
    //   86: aload_0
    //   87: iconst_3
    //   88: newarray <illegal type>
    //   90: putfield 80	com/loc/cp:m	[D
    //   93: aload_0
    //   94: dconst_0
    //   95: putfield 82	com/loc/cp:n	D
    //   98: aload_0
    //   99: lconst_0
    //   100: putfield 84	com/loc/cp:o	J
    //   103: aload_0
    //   104: lconst_0
    //   105: putfield 86	com/loc/cp:p	J
    //   108: aload_0
    //   109: bipush 100
    //   111: putfield 88	com/loc/cp:q	I
    //   114: aload_0
    //   115: bipush 30
    //   117: putfield 90	com/loc/cp:r	I
    //   120: aload_0
    //   121: aload_1
    //   122: putfield 46	com/loc/cp:s	Landroid/content/Context;
    //   125: aload_0
    //   126: getfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   129: ifnonnull +19 -> 148
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 46	com/loc/cp:s	Landroid/content/Context;
    //   137: ldc 92
    //   139: invokevirtual 98	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   142: checkcast 100	android/hardware/SensorManager
    //   145: putfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   153: bipush 6
    //   155: invokevirtual 104	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   158: putfield 50	com/loc/cp:b	Landroid/hardware/Sensor;
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   166: bipush 11
    //   168: invokevirtual 104	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   171: putfield 52	com/loc/cp:c	Landroid/hardware/Sensor;
    //   174: aload_0
    //   175: aload_0
    //   176: getfield 48	com/loc/cp:a	Landroid/hardware/SensorManager;
    //   179: iconst_1
    //   180: invokevirtual 104	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   183: putfield 54	com/loc/cp:d	Landroid/hardware/Sensor;
    //   186: return
    //   187: astore_1
    //   188: aload_1
    //   189: ldc 106
    //   191: ldc 107
    //   193: invokestatic 112	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   196: return
    //   197: astore_1
    //   198: goto -37 -> 161
    //   201: astore_1
    //   202: goto -28 -> 174
    //   205: astore_1
    //   206: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	cp
    //   0	207	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   120	148	187	java/lang/Throwable
    //   148	161	197	java/lang/Throwable
    //   161	174	201	java/lang/Throwable
    //   174	186	205	java/lang/Throwable
  }
  
  public final void a()
  {
    if ((this.a != null) && (!this.e))
    {
      this.e = true;
      try
      {
        if (this.b != null) {
          this.a.registerListener(this, this.b, 3, this.h);
        }
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "AMapSensorManager", "registerListener mPressure");
      }
      try
      {
        if (this.c != null) {
          this.a.registerListener(this, this.c, 3, this.h);
        }
      }
      catch (Throwable localThrowable2)
      {
        dg.a(localThrowable2, "AMapSensorManager", "registerListener mRotationVector");
      }
      try
      {
        if (this.d != null) {
          this.a.registerListener(this, this.d, 3, this.h);
        }
        return;
      }
      catch (Throwable localThrowable3)
      {
        dg.a(localThrowable3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
      }
    }
  }
  
  public final void b()
  {
    if ((this.a != null) && (this.e)) {
      this.e = false;
    }
    try
    {
      if (this.b != null) {
        this.a.unregisterListener(this, this.b);
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          if (this.c != null) {
            this.a.unregisterListener(this, this.c);
          }
          try
          {
            if (this.d != null) {
              this.a.unregisterListener(this, this.d);
            }
            return;
          }
          catch (Throwable localThrowable3) {}
          localThrowable1 = localThrowable1;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  public final float c()
  {
    return this.u;
  }
  
  public final double d()
  {
    return this.l;
  }
  
  public final void e()
  {
    try
    {
      b();
      this.b = null;
      this.c = null;
      this.a = null;
      this.d = null;
      this.e = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapSensorManager", "destroy");
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent == null) {
      return;
    }
    for (;;)
    {
      float f1;
      try
      {
        int i1 = paramSensorEvent.sensor.getType();
        if (i1 != 1) {
          if (i1 != 6) {
            if (i1 != 11) {
              return;
            }
          }
        }
      }
      catch (Throwable paramSensorEvent)
      {
        Object localObject2;
        double d2;
        long l1;
        return;
      }
      try
      {
        if (this.c != null)
        {
          localObject2 = (float[])paramSensorEvent.values.clone();
          if (localObject2 != null)
          {
            paramSensorEvent = new float[9];
            SensorManager.getRotationMatrixFromVector(paramSensorEvent, (float[])localObject2);
            localObject2 = new float[3];
            SensorManager.getOrientation(paramSensorEvent, (float[])localObject2);
            this.u = ((float)Math.toDegrees(localObject2[0]));
            if (this.u > 0.0F)
            {
              f1 = this.u;
              break label553;
            }
            f1 = this.u + 360.0F;
            break label553;
            Object localObject1;
            this.u = ((float)Math.floor(localObject1));
          }
        }
        return;
      }
      catch (Throwable paramSensorEvent)
      {
        return;
      }
      try
      {
        if (this.b != null)
        {
          paramSensorEvent = (float[])paramSensorEvent.values.clone();
          if (paramSensorEvent != null) {
            this.g = paramSensorEvent[0];
          }
          if (paramSensorEvent != null) {
            this.f = dn.a(SensorManager.getAltitude(this.t, paramSensorEvent[0]));
          }
        }
        return;
      }
      catch (Throwable paramSensorEvent)
      {
        return;
      }
      if (this.d != null)
      {
        paramSensorEvent = (float[])paramSensorEvent.values.clone();
        localObject2 = this.m;
        d1 = this.m[0];
        f1 = paramSensorEvent[0];
        d2 = f1 * 0.19999999F;
        Double.isNaN(d2);
        localObject2[0] = (d1 * 0.800000011920929D + d2);
        localObject2 = this.m;
        d1 = this.m[1];
        f1 = paramSensorEvent[1];
        d2 = f1 * 0.19999999F;
        Double.isNaN(d2);
        localObject2[1] = (d1 * 0.800000011920929D + d2);
        localObject2 = this.m;
        d1 = this.m[2];
        f1 = paramSensorEvent[2];
        d2 = f1 * 0.19999999F;
        Double.isNaN(d2);
        localObject2[2] = (d1 * 0.800000011920929D + d2);
        d1 = paramSensorEvent[0];
        d2 = this.m[0];
        Double.isNaN(d1);
        this.i = (d1 - d2);
        d1 = paramSensorEvent[1];
        d2 = this.m[1];
        Double.isNaN(d1);
        this.j = (d1 - d2);
        d1 = paramSensorEvent[2];
        d2 = this.m[2];
        Double.isNaN(d1);
        this.k = (d1 - d2);
        l1 = System.currentTimeMillis();
        if (l1 - this.o >= 100L)
        {
          d1 = Math.sqrt(this.i * this.i + this.j * this.j + this.k * this.k);
          this.p += 1L;
          this.o = l1;
          this.n += d1;
          if (this.p >= 30L)
          {
            d1 = this.n;
            l1 = this.p;
            d2 = l1;
            Double.isNaN(d2);
            d1 /= d2;
            this.l = d1;
            this.n = 0.0D;
            this.p = 0L;
          }
        }
      }
      return;
      label553:
      double d1 = f1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */