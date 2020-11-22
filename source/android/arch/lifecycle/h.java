package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class h
{
  private static Map<Class, Integer> a = new HashMap();
  private static Map<Class, List<Constructor<? extends b>>> b = new HashMap();
  
  @NonNull
  static GenericLifecycleObserver a(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (b((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      b[] arrayOfb = new b[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfb[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfb);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static b a(Constructor<? extends b> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (b)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
  
  @Nullable
  private static Constructor<? extends b> a(Class<?> paramClass)
  {
    try
    {
      localObject = paramClass.getPackage();
      str = paramClass.getCanonicalName();
      if (localObject == null) {
        break label138;
      }
      localObject = ((Package)localObject).getName();
    }
    catch (NoSuchMethodException paramClass)
    {
      String str;
      StringBuilder localStringBuilder;
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      for (;;)
      {
        continue;
        label138:
        Object localObject = "";
      }
    }
    if (!((String)localObject).isEmpty()) {
      str = str.substring(((String)localObject).length() + 1);
    }
    str = a(str);
    if (((String)localObject).isEmpty())
    {
      localObject = str;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
    }
    paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
    if (!paramClass.isAccessible()) {
      paramClass.setAccessible(true);
    }
    return paramClass;
  }
  
  private static int b(Class<?> paramClass)
  {
    if (a.containsKey(paramClass)) {
      return ((Integer)a.get(paramClass)).intValue();
    }
    int i = c(paramClass);
    a.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static int c(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = a(paramClass);
    if (localObject1 != null)
    {
      b.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (a.a.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (d((Class)localObject2))
    {
      if (b((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)b.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (d(localClass))
      {
        if (b(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)b.get(localClass));
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      b.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
  
  private static boolean d(Class<?> paramClass)
  {
    return (paramClass != null) && (d.class.isAssignableFrom(paramClass));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */