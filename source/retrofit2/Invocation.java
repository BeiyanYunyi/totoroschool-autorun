package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Invocation
{
  private final List<?> arguments;
  private final Method method;
  
  Invocation(Method paramMethod, List<?> paramList)
  {
    this.method = paramMethod;
    this.arguments = Collections.unmodifiableList(paramList);
  }
  
  public static Invocation of(Method paramMethod, List<?> paramList)
  {
    Utils.checkNotNull(paramMethod, "method == null");
    Utils.checkNotNull(paramList, "arguments == null");
    return new Invocation(paramMethod, new ArrayList(paramList));
  }
  
  public List<?> arguments()
  {
    return this.arguments;
  }
  
  public Method method()
  {
    return this.method;
  }
  
  public String toString()
  {
    return String.format("%s.%s() %s", new Object[] { this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\Invocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */