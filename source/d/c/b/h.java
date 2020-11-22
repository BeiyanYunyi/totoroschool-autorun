package d.c.b;

import d.a;
import java.util.Arrays;

public class h
{
  private static <T extends Throwable> T a(T paramT)
  {
    return a(paramT, h.class.getName());
  }
  
  static <T extends Throwable> T a(T paramT, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int k = arrayOfStackTraceElement.length;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      if (paramString.equals(arrayOfStackTraceElement[i].getClassName())) {
        j = i;
      }
      i += 1;
    }
    paramT.setStackTrace((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, j + 1, k));
    return paramT;
  }
  
  public static void a()
  {
    throw ((a)a(new a()));
  }
  
  public static void a(int paramInt, String paramString) {}
  
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append(" must not be null");
    throw ((IllegalStateException)a(new IllegalStateException(((StringBuilder)paramObject).toString())));
  }
  
  public static void a(String paramString)
  {
    throw new UnsupportedOperationException(paramString);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static void b()
  {
    a("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
  }
  
  public static void b(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      b(paramString);
    }
  }
  
  private static void b(String paramString)
  {
    Object localObject = Thread.currentThread().getStackTrace()[3];
    String str = ((StackTraceElement)localObject).getClassName();
    localObject = ((StackTraceElement)localObject).getMethodName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Parameter specified as non-null is null: method ");
    localStringBuilder.append(str);
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", parameter ");
    localStringBuilder.append(paramString);
    throw ((IllegalArgumentException)a(new IllegalArgumentException(localStringBuilder.toString())));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */