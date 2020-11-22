package com.amap.api.maps.model;

import com.amap.api.mapcore.util.db;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class a
{
  private final db a;
  private final int b;
  private List<WeightedLatLng> c;
  private List<a> d = null;
  
  private a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new db(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
  }
  
  protected a(db paramdb)
  {
    this(paramdb, 0);
  }
  
  private a(db paramdb, int paramInt)
  {
    this.a = paramdb;
    this.b = paramInt;
  }
  
  private void a()
  {
    this.d = new ArrayList(4);
    this.d.add(new a(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.d.add(new a(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.d.add(new a(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.d.add(new a(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
    Object localObject = this.c;
    this.c = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)((Iterator)localObject).next();
      a(localWeightedLatLng.getPoint().x, localWeightedLatLng.getPoint().y, localWeightedLatLng);
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, WeightedLatLng paramWeightedLatLng)
  {
    if (this.d != null)
    {
      if (paramDouble2 < this.a.f)
      {
        if (paramDouble1 < this.a.e)
        {
          ((a)this.d.get(0)).a(paramDouble1, paramDouble2, paramWeightedLatLng);
          return;
        }
        ((a)this.d.get(1)).a(paramDouble1, paramDouble2, paramWeightedLatLng);
        return;
      }
      if (paramDouble1 < this.a.e)
      {
        ((a)this.d.get(2)).a(paramDouble1, paramDouble2, paramWeightedLatLng);
        return;
      }
      ((a)this.d.get(3)).a(paramDouble1, paramDouble2, paramWeightedLatLng);
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramWeightedLatLng);
    if ((this.c.size() > 50) && (this.b < 40)) {
      a();
    }
  }
  
  private void a(db paramdb, Collection<WeightedLatLng> paramCollection)
  {
    if (!this.a.a(paramdb)) {
      return;
    }
    Iterator localIterator;
    if (this.d != null)
    {
      localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(paramdb, paramCollection);
      }
    }
    if (this.c != null)
    {
      if (paramdb.b(this.a))
      {
        paramCollection.addAll(this.c);
        return;
      }
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeightedLatLng localWeightedLatLng = (WeightedLatLng)localIterator.next();
        if (paramdb.a(localWeightedLatLng.getPoint())) {
          paramCollection.add(localWeightedLatLng);
        }
      }
    }
  }
  
  protected Collection<WeightedLatLng> a(db paramdb)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramdb, localArrayList);
    return localArrayList;
  }
  
  protected void a(WeightedLatLng paramWeightedLatLng)
  {
    DPoint localDPoint = paramWeightedLatLng.getPoint();
    if (this.a.a(localDPoint.x, localDPoint.y)) {
      a(localDPoint.x, localDPoint.y, paramWeightedLatLng);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */