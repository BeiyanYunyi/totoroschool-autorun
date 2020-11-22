package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public final class jr
  extends gu
{
  private jm f;
  private hl g;
  private jn h;
  private jk i;
  private ji j;
  private boolean k;
  
  public jr(Context paramContext, gv paramgv, hl paramhl, fv paramfv)
  {
    super(paramContext, paramgv, paramfv);
    this.g = paramhl;
    this.f = new jm(paramContext, paramfv);
    this.c = this.f.j();
    this.h = new jn(this.e, paramfv);
    this.i = new jk(this.e, paramfv);
    this.j = new ji(this.e, paramfv);
  }
  
  private static boolean a(Context paramContext, fv paramfv)
  {
    Object localObject = hp.a(paramContext, paramfv, "ldtk");
    try
    {
      l = Long.parseLong((String)localObject);
    }
    catch (Throwable localThrowable)
    {
      long l;
      for (;;) {}
    }
    l = -1L;
    if ((l >= 0L) && (System.currentTimeMillis() - l <= 43200000L)) {
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    hp.a(paramContext, paramfv, "ldtk", ((StringBuilder)localObject).toString());
    return true;
  }
  
  public static boolean a(fv paramfv)
  {
    if (paramfv == null) {
      return false;
    }
    String str = paramfv.b();
    paramfv = paramfv.c();
    if (TextUtils.isEmpty(paramfv)) {
      return true;
    }
    return jh.a(paramfv, str) > 0;
  }
  
  public final void a()
  {
    if (ho.e(this.c))
    {
      onFinish();
      return;
    }
    if (!kf.a(this.e)) {
      return;
    }
    if (!a(this.e, this.b)) {
      return;
    }
    super.a();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  protected final boolean c()
  {
    return this.k;
  }
  
  public final void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    super.onDownload(paramArrayOfByte, paramLong);
  }
  
  public final void onException(Throwable paramThrowable)
  {
    super.onException(paramThrowable);
  }
  
  public final void onFinish()
  {
    try
    {
      if (this.d != null) {
        hd.a(this.d);
      }
      Context localContext = this.e;
      if (localContext != null)
      {
        ke localke = ke.a();
        new jv(localContext, this.b, this.a, localke, this.g, this.f, this.i, this.h, this.j).c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      hd.a(localThrowable, "dDownLoad", "onFinish()");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */