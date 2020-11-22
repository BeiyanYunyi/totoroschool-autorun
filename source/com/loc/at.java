package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;

public final class at
  implements bl.a
{
  protected au a;
  protected v b;
  protected String c;
  protected RandomAccessFile d;
  protected Context e;
  private bl f;
  
  public at(Context paramContext, au paramau, v paramv)
  {
    try
    {
      this.e = paramContext.getApplicationContext();
      this.b = paramv;
      if (paramau == null) {
        return;
      }
      this.a = paramau;
      this.f = new bl(new bd(this.a));
      this.c = av.a(paramContext, this.a.b);
      return;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "dDownLoad", "DexDownLoad()");
    }
  }
  
  public final void a()
  {
    try
    {
      ba.b().a().submit(new a());
      return;
    }
    catch (Throwable localThrowable)
    {
      ag.a(localThrowable, "dDownLoad", "startDownload()");
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong)
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
      ag.a(paramArrayOfByte, "dDownLoad", "onDownload()");
    }
  }
  
  public final void b()
  {
    try
    {
      if (this.d == null) {
        return;
      }
      bb.a(this.d);
      Object localObject = this.a.b();
      if (bb.a(this.c, (String)localObject))
      {
        String str = this.a.d;
        an localan = new an(this.e, ax.b());
        localan.a(new ay.a(this.a.b, (String)localObject, this.a.c, str, this.a.e).a("copy").a(), ay.a(this.a.b, this.a.c, str, this.a.e));
        localObject = this.e;
        str = this.a.c;
        try
        {
          localObject = ((Context)localObject).getSharedPreferences(str, 0).edit();
          ((SharedPreferences.Editor)localObject).clear();
          ((SharedPreferences.Editor)localObject).commit();
        }
        catch (Throwable localThrowable4)
        {
          ag.a(localThrowable4, "dDownLoad", "clearMarker()");
        }
        try
        {
          ba.b().a().submit(new a(localan));
        }
        catch (Throwable localThrowable1)
        {
          ag.a(localThrowable1, "dDownLoad", "onFinish1");
        }
        bu localbu = new bu(this.e, this.b.a(), this.b.b(), "O008");
        localbu.a("{\"param_int_first\":1}");
        bv.a(localbu, this.e);
        return;
      }
      try
      {
        new File(this.c).delete();
        return;
      }
      catch (Throwable localThrowable2)
      {
        ag.a(localThrowable2, "dDownLoad", "onFinish");
        return;
      }
      return;
    }
    catch (Throwable localThrowable3)
    {
      ag.a(localThrowable3, "dDownLoad", "onFinish()");
    }
  }
  
  public final void c() {}
  
  public final void d()
  {
    try
    {
      bb.a(this.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  final boolean e()
  {
    boolean bool;
    if ((this.a != null) && (this.a.c())) {
      bool = true;
    } else {
      bool = false;
    }
    for (;;)
    {
      try
      {
        if ((!w.b(this.e)) && (bb.a(this.b, this.a)) && (bb.a(this.a)) && (bb.a(this.e, bool)) && (!bb.a(this.e, this.a, this.b)))
        {
          Context localContext = this.e;
          au localau = this.a;
          if (localau.d()) {
            break label158;
          }
          if (w.a(localContext, localau.e())) {
            break label163;
          }
          break label158;
          if (i != 0)
          {
            av.b(this.e, this.b.a());
            return true;
          }
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        ag.a(localThrowable, "dDownLoad", "isNeedDownload()");
        return false;
      }
      label158:
      int i = 1;
      continue;
      label163:
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private int b;
    private an c;
    private String d;
    
    a()
    {
      this.b = 0;
    }
    
    a(an paraman)
    {
      this.b = 2;
      this.c = paraman;
    }
    
    public final void run()
    {
      String str;
      switch (this.b)
      {
      default: 
        return;
      case 3: 
        try
        {
          av.a(at.this.e, this.c, at.this.b, at.this.c, this.d);
          av.a(at.this.e, at.this.b);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ag.a(localThrowable1, "dDownLoad", "processDownloadedFile()");
          return;
        }
      case 1: 
      case 2: 
        try
        {
          av.a(at.this.e, this.c, at.this.b, at.this.c, at.this.a.e);
          av.a(at.this.e, at.this.b);
          return;
        }
        catch (Throwable localThrowable2)
        {
          str = "onFinish2";
        }
      }
      for (;;)
      {
        ag.a(localThrowable2, "dDownLoad", str);
        return;
        try
        {
          if (at.this.e())
          {
            bu localbu = new bu(at.this.e, at.this.b.a(), at.this.b.b(), "O008");
            localbu.a("{\"param_int_first\":0}");
            bv.a(localbu, at.this.e);
            at.a(at.this).a(at.this);
          }
          return;
        }
        catch (Throwable localThrowable3)
        {
          str = "run()";
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */