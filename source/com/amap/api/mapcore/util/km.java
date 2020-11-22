package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

public class km
  implements hz.a
{
  a a;
  private final Context b;
  private RandomAccessFile c;
  private if d;
  private String e;
  
  public km(Context paramContext, a parama, fv paramfv)
  {
    this.b = paramContext.getApplicationContext();
    if (parama == null) {
      return;
    }
    this.a = parama;
    this.d = new if(new b(parama));
    this.e = parama.c();
  }
  
  private boolean b()
  {
    c localc = this.a.e();
    return (localc == null) || (!localc.c()) || (!dn.a(this.b, localc.a(), localc.b(), "").equalsIgnoreCase(this.a.b()));
  }
  
  public void a()
  {
    try
    {
      if ((b()) && (this.d != null))
      {
        this.d.a(this);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "AuthTaskDownload", "startDownload()");
    }
  }
  
  public void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.c == null)
      {
        File localFile1 = new File(this.e);
        File localFile2 = localFile1.getParentFile();
        if (!localFile2.exists()) {
          localFile2.mkdirs();
        }
        this.c = new RandomAccessFile(localFile1, "rw");
      }
      this.c.seek(paramLong);
      this.c.write(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      gk.c(paramArrayOfByte, "AuthTaskDownload", "onDownload()");
    }
  }
  
  public void onException(Throwable paramThrowable)
  {
    try
    {
      if (this.c == null) {
        return;
      }
      this.c.close();
      return;
    }
    catch (Throwable paramThrowable)
    {
      gk.c(paramThrowable, "AuthTaskDownload", "onException()");
    }
  }
  
  public void onFinish()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = this.c;
      if (localRandomAccessFile == null) {
        return;
      }
      try
      {
        this.c.close();
      }
      catch (Throwable localThrowable1)
      {
        gk.c(localThrowable1, "AuthTaskDownload", "onFinish3");
      }
      Object localObject = this.a.b();
      String str = fs.a(this.e);
      if ((str != null) && (((String)localObject).equalsIgnoreCase(str)))
      {
        localObject = this.a.d();
        try
        {
          av localav = new av();
          File localFile = new File(this.e);
          long l = bc.a(localFile);
          localav.a(localFile, new File((String)localObject), -1L, l, null);
          localObject = this.a.e();
          if ((localObject != null) && (((c)localObject).c())) {
            dn.a(this.b, ((c)localObject).a(), ((c)localObject).b(), str);
          }
          new File(this.e).delete();
          return;
        }
        catch (Throwable localThrowable2)
        {
          gk.c(localThrowable2, "AuthTaskDownload", "onFinish1");
          return;
        }
      }
      try
      {
        new File(this.e).delete();
        return;
      }
      catch (Throwable localThrowable3)
      {
        gk.c(localThrowable3, "AuthTaskDownload", "onFinish");
        return;
      }
      return;
    }
    catch (Throwable localThrowable4)
    {
      gk.c(localThrowable4, "AuthTaskDownload", "onFinish()");
    }
  }
  
  public void onStop() {}
  
  static class a
  {
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected km.c e;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(".tmp");
      this.c = paramString1.toString();
      this.d = paramString3;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public void a(km.c paramc)
    {
      this.e = paramc;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public String c()
    {
      return this.c;
    }
    
    public String d()
    {
      return this.d;
    }
    
    public km.c e()
    {
      return this.e;
    }
  }
  
  static class b
    extends cw
  {
    private final km.a d;
    
    b(km.a parama)
    {
      this.d = parama;
    }
    
    public Map<String, String> getParams()
    {
      return null;
    }
    
    public Map<String, String> getRequestHead()
    {
      return null;
    }
    
    public String getURL()
    {
      if (this.d != null) {
        return this.d.a();
      }
      return null;
    }
  }
  
  static class c
  {
    protected String a;
    protected String b;
    
    public c(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public boolean c()
    {
      return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
    }
  }
  
  static class d
    extends km.a
  {
    public d(String paramString1, String paramString2, String paramString3)
    {
      super(paramString2, paramString3);
    }
    
    public void a(String paramString1, String paramString2)
    {
      a(new km.c(paramString1, paramString2));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\km.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */