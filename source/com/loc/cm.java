package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cm
{
  public boolean a = false;
  private String b = null;
  private Context c = null;
  private boolean d = true;
  private ServiceConnection e = null;
  private Intent f = new Intent();
  private String g = "com.autonavi.minimap";
  private String h = "com.amap.api.service.AMapService";
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private List<Intent> o = new ArrayList();
  private boolean p = false;
  
  public cm(Context paramContext)
  {
    this.c = paramContext;
    try
    {
      this.b = q.b(cv.a(l.f(paramContext).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "ConnectionServiceManager", "ConnectionServiceManager");
    }
  }
  
  public final void a()
  {
    try
    {
      if ((this.e != null) && (this.l)) {
        this.c.unbindService(this.e);
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ConnectionServiceManager", "unbindService connService");
    }
    if ((this.o != null) && (this.o.size() > 0))
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        Intent localIntent = (Intent)localIterator.next();
        this.c.stopService(localIntent);
      }
    }
    this.c = null;
    this.e = null;
    this.d = true;
    this.a = false;
    this.i = false;
    this.j = false;
    this.k = false;
    this.p = false;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o.clear();
    this.o = null;
  }
  
  public final void b()
  {
    try
    {
      if (this.e == null) {
        this.e = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            cm.this.a = true;
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            cm.this.a = false;
          }
        };
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ConnectionServiceManager", "init");
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/loc/cm:p	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 40	com/loc/cm:c	Landroid/content/Context;
    //   12: invokestatic 156	com/loc/df:b	(Landroid/content/Context;)Z
    //   15: ifeq +162 -> 177
    //   18: aload_0
    //   19: getfield 51	com/loc/cm:f	Landroid/content/Intent;
    //   22: ldc -98
    //   24: aload_0
    //   25: getfield 38	com/loc/cm:b	Ljava/lang/String;
    //   28: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   31: pop
    //   32: aload_0
    //   33: getfield 51	com/loc/cm:f	Landroid/content/Intent;
    //   36: new 164	android/content/ComponentName
    //   39: dup
    //   40: aload_0
    //   41: getfield 55	com/loc/cm:g	Ljava/lang/String;
    //   44: aload_0
    //   45: getfield 59	com/loc/cm:h	Ljava/lang/String;
    //   48: invokespecial 167	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokevirtual 171	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 40	com/loc/cm:c	Landroid/content/Context;
    //   60: aload_0
    //   61: getfield 51	com/loc/cm:f	Landroid/content/Intent;
    //   64: aload_0
    //   65: getfield 46	com/loc/cm:e	Landroid/content/ServiceConnection;
    //   68: iconst_1
    //   69: invokevirtual 175	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   72: putfield 61	com/loc/cm:i	Z
    //   75: aload_0
    //   76: getfield 61	com/loc/cm:i	Z
    //   79: ifne +93 -> 172
    //   82: invokestatic 178	com/loc/df:f	()Ljava/util/ArrayList;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +85 -> 172
    //   90: aload_1
    //   91: invokevirtual 179	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   94: astore_1
    //   95: aload_1
    //   96: invokeinterface 135 1 0
    //   101: ifeq +71 -> 172
    //   104: aload_1
    //   105: invokeinterface 139 1 0
    //   110: checkcast 87	java/lang/String
    //   113: astore_2
    //   114: aload_2
    //   115: aload_0
    //   116: getfield 59	com/loc/cm:h	Ljava/lang/String;
    //   119: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne -27 -> 95
    //   125: aload_0
    //   126: getfield 51	com/loc/cm:f	Landroid/content/Intent;
    //   129: new 164	android/content/ComponentName
    //   132: dup
    //   133: aload_0
    //   134: getfield 55	com/loc/cm:g	Ljava/lang/String;
    //   137: aload_2
    //   138: invokespecial 167	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: invokevirtual 171	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   144: pop
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 40	com/loc/cm:c	Landroid/content/Context;
    //   150: aload_0
    //   151: getfield 51	com/loc/cm:f	Landroid/content/Intent;
    //   154: aload_0
    //   155: getfield 46	com/loc/cm:e	Landroid/content/ServiceConnection;
    //   158: iconst_1
    //   159: invokevirtual 175	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   162: putfield 61	com/loc/cm:i	Z
    //   165: aload_0
    //   166: getfield 61	com/loc/cm:i	Z
    //   169: ifeq -74 -> 95
    //   172: aload_0
    //   173: iconst_1
    //   174: putfield 67	com/loc/cm:l	Z
    //   177: aload_0
    //   178: iconst_1
    //   179: putfield 78	com/loc/cm:p	Z
    //   182: return
    //   183: astore_1
    //   184: goto -7 -> 177
    //   187: astore_1
    //   188: goto -113 -> 75
    //   191: astore_2
    //   192: goto -27 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	cm
    //   85	20	1	localObject	Object
    //   183	1	1	localThrowable1	Throwable
    //   187	1	1	localThrowable2	Throwable
    //   113	25	2	str	String
    //   191	1	2	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	55	183	java/lang/Throwable
    //   75	86	183	java/lang/Throwable
    //   90	95	183	java/lang/Throwable
    //   95	145	183	java/lang/Throwable
    //   165	172	183	java/lang/Throwable
    //   172	177	183	java/lang/Throwable
    //   55	75	187	java/lang/Throwable
    //   145	165	191	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */