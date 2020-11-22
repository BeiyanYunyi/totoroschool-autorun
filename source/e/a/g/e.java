package e.a.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e<T>
{
  private final Class<?> a;
  private final String b;
  private final Class[] c;
  
  e(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class<?> paramClass)
  {
    String str = this.b;
    Method localMethod = null;
    if (str != null)
    {
      localMethod = a(paramClass, this.b, this.c);
      if ((localMethod != null) && (this.a != null) && (!this.a.isAssignableFrom(localMethod.getReturnType()))) {
        return null;
      }
    }
    return localMethod;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      int i;
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        try
        {
          i = paramClass.getModifiers();
          if ((i & 0x1) == 0) {
            paramClass = null;
          }
          return paramClass;
        }
        catch (NoSuchMethodException paramString) {}
        paramClass = paramClass;
      }
    }
  }
  
  public Object a(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  public boolean a(T paramT)
  {
    return a(paramT.getClass()) != null;
  }
  
  public Object b(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = a(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object c(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod != null) {
      try
      {
        paramT = localMethod.invoke(paramT, paramVarArgs);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Unexpectedly could not call: ");
        paramVarArgs.append(localMethod);
        paramVarArgs = new AssertionError(paramVarArgs.toString());
        paramVarArgs.initCause(paramT);
        throw paramVarArgs;
      }
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("Method ");
    paramVarArgs.append(this.b);
    paramVarArgs.append(" not supported for object ");
    paramVarArgs.append(paramT);
    throw new AssertionError(paramVarArgs.toString());
  }
  
  public Object d(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = c(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */