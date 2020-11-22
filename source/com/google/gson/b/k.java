package com.google.gson.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class k
{
  public static k a()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new k()
      {
        public <T> T a(Class<T> paramAnonymousClass)
          throws Exception
        {
          b(paramAnonymousClass);
          return (T)this.a.invoke(localObject2, new Object[] { paramAnonymousClass });
        }
      };
      return (k)localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      final int i;
      label133:
      label171:
      for (;;) {}
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new k()
      {
        public <T> T a(Class<T> paramAnonymousClass)
          throws Exception
        {
          b(paramAnonymousClass);
          return (T)this.a.invoke(null, new Object[] { paramAnonymousClass, Integer.valueOf(i) });
        }
      };
      return (k)localObject1;
    }
    catch (Exception localException2)
    {
      break label133;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new k()
      {
        public <T> T a(Class<T> paramAnonymousClass)
          throws Exception
        {
          b(paramAnonymousClass);
          return (T)this.a.invoke(null, new Object[] { paramAnonymousClass, Object.class });
        }
      };
      return (k)localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    new k()
    {
      public <T> T a(Class<T> paramAnonymousClass)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot allocate ");
        localStringBuilder.append(paramAnonymousClass);
        throw new UnsupportedOperationException(localStringBuilder.toString());
      }
    };
  }
  
  static void b(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public abstract <T> T a(Class<T> paramClass)
    throws Exception;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */