package b.a.e.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public enum l
  implements Callable<Map<Object, Object>>
{
  private l() {}
  
  public static <K, V> Callable<Map<K, V>> asCallable()
  {
    return INSTANCE;
  }
  
  public Map<Object, Object> call()
    throws Exception
  {
    return new HashMap();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */