package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class dk
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final AtomicInteger b = new AtomicInteger(1);
  private final String c;
  private final boolean d;
  private final ThreadGroup e;
  
  public dk()
  {
    this(localStringBuilder.toString(), false);
  }
  
  public dk(String paramString)
  {
    this(paramString, false);
  }
  
  public dk(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("-thread-");
      paramString = localStringBuilder.toString();
    }
    this.c = paramString;
    this.d = paramBoolean;
    paramString = System.getSecurityManager();
    if (paramString == null) {
      paramString = Thread.currentThread().getThreadGroup();
    } else {
      paramString = paramString.getThreadGroup();
    }
    this.e = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(this.b.getAndIncrement());
    localObject = ((StringBuilder)localObject).toString();
    paramRunnable = new Thread(this.e, paramRunnable, (String)localObject, 0L);
    paramRunnable.setDaemon(this.d);
    return paramRunnable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */