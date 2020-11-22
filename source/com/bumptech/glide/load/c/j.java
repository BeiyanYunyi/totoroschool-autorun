package com.bumptech.glide.load.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements e
{
  private final Map<String, List<i>> c;
  private volatile Map<String, String> d;
  
  j(Map<String, List<i>> paramMap)
  {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  private Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      List localList = (List)localEntry.getValue();
      int i = 0;
      while (i < localList.size())
      {
        localStringBuilder.append(((i)localList.get(i)).a());
        if (i != localList.size() - 1) {
          localStringBuilder.append(',');
        }
        i += 1;
      }
      localHashMap.put(localEntry.getKey(), localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  public Map<String, String> a()
  {
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = Collections.unmodifiableMap(b());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      return this.c.equals(((j)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LazyHeaders{headers=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private static final String a = System.getProperty("http.agent");
    private static final Map<String, List<i>> b;
    private boolean c = true;
    private Map<String, List<i>> d = b;
    private boolean e = true;
    private boolean f = true;
    
    static
    {
      HashMap localHashMap = new HashMap(2);
      if (!TextUtils.isEmpty(a)) {
        localHashMap.put("User-Agent", Collections.singletonList(new j.b(a)));
      }
      localHashMap.put("Accept-Encoding", Collections.singletonList(new j.b("identity")));
      b = Collections.unmodifiableMap(localHashMap);
    }
    
    public j a()
    {
      this.c = true;
      return new j(this.d);
    }
  }
  
  static final class b
    implements i
  {
    private final String a;
    
    b(String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return this.a.equals(((b)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringHeaderFactory{value='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */