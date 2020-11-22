package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;

public class gu
  implements hz.a
{
  protected gv a;
  protected fv b;
  protected String c;
  protected RandomAccessFile d;
  protected Context e;
  private hz f;
  
  public gu(Context paramContext, gv paramgv, fv paramfv)
  {
    try
    {
      this.e = paramContext.getApplicationContext();
      this.b = paramfv;
      if (paramgv == null) {
        return;
      }
      this.a = paramgv;
      this.f = new hz(new hg(this.a));
      this.c = gw.a(paramContext, this.a.b);
      return;
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "dDownLoad", "DexDownLoad()");
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
      paramContext.clear();
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "dDownLoad", "clearMarker()");
    }
  }
  
  private void a(String paramString)
  {
    String str = this.a.c();
    go localgo = new go(this.e, gy.a());
    gw.a.a(localgo, new gz.a(this.a.b, paramString, this.a.c, str, this.a.e).a("copy").a(), gz.a(this.a.b, this.a.c, str, this.a.e));
    a(this.e, this.a.c);
    try
    {
      hb.b().a().submit(new a(localgo, 2));
      return;
    }
    catch (Throwable paramString)
    {
      hd.a(paramString, "dDownLoad", "onFinish1");
    }
  }
  
  public void a()
  {
    try
    {
      hb.b().a().submit(new a(0));
      return;
    }
    catch (Throwable localThrowable)
    {
      hd.a(localThrowable, "dDownLoad", "startDownload()");
    }
  }
  
  boolean b()
  {
    boolean bool;
    if ((this.a != null) && (this.a.d())) {
      bool = true;
    } else {
      bool = false;
    }
    for (;;)
    {
      try
      {
        if ((!c()) && (fw.b(this.e)))
        {
          i = 1;
          if ((i == 0) && (hd.a(this.b, this.a)) && (hd.a(this.a)) && (hd.a(this.e, bool)) && (!hd.a(this.e, this.a, this.b)) && (hd.a(this.e, this.b, this.a)))
          {
            gw.b(this.e, this.b.a());
            return true;
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        hd.a(localThrowable, "dDownLoad", "isNeedDownload()");
        return false;
      }
      int i = 0;
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.d == null)
      {
        File localFile1 = new File(this.c);
        File localFile2 = localFile1.getParentFile();
        if (!localFile2.exists()) {
          localFile2.mkdirs();
        }
        this.d = new RandomAccessFile(localFile1, "rw");
      }
      this.d.seek(paramLong);
      this.d.write(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      hd.a(paramArrayOfByte, "dDownLoad", "onDownload()");
    }
  }
  
  public void onException(Throwable paramThrowable)
  {
    try
    {
      hd.a(this.d);
      return;
    }
    catch (Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  public void onFinish()
  {
    try
    {
      if (this.d == null) {
        return;
      }
      hd.a(this.d);
      Object localObject = this.a.b();
      if (hd.b(this.c, (String)localObject))
      {
        a((String)localObject);
        localObject = new in(this.e, this.b.a(), this.b.b(), "O008");
        ((in)localObject).a("{\"param_int_first\":1}");
        io.a((in)localObject, this.e);
        return;
      }
      try
      {
        new File(this.c).delete();
        return;
      }
      catch (Throwable localThrowable1)
      {
        hd.a(localThrowable1, "dDownLoad", "onFinish");
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      hd.a(localThrowable2, "dDownLoad", "onFinish()");
    }
  }
  
  public void onStop() {}
  
  class a
    implements Runnable
  {
    private int b;
    private go c;
    private String d;
    
    a(int paramInt)
    {
      this.b = paramInt;
    }
    
    a(go paramgo, int paramInt)
    {
      this.b = paramInt;
      this.c = paramgo;
    }
    
    public void run()
    {
      switch (this.b)
      {
      default: 
        return;
      case 3: 
        try
        {
          gw.a(gu.this.e, this.c, gu.this.b, gu.this.c, this.d);
          gw.a(gu.this.e, gu.this.b);
          return;
        }
        catch (Throwable localThrowable1)
        {
          hd.a(localThrowable1, "dDownLoad", "processDownloadedFile()");
          return;
        }
      case 1: 
      case 2: 
        try
        {
          gw.a(gu.this.e, this.c, gu.this.b, gu.this.c, gu.this.a.e);
          gw.a(gu.this.e, gu.this.b);
          return;
        }
        catch (Throwable localThrowable2)
        {
          hd.a(localThrowable2, "dDownLoad", "onFinish2");
          return;
        }
      }
      try
      {
        if (gu.this.b())
        {
          in localin = new in(gu.this.e, gu.this.b.a(), gu.this.b.b(), "O008");
          localin.a("{\"param_int_first\":0}");
          io.a(localin, gu.this.e);
          gu.a(gu.this).a(gu.this);
          return;
        }
      }
      catch (Throwable localThrowable3)
      {
        hd.a(localThrowable3, "dDownLoad", "run()");
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */