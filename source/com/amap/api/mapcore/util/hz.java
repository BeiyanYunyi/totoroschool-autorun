package com.amap.api.mapcore.util;

public class hz
{
  private ia a;
  private ic b;
  
  public hz(ic paramic)
  {
    this(paramic, 0L, -1L);
  }
  
  public hz(ic paramic, long paramLong1, long paramLong2)
  {
    this(paramic, paramLong1, paramLong2, false);
  }
  
  public hz(ic paramic, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.b = paramic;
    if (paramic.c == null) {
      paramic = null;
    } else {
      paramic = paramic.c;
    }
    this.a = new ia(this.b.a, this.b.b, paramic, paramBoolean);
    this.a.b(paramLong2);
    this.a.a(paramLong1);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(a parama)
  {
    this.a.a(this.b.getURL(), this.b.isIPRequest(), this.b.getIPDNSName(), this.b.getRequestHead(), this.b.getParams(), this.b.getEntityBytes(), parama);
  }
  
  public static abstract interface a
  {
    public abstract void onDownload(byte[] paramArrayOfByte, long paramLong);
    
    public abstract void onException(Throwable paramThrowable);
    
    public abstract void onFinish();
    
    public abstract void onStop();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */