package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.HashMap;

public final class kv
{
  private HashMap<Long, kw> a = new HashMap();
  private long b = 0L;
  
  private static long a(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 & 0xFFFF | (l & 0xFFFF) << 32;
  }
  
  public final long a(kw paramkw)
  {
    long l = 0L;
    if (paramkw != null)
    {
      if (!paramkw.p) {
        return 0L;
      }
      HashMap localHashMap = this.a;
      int i;
      int j;
      switch (paramkw.k)
      {
      default: 
        l = 0L;
        break;
      case 2: 
        i = paramkw.c();
        j = paramkw.d();
        break;
      case 1: 
      case 3: 
      case 4: 
        i = paramkw.a();
        j = paramkw.b();
      }
      l = a(i, j);
      kw localkw = (kw)localHashMap.get(Long.valueOf(l));
      if (localkw == null)
      {
        paramkw.m = lj.b();
        localHashMap.put(Long.valueOf(l), paramkw);
        return 0L;
      }
      if (localkw.e() != paramkw.e())
      {
        paramkw.m = lj.b();
        localHashMap.put(Long.valueOf(l), paramkw);
        return 0L;
      }
      paramkw.m = localkw.m;
      localHashMap.put(Long.valueOf(l), paramkw);
      l = (lj.b() - localkw.m) / 1000L;
    }
    return l;
  }
  
  public final void a()
  {
    this.a.clear();
    this.b = 0L;
  }
  
  public final void a(ArrayList<? extends kw> paramArrayList)
  {
    if (paramArrayList != null)
    {
      long l3 = lj.b();
      if ((this.b > 0L) && (l3 - this.b < 60000L)) {
        return;
      }
      HashMap localHashMap = this.a;
      int n = paramArrayList.size();
      int m = 0;
      long l1 = 0L;
      int i = 0;
      kw localkw1;
      long l2;
      int j;
      int k;
      while (i < n)
      {
        localkw1 = (kw)paramArrayList.get(i);
        l2 = l1;
        if (localkw1.p)
        {
          switch (localkw1.k)
          {
          default: 
            break;
          case 2: 
            j = localkw1.h;
            k = localkw1.i;
            break;
          case 1: 
          case 3: 
          case 4: 
            j = localkw1.c;
            k = localkw1.d;
          }
          l1 = a(j, k);
          kw localkw2 = (kw)localHashMap.get(Long.valueOf(l1));
          l2 = l1;
          if (localkw2 != null) {
            if (localkw2.e() == localkw1.e())
            {
              localkw1.m = localkw2.m;
              l2 = l1;
            }
            else
            {
              localkw1.m = l3;
              l2 = l1;
            }
          }
        }
        i += 1;
        l1 = l2;
      }
      localHashMap.clear();
      n = paramArrayList.size();
      i = m;
      while (i < n)
      {
        localkw1 = (kw)paramArrayList.get(i);
        l2 = l1;
        if (localkw1.p)
        {
          switch (localkw1.k)
          {
          default: 
            break;
          case 2: 
            j = localkw1.c();
            k = localkw1.d();
            break;
          case 1: 
          case 3: 
          case 4: 
            j = localkw1.a();
            k = localkw1.b();
          }
          l1 = a(j, k);
          localHashMap.put(Long.valueOf(l1), localkw1);
          l2 = l1;
        }
        i += 1;
        l1 = l2;
      }
      this.b = l3;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */