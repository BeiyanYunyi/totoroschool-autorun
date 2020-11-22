package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class at
{
  private static volatile at a;
  private static go b;
  private Context c;
  
  private at(Context paramContext)
  {
    this.c = paramContext;
    b = b(this.c);
  }
  
  public static at a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new at(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private List<String> a(List<aq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((aq)paramList.next()).a());
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      Object localObject = aq.a(paramString1);
      if (b.b((String)localObject, aq.class).size() > 0) {
        b.a((String)localObject, aq.class);
      }
      paramString2 = paramString2.split(";");
      localObject = new ArrayList();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject).add(new aq(paramString1, paramString2[i]));
        i += 1;
      }
      b.a((List)localObject);
    }
  }
  
  private go b(Context paramContext)
  {
    try
    {
      paramContext = new go(paramContext, as.a());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "OfflineDB", "getDB");
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private boolean b()
  {
    if (b == null) {
      b = b(this.c);
    }
    return b != null;
  }
  
  public ao a(String paramString)
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return null;
      }
      paramString = ao.e(paramString);
      paramString = b.b(paramString, ao.class);
      if (paramString.size() > 0)
      {
        paramString = (ao)paramString.get(0);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public ArrayList<ao> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!b()) {
      return localArrayList;
    }
    Iterator localIterator = b.b("", ao.class).iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ao)localIterator.next());
    }
    return localArrayList;
  }
  
  public void a(ao paramao)
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      String str = ao.f(paramao.i());
      b.a(paramao, str);
      str = paramao.b();
      a(paramao.f(), str);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (!b()) {
      return;
    }
    a(paramString, paramInt, paramLong1, new long[] { paramLong2, 0L, 0L, 0L, 0L }, new long[] { paramLong3, 0L, 0L, 0L, 0L });
  }
  
  public void a(String paramString, int paramInt, long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      paramArrayOfLong1 = new ap(paramString, paramLong, paramInt, paramArrayOfLong1[0], paramArrayOfLong2[0]);
      paramString = ap.a(paramString);
      b.a(paramArrayOfLong1, paramString);
      return;
    }
    finally {}
  }
  
  public List<String> b(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      boolean bool = b();
      if (!bool) {
        return localArrayList;
      }
      paramString = aq.a(paramString);
      localArrayList.addAll(a(b.b(paramString, aq.class)));
      return localArrayList;
    }
    finally {}
  }
  
  public void b(ao paramao)
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      b.a(ar.f(paramao.i()), ar.class);
      b.a(aq.a(paramao.f()), aq.class);
      b.a(ap.a(paramao.f()), ap.class);
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      b.a(ar.e(paramString), ar.class);
      b.a(aq.a(paramString), aq.class);
      b.a(ap.a(paramString), ap.class);
      return;
    }
    finally {}
  }
  
  public String d(String paramString)
  {
    Object localObject = null;
    try
    {
      boolean bool = b();
      if (!bool) {
        return null;
      }
      paramString = ar.f(paramString);
      List localList = b.b(paramString, ar.class);
      paramString = (String)localObject;
      if (localList.size() > 0) {
        paramString = ((ar)localList.get(0)).e();
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */