package b.a.e.j;

import b.a.d.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public enum b
  implements h<Object, List<Object>>, Callable<List<Object>>
{
  private b() {}
  
  public static <T> Callable<List<T>> asCallable()
  {
    return INSTANCE;
  }
  
  public static <T, O> h<O, List<T>> asFunction()
  {
    return INSTANCE;
  }
  
  public List<Object> apply(Object paramObject)
    throws Exception
  {
    return new ArrayList();
  }
  
  public List<Object> call()
    throws Exception
  {
    return new ArrayList();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */