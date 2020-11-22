package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;

public class cn
  implements Runnable
{
  private Context a;
  private IAMapDelegate b;
  private cm c;
  private a d;
  private int e;
  
  public cn(Context paramContext, a parama, int paramInt)
  {
    boolean bool = false;
    this.e = 0;
    this.a = paramContext;
    this.d = parama;
    this.e = paramInt;
    if (this.c == null)
    {
      paramContext = this.a;
      if (paramInt == 1) {
        bool = true;
      }
      this.c = new cm(paramContext, "", bool);
    }
  }
  
  public cn(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.e = 0;
    this.a = paramContext;
    this.b = paramIAMapDelegate;
    if (this.c == null) {
      this.c = new cm(this.a, "");
    }
  }
  
  public void a()
  {
    this.a = null;
    if (this.c != null) {
      this.c = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.b(paramString);
    }
  }
  
  public void b()
  {
    dw.a().a(this);
  }
  
  public void run()
  {
    try
    {
      if (!MapsInitializer.getNetWorkEnable()) {
        return;
      }
      if (this.c != null)
      {
        cm.a locala = (cm.a)this.c.a();
        if ((locala != null) && (locala.a != null)) {
          if (this.d != null) {
            this.d.a(locala.a, this.e);
          } else if (this.b != null) {
            this.b.setCustomMapStyle(this.b.getMapConfig().isCustomStyleEnable(), locala.a);
          }
        }
      }
      gk.a(this.a, dx.e());
      if (this.b != null)
      {
        this.b.setRunLowFrame(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "CustomStyleTask", "download customStyle");
      localThrowable.printStackTrace();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */