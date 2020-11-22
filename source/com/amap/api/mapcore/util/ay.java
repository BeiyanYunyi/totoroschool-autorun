package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ay
  implements hz.a
{
  ba a = null;
  long b = 0L;
  long c = 0L;
  long d;
  boolean e = true;
  at f;
  long g = 0L;
  a h;
  private Context i;
  private bg j;
  private String k;
  private if l;
  private au m;
  private boolean n = false;
  
  public ay(ba paramba, String paramString, Context paramContext, bg parambg)
    throws IOException
  {
    this.f = at.a(paramContext.getApplicationContext());
    this.a = paramba;
    this.i = paramContext;
    this.k = paramString;
    this.j = parambg;
    d();
  }
  
  private void a(long paramLong)
  {
    if ((this.d > 0L) && (this.j != null))
    {
      this.j.a(this.d, paramLong);
      this.g = System.currentTimeMillis();
    }
  }
  
  private void c()
    throws IOException
  {
    Object localObject = new bh(this.k);
    ((bh)localObject).setConnectionTimeout(1800000);
    ((bh)localObject).setSoTimeout(1800000);
    long l1 = this.b;
    long l2 = this.c;
    boolean bool;
    if (MapsInitializer.getProtocol() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.l = new if((ic)localObject, l1, l2, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.b());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.a.c());
    this.m = new au(((StringBuilder)localObject).toString(), this.b);
  }
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.b());
    ((StringBuilder)localObject).append(this.a.c());
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      this.e = false;
      this.b = ((File)localObject).length();
    }
    try
    {
      this.d = g();
      this.c = this.d;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    if (this.j != null)
    {
      this.j.a(bg.a.c);
      return;
      this.b = 0L;
      this.c = 0L;
    }
  }
  
  private boolean e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.b());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.a.c());
    return new File(localStringBuilder.toString()).length() >= 10L;
  }
  
  private void f()
    throws AMapException
  {
    if (fm.a != 1)
    {
      int i1 = 0;
      while (i1 < 3) {
        try
        {
          boolean bool = fm.a(this.i, dx.e());
          if (bool) {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "SiteFileFetch", "authOffLineDownLoad");
          localThrowable.printStackTrace();
          i1 += 1;
        }
      }
    }
  }
  
  private long g()
    throws IOException
  {
    Object localObject3 = this.a.a();
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = ib.b();
        localObject3 = new b((String)localObject3);
        if (MapsInitializer.getProtocol() != 2) {
          break label139;
        }
        bool = true;
        localObject1 = ((ib)localObject1).b((ic)localObject3, bool);
      }
      catch (fj localfj)
      {
        localfj.printStackTrace();
        localObject2 = null;
      }
      int i1 = -1;
      int i2 = i1;
      if (localObject2 != null)
      {
        localObject3 = ((Map)localObject2).keySet().iterator();
        for (;;)
        {
          i2 = i1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          String str = (String)((Iterator)localObject3).next();
          if ("Content-Length".equalsIgnoreCase(str)) {
            i1 = Integer.parseInt((String)((Map)localObject2).get(str));
          }
        }
      }
      return i2;
      label139:
      boolean bool = false;
    }
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    if ((this.a != null) && (l1 - this.g > 'Ǵ'))
    {
      i();
      this.g = l1;
      a(this.b);
    }
  }
  
  private void i()
  {
    this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
  }
  
  public void a()
  {
    try
    {
      if (dx.d(this.i))
      {
        f();
        if (fm.a != 1)
        {
          if (this.j == null) {
            return;
          }
          this.j.a(bg.a.a);
          return;
        }
        if (!e()) {
          this.e = true;
        }
        if (this.e)
        {
          this.d = g();
          if (this.d == -1L) {
            bc.a("File Length is not known!");
          } else if (this.d == -2) {
            bc.a("File is not access!");
          } else {
            this.c = this.d;
          }
          this.b = 0L;
        }
        if (this.j != null) {
          this.j.n();
        }
        if (this.b >= this.c)
        {
          onFinish();
          return;
        }
        c();
        this.l.a(this);
        return;
      }
      if (this.j != null) {
        this.j.a(bg.a.b);
      }
      return;
    }
    catch (AMapException localAMapException)
    {
      gk.c(localAMapException, "SiteFileFetch", "download");
      if (this.j == null) {
        break label236;
      }
      this.j.a(bg.a.a);
      return;
    }
    catch (IOException localIOException)
    {
      label236:
      for (;;) {}
    }
    if (this.j != null)
    {
      this.j.a(bg.a.c);
      return;
    }
  }
  
  public void a(a parama)
  {
    this.h = parama;
  }
  
  public void b()
  {
    if (this.l != null) {
      this.l.a();
    }
  }
  
  public void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      this.m.a(paramArrayOfByte);
      this.b = paramLong;
      h();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      gk.c(paramArrayOfByte, "fileAccessI", "fileAccessI.write(byte[] data)");
      if (this.j != null) {
        this.j.a(bg.a.c);
      }
      if (this.l != null) {
        this.l.a();
      }
    }
  }
  
  public void onException(Throwable paramThrowable)
  {
    this.n = true;
    b();
    if (this.j != null) {
      this.j.a(bg.a.b);
    }
    if ((paramThrowable instanceof IOException)) {
      return;
    }
    if (this.m != null) {
      this.m.a();
    }
  }
  
  public void onFinish()
  {
    h();
    if (this.j != null) {
      this.j.o();
    }
    if (this.m != null) {
      this.m.a();
    }
    if (this.h != null) {
      this.h.c();
    }
  }
  
  public void onStop()
  {
    if (this.n) {
      return;
    }
    if (this.j != null) {
      this.j.p();
    }
    i();
  }
  
  public static abstract interface a
  {
    public abstract void c();
  }
  
  private static class b
    extends cw
  {
    private final String d;
    
    public b(String paramString)
    {
      this.d = paramString;
    }
    
    public String getURL()
    {
      return this.d;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */