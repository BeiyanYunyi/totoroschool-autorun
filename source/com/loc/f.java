package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public final class f
{
  static boolean g = false;
  private j A = null;
  private boolean B = true;
  private String C = "";
  private final int D = 5000;
  private String E = "jsonp1";
  String a = null;
  b b = null;
  AMapLocation c = null;
  a d = null;
  Context e = null;
  cl f = null;
  HashMap<Messenger, Long> h = new HashMap();
  dk i = null;
  long j = 0L;
  long k = 0L;
  String l = null;
  AMapLocationClientOption m = null;
  AMapLocationClientOption n = new AMapLocationClientOption();
  ServerSocket o = null;
  boolean p = false;
  Socket q = null;
  boolean r = false;
  c s = null;
  private boolean t = false;
  private boolean u = false;
  private long v = 0L;
  private long w = 0L;
  private co x = null;
  private long y = 0L;
  private int z = 0;
  
  public f(Context paramContext)
  {
    this.e = paramContext;
  }
  
  private static co a(int paramInt, String paramString)
  {
    try
    {
      co localco = new co("");
      localco.setErrorCode(paramInt);
      localco.setLocationDetail(paramString);
      return localco;
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "ApsServiceCore", "newInstanceAMapLoc");
    }
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      if (this.t) {
        return;
      }
      dg.a(this.e);
      if (paramBundle != null) {
        this.n = dg.a(paramBundle.getBundle("optBundle"));
      }
      this.f.a(this.e);
      this.f.a();
      a(this.n);
      this.f.b();
      this.t = true;
      this.B = true;
      this.C = "";
      return;
    }
    catch (Throwable paramBundle)
    {
      this.B = false;
      this.C = paramBundle.getMessage();
      dg.a(paramBundle, "ApsServiceCore", "init");
    }
  }
  
  private void a(Messenger paramMessenger)
  {
    try
    {
      cl.b(this.e);
      Bundle localBundle;
      if (df.i())
      {
        localBundle = new Bundle();
        localBundle.putBoolean("ngpsAble", df.k());
        a(paramMessenger, 7, localBundle);
        df.j();
      }
      if (df.q())
      {
        localBundle = new Bundle();
        localBundle.putBoolean("installMockApp", true);
        a(paramMessenger, 9, localBundle);
      }
      return;
    }
    catch (Throwable paramMessenger)
    {
      dg.a(paramMessenger, "ApsServiceCore", "initAuth");
    }
  }
  
  private static void a(Messenger paramMessenger, int paramInt, Bundle paramBundle)
  {
    if (paramMessenger != null) {
      try
      {
        Message localMessage = Message.obtain();
        localMessage.setData(paramBundle);
        localMessage.what = paramInt;
        paramMessenger.send(localMessage);
        return;
      }
      catch (Throwable paramMessenger)
      {
        dg.a(paramMessenger, "ApsServiceCore", "sendMessage");
      }
    }
  }
  
  private void a(Messenger paramMessenger, AMapLocation paramAMapLocation, String paramString, d paramd)
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(AMapLocation.class.getClassLoader());
    localBundle.putParcelable("loc", paramAMapLocation);
    localBundle.putString("nb", paramString);
    localBundle.putParcelable("statics", paramd);
    this.h.put(paramMessenger, Long.valueOf(dn.b()));
    a(paramMessenger, 1, localBundle);
  }
  
  private void a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    try
    {
      if (this.f != null) {
        this.f.a(paramAMapLocationClientOption);
      }
      if (paramAMapLocationClientOption != null)
      {
        g = paramAMapLocationClientOption.isKillProcess();
        if ((this.m != null) && ((paramAMapLocationClientOption.isOffset() != this.m.isOffset()) || (paramAMapLocationClientOption.isNeedAddress() != this.m.isNeedAddress()) || (paramAMapLocationClientOption.isLocationCacheEnable() != this.m.isLocationCacheEnable()) || (this.m.getGeoLanguage() != paramAMapLocationClientOption.getGeoLanguage())))
        {
          this.w = 0L;
          this.c = null;
        }
        this.m = paramAMapLocationClientOption;
      }
      return;
    }
    catch (Throwable paramAMapLocationClientOption)
    {
      dg.a(paramAMapLocationClientOption, "ApsServiceCore", "setExtra");
    }
  }
  
  private void a(BufferedReader paramBufferedReader)
    throws Exception
  {
    paramBufferedReader = paramBufferedReader.readLine();
    int i2 = 30000;
    int i1 = i2;
    if (paramBufferedReader != null)
    {
      i1 = i2;
      if (paramBufferedReader.length() > 0)
      {
        paramBufferedReader = paramBufferedReader.split(" ");
        i1 = i2;
        if (paramBufferedReader != null)
        {
          i1 = i2;
          if (paramBufferedReader.length > 1)
          {
            paramBufferedReader = paramBufferedReader[1].split("\\?");
            i1 = i2;
            if (paramBufferedReader != null)
            {
              i1 = i2;
              if (paramBufferedReader.length > 1)
              {
                paramBufferedReader = paramBufferedReader[1].split("&");
                i1 = i2;
                if (paramBufferedReader != null)
                {
                  i1 = i2;
                  if (paramBufferedReader.length > 0)
                  {
                    i2 = 0;
                    int i3;
                    for (i1 = 30000; i2 < paramBufferedReader.length; i1 = i3)
                    {
                      String[] arrayOfString = paramBufferedReader[i2].split("=");
                      i3 = i1;
                      if (arrayOfString != null)
                      {
                        i3 = i1;
                        if (arrayOfString.length > 1)
                        {
                          if ("to".equals(arrayOfString[0])) {
                            i1 = dn.h(arrayOfString[1]);
                          }
                          i3 = i1;
                          if ("callback".equals(arrayOfString[0]))
                          {
                            this.E = arrayOfString[1];
                            i3 = i1;
                          }
                        }
                      }
                      i2 += 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    dg.f = i1;
  }
  
  private AMapLocationClientOption b(Bundle paramBundle)
  {
    AMapLocationClientOption localAMapLocationClientOption = dg.a(paramBundle.getBundle("optBundle"));
    a(localAMapLocationClientOption);
    try
    {
      paramBundle = paramBundle.getString("d");
      if (!TextUtils.isEmpty(paramBundle))
      {
        p.a(paramBundle);
        return localAMapLocationClientOption;
      }
    }
    catch (Throwable paramBundle)
    {
      try
      {
        dg.a(paramBundle, "APSManager", "doLocation setUmidToken");
        return localAMapLocationClientOption;
      }
      catch (Throwable paramBundle)
      {
        dg.a(paramBundle, "APSManager", "parseBundle");
      }
    }
    return localAMapLocationClientOption;
  }
  
  private void b(String paramString)
    throws UnsupportedEncodingException, IOException
  {
    PrintStream localPrintStream = new PrintStream(this.q.getOutputStream(), true, "UTF-8");
    localPrintStream.println("HTTP/1.0 200 OK");
    StringBuilder localStringBuilder = new StringBuilder("Content-Length:");
    localStringBuilder.append(paramString.getBytes("UTF-8").length);
    localPrintStream.println(localStringBuilder.toString());
    localPrintStream.println();
    localPrintStream.println(paramString);
    localPrintStream.close();
  }
  
  public static void c()
  {
    g = false;
  }
  
  private void d()
  {
    try
    {
      this.d.removeMessages(4);
      if (df.a()) {
        this.d.sendEmptyMessage(4);
      }
      this.d.removeMessages(5);
      if ((df.c()) && (df.d() > 2)) {
        this.d.sendEmptyMessage(5);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ApsServiceCore", "checkConfig");
    }
  }
  
  private String e()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    String str;
    if (dn.e(this.e))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.E);
      ((StringBuilder)localObject).append("&&");
      ((StringBuilder)localObject).append(this.E);
      ((StringBuilder)localObject).append("({'package':'");
      ((StringBuilder)localObject).append(this.a);
      str = "','error_code':36,'error':'app is background'})";
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
      if ((this.x == null) || (l1 - this.x.getTime() > 5000L)) {
        try
        {
          localObject = new d();
          this.x = this.f.a((d)localObject);
        }
        catch (Throwable localThrowable)
        {
          dg.a(localThrowable, "ApsServiceCore", "getSocketLocResult");
        }
      }
      StringBuilder localStringBuilder;
      if (this.x == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.E);
        localStringBuilder.append("&&");
        localStringBuilder.append(this.E);
        localStringBuilder.append("({'package':'");
        localStringBuilder.append(this.a);
        str = "','error_code':8,'error':'unknown error'})";
      }
      else if (this.x.getErrorCode() != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.E);
        localStringBuilder.append("&&");
        localStringBuilder.append(this.E);
        localStringBuilder.append("({'package':'");
        localStringBuilder.append(this.a);
        localStringBuilder.append("','error_code':");
        localStringBuilder.append(this.x.getErrorCode());
        localStringBuilder.append(",'error':'");
        localStringBuilder.append(this.x.getErrorInfo());
        str = "'})";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.E);
        localStringBuilder.append("&&");
        localStringBuilder.append(this.E);
        localStringBuilder.append("({'package':'");
        localStringBuilder.append(this.a);
        localStringBuilder.append("','error_code':0,'error':'','location':{'y':");
        localStringBuilder.append(this.x.getLatitude());
        localStringBuilder.append(",'precision':");
        localStringBuilder.append(this.x.getAccuracy());
        localStringBuilder.append(",'x':");
        localStringBuilder.append(this.x.getLongitude());
        str = "},'version_code':'4.8.0','version':'4.8.0'})";
      }
    }
  }
  
  private void f()
  {
    try
    {
      if (this.f != null) {
        this.f.h();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ApsServiceCore", "startColl");
    }
  }
  
  public final void a()
  {
    try
    {
      if (this.q != null) {
        this.q.close();
      }
    }
    catch (Throwable localThrowable1)
    {
      dg.a(localThrowable1, "ApsServiceCore", "doStopScocket 1");
    }
    try
    {
      if (this.o != null) {
        this.o.close();
      }
    }
    catch (Throwable localThrowable2)
    {
      dg.a(localThrowable2, "ApsServiceCore", "doStopScocket 2");
    }
    try
    {
      if (this.s != null) {
        this.s.interrupt();
      }
      this.s = null;
      this.o = null;
      this.p = false;
      this.r = false;
      return;
    }
    catch (Throwable localThrowable3)
    {
      for (;;) {}
    }
  }
  
  final void a(Messenger paramMessenger, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        if (paramBundle.isEmpty()) {
          return;
        }
        if (!df.n()) {
          return;
        }
        double d1 = paramBundle.getDouble("lat");
        double d2 = paramBundle.getDouble("lon");
        b(paramBundle);
        if (this.c == null) {
          break label222;
        }
        float f2 = dn.a(new double[] { d1, d2, this.c.getLatitude(), this.c.getLongitude() });
        f1 = f2;
        if (f2 < df.o() * 3)
        {
          Bundle localBundle = new Bundle();
          localBundle.setClassLoader(AMapLocation.class.getClassLoader());
          localBundle.putInt("I_MAX_GEO_DIS", df.o() * 3);
          localBundle.putInt("I_MIN_GEO_DIS", df.o());
          localBundle.putParcelable("loc", this.c);
          a(paramMessenger, 6, localBundle);
          f1 = f2;
        }
        if ((f1 == -1.0F) || (f1 > df.o()))
        {
          a(paramBundle);
          this.c = this.f.a(d1, d2);
        }
        return;
      }
      catch (Throwable paramMessenger)
      {
        dg.a(paramMessenger, "ApsServiceCore", "doLocationGeo");
      }
      return;
      label222:
      float f1 = -1.0F;
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      try
      {
        this.h.clear();
        this.h = null;
        if (this.f != null) {
          cl.b(this.e);
        }
        if (this.d != null) {
          this.d.removeCallbacksAndMessages(null);
        }
        if (this.b != null)
        {
          i1 = Build.VERSION.SDK_INT;
          if (i1 < 18) {}
        }
      }
      catch (Throwable localThrowable1)
      {
        int i1;
        b localb;
        long l1;
        long l2;
        int i2;
        dg.a(localThrowable1, "ApsServiceCore", "threadDestroy");
        return;
      }
      try
      {
        dj.a(this.b, HandlerThread.class, "quitSafely", new Object[0]);
      }
      catch (Throwable localThrowable2) {}
    }
    for (localb = this.b;; localb = this.b)
    {
      localb.quit();
      break;
    }
    this.b = null;
    this.d = null;
    if (this.A != null)
    {
      this.A.c();
      this.A = null;
    }
    a();
    this.t = false;
    this.u = false;
    this.f.e();
    dk.a(this.e);
    if ((this.i != null) && (this.j != 0L) && (this.k != 0L))
    {
      l1 = dn.b();
      l2 = this.j;
      i1 = this.i.c(this.e);
      i2 = this.i.d(this.e);
      dk.a(this.e, i1, i2, this.k, l1 - l2);
      this.i.e(this.e);
    }
    aj.b();
    if (g) {
      Process.killProcess(Process.myPid());
    }
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i;
      try
      {
        Bundle localBundle = paramMessage.getData();
        Object localObject1;
        Object localObject4;
        try
        {
          localObject1 = paramMessage.replyTo;
          localObject4 = localBundle;
          Object localObject2 = localObject1;
          if (localBundle != null)
          {
            localObject4 = localBundle;
            localObject2 = localObject1;
            try
            {
              if (localBundle.isEmpty()) {
                break label211;
              }
              localObject2 = localBundle.getString("c");
              localObject4 = f.this;
              if (TextUtils.isEmpty(((f)localObject4).l)) {
                ((f)localObject4).l = dg.b(((f)localObject4).e);
              }
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label572;
              }
              if (((String)localObject2).equals(((f)localObject4).l)) {
                break label567;
              }
            }
            catch (Throwable localThrowable2)
            {
              break label195;
            }
            localObject4 = localBundle;
            localObject2 = localObject1;
            if (i == 0)
            {
              if (paramMessage.what == 1)
              {
                dk.a(null, 2102);
                localObject2 = f.a("invalid handlder scode!!!#1002");
                localObject4 = new d();
                ((d)localObject4).e("#1002");
                ((d)localObject4).d("conitue");
                f.a(f.this, (Messenger)localObject1, (AMapLocation)localObject2, ((co)localObject2).k(), (d)localObject4);
              }
              return;
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          localObject1 = null;
        }
        try
        {
          dg.a(localThrowable4, "ApsServiceCore", "ActionHandler handlerMessage");
          localObject3 = localObject1;
          localObject4 = localBundle;
          switch (paramMessage.what)
          {
          case 12: 
            f.b(f.this, (Messenger)localObject3);
            break;
          case 11: 
            f.this.b();
            break;
          case 10: 
            f.a(f.this, (Bundle)localObject4);
            f.this.a((Messenger)localObject3, (Bundle)localObject4);
            break;
          case 9: 
            f.a(f.this, (Bundle)localObject4);
            f.a(f.this, (Messenger)localObject3);
            break;
          case 7: 
            f.a(f.this, (Bundle)localObject4);
            f.c(f.this);
            break;
          case 5: 
            f.a(f.this, (Bundle)localObject4);
            f.b(f.this);
            break;
          case 4: 
            f.a(f.this, (Bundle)localObject4);
            f.a(f.this);
            break;
          case 3: 
            if (localObject4 == null) {
              break label580;
            }
            if (((Bundle)localObject4).isEmpty()) {
              return;
            }
            f.a(f.this, null);
            f.this.a();
            break;
          case 2: 
            if (localObject4 == null) {
              return;
            }
            if (((Bundle)localObject4).isEmpty()) {
              return;
            }
            f.a(f.this, null);
            localObject1 = f.this;
            try
            {
              if (!((f)localObject1).r)
              {
                ((f)localObject1).s = new f.c((f)localObject1);
                ((f)localObject1).s.start();
                ((f)localObject1).r = true;
              }
            }
            catch (Throwable localThrowable1)
            {
              dg.a(localThrowable1, "ApsServiceCore", "startSocket");
            }
          case 1: 
            f.a(f.this, (Bundle)localObject4);
            f.b(f.this, (Messenger)localObject3, (Bundle)localObject4);
            break;
          case 0: 
            f.a(f.this, (Bundle)localObject4);
            f.a(f.this, (Messenger)localObject3, (Bundle)localObject4);
            super.handleMessage(paramMessage);
            return;
          }
        }
        catch (Throwable paramMessage)
        {
          dg.a(paramMessage, "actionHandler", "handleMessage");
          return;
        }
      }
      catch (Throwable localThrowable4)
      {
        localBundle = null;
        localObject1 = localBundle;
      }
      for (;;)
      {
        label195:
        Object localObject3;
        label211:
        label567:
        i = 1;
        break;
        label572:
        i = 0;
        break;
      }
      label580:
      return;
    }
  }
  
  final class b
    extends HandlerThread
  {
    public b(String paramString)
    {
      super();
    }
    
    protected final void onLooperPrepared()
    {
      try
      {
        f.a(f.this, new j(f.this.e));
      }
      catch (Throwable localThrowable1) {}
      try
      {
        dg.a(localThrowable1, "APSManager$ActionThread", "init 2");
        f.this.f = new cl();
        super.onLooperPrepared();
        return;
      }
      catch (Throwable localThrowable2)
      {
        dg.a(localThrowable2, "APSManager$ActionThread", "onLooperPrepared");
      }
    }
    
    public final void run()
    {
      try
      {
        super.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "APSManager$ActionThread", "run");
      }
    }
  }
  
  final class c
    extends Thread
  {
    c() {}
    
    public final void run()
    {
      try
      {
        if (!f.this.p)
        {
          f.this.p = true;
          f.this.o = new ServerSocket(43689);
        }
        while ((f.this.p) && (f.this.o != null))
        {
          f.this.q = f.this.o.accept();
          f.a(f.this, f.this.q);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "ApsServiceCore", "run");
        super.run();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */