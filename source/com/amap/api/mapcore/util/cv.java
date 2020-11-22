package com.amap.api.mapcore.util;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class cv
{
  private Map<Integer, StyleItem> a = new ConcurrentHashMap();
  private Object b = null;
  private StyleItem[] c;
  
  public Map<Integer, StyleItem> a()
  {
    return this.a;
  }
  
  public StyleItem[] b()
  {
    if (this.a != null)
    {
      if (this.a.size() == 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        StyleItem localStyleItem = (StyleItem)localIterator.next();
        if (localStyleItem.isValid()) {
          localArrayList.add(localStyleItem);
        }
      }
      int i = localArrayList.size();
      if (i > 0)
      {
        this.c = ((StyleItem[])localArrayList.toArray(new StyleItem[i]));
        return this.c;
      }
      return null;
    }
    return null;
  }
  
  public StyleItem[] c()
  {
    return this.c;
  }
  
  public Object d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */