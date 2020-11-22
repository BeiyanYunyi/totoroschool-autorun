package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.AMap;
import java.io.IOException;

public class aj
  extends jf
  implements ay.a
{
  private ay a;
  private bb b;
  private be c;
  private Context e;
  private Bundle f = new Bundle();
  private boolean g = false;
  
  public aj(be parambe, Context paramContext)
  {
    this.c = parambe;
    this.e = paramContext;
  }
  
  public aj(be parambe, Context paramContext, AMap paramAMap)
  {
    this(parambe, paramContext);
  }
  
  private String d()
  {
    return dx.c(this.e);
  }
  
  private void e()
    throws IOException
  {
    String str = this.c.A();
    this.a = new ay(new ba(this.c.getUrl(), d(), this.c.z(), 1, str), this.c.getUrl(), this.e, this.c);
    this.a.a(this);
    this.b = new bb(this.c, this.c);
    if (!this.g) {
      this.a.a();
    }
  }
  
  public void a()
  {
    this.g = true;
    if (this.a != null) {
      this.a.b();
    } else {
      cancelTask();
    }
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void b()
  {
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public void runTask()
  {
    if (this.c.y())
    {
      this.c.a(bg.a.c);
      return;
    }
    try
    {
      e();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */