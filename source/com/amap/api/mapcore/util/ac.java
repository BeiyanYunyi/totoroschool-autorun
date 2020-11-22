package com.amap.api.mapcore.util;

import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ac
{
  private final y a;
  private final int b;
  private int c = 30;
  private List<MultiPointItem> d;
  private List<ac> e = null;
  
  private ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(new y(paramInt1, paramInt2, paramInt3, paramInt4), paramInt5);
  }
  
  protected ac(y paramy)
  {
    this(paramy, 0);
  }
  
  private ac(y paramy, int paramInt)
  {
    this.a = paramy;
    this.b = paramInt;
    this.c = a(this.b);
  }
  
  private int a(int paramInt)
  {
    int i = 10;
    switch (paramInt)
    {
    case 6: 
    default: 
      return 5;
    case 2: 
    case 3: 
      return 20;
    case 1: 
      return 30;
    case 0: 
      i = 50;
    }
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, MultiPointItem paramMultiPointItem)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    if ((this.d.size() > this.c) && (this.b < 40))
    {
      if (this.e == null) {
        b();
      }
      if (this.e != null)
      {
        if (paramInt2 < this.a.f)
        {
          if (paramInt1 < this.a.e)
          {
            ((ac)this.e.get(0)).a(paramInt1, paramInt2, paramMultiPointItem);
            return;
          }
          ((ac)this.e.get(1)).a(paramInt1, paramInt2, paramMultiPointItem);
          return;
        }
        if (paramInt1 < this.a.e)
        {
          ((ac)this.e.get(2)).a(paramInt1, paramInt2, paramMultiPointItem);
          return;
        }
        ((ac)this.e.get(3)).a(paramInt1, paramInt2, paramMultiPointItem);
        return;
      }
      return;
    }
    this.d.add(paramMultiPointItem);
  }
  
  private void a(y paramy, Collection<MultiPointItem> paramCollection, float paramFloat, double paramDouble)
  {
    if (!this.a.a(paramy)) {
      return;
    }
    Object localObject;
    if (this.d != null)
    {
      int j = (int)(this.d.size() * paramFloat);
      int i = 0;
      while (i < j)
      {
        localObject = (MultiPointItem)this.d.get(i);
        if (paramy.a(((MultiPointItem)localObject).getIPoint())) {
          paramCollection.add(localObject);
        }
        i += 1;
      }
    }
    if (paramDouble > 0.0D)
    {
      double d1 = this.a.d;
      double d2 = this.a.b;
      Double.isNaN(d1);
      Double.isNaN(d2);
      double d3 = this.a.c;
      double d4 = this.a.a;
      Double.isNaN(d3);
      Double.isNaN(d4);
      d1 = (d1 - d2) * (d3 - d4) / paramDouble;
      if (d1 < 0.7F) {
        return;
      }
      if (d1 > 1.0D) {
        paramFloat = 1.0F;
      } else {
        paramFloat = (float)(4.8188D * d1 * d1 - d1 * 4.9339D + 1.1093D);
      }
    }
    if (this.e != null)
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ac)((Iterator)localObject).next()).a(paramy, paramCollection, paramFloat, paramDouble);
      }
    }
  }
  
  private void b()
  {
    this.e = new ArrayList(4);
    this.e.add(new ac(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.e.add(new ac(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.e.add(new ac(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.e.add(new ac(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
  }
  
  protected void a()
  {
    this.e = null;
    if (this.d != null) {
      this.d.clear();
    }
  }
  
  protected void a(y paramy, Collection<MultiPointItem> paramCollection, double paramDouble)
  {
    a(paramy, paramCollection, 1.0F, paramDouble);
  }
  
  protected void a(MultiPointItem paramMultiPointItem)
  {
    IPoint localIPoint = paramMultiPointItem.getIPoint();
    if (this.a.a(localIPoint.x, localIPoint.y)) {
      a(localIPoint.x, localIPoint.y, paramMultiPointItem);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */