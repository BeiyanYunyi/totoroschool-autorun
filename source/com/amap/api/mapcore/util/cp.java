package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

public class cp
  implements Runnable
{
  private Context a;
  private co b;
  private cv c;
  private a d;
  
  public cp(Context paramContext)
  {
    this.a = paramContext;
    if (this.b == null) {
      this.b = new co(this.a, "");
    }
  }
  
  private String a(Context paramContext)
  {
    return FileUtil.getMapBaseStorage(paramContext);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    FileUtil.writeDatasToFile(paramString, paramArrayOfByte);
  }
  
  public void a()
  {
    this.a = null;
    if (this.b != null) {
      this.b = null;
    }
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(cv paramcv)
  {
    this.c = paramcv;
  }
  
  public void a(String paramString)
  {
    if (this.b != null) {
      this.b.a(paramString);
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
      if (this.b != null)
      {
        co.a locala = (co.a)this.b.a();
        StringBuilder localStringBuilder = null;
        Object localObject = localStringBuilder;
        if (locala != null)
        {
          localObject = localStringBuilder;
          if (locala.a != null)
          {
            localObject = a(this.a);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("/");
            localStringBuilder.append("custom_texture_data");
            localObject = localStringBuilder.toString();
            a((String)localObject, locala.a);
          }
        }
        if (this.d != null) {
          this.d.a((String)localObject, this.c);
        }
      }
      gk.a(this.a, dx.e());
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "CustomStyleTask", "download customStyle");
      localThrowable.printStackTrace();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, cv paramcv);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */