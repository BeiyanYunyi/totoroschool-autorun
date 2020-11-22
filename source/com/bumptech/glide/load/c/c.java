package com.bumptech.glide.load.c;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  private static final l c = new l()
  {
    public com.bumptech.glide.load.a.c a(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new NoSuchMethodError("This should never be called!");
    }
    
    public String toString()
    {
      return "NULL_MODEL_LOADER";
    }
  };
  private final Map<Class, Map<Class, m>> a = new HashMap();
  private final Map<Class, Map<Class, l>> b = new HashMap();
  private final Context d;
  
  public c(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  private <T, Y> void a(Class<T> paramClass, Class<Y> paramClass1, l<T, Y> paraml)
  {
    Map localMap = (Map)this.b.get(paramClass);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.b.put(paramClass, localObject);
    }
    ((Map)localObject).put(paramClass1, paraml);
  }
  
  private <T, Y> void b(Class<T> paramClass, Class<Y> paramClass1)
  {
    a(paramClass, paramClass1, c);
  }
  
  private <T, Y> l<T, Y> c(Class<T> paramClass, Class<Y> paramClass1)
  {
    paramClass = (Map)this.b.get(paramClass);
    if (paramClass != null) {
      return (l)paramClass.get(paramClass1);
    }
    return null;
  }
  
  private <T, Y> m<T, Y> d(Class<T> paramClass, Class<Y> paramClass1)
  {
    Object localObject1 = (Map)this.a.get(paramClass);
    if (localObject1 != null) {
      localObject1 = (m)((Map)localObject1).get(paramClass1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Iterator localIterator = this.a.keySet().iterator();
      do
      {
        do
        {
          do
          {
            localObject2 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (Class)localIterator.next();
          } while (!((Class)localObject2).isAssignableFrom(paramClass));
          localObject2 = (Map)this.a.get(localObject2);
        } while (localObject2 == null);
        localObject2 = (m)((Map)localObject2).get(paramClass1);
        localObject1 = localObject2;
      } while (localObject2 == null);
    }
    return (m<T, Y>)localObject2;
  }
  
  public <T, Y> l<T, Y> a(Class<T> paramClass, Class<Y> paramClass1)
  {
    try
    {
      l locall = c(paramClass, paramClass1);
      if (locall != null)
      {
        boolean bool = c.equals(locall);
        if (bool) {
          return null;
        }
        return locall;
      }
      m localm = d(paramClass, paramClass1);
      if (localm != null)
      {
        locall = localm.a(this.d, this);
        a(paramClass, paramClass1, locall);
        paramClass = locall;
      }
      else
      {
        b(paramClass, paramClass1);
        paramClass = locall;
      }
      return paramClass;
    }
    finally {}
  }
  
  public <T, Y> m<T, Y> a(Class<T> paramClass, Class<Y> paramClass1, m<T, Y> paramm)
  {
    try
    {
      this.b.clear();
      Map localMap = (Map)this.a.get(paramClass);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.a.put(paramClass, localObject);
      }
      paramClass1 = (m)((Map)localObject).put(paramClass1, paramm);
      paramClass = paramClass1;
      if (paramClass1 != null)
      {
        paramm = this.a.values().iterator();
        boolean bool;
        do
        {
          paramClass = paramClass1;
          if (!paramm.hasNext()) {
            break;
          }
          bool = ((Map)paramm.next()).containsValue(paramClass1);
        } while (!bool);
        paramClass = null;
      }
      return paramClass;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */