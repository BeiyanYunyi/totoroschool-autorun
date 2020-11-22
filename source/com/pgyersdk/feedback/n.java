package com.pgyersdk.feedback;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.pgyersdk.c.b;
import com.pgyersdk.f.f;

public class n
  implements SensorListener
{
  public static int a = 950;
  private int b = 110;
  private int c = 500;
  private int d = 1000;
  private int e = 4;
  private SensorManager f;
  private float g = -1.0F;
  private float h = -1.0F;
  private float i = -1.0F;
  private long j;
  private a k;
  private Context l;
  private int m = 0;
  private long n;
  private long o;
  
  public n(Context paramContext)
  {
    this.l = paramContext;
    a();
  }
  
  public void a()
  {
    if (this.f == null)
    {
      this.f = ((SensorManager)this.l.getSystemService("sensor"));
      if (this.f == null) {
        f.a("PgyerSDK", b.a(1060));
      }
      if (!this.f.registerListener(this, 2, 1))
      {
        this.f.unregisterListener(this, 2);
        f.a("PgyerSDK", b.a(1060));
      }
    }
  }
  
  public void a(a parama)
  {
    this.k = parama;
  }
  
  public void b()
  {
    SensorManager localSensorManager = this.f;
    if (localSensorManager != null)
    {
      localSensorManager.unregisterListener(this, 2);
      this.f = null;
    }
  }
  
  public void onAccuracyChanged(int paramInt1, int paramInt2) {}
  
  public void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
  {
    if (paramInt != 2) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.o > this.c) {
      this.m = 0;
    }
    long l2 = l1 - this.j;
    if (l2 > this.b)
    {
      if (Math.abs(paramArrayOfFloat[0] + paramArrayOfFloat[1] + paramArrayOfFloat[2] - this.g - this.h - this.i) / (float)l2 * 10000.0F > a)
      {
        paramInt = this.m + 1;
        this.m = paramInt;
        if ((paramInt >= this.e) && (l1 - this.n > this.d))
        {
          this.n = l1;
          this.m = 0;
          a locala = this.k;
          if (locala != null) {
            try
            {
              locala.a();
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
            }
          }
        }
        this.o = l1;
      }
      this.j = l1;
      this.g = paramArrayOfFloat[0];
      this.h = paramArrayOfFloat[1];
      this.i = paramArrayOfFloat[2];
    }
  }
  
  public static abstract interface a
  {
    public abstract void a()
      throws IllegalAccessException;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */