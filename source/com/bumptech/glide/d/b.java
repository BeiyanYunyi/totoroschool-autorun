package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
{
  private final Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private static a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 27	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   4: astore_0
    //   5: aload_0
    //   6: invokevirtual 31	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: instanceof 33
    //   14: ifeq +8 -> 22
    //   17: aload_1
    //   18: checkcast 33	com/bumptech/glide/d/a
    //   21: areturn
    //   22: new 35	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 38
    //   33: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 47	java/lang/RuntimeException
    //   46: dup
    //   47: aload_0
    //   48: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 54	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: astore_1
    //   56: new 35	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   63: astore_2
    //   64: aload_2
    //   65: ldc 56
    //   67: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: aload_0
    //   73: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 47	java/lang/RuntimeException
    //   80: dup
    //   81: aload_2
    //   82: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_1
    //   86: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_1
    //   91: new 35	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: ldc 56
    //   102: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: aload_0
    //   108: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 47	java/lang/RuntimeException
    //   115: dup
    //   116: aload_2
    //   117: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_1
    //   121: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore_0
    //   126: new 61	java/lang/IllegalArgumentException
    //   129: dup
    //   130: ldc 63
    //   132: aload_0
    //   133: invokespecial 64	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   9	30	1	localObject	Object
    //   55	31	1	localIllegalAccessException	IllegalAccessException
    //   90	31	1	localInstantiationException	InstantiationException
    //   63	54	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	10	55	java/lang/IllegalAccessException
    //   5	10	90	java/lang/InstantiationException
    //   0	5	125	java/lang/ClassNotFoundException
  }
  
  public List<a> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ApplicationInfo localApplicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (localApplicationInfo.metaData != null)
      {
        Iterator localIterator = localApplicationInfo.metaData.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ("GlideModule".equals(localApplicationInfo.metaData.get(str))) {
            localArrayList.add(a(str));
          }
        }
      }
      return localArrayList;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Unable to find metadata to parse GlideModules", localNameNotFoundException);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */