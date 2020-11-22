package android.arch.lifecycle;

import android.support.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class a
{
  static a a = new a();
  private final Map<Class, a> b = new HashMap();
  private final Map<Class, Boolean> c = new HashMap();
  
  private a a(Class paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = b((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((a)localObject1).b);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = b(localObject1[i]).b.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (b)((Map.Entry)localObject3).getKey(), (c.a)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = c(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (l)((Method)localObject1).getAnnotation(l.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(e.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((l)localObject3).a();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(c.a.class))
          {
            if (localObject3 == c.a.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          a(localHashMap, new b(i, (Method)localObject1), (c.a)localObject3, paramClass);
          bool = true;
        }
      }
      else
      {
        j += 1;
        continue;
      }
      throw new IllegalArgumentException("cannot have more than 2 params");
    }
    paramArrayOfMethod = new a(localHashMap);
    this.b.put(paramClass, paramArrayOfMethod);
    this.c.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
  
  private void a(Map<b, c.a> paramMap, b paramb, c.a parama, Class paramClass)
  {
    c.a locala = (c.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = paramb.b;
      paramb = new StringBuilder();
      paramb.append("Method ");
      paramb.append(paramMap.getName());
      paramb.append(" in ");
      paramb.append(paramClass.getName());
      paramb.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramb.append(locala);
      paramb.append(", new value ");
      paramb.append(parama);
      throw new IllegalArgumentException(paramb.toString());
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
  }
  
  private Method[] c(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  boolean a(Class paramClass)
  {
    if (this.c.containsKey(paramClass)) {
      return ((Boolean)this.c.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = c(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((l)arrayOfMethod[i].getAnnotation(l.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.c.put(paramClass, Boolean.valueOf(false));
    return false;
  }
  
  a b(Class paramClass)
  {
    a locala = (a)this.b.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  static class a
  {
    final Map<c.a, List<a.b>> a;
    final Map<a.b, c.a> b;
    
    a(Map<a.b, c.a> paramMap)
    {
      this.b = paramMap;
      this.a = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        c.a locala = (c.a)localEntry.getValue();
        List localList = (List)this.a.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.a.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
    
    private static void a(List<a.b> paramList, e parame, c.a parama, Object paramObject)
    {
      if (paramList != null)
      {
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          ((a.b)paramList.get(i)).a(parame, parama, paramObject);
          i -= 1;
        }
      }
    }
    
    void a(e parame, c.a parama, Object paramObject)
    {
      a((List)this.a.get(parama), parame, parama, paramObject);
      a((List)this.a.get(c.a.ON_ANY), parame, parama, paramObject);
    }
  }
  
  static class b
  {
    final int a;
    final Method b;
    
    b(int paramInt, Method paramMethod)
    {
      this.a = paramInt;
      this.b = paramMethod;
      this.b.setAccessible(true);
    }
    
    void a(e parame, c.a parama, Object paramObject)
    {
      try
      {
        switch (this.a)
        {
        case 2: 
          this.b.invoke(paramObject, new Object[] { parame, parama });
          return;
        }
      }
      catch (IllegalAccessException parame)
      {
        throw new RuntimeException(parame);
      }
      catch (InvocationTargetException parame)
      {
        throw new RuntimeException("Failed to call observer method", parame.getCause());
      }
      this.b.invoke(paramObject, new Object[] { parame });
      return;
      this.b.invoke(paramObject, new Object[0]);
      return;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (b)paramObject;
        return (this.a == ((b)paramObject).a) && (this.b.getName().equals(((b)paramObject).b.getName()));
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a * 31 + this.b.getName().hashCode();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */