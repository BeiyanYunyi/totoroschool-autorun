package com.loc;

import java.util.ArrayList;
import java.util.HashMap;

public final class cq
{
  private HashMap<Long, cr> a = new HashMap();
  private long b = 0L;
  
  private static long a(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 & 0xFFFF | (l & 0xFFFF) << 32;
  }
  
  public final long a(cr paramcr)
  {
    long l = 0L;
    if (paramcr != null)
    {
      if (!paramcr.p) {
        return 0L;
      }
      HashMap localHashMap = this.a;
      int i;
      int j;
      switch (paramcr.k)
      {
      default: 
        l = 0L;
        break;
      case 2: 
        i = paramcr.h;
        j = paramcr.i;
        break;
      case 1: 
      case 3: 
      case 4: 
        i = paramcr.c;
        j = paramcr.d;
      }
      l = a(i, j);
      cr localcr = (cr)localHashMap.get(Long.valueOf(l));
      if (localcr == null)
      {
        paramcr.m = dn.b();
        localHashMap.put(Long.valueOf(l), paramcr);
        return 0L;
      }
      if (localcr.j != paramcr.j)
      {
        paramcr.m = dn.b();
        localHashMap.put(Long.valueOf(l), paramcr);
        return 0L;
      }
      paramcr.m = localcr.m;
      localHashMap.put(Long.valueOf(l), paramcr);
      l = (dn.b() - localcr.m) / 1000L;
    }
    return l;
  }
  
  public final void a()
  {
    this.a.clear();
    this.b = 0L;
  }
  
  public final void a(ArrayList<? extends cr> paramArrayList)
  {
    if (paramArrayList != null)
    {
      long l3 = dn.b();
      if ((this.b > 0L) && (l3 - this.b < 60000L)) {
        return;
      }
      HashMap localHashMap = this.a;
      int n = paramArrayList.size();
      int m = 0;
      long l1 = 0L;
      int i = 0;
      cr localcr1;
      long l2;
      int j;
      int k;
      while (i < n)
      {
        localcr1 = (cr)paramArrayList.get(i);
        l2 = l1;
        if (localcr1.p)
        {
          switch (localcr1.k)
          {
          default: 
            break;
          case 2: 
            j = localcr1.h;
            k = localcr1.i;
            break;
          case 1: 
          case 3: 
          case 4: 
            j = localcr1.c;
            k = localcr1.d;
          }
          l1 = a(j, k);
          cr localcr2 = (cr)localHashMap.get(Long.valueOf(l1));
          l2 = l1;
          if (localcr2 != null) {
            if (localcr2.j == localcr1.j)
            {
              localcr1.m = localcr2.m;
              l2 = l1;
            }
            else
            {
              localcr1.m = l3;
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
        localcr1 = (cr)paramArrayList.get(i);
        l2 = l1;
        if (localcr1.p)
        {
          switch (localcr1.k)
          {
          default: 
            break;
          case 2: 
            j = localcr1.h;
            k = localcr1.i;
            break;
          case 1: 
          case 3: 
          case 4: 
            j = localcr1.c;
            k = localcr1.d;
          }
          l1 = a(j, k);
          localHashMap.put(Long.valueOf(l1), localcr1);
          l2 = l1;
        }
        i += 1;
        l1 = l2;
      }
      this.b = l3;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */