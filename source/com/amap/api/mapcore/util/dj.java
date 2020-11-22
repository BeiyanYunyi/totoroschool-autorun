package com.amap.api.mapcore.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class dj<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public dj(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b >= 0) && (this.a.isEmpty())) {
          int i = this.b;
        }
        if (this.b <= paramInt) {
          return;
        }
        Object localObject3 = this.a.entrySet().iterator();
        for (Object localObject1 = null; ((Iterator)localObject3).hasNext(); localObject1 = (Map.Entry)((Iterator)localObject3).next()) {}
        if (localObject1 == null) {
          return;
        }
        localObject3 = ((Map.Entry)localObject1).getKey();
        localObject1 = ((Map.Entry)localObject1).getValue();
        this.a.remove(localObject3);
        this.b -= c(localObject3, localObject1);
        this.f += 1;
        a(true, localObject3, localObject1, null);
      }
      finally {}
    }
  }
  
  private int c(K paramK, V paramV)
  {
    int i = b(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final V a(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject1 = this.a.get(paramK);
        if (localObject1 != null)
        {
          this.g += 1;
          return (V)localObject1;
        }
        this.h += 1;
        localObject1 = b(paramK);
        if (localObject1 == null) {
          return null;
        }
        try
        {
          this.e += 1;
          Object localObject2 = this.a.put(paramK, localObject1);
          if (localObject2 != null) {
            this.a.put(paramK, localObject2);
          } else {
            this.b += c(paramK, localObject1);
          }
          if (localObject2 != null)
          {
            a(false, paramK, localObject1, localObject2);
            return (V)localObject2;
          }
          a(this.c);
          return (V)localObject1;
        }
        finally {}
        throw new NullPointerException("key == null");
      }
      finally {}
    }
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.b += c(paramK, paramV);
        Object localObject = this.a.put(paramK, paramV);
        if (localObject != null) {
          this.b -= c(paramK, localObject);
        }
        if (localObject != null) {
          a(false, paramK, localObject, paramV);
        }
        a(this.c);
        return (V)localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final void a()
  {
    a(-1);
  }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  protected int b(K paramK, V paramV)
  {
    return 1;
  }
  
  protected V b(K paramK)
  {
    return null;
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.g + this.h;
        if (i != 0)
        {
          i = this.g * 100 / i;
          String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */